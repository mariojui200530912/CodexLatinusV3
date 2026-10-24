package ast.expresiones;

import ast.Expresion;
import ast.ResultadoC3D;
import cuartetas.AccesoTemporal;
import cuartetas.GetStack3D;
import cuartetas.Literal3D;
import cuartetas.OperacionBinaria3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.Simbolo;
import semantico.TablaSimbolos;
import semantico.TipoDato;
import semantico.ValidadorTipos;

public class AccesoVariable extends Expresion {
    public String id;
    public boolean esDestino = false; // true si está a la izquierda de un igual (L-Value)

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
                    TipoError.SEMANTICO, "La variable '" + id + "' no existe.", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        this.tipo = ValidadorTipos.parsearTipo(sim.tipo);

        // Calcular posición en el Stack: Puntero P + offset de la variable
        AccesoTemporal t_posicion = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_posicion, new cuartetas.PunteroGlobal3D("P"), "+", new Literal3D(String.valueOf(sim.direccionMemoria))
        ));

        // Si es para asignación (L-Value), retornamos la dirección en el Stack
        if (esDestino) {
            ResultadoC3D res = new ResultadoC3D(t_posicion, this.tipo);
            if (this.tipo == TipoDato.OBJETO) res.tipoStringOriginal = sim.tipo;
            return res;
        }

        // Si es lectura (R-Value), extraemos el valor del Stack
        AccesoTemporal t_valor = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new GetStack3D(t_valor, t_posicion));

        ResultadoC3D res = new ResultadoC3D(t_valor, this.tipo);
        if (this.tipo == TipoDato.OBJETO) res.tipoStringOriginal = sim.tipo;

        return res;
    }
}