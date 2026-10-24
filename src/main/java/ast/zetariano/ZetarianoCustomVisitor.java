package ast.zetariano;

import ast.Expresion;
import ast.Instruccion;
import ast.expresiones.*;
import ast.instrucciones.*;
import gramaticas.zetariano.*;
import semantico.Simbolo;
import semantico.TipoDato;
import semantico.ValidadorTipos;

import java.util.ArrayList;
import java.util.List;

public class ZetarianoCustomVisitor extends ZetarianoBaseVisitor<Object> {

    @Override
    public Object visitPrograma(ZetarianoParser.ProgramaContext ctx) {
        List<Instruccion> clases = new ArrayList<>();
        for (ZetarianoParser.DefinicionClaseContext claseCtx : ctx.definicionClase()) {
            Instruccion defClase = (Instruccion) visit(claseCtx);
            if (defClase != null) clases.add(defClase);
        }
        return clases;
    }

    @Override
    public Object visitDefinicionClase(ZetarianoParser.DefinicionClaseContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();

        String visibilidad = ctx.modificadorAcceso() != null ? ctx.modificadorAcceso().getText() : "default";
        String nombreClase = ctx.ID(0).getText();

        String clasePadre = null;
        if (ctx.EXTENDS() != null) {
            clasePadre = ctx.ID(1).getText();
        }

        List<Instruccion> miembros = new ArrayList<>();
        for (ZetarianoParser.MiembroClaseContext miembroCtx : ctx.miembroClase()) {
            Instruccion miembro = (Instruccion) visit(miembroCtx);
            if (miembro != null) miembros.add(miembro);
        }

        return new DefinicionClase(nombreClase, clasePadre, visibilidad, miembros, linea, columna);
    }

    @Override
    public Object visitDeclaracionAtributo(ZetarianoParser.DeclaracionAtributoContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();

        String visibilidad = ctx.modificadorAcceso() != null ? ctx.modificadorAcceso().getText() : "default";
        String tipoString = ctx.tipoDato().getText();
        TipoDato tipo = ValidadorTipos.parsearTipo(tipoString);
        String tipoObjeto = (tipo == TipoDato.OBJETO) ? tipoString : null;

        boolean esArreglo = ctx.CORCHETE_A() != null;
        String idVariable = ctx.ID().getText();

        return new DeclaracionAtributo(visibilidad, tipo, tipoObjeto, idVariable, esArreglo, linea, columna);
    }

    @Override
    public Object visitDefinicionMetodo(ZetarianoParser.DefinicionMetodoContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();

        boolean esOverride = ctx.OVERRIDE() != null;
        String visibilidad = ctx.modificadorAcceso() != null ? ctx.modificadorAcceso().getText() : "default";

        TipoDato tipoRetorno = TipoDato.VOID;
        String tipoObjeto = null;
        if (ctx.tipoDato() != null) {
            String tipoString = ctx.tipoDato().getText();
            tipoRetorno = ValidadorTipos.parsearTipo(tipoString);
            if (tipoRetorno == TipoDato.OBJETO) tipoObjeto = tipoString;
        }

        String idMetodo = ctx.ID().getText();

        List<Simbolo> parametros = new ArrayList<>();
        if (ctx.parametros() != null) {
            parametros = (List<Simbolo>) visit(ctx.parametros());
        }

        List<Instruccion> bloque = (List<Instruccion>) visit(ctx.bloque());

        return new DefinicionMetodo(visibilidad, esOverride, tipoRetorno, tipoObjeto, idMetodo, parametros, bloque, linea, columna);
    }

    @Override
    public Object visitConstructor(ZetarianoParser.ConstructorContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();

        String visibilidad = ctx.modificadorAcceso() != null ? ctx.modificadorAcceso().getText() : "default";
        String idConstructor = ctx.ID().getText();

        List<Simbolo> parametros = new ArrayList<>();
        if (ctx.parametros() != null) {
            parametros = (List<Simbolo>) visit(ctx.parametros());
        }

        List<Instruccion> bloque = (List<Instruccion>) visit(ctx.bloque());

        // El constructor se modela como un metodo que retorna su propia clase
        return new DefinicionMetodo(visibilidad, false, TipoDato.OBJETO, idConstructor, idConstructor, parametros, bloque, linea, columna);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object visitParametros(ZetarianoParser.ParametrosContext ctx) {
        List<Simbolo> listaParams = new ArrayList<>();
        for (ZetarianoParser.ParametroContext paramCtx : ctx.parametro()) {
            listaParams.add((Simbolo) visit(paramCtx));
        }
        return listaParams;
    }

    @Override
    public Object visitParametro(ZetarianoParser.ParametroContext ctx) {
        String tipoString = ctx.tipoDato().getText();
        String idParam = ctx.ID().getText();
        return new Simbolo(idParam, tipoString, "Parametro");
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

    // EXPRESIONES Y ACCESOS
    @Override
    public Object visitAcceso(ZetarianoParser.AccesoContext ctx) {
        int linea = ctx.start.getLine();
        int columna = ctx.start.getCharPositionInLine();

        String idBase = ctx.ID(0).getText();
        Expresion nodoActual;

        // Validar si inicia con 'this.'
        if (ctx.THIS() != null) {
            nodoActual = new AccesoPropiedad(new AccesoVariable("this", linea, columna), idBase, linea, columna);
        } else {
            nodoActual = new AccesoVariable(idBase, linea, columna);
        }

        // Iterar sobre las propiedades anidadas (PUNTO ID) y arreglos
        // (Aquí debes adaptar la lógica que ya tenías en LenguajeYCustomVisitor para anidar AccesoPropiedad y AccesoArreglo)

        return nodoActual;
    }
}