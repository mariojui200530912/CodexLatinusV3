package semantico;

public class ValidadorTipos {

    private static final TipoDato[][] matrizSuma = {
            {TipoDato.ENTERO, TipoDato.DECIMAL, TipoDato.ERROR, TipoDato.ENTERO, TipoDato.CADENA},
            {TipoDato.DECIMAL, TipoDato.DECIMAL, TipoDato.ERROR, TipoDato.DECIMAL, TipoDato.CADENA},
            {TipoDato.ERROR, TipoDato.ERROR, TipoDato.ERROR, TipoDato.ERROR, TipoDato.CADENA},
            {TipoDato.ENTERO, TipoDato.DECIMAL, TipoDato.ERROR, TipoDato.CADENA, TipoDato.CADENA},
            {TipoDato.CADENA, TipoDato.CADENA, TipoDato.CADENA, TipoDato.CADENA, TipoDato.CADENA}
    };

    private static final TipoDato[][] matrizAritmetica = {
            {TipoDato.ENTERO,  TipoDato.DECIMAL, TipoDato.ERROR, TipoDato.ENTERO, TipoDato.ERROR},
            {TipoDato.DECIMAL, TipoDato.DECIMAL, TipoDato.ERROR, TipoDato.DECIMAL, TipoDato.ERROR},
            {TipoDato.ERROR,   TipoDato.ERROR,   TipoDato.ERROR, TipoDato.ERROR,  TipoDato.ERROR},
            {TipoDato.ENTERO,  TipoDato.DECIMAL, TipoDato.ERROR, TipoDato.ERROR,  TipoDato.ERROR},
            {TipoDato.ERROR,   TipoDato.ERROR,   TipoDato.ERROR, TipoDato.ERROR,  TipoDato.ERROR}
    };

    public static TipoDato operarSuma(TipoDato izq, TipoDato der) {
        if (izq == TipoDato.ERROR || der == TipoDato.ERROR) return TipoDato.ERROR;
        if (izq == TipoDato.CADENA || der == TipoDato.CADENA) {
            return TipoDato.CADENA;
        }
        if (izq.ordinal() >= 5 || der.ordinal() >= 5) return TipoDato.ERROR;
        return matrizSuma[izq.ordinal()][der.ordinal()];
    }

    public static TipoDato operarAritmetica(TipoDato izq, TipoDato der) {
        if (izq == TipoDato.ERROR || der == TipoDato.ERROR) return TipoDato.ERROR;
        if (izq.ordinal() >= 5 || der.ordinal() >= 5) return TipoDato.ERROR;
        return matrizAritmetica[izq.ordinal()][der.ordinal()];
    }

    // Relacional estricto (>, <, >=, <=) - Solo para números
    public static TipoDato operarRelacional(TipoDato izq, TipoDato der) {
        if (izq == TipoDato.ERROR || der == TipoDato.ERROR) return TipoDato.ERROR;

        if ((izq == TipoDato.ENTERO || izq == TipoDato.DECIMAL || izq == TipoDato.CARACTER) &&
                (der == TipoDato.ENTERO || der == TipoDato.DECIMAL || der == TipoDato.CARACTER)) {
            return TipoDato.BOOLEANO;
        }

        if (izq == TipoDato.OBJETO || der == TipoDato.OBJETO) return TipoDato.BOOLEANO;
        return TipoDato.ERROR;
    }

    public static TipoDato operarIgualdad(TipoDato izq, TipoDato der) {
        if (izq == TipoDato.ERROR || der == TipoDato.ERROR) return TipoDato.ERROR;

        if (izq == der) return TipoDato.BOOLEANO;

        if ((izq == TipoDato.ENTERO || izq == TipoDato.DECIMAL || izq == TipoDato.CARACTER) &&
                (der == TipoDato.ENTERO || der == TipoDato.DECIMAL || der == TipoDato.CARACTER)) {
            return TipoDato.BOOLEANO;
        }

        if ((izq == TipoDato.OBJETO && der == TipoDato.NULO) ||
                (izq == TipoDato.NULO && der == TipoDato.OBJETO) ||
                (izq == TipoDato.OBJETO && der == TipoDato.OBJETO)) {
            return TipoDato.BOOLEANO;
        }

        return TipoDato.ERROR;
    }

    public static TipoDato parsearTipo(String tipoString) {
        if (tipoString == null) return TipoDato.ERROR;
        switch (tipoString.toLowerCase()) {
            case "entero": case "int": case "numerus":
                return TipoDato.ENTERO;
            case "flotante": case "double": case "decimalis":
                return TipoDato.DECIMAL;
            case "bool": case "boolean": case "verum": case "falsus": case "booleano":
                return TipoDato.BOOLEANO;
            case "caracter": case "char": case "littera":
                return TipoDato.CARACTER;
            case "cadena": case "string": case "textum":
                return TipoDato.CADENA;
            case "void":
                return TipoDato.VOID;
            default:
                return TipoDato.OBJETO; // Objetos y arreglos se manejan con logica aparte
        }
    }

    // MATRIZ ASIGNACION
    private static final boolean[][] matrizAsignacion = {
            /* ORIGEN ->     ENTERO   DECIMAL  BOOLEANO CARACTER CADENA */
            /* D: ENTERO */   {true,    false,   false,   true,    false},
            /* D: DECIMAL */  {true,    true,    false,   true,    false},
            /* D: BOOLEANO */ {false,   false,   true,    false,   false},
            /* D: CARACTER */ {false,   false,   false,   true,    false},
            /* D: CADENA */   {false,   false,   false,   false,   true}
    };

    public static boolean validarAsignacion(TipoDato destino, TipoDato origen) {
        if (destino == TipoDato.ERROR || origen == TipoDato.ERROR) return false;

        if (destino == TipoDato.OBJETO && origen == TipoDato.NULO) return true;
        if (destino == TipoDato.OBJETO && origen == TipoDato.OBJETO) return true;

        if (destino == TipoDato.OBJETO && origen == TipoDato.DECIMAL) return true;

        if (destino.ordinal() >= 5 || origen.ordinal() >= 5) return false;

        return matrizAsignacion[destino.ordinal()][origen.ordinal()];
    }

    // JERARQUIA DE PESOS
    public static int obtenerPeso(TipoDato tipo) {
        switch (tipo) {
            case BOOLEANO: return 1;
            case CARACTER: return 2;
            case ENTERO:   return 3;
            case DECIMAL:  return 4;
            case CADENA:   return 5;
            default:       return 0; // Tipos de error o estructuras/objetos
        }
    }

    public static int obtenerPeso(String tipoString) {
        return obtenerPeso(parsearTipo(tipoString));
    }
}
