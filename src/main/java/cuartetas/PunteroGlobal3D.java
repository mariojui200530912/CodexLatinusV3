package cuartetas;

public class PunteroGlobal3D implements Operando3D {
    public String puntero; // "P" para Stack, "H" para Heap
    public PunteroGlobal3D(String puntero) { this.puntero = puntero; }
    @Override public String obtenerValor() { return puntero; }
}