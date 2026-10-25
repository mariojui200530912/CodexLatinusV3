package cuartetas;

public class AccesoTemporal implements Operando3D {
    public String idTemporal;
    public AccesoTemporal(String idTemporal) { this.idTemporal = idTemporal; }
    @Override public String obtenerValor() { return idTemporal; }
}