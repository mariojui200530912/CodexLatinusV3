package cuartetas;

public class Print3D extends Cuarteta {
    public String formato; // "i" (entero), "f" (decimal), "c" (carácter), "s" (cadena)
    public Operando3D valor;

    private static int contadorLoops = 0;

    public Print3D(String formato, Operando3D valor) {
        this.formato = formato;
        this.valor = valor;
    }

    @Override
    public String generarCodigo() {
        String formatoPrintf = "%d";
        if (formato.equals("f")) {
            formatoPrintf = "%f";
        } else if (formato.equals("c")) {
            formatoPrintf = "%c";
        } else if (formato.equals("s")) {
            formatoPrintf = "%s";
        }

        return "printf(\"" + formatoPrintf + "\", " + valor.obtenerValor() + ");\n";
    }

    @Override
    public void traducirRiscV(StringBuilder text, generador.TraductorRiscV traductor) {
        traductor.cargarOperando(valor, "a0");

        switch (formato) {
            case "i":
                text.append("  li a7, 1\n  ecall\n");
                break;
            case "f":
                text.append("  fmv.w.x fa0, a0\n  li a7, 2\n  ecall\n");
                break;
            case "c":
                text.append("  li a7, 11\n  ecall\n");
                break;
            case "s":
                int idLoop = contadorLoops++;
                text.append("  mv t4, a0\n"); // t4 = índice inicial
                text.append("print_str_loop_").append(idLoop).append(":\n");
                text.append("  slli t5, t4, 2\n"); // Índice * 4 (bytes por word)
                text.append("  la t6, Heap\n");
                text.append("  add t6, t6, t5\n"); // Dirección exacta del Heap
                text.append("  lw a0, 0(t6)\n"); // Extraer valor ASCII
                text.append("  li t5, -1\n");
                text.append("  beq a0, t5, print_str_end_").append(idLoop).append("\n"); // Fin de cadena
                text.append("  li a7, 11\n"); // Imprimir caracter (a0)
                text.append("  ecall\n");
                text.append("  addi t4, t4, 1\n"); // Siguiente índice
                text.append("  j print_str_loop_").append(idLoop).append("\n");
                text.append("print_str_end_").append(idLoop).append(":\n");
                break;
        }
    }
}