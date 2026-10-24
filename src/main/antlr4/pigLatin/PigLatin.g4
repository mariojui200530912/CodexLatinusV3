grammar PigLatin;

// ======================================================
// REGLAS SINTÁCTICAS (PARSER)
// ======================================================

programa: importacion* seccionVariables? seccionPrincipal EOF;

importacion: IMPORT ID (PUNTO ID)*; // Reconoce 'import banco.Cuenta.z'

seccionVariables: VARIABILES_MAYOR declaracion*;

// --- DECLARACIONES FASE 2 ---
declaracion: ESTO ID DOSPUNTOS tipoDato expresion PUNTOCOMA                                                   # DeclNormal
           | ESTO ID DOSPUNTOS NOVUS tipoDato PAREN_A argumentos? PAREN_C DOSPUNTOS tipoDato PUNTOCOMA        # DeclObjetoNovus
           | ESTO ID DOSPUNTOS NULL_LIT DOSPUNTOS tipoDato PUNTOCOMA                                          # DeclObjetoNull
           | SERIES ID CORCHETE_A expresion CORCHETE_C DOSPUNTOS tipoDato (LLAVE_A argumentos? LLAVE_C)? PUNTOCOMA # DeclArreglo
           ;

seccionPrincipal: MAIOR_MAYOR instruccion* FINIS_MAIN PUNTOCOMA?;

// --- INSTRUCCIONES ---
instruccion: acceso IGUAL expresion PUNTOCOMA                                                                 # InstAsignacion
           | acceso MAS_MAS PUNTOCOMA                                                                         # InstInc
           | acceso MENOS_MENOS PUNTOCOMA                                                                     # InstDec
           | acceso PAREN_A argumentos? PAREN_C PUNTOCOMA                                                     # InstLlamada
           | acceso MENOR_MENOR PUNTOCOMA?                                                                    # InstLeerVar
           | MAYOR_MAYOR expresion (MAYOR_MAYOR expresion)* PUNTOCOMA                                         # InstImprimir
           | SI PAREN_A expresion PAREN_C LLAVE_A instruccion* LLAVE_C (ALITER (PAREN_A expresion PAREN_C)? LLAVE_A instruccion* LLAVE_C)* FINIS PUNTOCOMA # InstSi
           | DUM PAREN_A expresion PAREN_C LLAVE_A instruccion* LLAVE_C FINIS PUNTOCOMA                       # InstDum
           | FACERE LLAVE_A instruccion* LLAVE_C DUM PAREN_A expresion PAREN_C PUNTOCOMA                      # InstFacere
           | PER PAREN_A (ESTO ID DOSPUNTOS tipoDato expresion | acceso IGUAL expresion) PUNTOCOMA expresion PUNTOCOMA (acceso MAS_MAS | acceso MENOS_MENOS | acceso IGUAL expresion) PAREN_C LLAVE_A instruccion* LLAVE_C FINIS PUNTOCOMA # InstPer
           | INTERRUMPE PUNTOCOMA                                                                             # InstInterrumpe
           | PERGE PUNTOCOMA                                                                                  # InstPerge
           ;

acceso: ID (PUNTO ID | CORCHETE_A expresion CORCHETE_C)*;

tipoDato: NUMERUS | DECIMALIS | TEXTUM | BOOL | CARACTER | ID;

argumentos: expresion (COMA expresion)*;

// --- EXPRESIONES ---
expresion: PAREN_A expresion PAREN_C                                 # ExprAgrupacion
         | NOT expresion                                             # ExprNot
         | expresion (MULT | DIV) expresion                          # ExprMultDiv
         | expresion (MAS | MENOS) expresion                         # ExprSumaResta
         | expresion (MAYOR | MENOR | MAYOR_IG | MENOR_IG) expresion # ExprRelacional
         | expresion (IGUAL_IGUAL | NOT_IGUAL) expresion             # ExprIgualdad
         | expresion AND expresion                                   # ExprAnd
         | expresion OR expresion                                    # ExprOr
         | ENTERO                                                    # ExprEntero
         | DECIMAL_LIT                                               # ExprDecimal
         | CADENA                                                    # ExprCadena
         | CARACTER_LIT                                              # ExprCaracter
         | VERUM                                                     # ExprVerum
         | FALSUS                                                    # ExprFalsus
         | NULL_LIT                                                  # ExprNull
         | NOVUS tipoDato PAREN_A argumentos? PAREN_C                # ExprNovus     // Para uso en expresiones regulares
         | acceso PAREN_A argumentos? PAREN_C                        # ExprLlamadaMetodo
         | acceso                                                    # ExprAccesoVariable
         | LLAVE_A argumentos? LLAVE_C                               # ExprInstanciaStruct
         ;

// ======================================================
// TOKENS (LEXER)
// ======================================================

IMPORT           : 'import';
VARIABILES_MAYOR : 'VARIABILES>';
MAIOR_MAYOR      : 'MAIOR>';
FINIS_MAIN       : 'FINIS;';
ESTO             : 'esto';
SERIES           : 'series';
NOVUS            : 'novus';
NULL_LIT         : 'null';
SI               : 'si';
ALITER           : 'aliter';
DUM              : 'dum';
FACERE           : 'facere';
PER              : 'per';
INTERRUMPE       : 'interrumpe';
PERGE            : 'perge';
FINIS            : 'finis';

NUMERUS          : 'numerus';
DECIMALIS        : 'decimalis';
TEXTUM           : 'textum';
BOOL             : 'bool';
CARACTER         : 'caracter';
VERUM            : 'verum';
FALSUS           : 'falsus';

MAYOR_MAYOR : '>>';
MENOR_MENOR : '<<';

DOSPUNTOS   : ':';
IGUAL       : '=';
COMA        : ',';
PAREN_A     : '(';
PAREN_C     : ')';
CORCHETE_A  : '[';
CORCHETE_C  : ']';
LLAVE_A     : '{';
LLAVE_C     : '}';
PUNTOCOMA   : ';';
PUNTO       : '.';

MAS_MAS     : '++';
MENOS_MENOS : '--';
MAS         : '+';
MENOS       : '-';
MULT        : '*';
DIV         : '/';
MAYOR       : '>';
MENOR       : '<';
MAYOR_IG    : '>=';
MENOR_IG    : '<=';
IGUAL_IGUAL : '==';
NOT_IGUAL   : '!=';
AND         : '&&';
OR          : '||';
NOT         : '!';

ID          : [a-zA-Z_áéíóúÁÉÍÓÚñÑ][a-zA-Z0-9_áéíóúÁÉÍÓÚñÑ]*;
ENTERO      : [0-9]+;
DECIMAL_LIT : [0-9]+ '.' [0-9]+;

CADENA           : '"' .*? '"';
CARACTER_LIT     : '\'' . '\'';

// Ignorar saltos de línea y espacios automáticamente
WS               : [ \t\r\n]+ -> skip;
COMENTARIO_LINEA : '//' ~[\r\n]* -> skip;
COMENTARIO_BLOQUE: '/*' .*? '*/' -> skip;