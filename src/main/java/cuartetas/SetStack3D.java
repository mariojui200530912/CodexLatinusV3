package cuartetas;

public class SetStack3D extends Cuarteta {
    public Operando3D posicion;
    public Operando3D valor;

    public SetStack3D(Operando3D posicion, Operando3D valor) {
        this.posicion = posicion;
        this.valor = valor;
    }

    @Override
    public String generarCodigo() {
        return "Stack[(int)" + posicion.obtenerValor() + "] = " + valor.obtenerValor() + ";\n";
    }
}