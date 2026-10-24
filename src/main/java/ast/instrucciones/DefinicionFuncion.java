package ast.instrucciones;

import ast.Instruccion;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.Simbolo;
import semantico.TablaSimbolos;
import semantico.TipoDato;
import semantico.ValidadorTipos;

import java.util.List;

public class DefinicionFuncion extends Instruccion {
    public String idFuncion;
    public TipoDato tipoRetorno;
    public String tipoObjetoRetorno;
    public List<ParametroFormal> parametros;
    public List<Instruccion> bloque;

    public DefinicionFuncion(String idFuncion, TipoDato tipoRetorno, String tipoObjetoRetorno, List<ParametroFormal> parametros, List<Instruccion> bloque, int linea, int columna) {
        super(linea, columna);
        this.idFuncion = idFuncion;
        this.tipoRetorno = tipoRetorno;
        this.tipoObjetoRetorno = tipoObjetoRetorno;
        this.parametros = parametros;
        this.bloque = bloque;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        // Validar que la función no exista ya en el mismo ambito
        if (entorno.tabla.containsKey(idFuncion)) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "La función o método '" + idFuncion + "' ya está definida.", linea, columna
            );
            return null;
        }

        // Crear el simbolo de la funcion
        String tipoString = (tipoRetorno == TipoDato.OBJETO && tipoObjetoRetorno != null) ? tipoObjetoRetorno : tipoRetorno.toString();
        Simbolo simFuncion = new Simbolo(idFuncion, tipoString, "Funcion");
        entorno.insertar(simFuncion);

        // Crear el nuevo ambito (Scope) para la funcion
        TablaSimbolos entornoLocal = new TablaSimbolos(entorno, "Funcion_" + idFuncion);

        // El offset 0 está reservado para el valor de retorno ('return')
        entornoLocal.offset = 1;

        // Registrar los parametros en el entorno local
        if (parametros != null) {
            for (ParametroFormal param : parametros) {
                String tipoParamStr = (param.tipo == TipoDato.OBJETO) ? param.tipoObjeto : param.tipo.toString();
                Simbolo simParam = new Simbolo(param.id, tipoParamStr, "Variable");

                // Le asignamos su posicion en el Stack a este parametro y guardamos en la tabla
                simParam.direccionMemoria = entornoLocal.offset++;
                simFuncion.parametros.add(simParam);
                entornoLocal.insertar(simParam);
            }
        }

        // Iniciar la etiqueta de la funcion en C3D
        gen.agregarCodigoEnBruto("void " + idFuncion + "() {");

        // 6. Generar el código de las instrucciones internas
        if (bloque != null) {
            for (Instruccion inst : bloque) {
                if (inst != null) inst.generar(entornoLocal);
            }
        }

        // Cerrar la funcion
        gen.agregarCodigoEnBruto("    return;\n}\n");

        return null;
    }

    // Estructura auxiliar para los parametros recibidos
    public static class ParametroFormal {
        public TipoDato tipo;
        public String tipoObjeto;
        public String id;
        public ParametroFormal(TipoDato tipo, String tipoObjeto, String id) {
            this.tipo = tipo; this.tipoObjeto = tipoObjeto; this.id = id;
        }
    }
}