package ast.instrucciones;

import ast.Instruccion;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.Simbolo;
import semantico.TablaSimbolos;
import semantico.TipoDato;

import java.util.List;

public class DefinicionMetodo extends Instruccion {
    public String visibilidad;
    public boolean esOverride;
    public TipoDato tipoRetorno;
    public String tipoObjeto; // Por si retorna otra clase
    public String idMetodo;
    public List<Simbolo> parametros;
    public List<Instruccion> bloque;

    public DefinicionMetodo(String visibilidad, boolean esOverride, TipoDato tipoRetorno, String tipoObjeto, String idMetodo, List<Simbolo> parametros, List<Instruccion> bloque, int linea, int columna) {
        super(linea, columna);
        this.visibilidad = visibilidad != null ? visibilidad : "default";
        this.esOverride = esOverride;
        this.tipoRetorno = tipoRetorno;
        this.tipoObjeto = tipoObjeto;
        this.idMetodo = idMetodo;
        this.parametros = parametros;
        this.bloque = bloque;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        // Extraer nombre de la clase para evitar colisiones en C3D
        String nombreClase = entorno.nombreEntorno.replace("Clase_", "");
        String nombreUnicoMetodo = nombreClase + "_" + idMetodo;

        // Registrar el metodo en la Tabla de Simbolos de la clase
        Simbolo simMetodo = new Simbolo(idMetodo, tipoRetorno.toString(), "Metodo", visibilidad, null);
        simMetodo.parametros = this.parametros;

        if (esOverride) {
            // Aquí puedes agregar la validación semántica buscando el método en la clasePadre
        }

        if (!entorno.insertar(simMetodo)) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "El método '" + idMetodo + "' ya está definido en la clase.", linea, columna
            );
            return null;
        }

        // Crear entorno local y configurar memoria en el Stack
        TablaSimbolos entornoLocal = new TablaSimbolos(entorno, "Metodo_" + idMetodo);

        // El offset inicia en 1 porque la posición 0 del Stack Local contendrá el puntero 'this'
        entornoLocal.offset = 1;

        // Inyectamos 'this' implícitamente
        Simbolo simThis = new Simbolo("this", nombreClase, "Instancia");
        simThis.direccionMemoria = 0;
        entornoLocal.tabla.put("this", simThis);

        // Guardamos los parametros formales
        if (parametros != null) {
            for (Simbolo param : parametros) {
                entornoLocal.insertar(param);
            }
        }

        // Generación de Cuartetas C3D
        gen.setEnFuncion(true);
        gen.agregarPrototipo(nombreUnicoMetodo);

        // Agrega la cuarteta que inicia el bloque de la función en C/RISC-V
        // gen.agregarCuarteta(new DefinicionMetodo3D(nombreUnicoMetodo));

        if (bloque != null) {
            for (Instruccion inst : bloque) {
                if (inst != null) inst.generar(entornoLocal);
            }
        }

        // gen.agregarCuarteta(new FinMetodo3D());
        gen.setEnFuncion(false);

        return null;
    }
}