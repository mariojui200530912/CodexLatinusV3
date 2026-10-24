package ast.expresiones;

import ast.Expresion;
import ast.ResultadoC3D;
import cuartetas.AccesoTemporal;
import cuartetas.GetStack3D;
import cuartetas.Literal3D;
import cuartetas.OperacionBinaria3D;
import cuartetas.SetStack3D;
import cuartetas.Asignacion3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.Simbolo;
import semantico.TablaSimbolos;
import semantico.TipoDato;
import semantico.ValidadorTipos;

import java.util.ArrayList;
import java.util.List;

public class LlamadaFuncion extends Expresion {
    public String idFuncion;
    public List<Expresion> argumentos;

    public LlamadaFuncion(String idFuncion, List<Expresion> argumentos, int linea, int columna) {
        super(linea, columna);
        this.idFuncion = idFuncion;
        this.argumentos = argumentos != null ? argumentos : new ArrayList<>();
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        // Buscar la funcion/metodo en la Tabla de Símbolos
        Simbolo simFuncion = entorno.buscar(idFuncion);
        if (simFuncion == null || (!simFuncion.categoria.equals("Funcion") && !simFuncion.categoria.equals("Metodo"))) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "La función o método '" + idFuncion + "' no está definido.", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // Validar coincidencia en la cantidad de parametros
        if (simFuncion.parametros.size() != argumentos.size()) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "La función '" + idFuncion + "' espera " + simFuncion.parametros.size() + " argumentos, pero recibió " + argumentos.size() + ".", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // Evaluar los argumentos actuales
        List<ResultadoC3D> resultadosArgs = new ArrayList<>();
        for (Expresion arg : argumentos) {
            resultadosArgs.add((ResultadoC3D) arg.generar(entorno));
        }

        // Calcular el inicio del nuevo entorno (Stack): t_nuevoP = P + entorno.offset
        AccesoTemporal t_nuevoP = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_nuevoP, new cuartetas.PunteroGlobal3D("P"), "+", new Literal3D(String.valueOf(entorno.offset))
        ));

        // Inyectar los argumentos en las posiciones relativas del nuevo entorno
        for (int i = 0; i < resultadosArgs.size(); i++) {
            Simbolo paramFormal = simFuncion.parametros.get(i);
            AccesoTemporal t_posArg = new AccesoTemporal(gen.generarTemporal());

            gen.agregarCuarteta(new OperacionBinaria3D(
                    t_posArg, t_nuevoP, "+", new Literal3D(String.valueOf(paramFormal.direccionMemoria))
            ));
            gen.agregarCuarteta(new SetStack3D(t_posArg, resultadosArgs.get(i).valorC3D));
        }

        // Mover el puntero global P, ejecutar la llamada y restaurar P
        gen.agregarCuarteta(new Asignacion3D(new cuartetas.PunteroGlobal3D("P"), t_nuevoP));

        // Simulacion de la instruccion de llamada 'call funcion()' en C3D
        gen.agregarCuarteta(new Asignacion3D(new AccesoTemporal("llamar"), new Literal3D(idFuncion + "()")));

        AccesoTemporal t_regresarP = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_regresarP, new cuartetas.PunteroGlobal3D("P"), "-", new Literal3D(String.valueOf(entorno.offset))
        ));
        gen.agregarCuarteta(new Asignacion3D(new cuartetas.PunteroGlobal3D("P"), t_regresarP));

        // Extraer el valor de retorno (si no es VOID)
        TipoDato tipoRetorno = ValidadorTipos.parsearTipo(simFuncion.tipo);
        if (tipoRetorno != TipoDato.VOID) {
            AccesoTemporal t_posRetorno = new AccesoTemporal(gen.generarTemporal());

            // Por convencion, el valor de retorno se aloja en la posición 0 del entorno de la función llamada
            gen.agregarCuarteta(new OperacionBinaria3D(
                    t_posRetorno, new cuartetas.PunteroGlobal3D("P"), "+", new Literal3D(String.valueOf(entorno.offset))
            ));

            AccesoTemporal t_valorRetorno = new AccesoTemporal(gen.generarTemporal());
            gen.agregarCuarteta(new GetStack3D(t_valorRetorno, t_posRetorno));

            ResultadoC3D resFinal = new ResultadoC3D(t_valorRetorno, tipoRetorno);
            if (tipoRetorno == TipoDato.OBJETO) resFinal.tipoStringOriginal = simFuncion.tipo;
            return resFinal;
        }

        return new ResultadoC3D(null, TipoDato.VOID);
    }
}