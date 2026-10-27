package cuartetas;

import generador.TraductorRiscV;

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

    @Override
    public void traducirRiscV(StringBuilder ensamblador, TraductorRiscV traductor) {
        traductor.cargarOperando(posicion, "t0");

        ensamblador.append("    slli t0, t0, 2\n");
        ensamblador.append("    la t3, Heap\n");
        ensamblador.append("    add t3, t3, t0\n");
        traductor.cargarOperando(valor, "t1");
        ensamblador.append("    sw t1, 0(t3)\n");
    }
}