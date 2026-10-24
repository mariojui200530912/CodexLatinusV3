package ast.piglatin;

import ast.Expresion;
import ast.Instruccion;
import ast.expresiones.*;
import ast.instrucciones.*;
import gramaticas.piglatin.*;
import semantico.Simbolo;
import semantico.TipoDato;
import semantico.ValidadorTipos;

import java.util.ArrayList;
import java.util.List;

public class PigLatinCustomVisitor extends PigLatinBaseVisitor<Object> {

    @Override
    public Object visitPrograma(PigLatinParser.ProgramaContext ctx) {
        List<Instruccion> instrucciones = new ArrayList<>();

        if (ctx.seccionVariables() != null) {
            Object vars = visit(ctx.seccionVariables());
            if (vars instanceof List) {
                instrucciones.addAll((List<Instruccion>) vars);
            }
        }

        if (ctx.seccionPrincipal() != null) {
            Object principal = visit(ctx.seccionPrincipal());
            if (principal instanceof List) {
                instrucciones.addAll((List<Instruccion>) principal);
            }
        }

        return instrucciones;
    }

    @Override
    public Object visitSeccionVariables(PigLatinParser.SeccionVariablesContext ctx) {
        List<Instruccion> declaraciones = new ArrayList<>();
        for (PigLatinParser.DeclaracionContext declCtx : ctx.declaracion()) {
            Instruccion decl = (Instruccion) visit(declCtx);
            if (decl != null) declaraciones.add(decl);
        }
        return declaraciones;
    }

    @Override
    public Object visitSeccionPrincipal(PigLatinParser.SeccionPrincipalContext ctx) {
        List<Instruccion> instrucciones = new ArrayList<>();
        for (PigLatinParser.InstruccionContext instCtx : ctx.instruccion()) {
            Instruccion inst = (Instruccion) visit(instCtx);
            if (inst != null) instrucciones.add(inst);
        }
        return instrucciones;
    }

    // DECLARACIONES

    @Override
    public Object visitDeclNormal(PigLatinParser.DeclNormalContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        String idVariable = ctx.ID().getText();
        String tipoString = ctx.tipoDato().getText();
        Expresion valor = (Expresion) visit(ctx.expresion());

        return new Declaracion(idVariable, ValidadorTipos.parsearTipo(tipoString), valor, linea, columna);
    }

    @Override
    public Object visitDeclObjetoNovus(PigLatinParser.DeclObjetoNovusContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        String idVariable = ctx.ID().getText();

        String tipoDatoFinal = ctx.tipoDato(1).getText();

        String tipoInstancia = ctx.tipoDato(0).getText();

        List<Expresion> args = new ArrayList<>();
        if (ctx.argumentos() != null) {
            args = (List<Expresion>) visit(ctx.argumentos());
        }

        InstanciaObjeto instancia = new InstanciaObjeto(tipoInstancia, args, linea, columna);
        return new Declaracion(idVariable, ValidadorTipos.parsearTipo(tipoDatoFinal), instancia, linea, columna);
    }

    @Override
    public Object visitDeclObjetoNull(PigLatinParser.DeclObjetoNullContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        String idVariable = ctx.ID().getText();
        String tipoString = ctx.tipoDato().getText();

        Primitivo valorNull = new Primitivo("null", TipoDato.NULO, linea, columna);
        return new Declaracion(idVariable, ValidadorTipos.parsearTipo(tipoString), valorNull, linea, columna);
    }

    @Override
    public Object visitDeclArreglo(PigLatinParser.DeclArregloContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        String idVariable = ctx.ID().getText();
        String tipoString = ctx.tipoDato().getText();
        Expresion tamanoExpr = (Expresion) visit(ctx.expresion());

        Declaracion decl = new Declaracion(idVariable, ValidadorTipos.parsearTipo(tipoString), null, linea, columna);
        decl.esArreglo = true;
        // Aquí puedes ajustar tu lógica interna de declaración para procesar el tamaño inicial y las listas por defecto

        return decl;
    }

    // EXPRESIONES Y ACCESOS

    @Override
    public Object visitExprNovus(PigLatinParser.ExprNovusContext ctx) {
        String tipoClase = ctx.tipoDato().getText();
        List<Expresion> args = new ArrayList<>();
        if (ctx.argumentos() != null) {
            args = (List<Expresion>) visit(ctx.argumentos());
        }
        return new InstanciaObjeto(tipoClase, args, ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public Object visitExprNull(PigLatinParser.ExprNullContext ctx) {
        return new Primitivo("null", TipoDato.NULO, ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public Object visitInstAsignacion(PigLatinParser.InstAsignacionContext ctx) {
        Expresion accesoDestino = (Expresion) visit(ctx.acceso());
        Expresion valorDerecho = (Expresion) visit(ctx.expresion());
        return new Asignacion(accesoDestino, valorDerecho, ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public Object visitAcceso(PigLatinParser.AccesoContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();
        String idBase = ctx.ID(0).getText();

        Expresion nodoActual = new AccesoVariable(idBase, linea, columna);

        // Lógica para encadenar accesos a propiedades o arreglos (similar al de LenguajeY)
        // nodoActual = new AccesoPropiedad(nodoActual, idSiguiente...);

        return nodoActual;
    }

    @Override
    public Object visitArgumentos(PigLatinParser.ArgumentosContext ctx) {
        List<Expresion> expresiones = new ArrayList<>();
        for (PigLatinParser.ExpresionContext exprCtx : ctx.expresion()) {
            expresiones.add((Expresion) visit(exprCtx));
        }
        return expresiones;
    }

    // (Aquí debes agregar el resto de las visitas básicas: ciclos, operaciones aritméticas e impresión)
}