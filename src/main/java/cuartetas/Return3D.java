package cuartetas;

import generador.TraductorRiscV;

public class Return3D extends Cuarteta {
    @Override
    public String generarCodigo() {
        return "return;\n";
    }

    @Override
    public void traducirRiscV(StringBuilder text, TraductorRiscV traductor) {
        text.append("  ret\n");
    }
}