package ast.instrucciones;

import ast.Expresion;
import ast.Instruccion;
import ast.ResultadoC3D;
import cuartetas.PunteroGlobal3D;
import cuartetas.Return3D;
import cuartetas.SetStack3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.Simbolo;
import semantico.TablaSimbolos;
import semantico.TipoDato;
import semantico.ValidadorTipos;

public class NodoRetornar extends Instruccion {
    public Expresion expresion;

    public NodoRetornar(Expresion expresion, int linea, int columna) {
        super(linea, columna);
        this.expresion = expresion;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        // Buscar la firma de retorno en el entorno (inyectado por DefinicionMetodo/Funcion)
        Simbolo simRetorno = entorno.buscar("$retorno");

        if (simRetorno == null) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO,
                    "La instrucción 'retornar' solo puede usarse dentro del bloque de una función o método.",
                    linea, columna
            );
            return null;
        }

        TipoDato tipoEsperado = ValidadorTipos.parsearTipo(simRetorno.tipo);
        String tipoObjetoEsperado = simRetorno.tipo;

        // Caso A: Retorno vacío (return;)
        if (expresion == null) {
            if (tipoEsperado != TipoDato.VOID) {
                GestorErrores.getInstancia().agregarError(
                        TipoError.SEMANTICO,
                        "La función/método debe retornar un valor de tipo '" + tipoObjetoEsperado + "', pero se encontró un retorno vacío.",
                        linea, columna
                );
            } else {
                // Emitir salto de retorno de forma estructurada mediante Cuarteta
                gen.agregarCuarteta(new Return3D());
            }
            return null;
        }

        // Caso B: Retorno con valor (return expr;)
        if (tipoEsperado == TipoDato.VOID) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO,
                    "Una función/método de tipo 'void' no puede retornar un valor.",
                    linea, columna
            );
            return null;
        }

        // Evaluar la expresión a retornar
        ResultadoC3D resValor = (ResultadoC3D) expresion.generar(entorno);

        if (resValor == null || resValor.tipo == TipoDato.ERROR) {
            return null;
        }

        // VALIDACION SEMANTICA
        boolean esValido = ValidadorTipos.validarAsignacion(tipoEsperado, resValor.tipo);

        if (!esValido) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO,
                    "Incompatibilidad de tipos en el retorno: Se esperaba '" + tipoObjetoEsperado + "' pero se retornó '" + resValor.tipo + "'.",
                    linea, columna
            );
            return null;
        }

        // Validacion de Herencia (Polimorfismo / Upcasting)
        if (tipoEsperado == TipoDato.OBJETO && resValor.tipo == TipoDato.OBJETO) {
            if (resValor.tipoStringOriginal != null) {
                boolean esCompatible = false;
                String claseActual = resValor.tipoStringOriginal;

                while (claseActual != null && !claseActual.isEmpty()) {
                    if (claseActual.equals(tipoObjetoEsperado)) {
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
                            "Incompatibilidad de clases: No se puede retornar un objeto de clase '" + resValor.tipoStringOriginal + "' donde se espera '" + tipoObjetoEsperado + "'.",
                            linea, columna
                    );
                    return null;
                }
            }
        }

        // GENERACION C3D
        // Guardar el valor de retorno en la posición 0 del Stack actual: Stack[(int) P] = valor
        gen.agregarCuarteta(new SetStack3D(new PunteroGlobal3D("P"), resValor.valorC3D));

        // Emitir el retorno (el equivalente a 'ret' o 'jr ra' en ensamblador)
        gen.agregarCuarteta(new Return3D());

        return null;
    }
}