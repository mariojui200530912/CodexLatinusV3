package cuartetas;

public class DefinicionEtiqueta3D extends Cuarteta {
    public String etiqueta;

    public DefinicionEtiqueta3D(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public String generarCodigo() {
        return etiqueta + ":\n";
    }
}