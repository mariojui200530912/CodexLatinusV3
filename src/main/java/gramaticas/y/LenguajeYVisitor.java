// Generated from C:/Users/Hp/IntelliJProjects/CodexLatinusV3/src/main/antlr4/lenguajeY/LenguajeY.g4 by ANTLR 4.13.2
package gramaticas.y;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LenguajeYParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LenguajeYVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LenguajeYParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(LenguajeYParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeYParser#seccionEstructuras}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeccionEstructuras(LenguajeYParser.SeccionEstructurasContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeYParser#estructuraDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEstructuraDef(LenguajeYParser.EstructuraDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeYParser#atributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtributo(LenguajeYParser.AtributoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeYParser#seccionFunciones}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeccionFunciones(LenguajeYParser.SeccionFuncionesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeYParser#funcionDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncionDef(LenguajeYParser.FuncionDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeYParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(LenguajeYParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeYParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(LenguajeYParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeYParser#tipoDato}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoDato(LenguajeYParser.TipoDatoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstDeclaracion}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstDeclaracion(LenguajeYParser.InstDeclaracionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstAsignacion}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstAsignacion(LenguajeYParser.InstAsignacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstInc}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstInc(LenguajeYParser.InstIncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstDec}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstDec(LenguajeYParser.InstDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstLlamada}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstLlamada(LenguajeYParser.InstLlamadaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstRetorno}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstRetorno(LenguajeYParser.InstRetornoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstRomper}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstRomper(LenguajeYParser.InstRomperContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstContinuar}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstContinuar(LenguajeYParser.InstContinuarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstImprimir}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstImprimir(LenguajeYParser.InstImprimirContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstIf}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstIf(LenguajeYParser.InstIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstSwitch}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstSwitch(LenguajeYParser.InstSwitchContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstFor}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstFor(LenguajeYParser.InstForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstWhile}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstWhile(LenguajeYParser.InstWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstDoWhile}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstDoWhile(LenguajeYParser.InstDoWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstVacia}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstVacia(LenguajeYParser.InstVaciaContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeYParser#declaracionLocal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionLocal(LenguajeYParser.DeclaracionLocalContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeYParser#acceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcceso(LenguajeYParser.AccesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeYParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(LenguajeYParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeYParser#switchStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStmt(LenguajeYParser.SwitchStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeYParser#casoStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCasoStmt(LenguajeYParser.CasoStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeYParser#defaultStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultStmt(LenguajeYParser.DefaultStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeYParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(LenguajeYParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeYParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(LenguajeYParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeYParser#doWhileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStmt(LenguajeYParser.DoWhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link LenguajeYParser#argumentos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentos(LenguajeYParser.ArgumentosContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprEntero}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprEntero(LenguajeYParser.ExprEnteroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprInstanciaEstructura}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprInstanciaEstructura(LenguajeYParser.ExprInstanciaEstructuraContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprRelacional}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRelacional(LenguajeYParser.ExprRelacionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprIgualdad}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIgualdad(LenguajeYParser.ExprIgualdadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprFlotante}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFlotante(LenguajeYParser.ExprFlotanteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprCadena}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCadena(LenguajeYParser.ExprCadenaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAcceso}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAcceso(LenguajeYParser.ExprAccesoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprCaracter}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCaracter(LenguajeYParser.ExprCaracterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLlamada}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLlamada(LenguajeYParser.ExprLlamadaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNot}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNot(LenguajeYParser.ExprNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSumaResta}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSumaResta(LenguajeYParser.ExprSumaRestaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAnd}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAnd(LenguajeYParser.ExprAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprParentesis}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParentesis(LenguajeYParser.ExprParentesisContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprFalso}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFalso(LenguajeYParser.ExprFalsoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprVerdadero}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprVerdadero(LenguajeYParser.ExprVerdaderoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprOr}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOr(LenguajeYParser.ExprOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMultDiv}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultDiv(LenguajeYParser.ExprMultDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprLeer}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLeer(LenguajeYParser.ExprLeerContext ctx);
}