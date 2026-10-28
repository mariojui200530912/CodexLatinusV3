package cuartetas;

import generador.TraductorRiscV;

public class SaltoIncondicional3D extends Cuarteta {
    public String etiqueta;

    public SaltoIncondicional3D(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public String generarCodigo() {
        return "goto " + etiqueta + ";\n";
    }

    @Override
    public void traducirRiscV(StringBuilder text, TraductorRiscV traductor) {
        text.append("  j ").append(etiqueta).append("\n");
    }
}