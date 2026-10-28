package ast.expresiones;

import ast.Expresion;
import ast.ResultadoC3D;
import cuartetas.AccesoTemporal;
import cuartetas.Asignacion3D;
import cuartetas.Call3D;
import cuartetas.GetStack3D;
import cuartetas.Literal3D;
import cuartetas.OperacionBinaria3D;
import cuartetas.SetStack3D;
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

        Simbolo simFuncion = entorno.buscar(idFuncion);

        if (simFuncion == null || !"Funcion".equals(simFuncion.categoria)) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "La función '" + idFuncion + "' no existe o no ha sido declarada.", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        if (argumentos.size() != simFuncion.parametros.size()) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO,
                    "La función '" + idFuncion + "' espera " + simFuncion.parametros.size() + " argumentos, pero se enviaron " + argumentos.size() + ".",
                    linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        List<ResultadoC3D> resultadosArgs = new ArrayList<>();
        for (Expresion arg : argumentos) {
            resultadosArgs.add((ResultadoC3D) arg.generar(entorno));
        }

        AccesoTemporal t_nuevoP = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_nuevoP, new cuartetas.PunteroGlobal3D("P"), "+", new Literal3D(String.valueOf(entorno.offset))
        ));

        for (int i = 0; i < resultadosArgs.size(); i++) {
            ResultadoC3D resArg = resultadosArgs.get(i);
            Simbolo paramFormal = simFuncion.parametros.get(i);

            TipoDato tipoEsperado = ValidadorTipos.parsearTipo(paramFormal.tipo);
            String tipoObjetoEsperado = paramFormal.tipo;

            boolean esAsignacionValida = ValidadorTipos.validarAsignacion(tipoEsperado, resArg.tipo);

            if (!esAsignacionValida) {
                GestorErrores.getInstancia().agregarError(
                        TipoError.SEMANTICO,
                        "Incompatibilidad de tipos en argumento " + (i + 1) + " de '" + idFuncion + "': Se esperaba '" + tipoObjetoEsperado + "' pero se envió '" + resArg.tipo + "'.",
                        linea, columna
                );
                return new ResultadoC3D(null, TipoDato.ERROR);
            }

            if (tipoEsperado == TipoDato.OBJETO && resArg.tipo == TipoDato.OBJETO) {
                if (resArg.tipoStringOriginal != null) {
                    boolean esCompatible = false;
                    String claseActual = resArg.tipoStringOriginal;

                    while (claseActual != null && !claseActual.isEmpty()) {
                        if (claseActual.equals(tipoObjetoEsperado)) {
                            esCompatible = true;
                            break;
                        }
                        Simbolo simClaseActual = entorno.buscar(claseActual);
                        if (simClaseActual != null && "Clase".equals(simClaseActual.categoria)) {
                            claseActual = simClaseActual.clasePadre;
                        } else {
                            break;
                        }
                    }

                    if (!esCompatible) {
                        GestorErrores.getInstancia().agregarError(
                                TipoError.SEMANTICO,
                                "Incompatibilidad de clases en argumento " + (i + 1) + ": No se puede enviar un objeto de clase '" + resArg.tipoStringOriginal + "' como parámetro de tipo '" + tipoObjetoEsperado + "'.",
                                linea, columna
                        );
                        return new ResultadoC3D(null, TipoDato.ERROR);
                    }
                }
            }

            AccesoTemporal t_posArg = new AccesoTemporal(gen.generarTemporal());

            gen.agregarCuarteta(new OperacionBinaria3D(
                    t_posArg, t_nuevoP, "+", new Literal3D(String.valueOf(i + 1))
            ));
            gen.agregarCuarteta(new SetStack3D(t_posArg, resArg.valorC3D));
        }

        gen.agregarCuarteta(new Asignacion3D(new cuartetas.PunteroGlobal3D("P"), t_nuevoP));

        gen.agregarCuarteta(new Call3D(idFuncion));

        AccesoTemporal t_regresarP = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_regresarP, new cuartetas.PunteroGlobal3D("P"), "-", new Literal3D(String.valueOf(entorno.offset))
        ));
        gen.agregarCuarteta(new Asignacion3D(new cuartetas.PunteroGlobal3D("P"), t_regresarP));

        TipoDato tipoRetorno = ValidadorTipos.parsearTipo(simFuncion.tipo);
        if (tipoRetorno != TipoDato.VOID) {
            AccesoTemporal t_valorRetorno = new AccesoTemporal(gen.generarTemporal());
            gen.agregarCuarteta(new GetStack3D(t_valorRetorno, t_nuevoP));

            ResultadoC3D resFinal = new ResultadoC3D(t_valorRetorno, tipoRetorno);
            if (tipoRetorno == TipoDato.OBJETO) resFinal.tipoStringOriginal = simFuncion.tipo;
            return resFinal;
        }

        return new ResultadoC3D(null, TipoDato.VOID);
    }
}