package cuartetas;

public class Print3D extends Cuarteta {
    public String formato; // "i" (entero), "f" (decimal), "c" (carácter), "s" (cadena)
    public Operando3D valor;

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
            case "i": text.append("  li a7, 1\n  ecall\n"); break;
            case "f":
                text.append("  fmv.w.x fa0, a0\n  li a7, 2\n  ecall\n");
                break;
            case "c": text.append("  li a7, 11\n  ecall\n"); break;
            case "s": text.append("  li a7, 4\n  ecall\n"); break;
        }
    }
}