package ast.zetariano;

import ast.Expresion;
import ast.Instruccion;
import ast.expresiones.*;
import ast.instrucciones.*;
import ast.instrucciones.NodoIncrementoDecremento;
import gramaticas.zetariano.ZetarianoBaseVisitor;
import gramaticas.zetariano.ZetarianoParser.*;
import semantico.TipoDato;
import semantico.ValidadorTipos;

import org.antlr.v4.runtime.tree.ParseTree;
import java.util.ArrayList;
import java.util.List;

public class ZetarianoCustomVisitor extends ZetarianoBaseVisitor<Object> {

    // --- PROGRAMA Y CLASES ---

    @Override
    public Object visitPrograma(ProgramaContext ctx) {
        List<Instruccion> clases = new ArrayList<>();
        for (DefinicionClaseContext claseCtx : ctx.definicionClase()) {
            clases.add((Instruccion) visit(claseCtx));
        }
        return clases;
    }

    @Override
    public Object visitDefinicionClase(DefinicionClaseContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        String visibilidad = (ctx.modificadorAcceso() != null) ? ctx.modificadorAcceso().getText() : "default";

        String idClase = ctx.ID(0).getText();
        String idPadre = (ctx.EXTENDS() != null) ? ctx.ID(1).getText() : null;

        List<Instruccion> instrucciones = new ArrayList<>();
        for (MiembroClaseContext miembroCtx : ctx.miembroClase()) {
            Instruccion inst = (Instruccion) visit(miembroCtx);
            if (inst != null) instrucciones.add(inst);
        }

        return new DefinicionClase(idClase, idPadre, visibilidad, instrucciones, linea, col);
    }

    @Override
    public Object visitDeclaracionAtributo(DeclaracionAtributoContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        String visibilidad = (ctx.modificadorAcceso() != null) ? ctx.modificadorAcceso().getText() : "default";

        TipoEstructuraContext tipoStructCtx = ctx.tipoEstructura();
        String tipoStr = tipoStructCtx.tipoDato().getText();
        TipoDato tipo = ValidadorTipos.parsearTipo(tipoStr);
        String tipoObjeto = (tipo == TipoDato.OBJETO) ? tipoStr : null;

        String id = ctx.ID().getText();

        // Validar si tiene corchetes para marcarlo como arreglo
        boolean esArreglo = tipoStructCtx.CORCHETE_A() != null && !tipoStructCtx.CORCHETE_A().isEmpty();

        Expresion valor = null;
        if (ctx.expresion() != null) {
            valor = (Expresion) visit(ctx.expresion());
        }

        return new DeclaracionAtributo(visibilidad, tipo, tipoObjeto, id, esArreglo, valor, linea, col);
    }

    @Override
    public Object visitConstructor(ConstructorContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        String visibilidad = (ctx.modificadorAcceso() != null) ? ctx.modificadorAcceso().getText() : "public";
        String idConstructor = ctx.ID().getText();

        List<DefinicionFuncion.ParametroFormal> parametros = new ArrayList<>();
        if (ctx.parametros() != null) {
            parametros = (List<DefinicionFuncion.ParametroFormal>) visit(ctx.parametros());
        }

        List<Instruccion> bloque = (List<Instruccion>) visit(ctx.bloque());

        return new DefinicionMetodo(idConstructor, TipoDato.VOID, null, parametros, bloque, visibilidad, linea, col);
    }

    @Override
    public Object visitDefinicionMetodo(DefinicionMetodoContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        String visibilidad = (ctx.modificadorAcceso() != null) ? ctx.modificadorAcceso().getText() : "default";

        String tipoRetornoStr = (ctx.VOID() != null) ? "void" : ctx.tipoEstructura().getText();
        TipoDato tipoRetorno = ValidadorTipos.parsearTipo(tipoRetornoStr);
        String tipoObjeto = (tipoRetorno == TipoDato.OBJETO) ? tipoRetornoStr : null;

        String idMetodo = ctx.ID().getText();

        List<DefinicionFuncion.ParametroFormal> parametros = new ArrayList<>();
        if (ctx.parametros() != null) {
            parametros = (List<DefinicionFuncion.ParametroFormal>) visit(ctx.parametros());
        }

        List<Instruccion> bloque = (List<Instruccion>) visit(ctx.bloque());

        return new DefinicionMetodo(idMetodo, tipoRetorno, tipoObjeto, parametros, bloque, visibilidad, linea, col);
    }

    // --- PARÁMETROS Y BLOQUES ---

    @Override
    public Object visitParametros(ParametrosContext ctx) {
        List<DefinicionFuncion.ParametroFormal> lista = new ArrayList<>();
        for (ParametroContext paramCtx : ctx.parametro()) {
            lista.add((DefinicionFuncion.ParametroFormal) visit(paramCtx));
        }
        return lista;
    }

    @Override
    public Object visitParametro(ParametroContext ctx) {
        String tipoStr = ctx.tipoEstructura().getText();
        TipoDato tipo = ValidadorTipos.parsearTipo(tipoStr);
        String tipoObj = (tipo == TipoDato.OBJETO) ? tipoStr : null;
        String id = ctx.ID().getText();
        return new DefinicionFuncion.ParametroFormal(tipo, tipoObj, id);
    }

    @Override
    public Object visitBloque(BloqueContext ctx) {
        List<Instruccion> instrucciones = new ArrayList<>();
        for (InstruccionContext instCtx : ctx.instruccion()) {
            Instruccion inst = (Instruccion) visit(instCtx);
            if (inst != null) instrucciones.add(inst);
        }
        return instrucciones;
    }

    // --- INSTRUCCIONES BÁSICAS Y CONTROL DE FLUJO ---

    @Override
    public Object visitInstruccion(InstruccionContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        if (ctx.PRINTLN() != null) {
            return new Imprimir((Expresion) visit(ctx.expresion()), true, linea, col);
        } else if (ctx.PRINT() != null) {
            return new Imprimir((Expresion) visit(ctx.expresion()), false, linea, col);
        } else if (ctx.RETURN() != null) {
            Expresion valor = (ctx.expresion() != null) ? (Expresion) visit(ctx.expresion()) : null;
            return new NodoRetornar(valor, linea, col);
        } else if (ctx.BREAK() != null) {
            return new NodoBreak(linea, col);
        } else if (ctx.CONTINUE() != null) {
            return new NodoContinue(linea, col);
        } else if (ctx.READLN() != null) {
            return new LlamadaFuncion("readln", new ArrayList<>(), linea, col); // readln como instrucción
        }
        return visitChildren(ctx);
    }

    @Override
    public Object visitDeclaracionLocal(DeclaracionLocalContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        String tipoStr = ctx.tipoEstructura().getText();
        TipoDato tipo = ValidadorTipos.parsearTipo(tipoStr);
        String tipoObj = (tipo == TipoDato.OBJETO) ? tipoStr : null;

        String id = ctx.ID().getText();
        Expresion valor = null;
        if (ctx.expresion() != null) {
            valor = (Expresion) visit(ctx.expresion());
        }

        return new Declaracion(id, tipo, tipoObj, valor, linea, col);
    }

    @Override
    public Object visitIfStmt(IfStmtContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        Expresion condicion = (Expresion) visit(ctx.expresion());

        List<Instruccion> bloqueVerdadero = new ArrayList<>();
        bloqueVerdadero.add((Instruccion) visit(ctx.instruccion(0)));

        List<Instruccion> bloqueFalso = new ArrayList<>();
        if (ctx.ELSE() != null) {
            bloqueFalso.add((Instruccion) visit(ctx.instruccion(1)));
        }

        return new NodoIf(condicion, bloqueVerdadero, bloqueFalso, linea, col);
    }

    @Override
    public Object visitForStmt(ForStmtContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        Instruccion inicializacion = null;
        Expresion condicion = null;
        Instruccion actualizacion = null;

        // Buscar los índices de los PUNTOCOMA para delimitar las secciones
        int primerPuntoComa = -1;
        int segundoPuntoComa = -1;
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i).getText().equals(";")) {
                if (primerPuntoComa == -1) primerPuntoComa = i;
                else segundoPuntoComa = i;
            }
        }

        // Identificar Inicialización
        if (ctx.declaracionLocal() != null) {
            inicializacion = (Instruccion) visit(ctx.declaracionLocal());
        } else if (!ctx.asignacionOMetodo().isEmpty()) {
            ParseTree posibleInit = ctx.asignacionOMetodo(0);
            if (ctx.children.indexOf(posibleInit) < primerPuntoComa) {
                inicializacion = (Instruccion) visit(posibleInit);
            }
        }

        // Identificar Condición
        if (ctx.expresion() != null) {
            condicion = (Expresion) visit(ctx.expresion());
        }

        // Identificar Actualización
        for (AsignacionOMetodoContext asigCtx : ctx.asignacionOMetodo()) {
            if (ctx.children.indexOf(asigCtx) > segundoPuntoComa) {
                actualizacion = (Instruccion) visit(asigCtx);
            }
        }

        List<Instruccion> bloque = new ArrayList<>();
        bloque.add((Instruccion) visit(ctx.instruccion()));

        return new NodoPara(inicializacion, condicion, actualizacion, bloque, linea, col);
    }

    @Override
    public Object visitInstAsignacion(InstAsignacionContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        Expresion destino = (Expresion) visit(ctx.acceso());
        Expresion valor = (Expresion) visit(ctx.expresion());

        String operador = ctx.getChild(1).getText();
        if (!operador.equals("=")) {
            String opBinario = operador.equals("+=") ? "+" : (operador.equals("-=") ? "-" : "*");
            valor = new OperacionBinaria(destino, valor, opBinario, linea, col);
        }

        return new Asignacion(destino, valor, linea, col);
    }

    @Override
    public Object visitInstIncremento(InstIncrementoContext ctx) {
        Expresion destino = (Expresion) visit(ctx.acceso());
        return new NodoIncrementoDecremento(destino, "++", ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitInstDecremento(InstDecrementoContext ctx) {
        Expresion destino = (Expresion) visit(ctx.acceso());
        return new NodoIncrementoDecremento(destino, "--", ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitInstLlamada(InstLlamadaContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        Expresion base = (Expresion) visit(ctx.acceso());
        List<Expresion> args = new ArrayList<>();
        if (ctx.argumentos() != null) {
            args = (List<Expresion>) visit(ctx.argumentos());
        }

        if (base instanceof AccesoPropiedad) {
            AccesoPropiedad prop = (AccesoPropiedad) base;
            return new LlamadaMetodo(prop.objetoBase, prop.idPropiedad, args, linea, col);
        } else if (base instanceof AccesoVariable) {
            AccesoVariable var = (AccesoVariable) base;
            return new LlamadaFuncion(var.id, args, linea, col);
        }
        return null;
    }

    @Override
    public Object visitWhileStmt(WhileStmtContext ctx) {
        Expresion condicion = (Expresion) visit(ctx.expresion());
        List<Instruccion> bloque = new ArrayList<>();
        bloque.add((Instruccion) visit(ctx.instruccion()));
        return new NodoMientras(condicion, bloque, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitDoWhileStmt(DoWhileStmtContext ctx) {
        Expresion condicion = (Expresion) visit(ctx.expresion());
        List<Instruccion> bloque = new ArrayList<>();
        bloque.add((Instruccion) visit(ctx.instruccion()));
        return new NodoHacerMientras(bloque, condicion, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitSwitchStmt(SwitchStmtContext ctx) {
        Expresion expresionEvaluar = (Expresion) visit(ctx.expresion());
        List<NodoCaso> casos = new ArrayList<>();
        for (CaseCodeContext caseCtx : ctx.caseCode()) {
            casos.add((NodoCaso) visit(caseCtx));
        }
        List<Instruccion> bloqueDefault = ctx.defaultCode() != null ? (List<Instruccion>) visit(ctx.defaultCode()) : null;
        return new NodoSwitch(expresionEvaluar, casos, bloqueDefault, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitCaseCode(CaseCodeContext ctx) {
        Expresion valorCaso = (Expresion) visit(ctx.expresion());
        List<Instruccion> instrucciones = new ArrayList<>();
        for (InstruccionContext instCtx : ctx.instruccion()) {
            instrucciones.add((Instruccion) visit(instCtx));
        }
        return new NodoCaso(valorCaso, instrucciones, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitDefaultCode(DefaultCodeContext ctx) {
        List<Instruccion> instrucciones = new ArrayList<>();
        for (InstruccionContext instCtx : ctx.instruccion()) {
            instrucciones.add((Instruccion) visit(instCtx));
        }
        return instrucciones;
    }

    // --- ACCESO A VARIABLES, PROPIEDADES Y ARREGLOS ---

    @Override
    public Object visitAcceso(AccesoContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        Expresion actual = null;

        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree hijo = ctx.getChild(i);
            String texto = hijo.getText();

            // Ignorar tokens de puntuación sueltos, la lógica recae en los operandos
            if (texto.equals(".") || texto.equals("[") || texto.equals("]")) {
                continue;
            }

            if (texto.equals("this")) {
                actual = new AccesoVariable("this", linea, col);
            } else if (hijo instanceof org.antlr.v4.runtime.tree.TerminalNode && texto.matches("[a-zA-Z_$][a-zA-Z0-9_$]*")) {
                if (actual == null) {
                    actual = new AccesoVariable(texto, linea, col);
                } else {
                    actual = new AccesoPropiedad(actual, texto, linea, col);
                }
            } else if (hijo instanceof ExpresionContext) {
                Expresion indice = (Expresion) visit(hijo);

                if (actual instanceof AccesoArreglo) {
                    // Agrupar índices contiguos en la lista del nodo existente (ej. matriz[1][2])
                    ((AccesoArreglo) actual).indices.add(indice);
                } else {
                    // Primer índice: crear el nodo instanciando la lista
                    List<Expresion> listaIndices = new ArrayList<>();
                    listaIndices.add(indice);
                    actual = new AccesoArreglo(actual, listaIndices, linea, col);
                }
            }
        }
        return actual;
    }

    @Override
    public Object visitArgumentos(ArgumentosContext ctx) {
        List<Expresion> args = new ArrayList<>();
        for (ExpresionContext exprCtx : ctx.expresion()) {
            args.add((Expresion) visit(exprCtx));
        }
        return args;
    }

    // --- EXPRESIONES ---

    @Override
    public Object visitExprAgrupacion(ExprAgrupacionContext ctx) {
        return visit(ctx.expresion());
    }

    @Override
    public Object visitExprArregloLiteral(ExprArregloLiteralContext ctx) {
        List<Expresion> valores = new ArrayList<>();
        for (ExpresionContext exprCtx : ctx.expresion()) {
            valores.add((Expresion) visit(exprCtx));
        }
        return new ArregloLiteral(valores, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprInstanciaArreglo(ExprInstanciaArregloContext ctx) {
        TipoDato tipo = ValidadorTipos.parsearTipo(ctx.tipoDato().getText());
        List<Expresion> dimensiones = new ArrayList<>();
        for (ExpresionContext exprCtx : ctx.expresion()) {
            dimensiones.add((Expresion) visit(exprCtx));
        }
        return new InstanciaArreglo(tipo, dimensiones, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprInstanciaObjeto(ExprInstanciaObjetoContext ctx) {
        String idClase = ctx.ID().getText();
        List<Expresion> args = new ArrayList<>();
        if (ctx.argumentos() != null) args = (List<Expresion>) visit(ctx.argumentos());
        return new InstanciaObjeto(idClase, args, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprNot(ExprNotContext ctx) {
        Expresion expr = (Expresion) visit(ctx.expresion());
        return new OperacionUnaria(expr, "!", ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprMultDivMod(ExprMultDivModContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    @Override
    public Object visitExprReadln(ExprReadlnContext ctx) {
        return new LlamadaFuncion("readln", new ArrayList<>(), ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprCaracter(ExprCaracterContext ctx) {
        String str = ctx.getText();
        String valor = str.substring(1, str.length() - 1);
        return new Primitivo(valor, TipoDato.CARACTER, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprTernario(ExprTernarioContext ctx) {
        Expresion condicion = (Expresion) visit(ctx.expresion(0));
        Expresion verdadero = (Expresion) visit(ctx.expresion(1));
        Expresion falso = (Expresion) visit(ctx.expresion(2));
        return new OperadorTernario(condicion, verdadero, falso, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprSumaResta(ExprSumaRestaContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    @Override
    public Object visitExprRelacional(ExprRelacionalContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    @Override
    public Object visitExprIgualdad(ExprIgualdadContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    @Override
    public Object visitExprAnd(ExprAndContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    @Override
    public Object visitExprOr(ExprOrContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    private OperacionBinaria crearBinaria(ParseTree ctxIzq, ParseTree ctxDer, String op, org.antlr.v4.runtime.ParserRuleContext ctx) {
        Expresion izq = (Expresion) visit(ctxIzq);
        Expresion der = (Expresion) visit(ctxDer);
        return new OperacionBinaria(izq, der, op, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprAccesoOlamada(ExprAccesoOlamadaContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        Expresion base = (Expresion) visit(ctx.acceso());

        if (ctx.PAREN_A() != null) {
            List<Expresion> args = new ArrayList<>();
            if (ctx.argumentos() != null) args = (List<Expresion>) visit(ctx.argumentos());

            if (base instanceof AccesoPropiedad) {
                AccesoPropiedad prop = (AccesoPropiedad) base;
                return new LlamadaMetodo(prop.objetoBase, prop.idPropiedad, args, linea, col);
            } else if (base instanceof AccesoVariable) {
                AccesoVariable var = (AccesoVariable) base;
                return new LlamadaFuncion(var.id, args, linea, col);
            }
        }
        return base;
    }

    // --- PRIMITIVOS ---

    @Override
    public Object visitExprEntero(ExprEnteroContext ctx) {
        return new Primitivo(Integer.parseInt(ctx.getText()), TipoDato.ENTERO, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprDouble(ExprDoubleContext ctx) {
        return new Primitivo(Double.parseDouble(ctx.getText()), TipoDato.DECIMAL, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprCadena(ExprCadenaContext ctx) {
        String stringCrudo = ctx.getText();
        String valor = stringCrudo.substring(1, stringCrudo.length() - 1);
        return new Primitivo(valor, TipoDato.CADENA, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprTrue(ExprTrueContext ctx) {
        return new Primitivo(true, TipoDato.BOOLEANO, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprFalse(ExprFalseContext ctx) {
        return new Primitivo(false, TipoDato.BOOLEANO, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprNull(ExprNullContext ctx) {
        return new Primitivo("null", TipoDato.NULO, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }
}