package ast.instrucciones;

import ast.Expresion;
import ast.Instruccion;
import semantico.TablaSimbolos;

public class NodoLlamada extends Instruccion {
    public Expresion llamada;

    public NodoLlamada(Expresion llamada, int linea, int columna) {
        super(linea, columna);
        this.llamada = llamada;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        return llamada.generar(entorno);
    }
}