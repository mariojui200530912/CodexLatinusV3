package cuartetas;

import generador.TraductorRiscV;

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

    @Override
    public void traducirRiscV(StringBuilder ensamblador, TraductorRiscV traductor) {
        traductor.cargarOperando(posicion, "t0");
        ensamblador.append("    slli t0, t0, 2\n");
        ensamblador.append("    la t3, Heap\n");
        ensamblador.append("    add t3, t3, t0\n");
        ensamblador.append("    lw t1, 0(t3)\n");
        traductor.guardarEnDestino(destino, "t1");
    }
}