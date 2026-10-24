package ast.expresiones;

import ast.Expresion;
import ast.ResultadoC3D;
import cuartetas.AccesoTemporal;
import cuartetas.Literal3D;
import cuartetas.OperacionBinaria3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.TablaSimbolos;
import semantico.TipoDato;

public class OperacionUnaria extends Expresion {
    public Expresion expr;
    public String operador;

    public OperacionUnaria(Expresion expr, String operador, int linea, int columna) {
        super(linea, columna);
        this.expr = expr;
        this.operador = operador;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();
        ResultadoC3D resExpr = (ResultadoC3D) expr.generar(entorno);

        if (resExpr == null || resExpr.tipo == TipoDato.ERROR) {
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        AccesoTemporal temporalResultado = new AccesoTemporal(gen.generarTemporal());

        if (operador.equals("!")) {
            if (resExpr.tipo != TipoDato.BOOLEANO) {
                GestorErrores.getInstancia().agregarError(
                        TipoError.SEMANTICO, "El operador '!' requiere una expresión booleana.", linea, columna
                );
                return new ResultadoC3D(null, TipoDato.ERROR);
            }
            // En C3D, negar un booleano (1 o 0) es equivalente a: resultado = 1 - valor
            gen.agregarCuarteta(new OperacionBinaria3D(
                    temporalResultado, new Literal3D("1"), "-", resExpr.valorC3D
            ));
            return new ResultadoC3D(temporalResultado, TipoDato.BOOLEANO);
        }
        else if (operador.equals("-")) {
            // Negacion aritmetica: resultado = 0 - valor
            gen.agregarCuarteta(new OperacionBinaria3D(
                    temporalResultado, new Literal3D("0"), "-", resExpr.valorC3D
            ));
            return new ResultadoC3D(temporalResultado, resExpr.tipo);
        }

        return new ResultadoC3D(null, TipoDato.ERROR);
    }
}