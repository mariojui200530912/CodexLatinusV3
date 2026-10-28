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
        if (entornoGlobal.buscar(nombreClase) != null) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "La clase '" + nombreClase + "' ya ha sido definida.", linea, columna
            );
            return null;
        }

        Simbolo simClase = new Simbolo(nombreClase, "Objeto", "Clase", visibilidad, clasePadre);
        TablaSimbolos entornoClase = new TablaSimbolos(entornoGlobal, "Clase_" + nombreClase);
        GeneradorC3D.getInstancia().guardarEntornoClase(nombreClase, entornoClase);

        int offsetAtributos = 0;
        List<String> vTableFirmas = new ArrayList<>();
        List<String> vTableEtiquetasC3D = new ArrayList<>();

        // HERENCIA: Copiar Atributos y V-Table del Padre
        if (clasePadre != null) {
            Simbolo simPadre = entornoGlobal.buscar(clasePadre);
            if (simPadre != null && "Clase".equals(simPadre.categoria)) {
                offsetAtributos = simPadre.tamano;
                simClase.parametros.addAll(simPadre.parametros);

                for (Simbolo paramPadre : simPadre.parametros) {
                    if (paramPadre.categoria.equals("Atributo")) {
                        entornoClase.insertar(paramPadre);
                    }
                }

                if (simPadre.vTableFirmas != null) {
                    vTableFirmas.addAll(simPadre.vTableFirmas);
                    vTableEtiquetasC3D.addAll(simPadre.vTableEtiquetasC3D);
                }
            } else {
                GestorErrores.getInstancia().agregarError(TipoError.SEMANTICO, "Clase padre '" + clasePadre + "' no encontrada antes de " + nombreClase, linea, columna);
            }
        }

        // Registrar Atributos Propios y construir V-Table (Polimorfismo)
        for (Instruccion miembro : miembros) {
            if (miembro instanceof DeclaracionAtributo) {
                DeclaracionAtributo attr = (DeclaracionAtributo) miembro;
                String tipoString = attr.tipoObjeto != null ? attr.tipoObjeto : attr.tipo.toString();
                Simbolo simAttr = new Simbolo(attr.idVariable, tipoString, "Atributo", attr.visibilidad, null);

                if (attr.esArreglo) {
                    simAttr.dimensionesArreglo.add(1);
                }

                simAttr.direccionMemoria = offsetAtributos++;
                simClase.parametros.add(simAttr);
                entornoClase.insertar(simAttr);
            }
            else if (miembro instanceof DefinicionMetodo) {
                DefinicionMetodo met = (DefinicionMetodo) miembro;
                String etiquetaC3D = nombreClase + "_" + met.idMetodo;

                Simbolo simMetodo = new Simbolo(met.idMetodo, met.tipoRetorno.toString(), "Metodo", met.visibilidad, null);
                entornoClase.insertar(simMetodo);

                if (met.idMetodo.equals(nombreClase)) continue;

                int indexOverride = vTableFirmas.indexOf(met.idMetodo);
                if (indexOverride != -1) {
                    vTableEtiquetasC3D.set(indexOverride, etiquetaC3D);
                } else {
                    vTableFirmas.add(met.idMetodo);
                    vTableEtiquetasC3D.add(etiquetaC3D);
                }
            }
        }

        simClase.tamano = offsetAtributos;
        simClase.vTableFirmas = vTableFirmas;
        simClase.vTableEtiquetasC3D = vTableEtiquetasC3D;
        entornoGlobal.insertar(simClase);

        return null;
    }

    public void generarCuerpoMetodos(TablaSimbolos entornoGlobal) {
        TablaSimbolos entornoClase = GeneradorC3D.getInstancia().obtenerEntornoClase(nombreClase);
        for (Instruccion miembro : miembros) {
            if (miembro instanceof DefinicionMetodo) {
                miembro.generar(entornoClase);
            }
        }
    }
}