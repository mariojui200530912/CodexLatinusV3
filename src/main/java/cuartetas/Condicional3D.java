package cuartetas;

public class Condicional3D extends Cuarteta {
    public Operando3D izq;
    public Operando3D der;
    public String operador;
    public String etiqueta;

    public Condicional3D(Operando3D izq, Operando3D der, String operador, String etiqueta) {
        this.izq = izq;
        this.der = der;
        this.operador = operador;
        this.etiqueta = etiqueta;
    }

    @Override
    public String generarCodigo() {
        return "if (" + izq.obtenerValor() + " " + operador + " " + der.obtenerValor() + ") goto " + etiqueta + ";\n";
    }
}