package ast.instrucciones;

import ast.Instruccion;
import semantico.TablaSimbolos;
import semantico.TipoDato;

public class DeclaracionAtributo extends Instruccion {
    public String visibilidad;
    public TipoDato tipo;
    public String tipoObjeto; // Almacena el nombre de la clase si el tipo es un objeto
    public String idVariable;
    public boolean esArreglo;

    public DeclaracionAtributo(String visibilidad, TipoDato tipo, String tipoObjeto, String idVariable, boolean esArreglo, int linea, int columna) {
        super(linea, columna);
        this.visibilidad = visibilidad != null ? visibilidad : "default";
        this.tipo = tipo;
        this.tipoObjeto = tipoObjeto;
        this.idVariable = idVariable;
        this.esArreglo = esArreglo;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        return null;
    }
}