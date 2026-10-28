package generador;

import cuartetas.Cuarteta;
import semantico.TablaSimbolos;

import java.util.*;

public class GeneradorC3D {
    private static GeneradorC3D instancia;

    private int contadorTemporales;
    private int contadorEtiquetas;

    private List<Cuarteta> codigoFunciones;
    private List<Cuarteta> codigoMain;

    private boolean generandoFuncion;

    // Pilas globales para resolver los saltos de ciclos anidados
    public Stack<String> etiquetasBreak;
    public Stack<String> etiquetasContinue;

    private Map<String, TablaSimbolos> entornosClases;

    // Constructor privado (Patrón Singleton)
    private GeneradorC3D() {
        this.contadorTemporales = 0;
        this.contadorEtiquetas = 0;
        this.codigoFunciones = new ArrayList<>();
        this.codigoMain = new ArrayList<>();
        this.generandoFuncion = false;
        this.etiquetasBreak = new Stack<>();
        this.etiquetasContinue = new Stack<>();
        this.entornosClases = new HashMap<>();
    }

    // Obtener la instancia global
    public static GeneradorC3D getInstancia() {
        if (instancia == null) {
            instancia = new GeneradorC3D();
        }
        return instancia;
    }

    public void limpiar() {
        this.contadorTemporales = 0;
        this.contadorEtiquetas = 0;
        this.codigoFunciones.clear();
        this.codigoMain.clear();
        this.generandoFuncion = false;
        this.etiquetasBreak.clear();
        this.etiquetasContinue.clear();
        this.entornosClases.clear();
    }

    public void iniciarGeneracionFuncion() {
        this.generandoFuncion = true;
    }

    public void finalizarGeneracionFuncion() {
        this.generandoFuncion = false;
    }

    public String generarTemporal() {
        return "t" + (contadorTemporales++);
    }

    public String generarEtiqueta() {
        return "L" + (contadorEtiquetas++);
    }

    public void agregarCuarteta(Cuarteta cuarteta) {
        if (this.generandoFuncion) {
            this.codigoFunciones.add(cuarteta);
        } else {
            this.codigoMain.add(cuarteta);
        }
    }

    public List<Cuarteta> getCuartetas() {
        List<Cuarteta> todas = new ArrayList<>();
        todas.addAll(this.codigoFunciones);
        todas.addAll(this.codigoMain);
        return todas;
    }

    public void guardarEntornoClase(String nombreClase, TablaSimbolos entorno) {
        this.entornosClases.put(nombreClase, entorno);
    }

    public TablaSimbolos obtenerEntornoClase(String nombreClase) {
        return this.entornosClases.get(nombreClase);
    }


    public String obtenerCodigoString() {
        StringBuilder sb = new StringBuilder();

        sb.append("/* --- CÓDIGO DE TRES DIRECCIONES --- */\n");
        sb.append("#include <stdio.h>\n\n");

        // Memoria Principal
        sb.append("float Heap[65536];\n");
        sb.append("float Stack[65536];\n");
        sb.append("int P = 0;\n");
        sb.append("int H = 0;\n\n");

        if (contadorTemporales > 0) {
            sb.append("float ");
            for (int i = 0; i < contadorTemporales; i++) {
                sb.append("t").append(i);
                if (i < contadorTemporales - 1) {
                    sb.append(", ");
                }
            }
            sb.append(";\n\n");
        }

        // Primero las funciones (para que el compilador de C las conozca)
        sb.append("/* ========== FUNCIONES ========== */\n");
        for (Cuarteta c : codigoFunciones) {
            sb.append("\t").append(c.generarCodigo());
        }
        sb.append("\n");

        // Luego el main
        sb.append("/* ========== MAIN ========== */\n");
        sb.append("void main() {\n");
        for (Cuarteta c : codigoMain) {
            sb.append("\t").append(c.generarCodigo());
        }
        sb.append("\n\treturn;\n");
        sb.append("}\n");

        return sb.toString();
    }
}