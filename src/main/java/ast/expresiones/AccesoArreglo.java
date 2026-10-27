package ast.expresiones;

import ast.Expresion;
import ast.ResultadoC3D;
import cuartetas.AccesoTemporal;
import cuartetas.GetHeap3D;
import cuartetas.Literal3D;
import cuartetas.OperacionBinaria3D;
import cuartetas.Asignacion3D;
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
        if (resBase == null || resBase.tipo == TipoDato.ERROR) return new ResultadoC3D(null, TipoDato.ERROR);

        if (!resBase.esArreglo) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "Se intentó acceder con índices a un tipo que no es arreglo.", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // t_offset = 0
        AccesoTemporal t_offset = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new Asignacion3D(t_offset, new Literal3D("0")));

        for (int i = 0; i < indices.size(); i++) {
            ResultadoC3D resIndice = (ResultadoC3D) indices.get(i).generar(entorno);

            if (resIndice.tipo != TipoDato.ENTERO) {
                GestorErrores.getInstancia().agregarError(TipoError.SEMANTICO, "El índice debe ser ENTERO.", linea, columna);
                return new ResultadoC3D(null, TipoDato.ERROR);
            }

            if (i > 0) {
                // Leer el tamaño de la dimensión actual: Heap[Base + 1 + i]
                AccesoTemporal t_dirDim = new AccesoTemporal(gen.generarTemporal());
                gen.agregarCuarteta(new OperacionBinaria3D(t_dirDim, resBase.valorC3D, "+", new Literal3D(String.valueOf(1 + i))));

                AccesoTemporal t_dimSize = new AccesoTemporal(gen.generarTemporal());
                gen.agregarCuarteta(new GetHeap3D(t_dimSize, t_dirDim));

                // t_offset = t_offset * t_dimSize
                gen.agregarCuarteta(new OperacionBinaria3D(t_offset, t_offset, "*", t_dimSize));
            }

            // t_offset = t_offset + resIndice
            gen.agregarCuarteta(new OperacionBinaria3D(t_offset, t_offset, "+", resIndice.valorC3D));
        }

        // Leer número de dimensiones: Heap[Base]
        AccesoTemporal t_numDims = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new GetHeap3D(t_numDims, resBase.valorC3D));

        // Calcular inicio de los datos: header_size = numDims + 1 -> dataStart = Base + header_size
        AccesoTemporal t_headerSize = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(t_headerSize, t_numDims, "+", new Literal3D("1")));

        AccesoTemporal t_dataStart = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(t_dataStart, resBase.valorC3D, "+", t_headerSize));

        // dir_fisica = dataStart + t_offset
        AccesoTemporal t_direccion = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(t_direccion, t_dataStart, "+", t_offset));

        if (esDestino) {
            ResultadoC3D res = new ResultadoC3D(t_direccion, resBase.tipo);
            res.tipoStringOriginal = resBase.tipoStringOriginal;
            res.esArreglo = false;
            return res;
        } else {
            AccesoTemporal t_valor = new AccesoTemporal(gen.generarTemporal());
            gen.agregarCuarteta(new GetHeap3D(t_valor, t_direccion));

            ResultadoC3D res = new ResultadoC3D(t_valor, resBase.tipo);
            res.tipoStringOriginal = resBase.tipoStringOriginal;
            res.esArreglo = false;
            return res;
        }
    }
}