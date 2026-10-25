package cuartetas;

public class GetHeap3D extends Cuarteta {
    public Operando3D destino;
    public Operando3D posicion;

    public GetHeap3D(Operando3D destino, Operando3D posicion) {
        this.destino = destino;
        this.posicion = posicion;
    }

    @Override
    public String generarCodigo() {
        return destino.obtenerValor() + " = Heap[(int)" + posicion.obtenerValor() + "];\n";
    }
}