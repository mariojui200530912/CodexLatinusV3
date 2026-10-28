package cuartetas;

import generador.TraductorRiscV;
import java.util.List;

public class Call3DPolimorfica extends Cuarteta {
    public String nombreMetodoGenerico;
    public Operando3D idClaseRuntime;
    public List<String> vTableFirmas;
    public List<String> vTableEtiquetas;

    private static int contadorLlamadasPolimorficas = 0;

    public Call3DPolimorfica(String nombreMetodoGenerico, Operando3D idClaseRuntime, List<String> vTableFirmas, List<String> vTableEtiquetas) {
        this.nombreMetodoGenerico = nombreMetodoGenerico;
        this.idClaseRuntime = idClaseRuntime;
        this.vTableFirmas = vTableFirmas;
        this.vTableEtiquetas = vTableEtiquetas;
    }

    @Override
    public String generarCodigo() {
        return "CallPolimorfica(" + nombreMetodoGenerico + ", ID_Runtime: " + idClaseRuntime.obtenerValor() + ");\n";
    }

    @Override
    public void traducirRiscV(StringBuilder text, TraductorRiscV traductor) {
        int idLlamada = contadorLlamadasPolimorficas++;
        String etiquetaFinLlamada = "fin_polimorfica_" + idLlamada;

        traductor.cargarOperando(idClaseRuntime, "t4");

        for (int i = 0; i < vTableFirmas.size(); i++) {
            if (vTableFirmas.get(i).equals(nombreMetodoGenerico)) {
                // Se deduce el hashcode de la clase propietaria de esta etiqueta
                String etiquetaMetodo = vTableEtiquetas.get(i);
                String nombreClase = etiquetaMetodo.split("_")[0];
                int hashEsperado = Math.abs(nombreClase.hashCode() % 99999);

                text.append("  li t5, ").append(hashEsperado).append("\n");
                text.append("  beq t4, t5, hacer_llamada_").append(idLlamada).append("_").append(i).append("\n");
            }
        }

        text.append("  j ").append(etiquetaFinLlamada).append("\n");

        for (int i = 0; i < vTableFirmas.size(); i++) {
            if (vTableFirmas.get(i).equals(nombreMetodoGenerico)) {
                text.append("hacer_llamada_").append(idLlamada).append("_").append(i).append(":\n");
                text.append("  jal ").append(vTableEtiquetas.get(i)).append("\n");
                text.append("  j ").append(etiquetaFinLlamada).append("\n");
            }
        }

        text.append(etiquetaFinLlamada).append(":\n");
    }
}