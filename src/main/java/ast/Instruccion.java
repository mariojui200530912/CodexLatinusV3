package ast;
import semantico.TablaSimbolos;

public abstract class Instruccion {
    public int linea;
    public int columna;

    public Instruccion(int linea, int columna) {
        this.linea = linea;
        this.columna = columna;
    }

    public abstract Object generar(TablaSimbolos entorno);
}