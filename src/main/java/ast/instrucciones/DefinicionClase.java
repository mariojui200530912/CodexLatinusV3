package ast.instrucciones;

import ast.Instruccion;
import errores.GestorErrores;
import errores.TipoError;
import semantico.Simbolo;
import semantico.TablaSimbolos;

import java.util.List;

public class DefinicionClase extends Instruccion {
    public String nombreClase;
    public String clasePadre;
    public String visibilidad;
    public List<Instruccion> miembros; // Atributos, métodos y constructores

    public DefinicionClase(String nombreClase, String clasePadre, String visibilidad, List<Instruccion> miembros, int linea, int columna) {
        super(linea, columna);
        this.nombreClase = nombreClase;
        this.clasePadre = clasePadre;
        this.visibilidad = visibilidad != null ? visibilidad : "default";
        this.miembros = miembros;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        Simbolo simClase = new Simbolo(nombreClase, nombreClase, "Clase", visibilidad, clasePadre);

        int tamanoClase = 0;

        // Resolver la herencia (extends)
        if (clasePadre != null) {
            Simbolo padre = entorno.buscar(clasePadre);
            if (padre == null || !"Clase".equals(padre.categoria)) {
                GestorErrores.getInstancia().agregarError(
                        TipoError.SEMANTICO, "La clase padre '" + clasePadre + "' no existe.", linea, columna
                );
            } else {
                // Copiamos los atributos del padre para mantener la estructura en el Heap
                tamanoClase = padre.tamano;
                simClase.parametros.addAll(padre.parametros);
            }
        }

        // Extraer atributos para calcular el tamaño total de la instancia
        TablaSimbolos entornoClase = new TablaSimbolos(entorno, "Clase_" + nombreClase);
        entornoClase.offset = tamanoClase; // Los atributos nuevos se colocan después de los heredados

        for (Instruccion miembro : miembros) {
            if (miembro instanceof DeclaracionAtributo) {
                DeclaracionAtributo attr = (DeclaracionAtributo) miembro;
                Simbolo simAttr = new Simbolo(attr.idVariable, attr.tipo.toString(), "Atributo", attr.visibilidad, null);

                if (entornoClase.insertar(simAttr)) {
                    simClase.parametros.add(simAttr);
                    tamanoClase += simAttr.tamano;
                } else {
                    GestorErrores.getInstancia().agregarError(
                            TipoError.SEMANTICO, "Atributo duplicado: '" + attr.idVariable + "'.", attr.linea, attr.columna
                    );
                }
            }
        }

        simClase.tamano = tamanoClase;

        // Registrar la clase en la tabla global para que 'novus' la encuentre
        if (!entorno.insertar(simClase)) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "La clase '" + nombreClase + "' ya existe.", linea, columna
            );
            return null;
        }

        // Generar el código de constructores y metodos
        for (Instruccion miembro : miembros) {
            if (!(miembro instanceof DeclaracionAtributo)) {
                miembro.generar(entorno);
            }
        }

        return null;
    }
}