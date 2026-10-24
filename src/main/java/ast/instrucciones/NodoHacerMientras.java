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

public class NodoHacerMientras extends Instruccion {
    public List<Instruccion> bloque;
    public Expresion condicion;

    public NodoHacerMientras(List<Instruccion> bloque, Expresion condicion, int linea, int columna) {
        super(linea, columna);
        this.bloque = bloque;
        this.condicion = condicion;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        String L_Inicio = gen.generarEtiqueta();
        String L_Condicion = gen.generarEtiqueta();
        String L_Verdadero = gen.generarEtiqueta();
        String L_Falso = gen.generarEtiqueta();

        // Etiqueta de inicio del ciclo
        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Inicio));

        TablaSimbolos entornoCiclo = new TablaSimbolos(entorno, "Ciclo_Hacer_Mientras");
        entornoCiclo.esCiclo = true;

        gen.etiquetasBreak.push(L_Falso);
        gen.etiquetasContinue.push(L_Condicion);

        // Ejecutar el bloque primero
        if (bloque != null) {
            for (Instruccion inst : bloque) {
                if (inst != null) inst.generar(entornoCiclo);
            }
        }

        gen.etiquetasBreak.pop();
        gen.etiquetasContinue.pop();

        // Etiqueta de evaluacion
        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Condicion));

        ResultadoC3D resCondicion = (ResultadoC3D) condicion.generar(entornoCiclo);
        if (resCondicion != null && resCondicion.tipo != TipoDato.BOOLEANO && resCondicion.tipo != TipoDato.ERROR) {
            GestorErrores.getInstancia().agregarError(TipoError.SEMANTICO, "La condición del ciclo hacer-mientras debe ser booleana", linea, columna);
        }

        // Salto condicional de regreso al inicio
        gen.agregarCuarteta(new Condicional3D(resCondicion.valorC3D, new Literal3D("1"), "==", L_Inicio));
        gen.agregarCuarteta(new Goto3D(L_Falso));

        // Etiqueta de salida
        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Falso));

        return null;
    }
}