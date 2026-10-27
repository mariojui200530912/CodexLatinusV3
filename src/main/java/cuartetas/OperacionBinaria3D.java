package cuartetas;

import generador.TraductorRiscV;

public class OperacionBinaria3D extends Cuarteta {
    public Operando3D destino;
    public Operando3D izq;
    public String operador;
    public Operando3D der;

    public OperacionBinaria3D(Operando3D destino, Operando3D izq, String operador, Operando3D der) {
        this.destino = destino;
        this.izq = izq;
        this.operador = operador;
        this.der = der;
    }

    @Override
    public String generarCodigo() {
        return destino.obtenerValor() + " = " + izq.obtenerValor() + " " + operador + " " + der.obtenerValor() + ";\n";
    }

    @Override
    public void traducirRiscV(StringBuilder text, TraductorRiscV traductor) {
        traductor.cargarOperando(izq, "t0");
        traductor.cargarOperando(der, "t1");

        switch (operador) {
            case "+": text.append("  add t2, t0, t1\n"); break;
            case "-": text.append("  sub t2, t0, t1\n"); break;
            case "*": text.append("  mul t2, t0, t1\n"); break;
            case "/": text.append("  div t2, t0, t1\n"); break;
            case ">": text.append("  sgt t2, t0, t1\n"); break;
            case "<": text.append("  slt t2, t0, t1\n"); break;
            case "==":
                text.append("  sub t2, t0, t1\n  seqz t2, t2\n");
                break;
            case "!=":
                text.append("  sub t2, t0, t1\n  snez t2, t2\n");
                break;
        }
        traductor.guardarEnDestino(destino, "t2");
    }
}