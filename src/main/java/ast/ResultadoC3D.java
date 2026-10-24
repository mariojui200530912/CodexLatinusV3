package ast;
import semantico.TipoDato;
import cuartetas.MemoryAccess;

public class ResultadoC3D {
    public MemoryAccess valorC3D; // Puede ser un Temporal (t0) o Literal (5)
    public TipoDato tipo;
    public String tipoStringOriginal; // Guarda el nombre de la clase (ej. "Cuenta")

    public ResultadoC3D(MemoryAccess valorC3D, TipoDato tipo) {
        this.valorC3D = valorC3D;
        this.tipo = tipo;
    }
}