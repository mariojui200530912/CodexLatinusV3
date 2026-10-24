package ast.instrucciones;

import ast.Expresion;
import ast.Instruccion;
import ast.ResultadoC3D;
import ast.expresiones.AccesoPropiedad;
import ast.expresiones.AccesoVariable;
import cuartetas.AccesoTemporal;
import cuartetas.Literal3D;
import cuartetas.OperacionBinaria3D;
import cuartetas.SetHeap3D;
import cuartetas.SetStack3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.TablaSimbolos;
import semantico.TipoDato;

public class NodoIncrementoDecremento extends Instruccion {
    public Expresion destino;
    public String operador; // "++" o "--"

    public NodoIncrementoDecremento(Expresion destino, String operador, int linea, int columna) {
        super(linea, columna);
        this.destino = destino;
        this.operador = operador;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        // Obtener el valor actual (R-Value)
        ResultadoC3D resValorAntiguo = (ResultadoC3D) destino.generar(entorno);

        if (resValorAntiguo == null || (resValorAntiguo.tipo != TipoDato.ENTERO && resValorAntiguo.tipo != TipoDato.DECIMAL)) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "El operador '" + operador + "' solo se puede aplicar a variables numéricas.", linea, columna
            );
            return null;
        }

        // Obtener la dirección de memoria (L-Value)
        if (destino instanceof AccesoVariable) ((AccesoVariable) destino).esDestino = true;
        else if (destino instanceof AccesoPropiedad) ((AccesoPropiedad) destino).esDestino = true;

        ResultadoC3D resDireccion = (ResultadoC3D) destino.generar(entorno);

        // Operar (+1 o -1)
        String opC3D = operador.equals("++") ? "+" : "-";
        AccesoTemporal t_nuevoValor = new AccesoTemporal(gen.generarTemporal());

        gen.agregarCuarteta(new OperacionBinaria3D(
                t_nuevoValor, resValorAntiguo.valorC3D, opC3D, new Literal3D("1")
        ));

        // Guardar de vuelta
        if (destino instanceof AccesoVariable) {
            gen.agregarCuarteta(new SetStack3D(resDireccion.valorC3D, t_nuevoValor));
        } else {
            gen.agregarCuarteta(new SetHeap3D(resDireccion.valorC3D, t_nuevoValor));
        }

        return null;
    }
}