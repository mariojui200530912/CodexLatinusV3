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

        if (entornoClase.tabla.containsKey(idMetodo)) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "El método '" + idMetodo + "' ya está definido en la clase '" + nombreClase + "'.", linea, columna
            );
            return null;
        }

        String tipoStr = (tipoRetorno == TipoDato.OBJETO && tipoObjetoRetorno != null) ? tipoObjetoRetorno : tipoRetorno.toString();
        Simbolo simMetodo = new Simbolo(idMetodo, tipoStr, "Metodo", visibilidad, null);
        entornoClase.insertar(simMetodo);

        String nombreUnicoMetodo = nombreClase + "_" + idMetodo;
        TablaSimbolos entornoLocal = new TablaSimbolos(entornoClase, "Metodo_" + nombreUnicoMetodo);
        entornoLocal.offset = 1;

        // El NodoRetornar buscará este símbolo "$retorno" para validar que devuelva el tipo correcto
        entornoLocal.insertar(new Simbolo("$retorno", tipoStr, "Metadato"));

        Simbolo simThis = new Simbolo("this", nombreClase, "Variable");
        simThis.direccionMemoria = entornoLocal.offset++;
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

                simParam.direccionMemoria = entornoLocal.offset++;
                simMetodo.parametros.add(simParam);
                entornoLocal.insertar(simParam);
            }
        }

        // Emitir la etiqueta de entrada de la función en C3D
        gen.agregarCuarteta(new DefinicionEtiqueta3D(nombreUnicoMetodo));

        if (bloque != null) {
            for (Instruccion inst : bloque) {
                if (inst != null) inst.generar(entornoLocal);
            }
        }

        // Emitir instrucción de retorno por defecto (cubriendo el caso en que un método void no tenga 'return;')
        gen.agregarCuarteta(new Return3D());
        return null;
    }
}