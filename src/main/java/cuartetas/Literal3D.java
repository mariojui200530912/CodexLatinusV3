package cuartetas;

public class Literal3D implements Operando3D {
    public String valor;
    public Literal3D(String valor) { this.valor = valor; }
    @Override public String obtenerValor() { return valor; }
}