package cuartetas;

import generador.TraductorRiscV;

public class DefinicionEtiqueta3D extends Cuarteta {
    public String etiqueta;

    public DefinicionEtiqueta3D(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public String generarCodigo() {
        return etiqueta + ":\n";
    }

    @Override
    public void traducirRiscV(StringBuilder ensamblador, TraductorRiscV traductor) {
        ensamblador.append(etiqueta).append(":\n");
    }
}