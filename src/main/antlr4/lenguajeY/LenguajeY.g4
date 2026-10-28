grammar LenguajeY;

// ======================================================
// INYECCION CODIGO JAVA EN EL LEXER PARA INDENTACION
// ======================================================
@lexer::header {
    import java.util.Stack;
    import java.util.LinkedList;
    import java.util.Queue;
}

@lexer::members {
    private Stack<Integer> indents = new Stack<>();
    private Queue<Token> pendingTokens = new LinkedList<>();

    {
        indents.push(0);
    }

    @Override
    public void reset() {
        super.reset();
        pendingTokens.clear();
        indents.clear();
        indents.push(0);
    }

    @Override
    public Token nextToken() {
        if (!pendingTokens.isEmpty()) {
            return pendingTokens.poll();
        }

        Token t = super.nextToken();

        if (t.getType() == Token.EOF) {
            while (indents.size() > 1) {
                indents.pop();
                pendingTokens.add(crearToken(DEDENT, "<DEDENT>"));
            }
            pendingTokens.add(t);
            return pendingTokens.poll();
        }
        return t;
    }

    private Token crearToken(int tipo, String texto) {
            return _factory.create(new Pair<>(this, _input), tipo, texto, _channel, _tokenStartCharIndex, _tokenStartCharIndex - 1, _tokenStartLine, _tokenStartCharPositionInLine);
    }

    private void procesarIndentacion(int espacios) {
        int nivelActual = indents.peek();
        if (espacios > nivelActual) {
            indents.push(espacios);
            pendingTokens.add(crearToken(INDENT, "<INDENT>"));
        } else if (espacios < nivelActual) {
            while (indents.size() > 1 && espacios < indents.peek()) {
                indents.pop();
                pendingTokens.add(crearToken(DEDENT, "<DEDENT>"));
            }
        }
    }
}

// ======================================================
// REGLAS SINTACTICAS (PARSER)
// ======================================================

programa: NEWLINE* seccionEstructuras? NEWLINE* seccionFunciones? NEWLINE* EOF;

// --- ESTRUCTURAS ---
seccionEstructuras: DEF_ESTRUCTURAS NEWLINE (estructuraDef | NEWLINE)*;
estructuraDef: ESTRUCTURA ID DOSPUNTOS NEWLINE INDENT (atributo | NEWLINE)* DEDENT;
atributo: tipoDato ID (CORCHETE_A ENTERO CORCHETE_C)* NEWLINE; // Soporte multidimensional

// --- FUNCIONES ---
seccionFunciones: DEF_FUNCIONES NEWLINE (funcionDef | NEWLINE)*;

funcionDef: DEFINIR FUNCION? ID PAREN_A parametros? PAREN_C (FLECHA tipoDato)? DOSPUNTOS NEWLINE INDENT (instruccion | NEWLINE)* DEDENT;
parametros: parametro (COMA parametro)*;

parametro: (CORCHETE_A CORCHETE_C | LLAVE_A LLAVE_C)? tipoDato ID;

// --- TIPOS DE DATO ---
tipoDato: T_ENTERO | T_CADENA | T_FLOTANTE | T_CARACTER | T_BOOL | ID;

// --- INSTRUCCIONES ---
instruccion: declaracionLocal PUNTOCOMA? NEWLINE                                    # InstDeclaracion
           | acceso IGUAL expresion PUNTOCOMA? NEWLINE                              # InstAsignacion
           | acceso MAS_MAS PUNTOCOMA? NEWLINE                                      # InstInc
           | acceso MENOS_MENOS PUNTOCOMA? NEWLINE                                  # InstDec
           | ID PAREN_A argumentos? PAREN_C PUNTOCOMA? NEWLINE                      # InstLlamada
           | RETORNAR expresion? PUNTOCOMA? NEWLINE                                 # InstRetorno
           | ROMPER PUNTOCOMA? NEWLINE                                              # InstRomper
           | CONTINUAR PUNTOCOMA? NEWLINE                                           # InstContinuar
           | IMPRIMIR_RES PAREN_A argumentos? PAREN_C PUNTOCOMA? NEWLINE            # InstImprimir
           | ifStmt                                                                 # InstIf
           | switchStmt                                                             # InstSwitch
           | forStmt                                                                # InstFor
           | whileStmt                                                              # InstWhile
           | doWhileStmt                                                            # InstDoWhile
           ;

declaracionLocal: tipoDato ID (CORCHETE_A ENTERO CORCHETE_C)* (IGUAL expresion)?;

acceso: ID (PUNTO ID | CORCHETE_A expresion CORCHETE_C)*;

ifStmt: SI PAREN_A expresion PAREN_C ENTONCES NEWLINE INDENT (instruccion | NEWLINE)* DEDENT
        (SINO PAREN_A expresion PAREN_C ENTONCES NEWLINE INDENT (instruccion | NEWLINE)* DEDENT)*
        (CONTRARIO NEWLINE INDENT (instruccion | NEWLINE)* DEDENT)?;

switchStmt: ELEGIR PAREN_A expresion PAREN_C LLAVE_A NEWLINE? (casoStmt | defaultStmt | NEWLINE)* LLAVE_C NEWLINE?;
casoStmt: CASO expresion DOSPUNTOS NEWLINE INDENT? (instruccion | NEWLINE)* DEDENT?;
defaultStmt: SIEMPRE DOSPUNTOS NEWLINE INDENT? (instruccion | NEWLINE)* DEDENT?;

forStmt: PARA PAREN_A (declaracionLocal | acceso IGUAL expresion) PUNTOCOMA expresion PUNTOCOMA (acceso MAS_MAS | acceso MENOS_MENOS | acceso IGUAL expresion) PAREN_C DOSPUNTOS NEWLINE INDENT (instruccion | NEWLINE)* DEDENT;

whileStmt: MIENTRAS PAREN_A expresion PAREN_C HACER NEWLINE INDENT (instruccion | NEWLINE)* DEDENT;

doWhileStmt: HACER DOSPUNTOS NEWLINE INDENT (instruccion | NEWLINE)* DEDENT MIENTRAS PAREN_A expresion PAREN_C NEWLINE?;

argumentos: expresion (COMA expresion)*;

// --- EXPRESIONES ---
expresion: PAREN_A expresion PAREN_C                                 # ExprParentesis
         | NOT expresion                                             # ExprNot
         | expresion (MULT | DIV) expresion                          # ExprMultDiv
         | expresion (MAS | MENOS) expresion                         # ExprSumaResta
         | expresion (MAYOR | MENOR | MAYOR_IG | MENOR_IG) expresion # ExprRelacional
         | expresion (IGUAL_IGUAL | NOT_IGUAL) expresion             # ExprIgualdad
         | expresion AND expresion                                   # ExprAnd
         | expresion OR expresion                                    # ExprOr
         | ENTERO                                                    # ExprEntero
         | FLOTANTE_LITERAL                                          # ExprFlotante
         | CADENA                                                    # ExprCadena
         | CARACTER_LITERAL                                          # ExprCaracter
         | VERDADERO                                                 # ExprVerdadero
         | FALSO                                                     # ExprFalso
         | LEER_RES PAREN_A PAREN_C                                  # ExprLeer
         | ID PAREN_A argumentos? PAREN_C                            # ExprLlamada
         | acceso                                                    # ExprAcceso
         | LLAVE_A argumentos? LLAVE_C                               # ExprInstanciaEstructura
         ;

// ======================================================
// TOKENS (LEXER)
// ======================================================

DEF_ESTRUCTURAS : '%estructuras';
DEF_FUNCIONES   : '%funciones';
ESTRUCTURA      : 'estructura';
DEFINIR         : 'definir';
FUNCION         : 'funcion'; // CORRECCIÓN: Token faltante
RETORNAR        : 'retornar';
ROMPER          : 'romper';
SI              : 'si';
ENTONCES        : 'entonces';
SINO            : 'sino';
CONTRARIO       : 'contrario';
ELEGIR          : 'elegir';
CASO            : 'caso';
SIEMPRE         : 'siempre';
PARA            : 'para';
MIENTRAS        : 'mientras';
HACER           : 'hacer';
CONTINUAR       : 'continuar';
VERDADERO       : 'verdadero';
FALSO           : 'falso';
IMPRIMIR_RES    : 'imprimir';
LEER_RES        : 'leer';

T_ENTERO   : 'entero';
T_CADENA   : 'cadena';
T_FLOTANTE : 'flotante';
T_CARACTER : 'caracter';
T_BOOL     : 'bool';

DOSPUNTOS : ':';
FLECHA    : '->';
IGUAL     : '=';
COMA      : ',';
PAREN_A   : '(';
PAREN_C   : ')';
CORCHETE_A: '[';
CORCHETE_C: ']';
LLAVE_A   : '{';
LLAVE_C   : '}';
PUNTOCOMA : ';';
PUNTO     : '.';

MAS_MAS    : '++';
MENOS_MENOS: '--';
MAS        : '+';
MENOS      : '-';
MULT       : '*';
DIV        : '/';
MAYOR      : '>';
MENOR      : '<';
MAYOR_IG   : '>=';
MENOR_IG   : '<=';
IGUAL_IGUAL: '==';
NOT_IGUAL  : '!=';
AND        : '&&';
OR         : '||';
NOT        : '!';

ID               : [a-zA-Z_áéíóúÁÉÍÓÚñÑ][a-zA-Z0-9_áéíóúÁÉÍÓÚñÑ]*;
ENTERO           : [0-9]+;
FLOTANTE_LITERAL : [0-9]+ '.' [0-9]+;
CADENA           : '"' .*? '"';
CARACTER_LITERAL : '\'' . '\'';

COMENTARIO_LINEA : '//' ~[\r\n]* -> skip;
COMENTARIO_BLOQUE: '/*' .*? '*/' -> skip;

INDENT : '<INDENT>';
DEDENT : '<DEDENT>';

NEWLINE : ('\r'? '\n')+ [ \t]* {
    String texto = getText();
    int lastNewline = texto.lastIndexOf('\n');
    String indentacion = texto.substring(lastNewline + 1);

    int espacios = 0;
    for (char c : indentacion.toCharArray()) {
        if (c == '\t') espacios += 4;
        else if (c == ' ') espacios += 1;
    }

    procesarIndentacion(espacios);
};

WS : [ \t]+ -> skip;