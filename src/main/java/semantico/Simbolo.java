package semantico;

import java.util.ArrayList;
import java.util.List;

public class Simbolo {
    public String id;
    public String tipo; // int, double, boolean, o el nombre de la clase (ej. "Cuenta")
    public String categoria; // Variable, Atributo, Metodo, Clase, Arreglo
    public String visibilidad; // public, private, protected, default

    public int direccionMemoria; // Posicion relativa en Stack o Heap
    public int tamano;

    public List<Integer> dimensionesArreglo; // Para arreglos multidimensionales
    public List<Simbolo> parametros; // Atributos si es Clase; Argumentos si es Metodo/Funcion
    public String clasePadre; // Para manejar 'extends' en Zetariano

    public boolean esReferencia; // Para objetos o arreglos pasados por referencia

    public List<String> vTableFirmas;
    public List<String> vTableEtiquetasC3D;

    // Constructor completo para Clases y Métodos
    public Simbolo(String id, String tipo, String categoria, String visibilidad, String clasePadre) {
        this.id = id;
        this.tipo = tipo;
        this.categoria = categoria;
        this.visibilidad = visibilidad;
        this.clasePadre = clasePadre;
        this.direccionMemoria = 0;
        this.tamano = 1;
        this.dimensionesArreglo = new ArrayList<>();
        this.parametros = new ArrayList<>();
        this.esReferencia = false;
        this.vTableFirmas = new ArrayList<>();
        this.vTableEtiquetasC3D = new ArrayList<>();
    }

    public Simbolo(String id, String tipo, String categoria) {
        this(id, tipo, categoria, "default", null);
    }
}