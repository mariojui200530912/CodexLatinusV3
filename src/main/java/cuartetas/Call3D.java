package cuartetas;

import generador.TraductorRiscV;

public class Call3D extends Cuarteta {
    public String nombreFuncion;

    public Call3D(String nombreFuncion) {
        this.nombreFuncion = nombreFuncion;
    }

    @Override
    public String generarCodigo() {
        return nombreFuncion + "();\n";
    }

    @Override
    public void traducirRiscV(StringBuilder text, TraductorRiscV traductor) {
        text.append("  jal ").append(nombreFuncion).append("\n");
    }
}