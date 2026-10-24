package ast.zetariano;

import ast.Expresion;
import ast.Instruccion;
import ast.expresiones.*;
import ast.instrucciones.*;
import ast.instrucciones.NodoIncrementoDecremento;
import gramaticas.zetariano.ZetarianoBaseVisitor;
import gramaticas.zetariano.ZetarianoParser;
import semantico.TipoDato;
import semantico.ValidadorTipos;

import org.antlr.v4.runtime.tree.ParseTree;
import java.util.ArrayList;
import java.util.List;

public class ZetarianoCustomVisitor extends ZetarianoBaseVisitor<Object> {

    // --- PROGRAMA Y CLASES ---

    @Override
    public Object visitPrograma(ZetarianoParser.ProgramaContext ctx) {
        List<Instruccion> clases = new ArrayList<>();
        for (ZetarianoParser.DefinicionClaseContext claseCtx : ctx.definicionClase()) {
            clases.add((Instruccion) visit(claseCtx));
        }
        return clases;
    }

    @Override
    public Object visitDefinicionClase(ZetarianoParser.DefinicionClaseContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        String visibilidad = (ctx.modificadorAcceso() != null) ? ctx.modificadorAcceso().getText() : "default";

        String idClase = ctx.ID(0).getText();
        String idPadre = (ctx.EXTENDS() != null) ? ctx.ID(1).getText() : null;

        List<Instruccion> instrucciones = new ArrayList<>();
        for (ZetarianoParser.MiembroClaseContext miembroCtx : ctx.miembroClase()) {
            Instruccion inst = (Instruccion) visit(miembroCtx);
            if (inst != null) instrucciones.add(inst);
        }

        // Ahora enviamos los 6 parámetros en el orden correcto
        return new DefinicionClase(idClase, idPadre, visibilidad, instrucciones, linea, col);
    }

    @Override
    public Object visitDeclaracionAtributo(ZetarianoParser.DeclaracionAtributoContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        String visibilidad = (ctx.modificadorAcceso() != null) ? ctx.modificadorAcceso().getText() : "default";
        String tipoStr = ctx.tipoDato().getText();
        TipoDato tipo = ValidadorTipos.parsearTipo(tipoStr);
        String tipoObjeto = (tipo == TipoDato.OBJETO) ? tipoStr : null;

        String id = ctx.ID().getText();
        boolean esArreglo = ctx.CORCHETE_A() != null;

        return new DeclaracionAtributo(visibilidad, tipo, tipoObjeto, id, esArreglo, linea, col);
    }

    @Override
    public Object visitConstructor(ZetarianoParser.ConstructorContext ctx) {
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
    public Object visitDefinicionMetodo(ZetarianoParser.DefinicionMetodoContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        String visibilidad = (ctx.modificadorAcceso() != null) ? ctx.modificadorAcceso().getText() : "default";

        String tipoRetornoStr = (ctx.VOID() != null) ? "void" : ctx.tipoDato().getText();
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
    public Object visitParametros(ZetarianoParser.ParametrosContext ctx) {
        List<DefinicionFuncion.ParametroFormal> lista = new ArrayList<>();
        for (ZetarianoParser.ParametroContext paramCtx : ctx.parametro()) {
            lista.add((DefinicionFuncion.ParametroFormal) visit(paramCtx));
        }
        return lista;
    }

    @Override
    public Object visitParametro(ZetarianoParser.ParametroContext ctx) {
        String tipoStr = ctx.tipoDato().getText();
        TipoDato tipo = ValidadorTipos.parsearTipo(tipoStr);
        String tipoObj = (tipo == TipoDato.OBJETO) ? tipoStr : null;
        String id = ctx.ID().getText();
        return new DefinicionFuncion.ParametroFormal(tipo, tipoObj, id);
    }

    @Override
    public Object visitBloque(ZetarianoParser.BloqueContext ctx) {
        List<Instruccion> instrucciones = new ArrayList<>();
        for (ZetarianoParser.InstruccionContext instCtx : ctx.instruccion()) {
            Instruccion inst = (Instruccion) visit(instCtx);
            if (inst != null) instrucciones.add(inst);
        }
        return instrucciones;
    }

    // --- INSTRUCCIONES BÁSICAS Y CONTROL DE FLUJO ---

    @Override
    public Object visitInstruccion(ZetarianoParser.InstruccionContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        if (ctx.PRINTLN() != null) {
            Expresion valor = (Expresion) visit(ctx.expresion());
            return new Imprimir(valor, true, linea, col);
        } else if (ctx.RETURN() != null) {
            Expresion valor = (ctx.expresion() != null) ? (Expresion) visit(ctx.expresion()) : null;
            return new NodoRetornar(valor, linea, col);
        }

        return visitChildren(ctx);
    }

    @Override
    public Object visitDeclaracionLocal(ZetarianoParser.DeclaracionLocalContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        String tipoStr = ctx.tipoDato().getText();
        TipoDato tipo = ValidadorTipos.parsearTipo(tipoStr);
        String tipoObj = (tipo == TipoDato.OBJETO) ? tipoStr : null;

        String id = ctx.ID().getText();
        Expresion valor = (Expresion) visit(ctx.expresion());

        return new Declaracion(id, tipo, tipoObj, valor, linea, col);
    }

    @Override
    public Object visitIfStmt(ZetarianoParser.IfStmtContext ctx) {
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
    public Object visitForStmt(ZetarianoParser.ForStmtContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        Instruccion inicializacion = null;
        if (ctx.declaracionLocal() != null) inicializacion = (Instruccion) visit(ctx.declaracionLocal());
        else if (ctx.asignacionOMetodo(0) != null) inicializacion = (Instruccion) visit(ctx.asignacionOMetodo(0));

        Expresion condicion = (Expresion) visit(ctx.expresion());

        Instruccion actualizacion = (ctx.asignacionOMetodo().size() > 1)
                ? (Instruccion) visit(ctx.asignacionOMetodo(1))
                : (Instruccion) visit(ctx.asignacionOMetodo(0));

        List<Instruccion> bloque = new ArrayList<>();
        bloque.add((Instruccion) visit(ctx.instruccion()));

        return new NodoPara(inicializacion, condicion, actualizacion, bloque, linea, col);
    }

    @Override
    public Object visitInstAsignacion(ZetarianoParser.InstAsignacionContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        Expresion destino = (Expresion) visit(ctx.acceso());
        Expresion valor = (Expresion) visit(ctx.expresion());

        String operador = ctx.getChild(1).getText();
        if (!operador.equals("=")) {
            String opBinario = operador.equals("+=") ? "+" : "-";
            valor = new OperacionBinaria(destino, valor, opBinario, linea, col);
        }

        return new Asignacion(destino, valor, linea, col);
    }

    @Override
    public Object visitInstIncremento(ZetarianoParser.InstIncrementoContext ctx) {
        Expresion destino = (Expresion) visit(ctx.acceso());
        return new NodoIncrementoDecremento(destino, "++", ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitInstDecremento(ZetarianoParser.InstDecrementoContext ctx) {
        Expresion destino = (Expresion) visit(ctx.acceso());
        return new NodoIncrementoDecremento(destino, "--", ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitInstLlamada(ZetarianoParser.InstLlamadaContext ctx) {
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

    // --- ACCESO A VARIABLES, PROPIEDADES Y ARREGLOS ---

    @Override
    public Object visitAcceso(ZetarianoParser.AccesoContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        Expresion actual = null;

        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree hijo = ctx.getChild(i);
            String texto = hijo.getText();

            if (texto.equals("this")) {
                actual = new AccesoVariable("this", linea, col);
            } else if (hijo instanceof org.antlr.v4.runtime.tree.TerminalNode && texto.matches("[a-zA-Z_$][a-zA-Z0-9_$]*")) {
                if (actual == null) {
                    actual = new AccesoVariable(texto, linea, col);
                } else {
                    actual = new AccesoPropiedad(actual, texto, linea, col);
                }
            } else if (hijo instanceof ZetarianoParser.ExpresionContext) {
                Expresion indice = (Expresion) visit(hijo);
                actual = new AccesoArreglo(actual, indice, linea, col);
            }
        }
        return actual;
    }

    @Override
    public Object visitArgumentos(ZetarianoParser.ArgumentosContext ctx) {
        List<Expresion> args = new ArrayList<>();
        for (ZetarianoParser.ExpresionContext exprCtx : ctx.expresion()) {
            args.add((Expresion) visit(exprCtx));
        }
        return args;
    }

    // --- EXPRESIONES ---

    @Override
    public Object visitExprAgrupacion(ZetarianoParser.ExprAgrupacionContext ctx) {
        return visit(ctx.expresion());
    }

    @Override
    public Object visitExprInstanciaArreglo(ZetarianoParser.ExprInstanciaArregloContext ctx) {
        TipoDato tipo = ValidadorTipos.parsearTipo(ctx.tipoDato().getText());
        Expresion tamano = (Expresion) visit(ctx.expresion());
        return new InstanciaArreglo(tipo, tamano, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprInstanciaObjeto(ZetarianoParser.ExprInstanciaObjetoContext ctx) {
        String idClase = ctx.ID().getText();
        List<Expresion> args = new ArrayList<>();
        if (ctx.argumentos() != null) args = (List<Expresion>) visit(ctx.argumentos());
        return new InstanciaObjeto(idClase, args, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprNot(ZetarianoParser.ExprNotContext ctx) {
        Expresion expr = (Expresion) visit(ctx.expresion());
        return new OperacionUnaria(expr, "!", ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprMultDiv(ZetarianoParser.ExprMultDivContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    @Override
    public Object visitExprSumaResta(ZetarianoParser.ExprSumaRestaContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    @Override
    public Object visitExprRelacional(ZetarianoParser.ExprRelacionalContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    @Override
    public Object visitExprIgualdad(ZetarianoParser.ExprIgualdadContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    @Override
    public Object visitExprAnd(ZetarianoParser.ExprAndContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    @Override
    public Object visitExprOr(ZetarianoParser.ExprOrContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    private OperacionBinaria crearBinaria(ParseTree ctxIzq, ParseTree ctxDer, String op, org.antlr.v4.runtime.ParserRuleContext ctx) {
        Expresion izq = (Expresion) visit(ctxIzq);
        Expresion der = (Expresion) visit(ctxDer);
        return new OperacionBinaria(izq, der, op, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprAccesoOlamada(ZetarianoParser.ExprAccesoOlamadaContext ctx) {
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
    public Object visitExprEntero(ZetarianoParser.ExprEnteroContext ctx) {
        return new Primitivo(Integer.parseInt(ctx.getText()), TipoDato.ENTERO, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprDouble(ZetarianoParser.ExprDoubleContext ctx) {
        return new Primitivo(Double.parseDouble(ctx.getText()), TipoDato.DECIMAL, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprCadena(ZetarianoParser.ExprCadenaContext ctx) {
        String stringCrudo = ctx.getText();
        String valor = stringCrudo.substring(1, stringCrudo.length() - 1);
        return new Primitivo(valor, TipoDato.CADENA, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprTrue(ZetarianoParser.ExprTrueContext ctx) {
        return new Primitivo(true, TipoDato.BOOLEANO, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprFalse(ZetarianoParser.ExprFalseContext ctx) {
        return new Primitivo(false, TipoDato.BOOLEANO, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprNull(ZetarianoParser.ExprNullContext ctx) {
        return new Primitivo("null", TipoDato.NULO, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }
}