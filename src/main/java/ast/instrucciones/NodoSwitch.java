package ast.instrucciones;

import ast.Expresion;
import ast.Instruccion;
import ast.ResultadoC3D;
import cuartetas.Condicional3D;
import cuartetas.DefinicionEtiqueta3D;
import cuartetas.Goto3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.TablaSimbolos;
import semantico.TipoDato;

import java.util.List;

public class NodoSwitch extends Instruccion {
    public Expresion expresionPrincipal;
    public List<NodoCaso> casos;
    public List<Instruccion> bloqueDefault;

    public NodoSwitch(Expresion expresionPrincipal, List<NodoCaso> casos, List<Instruccion> bloqueDefault, int linea, int columna) {
        super(linea, columna);
        this.expresionPrincipal = expresionPrincipal;
        this.casos = casos;
        this.bloqueDefault = bloqueDefault;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        // Evaluar la expresión principal a comparar
        ResultadoC3D resPrincipal = (ResultadoC3D) expresionPrincipal.generar(entorno);
        if (resPrincipal == null || resPrincipal.tipo == TipoDato.ERROR) {
            return null; // Error previo propagado
        }

        // Preparar etiquetas globales del Switch
        String L_Salida = gen.generarEtiqueta();
        String L_Default = (bloqueDefault != null && !bloqueDefault.isEmpty()) ? gen.generarEtiqueta() : L_Salida;

        // Inyectamos la etiqueta de salida para que los 'break' internos la encuentren
        gen.etiquetasBreak.push(L_Salida);

        // Pre-generar etiquetas para cada bloque de caso
        if (casos != null) {
            for (NodoCaso caso : casos) {
                caso.etiquetaBloque = gen.generarEtiqueta();
            }
        }

        // FASE DE ENRUTAMIENTO (Evaluación de condiciones)
        if (casos != null) {
            for (NodoCaso caso : casos) {
                ResultadoC3D resCaso = (ResultadoC3D) caso.expresion.generar(entorno);

                if (resCaso != null && resCaso.tipo != TipoDato.ERROR) {
                    // Validación semántica básica: los tipos deben ser compatibles para igualdad
                    if (resPrincipal.tipo != resCaso.tipo) {
                        GestorErrores.getInstancia().agregarError(
                                TipoError.SEMANTICO,
                                "Incompatibilidad en Switch: No se puede comparar '" + resPrincipal.tipo + "' con '" + resCaso.tipo + "'.",
                                caso.linea, caso.columna
                        );
                        continue;
                    }

                    // Cuarteta: if (expresionPrincipal == expresionCaso) goto L_BloqueCaso
                    gen.agregarCuarteta(new Condicional3D(resPrincipal.valorC3D, resCaso.valorC3D, "==", caso.etiquetaBloque));
                }
            }
        }

        // Si ninguna condición anterior se cumple, saltar al Default (o a la Salida si no hay Default)
        gen.agregarCuarteta(new Goto3D(L_Default));

        // FASE DE EJECUCION
        if (casos != null) {
            for (NodoCaso caso : casos) {
                gen.agregarCuarteta(new DefinicionEtiqueta3D(caso.etiquetaBloque));

                TablaSimbolos entornoCaso = new TablaSimbolos(entorno, "Switch_Caso");
                if (caso.instrucciones != null) {
                    for (Instruccion inst : caso.instrucciones) {
                        if (inst != null) inst.generar(entornoCaso);
                    }
                }
            }
        }

        // Generar bloque Default
        if (bloqueDefault != null && !bloqueDefault.isEmpty()) {
            gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Default));
            TablaSimbolos entornoDefault = new TablaSimbolos(entorno, "Switch_Default");
            for (Instruccion inst : bloqueDefault) {
                if (inst != null) inst.generar(entornoDefault);
            }
        }

        // Finalizar la estructura
        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Salida));

        // Retiramos la etiqueta de la pila al abandonar el ámbito del Switch
        gen.etiquetasBreak.pop();

        return null;
    }
}