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

        ResultadoC3D resBase = (ResultadoC3D) objetoBase.generar(entorno);
        if (resBase == null || resBase.tipo != TipoDato.OBJETO || resBase.tipoStringOriginal == null) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "Intento de llamar al método '" + idMetodo + "' sobre un objeto nulo o inválido.", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        String nombreClase = resBase.tipoStringOriginal;
        TablaSimbolos entornoClase = GeneradorC3D.getInstancia().obtenerEntornoClase(nombreClase);
        Simbolo simMetodo = null;
        if (entornoClase != null) {
            simMetodo = entornoClase.buscarLocal(idMetodo);
        }

        if (simMetodo == null || !"Metodo".equals(simMetodo.categoria)) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "El método '" + idMetodo + "' no pertenece a la clase '" + nombreClase + "'.", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        int argsEsperados = simMetodo.parametros.size() - 1;
        if (argumentos.size() != argsEsperados) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO,
                    "El método '" + idMetodo + "' espera " + argsEsperados + " argumentos, pero se enviaron " + argumentos.size() + ".",
                    linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        List<ResultadoC3D> resultadosArgs = new ArrayList<>();
        for (int i = 0; i < argumentos.size(); i++) {
            ResultadoC3D resArg = (ResultadoC3D) argumentos.get(i).generar(entorno);
            if (resArg == null || resArg.tipo == TipoDato.ERROR) {
                return new ResultadoC3D(null, TipoDato.ERROR);
            }
            resultadosArgs.add(resArg);
        }

        AccesoTemporal t_nuevoP = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_nuevoP, new cuartetas.PunteroGlobal3D("P"), "+", new Literal3D(String.valueOf(entorno.offset))
        ));

        // Inyectar 'this'
        AccesoTemporal t_posThis = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(t_posThis, t_nuevoP, "+", new Literal3D("1")));
        gen.agregarCuarteta(new SetStack3D(t_posThis, resBase.valorC3D));

        // Inyectar argumentos
        for (int i = 0; i < resultadosArgs.size(); i++) {
            AccesoTemporal t_posArg = new AccesoTemporal(gen.generarTemporal());
            gen.agregarCuarteta(new OperacionBinaria3D(
                    t_posArg, t_nuevoP, "+", new Literal3D(String.valueOf(i + 2))
            ));
            gen.agregarCuarteta(new SetStack3D(t_posArg, resultadosArgs.get(i).valorC3D));
        }

        // --- LLAMADA POLIMÓRFICA (Late Binding / V-Table) ---
        AccesoTemporal t_referenciaThis = (AccesoTemporal) resBase.valorC3D;

        Simbolo simClaseBase = entorno.buscar(nombreClase);
        AccesoTemporal t_posID = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(t_posID, t_referenciaThis, "+", new Literal3D(String.valueOf(simClaseBase.tamano))));

        // Leer el ID de la clase desde el Heap
        AccesoTemporal t_idRuntime = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new GetHeap3D(t_idRuntime, t_posID));

        gen.agregarCuarteta(new Asignacion3D(new PunteroGlobal3D("P"), t_nuevoP));

        gen.agregarCuarteta(new Call3DPolimorfica(idMetodo, t_idRuntime, simClaseBase.vTableFirmas, simClaseBase.vTableEtiquetasC3D));

        // Restaurar P
        AccesoTemporal t_regresarP = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_regresarP, new cuartetas.PunteroGlobal3D("P"), "-", new Literal3D(String.valueOf(entorno.offset))
        ));
        gen.agregarCuarteta(new Asignacion3D(new cuartetas.PunteroGlobal3D("P"), t_regresarP));

        // Capturar valor de retorno
        TipoDato tipoRetorno = ValidadorTipos.parsearTipo(simMetodo.tipo);
        if (tipoRetorno != TipoDato.VOID) {
            AccesoTemporal t_valorRetorno = new AccesoTemporal(gen.generarTemporal());
            gen.agregarCuarteta(new GetStack3D(t_valorRetorno, t_nuevoP));

            ResultadoC3D resFinal = new ResultadoC3D(t_valorRetorno, tipoRetorno);
            if (tipoRetorno == TipoDato.OBJETO) resFinal.tipoStringOriginal = simMetodo.tipo;
            return resFinal;
        }

        return new ResultadoC3D(null, TipoDato.VOID);
    }
}