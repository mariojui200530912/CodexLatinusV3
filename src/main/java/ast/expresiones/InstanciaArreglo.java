package ast.expresiones;

import ast.Expresion;
import ast.ResultadoC3D;
import cuartetas.AccesoTemporal;
import cuartetas.Asignacion3D;
import cuartetas.OperacionBinaria3D;
import cuartetas.PunteroGlobal3D;
import cuartetas.SetHeap3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.TablaSimbolos;
import semantico.TipoDato;

public class InstanciaArreglo extends Expresion {
    public TipoDato tipo;
    public Expresion tamano;

    public InstanciaArreglo(TipoDato tipo, Expresion tamano, int linea, int columna) {
        super(linea, columna);
        this.tipo = tipo;
        this.tamano = tamano;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        ResultadoC3D resTamano = (ResultadoC3D) tamano.generar(entorno);
        if (resTamano == null || resTamano.tipo != TipoDato.ENTERO) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "El tamaño del arreglo debe ser un número entero.", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // Reservar el puntero base en el Heap (H)
        AccesoTemporal t_refArreglo = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new Asignacion3D(t_refArreglo, new PunteroGlobal3D("H")));

        // Guardar el tamaño del arreglo en Heap[H] (útil para validar límites)
        gen.agregarCuarteta(new SetHeap3D(new PunteroGlobal3D("H"), resTamano.valorC3D));

        // Mover el puntero del Heap (H = H + tamano + 1)
        AccesoTemporal t_nuevoH = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_nuevoH, new PunteroGlobal3D("H"), "+", resTamano.valorC3D
        ));
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_nuevoH, t_nuevoH, "+", new cuartetas.Literal3D("1")
        ));
        gen.agregarCuarteta(new Asignacion3D(new PunteroGlobal3D("H"), t_nuevoH));

        return new ResultadoC3D(t_refArreglo, tipo);
    }
}