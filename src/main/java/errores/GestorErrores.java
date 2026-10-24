package errores;

import java.util.ArrayList;
import java.util.List;

public class GestorErrores {
    private static GestorErrores instancia;
    private List<ErrorCompilacion> listaErrores;
    private String archivoActual; // Rastrea el archivo en compilación

    private GestorErrores() {
        this.listaErrores = new ArrayList<>();
        this.archivoActual = "Desconocido";
    }

    public static GestorErrores getInstancia() {
        if (instancia == null) {
            instancia = new GestorErrores();
        }
        return instancia;
    }

    public void setArchivoActual(String archivoActual) {
        this.archivoActual = archivoActual;
    }

    public String getArchivoActual() {
        return archivoActual;
    }

    public void agregarError(TipoError tipo, String descripcion, int linea, int columna, String archivo) {
        ErrorCompilacion nuevoError = new ErrorCompilacion(tipo, descripcion, linea, columna, archivo);
        listaErrores.add(nuevoError);
        System.err.println(nuevoError.toString());
    }

    public void agregarError(TipoError tipo, String descripcion, int linea, int columna) {
        agregarError(tipo, descripcion, linea, columna, this.archivoActual);
    }

    public List<ErrorCompilacion> getListaErrores() {
        return listaErrores;
    }

    public boolean hayErrores() {
        return !listaErrores.isEmpty();
    }

    public void limpiarErrores() {
        listaErrores.clear();
    }
}