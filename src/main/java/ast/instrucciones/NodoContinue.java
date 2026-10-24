package ast.instrucciones;

import ast.Instruccion;
import cuartetas.Goto3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.TablaSimbolos;

public class NodoContinue extends Instruccion {

    public NodoContinue(int linea, int columna) {
        super(linea, columna);
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        if (gen.etiquetasContinue.isEmpty()) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "La instrucción 'interrumpir' o 'continue' solo puede usarse dentro de un ciclo.", linea, columna
            );
            return null;
        }

        // Obtenemos la etiqueta de retorno al inicio del ciclo más cercano
        String etiquetaInicio = gen.etiquetasContinue.peek();
        gen.agregarCuarteta(new Goto3D(etiquetaInicio));

        return null;
    }
}