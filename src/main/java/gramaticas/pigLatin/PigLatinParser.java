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
		PERGE=15, FINIS=16, NUMERUS=17, DECIMALIS=18, TEXTUM=19, BOOL=20, LITTERA=21, 
		VERUM=22, FALSUS=23, MAYOR_MAYOR=24, MENOR_MENOR_MENOR=25, DOSPUNTOS=26, 
		IGUAL=27, COMA=28, PAREN_A=29, PAREN_C=30, CORCHETE_A=31, CORCHETE_C=32, 
		LLAVE_A=33, LLAVE_C=34, PUNTOCOMA=35, PUNTO=36, MAS_MAS=37, MENOS_MENOS=38, 
		MAS=39, MENOS=40, MULT=41, DIV=42, MAYOR=43, MENOR=44, MAYOR_IG=45, MENOR_IG=46, 
		IGUAL_IGUAL=47, NOT_IGUAL=48, AND=49, OR=50, NOT=51, ID=52, ENTERO=53, 
		DECIMAL_LIT=54, CADENA=55, CARACTER_LIT=56, WS=57, COMENTARIO_LINEA=58, 
		COMENTARIO_BLOQUE=59, COMENTARIO_PIG=60;
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
			"'textum'", "'bool'", "'littera'", "'verum'", "'falsus'", "'>>'", "'<<'", 
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
			"LITTERA", "VERUM", "FALSUS", "MAYOR_MAYOR", "MENOR_MENOR_MENOR", "DOSPUNTOS", 
			"IGUAL", "COMA", "PAREN_A", "PAREN_C", "CORCHETE_A", "CORCHETE_C", "LLAVE_A", 
			"LLAVE_C", "PUNTOCOMA", "PUNTO", "MAS_MAS", "MENOS_MENOS", "MAS", "MENOS", 
			"MULT", "DIV", "MAYOR", "MENOR", "MAYOR_IG", "MENOR_IG", "IGUAL_IGUAL", 
			"NOT_IGUAL", "AND", "OR", "NOT", "ID", "ENTERO", "DECIMAL_LIT", "CADENA", 
			"CARACTER_LIT", "WS", "COMENTARIO_LINEA", "COMENTARIO_BLOQUE", "COMENTARIO_PIG"
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
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(IMPORT);
			setState(33);
			match(ID);
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(34);
					match(PUNTO);
					setState(35);
					match(ID);
					}
					} 
				}
				setState(40);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(41);
			match(PUNTO);
			setState(42);
			match(ID);
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTOCOMA) {
				{
				setState(43);
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
			setState(46);
			match(VARIABILES_MAYOR);
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ESTO || _la==SERIES) {
				{
				{
				setState(47);
				declaracion();
				}
				}
				setState(52);
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
		public TerminalNode NULL_LIT() { return getToken(PigLatinParser.NULL_LIT, 0); }
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public List<TerminalNode> DOSPUNTOS() { return getTokens(PigLatinParser.DOSPUNTOS); }
		public TerminalNode DOSPUNTOS(int i) {
			return getToken(PigLatinParser.DOSPUNTOS, i);
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
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode DOSPUNTOS() { return getToken(PigLatinParser.DOSPUNTOS, 0); }
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
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
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
		}
		public TerminalNode DOSPUNTOS() { return getToken(PigLatinParser.DOSPUNTOS, 0); }
		public TerminalNode LLAVE_A() { return getToken(PigLatinParser.LLAVE_A, 0); }
		public TerminalNode LLAVE_C() { return getToken(PigLatinParser.LLAVE_C, 0); }
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
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
		public TerminalNode NOVUS() { return getToken(PigLatinParser.NOVUS, 0); }
		public List<TipoDatoContext> tipoDato() {
			return getRuleContexts(TipoDatoContext.class);
		}
		public TipoDatoContext tipoDato(int i) {
			return getRuleContext(TipoDatoContext.class,i);
		}
		public TerminalNode PAREN_A() { return getToken(PigLatinParser.PAREN_A, 0); }
		public TerminalNode PAREN_C() { return getToken(PigLatinParser.PAREN_C, 0); }
		public List<TerminalNode> DOSPUNTOS() { return getTokens(PigLatinParser.DOSPUNTOS); }
		public TerminalNode DOSPUNTOS(int i) {
			return getToken(PigLatinParser.DOSPUNTOS, i);
		}
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
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
			setState(116);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new DeclNormalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				match(ESTO);
				setState(54);
				match(ID);
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOSPUNTOS) {
					{
					setState(55);
					match(DOSPUNTOS);
					}
				}

				setState(59);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(58);
					tipoDato();
					}
					break;
				}
				setState(61);
				expresion(0);
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTOCOMA) {
					{
					setState(62);
					match(PUNTOCOMA);
					}
				}

				}
				break;
			case 2:
				_localctx = new DeclObjetoNovusContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(65);
				match(ESTO);
				setState(66);
				match(ID);
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOSPUNTOS) {
					{
					setState(67);
					match(DOSPUNTOS);
					}
				}

				setState(70);
				match(NOVUS);
				setState(71);
				tipoDato();
				setState(72);
				match(PAREN_A);
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 141863397401559424L) != 0)) {
					{
					setState(73);
					argumentos();
					}
				}

				setState(76);
				match(PAREN_C);
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOSPUNTOS) {
					{
					setState(77);
					match(DOSPUNTOS);
					setState(78);
					tipoDato();
					}
				}

				setState(82);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTOCOMA) {
					{
					setState(81);
					match(PUNTOCOMA);
					}
				}

				}
				break;
			case 3:
				_localctx = new DeclObjetoNullContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				match(ESTO);
				setState(85);
				match(ID);
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOSPUNTOS) {
					{
					setState(86);
					match(DOSPUNTOS);
					}
				}

				setState(89);
				match(NULL_LIT);
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOSPUNTOS) {
					{
					setState(90);
					match(DOSPUNTOS);
					}
				}

				setState(93);
				tipoDato();
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTOCOMA) {
					{
					setState(94);
					match(PUNTOCOMA);
					}
				}

				}
				break;
			case 4:
				_localctx = new DeclArregloContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(97);
				match(SERIES);
				setState(98);
				match(ID);
				setState(99);
				match(CORCHETE_A);
				setState(100);
				expresion(0);
				setState(101);
				match(CORCHETE_C);
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOSPUNTOS) {
					{
					setState(102);
					match(DOSPUNTOS);
					}
				}

				setState(105);
				tipoDato();
				setState(111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LLAVE_A) {
					{
					setState(106);
					match(LLAVE_A);
					setState(108);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 141863397401559424L) != 0)) {
						{
						setState(107);
						argumentos();
						}
					}

					setState(110);
					match(LLAVE_C);
					}
				}

				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTOCOMA) {
					{
					setState(113);
					match(PUNTOCOMA);
					}
				}

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
			setState(118);
			match(MAIOR_MAYOR);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599677766144L) != 0)) {
				{
				{
				setState(119);
				instruccion();
				}
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(125);
			match(FINIS_MAIN);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTOCOMA) {
				{
				setState(126);
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
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
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
		public TerminalNode ESTO() { return getToken(PigLatinParser.ESTO, 0); }
		public TerminalNode ID() { return getToken(PigLatinParser.ID, 0); }
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
		public TerminalNode FINIS() { return getToken(PigLatinParser.FINIS, 0); }
		public TerminalNode DOSPUNTOS() { return getToken(PigLatinParser.DOSPUNTOS, 0); }
		public TipoDatoContext tipoDato() {
			return getRuleContext(TipoDatoContext.class,0);
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
		public ArgumentosContext argumentos() {
			return getRuleContext(ArgumentosContext.class,0);
		}
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
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
		public TerminalNode MENOR_MENOR_MENOR() { return getToken(PigLatinParser.MENOR_MENOR_MENOR, 0); }
		public AccesoContext acceso() {
			return getRuleContext(AccesoContext.class,0);
		}
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
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
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
		public List<InstruccionContext> instruccion() {
			return getRuleContexts(InstruccionContext.class);
		}
		public InstruccionContext instruccion(int i) {
			return getRuleContext(InstruccionContext.class,i);
		}
		public TerminalNode PUNTOCOMA() { return getToken(PigLatinParser.PUNTOCOMA, 0); }
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
			int _alt;
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				_localctx = new InstAsignacionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				acceso();
				setState(130);
				match(IGUAL);
				setState(131);
				expresion(0);
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTOCOMA) {
					{
					setState(132);
					match(PUNTOCOMA);
					}
				}

				}
				break;
			case 2:
				_localctx = new InstIncContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				acceso();
				setState(136);
				match(MAS_MAS);
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTOCOMA) {
					{
					setState(137);
					match(PUNTOCOMA);
					}
				}

				}
				break;
			case 3:
				_localctx = new InstDecContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				acceso();
				setState(141);
				match(MENOS_MENOS);
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTOCOMA) {
					{
					setState(142);
					match(PUNTOCOMA);
					}
				}

				}
				break;
			case 4:
				_localctx = new InstLlamadaContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(145);
				acceso();
				setState(146);
				match(PAREN_A);
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 141863397401559424L) != 0)) {
					{
					setState(147);
					argumentos();
					}
				}

				setState(150);
				match(PAREN_C);
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTOCOMA) {
					{
					setState(151);
					match(PUNTOCOMA);
					}
				}

				}
				break;
			case 5:
				_localctx = new InstLeerVarContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					setState(154);
					acceso();
					}
				}

				setState(157);
				match(MENOR_MENOR_MENOR);
				setState(159);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTOCOMA) {
					{
					setState(158);
					match(PUNTOCOMA);
					}
				}

				}
				break;
			case 6:
				_localctx = new InstImprimirContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(161);
				match(MAYOR_MAYOR);
				setState(162);
				expresion(0);
				setState(167);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(163);
						match(MAYOR_MAYOR);
						setState(164);
						expresion(0);
						}
						} 
					}
					setState(169);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTOCOMA) {
					{
					setState(170);
					match(PUNTOCOMA);
					}
				}

				}
				break;
			case 7:
				_localctx = new InstSiContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(173);
				match(SI);
				setState(174);
				match(PAREN_A);
				setState(175);
				expresion(0);
				setState(176);
				match(PAREN_C);
				setState(177);
				match(LLAVE_A);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599677766144L) != 0)) {
					{
					{
					setState(178);
					instruccion();
					}
					}
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(184);
				match(LLAVE_C);
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ALITER) {
					{
					{
					setState(185);
					match(ALITER);
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==PAREN_A) {
						{
						setState(186);
						match(PAREN_A);
						setState(187);
						expresion(0);
						setState(188);
						match(PAREN_C);
						}
					}

					setState(192);
					match(LLAVE_A);
					setState(196);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599677766144L) != 0)) {
						{
						{
						setState(193);
						instruccion();
						}
						}
						setState(198);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(199);
					match(LLAVE_C);
					}
					}
					setState(204);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(205);
				match(FINIS);
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTOCOMA) {
					{
					setState(206);
					match(PUNTOCOMA);
					}
				}

				}
				break;
			case 8:
				_localctx = new InstDumContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(209);
				match(DUM);
				setState(210);
				match(PAREN_A);
				setState(211);
				expresion(0);
				setState(212);
				match(PAREN_C);
				setState(213);
				match(LLAVE_A);
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599677766144L) != 0)) {
					{
					{
					setState(214);
					instruccion();
					}
					}
					setState(219);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(220);
				match(LLAVE_C);
				setState(221);
				match(FINIS);
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTOCOMA) {
					{
					setState(222);
					match(PUNTOCOMA);
					}
				}

				}
				break;
			case 9:
				_localctx = new InstFacereContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(225);
				match(FACERE);
				setState(226);
				match(LLAVE_A);
				setState(230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599677766144L) != 0)) {
					{
					{
					setState(227);
					instruccion();
					}
					}
					setState(232);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(233);
				match(LLAVE_C);
				setState(234);
				match(DUM);
				setState(235);
				match(PAREN_A);
				setState(236);
				expresion(0);
				setState(237);
				match(PAREN_C);
				setState(239);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTOCOMA) {
					{
					setState(238);
					match(PUNTOCOMA);
					}
				}

				}
				break;
			case 10:
				_localctx = new InstPerContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(241);
				match(PER);
				setState(242);
				match(PAREN_A);
				setState(256);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ESTO:
					{
					setState(243);
					match(ESTO);
					setState(244);
					match(ID);
					setState(246);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==DOSPUNTOS) {
						{
						setState(245);
						match(DOSPUNTOS);
						}
					}

					setState(249);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
					case 1:
						{
						setState(248);
						tipoDato();
						}
						break;
					}
					setState(251);
					expresion(0);
					}
					break;
				case ID:
					{
					setState(252);
					acceso();
					setState(253);
					match(IGUAL);
					setState(254);
					expresion(0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(258);
				match(PUNTOCOMA);
				setState(259);
				expresion(0);
				setState(260);
				match(PUNTOCOMA);
				setState(271);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
				case 1:
					{
					setState(261);
					acceso();
					setState(262);
					match(MAS_MAS);
					}
					break;
				case 2:
					{
					setState(264);
					acceso();
					setState(265);
					match(MENOS_MENOS);
					}
					break;
				case 3:
					{
					setState(267);
					acceso();
					setState(268);
					match(IGUAL);
					setState(269);
					expresion(0);
					}
					break;
				}
				setState(273);
				match(PAREN_C);
				setState(274);
				match(LLAVE_A);
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4503599677766144L) != 0)) {
					{
					{
					setState(275);
					instruccion();
					}
					}
					setState(280);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(281);
				match(LLAVE_C);
				setState(283);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FINIS) {
					{
					setState(282);
					match(FINIS);
					}
				}

				setState(286);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTOCOMA) {
					{
					setState(285);
					match(PUNTOCOMA);
					}
				}

				}
				break;
			case 11:
				_localctx = new InstInterrumpeContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(288);
				match(INTERRUMPE);
				setState(290);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTOCOMA) {
					{
					setState(289);
					match(PUNTOCOMA);
					}
				}

				}
				break;
			case 12:
				_localctx = new InstPergeContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(292);
				match(PERGE);
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUNTOCOMA) {
					{
					setState(293);
					match(PUNTOCOMA);
					}
				}

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
			setState(298);
			match(ID);
			setState(307);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(305);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case PUNTO:
						{
						setState(299);
						match(PUNTO);
						setState(300);
						match(ID);
						}
						break;
					case CORCHETE_A:
						{
						setState(301);
						match(CORCHETE_A);
						setState(302);
						expresion(0);
						setState(303);
						match(CORCHETE_C);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(309);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
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
		public TerminalNode LITTERA() { return getToken(PigLatinParser.LITTERA, 0); }
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
			setState(310);
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
			setState(312);
			expresion(0);
			setState(317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMA) {
				{
				{
				setState(313);
				match(COMA);
				setState(314);
				expresion(0);
				}
				}
				setState(319);
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
			setState(355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				{
				_localctx = new ExprAgrupacionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(321);
				match(PAREN_A);
				setState(322);
				expresion(0);
				setState(323);
				match(PAREN_C);
				}
				break;
			case 2:
				{
				_localctx = new ExprNotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(325);
				match(NOT);
				setState(326);
				expresion(18);
				}
				break;
			case 3:
				{
				_localctx = new ExprEnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(327);
				match(ENTERO);
				}
				break;
			case 4:
				{
				_localctx = new ExprDecimalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(328);
				match(DECIMAL_LIT);
				}
				break;
			case 5:
				{
				_localctx = new ExprCadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(329);
				match(CADENA);
				}
				break;
			case 6:
				{
				_localctx = new ExprCaracterContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(330);
				match(CARACTER_LIT);
				}
				break;
			case 7:
				{
				_localctx = new ExprVerumContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(331);
				match(VERUM);
				}
				break;
			case 8:
				{
				_localctx = new ExprFalsusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(332);
				match(FALSUS);
				}
				break;
			case 9:
				{
				_localctx = new ExprNullContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(333);
				match(NULL_LIT);
				}
				break;
			case 10:
				{
				_localctx = new ExprNovusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(334);
				match(NOVUS);
				setState(335);
				tipoDato();
				setState(336);
				match(PAREN_A);
				setState(338);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 141863397401559424L) != 0)) {
					{
					setState(337);
					argumentos();
					}
				}

				setState(340);
				match(PAREN_C);
				}
				break;
			case 11:
				{
				_localctx = new ExprLlamadaMetodoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(342);
				acceso();
				setState(343);
				match(PAREN_A);
				setState(345);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 141863397401559424L) != 0)) {
					{
					setState(344);
					argumentos();
					}
				}

				setState(347);
				match(PAREN_C);
				}
				break;
			case 12:
				{
				_localctx = new ExprAccesoVariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(349);
				acceso();
				}
				break;
			case 13:
				{
				_localctx = new ExprInstanciaStructContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(350);
				match(LLAVE_A);
				setState(352);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 141863397401559424L) != 0)) {
					{
					setState(351);
					argumentos();
					}
				}

				setState(354);
				match(LLAVE_C);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(377);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(375);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
					case 1:
						{
						_localctx = new ExprMultDivContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(357);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(358);
						_la = _input.LA(1);
						if ( !(_la==MULT || _la==DIV) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(359);
						expresion(18);
						}
						break;
					case 2:
						{
						_localctx = new ExprSumaRestaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(360);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(361);
						_la = _input.LA(1);
						if ( !(_la==MAS || _la==MENOS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(362);
						expresion(17);
						}
						break;
					case 3:
						{
						_localctx = new ExprRelacionalContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(363);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(364);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 131941395333120L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(365);
						expresion(16);
						}
						break;
					case 4:
						{
						_localctx = new ExprIgualdadContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(366);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(367);
						_la = _input.LA(1);
						if ( !(_la==IGUAL_IGUAL || _la==NOT_IGUAL) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(368);
						expresion(15);
						}
						break;
					case 5:
						{
						_localctx = new ExprAndContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(369);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(370);
						match(AND);
						setState(371);
						expresion(14);
						}
						break;
					case 6:
						{
						_localctx = new ExprOrContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(372);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(373);
						match(OR);
						setState(374);
						expresion(13);
						}
						break;
					}
					} 
				}
				setState(379);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
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
		"\u0004\u0001<\u017d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0005\u0000\u0016\b\u0000\n\u0000"+
		"\f\u0000\u0019\t\u0000\u0001\u0000\u0003\u0000\u001c\b\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0005\u0001%\b\u0001\n\u0001\f\u0001(\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001-\b\u0001\u0001\u0002\u0001\u0002\u0005\u0002"+
		"1\b\u0002\n\u0002\f\u00024\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u00039\b\u0003\u0001\u0003\u0003\u0003<\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003@\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003E\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003"+
		"\u0003K\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003P\b\u0003"+
		"\u0001\u0003\u0003\u0003S\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u0003X\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003\\\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0003\u0003`\b\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003h\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003m\b\u0003\u0001\u0003\u0003"+
		"\u0003p\b\u0003\u0001\u0003\u0003\u0003s\b\u0003\u0003\u0003u\b\u0003"+
		"\u0001\u0004\u0001\u0004\u0005\u0004y\b\u0004\n\u0004\f\u0004|\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004\u0080\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005\u0086\b\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u008b\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005\u0090\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u0095\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0099\b\u0005\u0001"+
		"\u0005\u0003\u0005\u009c\b\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00a0"+
		"\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00a6"+
		"\b\u0005\n\u0005\f\u0005\u00a9\t\u0005\u0001\u0005\u0003\u0005\u00ac\b"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005\u00b4\b\u0005\n\u0005\f\u0005\u00b7\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u00bf\b\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u00c3\b\u0005\n\u0005"+
		"\f\u0005\u00c6\t\u0005\u0001\u0005\u0005\u0005\u00c9\b\u0005\n\u0005\f"+
		"\u0005\u00cc\t\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u00d0\b\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005\u00d8\b\u0005\n\u0005\f\u0005\u00db\t\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005\u00e0\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005\u00e5\b\u0005\n\u0005\f\u0005\u00e8\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005"+
		"\u00f0\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005\u00f7\b\u0005\u0001\u0005\u0003\u0005\u00fa\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0101"+
		"\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005\u0110\b\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0005\u0005\u0115\b\u0005\n\u0005\f\u0005\u0118\t\u0005\u0001\u0005"+
		"\u0001\u0005\u0003\u0005\u011c\b\u0005\u0001\u0005\u0003\u0005\u011f\b"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0123\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005\u0127\b\u0005\u0003\u0005\u0129\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0005\u0006\u0132\b\u0006\n\u0006\f\u0006\u0135\t\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u013c\b\b\n\b\f\b\u013f\t\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\t\u0153\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u015a\b\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0161\b\t\u0001\t\u0003"+
		"\t\u0164\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0005\t\u0178\b\t\n\t\f\t\u017b\t\t\u0001\t\u0000\u0001\u0012"+
		"\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0005\u0002\u0000"+
		"\u0011\u001544\u0001\u0000)*\u0001\u0000\'(\u0001\u0000+.\u0001\u0000"+
		"/0\u01c9\u0000\u0017\u0001\u0000\u0000\u0000\u0002 \u0001\u0000\u0000"+
		"\u0000\u0004.\u0001\u0000\u0000\u0000\u0006t\u0001\u0000\u0000\u0000\b"+
		"v\u0001\u0000\u0000\u0000\n\u0128\u0001\u0000\u0000\u0000\f\u012a\u0001"+
		"\u0000\u0000\u0000\u000e\u0136\u0001\u0000\u0000\u0000\u0010\u0138\u0001"+
		"\u0000\u0000\u0000\u0012\u0163\u0001\u0000\u0000\u0000\u0014\u0016\u0003"+
		"\u0002\u0001\u0000\u0015\u0014\u0001\u0000\u0000\u0000\u0016\u0019\u0001"+
		"\u0000\u0000\u0000\u0017\u0015\u0001\u0000\u0000\u0000\u0017\u0018\u0001"+
		"\u0000\u0000\u0000\u0018\u001b\u0001\u0000\u0000\u0000\u0019\u0017\u0001"+
		"\u0000\u0000\u0000\u001a\u001c\u0003\u0004\u0002\u0000\u001b\u001a\u0001"+
		"\u0000\u0000\u0000\u001b\u001c\u0001\u0000\u0000\u0000\u001c\u001d\u0001"+
		"\u0000\u0000\u0000\u001d\u001e\u0003\b\u0004\u0000\u001e\u001f\u0005\u0000"+
		"\u0000\u0001\u001f\u0001\u0001\u0000\u0000\u0000 !\u0005\u0001\u0000\u0000"+
		"!&\u00054\u0000\u0000\"#\u0005$\u0000\u0000#%\u00054\u0000\u0000$\"\u0001"+
		"\u0000\u0000\u0000%(\u0001\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000"+
		"&\'\u0001\u0000\u0000\u0000\')\u0001\u0000\u0000\u0000(&\u0001\u0000\u0000"+
		"\u0000)*\u0005$\u0000\u0000*,\u00054\u0000\u0000+-\u0005#\u0000\u0000"+
		",+\u0001\u0000\u0000\u0000,-\u0001\u0000\u0000\u0000-\u0003\u0001\u0000"+
		"\u0000\u0000.2\u0005\u0002\u0000\u0000/1\u0003\u0006\u0003\u00000/\u0001"+
		"\u0000\u0000\u000014\u0001\u0000\u0000\u000020\u0001\u0000\u0000\u0000"+
		"23\u0001\u0000\u0000\u00003\u0005\u0001\u0000\u0000\u000042\u0001\u0000"+
		"\u0000\u000056\u0005\u0005\u0000\u000068\u00054\u0000\u000079\u0005\u001a"+
		"\u0000\u000087\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009;\u0001"+
		"\u0000\u0000\u0000:<\u0003\u000e\u0007\u0000;:\u0001\u0000\u0000\u0000"+
		";<\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=?\u0003\u0012\t\u0000"+
		">@\u0005#\u0000\u0000?>\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000"+
		"@u\u0001\u0000\u0000\u0000AB\u0005\u0005\u0000\u0000BD\u00054\u0000\u0000"+
		"CE\u0005\u001a\u0000\u0000DC\u0001\u0000\u0000\u0000DE\u0001\u0000\u0000"+
		"\u0000EF\u0001\u0000\u0000\u0000FG\u0005\u0007\u0000\u0000GH\u0003\u000e"+
		"\u0007\u0000HJ\u0005\u001d\u0000\u0000IK\u0003\u0010\b\u0000JI\u0001\u0000"+
		"\u0000\u0000JK\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000LO\u0005"+
		"\u001e\u0000\u0000MN\u0005\u001a\u0000\u0000NP\u0003\u000e\u0007\u0000"+
		"OM\u0001\u0000\u0000\u0000OP\u0001\u0000\u0000\u0000PR\u0001\u0000\u0000"+
		"\u0000QS\u0005#\u0000\u0000RQ\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000"+
		"\u0000Su\u0001\u0000\u0000\u0000TU\u0005\u0005\u0000\u0000UW\u00054\u0000"+
		"\u0000VX\u0005\u001a\u0000\u0000WV\u0001\u0000\u0000\u0000WX\u0001\u0000"+
		"\u0000\u0000XY\u0001\u0000\u0000\u0000Y[\u0005\b\u0000\u0000Z\\\u0005"+
		"\u001a\u0000\u0000[Z\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000"+
		"\\]\u0001\u0000\u0000\u0000]_\u0003\u000e\u0007\u0000^`\u0005#\u0000\u0000"+
		"_^\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`u\u0001\u0000\u0000"+
		"\u0000ab\u0005\u0006\u0000\u0000bc\u00054\u0000\u0000cd\u0005\u001f\u0000"+
		"\u0000de\u0003\u0012\t\u0000eg\u0005 \u0000\u0000fh\u0005\u001a\u0000"+
		"\u0000gf\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000hi\u0001\u0000"+
		"\u0000\u0000io\u0003\u000e\u0007\u0000jl\u0005!\u0000\u0000km\u0003\u0010"+
		"\b\u0000lk\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mn\u0001\u0000"+
		"\u0000\u0000np\u0005\"\u0000\u0000oj\u0001\u0000\u0000\u0000op\u0001\u0000"+
		"\u0000\u0000pr\u0001\u0000\u0000\u0000qs\u0005#\u0000\u0000rq\u0001\u0000"+
		"\u0000\u0000rs\u0001\u0000\u0000\u0000su\u0001\u0000\u0000\u0000t5\u0001"+
		"\u0000\u0000\u0000tA\u0001\u0000\u0000\u0000tT\u0001\u0000\u0000\u0000"+
		"ta\u0001\u0000\u0000\u0000u\u0007\u0001\u0000\u0000\u0000vz\u0005\u0003"+
		"\u0000\u0000wy\u0003\n\u0005\u0000xw\u0001\u0000\u0000\u0000y|\u0001\u0000"+
		"\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{}\u0001"+
		"\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000}\u007f\u0005\u0004\u0000"+
		"\u0000~\u0080\u0005#\u0000\u0000\u007f~\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0001\u0000\u0000\u0000\u0080\t\u0001\u0000\u0000\u0000\u0081\u0082"+
		"\u0003\f\u0006\u0000\u0082\u0083\u0005\u001b\u0000\u0000\u0083\u0085\u0003"+
		"\u0012\t\u0000\u0084\u0086\u0005#\u0000\u0000\u0085\u0084\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0129\u0001\u0000"+
		"\u0000\u0000\u0087\u0088\u0003\f\u0006\u0000\u0088\u008a\u0005%\u0000"+
		"\u0000\u0089\u008b\u0005#\u0000\u0000\u008a\u0089\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u0129\u0001\u0000\u0000\u0000"+
		"\u008c\u008d\u0003\f\u0006\u0000\u008d\u008f\u0005&\u0000\u0000\u008e"+
		"\u0090\u0005#\u0000\u0000\u008f\u008e\u0001\u0000\u0000\u0000\u008f\u0090"+
		"\u0001\u0000\u0000\u0000\u0090\u0129\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0003\f\u0006\u0000\u0092\u0094\u0005\u001d\u0000\u0000\u0093\u0095\u0003"+
		"\u0010\b\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000"+
		"\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u0098\u0005\u001e"+
		"\u0000\u0000\u0097\u0099\u0005#\u0000\u0000\u0098\u0097\u0001\u0000\u0000"+
		"\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u0129\u0001\u0000\u0000"+
		"\u0000\u009a\u009c\u0003\f\u0006\u0000\u009b\u009a\u0001\u0000\u0000\u0000"+
		"\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000"+
		"\u009d\u009f\u0005\u0019\u0000\u0000\u009e\u00a0\u0005#\u0000\u0000\u009f"+
		"\u009e\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0"+
		"\u0129\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005\u0018\u0000\u0000\u00a2"+
		"\u00a7\u0003\u0012\t\u0000\u00a3\u00a4\u0005\u0018\u0000\u0000\u00a4\u00a6"+
		"\u0003\u0012\t\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001"+
		"\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ac\u0005#\u0000\u0000\u00ab\u00aa\u0001\u0000"+
		"\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000\u0000\u00ac\u0129\u0001\u0000"+
		"\u0000\u0000\u00ad\u00ae\u0005\t\u0000\u0000\u00ae\u00af\u0005\u001d\u0000"+
		"\u0000\u00af\u00b0\u0003\u0012\t\u0000\u00b0\u00b1\u0005\u001e\u0000\u0000"+
		"\u00b1\u00b5\u0005!\u0000\u0000\u00b2\u00b4\u0003\n\u0005\u0000\u00b3"+
		"\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b7\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6"+
		"\u00b8\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b8"+
		"\u00ca\u0005\"\u0000\u0000\u00b9\u00be\u0005\n\u0000\u0000\u00ba\u00bb"+
		"\u0005\u001d\u0000\u0000\u00bb\u00bc\u0003\u0012\t\u0000\u00bc\u00bd\u0005"+
		"\u001e\u0000\u0000\u00bd\u00bf\u0001\u0000\u0000\u0000\u00be\u00ba\u0001"+
		"\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001"+
		"\u0000\u0000\u0000\u00c0\u00c4\u0005!\u0000\u0000\u00c1\u00c3\u0003\n"+
		"\u0005\u0000\u00c2\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c7\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000"+
		"\u0000\u0000\u00c7\u00c9\u0005\"\u0000\u0000\u00c8\u00b9\u0001\u0000\u0000"+
		"\u0000\u00c9\u00cc\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000"+
		"\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u00cd\u0001\u0000\u0000"+
		"\u0000\u00cc\u00ca\u0001\u0000\u0000\u0000\u00cd\u00cf\u0005\u0010\u0000"+
		"\u0000\u00ce\u00d0\u0005#\u0000\u0000\u00cf\u00ce\u0001\u0000\u0000\u0000"+
		"\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u0129\u0001\u0000\u0000\u0000"+
		"\u00d1\u00d2\u0005\u000b\u0000\u0000\u00d2\u00d3\u0005\u001d\u0000\u0000"+
		"\u00d3\u00d4\u0003\u0012\t\u0000\u00d4\u00d5\u0005\u001e\u0000\u0000\u00d5"+
		"\u00d9\u0005!\u0000\u0000\u00d6\u00d8\u0003\n\u0005\u0000\u00d7\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9\u00d7"+
		"\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00dc"+
		"\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc\u00dd"+
		"\u0005\"\u0000\u0000\u00dd\u00df\u0005\u0010\u0000\u0000\u00de\u00e0\u0005"+
		"#\u0000\u0000\u00df\u00de\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000"+
		"\u0000\u0000\u00e0\u0129\u0001\u0000\u0000\u0000\u00e1\u00e2\u0005\f\u0000"+
		"\u0000\u00e2\u00e6\u0005!\u0000\u0000\u00e3\u00e5\u0003\n\u0005\u0000"+
		"\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e5\u00e8\u0001\u0000\u0000\u0000"+
		"\u00e6\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000"+
		"\u00e7\u00e9\u0001\u0000\u0000\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000"+
		"\u00e9\u00ea\u0005\"\u0000\u0000\u00ea\u00eb\u0005\u000b\u0000\u0000\u00eb"+
		"\u00ec\u0005\u001d\u0000\u0000\u00ec\u00ed\u0003\u0012\t\u0000\u00ed\u00ef"+
		"\u0005\u001e\u0000\u0000\u00ee\u00f0\u0005#\u0000\u0000\u00ef\u00ee\u0001"+
		"\u0000\u0000\u0000\u00ef\u00f0\u0001\u0000\u0000\u0000\u00f0\u0129\u0001"+
		"\u0000\u0000\u0000\u00f1\u00f2\u0005\r\u0000\u0000\u00f2\u0100\u0005\u001d"+
		"\u0000\u0000\u00f3\u00f4\u0005\u0005\u0000\u0000\u00f4\u00f6\u00054\u0000"+
		"\u0000\u00f5\u00f7\u0005\u001a\u0000\u0000\u00f6\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\u00f9\u0001\u0000\u0000"+
		"\u0000\u00f8\u00fa\u0003\u000e\u0007\u0000\u00f9\u00f8\u0001\u0000\u0000"+
		"\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fb\u0001\u0000\u0000"+
		"\u0000\u00fb\u0101\u0003\u0012\t\u0000\u00fc\u00fd\u0003\f\u0006\u0000"+
		"\u00fd\u00fe\u0005\u001b\u0000\u0000\u00fe\u00ff\u0003\u0012\t\u0000\u00ff"+
		"\u0101\u0001\u0000\u0000\u0000\u0100\u00f3\u0001\u0000\u0000\u0000\u0100"+
		"\u00fc\u0001\u0000\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000\u0102"+
		"\u0103\u0005#\u0000\u0000\u0103\u0104\u0003\u0012\t\u0000\u0104\u010f"+
		"\u0005#\u0000\u0000\u0105\u0106\u0003\f\u0006\u0000\u0106\u0107\u0005"+
		"%\u0000\u0000\u0107\u0110\u0001\u0000\u0000\u0000\u0108\u0109\u0003\f"+
		"\u0006\u0000\u0109\u010a\u0005&\u0000\u0000\u010a\u0110\u0001\u0000\u0000"+
		"\u0000\u010b\u010c\u0003\f\u0006\u0000\u010c\u010d\u0005\u001b\u0000\u0000"+
		"\u010d\u010e\u0003\u0012\t\u0000\u010e\u0110\u0001\u0000\u0000\u0000\u010f"+
		"\u0105\u0001\u0000\u0000\u0000\u010f\u0108\u0001\u0000\u0000\u0000\u010f"+
		"\u010b\u0001\u0000\u0000\u0000\u0110\u0111\u0001\u0000\u0000\u0000\u0111"+
		"\u0112\u0005\u001e\u0000\u0000\u0112\u0116\u0005!\u0000\u0000\u0113\u0115"+
		"\u0003\n\u0005\u0000\u0114\u0113\u0001\u0000\u0000\u0000\u0115\u0118\u0001"+
		"\u0000\u0000\u0000\u0116\u0114\u0001\u0000\u0000\u0000\u0116\u0117\u0001"+
		"\u0000\u0000\u0000\u0117\u0119\u0001\u0000\u0000\u0000\u0118\u0116\u0001"+
		"\u0000\u0000\u0000\u0119\u011b\u0005\"\u0000\u0000\u011a\u011c\u0005\u0010"+
		"\u0000\u0000\u011b\u011a\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000"+
		"\u0000\u0000\u011c\u011e\u0001\u0000\u0000\u0000\u011d\u011f\u0005#\u0000"+
		"\u0000\u011e\u011d\u0001\u0000\u0000\u0000\u011e\u011f\u0001\u0000\u0000"+
		"\u0000\u011f\u0129\u0001\u0000\u0000\u0000\u0120\u0122\u0005\u000e\u0000"+
		"\u0000\u0121\u0123\u0005#\u0000\u0000\u0122\u0121\u0001\u0000\u0000\u0000"+
		"\u0122\u0123\u0001\u0000\u0000\u0000\u0123\u0129\u0001\u0000\u0000\u0000"+
		"\u0124\u0126\u0005\u000f\u0000\u0000\u0125\u0127\u0005#\u0000\u0000\u0126"+
		"\u0125\u0001\u0000\u0000\u0000\u0126\u0127\u0001\u0000\u0000\u0000\u0127"+
		"\u0129\u0001\u0000\u0000\u0000\u0128\u0081\u0001\u0000\u0000\u0000\u0128"+
		"\u0087\u0001\u0000\u0000\u0000\u0128\u008c\u0001\u0000\u0000\u0000\u0128"+
		"\u0091\u0001\u0000\u0000\u0000\u0128\u009b\u0001\u0000\u0000\u0000\u0128"+
		"\u00a1\u0001\u0000\u0000\u0000\u0128\u00ad\u0001\u0000\u0000\u0000\u0128"+
		"\u00d1\u0001\u0000\u0000\u0000\u0128\u00e1\u0001\u0000\u0000\u0000\u0128"+
		"\u00f1\u0001\u0000\u0000\u0000\u0128\u0120\u0001\u0000\u0000\u0000\u0128"+
		"\u0124\u0001\u0000\u0000\u0000\u0129\u000b\u0001\u0000\u0000\u0000\u012a"+
		"\u0133\u00054\u0000\u0000\u012b\u012c\u0005$\u0000\u0000\u012c\u0132\u0005"+
		"4\u0000\u0000\u012d\u012e\u0005\u001f\u0000\u0000\u012e\u012f\u0003\u0012"+
		"\t\u0000\u012f\u0130\u0005 \u0000\u0000\u0130\u0132\u0001\u0000\u0000"+
		"\u0000\u0131\u012b\u0001\u0000\u0000\u0000\u0131\u012d\u0001\u0000\u0000"+
		"\u0000\u0132\u0135\u0001\u0000\u0000\u0000\u0133\u0131\u0001\u0000\u0000"+
		"\u0000\u0133\u0134\u0001\u0000\u0000\u0000\u0134\r\u0001\u0000\u0000\u0000"+
		"\u0135\u0133\u0001\u0000\u0000\u0000\u0136\u0137\u0007\u0000\u0000\u0000"+
		"\u0137\u000f\u0001\u0000\u0000\u0000\u0138\u013d\u0003\u0012\t\u0000\u0139"+
		"\u013a\u0005\u001c\u0000\u0000\u013a\u013c\u0003\u0012\t\u0000\u013b\u0139"+
		"\u0001\u0000\u0000\u0000\u013c\u013f\u0001\u0000\u0000\u0000\u013d\u013b"+
		"\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000\u0000\u0000\u013e\u0011"+
		"\u0001\u0000\u0000\u0000\u013f\u013d\u0001\u0000\u0000\u0000\u0140\u0141"+
		"\u0006\t\uffff\uffff\u0000\u0141\u0142\u0005\u001d\u0000\u0000\u0142\u0143"+
		"\u0003\u0012\t\u0000\u0143\u0144\u0005\u001e\u0000\u0000\u0144\u0164\u0001"+
		"\u0000\u0000\u0000\u0145\u0146\u00053\u0000\u0000\u0146\u0164\u0003\u0012"+
		"\t\u0012\u0147\u0164\u00055\u0000\u0000\u0148\u0164\u00056\u0000\u0000"+
		"\u0149\u0164\u00057\u0000\u0000\u014a\u0164\u00058\u0000\u0000\u014b\u0164"+
		"\u0005\u0016\u0000\u0000\u014c\u0164\u0005\u0017\u0000\u0000\u014d\u0164"+
		"\u0005\b\u0000\u0000\u014e\u014f\u0005\u0007\u0000\u0000\u014f\u0150\u0003"+
		"\u000e\u0007\u0000\u0150\u0152\u0005\u001d\u0000\u0000\u0151\u0153\u0003"+
		"\u0010\b\u0000\u0152\u0151\u0001\u0000\u0000\u0000\u0152\u0153\u0001\u0000"+
		"\u0000\u0000\u0153\u0154\u0001\u0000\u0000\u0000\u0154\u0155\u0005\u001e"+
		"\u0000\u0000\u0155\u0164\u0001\u0000\u0000\u0000\u0156\u0157\u0003\f\u0006"+
		"\u0000\u0157\u0159\u0005\u001d\u0000\u0000\u0158\u015a\u0003\u0010\b\u0000"+
		"\u0159\u0158\u0001\u0000\u0000\u0000\u0159\u015a\u0001\u0000\u0000\u0000"+
		"\u015a\u015b\u0001\u0000\u0000\u0000\u015b\u015c\u0005\u001e\u0000\u0000"+
		"\u015c\u0164\u0001\u0000\u0000\u0000\u015d\u0164\u0003\f\u0006\u0000\u015e"+
		"\u0160\u0005!\u0000\u0000\u015f\u0161\u0003\u0010\b\u0000\u0160\u015f"+
		"\u0001\u0000\u0000\u0000\u0160\u0161\u0001\u0000\u0000\u0000\u0161\u0162"+
		"\u0001\u0000\u0000\u0000\u0162\u0164\u0005\"\u0000\u0000\u0163\u0140\u0001"+
		"\u0000\u0000\u0000\u0163\u0145\u0001\u0000\u0000\u0000\u0163\u0147\u0001"+
		"\u0000\u0000\u0000\u0163\u0148\u0001\u0000\u0000\u0000\u0163\u0149\u0001"+
		"\u0000\u0000\u0000\u0163\u014a\u0001\u0000\u0000\u0000\u0163\u014b\u0001"+
		"\u0000\u0000\u0000\u0163\u014c\u0001\u0000\u0000\u0000\u0163\u014d\u0001"+
		"\u0000\u0000\u0000\u0163\u014e\u0001\u0000\u0000\u0000\u0163\u0156\u0001"+
		"\u0000\u0000\u0000\u0163\u015d\u0001\u0000\u0000\u0000\u0163\u015e\u0001"+
		"\u0000\u0000\u0000\u0164\u0179\u0001\u0000\u0000\u0000\u0165\u0166\n\u0011"+
		"\u0000\u0000\u0166\u0167\u0007\u0001\u0000\u0000\u0167\u0178\u0003\u0012"+
		"\t\u0012\u0168\u0169\n\u0010\u0000\u0000\u0169\u016a\u0007\u0002\u0000"+
		"\u0000\u016a\u0178\u0003\u0012\t\u0011\u016b\u016c\n\u000f\u0000\u0000"+
		"\u016c\u016d\u0007\u0003\u0000\u0000\u016d\u0178\u0003\u0012\t\u0010\u016e"+
		"\u016f\n\u000e\u0000\u0000\u016f\u0170\u0007\u0004\u0000\u0000\u0170\u0178"+
		"\u0003\u0012\t\u000f\u0171\u0172\n\r\u0000\u0000\u0172\u0173\u00051\u0000"+
		"\u0000\u0173\u0178\u0003\u0012\t\u000e\u0174\u0175\n\f\u0000\u0000\u0175"+
		"\u0176\u00052\u0000\u0000\u0176\u0178\u0003\u0012\t\r\u0177\u0165\u0001"+
		"\u0000\u0000\u0000\u0177\u0168\u0001\u0000\u0000\u0000\u0177\u016b\u0001"+
		"\u0000\u0000\u0000\u0177\u016e\u0001\u0000\u0000\u0000\u0177\u0171\u0001"+
		"\u0000\u0000\u0000\u0177\u0174\u0001\u0000\u0000\u0000\u0178\u017b\u0001"+
		"\u0000\u0000\u0000\u0179\u0177\u0001\u0000\u0000\u0000\u0179\u017a\u0001"+
		"\u0000\u0000\u0000\u017a\u0013\u0001\u0000\u0000\u0000\u017b\u0179\u0001"+
		"\u0000\u0000\u0000;\u0017\u001b&,28;?DJORW[_glortz\u007f\u0085\u008a\u008f"+
		"\u0094\u0098\u009b\u009f\u00a7\u00ab\u00b5\u00be\u00c4\u00ca\u00cf\u00d9"+
		"\u00df\u00e6\u00ef\u00f6\u00f9\u0100\u010f\u0116\u011b\u011e\u0122\u0126"+
		"\u0128\u0131\u0133\u013d\u0152\u0159\u0160\u0163\u0177\u0179";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}