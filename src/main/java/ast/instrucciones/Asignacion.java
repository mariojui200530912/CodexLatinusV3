package ast.instrucciones;

import ast.Expresion;
import ast.Instruccion;
import ast.ResultadoC3D;
import ast.expresiones.AccesoPropiedad;
import ast.expresiones.AccesoVariable;
import ast.expresiones.AccesoArreglo;
import cuartetas.SetHeap3D;
import cuartetas.SetStack3D;
import generador.GeneradorC3D;
import semantico.TablaSimbolos;
import semantico.TipoDato;

public class Asignacion extends Instruccion {
    public Expresion destino; // AccesoVariable, AccesoPropiedad o AccesoArreglo
    public Expresion valor;

    public Asignacion(Expresion destino, Expresion valor, int linea, int columna) {
        super(linea, columna);
        this.destino = destino;
        this.valor = valor;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        // Indicar al nodo destino que devolvera una dirección de memoria (L-Value), no el valor
        if (destino instanceof AccesoVariable) ((AccesoVariable) destino).esDestino = true;
        else if (destino instanceof AccesoPropiedad) ((AccesoPropiedad) destino).esDestino = true;
        else if (destino instanceof AccesoArreglo) ((AccesoArreglo) destino).esDestino = true;

        // Evaluar el destino (direccion) y el valor (resultado)
        ResultadoC3D resDestino = (ResultadoC3D) destino.generar(entorno);
        ResultadoC3D resValor = (ResultadoC3D) valor.generar(entorno);

        if (resDestino == null || resValor == null || resDestino.tipo == TipoDato.ERROR || resValor.tipo == TipoDato.ERROR) {
            return null; // Error semántico ya reportado
        }

        // Validación de tipos omitida por brevedad (Aquí llamarías a ValidadorTipos)

        // Generar la escritura en memoria
        if (destino instanceof AccesoVariable) {
            // Guardar en el Stack
            gen.agregarCuarteta(new SetStack3D(resDestino.valorC3D, resValor.valorC3D));
        } else {
            // AccesoPropiedad y AccesoArreglo guardan en el Heap
            gen.agregarCuarteta(new SetHeap3D(resDestino.valorC3D, resValor.valorC3D));
        }

        return null;
    }
}