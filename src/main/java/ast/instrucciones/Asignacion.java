package ast.instrucciones;

import ast.Expresion;
import ast.Instruccion;
import ast.ResultadoC3D;
import ast.expresiones.AccesoPropiedad;
import ast.expresiones.AccesoVariable;
import ast.expresiones.AccesoArreglo;
import cuartetas.SetHeap3D;
import cuartetas.SetStack3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.Simbolo;
import semantico.TablaSimbolos;
import semantico.TipoDato;
import semantico.ValidadorTipos;

public class Asignacion extends Instruccion {
    public Expresion destino;
    public Expresion valor;

    public Asignacion(Expresion destino, Expresion valor, int linea, int columna) {
        super(linea, columna);
        this.destino = destino;
        this.valor = valor;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        if (destino instanceof AccesoVariable) {
            ((AccesoVariable) destino).esDestino = true;
        } else if (destino instanceof AccesoPropiedad) {
            ((AccesoPropiedad) destino).esDestino = true;
        } else if (destino instanceof AccesoArreglo) {
            ((AccesoArreglo) destino).esDestino = true;
        } else {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "El lado izquierdo no es un destino válido.", linea, columna
            );
            return null;
        }

        ResultadoC3D resDestino = (ResultadoC3D) destino.generar(entorno);
        ResultadoC3D resValor = (ResultadoC3D) valor.generar(entorno);

        if (resDestino == null || resValor == null || resDestino.tipo == TipoDato.ERROR || resValor.tipo == TipoDato.ERROR) {
            return null;
        }

        if (!ValidadorTipos.validarAsignacion(resDestino.tipo, resValor.tipo)) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO,
                    "Incompatibilidad de tipos en asignación: No se puede asignar '" + resValor.tipo + "' a '" + resDestino.tipo + "'.",
                    linea, columna
            );
            return null;
        }

        if (resDestino.tipo == TipoDato.OBJETO && resValor.tipo == TipoDato.OBJETO) {
            if (resDestino.tipoStringOriginal != null && resValor.tipoStringOriginal != null) {
                boolean esCompatible = false;
                String claseActual = resValor.tipoStringOriginal;

                while (claseActual != null && !claseActual.isEmpty()) {
                    if (claseActual.equals(resDestino.tipoStringOriginal)) {
                        esCompatible = true;
                        break;
                    }

                    Simbolo simClaseActual = entorno.buscar(claseActual);
                    if (simClaseActual != null && "Clase".equals(simClaseActual.categoria)) {
                        claseActual = simClaseActual.clasePadre;
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

        if (destino instanceof AccesoPropiedad || destino instanceof AccesoArreglo) {
            gen.agregarCuarteta(new SetHeap3D(resDestino.valorC3D, resValor.valorC3D));
        } else if (destino instanceof AccesoVariable) {
            String idVar = ((AccesoVariable) destino).id;
            Simbolo sim = entorno.buscar(idVar);

            boolean esAtributo = sim != null && "Atributo".equals(sim.categoria);

            if (!esAtributo) {
                TablaSimbolos temp = entorno;
                while (temp != null) {
                    if (temp.tabla.containsKey(idVar) && temp.nombreEntorno.startsWith("Clase_")) {
                        esAtributo = true;
                        break;
                    }
                    temp = temp.padre;
                }
            }

            if (esAtributo) {
                gen.agregarCuarteta(new SetHeap3D(resDestino.valorC3D, resValor.valorC3D));
            } else {
                gen.agregarCuarteta(new SetStack3D(resDestino.valorC3D, resValor.valorC3D));
            }
        }

        return null;
    }
}