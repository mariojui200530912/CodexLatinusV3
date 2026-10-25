package cuartetas;

public class GetStack3D extends Cuarteta {
    public Operando3D destino;
    public Operando3D posicion;

    public GetStack3D(Operando3D destino, Operando3D posicion) {
        this.destino = destino;
        this.posicion = posicion;
    }

    @Override
    public String generarCodigo() {
        return destino.obtenerValor() + " = Stack[(int)" + posicion.obtenerValor() + "];\n";
    }
}