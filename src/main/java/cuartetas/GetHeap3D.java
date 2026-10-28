package cuartetas;
import generador.TraductorRiscV;

public class GetHeap3D extends Cuarteta {
    public Operando3D destino;
    public Operando3D indice;

    public GetHeap3D(Operando3D destino, Operando3D indice) {
        this.destino = destino;
        this.indice = indice;
    }

    @Override
    public String generarCodigo() {
        return destino.obtenerValor() + " = Heap[(int)" + indice.obtenerValor() + "];\n";
    }

    @Override
    public void traducirRiscV(StringBuilder text, TraductorRiscV traductor) {
        traductor.cargarOperando(indice, "t0");
        text.append("    slli t0, t0, 2\n");
        text.append("    la t3, Heap\n");
        text.append("    add t3, t3, t0\n");
        text.append("    lw t1, 0(t3)\n");
        traductor.guardarEnDestino(destino, "t1");
    }
}