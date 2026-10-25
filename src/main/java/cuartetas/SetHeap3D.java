package cuartetas;

public class SetHeap3D extends Cuarteta {
    public Operando3D posicion;
    public Operando3D valor;

    public SetHeap3D(Operando3D posicion, Operando3D valor) {
        this.posicion = posicion;
        this.valor = valor;
    }

    @Override
    public String generarCodigo() {
        return "Heap[(int)" + posicion.obtenerValor() + "] = " + valor.obtenerValor() + ";\n";
    }
}