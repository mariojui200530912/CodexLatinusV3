package errores;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class CodexErrorListener extends BaseErrorListener {
    public static final CodexErrorListener INSTANCE = new CodexErrorListener();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e) {

        TipoError tipo = msg.contains("token recognition error")
                ? TipoError.LEXICO
                : TipoError.SINTACTICO;

        GestorErrores.getInstancia().agregarError(
                tipo,
                msg,
                line,
                charPositionInLine,
                GestorErrores.getInstancia().getArchivoActual()
        );
    }
}