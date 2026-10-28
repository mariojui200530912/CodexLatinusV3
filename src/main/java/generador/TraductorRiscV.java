package generador;

import cuartetas.Cuarteta;
import cuartetas.Literal3D;
import cuartetas.PunteroGlobal3D;
import cuartetas.AccesoTemporal;
import cuartetas.Operando3D;
import java.util.List;

public class TraductorRiscV {
    private StringBuilder data;
    private StringBuilder text;
    private int cantidadTemporales;

    public TraductorRiscV(int cantidadTemporales) {
        this.cantidadTemporales = cantidadTemporales;
        this.data = new StringBuilder();
        this.text = new StringBuilder();
    }

    public String traducir(List<Cuarteta> codigoC3D) {
        // Sección de Datos (.data)
        data.append(".data\n");
        data.append("Heap: .space 65536\n");  // 16384 elementos * 4 bytes
        data.append("Stack: .space 65536\n");
        data.append("P: .word 0\n");
        data.append("H: .word 0\n");
        int espacioTemporales = (cantidadTemporales > 0) ? (cantidadTemporales * 4) : 400;
        data.append("Temporales: .space ").append(espacioTemporales).append("\n");

        // Los strings y arreglos de bytes van al final
        data.append("salto_linea: .asciz \"\\n\"\n");

        // Sección de Código (.text)
        text.append(".text\n.globl main\nmain:\n");
        text.append("  j inicio_main\n");

        for (Cuarteta c : codigoC3D) {
            // Imprimimos la instrucción original en C3D como comentario de referencia en el ensamblador
            text.append("  # ").append(c.generarCodigo().trim()).append("\n");

            c.traducirRiscV(text, this);
        }

        // Finalizar ejecución (Syscall 10)
        text.append("\n  li a7, 10\n  ecall\n");
        return data.toString() + "\n" + text.toString();
    }

    // --- METODOS AUXILIARES  ---

    public void cargarOperando(Operando3D op, String registroDestino) {
        String val = op.obtenerValor();
        if (op instanceof Literal3D) {
            text.append("  li ").append(registroDestino).append(", ").append(val).append("\n");
        } else if (op instanceof PunteroGlobal3D) {
            text.append("  la t3, ").append(val).append("\n");
            text.append("  lw ").append(registroDestino).append(", 0(t3)\n");
        } else if (op instanceof AccesoTemporal) {
            int indice = Integer.parseInt(val.substring(1)); // Extrae el número de 't1'
            int offset = indice * 4;
            text.append("  la t3, Temporales\n");
            text.append("  lw ").append(registroDestino).append(", ").append(offset).append("(t3)\n");
        }
    }

    public void guardarEnDestino(Operando3D op, String registroOrigen) {
        String val = op.obtenerValor();
        if (op instanceof PunteroGlobal3D) {
            text.append("  la t3, ").append(val).append("\n");
            text.append("  sw ").append(registroOrigen).append(", 0(t3)\n");
        } else if (op instanceof AccesoTemporal) {
            int indice = Integer.parseInt(val.substring(1));
            int offset = indice * 4;
            text.append("  la t3, Temporales\n");
            text.append("  sw ").append(registroOrigen).append(", ").append(offset).append("(t3)\n");
        }
    }
}