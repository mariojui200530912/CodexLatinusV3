package cuartetas;

import generador.TraductorRiscV;

public class Return3D extends Cuarteta {
    @Override
    public String generarCodigo() {
        return "return;\n";
    }

    @Override
    public void traducirRiscV(StringBuilder text, TraductorRiscV traductor) {
        text.append("  lw ra, 0(sp)\n");
        text.append("  addi sp, sp, 4\n");
        text.append("  ret\n");
    }
}