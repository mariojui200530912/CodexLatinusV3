package ast.expresiones;

import ast.Expresion;
import ast.ResultadoC3D;
import cuartetas.AccesoTemporal;
import cuartetas.Asignacion3D;
import cuartetas.Condicional3D;
import cuartetas.DefinicionEtiqueta3D;
import cuartetas.GetHeap3D;
import cuartetas.Goto3D;
import cuartetas.Literal3D;
import cuartetas.OperacionBinaria3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.TablaSimbolos;
import semantico.TipoDato;

public class AccesoLongitud extends Expresion {
    public Expresion base;

    public AccesoLongitud(Expresion base, int linea, int columna) {
        super(linea, columna);
        this.base = base;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        // Evaluar el objeto o primitivo base
        ResultadoC3D resBase = (ResultadoC3D) base.generar(entorno);

        if (resBase == null || resBase.tipo == TipoDato.ERROR) {
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        AccesoTemporal t_resultado = new AccesoTemporal(gen.generarTemporal());

        // RESOLUCION PARA CADENAS (Contar hasta encontrar el -1)
        if (resBase.tipo == TipoDato.CADENA) {
            String L_Inicio = gen.generarEtiqueta();
            String L_Fin = gen.generarEtiqueta();

            AccesoTemporal t_puntero = new AccesoTemporal(gen.generarTemporal());
            AccesoTemporal t_caracter = new AccesoTemporal(gen.generarTemporal());

            gen.agregarCuarteta(new Asignacion3D(t_resultado, new Literal3D("0")));
            gen.agregarCuarteta(new Asignacion3D(t_puntero, resBase.valorC3D));

            gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Inicio));
            gen.agregarCuarteta(new GetHeap3D(t_caracter, t_puntero));
            gen.agregarCuarteta(new Condicional3D(t_caracter, new Literal3D("-1"), "==", L_Fin));

            gen.agregarCuarteta(new OperacionBinaria3D(t_resultado, t_resultado, "+", new Literal3D("1")));
            gen.agregarCuarteta(new OperacionBinaria3D(t_puntero, t_puntero, "+", new Literal3D("1")));

            gen.agregarCuarteta(new Goto3D(L_Inicio));
            gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Fin));

            return new ResultadoC3D(t_resultado, TipoDato.ENTERO);
        }
        // RESOLUCION PARA ARREGLOS (Lectura directa de tamaño)
        else if (resBase.esArreglo) {
            // Leemos el tamaño directamente desde Heap[base]
            gen.agregarCuarteta(new GetHeap3D(t_resultado, resBase.valorC3D));
            return new ResultadoC3D(t_resultado, TipoDato.ENTERO);
        }
        // VALIDACION SEMANTICA (Error si no es Cadena ni Arreglo)
        else {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO,
                    "La propiedad '.length' (o longitud) solo se puede aplicar a Cadenas o Arreglos. Se intentó aplicar a un tipo: " + resBase.tipo,
                    linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }
    }
}