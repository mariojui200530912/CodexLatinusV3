package errores;

public class ErrorCompilacion {
    private TipoError tipo;
    private String descripcion;
    private int linea;
    private int columna;
    private String archivo; // Nuevo campo

    public ErrorCompilacion(TipoError tipo, String descripcion, int linea, int columna, String archivo) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.linea = linea;
        this.columna = columna;
        this.archivo = archivo;
    }

    public TipoError getTipo() { return tipo; }
    public String getDescripcion() { return descripcion; }
    public int getLinea() { return linea; }
    public int getColumna() { return columna; }

    public String getArchivo() { return archivo; }

    @Override
    public String toString() {
        return tipo + " en " + archivo + " - Línea " + linea + ", Columna " + columna + ": " + descripcion;
    }
}