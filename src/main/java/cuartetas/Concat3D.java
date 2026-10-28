package cuartetas;

import generador.TraductorRiscV;

public class Concat3D extends Cuarteta {
    public Operando3D destino;
    public Operando3D izq;
    public Operando3D der;

    public Concat3D(Operando3D destino, Operando3D izq, Operando3D der) {
        this.destino = destino;
        this.izq = izq;
        this.der = der;
    }

    @Override
    public String generarCodigo() {
        return destino.obtenerValor() + " = concat(" + izq.obtenerValor() + ", " + der.obtenerValor() + ");\n";
    }

    @Override
    public void traducirRiscV(StringBuilder text, TraductorRiscV traductor) {
        text.append("  la t0, H\n");
        text.append("  lw t0, 0(t0)\n");

        traductor.cargarOperando(izq, "t1");
        traductor.cargarOperando(der, "t2");

        String loop1 = "concat_loop1_" + System.identityHashCode(this);
        String end1 = "concat_end1_" + System.identityHashCode(this);
        String loop2 = "concat_loop2_" + System.identityHashCode(this);
        String end2 = "concat_end2_" + System.identityHashCode(this);

        // Bucle para copiar string1
        text.append(loop1).append(":\n");
        // CORRECCIÓN: Multiplicar t1 por 4 para leer el Heap de forma alineada
        text.append("  slli t3, t1, 2\n");
        text.append("  la t4, Heap\n");
        text.append("  add t3, t4, t3\n");
        text.append("  lw t3, 0(t3)\n");

        text.append("  li t4, -1\n");
        text.append("  beq t3, t4, ").append(end1).append("\n");

        text.append("  la t5, H\n  lw t5, 0(t5)\n  slli t5, t5, 2\n  la t6, Heap\n  add t6, t6, t5\n  sw t3, 0(t6)\n");
        text.append("  la t5, H\n  lw t6, 0(t5)\n  addi t6, t6, 1\n  sw t6, 0(t5)\n");
        text.append("  addi t1, t1, 1\n");
        text.append("  j ").append(loop1).append("\n");
        text.append(end1).append(":\n");

        // Bucle para copiar string2
        text.append(loop2).append(":\n");
        // CORRECCIÓN: Multiplicar t2 por 4 para leer el Heap de forma alineada
        text.append("  slli t3, t2, 2\n");
        text.append("  la t4, Heap\n");
        text.append("  add t3, t4, t3\n");
        text.append("  lw t3, 0(t3)\n");

        text.append("  li t4, -1\n");
        text.append("  beq t3, t4, ").append(end2).append("\n");

        text.append("  la t5, H\n  lw t5, 0(t5)\n  slli t5, t5, 2\n  la t6, Heap\n  add t6, t6, t5\n  sw t3, 0(t6)\n");
        text.append("  la t5, H\n  lw t6, 0(t5)\n  addi t6, t6, 1\n  sw t6, 0(t5)\n");
        text.append("  addi t2, t2, 1\n");
        text.append("  j ").append(loop2).append("\n");
        text.append(end2).append(":\n");

        // Escribir el -1 al final
        text.append("  la t5, H\n  lw t5, 0(t5)\n  slli t5, t5, 2\n  la t6, Heap\n  add t6, t6, t5\n  li t3, -1\n  sw t3, 0(t6)\n");
        text.append("  la t5, H\n  lw t6, 0(t5)\n  addi t6, t6, 1\n  sw t6, 0(t5)\n");

        traductor.guardarEnDestino(destino, "t0");
    }
}