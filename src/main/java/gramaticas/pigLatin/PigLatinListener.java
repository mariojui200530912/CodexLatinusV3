// Generated from C:/Users/Hp/IntelliJProjects/CodexLatinusV3/src/main/antlr4/pigLatin/PigLatin.g4 by ANTLR 4.13.2
package gramaticas.pigLatin;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PigLatinParser}.
 */
public interface PigLatinListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(PigLatinParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(PigLatinParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#importacion}.
	 * @param ctx the parse tree
	 */
	void enterImportacion(PigLatinParser.ImportacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#importacion}.
	 * @param ctx the parse tree
	 */
	void exitImportacion(PigLatinParser.ImportacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#seccionVariables}.
	 * @param ctx the parse tree
	 */
	void enterSeccionVariables(PigLatinParser.SeccionVariablesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#seccionVariables}.
	 * @param ctx the parse tree
	 */
	void exitSeccionVariables(PigLatinParser.SeccionVariablesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclNormal}
	 * labeled alternative in {@link PigLatinParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclNormal(PigLatinParser.DeclNormalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclNormal}
	 * labeled alternative in {@link PigLatinParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclNormal(PigLatinParser.DeclNormalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclObjetoNovus}
	 * labeled alternative in {@link PigLatinParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclObjetoNovus(PigLatinParser.DeclObjetoNovusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclObjetoNovus}
	 * labeled alternative in {@link PigLatinParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclObjetoNovus(PigLatinParser.DeclObjetoNovusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclObjetoNull}
	 * labeled alternative in {@link PigLatinParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclObjetoNull(PigLatinParser.DeclObjetoNullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclObjetoNull}
	 * labeled alternative in {@link PigLatinParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclObjetoNull(PigLatinParser.DeclObjetoNullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclArreglo}
	 * labeled alternative in {@link PigLatinParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void enterDeclArreglo(PigLatinParser.DeclArregloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclArreglo}
	 * labeled alternative in {@link PigLatinParser#declaracion}.
	 * @param ctx the parse tree
	 */
	void exitDeclArreglo(PigLatinParser.DeclArregloContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#seccionPrincipal}.
	 * @param ctx the parse tree
	 */
	void enterSeccionPrincipal(PigLatinParser.SeccionPrincipalContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#seccionPrincipal}.
	 * @param ctx the parse tree
	 */
	void exitSeccionPrincipal(PigLatinParser.SeccionPrincipalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstAsignacion}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstAsignacion(PigLatinParser.InstAsignacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstAsignacion}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstAsignacion(PigLatinParser.InstAsignacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstInc}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstInc(PigLatinParser.InstIncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstInc}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstInc(PigLatinParser.InstIncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstDec}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstDec(PigLatinParser.InstDecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstDec}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstDec(PigLatinParser.InstDecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstLlamada}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstLlamada(PigLatinParser.InstLlamadaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstLlamada}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstLlamada(PigLatinParser.InstLlamadaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstLeerVar}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstLeerVar(PigLatinParser.InstLeerVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstLeerVar}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstLeerVar(PigLatinParser.InstLeerVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstImprimir}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstImprimir(PigLatinParser.InstImprimirContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstImprimir}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstImprimir(PigLatinParser.InstImprimirContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstSi}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstSi(PigLatinParser.InstSiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstSi}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstSi(PigLatinParser.InstSiContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstDum}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstDum(PigLatinParser.InstDumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstDum}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstDum(PigLatinParser.InstDumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstFacere}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstFacere(PigLatinParser.InstFacereContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstFacere}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstFacere(PigLatinParser.InstFacereContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstPer}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstPer(PigLatinParser.InstPerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstPer}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstPer(PigLatinParser.InstPerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstInterrumpe}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstInterrumpe(PigLatinParser.InstInterrumpeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstInterrumpe}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstInterrumpe(PigLatinParser.InstInterrumpeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstPerge}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstPerge(PigLatinParser.InstPergeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstPerge}
	 * labeled alternative in {@link PigLatinParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstPerge(PigLatinParser.InstPergeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#acceso}.
	 * @param ctx the parse tree
	 */
	void enterAcceso(PigLatinParser.AccesoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#acceso}.
	 * @param ctx the parse tree
	 */
	void exitAcceso(PigLatinParser.AccesoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#tipoDato}.
	 * @param ctx the parse tree
	 */
	void enterTipoDato(PigLatinParser.TipoDatoContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#tipoDato}.
	 * @param ctx the parse tree
	 */
	void exitTipoDato(PigLatinParser.TipoDatoContext ctx);
	/**
	 * Enter a parse tree produced by {@link PigLatinParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos(PigLatinParser.ArgumentosContext ctx);
	/**
	 * Exit a parse tree produced by {@link PigLatinParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos(PigLatinParser.ArgumentosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAgrupacion}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprAgrupacion(PigLatinParser.ExprAgrupacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAgrupacion}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprAgrupacion(PigLatinParser.ExprAgrupacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprEntero}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprEntero(PigLatinParser.ExprEnteroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprEntero}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprEntero(PigLatinParser.ExprEnteroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprLlamadaMetodo}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprLlamadaMetodo(PigLatinParser.ExprLlamadaMetodoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprLlamadaMetodo}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprLlamadaMetodo(PigLatinParser.ExprLlamadaMetodoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprRelacional}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprRelacional(PigLatinParser.ExprRelacionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprRelacional}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprRelacional(PigLatinParser.ExprRelacionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprIgualdad}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprIgualdad(PigLatinParser.ExprIgualdadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprIgualdad}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprIgualdad(PigLatinParser.ExprIgualdadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprCadena}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprCadena(PigLatinParser.ExprCadenaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprCadena}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprCadena(PigLatinParser.ExprCadenaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprInstanciaStruct}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprInstanciaStruct(PigLatinParser.ExprInstanciaStructContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprInstanciaStruct}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprInstanciaStruct(PigLatinParser.ExprInstanciaStructContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprCaracter}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprCaracter(PigLatinParser.ExprCaracterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprCaracter}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprCaracter(PigLatinParser.ExprCaracterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprVerum}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprVerum(PigLatinParser.ExprVerumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprVerum}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprVerum(PigLatinParser.ExprVerumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNot}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprNot(PigLatinParser.ExprNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNot}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprNot(PigLatinParser.ExprNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprSumaResta}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprSumaResta(PigLatinParser.ExprSumaRestaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprSumaResta}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprSumaResta(PigLatinParser.ExprSumaRestaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAnd}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprAnd(PigLatinParser.ExprAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAnd}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprAnd(PigLatinParser.ExprAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprDecimal}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprDecimal(PigLatinParser.ExprDecimalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprDecimal}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprDecimal(PigLatinParser.ExprDecimalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprFalsus}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprFalsus(PigLatinParser.ExprFalsusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprFalsus}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprFalsus(PigLatinParser.ExprFalsusContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprOr}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprOr(PigLatinParser.ExprOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprOr}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprOr(PigLatinParser.ExprOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultDiv}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprMultDiv(PigLatinParser.ExprMultDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultDiv}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprMultDiv(PigLatinParser.ExprMultDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNull}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprNull(PigLatinParser.ExprNullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNull}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprNull(PigLatinParser.ExprNullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAccesoVariable}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprAccesoVariable(PigLatinParser.ExprAccesoVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAccesoVariable}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprAccesoVariable(PigLatinParser.ExprAccesoVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNovus}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprNovus(PigLatinParser.ExprNovusContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNovus}
	 * labeled alternative in {@link PigLatinParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprNovus(PigLatinParser.ExprNovusContext ctx);
}