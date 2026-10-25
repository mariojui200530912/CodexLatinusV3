package ast;
import cuartetas.Operando3D;
import semantico.TipoDato;

public class ResultadoC3D {
    public Operando3D valorC3D; // Puede ser un Temporal (t0) o Literal (5)
    public TipoDato tipo;
    public String tipoStringOriginal; // Guarda el nombre de la clase (ej. "Cuenta")
    public boolean esArreglo;

    public ResultadoC3D(Operando3D valorC3D, TipoDato tipo) {
        this.valorC3D = valorC3D;
        this.tipo = tipo;
        this.esArreglo = false;
    }
}