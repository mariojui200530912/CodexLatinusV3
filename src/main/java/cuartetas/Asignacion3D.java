package cuartetas;

public class Asignacion3D extends Cuarteta {
    public Operando3D destino;
    public Operando3D origen;

    public Asignacion3D(Operando3D destino, Operando3D origen) {
        this.destino = destino;
        this.origen = origen;
    }

    @Override
    public String generarCodigo() {
        return destino.obtenerValor() + " = " + origen.obtenerValor() + ";\n";
    }
}