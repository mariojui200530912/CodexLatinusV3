package ast.piglatin;

import ast.Expresion;
import ast.Instruccion;
import ast.expresiones.*;
import ast.instrucciones.*;
import ast.instrucciones.NodoIncrementoDecremento;
import gramaticas.pigLatin.PigLatinBaseVisitor;
import gramaticas.pigLatin.PigLatinParser;
import semantico.TipoDato;
import semantico.ValidadorTipos;

import org.antlr.v4.runtime.tree.ParseTree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PigLatinCustomVisitor extends PigLatinBaseVisitor<Object> {

    // --- PROGRAMA PRINCIPAL ---

    @Override
    public Object visitPrograma(PigLatinParser.ProgramaContext ctx) {
        List<Instruccion> programa = new ArrayList<>();

        if (ctx.seccionVariables() != null) {
            programa.addAll((List<Instruccion>) visit(ctx.seccionVariables()));
        }

        if (ctx.seccionPrincipal() != null) {
            programa.addAll((List<Instruccion>) visit(ctx.seccionPrincipal()));
        }

        return programa;
    }

    // --- SECCIÓN DE VARIABLES (Declaraciones Globales) ---

    @Override
    public Object visitSeccionVariables(PigLatinParser.SeccionVariablesContext ctx) {
        List<Instruccion> declaraciones = new ArrayList<>();
        for (PigLatinParser.DeclaracionContext declCtx : ctx.declaracion()) {
            declaraciones.add((Instruccion) visit(declCtx));
        }
        return declaraciones;
    }

    @Override
    public Object visitDeclNormal(PigLatinParser.DeclNormalContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        String id = ctx.ID().getText();
        String tipoStr = ctx.tipoDato().getText();
        TipoDato tipo = ValidadorTipos.parsearTipo(tipoStr);
        String tipoObj = (tipo == TipoDato.OBJETO) ? tipoStr : null;

        Expresion valor = (Expresion) visit(ctx.expresion());

        return new Declaracion(id, tipo, tipoObj, valor, linea, col);
    }

    @Override
    public Object visitDeclObjetoNovus(PigLatinParser.DeclObjetoNovusContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        String id = ctx.ID().getText();

        String tipoObjeto = ctx.tipoDato(1).getText();
        String claseInstancia = ctx.tipoDato(0).getText();

        List<Expresion> args = new ArrayList<>();
        if (ctx.argumentos() != null) args = (List<Expresion>) visit(ctx.argumentos());

        Expresion valor = new InstanciaObjeto(claseInstancia, args, linea, col);

        return new Declaracion(id, TipoDato.OBJETO, tipoObjeto, valor, linea, col);
    }

    @Override
    public Object visitDeclObjetoNull(PigLatinParser.DeclObjetoNullContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        String id = ctx.ID().getText();
        String tipoObjeto = ctx.tipoDato().getText();

        Expresion valorNull = new Primitivo("null", TipoDato.NULO, linea, col);

        return new Declaracion(id, TipoDato.OBJETO, tipoObjeto, valorNull, linea, col);
    }

    @Override
    public Object visitDeclArreglo(PigLatinParser.DeclArregloContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        String id = ctx.ID().getText();
        String tipoStr = ctx.tipoDato().getText();
        TipoDato tipo = ValidadorTipos.parsearTipo(tipoStr);
        String tipoObj = (tipo == TipoDato.OBJETO) ? tipoStr : null;

        Expresion valor;
        if (ctx.LLAVE_A() != null) {
            // Arreglo literal: series arr[3] : numerus {1, 2, 3};
            List<Expresion> elementos = new ArrayList<>();
            if (ctx.argumentos() != null) elementos = (List<Expresion>) visit(ctx.argumentos());
            valor = new ArregloLiteral(elementos, linea, col);
        } else {
            // Arreglo vacío: series arr[3] : numerus;
            Expresion tamano = (Expresion) visit(ctx.expresion());
            valor = new InstanciaArreglo(tipo, tamano, linea, col);
        }

        Declaracion decl = new Declaracion(id, tipo, tipoObj, valor, linea, col);
        decl.esArreglo = true;
        return decl;
    }

    // --- SECCIÓN PRINCIPAL ---

    @Override
    public Object visitSeccionPrincipal(PigLatinParser.SeccionPrincipalContext ctx) {
        List<Instruccion> bloque = new ArrayList<>();
        for (PigLatinParser.InstruccionContext instCtx : ctx.instruccion()) {
            Object res = visit(instCtx);
            // Algunas instrucciones como '>> a >> b;' retornan una lista de Imprimir
            if (res instanceof List) {
                bloque.addAll((List<Instruccion>) res);
            } else if (res instanceof Instruccion) {
                bloque.add((Instruccion) res);
            }
        }
        return bloque;
    }

    // --- INSTRUCCIONES ---

    @Override
    public Object visitInstAsignacion(PigLatinParser.InstAsignacionContext ctx) {
        Expresion destino = (Expresion) visit(ctx.acceso());
        Expresion valor = (Expresion) visit(ctx.expresion());
        return new Asignacion(destino, valor, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitInstInc(PigLatinParser.InstIncContext ctx) {
        Expresion destino = (Expresion) visit(ctx.acceso());
        return new NodoIncrementoDecremento(destino, "++", ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitInstDec(PigLatinParser.InstDecContext ctx) {
        Expresion destino = (Expresion) visit(ctx.acceso());
        return new NodoIncrementoDecremento(destino, "--", ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitInstLlamada(PigLatinParser.InstLlamadaContext ctx) {
        Expresion base = (Expresion) visit(ctx.acceso());
        List<Expresion> args = new ArrayList<>();
        if (ctx.argumentos() != null) args = (List<Expresion>) visit(ctx.argumentos());

        if (base instanceof AccesoPropiedad) {
            AccesoPropiedad prop = (AccesoPropiedad) base;
            return new LlamadaMetodo(prop.objetoBase, prop.idPropiedad, args, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        } else if (base instanceof AccesoVariable) {
            AccesoVariable var = (AccesoVariable) base;
            return new LlamadaFuncion(var.id, args, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return null;
    }

    @Override
    public Object visitInstImprimir(PigLatinParser.InstImprimirContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        List<Instruccion> impresiones = new ArrayList<>();
        // Múltiples >> en la misma línea: ">> expr1 >> expr2;"
        for (PigLatinParser.ExpresionContext exprCtx : ctx.expresion()) {
            Expresion expr = (Expresion) visit(exprCtx);
            impresiones.add(new Imprimir(expr, true, linea, col));
        }

        return impresiones;
    }

    @Override
    public Object visitInstSi(PigLatinParser.InstSiContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        Expresion condPrincipal = (Expresion) visit(ctx.expresion(0));

        List<Instruccion> bloquePrincipal = aplanarBloque(ctx.instruccion(0));

        class AliterData {
            Expresion cond;
            List<Instruccion> bloque;
        }

        List<AliterData> aliters = new ArrayList<>();
        int exprIndex = 1;
        int instIndex = 1;

        for(int i = 0; i < ctx.getChildCount(); i++){
            if(ctx.getChild(i).getText().equals("aliter")){
                AliterData ad = new AliterData();
                if(ctx.getChild(i+1).getText().equals("(")) { // Es un else if
                    ad.cond = (Expresion) visit(ctx.expresion(exprIndex++));
                }
                ad.bloque = aplanarBloque(ctx.instruccion(instIndex++));
                aliters.add(ad);
            }
        }

        List<Instruccion> bloqueFalsoFinal = new ArrayList<>();
        NodoIf ifAnidado = null;

        for(int i = aliters.size() - 1; i >= 0; i--) {
            AliterData ad = aliters.get(i);
            if (ad.cond == null) {
                bloqueFalsoFinal = ad.bloque; // Es un ELSE terminal
            } else {
                List<Instruccion> falsoDeEste = (ifAnidado != null) ? Arrays.asList(ifAnidado) : bloqueFalsoFinal;
                ifAnidado = new NodoIf(ad.cond, ad.bloque, falsoDeEste, linea, col);
                bloqueFalsoFinal = Arrays.asList(ifAnidado);
            }
        }

        return new NodoIf(condPrincipal, bloquePrincipal, bloqueFalsoFinal, linea, col);
    }

    @Override
    public Object visitInstDum(PigLatinParser.InstDumContext ctx) {
        Expresion condicion = (Expresion) visit(ctx.expresion());
        List<Instruccion> bloque = aplanarBloque(ctx.instruccion());
        return new NodoMientras(condicion, bloque, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitInstFacere(PigLatinParser.InstFacereContext ctx) {
        Expresion condicion = (Expresion) visit(ctx.expresion());
        List<Instruccion> bloque = aplanarBloque(ctx.instruccion());

        return new NodoHacerMientras(bloque, condicion, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitInstPer(PigLatinParser.InstPerContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        Instruccion inicializacion;
        if (ctx.ESTO() != null) { // per(esto i: numerus 0; ...)
            String id = ctx.ID().getText();
            TipoDato tipo = ValidadorTipos.parsearTipo(ctx.tipoDato().getText());
            Expresion val = (Expresion) visit(ctx.expresion(0));
            inicializacion = new Declaracion(id, tipo, null, val, linea, col);
        } else { // per(i = 0; ...)
            Expresion destino = (Expresion) visit(ctx.acceso(0));
            Expresion val = (Expresion) visit(ctx.expresion(0));
            inicializacion = new Asignacion(destino, val, linea, col);
        }

        Expresion condicion = (Expresion) visit(ctx.expresion(ctx.ESTO() != null ? 1 : 1));

        Instruccion actualizacion;
        int lastAcceso = ctx.acceso().size() - 1;
        if (ctx.MAS_MAS() != null) {
            actualizacion = new NodoIncrementoDecremento((Expresion) visit(ctx.acceso(lastAcceso)), "++", linea, col);
        } else if (ctx.MENOS_MENOS() != null) {
            actualizacion = new NodoIncrementoDecremento((Expresion) visit(ctx.acceso(lastAcceso)), "--", linea, col);
        } else {
            Expresion destino = (Expresion) visit(ctx.acceso(lastAcceso));
            Expresion valor = (Expresion) visit(ctx.expresion(ctx.expresion().size() - 1));
            actualizacion = new Asignacion(destino, valor, linea, col);
        }

        List<Instruccion> bloque = aplanarBloque(ctx.instruccion());
        return new NodoPara(inicializacion, condicion, actualizacion, bloque, linea, col);
    }

    @Override
    public Object visitInstInterrumpe(PigLatinParser.InstInterrumpeContext ctx) {
        return new NodoBreak(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitInstPerge(PigLatinParser.InstPergeContext ctx) {
        return new NodoContinue(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    // --- FUNCION UTILITARIA ---
    // Metodo original: Procesa una sola instrucción (y la aplana si retorna múltiples, como los '>>')
    private List<Instruccion> aplanarBloque(PigLatinParser.InstruccionContext instCtx) {
        List<Instruccion> bloque = new ArrayList<>();
        Object res = visit(instCtx);
        if (res instanceof List) {
            bloque.addAll((List<Instruccion>) res);
        } else if (res instanceof Instruccion) {
            bloque.add((Instruccion) res);
        }
        return bloque;
    }

    // Metodo sobrecargado: Procesa una lista de instrucciones iterando sobre ella
    private List<Instruccion> aplanarBloque(List<PigLatinParser.InstruccionContext> listaCtx) {
        List<Instruccion> bloque = new ArrayList<>();
        if (listaCtx != null) {
            for (PigLatinParser.InstruccionContext instCtx : listaCtx) {
                bloque.addAll(aplanarBloque(instCtx));
            }
        }
        return bloque;
    }

    // --- ACCESO A VARIABLES, ARREGLOS Y PROPIEDADES ---

    @Override
    public Object visitAcceso(PigLatinParser.AccesoContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        Expresion actual = new AccesoVariable(ctx.ID(0).getText(), linea, col);
        int idIndex = 1;
        int exprIndex = 0;

        for (int i = 1; i < ctx.getChildCount(); i++) {
            String texto = ctx.getChild(i).getText();
            if (texto.equals(".")) {
                String prop = ctx.ID(idIndex++).getText();
                actual = new AccesoPropiedad(actual, prop, linea, col);
            } else if (texto.equals("[")) {
                Expresion indice = (Expresion) visit(ctx.expresion(exprIndex++));
                actual = new AccesoArreglo(actual, indice, linea, col);
            }
        }
        return actual;
    }

    @Override
    public Object visitArgumentos(PigLatinParser.ArgumentosContext ctx) {
        List<Expresion> args = new ArrayList<>();
        for (PigLatinParser.ExpresionContext exprCtx : ctx.expresion()) {
            args.add((Expresion) visit(exprCtx));
        }
        return args;
    }

    // --- EXPRESIONES BÁSICAS ---

    @Override
    public Object visitExprSumaResta(PigLatinParser.ExprSumaRestaContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    @Override
    public Object visitExprMultDiv(PigLatinParser.ExprMultDivContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    @Override
    public Object visitExprRelacional(PigLatinParser.ExprRelacionalContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    @Override
    public Object visitExprIgualdad(PigLatinParser.ExprIgualdadContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    @Override
    public Object visitExprAnd(PigLatinParser.ExprAndContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    @Override
    public Object visitExprOr(PigLatinParser.ExprOrContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    private OperacionBinaria crearBinaria(ParseTree ctxIzq, ParseTree ctxDer, String op, org.antlr.v4.runtime.ParserRuleContext ctx) {
        Expresion izq = (Expresion) visit(ctxIzq);
        Expresion der = (Expresion) visit(ctxDer);
        return new OperacionBinaria(izq, der, op, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprNot(PigLatinParser.ExprNotContext ctx) {
        Expresion expr = (Expresion) visit(ctx.expresion());
        return new OperacionUnaria(expr, "!", ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprAgrupacion(PigLatinParser.ExprAgrupacionContext ctx) {
        return visit(ctx.expresion());
    }

    @Override
    public Object visitExprAccesoVariable(PigLatinParser.ExprAccesoVariableContext ctx) {
        return visit(ctx.acceso());
    }

    @Override
    public Object visitExprLlamadaMetodo(PigLatinParser.ExprLlamadaMetodoContext ctx) {
        Expresion base = (Expresion) visit(ctx.acceso());
        List<Expresion> args = new ArrayList<>();
        if (ctx.argumentos() != null) args = (List<Expresion>) visit(ctx.argumentos());

        if (base instanceof AccesoPropiedad) {
            AccesoPropiedad prop = (AccesoPropiedad) base;
            return new LlamadaMetodo(prop.objetoBase, prop.idPropiedad, args, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        } else if (base instanceof AccesoVariable) {
            AccesoVariable var = (AccesoVariable) base;
            return new LlamadaFuncion(var.id, args, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
        }
        return base;
    }

    @Override
    public Object visitExprInstanciaStruct(PigLatinParser.ExprInstanciaStructContext ctx) {
        List<Expresion> elementos = new ArrayList<>();
        if (ctx.argumentos() != null) elementos = (List<Expresion>) visit(ctx.argumentos());
        return new ArregloLiteral(elementos, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprNovus(PigLatinParser.ExprNovusContext ctx) {
        String idClase = ctx.tipoDato().getText();
        List<Expresion> args = new ArrayList<>();
        if (ctx.argumentos() != null) args = (List<Expresion>) visit(ctx.argumentos());
        return new InstanciaObjeto(idClase, args, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    // --- PRIMITIVOS ---

    @Override
    public Object visitExprEntero(PigLatinParser.ExprEnteroContext ctx) {
        return new Primitivo(Integer.parseInt(ctx.getText()), TipoDato.ENTERO, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprDecimal(PigLatinParser.ExprDecimalContext ctx) {
        return new Primitivo(Double.parseDouble(ctx.getText()), TipoDato.DECIMAL, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprCadena(PigLatinParser.ExprCadenaContext ctx) {
        String stringCrudo = ctx.getText();
        String valor = stringCrudo.substring(1, stringCrudo.length() - 1);
        return new Primitivo(valor, TipoDato.CADENA, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprCaracter(PigLatinParser.ExprCaracterContext ctx) {
        String stringCrudo = ctx.getText();
        String valor = stringCrudo.substring(1, stringCrudo.length() - 1);
        return new Primitivo(valor, TipoDato.CARACTER, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprVerum(PigLatinParser.ExprVerumContext ctx) {
        return new Primitivo(true, TipoDato.BOOLEANO, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprFalsus(PigLatinParser.ExprFalsusContext ctx) {
        return new Primitivo(false, TipoDato.BOOLEANO, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprNull(PigLatinParser.ExprNullContext ctx) {
        return new Primitivo("null", TipoDato.NULO, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }
}