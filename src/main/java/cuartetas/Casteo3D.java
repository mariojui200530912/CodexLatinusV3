package cuartetas;

public class Casteo3D extends Cuarteta {
    public Operando3D destino;
    public Operando3D origen;
    public String tipoDestino;

    public Casteo3D(Operando3D destino, Operando3D origen, String tipoDestino) {
        this.destino = destino;
        this.origen = origen;
        this.tipoDestino = tipoDestino;
    }

    @Override
    public String generarCodigo() {
        // Formateo visual para el C3D estilo C
        String casteoC = "";
        if (tipoDestino.equals("ENTERO")) casteoC = "(int)";
        else if (tipoDestino.equals("DECIMAL")) casteoC = "(float)";
        else if (tipoDestino.equals("CARACTER")) casteoC = "(char)";

        return destino.obtenerValor() + " = " + casteoC + " " + origen.obtenerValor() + ";\n";
    }
}