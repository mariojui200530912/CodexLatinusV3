package ast.y;

import ast.Expresion;
import ast.Instruccion;
import ast.expresiones.*;
import ast.instrucciones.*;
import ast.instrucciones.NodoIncrementoDecremento;
import gramaticas.y.LenguajeYBaseVisitor;
import gramaticas.y.LenguajeYParser;
import semantico.TipoDato;
import semantico.ValidadorTipos;

import org.antlr.v4.runtime.tree.ParseTree;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LenguajeYCustomVisitor extends LenguajeYBaseVisitor<Object> {

    // --- PROGRAMA PRINCIPAL ---

    @Override
    public Object visitPrograma(LenguajeYParser.ProgramaContext ctx) {
        List<Instruccion> programa = new ArrayList<>();

        if (ctx.seccionEstructuras() != null) {
            programa.addAll((List<Instruccion>) visit(ctx.seccionEstructuras()));
        }

        if (ctx.seccionFunciones() != null) {
            programa.addAll((List<Instruccion>) visit(ctx.seccionFunciones()));
        }

        return programa;
    }

    // --- ESTRUCTURAS (Se mapean como Clases) ---

    @Override
    public Object visitSeccionEstructuras(LenguajeYParser.SeccionEstructurasContext ctx) {
        List<Instruccion> estructuras = new ArrayList<>();
        for (LenguajeYParser.EstructuraDefContext estCtx : ctx.estructuraDef()) {
            estructuras.add((Instruccion) visit(estCtx));
        }
        return estructuras;
    }

    @Override
    public Object visitEstructuraDef(LenguajeYParser.EstructuraDefContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        String idEstructura = ctx.ID().getText();

        List<Instruccion> atributos = new ArrayList<>();
        for (LenguajeYParser.AtributoContext attrCtx : ctx.atributo()) {
            atributos.add((Instruccion) visit(attrCtx));
        }

        return new DefinicionClase(idEstructura, null, "public", atributos, linea, col);
    }

    @Override
    public Object visitAtributo(LenguajeYParser.AtributoContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        String tipoStr = ctx.tipoDato().getText();
        TipoDato tipo = ValidadorTipos.parsearTipo(tipoStr);
        String tipoObj = (tipo == TipoDato.OBJETO) ? tipoStr : null;

        String id = ctx.ID().getText();
        boolean esArreglo = ctx.CORCHETE_A() != null;

        return new DeclaracionAtributo("public", tipo, tipoObj, id, esArreglo, linea, col);
    }

    // --- FUNCIONES ---

    @Override
    public Object visitSeccionFunciones(LenguajeYParser.SeccionFuncionesContext ctx) {
        List<Instruccion> funciones = new ArrayList<>();
        for (LenguajeYParser.FuncionDefContext funcCtx : ctx.funcionDef()) {
            funciones.add((Instruccion) visit(funcCtx));
        }
        return funciones;
    }

    @Override
    public Object visitFuncionDef(LenguajeYParser.FuncionDefContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        String idFuncion = ctx.ID().getText();

        // Tipo de retorno (si no hay flecha '->', es void por defecto)
        String tipoRetornoStr = (ctx.FLECHA() != null) ? ctx.tipoDato().getText() : "void";
        TipoDato tipoRetorno = ValidadorTipos.parsearTipo(tipoRetornoStr);
        String tipoObjeto = (tipoRetorno == TipoDato.OBJETO) ? tipoRetornoStr : null;

        List<DefinicionFuncion.ParametroFormal> parametros = new ArrayList<>();
        if (ctx.parametros() != null) {
            parametros = (List<DefinicionFuncion.ParametroFormal>) visit(ctx.parametros());
        }

        List<Instruccion> bloque = new ArrayList<>();
        for (LenguajeYParser.InstruccionContext instCtx : ctx.instruccion()) {
            Instruccion inst = (Instruccion) visit(instCtx);
            if (inst != null) {
                bloque.add(inst);
            }
        }

        return new DefinicionFuncion(idFuncion, tipoRetorno, tipoObjeto, parametros, bloque, linea, col);
    }

    @Override
    public Object visitParametros(LenguajeYParser.ParametrosContext ctx) {
        List<DefinicionFuncion.ParametroFormal> lista = new ArrayList<>();
        for (LenguajeYParser.ParametroContext paramCtx : ctx.parametro()) {
            String tipoStr = paramCtx.tipoDato().getText();
            TipoDato tipo = ValidadorTipos.parsearTipo(tipoStr);
            String tipoObj = (tipo == TipoDato.OBJETO) ? tipoStr : null;
            String id = paramCtx.ID().getText();

            lista.add(new DefinicionFuncion.ParametroFormal(tipo, tipoObj, id));
        }
        return lista;
    }

    // --- INSTRUCCIONES ---

    @Override
    public Object visitInstDeclaracion(LenguajeYParser.InstDeclaracionContext ctx) {
        return visit(ctx.declaracionLocal());
    }

    @Override
    public Object visitDeclaracionLocal(LenguajeYParser.DeclaracionLocalContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        String tipoStr = ctx.tipoDato().getText();
        TipoDato tipo = ValidadorTipos.parsearTipo(tipoStr);
        String tipoObj = (tipo == TipoDato.OBJETO) ? tipoStr : null;

        String id = ctx.ID().getText();

        Expresion valor = null;
        if (ctx.IGUAL() != null) {
            valor = (Expresion) visit(ctx.expresion());
        }

        return new Declaracion(id, tipo, tipoObj, valor, linea, col);
    }

    @Override
    public Object visitInstAsignacion(LenguajeYParser.InstAsignacionContext ctx) {
        Expresion destino = (Expresion) visit(ctx.acceso());
        Expresion valor = (Expresion) visit(ctx.expresion());
        return new Asignacion(destino, valor, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitInstInc(LenguajeYParser.InstIncContext ctx) {
        Expresion destino = (Expresion) visit(ctx.acceso());
        return new NodoIncrementoDecremento(destino, "++", ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitInstDec(LenguajeYParser.InstDecContext ctx) {
        Expresion destino = (Expresion) visit(ctx.acceso());
        return new NodoIncrementoDecremento(destino, "--", ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitInstLlamada(LenguajeYParser.InstLlamadaContext ctx) {
        String idFuncion = ctx.ID().getText();
        List<Expresion> args = new ArrayList<>();
        if (ctx.argumentos() != null) {
            args = (List<Expresion>) visit(ctx.argumentos());
        }

        return new LlamadaFuncion(idFuncion, args, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitInstRetorno(LenguajeYParser.InstRetornoContext ctx) {
        Expresion valor = (ctx.expresion() != null) ? (Expresion) visit(ctx.expresion()) : null;
        return new NodoRetornar(valor, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitInstRomper(LenguajeYParser.InstRomperContext ctx) {
        return new NodoBreak(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitInstContinuar(LenguajeYParser.InstContinuarContext ctx) {
        return new NodoContinue(ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitInstImprimir(LenguajeYParser.InstImprimirContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        List<Expresion> args = new ArrayList<>();
        if (ctx.argumentos() != null) args = (List<Expresion>) visit(ctx.argumentos());

        List<Instruccion> impresiones = new ArrayList<>();
        for (Expresion arg : args) {
            impresiones.add(new Imprimir(arg, true, linea, col));
        }

        if (impresiones.size() == 1) return impresiones.get(0);

        return impresiones;
    }

    // --- CONTROL DE FLUJO ---

    @Override
    public Object visitInstIf(LenguajeYParser.InstIfContext ctx) {
        return visit(ctx.ifStmt());
    }

    @Override
    public Object visitIfStmt(LenguajeYParser.IfStmtContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        // Resolver el bloque CONTRARIO (else) si existe
        List<Instruccion> bloqueFalsoFinal = new ArrayList<>();
        if (ctx.CONTRARIO() != null) {
            // La instrucción del CONTRARIO es la última de la lista generada
            bloqueFalsoFinal.add((Instruccion) visit(ctx.instruccion(ctx.instruccion().size() - 1)));
        }

        NodoIf ifActual = null;
        int numSinos = ctx.SINO().size();

        // Construir la cadena de SINO (else if) de ABAJO hacia ARRIBA
        for (int i = numSinos; i >= 1; i--) {
            Expresion condSino = (Expresion) visit(ctx.expresion(i));
            List<Instruccion> bloqueSino = new ArrayList<>();
            bloqueSino.add((Instruccion) visit(ctx.instruccion(i)));

            List<Instruccion> falsoDeEsteSino = (ifActual != null) ? Arrays.asList(ifActual) : bloqueFalsoFinal;

            ifActual = new NodoIf(condSino, bloqueSino, falsoDeEsteSino, linea, col);
        }

        // Unir con el SI principal (if)
        Expresion condPrincipal = (Expresion) visit(ctx.expresion(0));
        List<Instruccion> bloqueVerdadero = new ArrayList<>();
        bloqueVerdadero.add((Instruccion) visit(ctx.instruccion(0)));

        List<Instruccion> falsoPrincipal = (ifActual != null) ? Arrays.asList(ifActual) : bloqueFalsoFinal;

        return new NodoIf(condPrincipal, bloqueVerdadero, falsoPrincipal, linea, col);
    }

    @Override
    public Object visitForStmt(LenguajeYParser.ForStmtContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        Instruccion inicializacion = (ctx.declaracionLocal() != null)
                ? (Instruccion) visit(ctx.declaracionLocal())
                : new Asignacion((Expresion) visit(ctx.acceso(0)), (Expresion) visit(ctx.expresion(0)), linea, col);

        Expresion condicion = (Expresion) visit(ctx.expresion(ctx.declaracionLocal() != null ? 0 : 1));

        Instruccion actualizacion;
        // Identificar el tipo de actualización: i++, i--, o i=x
        if (ctx.MAS_MAS() != null) {
            actualizacion = new NodoIncrementoDecremento((Expresion) visit(ctx.acceso(ctx.acceso().size()-1)), "++", linea, col);
        } else if (ctx.MENOS_MENOS() != null) {
            actualizacion = new NodoIncrementoDecremento((Expresion) visit(ctx.acceso(ctx.acceso().size()-1)), "--", linea, col);
        } else {
            Expresion destino = (Expresion) visit(ctx.acceso(ctx.acceso().size()-1));
            Expresion valor = (Expresion) visit(ctx.expresion(ctx.expresion().size()-1));
            actualizacion = new Asignacion(destino, valor, linea, col);
        }

        List<Instruccion> bloque = new ArrayList<>();
        for (LenguajeYParser.InstruccionContext instCtx : ctx.instruccion()) {
            Instruccion inst = (Instruccion) visit(instCtx);
            if (inst != null) {
                bloque.add(inst);
            }
        }

        return new NodoPara(inicializacion, condicion, actualizacion, bloque, linea, col);
    }

    @Override
    public Object visitWhileStmt(LenguajeYParser.WhileStmtContext ctx) {
        Expresion condicion = (Expresion) visit(ctx.expresion());
        List<Instruccion> bloque = new ArrayList<>();
        for (LenguajeYParser.InstruccionContext instCtx : ctx.instruccion()) {
            Instruccion inst = (Instruccion) visit(instCtx);
            if (inst != null) {
                bloque.add(inst);
            }
        }

        return new NodoMientras(condicion, bloque, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    // --- ACCESO A VARIABLES, ARREGLOS Y PROPIEDADES ---

    @Override
    public Object visitAcceso(LenguajeYParser.AccesoContext ctx) {
        int linea = ctx.getStart().getLine();
        int col = ctx.getStart().getCharPositionInLine();

        Expresion actual = new AccesoVariable(ctx.ID(0).getText(), linea, col);

        int idIndex = 1;
        int exprIndex = 0;

        for (int i = 1; i < ctx.getChildCount(); i++) {
            ParseTree hijo = ctx.getChild(i);
            String texto = hijo.getText();

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
    public Object visitArgumentos(LenguajeYParser.ArgumentosContext ctx) {
        List<Expresion> args = new ArrayList<>();
        for (LenguajeYParser.ExpresionContext exprCtx : ctx.expresion()) {
            args.add((Expresion) visit(exprCtx));
        }
        return args;
    }

    // --- EXPRESIONES BÁSICAS ---

    @Override
    public Object visitExprSumaResta(LenguajeYParser.ExprSumaRestaContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    @Override
    public Object visitExprMultDiv(LenguajeYParser.ExprMultDivContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    @Override
    public Object visitExprRelacional(LenguajeYParser.ExprRelacionalContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    @Override
    public Object visitExprIgualdad(LenguajeYParser.ExprIgualdadContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    @Override
    public Object visitExprAnd(LenguajeYParser.ExprAndContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    @Override
    public Object visitExprOr(LenguajeYParser.ExprOrContext ctx) {
        return crearBinaria(ctx.expresion(0), ctx.expresion(1), ctx.getChild(1).getText(), ctx);
    }

    private OperacionBinaria crearBinaria(ParseTree ctxIzq, ParseTree ctxDer, String op, org.antlr.v4.runtime.ParserRuleContext ctx) {
        Expresion izq = (Expresion) visit(ctxIzq);
        Expresion der = (Expresion) visit(ctxDer);
        return new OperacionBinaria(izq, der, op, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprNot(LenguajeYParser.ExprNotContext ctx) {
        Expresion expr = (Expresion) visit(ctx.expresion());
        return new OperacionUnaria(expr, "!", ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprParentesis(LenguajeYParser.ExprParentesisContext ctx) {
        return visit(ctx.expresion());
    }

    @Override
    public Object visitExprAcceso(LenguajeYParser.ExprAccesoContext ctx) {
        return visit(ctx.acceso());
    }

    @Override
    public Object visitExprLlamada(LenguajeYParser.ExprLlamadaContext ctx) {
        String idFuncion = ctx.ID().getText();
        List<Expresion> args = new ArrayList<>();
        if (ctx.argumentos() != null) args = (List<Expresion>) visit(ctx.argumentos());

        return new LlamadaFuncion(idFuncion, args, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprInstanciaEstructura(LenguajeYParser.ExprInstanciaEstructuraContext ctx) {
        List<Expresion> elementos = new ArrayList<>();
        if (ctx.argumentos() != null) elementos = (List<Expresion>) visit(ctx.argumentos());

        // En C3D, { 1, 2, 3 } lo manejamos exactamente igual que un arreglo literal en el Heap
        return new ArregloLiteral(elementos, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    // --- PRIMITIVOS ---

    @Override
    public Object visitExprEntero(LenguajeYParser.ExprEnteroContext ctx) {
        return new Primitivo(Integer.parseInt(ctx.getText()), TipoDato.ENTERO, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprFlotante(LenguajeYParser.ExprFlotanteContext ctx) {
        return new Primitivo(Double.parseDouble(ctx.getText()), TipoDato.DECIMAL, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprCadena(LenguajeYParser.ExprCadenaContext ctx) {
        String stringCrudo = ctx.getText();
        String valor = stringCrudo.substring(1, stringCrudo.length() - 1);
        return new Primitivo(valor, TipoDato.CADENA, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprCaracter(LenguajeYParser.ExprCaracterContext ctx) {
        String crudo = ctx.getText();
        String valor = crudo.substring(1, crudo.length() - 1);
        return new Primitivo(valor, TipoDato.CARACTER, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprVerdadero(LenguajeYParser.ExprVerdaderoContext ctx) {
        return new Primitivo(true, TipoDato.BOOLEANO, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }

    @Override
    public Object visitExprFalso(LenguajeYParser.ExprFalsoContext ctx) {
        return new Primitivo(false, TipoDato.BOOLEANO, ctx.getStart().getLine(), ctx.getStart().getCharPositionInLine());
    }
}