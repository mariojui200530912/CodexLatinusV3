package ast.expresiones;

import ast.Expresion;
import ast.ResultadoC3D;
import cuartetas.Literal3D;
import semantico.TablaSimbolos;
import semantico.TipoDato;

public class Primitivo extends Expresion {
    public Object valor;

    public Primitivo(Object valor, TipoDato tipo, int linea, int columna) {
        super(linea, columna);
        this.valor = valor;
        this.tipo = tipo;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        // Los booleanos se manejan como 1 y 0 en C3D
        if (tipo == TipoDato.BOOLEANO) {
            String valBool = (Boolean) valor ? "1" : "0";
            return new ResultadoC3D(new Literal3D(valBool), tipo);
        }

        return new ResultadoC3D(new Literal3D(valor.toString()), tipo);
    }
}