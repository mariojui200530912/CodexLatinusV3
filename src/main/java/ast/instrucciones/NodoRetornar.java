package ast.instrucciones;

import ast.Expresion;
import ast.Instruccion;
import ast.ResultadoC3D;
import cuartetas.SetStack3D;
import cuartetas.PunteroGlobal3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.TablaSimbolos;
import semantico.TipoDato;

public class NodoRetornar extends Instruccion {
    public Expresion valor;

    public NodoRetornar(Expresion valor, int linea, int columna) {
        super(linea, columna);
        this.valor = valor;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        if (valor != null) {
            ResultadoC3D resValor = (ResultadoC3D) valor.generar(entorno);

            if (resValor != null && resValor.tipo != TipoDato.ERROR) {
                // Por convención de nuestro compilador, el valor de retorno
                // se guarda en la posición base del puntero actual (Stack[P + 0])
                gen.agregarCuarteta(new SetStack3D(new PunteroGlobal3D("P"), resValor.valorC3D));
            }
        }

        // En implementaciones avanzadas, si el return ocurre dentro de un if o ciclo,
        // aquí se genera un Goto3D hacia la etiqueta de fin del metodo actual.

        return null;
    }
}