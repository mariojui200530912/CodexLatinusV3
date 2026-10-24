package ast.instrucciones;

import ast.Expresion;
import ast.Instruccion;
import ast.ResultadoC3D;
import ast.expresiones.AccesoPropiedad;
import ast.expresiones.AccesoVariable;
import ast.expresiones.AccesoArreglo;
import cuartetas.SetHeap3D;
import cuartetas.SetStack3D;
import generador.GeneradorC3D;
import semantico.Simbolo;
import semantico.TablaSimbolos;
import semantico.TipoDato;

public class Asignacion extends Instruccion {
    public Expresion destino; // AccesoVariable, AccesoPropiedad o AccesoArreglo
    public Expresion valor;

    public Asignacion(Expresion destino, Expresion valor, int linea, int columna) {
        super(linea, columna);
        this.destino = destino;
        this.valor = valor;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        // Indicar al nodo destino que devolvera una dirección de memoria (L-Value), no el valor
        if (destino instanceof AccesoVariable) {
            ((AccesoVariable) destino).esDestino = true;
        } else if (destino instanceof AccesoPropiedad) {
            ((AccesoPropiedad) destino).esDestino = true;
        } else if (destino instanceof AccesoArreglo) {
            ((AccesoArreglo) destino).esDestino = true;
        } else {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "El lado izquierdo de la asignación no es una variable, propiedad o arreglo válido.", linea, columna
            );
            return null;
        }

        // Evaluar el destino (direccion) y el valor (resultado)
        ResultadoC3D resDestino = (ResultadoC3D) destino.generar(entorno);
        ResultadoC3D resValor = (ResultadoC3D) valor.generar(entorno);

        if (resDestino == null || resValor == null || resDestino.tipo == TipoDato.ERROR || resValor.tipo == TipoDato.ERROR) {
            return null; // Error semántico ya reportado
        }

        boolean esAsignacionValida = ValidadorTipos.validarAsignacion(resDestino.tipo, resValor.tipo);

        if (!esAsignacionValida) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO,
                    "Incompatibilidad de tipos en asignación: No se puede asignar un valor '" + resValor.tipo + "' a un destino '" + resDestino.tipo + "'.",
                    linea, columna
            );
            return null;
        }

        // Validación extra para Objetos (Polimorfismo / Igualdad de Clases)
        if (resDestino.tipo == TipoDato.OBJETO && resValor.tipo == TipoDato.OBJETO) {
            if (resDestino.tipoStringOriginal != null && resValor.tipoStringOriginal != null) {

                boolean esCompatible = false;
                String claseActual = resValor.tipoStringOriginal; // Empezamos por la clase hija

                // Subimos por el arbol de herencia hasta encontrar la clase destino o llegar al final
                while (claseActual != null && !claseActual.isEmpty()) {
                    if (claseActual.equals(resDestino.tipoStringOriginal)) {
                        esCompatible = true;
                        break;
                    }

                    Simbolo simClaseActual = entorno.buscar(claseActual);
                    if (simClaseActual != null && "Clase".equals(simClaseActual.categoria)) {
                        claseActual = simClaseActual.clasePadre; // Avanzar hacia el padre
                    } else {
                        break;
                    }
                }

                if (!esCompatible) {
                    GestorErrores.getInstancia().agregarError(
                            TipoError.SEMANTICO,
                            "Incompatibilidad de clases: No se puede asignar un objeto de clase '" + resValor.tipoStringOriginal + "' a una referencia de tipo '" + resDestino.tipoStringOriginal + "'. No hay relación de herencia.",
                            linea, columna
                    );
                    return null;
                }
            }
        }

        // GENERACION DE CODIGO INTERMEDIO (C3D)
        if (destino instanceof AccesoVariable) {
            // Guardar en el Stack (Variables locales, apuntadas por el Puntero P)
            // Stack[(int) t_direccion] = t_valor;
            gen.agregarCuarteta(new SetStack3D(resDestino.valorC3D, resValor.valorC3D));
        } else {
            // Guardar en el Heap (Atributos de Objetos y Elementos de Arreglos, apuntados por el Puntero H)
            // Heap[(int) t_direccion] = t_valor;
            gen.agregarCuarteta(new SetHeap3D(resDestino.valorC3D, resValor.valorC3D));
        }

        return null;
    }
}