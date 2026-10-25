package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import org.fxmisc.richtext.CodeArea;
import org.fxmisc.richtext.LineNumberFactory;

public class EditorCodigoNativo extends BorderPane {

    private final CodeArea codeArea;
    private final Label statusBar;
    private String tipoLenguajeActual = "zetariano";

    public EditorCodigoNativo() {
        codeArea = new CodeArea();
        codeArea.setParagraphGraphicFactory(LineNumberFactory.get(codeArea));

        codeArea.textProperty().addListener((obs, viejo, nuevo) -> {
            codeArea.setStyleSpans(0, ResaltadorSintactico.calcularResaltado(nuevo, tipoLenguajeActual));
        });

        statusBar = new Label("Línea: 1, Columna: 0");
        statusBar.setStyle("-fx-text-fill: #808080; -fx-font-family: 'Consolas', monospace; -fx-font-size: 12px;");

        HBox statusBox = new HBox(statusBar);
        statusBox.setAlignment(Pos.CENTER_RIGHT);
        statusBox.setStyle("-fx-background-color: #1e1e1e; -fx-padding: 4px 10px; -fx-border-color: #323232; -fx-border-width: 1 0 0 0;");

        codeArea.caretPositionProperty().addListener((obs, oldPos, newPos) -> {
            int linea = codeArea.getCurrentParagraph() + 1;
            int columna = codeArea.getCaretColumn();
            statusBar.setText("Línea: " + linea + ", Columna: " + columna);
        });

        String css = getClass().getResource("/estilos.css").toExternalForm();
        this.getStylesheets().add(css);

        this.setCenter(codeArea);
        this.setBottom(statusBox);
    }

    public void setTipoLenguaje(String tipo) {
        this.tipoLenguajeActual = tipo;
        codeArea.setStyleSpans(0, ResaltadorSintactico.calcularResaltado(codeArea.getText(), tipoLenguajeActual));
    }

    public String getText() {
        return codeArea.getText();
    }

    public void setText(String texto) {
        codeArea.replaceText(0, codeArea.getLength(), texto);
    }
}