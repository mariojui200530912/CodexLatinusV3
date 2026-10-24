package ast.expresiones;

import ast.Expresion;
import ast.ResultadoC3D;
import cuartetas.AccesoTemporal;
import cuartetas.Asignacion3D;
import cuartetas.Literal3D;
import cuartetas.OperacionBinaria3D;
import cuartetas.PunteroGlobal3D;
import cuartetas.SetHeap3D;
import generador.GeneradorC3D;
import semantico.TablaSimbolos;
import semantico.TipoDato;

public class Primitivo extends Expresion {
    public Object valor;

    public Primitivo(Object valor, TipoDato tipo, int linea, int columna) {
        super(linea, columna);
        this.valor = valor;
        this.tipo = tipo;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        if (tipo == TipoDato.ENTERO || tipo == TipoDato.DECIMAL) {
            return new ResultadoC3D(new Literal3D(valor.toString()), tipo);
        }

        else if (tipo == TipoDato.BOOLEANO) {
            // Transformar true/false a 1/0 para C3D
            String valBool = (Boolean) valor ? "1" : "0";
            return new ResultadoC3D(new Literal3D(valBool), tipo);
        }

        else if (tipo == TipoDato.CARACTER) {
            // Guardar el valor ASCII del carácter
            char c = valor.toString().charAt(0);
            return new ResultadoC3D(new Literal3D(String.valueOf((int) c)), tipo);
        }

        else if (tipo == TipoDato.CADENA) {
            // Guardar la referencia inicial del Heap donde empezará la cadena
            AccesoTemporal t_refCadena = new AccesoTemporal(gen.generarTemporal());
            gen.agregarCuarteta(new Asignacion3D(t_refCadena, new PunteroGlobal3D("H")));

            String texto = valor.toString();

            // Insertar cada caracter en el Heap y mover el puntero H
            for (int i = 0; i < texto.length(); i++) {
                int ascii = (int) texto.charAt(i);

                // Heap[H] = ascii;
                gen.agregarCuarteta(new SetHeap3D(new PunteroGlobal3D("H"), new Literal3D(String.valueOf(ascii))));

                // H = H + 1;
                gen.agregarCuarteta(new OperacionBinaria3D(
                        new PunteroGlobal3D("H"), new PunteroGlobal3D("H"), "+", new Literal3D("1")
                ));
            }

            // Añadir el terminador de cadena (-1)
            gen.agregarCuarteta(new SetHeap3D(new PunteroGlobal3D("H"), new Literal3D("-1")));
            gen.agregarCuarteta(new OperacionBinaria3D(
                    new PunteroGlobal3D("H"), new PunteroGlobal3D("H"), "+", new Literal3D("1")
            ));

            return new ResultadoC3D(t_refCadena, tipo);
        }

        else if (tipo == TipoDato.NULO) {
            // Nulo se representa como un puntero a -1
            return new ResultadoC3D(new Literal3D("-1"), tipo);
        }

        return new ResultadoC3D(null, TipoDato.ERROR);
    }
}