package cuartetas;

public class Goto3D extends Cuarteta {
    public String etiqueta;

    public Goto3D(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public String generarCodigo() {
        return "goto " + etiqueta + ";\n";
    }

    @Override
    public void traducirRiscV(StringBuilder text, generador.TraductorRiscV traductor) {
        text.append("  j ").append(etiqueta).append("\n");
    }
}