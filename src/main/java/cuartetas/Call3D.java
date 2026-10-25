package cuartetas;

public class Call3D extends Cuarteta {
    public String nombreFuncion;

    public Call3D(String nombreFuncion) {
        this.nombreFuncion = nombreFuncion;
    }

    @Override
    public String generarCodigo() {
        return nombreFuncion + "();\n";
    }
}