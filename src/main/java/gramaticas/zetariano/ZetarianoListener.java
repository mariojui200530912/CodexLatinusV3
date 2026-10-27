// Generated from C:/Users/Hp/IntelliJProjects/CodexLatinusV3/src/main/antlr4/zetariano/Zetariano.g4 by ANTLR 4.13.2
package gramaticas.zetariano;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ZetarianoParser}.
 */
public interface ZetarianoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(ZetarianoParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(ZetarianoParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#definicionClase}.
	 * @param ctx the parse tree
	 */
	void enterDefinicionClase(ZetarianoParser.DefinicionClaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#definicionClase}.
	 * @param ctx the parse tree
	 */
	void exitDefinicionClase(ZetarianoParser.DefinicionClaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#miembroClase}.
	 * @param ctx the parse tree
	 */
	void enterMiembroClase(ZetarianoParser.MiembroClaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#miembroClase}.
	 * @param ctx the parse tree
	 */
	void exitMiembroClase(ZetarianoParser.MiembroClaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#modificadorAcceso}.
	 * @param ctx the parse tree
	 */
	void enterModificadorAcceso(ZetarianoParser.ModificadorAccesoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#modificadorAcceso}.
	 * @param ctx the parse tree
	 */
	void exitModificadorAcceso(ZetarianoParser.ModificadorAccesoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#tipoDato}.
	 * @param ctx the parse tree
	 */
	void enterTipoDato(ZetarianoParser.TipoDatoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#tipoDato}.
	 * @param ctx the parse tree
	 */
	void exitTipoDato(ZetarianoParser.TipoDatoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#tipoEstructura}.
	 * @param ctx the parse tree
	 */
	void enterTipoEstructura(ZetarianoParser.TipoEstructuraContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#tipoEstructura}.
	 * @param ctx the parse tree
	 */
	void exitTipoEstructura(ZetarianoParser.TipoEstructuraContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#declaracionAtributo}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionAtributo(ZetarianoParser.DeclaracionAtributoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#declaracionAtributo}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionAtributo(ZetarianoParser.DeclaracionAtributoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#constructor}.
	 * @param ctx the parse tree
	 */
	void enterConstructor(ZetarianoParser.ConstructorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#constructor}.
	 * @param ctx the parse tree
	 */
	void exitConstructor(ZetarianoParser.ConstructorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#definicionMetodo}.
	 * @param ctx the parse tree
	 */
	void enterDefinicionMetodo(ZetarianoParser.DefinicionMetodoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#definicionMetodo}.
	 * @param ctx the parse tree
	 */
	void exitDefinicionMetodo(ZetarianoParser.DefinicionMetodoContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(ZetarianoParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(ZetarianoParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(ZetarianoParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(ZetarianoParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(ZetarianoParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(ZetarianoParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void enterInstruccion(ZetarianoParser.InstruccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#instruccion}.
	 * @param ctx the parse tree
	 */
	void exitInstruccion(ZetarianoParser.InstruccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#declaracionLocal}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionLocal(ZetarianoParser.DeclaracionLocalContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#declaracionLocal}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionLocal(ZetarianoParser.DeclaracionLocalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstAsignacion}
	 * labeled alternative in {@link ZetarianoParser#asignacionOMetodo}.
	 * @param ctx the parse tree
	 */
	void enterInstAsignacion(ZetarianoParser.InstAsignacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstAsignacion}
	 * labeled alternative in {@link ZetarianoParser#asignacionOMetodo}.
	 * @param ctx the parse tree
	 */
	void exitInstAsignacion(ZetarianoParser.InstAsignacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstIncremento}
	 * labeled alternative in {@link ZetarianoParser#asignacionOMetodo}.
	 * @param ctx the parse tree
	 */
	void enterInstIncremento(ZetarianoParser.InstIncrementoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstIncremento}
	 * labeled alternative in {@link ZetarianoParser#asignacionOMetodo}.
	 * @param ctx the parse tree
	 */
	void exitInstIncremento(ZetarianoParser.InstIncrementoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstDecremento}
	 * labeled alternative in {@link ZetarianoParser#asignacionOMetodo}.
	 * @param ctx the parse tree
	 */
	void enterInstDecremento(ZetarianoParser.InstDecrementoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstDecremento}
	 * labeled alternative in {@link ZetarianoParser#asignacionOMetodo}.
	 * @param ctx the parse tree
	 */
	void exitInstDecremento(ZetarianoParser.InstDecrementoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstLlamada}
	 * labeled alternative in {@link ZetarianoParser#asignacionOMetodo}.
	 * @param ctx the parse tree
	 */
	void enterInstLlamada(ZetarianoParser.InstLlamadaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstLlamada}
	 * labeled alternative in {@link ZetarianoParser#asignacionOMetodo}.
	 * @param ctx the parse tree
	 */
	void exitInstLlamada(ZetarianoParser.InstLlamadaContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(ZetarianoParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(ZetarianoParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(ZetarianoParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(ZetarianoParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(ZetarianoParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(ZetarianoParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#doWhileStmt}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStmt(ZetarianoParser.DoWhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#doWhileStmt}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStmt(ZetarianoParser.DoWhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#switchStmt}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStmt(ZetarianoParser.SwitchStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#switchStmt}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStmt(ZetarianoParser.SwitchStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#caseCode}.
	 * @param ctx the parse tree
	 */
	void enterCaseCode(ZetarianoParser.CaseCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#caseCode}.
	 * @param ctx the parse tree
	 */
	void exitCaseCode(ZetarianoParser.CaseCodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#defaultCode}.
	 * @param ctx the parse tree
	 */
	void enterDefaultCode(ZetarianoParser.DefaultCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#defaultCode}.
	 * @param ctx the parse tree
	 */
	void exitDefaultCode(ZetarianoParser.DefaultCodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos(ZetarianoParser.ArgumentosContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos(ZetarianoParser.ArgumentosContext ctx);
	/**
	 * Enter a parse tree produced by {@link ZetarianoParser#acceso}.
	 * @param ctx the parse tree
	 */
	void enterAcceso(ZetarianoParser.AccesoContext ctx);
	/**
	 * Exit a parse tree produced by {@link ZetarianoParser#acceso}.
	 * @param ctx the parse tree
	 */
	void exitAcceso(ZetarianoParser.AccesoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAgrupacion}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprAgrupacion(ZetarianoParser.ExprAgrupacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAgrupacion}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprAgrupacion(ZetarianoParser.ExprAgrupacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprArregloLiteral}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprArregloLiteral(ZetarianoParser.ExprArregloLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprArregloLiteral}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprArregloLiteral(ZetarianoParser.ExprArregloLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprEntero}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprEntero(ZetarianoParser.ExprEnteroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprEntero}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprEntero(ZetarianoParser.ExprEnteroContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprRelacional}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprRelacional(ZetarianoParser.ExprRelacionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprRelacional}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprRelacional(ZetarianoParser.ExprRelacionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprIgualdad}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprIgualdad(ZetarianoParser.ExprIgualdadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprIgualdad}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprIgualdad(ZetarianoParser.ExprIgualdadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprDouble}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprDouble(ZetarianoParser.ExprDoubleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprDouble}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprDouble(ZetarianoParser.ExprDoubleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprCadena}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprCadena(ZetarianoParser.ExprCadenaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprCadena}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprCadena(ZetarianoParser.ExprCadenaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprFalse}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprFalse(ZetarianoParser.ExprFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprFalse}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprFalse(ZetarianoParser.ExprFalseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprCaracter}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprCaracter(ZetarianoParser.ExprCaracterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprCaracter}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprCaracter(ZetarianoParser.ExprCaracterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprTrue}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprTrue(ZetarianoParser.ExprTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprTrue}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprTrue(ZetarianoParser.ExprTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprInstanciaObjeto}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprInstanciaObjeto(ZetarianoParser.ExprInstanciaObjetoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprInstanciaObjeto}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprInstanciaObjeto(ZetarianoParser.ExprInstanciaObjetoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNot}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprNot(ZetarianoParser.ExprNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNot}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprNot(ZetarianoParser.ExprNotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAccesoOlamada}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprAccesoOlamada(ZetarianoParser.ExprAccesoOlamadaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAccesoOlamada}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprAccesoOlamada(ZetarianoParser.ExprAccesoOlamadaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprMultDivMod(ZetarianoParser.ExprMultDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprMultDivMod}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprMultDivMod(ZetarianoParser.ExprMultDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprSumaResta}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprSumaResta(ZetarianoParser.ExprSumaRestaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprSumaResta}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprSumaResta(ZetarianoParser.ExprSumaRestaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprAnd}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprAnd(ZetarianoParser.ExprAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprAnd}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprAnd(ZetarianoParser.ExprAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprInstanciaArreglo}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprInstanciaArreglo(ZetarianoParser.ExprInstanciaArregloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprInstanciaArreglo}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprInstanciaArreglo(ZetarianoParser.ExprInstanciaArregloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprTernario}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprTernario(ZetarianoParser.ExprTernarioContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprTernario}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprTernario(ZetarianoParser.ExprTernarioContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprOr}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprOr(ZetarianoParser.ExprOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprOr}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprOr(ZetarianoParser.ExprOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprNull}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprNull(ZetarianoParser.ExprNullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprNull}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprNull(ZetarianoParser.ExprNullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExprReadln}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExprReadln(ZetarianoParser.ExprReadlnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExprReadln}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExprReadln(ZetarianoParser.ExprReadlnContext ctx);
}