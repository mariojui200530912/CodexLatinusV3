package ast.expresiones;

import ast.Expresion;
import ast.ResultadoC3D;
import cuartetas.*;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.Simbolo;
import semantico.TablaSimbolos;
import semantico.TipoDato;
import semantico.ValidadorTipos;

public class AccesoVariable extends Expresion {
    public String id;
    public boolean esDestino = false;

    public AccesoVariable(String id, int linea, int columna) {
        super(linea, columna);
        this.id = id;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        Simbolo sim = entorno.buscar(id);

        if (sim == null) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "La variable '" + id + "' no está definida.", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        this.tipo = ValidadorTipos.parsearTipo(sim.tipo);

        boolean esAtributo = "Atributo".equals(sim.categoria);

        if (!esAtributo) {
            TablaSimbolos temp = entorno;
            while (temp != null) {
                if (temp.tabla.containsKey(id) && temp.nombreEntorno.startsWith("Clase_")) {
                    esAtributo = true;
                    break;
                }
                temp = temp.padre;
            }
        }

        if (esAtributo) {
            AccesoTemporal t_posThis = new AccesoTemporal(gen.generarTemporal());
            gen.agregarCuarteta(new OperacionBinaria3D(
                    t_posThis, new PunteroGlobal3D("P"), "+", new Literal3D("1")
            ));

            AccesoTemporal t_thisRef = new AccesoTemporal(gen.generarTemporal());
            gen.agregarCuarteta(new GetStack3D(t_thisRef, t_posThis));

            AccesoTemporal t_posAttr = new AccesoTemporal(gen.generarTemporal());
            gen.agregarCuarteta(new OperacionBinaria3D(
                    t_posAttr, t_thisRef, "+", new Literal3D(String.valueOf(sim.direccionMemoria))
            ));

            if (esDestino) {
                ResultadoC3D res = new ResultadoC3D(t_posAttr, this.tipo);
                if (this.tipo == TipoDato.OBJETO) res.tipoStringOriginal = sim.tipo;
                return res;
            }

            AccesoTemporal t_valor = new AccesoTemporal(gen.generarTemporal());
            gen.agregarCuarteta(new GetHeap3D(t_valor, t_posAttr));

            ResultadoC3D res = new ResultadoC3D(t_valor, this.tipo);
            if (this.tipo == TipoDato.OBJETO) res.tipoStringOriginal = sim.tipo;
            return res;
        }

        AccesoTemporal t_posicion = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_posicion, new PunteroGlobal3D("P"), "+", new Literal3D(String.valueOf(sim.direccionMemoria))
        ));

        if (esDestino) {
            ResultadoC3D res = new ResultadoC3D(t_posicion, this.tipo);
            if (this.tipo == TipoDato.OBJETO) res.tipoStringOriginal = sim.tipo;
            return res;
        }

        AccesoTemporal t_valor = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new GetStack3D(t_valor, t_posicion));

        ResultadoC3D res = new ResultadoC3D(t_valor, this.tipo);
        if (this.tipo == TipoDato.OBJETO) res.tipoStringOriginal = sim.tipo;
        return res;
    }
}