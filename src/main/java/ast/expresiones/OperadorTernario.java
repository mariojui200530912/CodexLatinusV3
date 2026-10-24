package ast.expresiones;

import ast.Expresion;
import ast.ResultadoC3D;
import cuartetas.AccesoTemporal;
import cuartetas.Asignacion3D;
import cuartetas.Condicional3D;
import cuartetas.DefinicionEtiqueta3D;
import cuartetas.Goto3D;
import cuartetas.Literal3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.TablaSimbolos;
import semantico.TipoDato;

public class OperadorTernario extends Expresion {
    public Expresion condicion;
    public Expresion exprVerdadera;
    public Expresion exprFalsa;

    public OperadorTernario(Expresion condicion, Expresion exprVerdadera, Expresion exprFalsa, int linea, int columna) {
        super(linea, columna);
        this.condicion = condicion;
        this.exprVerdadera = exprVerdadera;
        this.exprFalsa = exprFalsa;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        ResultadoC3D resCond = (ResultadoC3D) condicion.generar(entorno);
        if (resCond != null && resCond.tipo != TipoDato.BOOLEANO) {
            GestorErrores.getInstancia().agregarError(TipoError.SEMANTICO, "La condición del operador ternario debe ser booleana.", linea, columna);
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        String L_Verdadero = gen.generarEtiqueta();
        String L_Falso = gen.generarEtiqueta();
        String L_Salida = gen.generarEtiqueta();

        AccesoTemporal t_resultado = new AccesoTemporal(gen.generarTemporal());

        gen.agregarCuarteta(new Condicional3D(resCond.valorC3D, new Literal3D("1"), "==", L_Verdadero));
        gen.agregarCuarteta(new Goto3D(L_Falso));

        // Bloque Verdadero
        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Verdadero));
        ResultadoC3D resV = (ResultadoC3D) exprVerdadera.generar(entorno);
        if (resV != null && resV.tipo != TipoDato.ERROR) {
            gen.agregarCuarteta(new Asignacion3D(t_resultado, resV.valorC3D));
        }
        gen.agregarCuarteta(new Goto3D(L_Salida));

        // Bloque Falso
        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Falso));
        ResultadoC3D resF = (ResultadoC3D) exprFalsa.generar(entorno);
        if (resF != null && resF.tipo != TipoDato.ERROR) {
            gen.agregarCuarteta(new Asignacion3D(t_resultado, resF.valorC3D));
        }

        // Si los tipos son diferentes, idealmente deberías lanzar un error semántico aquí comparando resV.tipo y resF.tipo
        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Salida));

        return new ResultadoC3D(t_resultado, resV.tipo);
    }
}