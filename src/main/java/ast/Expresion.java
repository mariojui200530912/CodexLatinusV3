package ast;
import semantico.TablaSimbolos;
import semantico.TipoDato;

public abstract class Expresion {
    public int linea;
    public int columna;
    public TipoDato tipo; // Se llena durante la evaluación semántica

    public Expresion(int linea, int columna) {
        this.linea = linea;
        this.columna = columna;
    }

    public abstract Object generar(TablaSimbolos entorno);
}