package ast.instrucciones;

import ast.Expresion;
import ast.Instruccion;
import java.util.List;

public class NodoCaso {
    public Expresion expresion;
    public List<Instruccion> instrucciones;
    public int linea;
    public int columna;
    public String etiquetaBloque;

    public NodoCaso(Expresion expresion, List<Instruccion> instrucciones, int linea, int columna) {
        this.expresion = expresion;
        this.instrucciones = instrucciones;
        this.linea = linea;
        this.columna = columna;
    }
}