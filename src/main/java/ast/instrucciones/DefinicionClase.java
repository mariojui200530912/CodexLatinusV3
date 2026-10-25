package ast.instrucciones;

import ast.Instruccion;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.Simbolo;
import semantico.TablaSimbolos;

import java.util.ArrayList;
import java.util.List;

public class DefinicionClase extends Instruccion {
    public String nombreClase;
    public String clasePadre;
    public String visibilidad;
    public List<Instruccion> miembros;

    public DefinicionClase(String nombreClase, String clasePadre, String visibilidad, List<Instruccion> miembros, int linea, int columna) {
        super(linea, columna);
        this.nombreClase = nombreClase;
        this.clasePadre = clasePadre;
        this.visibilidad = visibilidad != null ? visibilidad : "default";
        this.miembros = miembros != null ? miembros : new ArrayList<>();
    }

    @Override
    public Object generar(TablaSimbolos entornoGlobal) {
        // Validar que la clase no exista ya en el entorno global
        if (entornoGlobal.buscar(nombreClase) != null) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "La clase '" + nombreClase + "' ya ha sido definida.", linea, columna
            );
            return null;
        }

        // Crear el símbolo de la clase
        Simbolo simClase = new Simbolo(nombreClase, "Objeto", "Clase", visibilidad, clasePadre);

        // Crear el entorno específico de la clase (Scope)
        TablaSimbolos entornoClase = new TablaSimbolos(entornoGlobal, "Clase_" + nombreClase);

        GeneradorC3D.getInstancia().guardarEntornoClase(nombreClase, entornoClase);

        // Si hay herencia, debemos buscar los atributos del padre para heredar el offset inicial
        int offsetAtributos = 0;
        if (clasePadre != null) {
            Simbolo simPadre = entornoGlobal.buscar(clasePadre);
            if (simPadre == null || !"Clase".equals(simPadre.categoria)) {
                GestorErrores.getInstancia().agregarError(
                        TipoError.SEMANTICO, "La clase padre '" + clasePadre + "' no existe.", linea, columna
                );
            } else {
                offsetAtributos = simPadre.tamano;
                simClase.parametros.addAll(simPadre.parametros);
            }
        }

        // Primer recorrido: Extraer atributos y calcular el tamaño total del objeto en el Heap
        for (Instruccion miembro : miembros) {
            if (miembro instanceof DeclaracionAtributo) {
                DeclaracionAtributo attr = (DeclaracionAtributo) miembro;

                String tipoString = attr.tipoObjeto != null ? attr.tipoObjeto : attr.tipo.toString();
                Simbolo simAttr = new Simbolo(attr.idVariable, tipoString, "Atributo", attr.visibilidad, null);

                // Asignamos la posición relativa de este atributo dentro del objeto
                simAttr.direccionMemoria = offsetAtributos;
                offsetAtributos++;

                // Guardamos el atributo en la lista (esto lo usará AccesoPropiedad para saber el desplazamiento)
                simClase.parametros.add(simAttr);
                entornoClase.insertar(simAttr);
            }
        }

        // Guardamos el tamaño final de la clase (muy importante para el nodo InstanciaObjeto)
        simClase.tamano = offsetAtributos;
        entornoGlobal.insertar(simClase); // Se guarda en global para que instanciaciones la encuentren

        // Segundo recorrido: Generar los métodos y constructores (ahora que los atributos existen)
        for (Instruccion miembro : miembros) {
            if (miembro instanceof DefinicionMetodo) {
                // DefinicionMetodo generará su C3D e inyectará 'this' en la posición 0 de su propio stack
                miembro.generar(entornoClase);
            }
        }

        return null;
    }
}