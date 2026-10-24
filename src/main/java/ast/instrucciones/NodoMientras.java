package ast.instrucciones;

import ast.Expresion;
import ast.Instruccion;
import ast.ResultadoC3D;
import cuartetas.Condicional3D;
import cuartetas.DefinicionEtiqueta3D;
import cuartetas.Goto3D;
import cuartetas.Literal3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.TablaSimbolos;
import semantico.TipoDato;

import java.util.List;

public class NodoMientras extends Instruccion {
    public Expresion condicion;
    public List<Instruccion> bloque;

    public NodoMientras(Expresion condicion, List<Instruccion> bloque, int linea, int columna) {
        super(linea, columna);
        this.condicion = condicion;
        this.bloque = bloque;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        // Crear etiquetas de control
        String L_Inicio = gen.generarEtiqueta();
        String L_Verdadero = gen.generarEtiqueta();
        String L_Falso = gen.generarEtiqueta();

        // Definir la etiqueta de retorno para la reevaluación del ciclo
        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Inicio));

        // Evaluar la expresión condicional
        ResultadoC3D resCondicion = (ResultadoC3D) condicion.generar(entorno);

        if (resCondicion == null || resCondicion.tipo == TipoDato.ERROR) {
            return null; // El error ya fue reportado en los nodos hijos
        }

        // Validación Semántica: Garantizar que la condición sea BOOLEANA
        if (resCondicion.tipo != TipoDato.BOOLEANO) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO,
                    "La condición del ciclo 'mientras' debe ser de tipo BOOLEANO. Se encontró: " + resCondicion.tipo,
                    linea, columna
            );
            return null;
        }

        // Salto Condicional (Evaluación de entrada al ciclo)
        gen.agregarCuarteta(new Condicional3D(resCondicion.valorC3D, new Literal3D("1"), "==", L_Verdadero));
        gen.agregarCuarteta(new Goto3D(L_Falso));

        // --- BLOQUE VERDADERO (Cuerpo del Ciclo) ---
        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Verdadero));

        // Inyectar etiquetas en las pilas para soportar 'break' y 'continue'
        // - break: salta a L_Falso
        // - continue: salta a L_Inicio
        gen.etiquetasBreak.push(L_Falso);
        gen.etiquetasContinue.push(L_Inicio);

        // Crear un sub-ámbito para encapsular las variables declaradas dentro del ciclo
        TablaSimbolos entornoMientras = new TablaSimbolos(entorno, "Mientras");
        entornoMientras.esCiclo = true;

        if (bloque != null) {
            for (Instruccion inst : bloque) {
                if (inst != null) inst.generar(entornoMientras);
            }
        }

        // Retirar las etiquetas de las pilas al salir del contexto del ciclo
        gen.etiquetasBreak.pop();
        gen.etiquetasContinue.pop();

        // Bucle: regresar incondicionalmente al inicio para evaluar de nuevo
        gen.agregarCuarteta(new Goto3D(L_Inicio));

        // --- ETIQUETA DE SALIDA ---
        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Falso));

        return null;
    }
}