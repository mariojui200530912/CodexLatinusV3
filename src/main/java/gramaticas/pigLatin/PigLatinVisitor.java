// Generated from C:/Users/Hp/IntelliJProjects/CodexLatinusV3/src/main/antlr4/pigLatin/PigLatin.g4 by ANTLR 4.13.2
package gramaticas.pigLatin;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PigLatinParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PigLatinVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(PigLatinParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#importacion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportacion(PigLatinParser.ImportacionContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#seccionVariables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeccionVariables(PigLatinParser.SeccionVariablesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclNormal}
	 * labeled alternative in {@link PigLatinParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclNormal(PigLatinParser.DeclNormalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclObjetoNovus}
	 * labeled alternative in {@link PigLatinParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclObjetoNovus(PigLatinParser.DeclObjetoNovusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclObjetoNull}
	 * labeled alternative in {@link PigLatinParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclObjetoNull(PigLatinParser.DeclObjetoNullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclArreglo}
	 * labeled alternative in {@link PigLatinParser#declaracion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclArreglo(PigLatinParser.DeclArregloContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#seccionPrincipal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeccionPrincipal(PigLatinParser.SeccionPrincipalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstAsignacion}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstAsignacion(PigLatinParser.InstAsignacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstInc}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstInc(PigLatinParser.InstIncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstDec}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstDec(PigLatinParser.InstDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstLlamada}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstLlamada(PigLatinParser.InstLlamadaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstLeerVar}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstLeerVar(PigLatinParser.InstLeerVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstImprimir}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstImprimir(PigLatinParser.InstImprimirContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstSi}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstSi(PigLatinParser.InstSiContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstDum}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstDum(PigLatinParser.InstDumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstFacere}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstFacere(PigLatinParser.InstFacereContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstPer}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstPer(PigLatinParser.InstPerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstInterrumpe}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstInterrumpe(PigLatinParser.InstInterrumpeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstPerge}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstPerge(PigLatinParser.InstPergeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#acceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcceso(PigLatinParser.AccesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#tipoDato}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoDato(PigLatinParser.TipoDatoContext ctx);
	/**
	 * Visit a parse tree produced by {@link PigLatinParser#argumentos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentos(PigLatinParser.ArgumentosContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAgrupacion}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAgrupacion(PigLatinParser.ExprAgrupacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprEntero}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprEntero(PigLatinParser.ExprEnteroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLlamadaMetodo}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLlamadaMetodo(PigLatinParser.ExprLlamadaMetodoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprRelacional}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRelacional(PigLatinParser.ExprRelacionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprIgualdad}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIgualdad(PigLatinParser.ExprIgualdadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprCadena}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCadena(PigLatinParser.ExprCadenaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprInstanciaStruct}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprInstanciaStruct(PigLatinParser.ExprInstanciaStructContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprCaracter}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCaracter(PigLatinParser.ExprCaracterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprVerum}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprVerum(PigLatinParser.ExprVerumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNot}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNot(PigLatinParser.ExprNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSumaResta}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSumaResta(PigLatinParser.ExprSumaRestaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAnd}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAnd(PigLatinParser.ExprAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDecimal}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDecimal(PigLatinParser.ExprDecimalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprFalsus}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFalsus(PigLatinParser.ExprFalsusContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprOr}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOr(PigLatinParser.ExprOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMultDiv}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultDiv(PigLatinParser.ExprMultDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNull}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNull(PigLatinParser.ExprNullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAccesoVariable}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAccesoVariable(PigLatinParser.ExprAccesoVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNovus}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNovus(PigLatinParser.ExprNovusContext ctx);
}