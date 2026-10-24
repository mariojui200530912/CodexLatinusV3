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

        String L_Condicion = gen.generarEtiqueta();
        String L_Verdadero = gen.generarEtiqueta();
        String L_Falso = gen.generarEtiqueta();

        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Condicion));

        ResultadoC3D resCondicion = (ResultadoC3D) condicion.generar(entorno);
        if (resCondicion != null && resCondicion.tipo != TipoDato.BOOLEANO && resCondicion.tipo != TipoDato.ERROR) {
            GestorErrores.getInstancia().agregarError(TipoError.SEMANTICO, "La condición del ciclo debe ser booleana", linea, columna);
        }

        gen.agregarCuarteta(new Condicional3D(resCondicion.valorC3D, new Literal3D("1"), "==", L_Verdadero));
        gen.agregarCuarteta(new Goto3D(L_Falso));

        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Verdadero));

        TablaSimbolos entornoMientras = new TablaSimbolos(entorno, "Ciclo_Mientras");
        entornoMientras.esCiclo = true;

        gen.etiquetasBreak.push(L_Falso);
        gen.etiquetasContinue.push(L_Condicion);

        if (bloque != null) {
            for (Instruccion inst : bloque) {
                if (inst != null) inst.generar(entornoMientras);
            }
        }

        gen.etiquetasBreak.pop();
        gen.etiquetasContinue.pop();

        gen.agregarCuarteta(new Goto3D(L_Condicion));
        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Falso));

        return null;
    }
}