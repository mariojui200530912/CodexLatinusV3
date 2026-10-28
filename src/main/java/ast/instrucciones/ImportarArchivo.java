package ast.instrucciones;

import ast.Instruccion;
import semantico.TablaSimbolos;

public class ImportarArchivo extends Instruccion {
    public String rutaRelativa;

    public ImportarArchivo(String rutaRelativa, int linea, int columna) {
        super(linea, columna);
        this.rutaRelativa = rutaRelativa;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        return null;
    }
}