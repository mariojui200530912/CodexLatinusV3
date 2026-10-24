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
    public boolean esDestino = false;

    public AccesoVariable(String id, int linea, int columna) {
        super(linea, columna);
        this.id = id;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        // Validar que la variable exista en el entorno o entornos padres
        Simbolo sim = entorno.buscar(id);

        if (sim == null) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "La variable '" + id + "' no está definida en el entorno actual.", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        this.tipo = ValidadorTipos.parsearTipo(sim.tipo);

        // Calcular la dirección absoluta en el Stack: t_pos = P + desplazamiento
        AccesoTemporal t_posicion = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_posicion, new cuartetas.PunteroGlobal3D("P"), "+", new Literal3D(String.valueOf(sim.direccionMemoria))
        ));

        // Si es destino (ej. x = 5), solo devolvemos la dirección de memoria donde se va a escribir
        if (esDestino) {
            ResultadoC3D res = new ResultadoC3D(t_posicion, this.tipo);
            if (this.tipo == TipoDato.OBJETO) res.tipoStringOriginal = sim.tipo;
            return res;
        }

        // Si es lectura (R-Value), leemos el valor contenido en el Stack
        AccesoTemporal t_valor = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new GetStack3D(t_valor, t_posicion));

        ResultadoC3D res = new ResultadoC3D(t_valor, this.tipo);

        // Mantener la clase original para validaciones de objetos posteriores
        if (this.tipo == TipoDato.OBJETO) res.tipoStringOriginal = sim.tipo;

        return res;
    }
}