// Generated from C:/Users/Hp/IntelliJProjects/CodexLatinusV3/src/main/antlr4/zetariano/Zetariano.g4 by ANTLR 4.13.2
package gramaticas.zetariano;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ZetarianoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ZetarianoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(ZetarianoParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#definicionClase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinicionClase(ZetarianoParser.DefinicionClaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#miembroClase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMiembroClase(ZetarianoParser.MiembroClaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#modificadorAcceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModificadorAcceso(ZetarianoParser.ModificadorAccesoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#tipoDato}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoDato(ZetarianoParser.TipoDatoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#declaracionAtributo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionAtributo(ZetarianoParser.DeclaracionAtributoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#constructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor(ZetarianoParser.ConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#definicionMetodo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinicionMetodo(ZetarianoParser.DefinicionMetodoContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#parametros}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametros(ZetarianoParser.ParametrosContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#parametro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametro(ZetarianoParser.ParametroContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#bloque}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloque(ZetarianoParser.BloqueContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#instruccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstruccion(ZetarianoParser.InstruccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#declaracionLocal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracionLocal(ZetarianoParser.DeclaracionLocalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstAsignacion}
	 * labeled alternative in {@link ZetarianoParser#asignacionOMetodo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstAsignacion(ZetarianoParser.InstAsignacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstIncremento}
	 * labeled alternative in {@link ZetarianoParser#asignacionOMetodo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstIncremento(ZetarianoParser.InstIncrementoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstDecremento}
	 * labeled alternative in {@link ZetarianoParser#asignacionOMetodo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstDecremento(ZetarianoParser.InstDecrementoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstLlamada}
	 * labeled alternative in {@link ZetarianoParser#asignacionOMetodo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstLlamada(ZetarianoParser.InstLlamadaContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(ZetarianoParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(ZetarianoParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#argumentos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentos(ZetarianoParser.ArgumentosContext ctx);
	/**
	 * Visit a parse tree produced by {@link ZetarianoParser#acceso}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAcceso(ZetarianoParser.AccesoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAgrupacion}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAgrupacion(ZetarianoParser.ExprAgrupacionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprEntero}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprEntero(ZetarianoParser.ExprEnteroContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprRelacional}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprRelacional(ZetarianoParser.ExprRelacionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprIgualdad}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprIgualdad(ZetarianoParser.ExprIgualdadContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDouble}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDouble(ZetarianoParser.ExprDoubleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprCadena}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprCadena(ZetarianoParser.ExprCadenaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprFalse}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFalse(ZetarianoParser.ExprFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprTrue}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprTrue(ZetarianoParser.ExprTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprInstanciaObjeto}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprInstanciaObjeto(ZetarianoParser.ExprInstanciaObjetoContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNot}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNot(ZetarianoParser.ExprNotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAccesoOlamada}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAccesoOlamada(ZetarianoParser.ExprAccesoOlamadaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprSumaResta}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprSumaResta(ZetarianoParser.ExprSumaRestaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprAnd}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAnd(ZetarianoParser.ExprAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprInstanciaArreglo}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprInstanciaArreglo(ZetarianoParser.ExprInstanciaArregloContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprOr}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprOr(ZetarianoParser.ExprOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprMultDiv}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMultDiv(ZetarianoParser.ExprMultDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprNull}
	 * labeled alternative in {@link ZetarianoParser#expresion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprNull(ZetarianoParser.ExprNullContext ctx);
}