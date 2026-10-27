package cuartetas;

import generador.TraductorRiscV;

public class SetStack3D extends Cuarteta {
    public Operando3D posicion;
    public Operando3D valor;

    public SetStack3D(Operando3D posicion, Operando3D valor) {
        this.posicion = posicion;
        this.valor = valor;
    }

    @Override
    public String generarCodigo() {
        return "Stack[(int)" + posicion.obtenerValor() + "] = " + valor.obtenerValor() + ";\n";
    }

    @Override
    public void traducirRiscV(StringBuilder text, TraductorRiscV traductor) {
        traductor.cargarOperando(posicion, "t0");
        traductor.cargarOperando(valor, "t1");
        text.append("  slli t0, t0, 2\n");
        text.append("  la t2, Stack\n");
        text.append("  add t2, t2, t0\n");
        text.append("  sw t1, 0(t2)\n");
    }
}