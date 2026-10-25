// Generated from C:/Users/Hp/IntelliJProjects/CodexLatinusV3/src/main/antlr4/lenguajeY/LenguajeY.g4 by ANTLR 4.13.2
package gramaticas.y;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LenguajeYParser}.
 */
public interface LenguajeYListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LenguajeYParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(LenguajeYParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeYParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(LenguajeYParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeYParser#seccionEstructuras}.
	 * @param ctx the parse tree
	 */
	void enterSeccionEstructuras(LenguajeYParser.SeccionEstructurasContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeYParser#seccionEstructuras}.
	 * @param ctx the parse tree
	 */
	void exitSeccionEstructuras(LenguajeYParser.SeccionEstructurasContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeYParser#estructuraDef}.
	 * @param ctx the parse tree
	 */
	void enterEstructuraDef(LenguajeYParser.EstructuraDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeYParser#estructuraDef}.
	 * @param ctx the parse tree
	 */
	void exitEstructuraDef(LenguajeYParser.EstructuraDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeYParser#atributo}.
	 * @param ctx the parse tree
	 */
	void enterAtributo(LenguajeYParser.AtributoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeYParser#atributo}.
	 * @param ctx the parse tree
	 */
	void exitAtributo(LenguajeYParser.AtributoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeYParser#seccionFunciones}.
	 * @param ctx the parse tree
	 */
	void enterSeccionFunciones(LenguajeYParser.SeccionFuncionesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeYParser#seccionFunciones}.
	 * @param ctx the parse tree
	 */
	void exitSeccionFunciones(LenguajeYParser.SeccionFuncionesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeYParser#funcionDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncionDef(LenguajeYParser.FuncionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeYParser#funcionDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncionDef(LenguajeYParser.FuncionDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeYParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(LenguajeYParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeYParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(LenguajeYParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeYParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(LenguajeYParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeYParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(LenguajeYParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeYParser#tipoDato}.
	 * @param ctx the parse tree
	 */
	void enterTipoDato(LenguajeYParser.TipoDatoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeYParser#tipoDato}.
	 * @param ctx the parse tree
	 */
	void exitTipoDato(LenguajeYParser.TipoDatoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstDeclaracion}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstDeclaracion(LenguajeYParser.InstDeclaracionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstDeclaracion}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstDeclaracion(LenguajeYParser.InstDeclaracionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstAsignacion}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstAsignacion(LenguajeYParser.InstAsignacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstAsignacion}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstAsignacion(LenguajeYParser.InstAsignacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstInc}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstInc(LenguajeYParser.InstIncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstInc}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstInc(LenguajeYParser.InstIncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstDec}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstDec(LenguajeYParser.InstDecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstDec}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstDec(LenguajeYParser.InstDecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstLlamada}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstLlamada(LenguajeYParser.InstLlamadaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstLlamada}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstLlamada(LenguajeYParser.InstLlamadaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstRetorno}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstRetorno(LenguajeYParser.InstRetornoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstRetorno}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstRetorno(LenguajeYParser.InstRetornoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstRomper}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstRomper(LenguajeYParser.InstRomperContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstRomper}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstRomper(LenguajeYParser.InstRomperContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstContinuar}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstContinuar(LenguajeYParser.InstContinuarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstContinuar}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstContinuar(LenguajeYParser.InstContinuarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstImprimir}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstImprimir(LenguajeYParser.InstImprimirContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstImprimir}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstImprimir(LenguajeYParser.InstImprimirContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstIf}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstIf(LenguajeYParser.InstIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstIf}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstIf(LenguajeYParser.InstIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstSwitch}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstSwitch(LenguajeYParser.InstSwitchContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstSwitch}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstSwitch(LenguajeYParser.InstSwitchContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstFor}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstFor(LenguajeYParser.InstForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstFor}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstFor(LenguajeYParser.InstForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstWhile}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstWhile(LenguajeYParser.InstWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstWhile}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstWhile(LenguajeYParser.InstWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstDoWhile}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstDoWhile(LenguajeYParser.InstDoWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstDoWhile}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstDoWhile(LenguajeYParser.InstDoWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstVacia}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstVacia(LenguajeYParser.InstVaciaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstVacia}
	 * labeled alternative in {@link LenguajeYParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstVacia(LenguajeYParser.InstVaciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeYParser#declaracionLocal}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionLocal(LenguajeYParser.DeclaracionLocalContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeYParser#declaracionLocal}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionLocal(LenguajeYParser.DeclaracionLocalContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeYParser#acceso}.
	 * @param ctx the parse tree
	 */
	void enterAcceso(LenguajeYParser.AccesoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeYParser#acceso}.
	 * @param ctx the parse tree
	 */
	void exitAcceso(LenguajeYParser.AccesoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeYParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(LenguajeYParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeYParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(LenguajeYParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeYParser#switchStmt}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStmt(LenguajeYParser.SwitchStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeYParser#switchStmt}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStmt(LenguajeYParser.SwitchStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeYParser#casoStmt}.
	 * @param ctx the parse tree
	 */
	void enterCasoStmt(LenguajeYParser.CasoStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeYParser#casoStmt}.
	 * @param ctx the parse tree
	 */
	void exitCasoStmt(LenguajeYParser.CasoStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeYParser#defaultStmt}.
	 * @param ctx the parse tree
	 */
	void enterDefaultStmt(LenguajeYParser.DefaultStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeYParser#defaultStmt}.
	 * @param ctx the parse tree
	 */
	void exitDefaultStmt(LenguajeYParser.DefaultStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeYParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(LenguajeYParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeYParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(LenguajeYParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeYParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(LenguajeYParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeYParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(LenguajeYParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeYParser#doWhileStmt}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStmt(LenguajeYParser.DoWhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeYParser#doWhileStmt}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStmt(LenguajeYParser.DoWhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link LenguajeYParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos(LenguajeYParser.ArgumentosContext ctx);
	/**
	 * Exit a parse tree produced by {@link LenguajeYParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos(LenguajeYParser.ArgumentosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprEntero}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprEntero(LenguajeYParser.ExprEnteroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprEntero}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprEntero(LenguajeYParser.ExprEnteroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprInstanciaEstructura}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprInstanciaEstructura(LenguajeYParser.ExprInstanciaEstructuraContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprInstanciaEstructura}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprInstanciaEstructura(LenguajeYParser.ExprInstanciaEstructuraContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprRelacional}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprRelacional(LenguajeYParser.ExprRelacionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprRelacional}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprRelacional(LenguajeYParser.ExprRelacionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprIgualdad}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprIgualdad(LenguajeYParser.ExprIgualdadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprIgualdad}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprIgualdad(LenguajeYParser.ExprIgualdadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprFlotante}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprFlotante(LenguajeYParser.ExprFlotanteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprFlotante}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprFlotante(LenguajeYParser.ExprFlotanteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprCadena}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprCadena(LenguajeYParser.ExprCadenaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprCadena}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprCadena(LenguajeYParser.ExprCadenaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAcceso}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprAcceso(LenguajeYParser.ExprAccesoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAcceso}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprAcceso(LenguajeYParser.ExprAccesoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprCaracter}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprCaracter(LenguajeYParser.ExprCaracterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprCaracter}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprCaracter(LenguajeYParser.ExprCaracterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprLlamada}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprLlamada(LenguajeYParser.ExprLlamadaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprLlamada}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprLlamada(LenguajeYParser.ExprLlamadaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNot}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprNot(LenguajeYParser.ExprNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNot}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprNot(LenguajeYParser.ExprNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprSumaResta}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprSumaResta(LenguajeYParser.ExprSumaRestaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprSumaResta}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprSumaResta(LenguajeYParser.ExprSumaRestaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAnd}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprAnd(LenguajeYParser.ExprAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAnd}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprAnd(LenguajeYParser.ExprAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprParentesis}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprParentesis(LenguajeYParser.ExprParentesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprParentesis}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprParentesis(LenguajeYParser.ExprParentesisContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprFalso}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprFalso(LenguajeYParser.ExprFalsoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprFalso}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprFalso(LenguajeYParser.ExprFalsoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprVerdadero}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprVerdadero(LenguajeYParser.ExprVerdaderoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprVerdadero}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprVerdadero(LenguajeYParser.ExprVerdaderoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprOr}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprOr(LenguajeYParser.ExprOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprOr}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprOr(LenguajeYParser.ExprOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultDiv}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprMultDiv(LenguajeYParser.ExprMultDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultDiv}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprMultDiv(LenguajeYParser.ExprMultDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprLeer}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprLeer(LenguajeYParser.ExprLeerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprLeer}
	 * labeled alternative in {@link LenguajeYParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprLeer(LenguajeYParser.ExprLeerContext ctx);
}