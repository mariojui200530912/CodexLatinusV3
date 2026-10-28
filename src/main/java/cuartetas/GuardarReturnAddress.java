package cuartetas;

import generador.TraductorRiscV;

public class GuardarReturnAddress extends Cuarteta {
    @Override
    public String generarCodigo() {
        return "// Guardar RA en hardware stack\n";
    }

    @Override
    public void traducirRiscV(StringBuilder text, TraductorRiscV traductor) {
        text.append("  addi sp, sp, -4\n");
        text.append("  sw ra, 0(sp)\n");
    }
}