package semantico;

import java.util.HashMap;
import java.util.Map;

public class TablaSimbolos {
    public Map<String, Simbolo> tabla;
    public TablaSimbolos padre;
    public String nombreEntorno;

    public int offset; // Contador para asignar posiciones relativas en el Stack/Heap

    // Variables para control de flujo (Ciclos)
    public boolean esCiclo;
    public String etiquetaBreak;
    public String etiquetaContinue;

    public TablaSimbolos(TablaSimbolos padre, String nombreEntorno) {
        this.tabla = new HashMap<>();
        this.padre = padre;
        this.nombreEntorno = nombreEntorno;
        this.offset = (padre != null) ? padre.offset : 0;
        this.esCiclo = false;
        this.etiquetaBreak = null;
        this.etiquetaContinue = null;
    }

    public boolean insertar(Simbolo simbolo) {
        if (tabla.containsKey(simbolo.id)) {
            return false;
        }
        // Asignamos la dirección actual y aumentamos el offset para la siguiente variable
        simbolo.direccionMemoria = this.offset;
        this.offset += simbolo.tamano;

        tabla.put(simbolo.id, simbolo);
        return true;
    }

    // Busqueda recursiva (Sube por los entornos hasta encontrar el símbolo)
    public Simbolo buscar(String id) {
        if (tabla.containsKey(id)) {
            return tabla.get(id);
        }
        if (padre != null) {
            return padre.buscar(id);
        }
        return null;
    }

    // Busqueda estricta (Solo busca en el entorno actual)
    public Simbolo buscarLocal(String id) {
        return tabla.get(id);
    }

    // METODOS RECURSIVOS PARA CONTROL DE FLUJO
    public boolean estoyEnCiclo() {
        if (this.esCiclo) return true;
        if (this.padre != null) return this.padre.estoyEnCiclo();
        return false;
    }

    public String obtenerEtiquetaBreak() {
        if (this.etiquetaBreak != null && !this.etiquetaBreak.isEmpty()) return this.etiquetaBreak;
        if (this.padre != null) return this.padre.obtenerEtiquetaBreak();
        return null;
    }

    public String obtenerEtiquetaContinue() {
        if (this.etiquetaContinue != null && !this.etiquetaContinue.isEmpty()) return this.etiquetaContinue;
        if (this.padre != null) return this.padre.obtenerEtiquetaContinue();
        return null;
    }
}