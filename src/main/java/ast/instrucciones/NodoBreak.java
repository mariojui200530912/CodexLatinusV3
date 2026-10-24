package ast.instrucciones;

import ast.Instruccion;
import cuartetas.Goto3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.TablaSimbolos;

public class NodoBreak extends Instruccion {

    public NodoBreak(int linea, int columna) {
        super(linea, columna);
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        if (gen.etiquetasBreak.isEmpty()) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "La instrucción 'romper' o 'break' solo puede usarse dentro de un ciclo.", linea, columna
            );
            return null;
        }

        // Obtenemos la etiqueta de salida del ciclo más cercano
        String etiquetaSalida = gen.etiquetasBreak.peek();
        gen.agregarCuarteta(new Goto3D(etiquetaSalida));

        return null;
    }
}