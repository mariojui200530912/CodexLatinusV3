package ast.expresiones;

import ast.Expresion;
import ast.ResultadoC3D;
import cuartetas.AccesoTemporal;
import cuartetas.Asignacion3D;
import cuartetas.Literal3D;
import cuartetas.OperacionBinaria3D;
import cuartetas.PunteroGlobal3D;
import cuartetas.SetHeap3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.TablaSimbolos;
import semantico.TipoDato;
import semantico.ValidadorTipos;

import java.util.ArrayList;
import java.util.List;

public class ArregloLiteral extends Expresion {
    public List<Expresion> elementos;

    public ArregloLiteral(List<Expresion> elementos, int linea, int columna) {
        super(linea, columna);
        this.elementos = elementos != null ? elementos : new ArrayList<>();
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        if (elementos.isEmpty()) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "No se puede inferir el tipo de un arreglo literal vacío.", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // 1. Guardar el puntero base del Heap (H)
        AccesoTemporal t_refArreglo = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new Asignacion3D(t_refArreglo, new PunteroGlobal3D("H")));

        // 2. Guardar el tamaño en Heap[H]
        gen.agregarCuarteta(new SetHeap3D(new PunteroGlobal3D("H"), new Literal3D(String.valueOf(elementos.size()))));
        gen.agregarCuarteta(new OperacionBinaria3D(
                new PunteroGlobal3D("H"), new PunteroGlobal3D("H"), "+", new Literal3D("1")
        ));

        TipoDato tipoArreglo = null;
        String tipoObjeto = null;

        // 3. Evaluar y guardar cada elemento
        for (int i = 0; i < elementos.size(); i++) {
            ResultadoC3D resElemento = (ResultadoC3D) elementos.get(i).generar(entorno);

            if (resElemento == null || resElemento.tipo == TipoDato.ERROR) continue;

            // Inferencia estricta: todos los elementos deben coincidir con el tipo del primero
            if (i == 0) {
                tipoArreglo = resElemento.tipo;
                tipoObjeto = resElemento.tipoStringOriginal;
            } else {
                if (!ValidadorTipos.validarAsignacion(tipoArreglo, resElemento.tipo)) {
                    GestorErrores.getInstancia().agregarError(
                            TipoError.SEMANTICO,
                            "Los elementos del arreglo deben ser del mismo tipo. Se encontró '" + resElemento.tipo + "' pero se esperaba '" + tipoArreglo + "'.",
                            linea, columna
                    );
                }
            }

            // Heap[H] = valor; H = H + 1;
            gen.agregarCuarteta(new SetHeap3D(new PunteroGlobal3D("H"), resElemento.valorC3D));
            gen.agregarCuarteta(new OperacionBinaria3D(
                    new PunteroGlobal3D("H"), new PunteroGlobal3D("H"), "+", new Literal3D("1")
            ));
        }

        ResultadoC3D resultado = new ResultadoC3D(t_refArreglo, tipoArreglo);
        resultado.tipoStringOriginal = tipoObjeto;
        resultado.esArreglo = true;

        return resultado;
    }
}