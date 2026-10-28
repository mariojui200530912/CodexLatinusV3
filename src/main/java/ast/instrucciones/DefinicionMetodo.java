package ast.instrucciones;

import ast.Instruccion;
import cuartetas.DefinicionEtiqueta3D;
import cuartetas.Return3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.Simbolo;
import semantico.TablaSimbolos;
import semantico.TipoDato;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DefinicionMetodo extends Instruccion {
    public String idMetodo;
    public String nombreClase;
    public TipoDato tipoRetorno;
    public String tipoObjetoRetorno;
    public List<DefinicionFuncion.ParametroFormal> parametros;
    public List<Instruccion> bloque;
    public String visibilidad;

    public DefinicionMetodo(String idMetodo, TipoDato tipoRetorno, String tipoObjetoRetorno, List<DefinicionFuncion.ParametroFormal> parametros, List<Instruccion> bloque, String visibilidad, int linea, int columna) {
        super(linea, columna);
        this.idMetodo = idMetodo;
        this.tipoRetorno = tipoRetorno;
        this.tipoObjetoRetorno = tipoObjetoRetorno;
        this.parametros = parametros;
        this.bloque = bloque;
        this.visibilidad = visibilidad != null ? visibilidad : "default";
    }

    @Override
    public Object generar(TablaSimbolos entornoClase) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        this.nombreClase = entornoClase.nombreEntorno.replace("Clase_", "");

        Simbolo simMetodo = entornoClase.buscarLocal(idMetodo);
        if (simMetodo == null) {
            String tipoStr = (tipoRetorno == TipoDato.OBJETO && tipoObjetoRetorno != null) ? tipoObjetoRetorno : tipoRetorno.toString();
            simMetodo = new Simbolo(idMetodo, tipoStr, "Metodo", visibilidad, null);
            entornoClase.insertar(simMetodo);
        }

        simMetodo.parametros.clear();

        String nombreUnicoMetodo = nombreClase + "_" + idMetodo;
        TablaSimbolos entornoLocal = new TablaSimbolos(entornoClase, "Metodo_" + nombreUnicoMetodo);
        entornoLocal.offset = 1;
        String tipoStr = (tipoRetorno == TipoDato.OBJETO && tipoObjetoRetorno != null) ? tipoObjetoRetorno : tipoRetorno.toString();
        Simbolo simRetorno = new Simbolo("$retorno", tipoStr, "Metadato");
        simRetorno.direccionMemoria = 0;
        entornoLocal.tabla.put("$retorno", simRetorno);

        Simbolo simThis = new Simbolo("this", nombreClase, "Variable");
        entornoLocal.insertar(simThis);
        simMetodo.parametros.add(simThis);

        if (parametros != null) {
            Set<String> nombresParametros = new HashSet<>();
            for (DefinicionFuncion.ParametroFormal param : parametros) {
                if (!nombresParametros.add(param.id)) {
                    GestorErrores.getInstancia().agregarError(
                            TipoError.SEMANTICO, "El parámetro '" + param.id + "' está duplicado en la definición del método '" + idMetodo + "'.", linea, columna
                    );
                    continue;
                }

                String tipoParamStr = (param.tipo == TipoDato.OBJETO) ? param.tipoObjeto : param.tipo.toString();
                Simbolo simParam = new Simbolo(param.id, tipoParamStr, "Variable");

                entornoLocal.insertar(simParam);
                simMetodo.parametros.add(simParam);
            }
        }

        gen.agregarCuarteta(new DefinicionEtiqueta3D(nombreUnicoMetodo));

        gen.agregarCuarteta(new cuartetas.GuardarReturnAddress());

        if (bloque != null) {
            for (Instruccion inst : bloque) {
                if (inst != null) inst.generar(entornoLocal);
            }
        }

        gen.agregarCuarteta(new Return3D());
        return null;
    }
}