package cuartetas;

import generador.TraductorRiscV;

public abstract class Cuarteta {
    public abstract String generarCodigo();

    public abstract void traducirRiscV(StringBuilder text, generador.TraductorRiscV traductor);
}