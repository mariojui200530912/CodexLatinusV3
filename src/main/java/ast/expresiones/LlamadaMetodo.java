package ast.expresiones;

import ast.Expresion;
import ast.ResultadoC3D;
import cuartetas.AccesoTemporal;
import cuartetas.Asignacion3D;
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

public class LlamadaMetodo extends Expresion {
    public Expresion objetoBase;
    public String idMetodo;
    public List<Expresion> argumentos;

    public LlamadaMetodo(Expresion objetoBase, String idMetodo, List<Expresion> argumentos, int linea, int columna) {
        super(linea, columna);
        this.objetoBase = objetoBase;
        this.idMetodo = idMetodo;
        this.argumentos = argumentos != null ? argumentos : new ArrayList<>();
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        // Evaluar el objeto base para obtener su referencia en el Heap
        ResultadoC3D resBase = (ResultadoC3D) objetoBase.generar(entorno);
        if (resBase == null || resBase.tipo != TipoDato.OBJETO || resBase.tipoStringOriginal == null) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "Intento de llamar al método '" + idMetodo + "' sobre un objeto nulo o inválido.", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        String nombreClase = resBase.tipoStringOriginal;

        // Buscar la clase y el metodo
        Simbolo simMetodo = null;
        TablaSimbolos entornoClase = GeneradorC3D.getInstancia().obtenerEntornoClase(nombreClase);
        if (entornoClase != null) {
            simMetodo = entornoClase.buscarLocal(idMetodo);
        }

        if (simMetodo == null || !"Metodo".equals(simMetodo.categoria)) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "El método '" + idMetodo + "' no pertenece a la clase '" + nombreClase + "'.", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // Validar cantidad de argumentos (restando 1 por el parámetro implícito 'this')
        int argsEsperados = simMetodo.parametros.size() - 1;
        if (argumentos.size() != argsEsperados) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO,
                    "El método '" + idMetodo + "' espera " + argsEsperados + " argumentos, pero se enviaron " + argumentos.size() + ".",
                    linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // Evaluar y Validar Argumentos Semanticamente
        List<ResultadoC3D> resultadosArgs = new ArrayList<>();
        for (int i = 0; i < argumentos.size(); i++) {
            ResultadoC3D resArg = (ResultadoC3D) argumentos.get(i).generar(entorno);
            if (resArg == null || resArg.tipo == TipoDato.ERROR) {
                return new ResultadoC3D(null, TipoDato.ERROR);
            }

            // El índice i + 1 salta el parámetro 'this' en la lista de símbolos
            Simbolo paramFormal = simMetodo.parametros.get(i + 1);

            TipoDato tipoEsperado = ValidadorTipos.parsearTipo(paramFormal.tipo);
            String tipoObjetoEsperado = paramFormal.tipo;

            boolean esAsignacionValida = ValidadorTipos.validarAsignacion(tipoEsperado, resArg.tipo);

            if (!esAsignacionValida) {
                GestorErrores.getInstancia().agregarError(
                        TipoError.SEMANTICO,
                        "Incompatibilidad de tipos en argumento " + (i + 1) + " del método '" + idMetodo + "': Se esperaba '" + tipoObjetoEsperado + "' pero se envió '" + resArg.tipo + "'.",
                        linea, columna
                );
                return new ResultadoC3D(null, TipoDato.ERROR);
            }

            // Validación de Herencia / Polimorfismo
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

            resultadosArgs.add(resArg);
        }

        // Preparar el nuevo entorno en el Stack
        AccesoTemporal t_nuevoP = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_nuevoP, new cuartetas.PunteroGlobal3D("P"), "+", new Literal3D(String.valueOf(entorno.offset))
        ));

        // Inyectar 'this' utilizando la direccion de memoria exacta registrada en su simbolo
        Simbolo paramThis = simMetodo.parametros.get(0);
        AccesoTemporal t_posThis = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(t_posThis, t_nuevoP, "+", new Literal3D(String.valueOf(paramThis.direccionMemoria))));
        gen.agregarCuarteta(new SetStack3D(t_posThis, resBase.valorC3D));

        // Inyectar el resto de parametros validados
        for (int i = 0; i < resultadosArgs.size(); i++) {
            Simbolo paramFormal = simMetodo.parametros.get(i + 1);
            AccesoTemporal t_posArg = new AccesoTemporal(gen.generarTemporal());

            gen.agregarCuarteta(new OperacionBinaria3D(
                    t_posArg, t_nuevoP, "+", new Literal3D(String.valueOf(paramFormal.direccionMemoria))
            ));
            gen.agregarCuarteta(new SetStack3D(t_posArg, resultadosArgs.get(i).valorC3D));
        }

        // Llamada (Name Mangling) y retorno del puntero P
        String nombreUnicoMetodo = nombreClase + "_" + idMetodo;
        gen.agregarCuarteta(new Asignacion3D(new cuartetas.PunteroGlobal3D("P"), t_nuevoP));
        gen.agregarCuarteta(new Asignacion3D(new AccesoTemporal("llamar"), new Literal3D(nombreUnicoMetodo + "()")));

        AccesoTemporal t_regresarP = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_regresarP, new cuartetas.PunteroGlobal3D("P"), "-", new Literal3D(String.valueOf(entorno.offset))
        ));
        gen.agregarCuarteta(new Asignacion3D(new cuartetas.PunteroGlobal3D("P"), t_regresarP));

        // Capturar valor de retorno leyendo la posicion 0 del entorno abandonado
        TipoDato tipoRetorno = ValidadorTipos.parsearTipo(simMetodo.tipo);
        if (tipoRetorno != TipoDato.VOID) {
            AccesoTemporal t_posRetorno = new AccesoTemporal(gen.generarTemporal());
            gen.agregarCuarteta(new OperacionBinaria3D(
                    t_posRetorno, new cuartetas.PunteroGlobal3D("P"), "+", new Literal3D(String.valueOf(entorno.offset))
            ));

            AccesoTemporal t_valorRetorno = new AccesoTemporal(gen.generarTemporal());
            gen.agregarCuarteta(new GetStack3D(t_valorRetorno, t_posRetorno));

            ResultadoC3D resFinal = new ResultadoC3D(t_valorRetorno, tipoRetorno);
            if (tipoRetorno == TipoDato.OBJETO) resFinal.tipoStringOriginal = simMetodo.tipo;
            return resFinal;
        }

        return new ResultadoC3D(null, TipoDato.VOID);
    }
}