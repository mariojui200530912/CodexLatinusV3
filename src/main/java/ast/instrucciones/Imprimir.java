package ast.instrucciones;

import ast.Expresion;
import ast.Instruccion;
import ast.ResultadoC3D;
import cuartetas.Print3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.TablaSimbolos;
import semantico.TipoDato;

public class Imprimir extends Instruccion {
    public Expresion expresion;
    public boolean saltoDeLinea;

    public Imprimir(Expresion expresion, boolean saltoDeLinea, int linea, int columna) {
        super(linea, columna);
        this.expresion = expresion;
        this.saltoDeLinea = saltoDeLinea;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();
        ResultadoC3D res = (ResultadoC3D) expresion.generar(entorno);

        if (res == null || res.tipo == TipoDato.ERROR) {
            return null; // Error ya reportado en la expresión
        }

        // Emitimos la cuarteta nativa según el tipo de dato
        switch (res.tipo) {
            case ENTERO:
            case BOOLEANO: // El booleano se imprime como 1 o 0
                gen.agregarCuarteta(new Print3D("i", res.valorC3D));
                break;
            case DECIMAL:
                gen.agregarCuarteta(new Print3D("f", res.valorC3D));
                break;
            case CARACTER:
                gen.agregarCuarteta(new Print3D("c", res.valorC3D));
                break;
            case CADENA:
                gen.agregarCuarteta(new Print3D("s", res.valorC3D));
                break;
            default:
                GestorErrores.getInstancia().agregarError(
                        TipoError.SEMANTICO, "No se puede imprimir el tipo de dato: " + res.tipo, linea, columna
                );
                return null;
        }

        if (saltoDeLinea) {
            // Imprimir el código ASCII del salto de línea (\n = 10)
            gen.agregarCuarteta(new Print3D("c", new cuartetas.Literal3D("10")));
        }

        return null;
    }
}