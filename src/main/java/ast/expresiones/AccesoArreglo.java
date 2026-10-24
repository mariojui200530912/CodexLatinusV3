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

public class AccesoArreglo extends Expresion {
    public Expresion arregloBase;
    public Expresion indice;
    public boolean esDestino = false; // true si está a la izquierda de una asignación

    public AccesoArreglo(Expresion arregloBase, Expresion indice, int linea, int columna) {
        super(linea, columna);
        this.arregloBase = arregloBase;
        this.indice = indice;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        //  Evaluar el arreglo base (devuelve el puntero base en el Heap)
        ResultadoC3D resBase = (ResultadoC3D) arregloBase.generar(entorno);

        // Evaluar la expresión del índice
        ResultadoC3D resIndice = (ResultadoC3D) indice.generar(entorno);

        if (resBase == null || resIndice == null || resBase.tipo == TipoDato.ERROR || resIndice.tipo == TipoDato.ERROR) {
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // Validación Semántica
        if (resIndice.tipo != TipoDato.ENTERO) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO,
                    "El índice para acceder a un arreglo debe ser de tipo ENTERO. Se encontró: " + resIndice.tipo,
                    linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // Calcular la dirección física en el Heap: dir = base + indice + 1
        AccesoTemporal t_desplazamiento = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_desplazamiento, resIndice.valorC3D, "+", new Literal3D("1")
        ));

        AccesoTemporal t_direccion = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_direccion, resBase.valorC3D, "+", t_desplazamiento
        ));

        // Retornar dirección si es asignación, o extraer el valor si es lectura
        if (esDestino) {
            ResultadoC3D res = new ResultadoC3D(t_direccion, resBase.tipo);
            res.tipoStringOriginal = resBase.tipoStringOriginal;
            res.esArreglo = false; // El elemento extraído ya no es un arreglo en sí
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