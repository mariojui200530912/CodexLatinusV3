// Generated from C:/Users/Hp/IntelliJProjects/CodexLatinusV3/src/main/antlr4/pigLatin/PigLatin.g4 by ANTLR 4.13.2
package gramaticas.pigLatin;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class PigLatinParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IMPORT=1, VARIABILES_MAYOR=2, MAIOR_MAYOR=3, FINIS_MAIN=4, ESTO=5, SERIES=6, 
		NOVUS=7, NULL_LIT=8, SI=9, ALITER=10, DUM=11, FACERE=12, PER=13, INTERRUMPE=14, 
		PERGE=15, FINIS=16, NUMERUS=17, DECIMALIS=18, TEXTUM=19, BOOL=20, CARACTER=21, 
		VERUM=22, FALSUS=23, MAYOR_MAYOR=24, MENOR_MENOR=25, DOSPUNTOS=26, IGUAL=27, 
		COMA=28, PAREN_A=29, PAREN_C=30, CORCHETE_A=31, CORCHETE_C=32, LLAVE_A=33, 
		LLAVE_C=34, PUNTOCOMA=35, PUNTO=36, MAS_MAS=37, MENOS_MENOS=38, MAS=39, 
		MENOS=40, MULT=41, DIV=42, MAYOR=43, MENOR=44, MAYOR_IG=45, MENOR_IG=46, 
		IGUAL_IGUAL=47, NOT_IGUAL=48, AND=49, OR=50, NOT=51, ID=52, ENTERO=53, 
		DECIMAL_LIT=54, CADENA=55, CARACTER_LIT=56, WS=57, COMENTARIO_LINEA=58, 
		COMENTARIO_BLOQUE=59;
	public static final int
		RULE_programa = 0, RULE_importacion = 1, RULE_seccionVariables = 2, RULE_declaracion = 3, 
		RULE_seccionPrincipal = 4, RULE_instruccion = 5, RULE_acceso = 6, RULE_tipoDato = 7, 
		RULE_argumentos = 8, RULE_expresion = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "importacion", "seccionVariables", "declaracion", "seccionPrincipal", 
			"instruccion", "acceso", "tipoDato", "argumentos", "expresion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'import'", "'VARIABILES>'", "'MAIOR>'", "'FINIS;'", "'esto'", 
			"'series'", "'novus'", "'null'", "'si'", "'aliter'", "'dum'", "'facere'", 
			"'per'", "'interrumpe'", "'perge'", "'finis'", "'numerus'", "'decimalis'", 
			"'textum'", "'bool'", "'caracter'", "'verum'", "'falsus'", "'>>'", "'<<'", 
			"':'", "'='", "','", "'('", "')'", "'['", "']'", "'{'", "'}'", "';'", 
			"'.'", "'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'>'", "'<'", "'>='", 
			"'<='", "'=='", "'!='", "'&&'", "'||'", "'!'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IMPORT", "VARIABILES_MAYOR", "MAIOR_MAYOR", "FINIS_MAIN", "ESTO", 
			"SERIES", "NOVUS", "NULL_LIT", "SI", "ALITER", "DUM", "FACERE", "PER", 
			"INTERRUMPE", "PERGE", "FINIS", "NUMERUS", "DECIMALIS", "TEXTUM", "BOOL", 
			"CARACTER", "VERUM", "FALSUS", "MAYOR_MAYOR", "MENOR_MENOR", "DOSPUNTOS", 
			"IGUAL", "COMA", "PAREN_A", "PAREN_C", "CORCHETE_A", "CORCHETE_C", "LLAVE_A", 
			"LLAVE_C", "PUNTOCOMA", "PUNTO", "MAS_MAS", "MENOS_MENOS", "MAS", "MENOS", 
			"MULT", "DIV", "MAYOR", "MENOR", "MAYOR_IG", "MENOR_IG", "IGUAL_IGUAL", 
			"NOT_IGUAL", "AND", "OR", "NOT", "ID", "ENTERO", "DECIMAL_LIT", "CADENA", 
			"CARACTER_LIT", "WS", "COMENTARIO_LINEA", "COMENTARIO_BLOQUE"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "PigLatin.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PigLatinParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public SeccionPrincipalContext seccionPrincipal() {
			return getRuleContext(SeccionPrincipalContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PigLatinParser.EOF, 0); }
		public List<ImportacionContext> importacion() {
			return getRuleContexts(ImportacionContext.class);
		}
		public ImportacionContext importacion(int i) {
			return getRuleContext(ImportacionContext.class,i);
		}
		public SeccionVariablesContext seccionVariables() {
			return getRuleContext(SeccionVariablesContext.class,0);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(20);
				importacion();
				}
				}
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VARIABILES_MAYOR) {
				{
				setState(26);
				seccionVariables();
				}
			}

			setState(29);
			seccionPrincipal();
			setState(30);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportacionContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(PigLatinParser.IMPORT, 0); }
		public List<TerminalNode> ID() { return getTokens(PigLatinParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PigLatinParser.ID, i);
		}
		public List<TerminalNode> PUNTO() { return getTokens(PigLatinParser.PUNTO); }
		public TerminalNode PUNTO(int i) {
			return getToken(PigLatinParser.PUNTO, i);
		}
		public ImportacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importacion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterImportacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitImportacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitImportacion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportacionContext importacion() throws RecognitionException {
		ImportacionContext _localctx = new ImportacionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importacion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(IMPORT);
			setState(33);
			match(ID);
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUNTO) {
				{
				{
				setState(34);
				match(PUNTO);
				setState(35);
				match(ID);
				}
				}
				setState(40);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SeccionVariablesContext extends ParserRuleContext {
		public TerminalNode VARIABILES_MAYOR() { return getToken(PigLatinParser.VARIABILES_MAYOR, 0); }
		public List<DeclaracionContext> declaracion() {
			return getRuleContexts(DeclaracionContext.class);
		}
		public DeclaracionContext declaracion(int i) {
			return getRuleContext(DeclaracionContext.class,i);
		}
		public SeccionVariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seccionVariables; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterSeccionVariables(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitSeccionVariables(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitSeccionVariables(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeccionVariablesContext seccionVariables() throws RecognitionException {
		SeccionVariablesContext _localctx = new SeccionVariablesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_seccionVariables);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(VARIABILES_MAYOR);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ESTO || _la==SERIES) {
				{
				{
				setState(42);
				declaracion();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaracionContext extends ParserRuleContext {
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
	 
		public DeclaracionContext() { }
		public void copyFrom(DeclaracionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclObjetoNullContext extends DeclaracionContext {
		public TerminalNode ESTO() { return getToken(PigLatinParser.ESTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public List<TerminalNode> DOSPUNTOS() { return getTokens(PigLatinParser.DOSPUNTOS); }
		public TerminalNode DOSPUNTOS(int i) {
			return getToken(PigLatinParser.DOSPUNTOS, i);
		}
		public TerminalNode NULL_LIT() { return getToken(PigLatinParser.NULL_LIT, 0); }
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
		public DeclObjetoNullContext(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterDeclObjetoNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitDeclObjetoNull(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitDeclObjetoNull(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclNormalContext extends DeclaracionContext {
		public TerminalNode ESTO() { return getToken(PigLatinParser.ESTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode DOSPUNTOS() { return getToken(PigLatinParser.DOSPUNTOS, 0); }
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
		public DeclNormalContext(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterDeclNormal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitDeclNormal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitDeclNormal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclArregloContext extends DeclaracionContext {
		public TerminalNode SERIES() { return getToken(PigLatinParser.SERIES, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode CORCHETE_A() { return getToken(PigLatinParser.CORCHETE_A, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode CORCHETE_C() { return getToken(PigLatinParser.CORCHETE_C, 0); }
		public TerminalNode DOSPUNTOS() { return getToken(PigLatinParser.DOSPUNTOS, 0); }
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
		public TerminalNode LLAVE_A() { return getToken(PigLatinParser.LLAVE_A, 0); }
		public TerminalNode LLAVE_C() { return getToken(PigLatinParser.LLAVE_C, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public DeclArregloContext(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterDeclArreglo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitDeclArreglo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitDeclArreglo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DeclObjetoNovusContext extends DeclaracionContext {
		public TerminalNode ESTO() { return getToken(PigLatinParser.ESTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public List<TerminalNode> DOSPUNTOS() { return getTokens(PigLatinParser.DOSPUNTOS); }
		public TerminalNode DOSPUNTOS(int i) {
			return getToken(PigLatinParser.DOSPUNTOS, i);
		}
		public TerminalNode NOVUS() { return getToken(PigLatinParser.NOVUS, 0); }
		public List<TipoDatoContext> tipoDato() {
			return getRuleContexts(TipoDatoContext.class);
		}
		public TipoDatoContext tipoDato(int i) {
			return getRuleContext(TipoDatoContext.class,i);
		}
		public TerminalNode PAREN_A() { return getToken(PigLatinParser.PAREN_A, 0); }
		public TerminalNode PAREN_C() { return getToken(PigLatinParser.PAREN_C, 0); }
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public DeclObjetoNovusContext(DeclaracionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterDeclObjetoNovus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitDeclObjetoNovus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitDeclObjetoNovus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaracion);
		int _la;
		try {
			setState(93);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new DeclNormalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				match(ESTO);
				setState(49);
				match(ID);
				setState(50);
				match(DOSPUNTOS);
				setState(51);
				tipoDato();
				setState(52);
				expresion(0);
				setState(53);
				match(PUNTOCOMA);
				}
				break;
			case 2:
				_localctx = new DeclObjetoNovusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				match(ESTO);
				setState(56);
				match(ID);
				setState(57);
				match(DOSPUNTOS);
				setState(58);
				match(NOVUS);
				setState(59);
				tipoDato();
				setState(60);
				match(PAREN_A);
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 141863397401559424L) != 0)) {
					{
					setState(61);
					argumentos();
					}
				}

				setState(64);
				match(PAREN_C);
				setState(65);
				match(DOSPUNTOS);
				setState(66);
				tipoDato();
				setState(67);
				match(PUNTOCOMA);
				}
				break;
			case 3:
				_localctx = new DeclObjetoNullContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				match(ESTO);
				setState(70);
				match(ID);
				setState(71);
				match(DOSPUNTOS);
				setState(72);
				match(NULL_LIT);
				setState(73);
				match(DOSPUNTOS);
				setState(74);
				tipoDato();
				setState(75);
				match(PUNTOCOMA);
				}
				break;
			case 4:
				_localctx = new DeclArregloContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				match(SERIES);
				setState(78);
				match(ID);
				setState(79);
				match(CORCHETE_A);
				setState(80);
				expresion(0);
				setState(81);
				match(CORCHETE_C);
				setState(82);
				match(DOSPUNTOS);
				setState(83);
				tipoDato();
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LLAVE_A) {
					{
					setState(84);
					match(LLAVE_A);
					setState(86);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 141863397401559424L) != 0)) {
						{
						setState(85);
						argumentos();
						}
					}

					setState(88);
					match(LLAVE_C);
					}
				}

				setState(91);
				match(PUNTOCOMA);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SeccionPrincipalContext extends ParserRuleContext {
		public TerminalNode MAIOR_MAYOR() { return getToken(PigLatinParser.MAIOR_MAYOR, 0); }
		public TerminalNode FINIS_MAIN() { return getToken(PigLatinParser.FINIS_MAIN, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
		public SeccionPrincipalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seccionPrincipal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterSeccionPrincipal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitSeccionPrincipal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitSeccionPrincipal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeccionPrincipalContext seccionPrincipal() throws RecognitionException {
		SeccionPrincipalContext _localctx = new SeccionPrincipalContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_seccionPrincipal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(MAIOR_MAYOR);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599644211712L) != 0)) {
				{
				{
				setState(96);
				instruccion();
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			match(FINIS_MAIN);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTOCOMA) {
				{
				setState(103);
				match(PUNTOCOMA);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstruccionContext extends ParserRuleContext {
		public InstruccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruccion; }
	 
		public InstruccionContext() { }
		public void copyFrom(InstruccionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstDumContext extends InstruccionContext {
		public TerminalNode DUM() { return getToken(PigLatinParser.DUM, 0); }
		public TerminalNode PAREN_A() { return getToken(PigLatinParser.PAREN_A, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREN_C() { return getToken(PigLatinParser.PAREN_C, 0); }
		public TerminalNode LLAVE_A() { return getToken(PigLatinParser.LLAVE_A, 0); }
		public TerminalNode LLAVE_C() { return getToken(PigLatinParser.LLAVE_C, 0); }
		public TerminalNode FINIS() { return getToken(PigLatinParser.FINIS, 0); }
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public InstDumContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterInstDum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitInstDum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitInstDum(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstPerContext extends InstruccionContext {
		public TerminalNode PER() { return getToken(PigLatinParser.PER, 0); }
		public TerminalNode PAREN_A() { return getToken(PigLatinParser.PAREN_A, 0); }
		public List<TerminalNode> PUNTOCOMA() { return getTokens(PigLatinParser.PUNTOCOMA); }
		public TerminalNode PUNTOCOMA(int i) {
			return getToken(PigLatinParser.PUNTOCOMA, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode PAREN_C() { return getToken(PigLatinParser.PAREN_C, 0); }
		public TerminalNode LLAVE_A() { return getToken(PigLatinParser.LLAVE_A, 0); }
		public TerminalNode LLAVE_C() { return getToken(PigLatinParser.LLAVE_C, 0); }
		public TerminalNode FINIS() { return getToken(PigLatinParser.FINIS, 0); }
		public TerminalNode ESTO() { return getToken(PigLatinParser.ESTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TerminalNode DOSPUNTOS() { return getToken(PigLatinParser.DOSPUNTOS, 0); }
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public List<AccesoContext> acceso() {
			return getRuleContexts(AccesoContext.class);
		}
		public AccesoContext acceso(int i) {
			return getRuleContext(AccesoContext.class,i);
		}
		public List<TerminalNode> IGUAL() { return getTokens(PigLatinParser.IGUAL); }
		public TerminalNode IGUAL(int i) {
			return getToken(PigLatinParser.IGUAL, i);
		}
		public TerminalNode MAS_MAS() { return getToken(PigLatinParser.MAS_MAS, 0); }
		public TerminalNode MENOS_MENOS() { return getToken(PigLatinParser.MENOS_MENOS, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public InstPerContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterInstPer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitInstPer(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitInstPer(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstLlamadaContext extends InstruccionContext {
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public TerminalNode PAREN_A() { return getToken(PigLatinParser.PAREN_A, 0); }
		public TerminalNode PAREN_C() { return getToken(PigLatinParser.PAREN_C, 0); }
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public InstLlamadaContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterInstLlamada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitInstLlamada(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitInstLlamada(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstLeerVarContext extends InstruccionContext {
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public TerminalNode MENOR_MENOR() { return getToken(PigLatinParser.MENOR_MENOR, 0); }
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
		public InstLeerVarContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterInstLeerVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitInstLeerVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitInstLeerVar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstImprimirContext extends InstruccionContext {
		public List<TerminalNode> MAYOR_MAYOR() { return getTokens(PigLatinParser.MAYOR_MAYOR); }
		public TerminalNode MAYOR_MAYOR(int i) {
			return getToken(PigLatinParser.MAYOR_MAYOR, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
		public InstImprimirContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterInstImprimir(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitInstImprimir(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitInstImprimir(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstSiContext extends InstruccionContext {
		public TerminalNode SI() { return getToken(PigLatinParser.SI, 0); }
		public List<TerminalNode> PAREN_A() { return getTokens(PigLatinParser.PAREN_A); }
		public TerminalNode PAREN_A(int i) {
			return getToken(PigLatinParser.PAREN_A, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> PAREN_C() { return getTokens(PigLatinParser.PAREN_C); }
		public TerminalNode PAREN_C(int i) {
			return getToken(PigLatinParser.PAREN_C, i);
		}
		public List<TerminalNode> LLAVE_A() { return getTokens(PigLatinParser.LLAVE_A); }
		public TerminalNode LLAVE_A(int i) {
			return getToken(PigLatinParser.LLAVE_A, i);
		}
		public List<TerminalNode> LLAVE_C() { return getTokens(PigLatinParser.LLAVE_C); }
		public TerminalNode LLAVE_C(int i) {
			return getToken(PigLatinParser.LLAVE_C, i);
		}
		public TerminalNode FINIS() { return getToken(PigLatinParser.FINIS, 0); }
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public List<TerminalNode> ALITER() { return getTokens(PigLatinParser.ALITER); }
		public TerminalNode ALITER(int i) {
			return getToken(PigLatinParser.ALITER, i);
		}
		public InstSiContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterInstSi(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitInstSi(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitInstSi(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstAsignacionContext extends InstruccionContext {
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public TerminalNode IGUAL() { return getToken(PigLatinParser.IGUAL, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
		public InstAsignacionContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterInstAsignacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitInstAsignacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitInstAsignacion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstDecContext extends InstruccionContext {
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public TerminalNode MENOS_MENOS() { return getToken(PigLatinParser.MENOS_MENOS, 0); }
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
		public InstDecContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterInstDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitInstDec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitInstDec(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstFacereContext extends InstruccionContext {
		public TerminalNode FACERE() { return getToken(PigLatinParser.FACERE, 0); }
		public TerminalNode LLAVE_A() { return getToken(PigLatinParser.LLAVE_A, 0); }
		public TerminalNode LLAVE_C() { return getToken(PigLatinParser.LLAVE_C, 0); }
		public TerminalNode DUM() { return getToken(PigLatinParser.DUM, 0); }
		public TerminalNode PAREN_A() { return getToken(PigLatinParser.PAREN_A, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREN_C() { return getToken(PigLatinParser.PAREN_C, 0); }
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public InstFacereContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterInstFacere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitInstFacere(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitInstFacere(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstIncContext extends InstruccionContext {
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public TerminalNode MAS_MAS() { return getToken(PigLatinParser.MAS_MAS, 0); }
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
		public InstIncContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterInstInc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitInstInc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitInstInc(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstInterrumpeContext extends InstruccionContext {
		public TerminalNode INTERRUMPE() { return getToken(PigLatinParser.INTERRUMPE, 0); }
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
		public InstInterrumpeContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterInstInterrumpe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitInstInterrumpe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitInstInterrumpe(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstPergeContext extends InstruccionContext {
		public TerminalNode PERGE() { return getToken(PigLatinParser.PERGE, 0); }
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
		public InstPergeContext(InstruccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterInstPerge(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitInstPerge(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitInstPerge(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstruccionContext instruccion() throws RecognitionException {
		InstruccionContext _localctx = new InstruccionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_instruccion);
		int _la;
		try {
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new InstAsignacionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				acceso();
				setState(107);
				match(IGUAL);
				setState(108);
				expresion(0);
				setState(109);
				match(PUNTOCOMA);
				}
				break;
			case 2:
				_localctx = new InstIncContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				acceso();
				setState(112);
				match(MAS_MAS);
				setState(113);
				match(PUNTOCOMA);
				}
				break;
			case 3:
				_localctx = new InstDecContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(115);
				acceso();
				setState(116);
				match(MENOS_MENOS);
				setState(117);
				match(PUNTOCOMA);
				}
				break;
			case 4:
				_localctx = new InstLlamadaContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(119);
				acceso();
				setState(120);
				match(PAREN_A);
				setState(122);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 141863397401559424L) != 0)) {
					{
					setState(121);
					argumentos();
					}
				}

				setState(124);
				match(PAREN_C);
				setState(125);
				match(PUNTOCOMA);
				}
				break;
			case 5:
				_localctx = new InstLeerVarContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(127);
				acceso();
				setState(128);
				match(MENOR_MENOR);
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTOCOMA) {
					{
					setState(129);
					match(PUNTOCOMA);
					}
				}

				}
				break;
			case 6:
				_localctx = new InstImprimirContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(132);
				match(MAYOR_MAYOR);
				setState(133);
				expresion(0);
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==MAYOR_MAYOR) {
					{
					{
					setState(134);
					match(MAYOR_MAYOR);
					setState(135);
					expresion(0);
					}
					}
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(141);
				match(PUNTOCOMA);
				}
				break;
			case 7:
				_localctx = new InstSiContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(143);
				match(SI);
				setState(144);
				match(PAREN_A);
				setState(145);
				expresion(0);
				setState(146);
				match(PAREN_C);
				setState(147);
				match(LLAVE_A);
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599644211712L) != 0)) {
					{
					{
					setState(148);
					instruccion();
					}
					}
					setState(153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(154);
				match(LLAVE_C);
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ALITER) {
					{
					{
					setState(155);
					match(ALITER);
					setState(160);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==PAREN_A) {
						{
						setState(156);
						match(PAREN_A);
						setState(157);
						expresion(0);
						setState(158);
						match(PAREN_C);
						}
					}

					setState(162);
					match(LLAVE_A);
					setState(166);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599644211712L) != 0)) {
						{
						{
						setState(163);
						instruccion();
						}
						}
						setState(168);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(169);
					match(LLAVE_C);
					}
					}
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(175);
				match(FINIS);
				setState(176);
				match(PUNTOCOMA);
				}
				break;
			case 8:
				_localctx = new InstDumContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(178);
				match(DUM);
				setState(179);
				match(PAREN_A);
				setState(180);
				expresion(0);
				setState(181);
				match(PAREN_C);
				setState(182);
				match(LLAVE_A);
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599644211712L) != 0)) {
					{
					{
					setState(183);
					instruccion();
					}
					}
					setState(188);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(189);
				match(LLAVE_C);
				setState(190);
				match(FINIS);
				setState(191);
				match(PUNTOCOMA);
				}
				break;
			case 9:
				_localctx = new InstFacereContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(193);
				match(FACERE);
				setState(194);
				match(LLAVE_A);
				setState(198);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599644211712L) != 0)) {
					{
					{
					setState(195);
					instruccion();
					}
					}
					setState(200);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(201);
				match(LLAVE_C);
				setState(202);
				match(DUM);
				setState(203);
				match(PAREN_A);
				setState(204);
				expresion(0);
				setState(205);
				match(PAREN_C);
				setState(206);
				match(PUNTOCOMA);
				}
				break;
			case 10:
				_localctx = new InstPerContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(208);
				match(PER);
				setState(209);
				match(PAREN_A);
				setState(220);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ESTO:
					{
					setState(210);
					match(ESTO);
					setState(211);
					match(ID);
					setState(212);
					match(DOSPUNTOS);
					setState(213);
					tipoDato();
					setState(214);
					expresion(0);
					}
					break;
				case ID:
					{
					setState(216);
					acceso();
					setState(217);
					match(IGUAL);
					setState(218);
					expresion(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(222);
				match(PUNTOCOMA);
				setState(223);
				expresion(0);
				setState(224);
				match(PUNTOCOMA);
				setState(235);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
				case 1:
					{
					setState(225);
					acceso();
					setState(226);
					match(MAS_MAS);
					}
					break;
				case 2:
					{
					setState(228);
					acceso();
					setState(229);
					match(MENOS_MENOS);
					}
					break;
				case 3:
					{
					setState(231);
					acceso();
					setState(232);
					match(IGUAL);
					setState(233);
					expresion(0);
					}
					break;
				}
				setState(237);
				match(PAREN_C);
				setState(238);
				match(LLAVE_A);
				setState(242);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599644211712L) != 0)) {
					{
					{
					setState(239);
					instruccion();
					}
					}
					setState(244);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(245);
				match(LLAVE_C);
				setState(246);
				match(FINIS);
				setState(247);
				match(PUNTOCOMA);
				}
				break;
			case 11:
				_localctx = new InstInterrumpeContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(249);
				match(INTERRUMPE);
				setState(250);
				match(PUNTOCOMA);
				}
				break;
			case 12:
				_localctx = new InstPergeContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(251);
				match(PERGE);
				setState(252);
				match(PUNTOCOMA);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AccesoContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(PigLatinParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(PigLatinParser.ID, i);
		}
		public List<TerminalNode> PUNTO() { return getTokens(PigLatinParser.PUNTO); }
		public TerminalNode PUNTO(int i) {
			return getToken(PigLatinParser.PUNTO, i);
		}
		public List<TerminalNode> CORCHETE_A() { return getTokens(PigLatinParser.CORCHETE_A); }
		public TerminalNode CORCHETE_A(int i) {
			return getToken(PigLatinParser.CORCHETE_A, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> CORCHETE_C() { return getTokens(PigLatinParser.CORCHETE_C); }
		public TerminalNode CORCHETE_C(int i) {
			return getToken(PigLatinParser.CORCHETE_C, i);
		}
		public AccesoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_acceso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterAcceso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitAcceso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitAcceso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccesoContext acceso() throws RecognitionException {
		AccesoContext _localctx = new AccesoContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_acceso);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(ID);
			setState(264);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(262);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PUNTO:
						{
						setState(256);
						match(PUNTO);
						setState(257);
						match(ID);
						}
						break;
					case CORCHETE_A:
						{
						setState(258);
						match(CORCHETE_A);
						setState(259);
						expresion(0);
						setState(260);
						match(CORCHETE_C);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(266);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TipoDatoContext extends ParserRuleContext {
		public TerminalNode NUMERUS() { return getToken(PigLatinParser.NUMERUS, 0); }
		public TerminalNode DECIMALIS() { return getToken(PigLatinParser.DECIMALIS, 0); }
		public TerminalNode TEXTUM() { return getToken(PigLatinParser.TEXTUM, 0); }
		public TerminalNode BOOL() { return getToken(PigLatinParser.BOOL, 0); }
		public TerminalNode CARACTER() { return getToken(PigLatinParser.CARACTER, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
		public TipoDatoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipoDato; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterTipoDato(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitTipoDato(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitTipoDato(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoDatoContext tipoDato() throws RecognitionException {
		TipoDatoContext _localctx = new TipoDatoContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tipoDato);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599631433728L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentosContext extends ParserRuleContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> COMA() { return getTokens(PigLatinParser.COMA); }
		public TerminalNode COMA(int i) {
			return getToken(PigLatinParser.COMA, i);
		}
		public ArgumentosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentos; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterArgumentos(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitArgumentos(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitArgumentos(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentosContext argumentos() throws RecognitionException {
		ArgumentosContext _localctx = new ArgumentosContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_argumentos);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			expresion(0);
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(270);
				match(COMA);
				setState(271);
				expresion(0);
				}
				}
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionContext extends ParserRuleContext {
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	 
		public ExpresionContext() { }
		public void copyFrom(ExpresionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAgrupacionContext extends ExpresionContext {
		public TerminalNode PAREN_A() { return getToken(PigLatinParser.PAREN_A, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PAREN_C() { return getToken(PigLatinParser.PAREN_C, 0); }
		public ExprAgrupacionContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterExprAgrupacion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitExprAgrupacion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitExprAgrupacion(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprEnteroContext extends ExpresionContext {
		public TerminalNode ENTERO() { return getToken(PigLatinParser.ENTERO, 0); }
		public ExprEnteroContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterExprEntero(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitExprEntero(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitExprEntero(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprLlamadaMetodoContext extends ExpresionContext {
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public TerminalNode PAREN_A() { return getToken(PigLatinParser.PAREN_A, 0); }
		public TerminalNode PAREN_C() { return getToken(PigLatinParser.PAREN_C, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public ExprLlamadaMetodoContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterExprLlamadaMetodo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitExprLlamadaMetodo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitExprLlamadaMetodo(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprRelacionalContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MAYOR() { return getToken(PigLatinParser.MAYOR, 0); }
		public TerminalNode MENOR() { return getToken(PigLatinParser.MENOR, 0); }
		public TerminalNode MAYOR_IG() { return getToken(PigLatinParser.MAYOR_IG, 0); }
		public TerminalNode MENOR_IG() { return getToken(PigLatinParser.MENOR_IG, 0); }
		public ExprRelacionalContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterExprRelacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitExprRelacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitExprRelacional(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprIgualdadContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode IGUAL_IGUAL() { return getToken(PigLatinParser.IGUAL_IGUAL, 0); }
		public TerminalNode NOT_IGUAL() { return getToken(PigLatinParser.NOT_IGUAL, 0); }
		public ExprIgualdadContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterExprIgualdad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitExprIgualdad(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitExprIgualdad(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprCadenaContext extends ExpresionContext {
		public TerminalNode CADENA() { return getToken(PigLatinParser.CADENA, 0); }
		public ExprCadenaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterExprCadena(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitExprCadena(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitExprCadena(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprInstanciaStructContext extends ExpresionContext {
		public TerminalNode LLAVE_A() { return getToken(PigLatinParser.LLAVE_A, 0); }
		public TerminalNode LLAVE_C() { return getToken(PigLatinParser.LLAVE_C, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public ExprInstanciaStructContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterExprInstanciaStruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitExprInstanciaStruct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitExprInstanciaStruct(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprCaracterContext extends ExpresionContext {
		public TerminalNode CARACTER_LIT() { return getToken(PigLatinParser.CARACTER_LIT, 0); }
		public ExprCaracterContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterExprCaracter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitExprCaracter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitExprCaracter(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprVerumContext extends ExpresionContext {
		public TerminalNode VERUM() { return getToken(PigLatinParser.VERUM, 0); }
		public ExprVerumContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterExprVerum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitExprVerum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitExprVerum(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprNotContext extends ExpresionContext {
		public TerminalNode NOT() { return getToken(PigLatinParser.NOT, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ExprNotContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterExprNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitExprNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitExprNot(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprSumaRestaContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MAS() { return getToken(PigLatinParser.MAS, 0); }
		public TerminalNode MENOS() { return getToken(PigLatinParser.MENOS, 0); }
		public ExprSumaRestaContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterExprSumaResta(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitExprSumaResta(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitExprSumaResta(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAndContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode AND() { return getToken(PigLatinParser.AND, 0); }
		public ExprAndContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterExprAnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitExprAnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitExprAnd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprDecimalContext extends ExpresionContext {
		public TerminalNode DECIMAL_LIT() { return getToken(PigLatinParser.DECIMAL_LIT, 0); }
		public ExprDecimalContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterExprDecimal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitExprDecimal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitExprDecimal(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprFalsusContext extends ExpresionContext {
		public TerminalNode FALSUS() { return getToken(PigLatinParser.FALSUS, 0); }
		public ExprFalsusContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterExprFalsus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitExprFalsus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitExprFalsus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprOrContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode OR() { return getToken(PigLatinParser.OR, 0); }
		public ExprOrContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterExprOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitExprOr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitExprOr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprMultDivContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MULT() { return getToken(PigLatinParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(PigLatinParser.DIV, 0); }
		public ExprMultDivContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterExprMultDiv(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitExprMultDiv(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitExprMultDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprNullContext extends ExpresionContext {
		public TerminalNode NULL_LIT() { return getToken(PigLatinParser.NULL_LIT, 0); }
		public ExprNullContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterExprNull(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitExprNull(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitExprNull(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAccesoVariableContext extends ExpresionContext {
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
		public ExprAccesoVariableContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterExprAccesoVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitExprAccesoVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitExprAccesoVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprNovusContext extends ExpresionContext {
		public TerminalNode NOVUS() { return getToken(PigLatinParser.NOVUS, 0); }
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public TerminalNode PAREN_A() { return getToken(PigLatinParser.PAREN_A, 0); }
		public TerminalNode PAREN_C() { return getToken(PigLatinParser.PAREN_C, 0); }
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public ExprNovusContext(ExpresionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).enterExprNovus(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PigLatinListener ) ((PigLatinListener)listener).exitExprNovus(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PigLatinVisitor ) return ((PigLatinVisitor<? extends T>)visitor).visitExprNovus(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpresionContext expresion() throws RecognitionException {
		return expresion(0);
	}

	private ExpresionContext expresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpresionContext _localctx = new ExpresionContext(_ctx, _parentState);
		ExpresionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expresion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				{
				_localctx = new ExprAgrupacionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(278);
				match(PAREN_A);
				setState(279);
				expresion(0);
				setState(280);
				match(PAREN_C);
				}
				break;
			case 2:
				{
				_localctx = new ExprNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(282);
				match(NOT);
				setState(283);
				expresion(18);
				}
				break;
			case 3:
				{
				_localctx = new ExprEnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(284);
				match(ENTERO);
				}
				break;
			case 4:
				{
				_localctx = new ExprDecimalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(285);
				match(DECIMAL_LIT);
				}
				break;
			case 5:
				{
				_localctx = new ExprCadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(286);
				match(CADENA);
				}
				break;
			case 6:
				{
				_localctx = new ExprCaracterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(287);
				match(CARACTER_LIT);
				}
				break;
			case 7:
				{
				_localctx = new ExprVerumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(288);
				match(VERUM);
				}
				break;
			case 8:
				{
				_localctx = new ExprFalsusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(289);
				match(FALSUS);
				}
				break;
			case 9:
				{
				_localctx = new ExprNullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(290);
				match(NULL_LIT);
				}
				break;
			case 10:
				{
				_localctx = new ExprNovusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(291);
				match(NOVUS);
				setState(292);
				tipoDato();
				setState(293);
				match(PAREN_A);
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 141863397401559424L) != 0)) {
					{
					setState(294);
					argumentos();
					}
				}

				setState(297);
				match(PAREN_C);
				}
				break;
			case 11:
				{
				_localctx = new ExprLlamadaMetodoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(299);
				acceso();
				setState(300);
				match(PAREN_A);
				setState(302);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 141863397401559424L) != 0)) {
					{
					setState(301);
					argumentos();
					}
				}

				setState(304);
				match(PAREN_C);
				}
				break;
			case 12:
				{
				_localctx = new ExprAccesoVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(306);
				acceso();
				}
				break;
			case 13:
				{
				_localctx = new ExprInstanciaStructContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(307);
				match(LLAVE_A);
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 141863397401559424L) != 0)) {
					{
					setState(308);
					argumentos();
					}
				}

				setState(311);
				match(LLAVE_C);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(334);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(332);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMultDivContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(314);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(315);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(316);
						expresion(18);
						}
						break;
					case 2:
						{
						_localctx = new ExprSumaRestaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(317);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(318);
						_la = _input.LA(1);
						if ( !(_la==MAS || _la==MENOS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(319);
						expresion(17);
						}
						break;
					case 3:
						{
						_localctx = new ExprRelacionalContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(320);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(321);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 131941395333120L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(322);
						expresion(16);
						}
						break;
					case 4:
						{
						_localctx = new ExprIgualdadContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(323);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(324);
						_la = _input.LA(1);
						if ( !(_la==IGUAL_IGUAL || _la==NOT_IGUAL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(325);
						expresion(15);
						}
						break;
					case 5:
						{
						_localctx = new ExprAndContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(326);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(327);
						match(AND);
						setState(328);
						expresion(14);
						}
						break;
					case 6:
						{
						_localctx = new ExprOrContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(329);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(330);
						match(OR);
						setState(331);
						expresion(13);
						}
						break;
					}
					} 
				}
				setState(336);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 17);
		case 1:
			return precpred(_ctx, 16);
		case 2:
			return precpred(_ctx, 15);
		case 3:
			return precpred(_ctx, 14);
		case 4:
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001;\u0152\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0005\u0000\u0016\b\u0000\n\u0000"+
		"\f\u0000\u0019\t\u0000\u0001\u0000\u0003\u0000\u001c\b\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001%\b\u0001\n\u0001\f\u0001(\t\u0001\u0001\u0002\u0001\u0002"+
		"\u0005\u0002,\b\u0002\n\u0002\f\u0002/\t\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003?\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003W\b\u0003\u0001\u0003\u0003\u0003Z\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003^\b\u0003\u0001\u0004\u0001\u0004\u0005\u0004b\b\u0004"+
		"\n\u0004\f\u0004e\t\u0004\u0001\u0004\u0001\u0004\u0003\u0004i\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005{\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005\u0083\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005\u0089\b\u0005\n\u0005\f\u0005\u008c\t\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005\u0096\b\u0005\n\u0005\f\u0005\u0099\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u00a1\b\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00a5\b\u0005\n\u0005"+
		"\f\u0005\u00a8\t\u0005\u0001\u0005\u0005\u0005\u00ab\b\u0005\n\u0005\f"+
		"\u0005\u00ae\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00b9"+
		"\b\u0005\n\u0005\f\u0005\u00bc\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00c5\b\u0005"+
		"\n\u0005\f\u0005\u00c8\t\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00dd\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005\u00ec\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005"+
		"\u0005\u00f1\b\u0005\n\u0005\f\u0005\u00f4\t\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005\u00fe\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u0107\b\u0006\n\u0006"+
		"\f\u0006\u010a\t\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b"+
		"\u0005\b\u0111\b\b\n\b\f\b\u0114\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0128\b\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u012f\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t\u0136\b\t\u0001\t\u0003\t\u0139\b\t\u0001\t\u0001\t\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u014d\b\t\n"+
		"\t\f\t\u0150\t\t\u0001\t\u0000\u0001\u0012\n\u0000\u0002\u0004\u0006\b"+
		"\n\f\u000e\u0010\u0012\u0000\u0005\u0002\u0000\u0011\u001544\u0001\u0000"+
		")*\u0001\u0000\'(\u0001\u0000+.\u0001\u0000/0\u0183\u0000\u0017\u0001"+
		"\u0000\u0000\u0000\u0002 \u0001\u0000\u0000\u0000\u0004)\u0001\u0000\u0000"+
		"\u0000\u0006]\u0001\u0000\u0000\u0000\b_\u0001\u0000\u0000\u0000\n\u00fd"+
		"\u0001\u0000\u0000\u0000\f\u00ff\u0001\u0000\u0000\u0000\u000e\u010b\u0001"+
		"\u0000\u0000\u0000\u0010\u010d\u0001\u0000\u0000\u0000\u0012\u0138\u0001"+
		"\u0000\u0000\u0000\u0014\u0016\u0003\u0002\u0001\u0000\u0015\u0014\u0001"+
		"\u0000\u0000\u0000\u0016\u0019\u0001\u0000\u0000\u0000\u0017\u0015\u0001"+
		"\u0000\u0000\u0000\u0017\u0018\u0001\u0000\u0000\u0000\u0018\u001b\u0001"+
		"\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u001a\u001c\u0003"+
		"\u0004\u0002\u0000\u001b\u001a\u0001\u0000\u0000\u0000\u001b\u001c\u0001"+
		"\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u001e\u0003"+
		"\b\u0004\u0000\u001e\u001f\u0005\u0000\u0000\u0001\u001f\u0001\u0001\u0000"+
		"\u0000\u0000 !\u0005\u0001\u0000\u0000!&\u00054\u0000\u0000\"#\u0005$"+
		"\u0000\u0000#%\u00054\u0000\u0000$\"\u0001\u0000\u0000\u0000%(\u0001\u0000"+
		"\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'\u0003"+
		"\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000\u0000)-\u0005\u0002\u0000"+
		"\u0000*,\u0003\u0006\u0003\u0000+*\u0001\u0000\u0000\u0000,/\u0001\u0000"+
		"\u0000\u0000-+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000.\u0005"+
		"\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000\u000001\u0005\u0005\u0000"+
		"\u000012\u00054\u0000\u000023\u0005\u001a\u0000\u000034\u0003\u000e\u0007"+
		"\u000045\u0003\u0012\t\u000056\u0005#\u0000\u00006^\u0001\u0000\u0000"+
		"\u000078\u0005\u0005\u0000\u000089\u00054\u0000\u00009:\u0005\u001a\u0000"+
		"\u0000:;\u0005\u0007\u0000\u0000;<\u0003\u000e\u0007\u0000<>\u0005\u001d"+
		"\u0000\u0000=?\u0003\u0010\b\u0000>=\u0001\u0000\u0000\u0000>?\u0001\u0000"+
		"\u0000\u0000?@\u0001\u0000\u0000\u0000@A\u0005\u001e\u0000\u0000AB\u0005"+
		"\u001a\u0000\u0000BC\u0003\u000e\u0007\u0000CD\u0005#\u0000\u0000D^\u0001"+
		"\u0000\u0000\u0000EF\u0005\u0005\u0000\u0000FG\u00054\u0000\u0000GH\u0005"+
		"\u001a\u0000\u0000HI\u0005\b\u0000\u0000IJ\u0005\u001a\u0000\u0000JK\u0003"+
		"\u000e\u0007\u0000KL\u0005#\u0000\u0000L^\u0001\u0000\u0000\u0000MN\u0005"+
		"\u0006\u0000\u0000NO\u00054\u0000\u0000OP\u0005\u001f\u0000\u0000PQ\u0003"+
		"\u0012\t\u0000QR\u0005 \u0000\u0000RS\u0005\u001a\u0000\u0000SY\u0003"+
		"\u000e\u0007\u0000TV\u0005!\u0000\u0000UW\u0003\u0010\b\u0000VU\u0001"+
		"\u0000\u0000\u0000VW\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000"+
		"XZ\u0005\"\u0000\u0000YT\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000"+
		"Z[\u0001\u0000\u0000\u0000[\\\u0005#\u0000\u0000\\^\u0001\u0000\u0000"+
		"\u0000]0\u0001\u0000\u0000\u0000]7\u0001\u0000\u0000\u0000]E\u0001\u0000"+
		"\u0000\u0000]M\u0001\u0000\u0000\u0000^\u0007\u0001\u0000\u0000\u0000"+
		"_c\u0005\u0003\u0000\u0000`b\u0003\n\u0005\u0000a`\u0001\u0000\u0000\u0000"+
		"be\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000"+
		"\u0000df\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000fh\u0005\u0004"+
		"\u0000\u0000gi\u0005#\u0000\u0000hg\u0001\u0000\u0000\u0000hi\u0001\u0000"+
		"\u0000\u0000i\t\u0001\u0000\u0000\u0000jk\u0003\f\u0006\u0000kl\u0005"+
		"\u001b\u0000\u0000lm\u0003\u0012\t\u0000mn\u0005#\u0000\u0000n\u00fe\u0001"+
		"\u0000\u0000\u0000op\u0003\f\u0006\u0000pq\u0005%\u0000\u0000qr\u0005"+
		"#\u0000\u0000r\u00fe\u0001\u0000\u0000\u0000st\u0003\f\u0006\u0000tu\u0005"+
		"&\u0000\u0000uv\u0005#\u0000\u0000v\u00fe\u0001\u0000\u0000\u0000wx\u0003"+
		"\f\u0006\u0000xz\u0005\u001d\u0000\u0000y{\u0003\u0010\b\u0000zy\u0001"+
		"\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000"+
		"|}\u0005\u001e\u0000\u0000}~\u0005#\u0000\u0000~\u00fe\u0001\u0000\u0000"+
		"\u0000\u007f\u0080\u0003\f\u0006\u0000\u0080\u0082\u0005\u0019\u0000\u0000"+
		"\u0081\u0083\u0005#\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0082"+
		"\u0083\u0001\u0000\u0000\u0000\u0083\u00fe\u0001\u0000\u0000\u0000\u0084"+
		"\u0085\u0005\u0018\u0000\u0000\u0085\u008a\u0003\u0012\t\u0000\u0086\u0087"+
		"\u0005\u0018\u0000\u0000\u0087\u0089\u0003\u0012\t\u0000\u0088\u0086\u0001"+
		"\u0000\u0000\u0000\u0089\u008c\u0001\u0000\u0000\u0000\u008a\u0088\u0001"+
		"\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u008d\u0001"+
		"\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008d\u008e\u0005"+
		"#\u0000\u0000\u008e\u00fe\u0001\u0000\u0000\u0000\u008f\u0090\u0005\t"+
		"\u0000\u0000\u0090\u0091\u0005\u001d\u0000\u0000\u0091\u0092\u0003\u0012"+
		"\t\u0000\u0092\u0093\u0005\u001e\u0000\u0000\u0093\u0097\u0005!\u0000"+
		"\u0000\u0094\u0096\u0003\n\u0005\u0000\u0095\u0094\u0001\u0000\u0000\u0000"+
		"\u0096\u0099\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000"+
		"\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u009a\u0001\u0000\u0000\u0000"+
		"\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u00ac\u0005\"\u0000\u0000\u009b"+
		"\u00a0\u0005\n\u0000\u0000\u009c\u009d\u0005\u001d\u0000\u0000\u009d\u009e"+
		"\u0003\u0012\t\u0000\u009e\u009f\u0005\u001e\u0000\u0000\u009f\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a0\u009c\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a2\u00a6\u0005"+
		"!\u0000\u0000\u00a3\u00a5\u0003\n\u0005\u0000\u00a4\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a5\u00a8\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a9\u0001\u0000"+
		"\u0000\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a9\u00ab\u0005\"\u0000"+
		"\u0000\u00aa\u009b\u0001\u0000\u0000\u0000\u00ab\u00ae\u0001\u0000\u0000"+
		"\u0000\u00ac\u00aa\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000"+
		"\u0000\u00ad\u00af\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001\u0000\u0000"+
		"\u0000\u00af\u00b0\u0005\u0010\u0000\u0000\u00b0\u00b1\u0005#\u0000\u0000"+
		"\u00b1\u00fe\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005\u000b\u0000\u0000"+
		"\u00b3\u00b4\u0005\u001d\u0000\u0000\u00b4\u00b5\u0003\u0012\t\u0000\u00b5"+
		"\u00b6\u0005\u001e\u0000\u0000\u00b6\u00ba\u0005!\u0000\u0000\u00b7\u00b9"+
		"\u0003\n\u0005\u0000\u00b8\u00b7\u0001\u0000\u0000\u0000\u00b9\u00bc\u0001"+
		"\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001"+
		"\u0000\u0000\u0000\u00bb\u00bd\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001"+
		"\u0000\u0000\u0000\u00bd\u00be\u0005\"\u0000\u0000\u00be\u00bf\u0005\u0010"+
		"\u0000\u0000\u00bf\u00c0\u0005#\u0000\u0000\u00c0\u00fe\u0001\u0000\u0000"+
		"\u0000\u00c1\u00c2\u0005\f\u0000\u0000\u00c2\u00c6\u0005!\u0000\u0000"+
		"\u00c3\u00c5\u0003\n\u0005\u0000\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c8\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c7\u00c9\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005\"\u0000\u0000\u00ca\u00cb"+
		"\u0005\u000b\u0000\u0000\u00cb\u00cc\u0005\u001d\u0000\u0000\u00cc\u00cd"+
		"\u0003\u0012\t\u0000\u00cd\u00ce\u0005\u001e\u0000\u0000\u00ce\u00cf\u0005"+
		"#\u0000\u0000\u00cf\u00fe\u0001\u0000\u0000\u0000\u00d0\u00d1\u0005\r"+
		"\u0000\u0000\u00d1\u00dc\u0005\u001d\u0000\u0000\u00d2\u00d3\u0005\u0005"+
		"\u0000\u0000\u00d3\u00d4\u00054\u0000\u0000\u00d4\u00d5\u0005\u001a\u0000"+
		"\u0000\u00d5\u00d6\u0003\u000e\u0007\u0000\u00d6\u00d7\u0003\u0012\t\u0000"+
		"\u00d7\u00dd\u0001\u0000\u0000\u0000\u00d8\u00d9\u0003\f\u0006\u0000\u00d9"+
		"\u00da\u0005\u001b\u0000\u0000\u00da\u00db\u0003\u0012\t\u0000\u00db\u00dd"+
		"\u0001\u0000\u0000\u0000\u00dc\u00d2\u0001\u0000\u0000\u0000\u00dc\u00d8"+
		"\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000\u0000\u00de\u00df"+
		"\u0005#\u0000\u0000\u00df\u00e0\u0003\u0012\t\u0000\u00e0\u00eb\u0005"+
		"#\u0000\u0000\u00e1\u00e2\u0003\f\u0006\u0000\u00e2\u00e3\u0005%\u0000"+
		"\u0000\u00e3\u00ec\u0001\u0000\u0000\u0000\u00e4\u00e5\u0003\f\u0006\u0000"+
		"\u00e5\u00e6\u0005&\u0000\u0000\u00e6\u00ec\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e8\u0003\f\u0006\u0000\u00e8\u00e9\u0005\u001b\u0000\u0000\u00e9\u00ea"+
		"\u0003\u0012\t\u0000\u00ea\u00ec\u0001\u0000\u0000\u0000\u00eb\u00e1\u0001"+
		"\u0000\u0000\u0000\u00eb\u00e4\u0001\u0000\u0000\u0000\u00eb\u00e7\u0001"+
		"\u0000\u0000\u0000\u00ec\u00ed\u0001\u0000\u0000\u0000\u00ed\u00ee\u0005"+
		"\u001e\u0000\u0000\u00ee\u00f2\u0005!\u0000\u0000\u00ef\u00f1\u0003\n"+
		"\u0005\u0000\u00f0\u00ef\u0001\u0000\u0000\u0000\u00f1\u00f4\u0001\u0000"+
		"\u0000\u0000\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f3\u00f5\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f6\u0005\"\u0000\u0000\u00f6\u00f7\u0005\u0010\u0000"+
		"\u0000\u00f7\u00f8\u0005#\u0000\u0000\u00f8\u00fe\u0001\u0000\u0000\u0000"+
		"\u00f9\u00fa\u0005\u000e\u0000\u0000\u00fa\u00fe\u0005#\u0000\u0000\u00fb"+
		"\u00fc\u0005\u000f\u0000\u0000\u00fc\u00fe\u0005#\u0000\u0000\u00fdj\u0001"+
		"\u0000\u0000\u0000\u00fdo\u0001\u0000\u0000\u0000\u00fds\u0001\u0000\u0000"+
		"\u0000\u00fdw\u0001\u0000\u0000\u0000\u00fd\u007f\u0001\u0000\u0000\u0000"+
		"\u00fd\u0084\u0001\u0000\u0000\u0000\u00fd\u008f\u0001\u0000\u0000\u0000"+
		"\u00fd\u00b2\u0001\u0000\u0000\u0000\u00fd\u00c1\u0001\u0000\u0000\u0000"+
		"\u00fd\u00d0\u0001\u0000\u0000\u0000\u00fd\u00f9\u0001\u0000\u0000\u0000"+
		"\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fe\u000b\u0001\u0000\u0000\u0000"+
		"\u00ff\u0108\u00054\u0000\u0000\u0100\u0101\u0005$\u0000\u0000\u0101\u0107"+
		"\u00054\u0000\u0000\u0102\u0103\u0005\u001f\u0000\u0000\u0103\u0104\u0003"+
		"\u0012\t\u0000\u0104\u0105\u0005 \u0000\u0000\u0105\u0107\u0001\u0000"+
		"\u0000\u0000\u0106\u0100\u0001\u0000\u0000\u0000\u0106\u0102\u0001\u0000"+
		"\u0000\u0000\u0107\u010a\u0001\u0000\u0000\u0000\u0108\u0106\u0001\u0000"+
		"\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\r\u0001\u0000\u0000"+
		"\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010b\u010c\u0007\u0000\u0000"+
		"\u0000\u010c\u000f\u0001\u0000\u0000\u0000\u010d\u0112\u0003\u0012\t\u0000"+
		"\u010e\u010f\u0005\u001c\u0000\u0000\u010f\u0111\u0003\u0012\t\u0000\u0110"+
		"\u010e\u0001\u0000\u0000\u0000\u0111\u0114\u0001\u0000\u0000\u0000\u0112"+
		"\u0110\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u0113"+
		"\u0011\u0001\u0000\u0000\u0000\u0114\u0112\u0001\u0000\u0000\u0000\u0115"+
		"\u0116\u0006\t\uffff\uffff\u0000\u0116\u0117\u0005\u001d\u0000\u0000\u0117"+
		"\u0118\u0003\u0012\t\u0000\u0118\u0119\u0005\u001e\u0000\u0000\u0119\u0139"+
		"\u0001\u0000\u0000\u0000\u011a\u011b\u00053\u0000\u0000\u011b\u0139\u0003"+
		"\u0012\t\u0012\u011c\u0139\u00055\u0000\u0000\u011d\u0139\u00056\u0000"+
		"\u0000\u011e\u0139\u00057\u0000\u0000\u011f\u0139\u00058\u0000\u0000\u0120"+
		"\u0139\u0005\u0016\u0000\u0000\u0121\u0139\u0005\u0017\u0000\u0000\u0122"+
		"\u0139\u0005\b\u0000\u0000\u0123\u0124\u0005\u0007\u0000\u0000\u0124\u0125"+
		"\u0003\u000e\u0007\u0000\u0125\u0127\u0005\u001d\u0000\u0000\u0126\u0128"+
		"\u0003\u0010\b\u0000\u0127\u0126\u0001\u0000\u0000\u0000\u0127\u0128\u0001"+
		"\u0000\u0000\u0000\u0128\u0129\u0001\u0000\u0000\u0000\u0129\u012a\u0005"+
		"\u001e\u0000\u0000\u012a\u0139\u0001\u0000\u0000\u0000\u012b\u012c\u0003"+
		"\f\u0006\u0000\u012c\u012e\u0005\u001d\u0000\u0000\u012d\u012f\u0003\u0010"+
		"\b\u0000\u012e\u012d\u0001\u0000\u0000\u0000\u012e\u012f\u0001\u0000\u0000"+
		"\u0000\u012f\u0130\u0001\u0000\u0000\u0000\u0130\u0131\u0005\u001e\u0000"+
		"\u0000\u0131\u0139\u0001\u0000\u0000\u0000\u0132\u0139\u0003\f\u0006\u0000"+
		"\u0133\u0135\u0005!\u0000\u0000\u0134\u0136\u0003\u0010\b\u0000\u0135"+
		"\u0134\u0001\u0000\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136"+
		"\u0137\u0001\u0000\u0000\u0000\u0137\u0139\u0005\"\u0000\u0000\u0138\u0115"+
		"\u0001\u0000\u0000\u0000\u0138\u011a\u0001\u0000\u0000\u0000\u0138\u011c"+
		"\u0001\u0000\u0000\u0000\u0138\u011d\u0001\u0000\u0000\u0000\u0138\u011e"+
		"\u0001\u0000\u0000\u0000\u0138\u011f\u0001\u0000\u0000\u0000\u0138\u0120"+
		"\u0001\u0000\u0000\u0000\u0138\u0121\u0001\u0000\u0000\u0000\u0138\u0122"+
		"\u0001\u0000\u0000\u0000\u0138\u0123\u0001\u0000\u0000\u0000\u0138\u012b"+
		"\u0001\u0000\u0000\u0000\u0138\u0132\u0001\u0000\u0000\u0000\u0138\u0133"+
		"\u0001\u0000\u0000\u0000\u0139\u014e\u0001\u0000\u0000\u0000\u013a\u013b"+
		"\n\u0011\u0000\u0000\u013b\u013c\u0007\u0001\u0000\u0000\u013c\u014d\u0003"+
		"\u0012\t\u0012\u013d\u013e\n\u0010\u0000\u0000\u013e\u013f\u0007\u0002"+
		"\u0000\u0000\u013f\u014d\u0003\u0012\t\u0011\u0140\u0141\n\u000f\u0000"+
		"\u0000\u0141\u0142\u0007\u0003\u0000\u0000\u0142\u014d\u0003\u0012\t\u0010"+
		"\u0143\u0144\n\u000e\u0000\u0000\u0144\u0145\u0007\u0004\u0000\u0000\u0145"+
		"\u014d\u0003\u0012\t\u000f\u0146\u0147\n\r\u0000\u0000\u0147\u0148\u0005"+
		"1\u0000\u0000\u0148\u014d\u0003\u0012\t\u000e\u0149\u014a\n\f\u0000\u0000"+
		"\u014a\u014b\u00052\u0000\u0000\u014b\u014d\u0003\u0012\t\r\u014c\u013a"+
		"\u0001\u0000\u0000\u0000\u014c\u013d\u0001\u0000\u0000\u0000\u014c\u0140"+
		"\u0001\u0000\u0000\u0000\u014c\u0143\u0001\u0000\u0000\u0000\u014c\u0146"+
		"\u0001\u0000\u0000\u0000\u014c\u0149\u0001\u0000\u0000\u0000\u014d\u0150"+
		"\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000\u014e\u014f"+
		"\u0001\u0000\u0000\u0000\u014f\u0013\u0001\u0000\u0000\u0000\u0150\u014e"+
		"\u0001\u0000\u0000\u0000 \u0017\u001b&->VY]chz\u0082\u008a\u0097\u00a0"+
		"\u00a6\u00ac\u00ba\u00c6\u00dc\u00eb\u00f2\u00fd\u0106\u0108\u0112\u0127"+
		"\u012e\u0135\u0138\u014c\u014e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}