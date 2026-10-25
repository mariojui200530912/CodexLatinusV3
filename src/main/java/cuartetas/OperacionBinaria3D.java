package cuartetas;

public class OperacionBinaria3D extends Cuarteta {
    public Operando3D destino;
    public Operando3D izq;
    public String operador;
    public Operando3D der;

    public OperacionBinaria3D(Operando3D destino, Operando3D izq, String operador, Operando3D der) {
        this.destino = destino;
        this.izq = izq;
        this.operador = operador;
        this.der = der;
    }

    @Override
    public String generarCodigo() {
        return destino.obtenerValor() + " = " + izq.obtenerValor() + " " + operador + " " + der.obtenerValor() + ";\n";
    }
}