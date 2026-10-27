grammar Zetariano;

programa: definicionClase+ EOF;

definicionClase: modificadorAcceso? CLASS ID (EXTENDS ID)? LLAVE_A miembroClase* LLAVE_C;

miembroClase: declaracionAtributo
            | constructor
            | definicionMetodo
            ;

modificadorAcceso: PUBLIC | PRIVATE | PROTECTED;

tipoDato: INT | DOUBLE | FLOAT | STRING | CHAR | BOOLEAN | ID;

tipoEstructura: tipoDato (CORCHETE_A CORCHETE_C)*;

declaracionAtributo: modificadorAcceso? tipoEstructura ID (IGUAL expresion)? PUNTOCOMA;

constructor: modificadorAcceso? ID PAREN_A parametros? PAREN_C bloque;

definicionMetodo: OVERRIDE? modificadorAcceso? (tipoEstructura | VOID) ID PAREN_A parametros? PAREN_C bloque;

parametros: parametro (COMA parametro)*;
parametro: tipoEstructura ID;

bloque: LLAVE_A instruccion* LLAVE_C;

instruccion: bloque
           | declaracionLocal PUNTOCOMA
           | asignacionOMetodo PUNTOCOMA
           | ifStmt
           | forStmt
           | whileStmt
           | doWhileStmt
           | switchStmt
           | BREAK PUNTOCOMA
           | CONTINUE PUNTOCOMA
           | RETURN expresion? PUNTOCOMA
           | PRINTLN PAREN_A expresion PAREN_C PUNTOCOMA
           | PRINT PAREN_A expresion PAREN_C PUNTOCOMA
           | READLN PAREN_A PAREN_C PUNTOCOMA
           ;

declaracionLocal: tipoEstructura ID (IGUAL expresion)?;

asignacionOMetodo: acceso (IGUAL | MAS_IGUAL | MENOS_IGUAL | MULT_IGUAL) expresion  # InstAsignacion
                 | acceso MAS_MAS                                                   # InstIncremento
                 | acceso MENOS_MENOS                                               # InstDecremento
                 | acceso PAREN_A argumentos? PAREN_C                               # InstLlamada
                 ;

ifStmt: IF PAREN_A expresion PAREN_C instruccion (ELSE instruccion)?;

forStmt: FOR PAREN_A (declaracionLocal | asignacionOMetodo)? PUNTOCOMA expresion? PUNTOCOMA asignacionOMetodo? PAREN_C instruccion;

whileStmt: WHILE PAREN_A expresion PAREN_C instruccion;

doWhileStmt: DO instruccion WHILE PAREN_A expresion PAREN_C PUNTOCOMA;

switchStmt: SWITCH PAREN_A expresion PAREN_C LLAVE_A caseCode* defaultCode? LLAVE_C;
caseCode: CASE expresion DOS_PUNTOS instruccion*;
defaultCode: DEFAULT DOS_PUNTOS instruccion*;

argumentos: expresion (COMA expresion)*;

acceso: (THIS PUNTO)? ID (CORCHETE_A expresion CORCHETE_C)* (PUNTO ID (CORCHETE_A expresion CORCHETE_C)*)*;

expresion: PAREN_A expresion PAREN_C                                          # ExprAgrupacion
         | NEW tipoDato (CORCHETE_A expresion CORCHETE_C)+ (CORCHETE_A CORCHETE_C)* # ExprInstanciaArreglo
         | NEW ID PAREN_A argumentos? PAREN_C                                 # ExprInstanciaObjeto
         | LLAVE_A (expresion (COMA expresion)*)? LLAVE_C                     # ExprArregloLiteral
         | READLN PAREN_A PAREN_C                                             # ExprReadln
         | NOT expresion                                                      # ExprNot
         | expresion (MULT | DIV | MODULO) expresion                          # ExprMultDivMod
         | expresion (MAS | MENOS) expresion                                  # ExprSumaResta
         | expresion (MAYOR | MENOR | MAYOR_IG | MENOR_IG) expresion          # ExprRelacional
         | expresion (IGUAL_IGUAL | NOT_IGUAL) expresion                      # ExprIgualdad
         | expresion AND expresion                                            # ExprAnd
         | expresion OR expresion                                             # ExprOr
         | <assoc=right> expresion INTERROGACION expresion DOS_PUNTOS expresion # ExprTernario
         | acceso (PAREN_A argumentos? PAREN_C)?                              # ExprAccesoOlamada
         | ENTERO_LITERAL                                                     # ExprEntero
         | DOUBLE_LITERAL                                                     # ExprDouble
         | CADENA                                                             # ExprCadena
         | CARACTER_LITERAL                                                   # ExprCaracter
         | TRUE                                                               # ExprTrue
         | FALSE                                                              # ExprFalse
         | NULL_LITERAL                                                       # ExprNull
         ;

// Palabras reservadas
PUBLIC    : 'public';
PRIVATE   : 'private';
PROTECTED : 'protected';
CLASS     : 'class';
EXTENDS   : 'extends';
OVERRIDE  : '@Override';
VOID      : 'void';
RETURN    : 'return';
IF        : 'if';
ELSE      : 'else';
FOR       : 'for';
WHILE     : 'while';
DO        : 'do';
SWITCH    : 'switch';
CASE      : 'case';
DEFAULT   : 'default';
BREAK     : 'break';
CONTINUE  : 'continue';
NEW       : 'new';
THIS      : 'this';
PRINTLN   : 'println';
PRINT     : 'print';
READLN    : 'readln';
TRUE      : 'true';
FALSE     : 'false';
NULL_LITERAL : 'null';

// Tipos
INT       : 'int';
DOUBLE    : 'double';
FLOAT     : 'float';
STRING    : 'String';
CHAR      : 'char';
BOOLEAN   : 'boolean';

// Simbolos
PAREN_A   : '(';
PAREN_C   : ')';
LLAVE_A   : '{';
LLAVE_C   : '}';
CORCHETE_A: '[';
CORCHETE_C: ']';
PUNTOCOMA : ';';
PUNTO     : '.';
COMA      : ',';
DOS_PUNTOS: ':';
INTERROGACION: '?';

// Operadores
IGUAL       : '=';
MAS_IGUAL   : '+=';
MENOS_IGUAL : '-=';
MULT_IGUAL  : '*=';
MAS_MAS     : '++';
MENOS_MENOS : '--';
MAS         : '+';
MENOS       : '-';
MULT        : '*';
DIV         : '/';
MODULO      : '%';
MAYOR       : '>';
MENOR       : '<';
MAYOR_IG    : '>=';
MENOR_IG    : '<=';
IGUAL_IGUAL : '==';
NOT_IGUAL   : '!=';
AND         : '&&';
OR          : '||';
NOT         : '!';

ID               : [a-zA-Z_$] [a-zA-Z0-9_$]*;
ENTERO_LITERAL   : [0-9]+;
DOUBLE_LITERAL   : [0-9]+ '.' [0-9]+;
CADENA           : '"' .*? '"';
CARACTER_LITERAL : '\'' . '\'';

WS : [ \t\r\n]+ -> skip;
COMENTARIO_LINEA : '//' ~[\r\n]* -> skip;
COMENTARIO_BLOQUE: '/*' .*? '*/' -> skip;