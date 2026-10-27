package ast.expresiones;

import ast.Expresion;
import ast.ResultadoC3D;
import cuartetas.AccesoTemporal;
import cuartetas.Asignacion3D;
import cuartetas.OperacionBinaria3D;
import cuartetas.PunteroGlobal3D;
import cuartetas.SetHeap3D;
import cuartetas.Literal3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.TablaSimbolos;
import semantico.TipoDato;

import java.util.List;

public class InstanciaArreglo extends Expresion {
    public TipoDato tipo;
    public List<Expresion> dimensiones;

    public InstanciaArreglo(TipoDato tipo, List<Expresion> dimensiones, int linea, int columna) {
        super(linea, columna);
        this.tipo = tipo;
        this.dimensiones = dimensiones;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();
        if (dimensiones == null || dimensiones.isEmpty()) return new ResultadoC3D(null, TipoDato.ERROR);

        AccesoTemporal t_tamanoTotal = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new Asignacion3D(t_tamanoTotal, new Literal3D("1")));

        List<ResultadoC3D> resDimensiones = new java.util.ArrayList<>();
        for (Expresion dim : dimensiones) {
            ResultadoC3D resDim = (ResultadoC3D) dim.generar(entorno);
            if (resDim == null || resDim.tipo != TipoDato.ENTERO) return new ResultadoC3D(null, TipoDato.ERROR);
            resDimensiones.add(resDim);
            gen.agregarCuarteta(new OperacionBinaria3D(t_tamanoTotal, t_tamanoTotal, "*", resDim.valorC3D));
        }

        AccesoTemporal t_refArreglo = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new Asignacion3D(t_refArreglo, new PunteroGlobal3D("H")));

        // Descriptor 1: Número total de dimensiones
        gen.agregarCuarteta(new SetHeap3D(new PunteroGlobal3D("H"), new Literal3D(String.valueOf(dimensiones.size()))));
        gen.agregarCuarteta(new OperacionBinaria3D(new PunteroGlobal3D("H"), new PunteroGlobal3D("H"), "+", new Literal3D("1")));

        // Descriptor 2: Guardar el tamaño de cada dimensión
        for (ResultadoC3D resDim : resDimensiones) {
            gen.agregarCuarteta(new SetHeap3D(new PunteroGlobal3D("H"), resDim.valorC3D));
            gen.agregarCuarteta(new OperacionBinaria3D(new PunteroGlobal3D("H"), new PunteroGlobal3D("H"), "+", new Literal3D("1")));
        }

        // Mover H para reservar el espacio de los datos aplanados
        gen.agregarCuarteta(new OperacionBinaria3D(new PunteroGlobal3D("H"), new PunteroGlobal3D("H"), "+", t_tamanoTotal));

        ResultadoC3D resFinal = new ResultadoC3D(t_refArreglo, tipo);
        resFinal.esArreglo = true;
        return resFinal;
    }
}