package ast.instrucciones;

import ast.Expresion;
import ast.Instruccion;
import ast.ResultadoC3D;
import cuartetas.AccesoTemporal;
import cuartetas.Literal3D;
import cuartetas.OperacionBinaria3D;
import cuartetas.SetStack3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.Simbolo;
import semantico.TablaSimbolos;
import semantico.TipoDato;
import semantico.ValidadorTipos;

public class Declaracion extends Instruccion {
    public String idVariable;
    public TipoDato tipo;
    public String tipoObjeto; // Se usa si el tipo es OBJETO (ej. "Cuenta")
    public Expresion valor;
    public boolean esArreglo;

    // Constructor básico para primitivos
    public Declaracion(String idVariable, TipoDato tipo, Expresion valor, int linea, int columna) {
        super(linea, columna);
        this.idVariable = idVariable;
        this.tipo = tipo;
        this.valor = valor;
        this.esArreglo = false;
    }

    // Constructor sobrecargado para objetos
    public Declaracion(String idVariable, TipoDato tipo, String tipoObjeto, Expresion valor, int linea, int columna) {
        super(linea, columna);
        this.idVariable = idVariable;
        this.tipo = tipo;
        this.tipoObjeto = tipoObjeto;
        this.valor = valor;
        this.esArreglo = false;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        // Evitar redeclaracion en el mismo ambito (Scope local)
        if (entorno.tabla.containsKey(idVariable)) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO,
                    "La variable '" + idVariable + "' ya ha sido declarada en el bloque actual.",
                    linea, columna
            );
            return null;
        }

        // Registrar en la Tabla de Simbolos y obtener el desplazamiento (offset) en el Stack
        String tipoString = (tipo == TipoDato.OBJETO && tipoObjeto != null) ? tipoObjeto : tipo.toString();
        Simbolo simNuevaVariable = new Simbolo(idVariable, tipoString, "Variable");

        // entorno.insertar asume la responsabilidad de aumentar el offset (entorno.offset++)
        entorno.insertar(simNuevaVariable);

        // Calcular la direccion fisica: t_pos = P + offset de la variable
        AccesoTemporal t_posicion = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_posicion, new cuartetas.PunteroGlobal3D("P"), "+", new Literal3D(String.valueOf(simNuevaVariable.direccionMemoria))
        ));

        // Evaluar expresion si la variable se inicializa
        if (valor != null) {
            ResultadoC3D resValor = (ResultadoC3D) valor.generar(entorno);

            if (resValor != null && resValor.tipo != TipoDato.ERROR) {

                // Validacion Semantica de Tipos
                boolean esValida = ValidadorTipos.validarAsignacion(this.tipo, resValor.tipo);
                if (!esValida) {
                    GestorErrores.getInstancia().agregarError(
                            TipoError.SEMANTICO,
                            "Incompatibilidad de tipos: No se puede inicializar un '" + this.tipo + "' con un valor '" + resValor.tipo + "'.",
                            linea, columna
                    );
                    return null;
                }

                // Validación de Herencia (Upcasting) para Objetos
                if (this.tipo == TipoDato.OBJETO && resValor.tipo == TipoDato.OBJETO) {
                    if (this.tipoObjeto != null && resValor.tipoStringOriginal != null) {
                        boolean esCompatible = false;
                        String claseActual = resValor.tipoStringOriginal;

                        while (claseActual != null && !claseActual.isEmpty()) {
                            if (claseActual.equals(this.tipoObjeto)) {
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
                                    "Incompatibilidad de clases: No se puede inicializar la variable '" + this.tipoObjeto + "' con un objeto '" + resValor.tipoStringOriginal + "'.",
                                    linea, columna
                            );
                            return null;
                        }
                    }
                }

                // Guardar valor inicial en el Stack (Stack[(int) t_posicion] = valorC3D)
                gen.agregarCuarteta(new SetStack3D(t_posicion, resValor.valorC3D));
            }
        } else {
            // Si no hay inicialización explícita, inyectar un 0/null por defecto
            gen.agregarCuarteta(new SetStack3D(t_posicion, new Literal3D("0")));
        }

        return null;
    }
}