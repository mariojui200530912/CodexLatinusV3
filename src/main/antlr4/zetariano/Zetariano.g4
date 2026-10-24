grammar Zetariano;

programa: definicionClase+ EOF;

definicionClase: modificadorAcceso? CLASS ID (EXTENDS ID)? LLAVE_A miembroClase* LLAVE_C;

miembroClase: declaracionAtributo
            | constructor
            | definicionMetodo
            ;

modificadorAcceso: PUBLIC | PRIVATE | PROTECTED;

tipoDato: INT | DOUBLE | FLOAT | STRING | CHAR | BOOLEAN | ID;

declaracionAtributo: modificadorAcceso? tipoDato (CORCHETE_A CORCHETE_C)? ID PUNTOCOMA;

constructor: modificadorAcceso? ID PAREN_A parametros? PAREN_C bloque;

definicionMetodo: OVERRIDE? modificadorAcceso? (tipoDato | VOID) ID PAREN_A parametros? PAREN_C bloque;

parametros: parametro (COMA parametro)*;
parametro: tipoDato ID;

bloque: LLAVE_A instruccion* LLAVE_C;

instruccion: bloque
           | declaracionLocal PUNTOCOMA
           | asignacionOMetodo PUNTOCOMA
           | ifStmt
           | forStmt
           | RETURN expresion? PUNTOCOMA
           | PRINTLN PAREN_A expresion PAREN_C PUNTOCOMA
           ;

declaracionLocal: tipoDato ID IGUAL expresion;

asignacionOMetodo: acceso (IGUAL | MAS_IGUAL | MENOS_IGUAL) expresion  # InstAsignacion
                 | acceso MAS_MAS                                      # InstIncremento
                 | acceso MENOS_MENOS                                  # InstDecremento
                 | acceso PAREN_A argumentos? PAREN_C                  # InstLlamada
                 ;

ifStmt: IF PAREN_A expresion PAREN_C instruccion (ELSE instruccion)?;

forStmt: FOR PAREN_A (declaracionLocal | asignacionOMetodo)? PUNTOCOMA expresion PUNTOCOMA asignacionOMetodo PAREN_C instruccion;

argumentos: expresion (COMA expresion)*;

acceso: (THIS PUNTO)? ID (CORCHETE_A expresion CORCHETE_C)* (PUNTO ID (CORCHETE_A expresion CORCHETE_C)*)*;

expresion: PAREN_A expresion PAREN_C                                 # ExprAgrupacion
         | NEW tipoDato CORCHETE_A expresion CORCHETE_C              # ExprInstanciaArreglo
         | NEW ID PAREN_A argumentos? PAREN_C                        # ExprInstanciaObjeto
         | NOT expresion                                             # ExprNot
         | expresion (MULT | DIV) expresion                          # ExprMultDiv
         | expresion (MAS | MENOS) expresion                         # ExprSumaResta
         | expresion (MAYOR | MENOR | MAYOR_IG | MENOR_IG) expresion # ExprRelacional
         | expresion (IGUAL_IGUAL | NOT_IGUAL) expresion             # ExprIgualdad
         | expresion AND expresion                                   # ExprAnd
         | expresion OR expresion                                    # ExprOr
         | acceso (PAREN_A argumentos? PAREN_C)?                     # ExprAccesoOlamada
         | ENTERO_LITERAL                                            # ExprEntero
         | DOUBLE_LITERAL                                            # ExprDouble
         | CADENA                                                    # ExprCadena
         | TRUE                                                      # ExprTrue
         | FALSE                                                     # ExprFalse
         | NULL_LITERAL                                              # ExprNull
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
NEW       : 'new';
THIS      : 'this';
PRINTLN   : 'println';
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

// Operadores
IGUAL       : '=';
MAS_IGUAL   : '+=';
MENOS_IGUAL : '-=';
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

ID             : [a-zA-Z_$] [a-zA-Z0-9_$]*;
ENTERO_LITERAL : [0-9]+;
DOUBLE_LITERAL : [0-9]+ '.' [0-9]+;
CADENA         : '"' .*? '"';

WS : [ \t\r\n]+ -> skip;
COMENTARIO_LINEA : '//' ~[\r\n]* -> skip;
COMENTARIO_BLOQUE: '/*' .*? '*/' -> skip;