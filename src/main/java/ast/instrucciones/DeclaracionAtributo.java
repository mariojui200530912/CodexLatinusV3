package ast.instrucciones;

import ast.Expresion;
import ast.Instruccion;
import semantico.TablaSimbolos;
import semantico.TipoDato;

public class DeclaracionAtributo extends Instruccion {
    public String visibilidad;
    public TipoDato tipo;
    public String tipoObjeto;
    public String idVariable;
    public boolean esArreglo;
    public Expresion valor;

    public DeclaracionAtributo(String visibilidad, TipoDato tipo, String tipoObjeto, String idVariable, boolean esArreglo, Expresion valor, int linea, int columna) {
        super(linea, columna);
        this.visibilidad = visibilidad != null ? visibilidad : "default";
        this.tipo = tipo;
        this.tipoObjeto = tipoObjeto;
        this.idVariable = idVariable;
        this.esArreglo = esArreglo;
        this.valor = valor;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        return null;
    }
}