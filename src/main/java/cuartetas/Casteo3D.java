package cuartetas;

import generador.TraductorRiscV;

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

    @Override
    public void traducirRiscV(StringBuilder text, TraductorRiscV traductor) {
        // Cargamos el valor original en t0
        traductor.cargarOperando(origen, "t0");

        // Aplicamos la conversión según el destino
        if (tipoDestino.equals("DECIMAL")) {
            text.append("  fcvt.s.w f0, t0\n");
            text.append("  fmv.x.w t1, f0\n");
        }
        else if (tipoDestino.equals("ENTERO")) {
            text.append("  fmv.w.x f0, t0\n");
            text.append("  fcvt.w.s t1, f0, rtz\n");
        }
        else if (tipoDestino.equals("CARACTER")) {
            text.append("  andi t1, t0, 255\n");
        }
        else {
            text.append("  mv t1, t0\n");
        }

        traductor.guardarEnDestino(destino, "t1");
    }
}