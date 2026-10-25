package gui;

import gramaticas.pigLatin.PigLatinLexer;
import gramaticas.y.LenguajeYLexer;
import gramaticas.zetariano.ZetarianoLexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.fxmisc.richtext.model.StyleSpans;
import org.fxmisc.richtext.model.StyleSpansBuilder;

import java.util.Collection;
import java.util.Collections;

public class ResaltadorSintactico {

    public static StyleSpans<Collection<String>> calcularResaltado(String texto, String lenguaje) {
        StyleSpansBuilder<Collection<String>> spansBuilder = new StyleSpansBuilder<>();

        if (texto.isEmpty()) {
            spansBuilder.add(Collections.emptyList(), 0);
            return spansBuilder.create();
        }

        CharStream input = CharStreams.fromString(texto);
        Lexer lexer;

        switch (lenguaje.toLowerCase()) {
            case "piglatin": lexer = new PigLatinLexer(input); break;
            case "y": lexer = new LenguajeYLexer(input); break;
            case "zetariano": default: lexer = new ZetarianoLexer(input); break;
        }

        lexer.removeErrorListeners();
        Token token;
        int ultimoFin = 0;

        while ((token = lexer.nextToken()).getType() != Token.EOF) {
            int inicioToken = token.getStartIndex();
            int finToken = token.getStopIndex() + 1;

            if (inicioToken > ultimoFin) {
                spansBuilder.add(Collections.singleton("default"), inicioToken - ultimoFin);
            }

            String claseCss = obtenerClaseCss(token.getType(), lenguaje);
            spansBuilder.add(Collections.singleton(claseCss), finToken - inicioToken);

            ultimoFin = finToken;
        }

        if (ultimoFin < texto.length()) {
            spansBuilder.add(Collections.singleton("default"), texto.length() - ultimoFin);
        }

        return spansBuilder.create();
    }

    private static String obtenerClaseCss(int tipoToken, String lenguaje) {
        if (lenguaje.equals("zetariano")) {
            // Ajusta estos tokens a tu ZetarianoLexer real
            if (tipoToken == ZetarianoLexer.PUBLIC || tipoToken == ZetarianoLexer.CLASS ||
                    tipoToken == ZetarianoLexer.IF || tipoToken == ZetarianoLexer.ELSE ||
                    tipoToken == ZetarianoLexer.WHILE || tipoToken == ZetarianoLexer.FOR ||
                    tipoToken == ZetarianoLexer.RETURN || tipoToken == ZetarianoLexer.NEW ||
                    tipoToken == ZetarianoLexer.INT || tipoToken == ZetarianoLexer.DOUBLE ||
                    tipoToken == ZetarianoLexer.BOOLEAN || tipoToken == ZetarianoLexer.STRING) {
                return "keyword";
            } else if (tipoToken == ZetarianoLexer.CADENA || tipoToken == ZetarianoLexer.CARACTER_LITERAL) {
                return "string";
            } else if (tipoToken == ZetarianoLexer.ENTERO || tipoToken == ZetarianoLexer.FLOTANTE_LITERAL) {
                return "number";
            } else if (tipoToken == ZetarianoLexer.COMENTARIO_LINEA || tipoToken == ZetarianoLexer.COMENTARIO_BLOQUE) {
                return "comment";
            }
        } else if (lenguaje.equals("y")) {
            if (tipoToken == LenguajeYLexer.DEF_ESTRUCTURAS || tipoToken == LenguajeYLexer.DEF_FUNCIONES ||
                    tipoToken == LenguajeYLexer.ESTRUCTURA || tipoToken == LenguajeYLexer.DEFINIR ||
                    tipoToken == LenguajeYLexer.SI || tipoToken == LenguajeYLexer.SINO ||
                    tipoToken == LenguajeYLexer.CONTRARIO || tipoToken == LenguajeYLexer.MIENTRAS ||
                    tipoToken == LenguajeYLexer.PARA || tipoToken == LenguajeYLexer.T_ENTERO ||
                    tipoToken == LenguajeYLexer.T_CADENA || tipoToken == LenguajeYLexer.RETORNAR ||
                    tipoToken == LenguajeYLexer.IMPRIMIR_RES) {
                return "keyword";
            } else if (tipoToken == LenguajeYLexer.CADENA || tipoToken == LenguajeYLexer.CARACTER_LITERAL) {
                return "string";
            } else if (tipoToken == LenguajeYLexer.ENTERO || tipoToken == LenguajeYLexer.FLOTANTE_LITERAL) {
                return "number";
            } else if (tipoToken == LenguajeYLexer.COMENTARIO_LINEA || tipoToken == LenguajeYLexer.COMENTARIO_BLOQUE) {
                return "comment";
            }
        } else if (lenguaje.equals("piglatin")) {
            if (tipoToken == PigLatinLexer.IMPORT || tipoToken == PigLatinLexer.VARIABILES_MAYOR ||
                    tipoToken == PigLatinLexer.MAIOR_MAYOR || tipoToken == PigLatinLexer.ESTO ||
                    tipoToken == PigLatinLexer.SERIES || tipoToken == PigLatinLexer.NOVUS ||
                    tipoToken == PigLatinLexer.NULL_LIT || tipoToken == PigLatinLexer.SI ||
                    tipoToken == PigLatinLexer.ALITER || tipoToken == PigLatinLexer.DUM ||
                    tipoToken == PigLatinLexer.FACERE || tipoToken == PigLatinLexer.PER ||
                    tipoToken == PigLatinLexer.NUMERUS || tipoToken == PigLatinLexer.DECIMALIS ||
                    tipoToken == PigLatinLexer.TEXTUM || tipoToken == PigLatinLexer.BOOL) {
                return "keyword";
            } else if (tipoToken == PigLatinLexer.CADENA || tipoToken == PigLatinLexer.CARACTER_LIT) {
                return "string";
            } else if (tipoToken == PigLatinLexer.ENTERO || tipoToken == PigLatinLexer.DECIMAL_LIT) {
                return "number";
            } else if (tipoToken == PigLatinLexer.COMENTARIO_LINEA || tipoToken == PigLatinLexer.COMENTARIO_BLOQUE) {
                return "comment";
            }
        }
        return "default";
    }
}