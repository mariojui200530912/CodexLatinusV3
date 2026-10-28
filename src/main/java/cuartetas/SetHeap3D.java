package cuartetas;
import generador.TraductorRiscV;

public class SetHeap3D extends Cuarteta {
    public Operando3D indice;
    public Operando3D valor;

    public SetHeap3D(Operando3D indice, Operando3D valor) {
        this.indice = indice;
        this.valor = valor;
    }

    @Override
    public String generarCodigo() {
        return "Heap[(int)" + indice.obtenerValor() + "] = " + valor.obtenerValor() + ";\n";
    }

    @Override
    public void traducirRiscV(StringBuilder text, TraductorRiscV traductor) {
        traductor.cargarOperando(indice, "t0");
        text.append("    slli t0, t0, 2\n");
        text.append("    la t3, Heap\n");
        text.append("    add t3, t3, t0\n");
        traductor.cargarOperando(valor, "t1");
        text.append("    sw t1, 0(t3)\n");
    }
}