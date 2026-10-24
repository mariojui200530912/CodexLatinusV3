package ast.expresiones;

import ast.Expresion;
import ast.ResultadoC3D;
import cuartetas.AccesoTemporal;
import cuartetas.GetHeap3D;
import cuartetas.Literal3D;
import cuartetas.OperacionBinaria3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.TablaSimbolos;
import semantico.TipoDato;

import java.util.List;

public class AccesoArreglo extends Expresion {
    public Expresion arregloBase;
    public List<Expresion> indices;
    public boolean esDestino = false;

    public AccesoArreglo(Expresion arregloBase, List<Expresion> indices, int linea, int columna) {
        super(linea, columna);
        this.arregloBase = arregloBase;
        this.indices = indices;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        ResultadoC3D resBase = (ResultadoC3D) arregloBase.generar(entorno);

        if (resBase == null || resBase.tipo == TipoDato.ERROR) {
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        ResultadoC3D resIndice = (ResultadoC3D) indices.get(0).generar(entorno);

        if (resIndice.tipo != TipoDato.ENTERO) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "El índice del arreglo debe ser un número entero.", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // Calcular posicion: Dirección Base (Heap) + Índice
        AccesoTemporal t_posicion = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_posicion, resBase.valorC3D, "+", resIndice.valorC3D
        ));

        this.tipo = resBase.tipo;

        if (esDestino) {
            return new ResultadoC3D(t_posicion, this.tipo);
        }

        AccesoTemporal t_valor = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new GetHeap3D(t_valor, t_posicion));

        return new ResultadoC3D(t_valor, this.tipo);
    }
}