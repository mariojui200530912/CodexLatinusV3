package cuartetas;

import generador.TraductorRiscV;

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

    @Override
    public void traducirRiscV(StringBuilder text, TraductorRiscV traductor) {
        traductor.cargarOperando(posicion, "t0");
        text.append("  slli t0, t0, 2\n");
        text.append("  la t2, Stack\n");
        text.append("  add t2, t2, t0\n");
        text.append("  lw t1, 0(t2)\n");
        traductor.guardarEnDestino(destino, "t1");
    }
}