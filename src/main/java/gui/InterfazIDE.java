package gui;

import ast.Instruccion;
import ast.piglatin.PigLatinCustomVisitor;
import gramaticas.pigLatin.PigLatinLexer;
import gramaticas.pigLatin.PigLatinParser;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.antlr.v4.runtime.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class InterfazIDE extends Application {

    private TabPane gestorPestanas;
    private TextArea consola;
    private Stage escenarioPrincipal;

    @Override
    public void start(Stage primaryStage) {
        this.escenarioPrincipal = primaryStage;
        BorderPane root = new BorderPane();

        gestorPestanas = new TabPane();
        consola = new TextArea();
        consola.setEditable(false);
        consola.setPrefHeight(200);
        consola.setStyle("-fx-control-inner-background: #1e1e1e; -fx-text-fill: #00ff00; -fx-font-family: 'Consolas';");

        TreeView<File> arbolArchivos = new TreeView<>();
        configurarAparienciaArbol(arbolArchivos);

        MenuBar menuBar = new MenuBar();
        Menu menuArchivo = new Menu("Archivo");

        MenuItem itemAbrirCarpeta = new MenuItem("Abrir Carpeta...");
        MenuItem itemGuardar = new MenuItem("Guardar");
        MenuItem itemDescargar = new MenuItem("Descargar (Guardar Como...)");

        itemAbrirCarpeta.setOnAction(e -> abrirCarpeta());
        itemGuardar.setOnAction(e -> guardarArchivoActual());
        itemDescargar.setOnAction(e -> descargarArchivo());

        menuArchivo.getItems().addAll(itemAbrirCarpeta, new SeparatorMenuItem(), itemGuardar, itemDescargar);

        Menu menuEjecutar = new Menu("Ejecutar");
        MenuItem itemCompilar = new MenuItem("Compilar y Generar C3D/RISC-V");
        itemCompilar.setOnAction(e -> compilarCodigo());
        menuEjecutar.getItems().add(itemCompilar);

        menuBar.getMenus().addAll(menuArchivo, menuEjecutar);

        ToolBar toolBar = new ToolBar();
        Button btnCompilar = new Button("▶ Ejecutar Compilador");
        btnCompilar.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        btnCompilar.setOnAction(e -> compilarCodigo());
        toolBar.getItems().add(btnCompilar);

        VBox panelSuperior = new VBox(menuBar, toolBar);

        arbolArchivos.getSelectionModel().selectedItemProperty().addListener((obs, viejoNodo, nuevoNodo) -> {
            if (nuevoNodo != null) {
                File archivoSeleccionado = nuevoNodo.getValue();
                if (archivoSeleccionado.isFile()) {
                    abrirArchivoEnPestana(archivoSeleccionado);
                }
            }
        });

        root.setTop(panelSuperior);
        root.setLeft(arbolArchivos);
        root.setCenter(gestorPestanas);
        root.setBottom(consola);

        Scene scene = new Scene(root, 1000, 700);
        primaryStage.setTitle("IDE Compiladores 2 - Fase 2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void guardarArchivoActual() {
        Tab pestanaActiva = gestorPestanas.getSelectionModel().getSelectedItem();
        if (pestanaActiva != null && pestanaActiva.getUserData() != null) {
            String rutaArchivo = (String) pestanaActiva.getUserData();
            File archivo = new File(rutaArchivo);
            EditorCodigoNativo editor = (EditorCodigoNativo) pestanaActiva.getContent();

            try {
                Files.writeString(archivo.toPath(), editor.getText());
                consola.appendText("✔ Archivo guardado correctamente: " + archivo.getName() + "\n");
            } catch (IOException ex) {
                consola.appendText("✖ Error al guardar el archivo: " + ex.getMessage() + "\n");
            }
        } else {
            consola.appendText("⚠ No hay un archivo físico asociado a esta pestaña para guardar.\n");
        }
    }

    private void descargarArchivo() {
        EditorCodigoNativo editor = obtenerEditorActivo();
        if (editor != null) {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Descargar / Guardar Como");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Archivos Zetariano (*.z)", "*.z"),
                    new FileChooser.ExtensionFilter("Archivos PigLatin (*.pig)", "*.pig"),
                    new FileChooser.ExtensionFilter("Archivos Lenguaje Y (*.y)", "*.y"),
                    new FileChooser.ExtensionFilter("Todos los Archivos", "*.*")
            );

            File archivoDestino = fileChooser.showSaveDialog(escenarioPrincipal);

            if (archivoDestino != null) {
                try {
                    Files.writeString(archivoDestino.toPath(), editor.getText());
                    consola.appendText("✔ Archivo descargado en: " + archivoDestino.getAbsolutePath() + "\n");
                    Tab pestanaActiva = gestorPestanas.getSelectionModel().getSelectedItem();
                    pestanaActiva.setText(archivoDestino.getName());
                    pestanaActiva.setUserData(archivoDestino.getAbsolutePath());
                } catch (IOException ex) {
                    consola.appendText("✖ Error al descargar el archivo: " + ex.getMessage() + "\n");
                }
            }
        } else {
            consola.appendText("⚠ No hay ningún editor abierto para descargar.\n");
        }
    }

    private void compilarCodigo() {
        EditorCodigoNativo editor = obtenerEditorActivo();

        if (editor == null) {
            consola.appendText("⚠ No hay código en la pestaña activa para compilar.\n");
            return;
        }

        Tab pestanaActiva = gestorPestanas.getSelectionModel().getSelectedItem();
        String rutaArchivo = (String) pestanaActiva.getUserData();

        if (rutaArchivo == null || !rutaArchivo.toLowerCase().endsWith(".pig")) {
            consola.appendText("✖ ERROR DE EJECUCIÓN: El punto de entrada del programa debe ser un archivo PigLatin (.pig).\n");
            return;
        }

        String codigo = editor.getText();
        consola.clear();
        consola.appendText("\n--- INICIANDO COMPILACIÓN DESDE PIGLATIN ---\n");

        // Limpiar Singleton del Generador C3D y Errores
        generador.GeneradorC3D.getInstancia().limpiar();
        errores.GestorErrores.getInstancia().limpiarErrores();
        errores.GestorErrores.getInstancia().setArchivoActual(pestanaActiva.getText());

        CharStream input = CharStreams.fromString(codigo);

        try {
            PigLatinLexer lexer = new PigLatinLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            PigLatinParser parser = new PigLatinParser(tokens);

            lexer.removeErrorListeners();
            parser.removeErrorListeners();

            BaseErrorListener errorListener = new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                        int line, int charPositionInLine, String msg, RecognitionException e) {
                    errores.GestorErrores.getInstancia().agregarError(
                            errores.TipoError.SINTACTICO, msg, line, charPositionInLine,
                            errores.GestorErrores.getInstancia().getArchivoActual()
                    );
                }
            };

            lexer.addErrorListener(errorListener);
            parser.addErrorListener(errorListener);

            var arbolSintactico = parser.programa();

            PigLatinCustomVisitor visitador = new PigLatinCustomVisitor();

            @SuppressWarnings("unchecked")
            List<Instruccion> astRaiz = (List<Instruccion>) visitador.visit(arbolSintactico);

            if (astRaiz != null) {
                semantico.TablaSimbolos entornoGlobal = new semantico.TablaSimbolos(null, "Global");

                for (Instruccion inst : astRaiz) {
                    if (inst != null) {
                        inst.generar(entornoGlobal);
                    }
                }
            }

            if (errores.GestorErrores.getInstancia().hayErrores()) {
                consola.appendText("⚠ SE ENCONTRARON ERRORES DE COMPILACIÓN:\n");
                for (errores.ErrorCompilacion error : errores.GestorErrores.getInstancia().getListaErrores()) {
                    consola.appendText(error.toString() + "\n");
                }
            } else {
                consola.appendText("✔ COMPILACIÓN EXITOSA. Generando Código C3D y RISC-V...\n");

                String codigoC3D = generador.GeneradorC3D.getInstancia().obtenerCodigoString();

                generador.TraductorRiscV traductor = new generador.TraductorRiscV(0); // Cantidad de temporales opcional para la memoria
                String codigoRiscV = traductor.traducir(generador.GeneradorC3D.getInstancia().getCuartetas());

                consola.appendText("\n================ CÓDIGO C3D ================\n");
                consola.appendText(codigoC3D + "\n");

                consola.appendText("\n============== ENSAMBLADOR RISC-V ==============\n");
                consola.appendText(codigoRiscV + "\n");

                try {
                    File archivoBaseSalida = new File(rutaArchivo);
                    String rutaSalidaC3D = archivoBaseSalida.getParent() + File.separator + "salida_c3d.c";
                    String rutaSalidaRiscV = archivoBaseSalida.getParent() + File.separator + "salida_riscv.s";

                    Files.writeString(new File(rutaSalidaC3D).toPath(), codigoC3D);
                    Files.writeString(new File(rutaSalidaRiscV).toPath(), codigoRiscV);

                    consola.appendText("✔ Archivos generados exitosamente en:\n  -> " + rutaSalidaC3D + "\n  -> " + rutaSalidaRiscV + "\n");
                } catch (IOException e) {
                    consola.appendText("✖ Error al guardar archivos de salida: " + e.getMessage() + "\n");
                }
            }

        } catch (Exception ex) {
            consola.appendText("✖ Error crítico durante la compilación: " + ex.getMessage() + "\n");
            ex.printStackTrace();
        }
    }

    private void abrirCarpeta() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Seleccionar Carpeta de Trabajo");
        File directorioSeleccionado = directoryChooser.showDialog(escenarioPrincipal);

        if (directorioSeleccionado != null) {
            @SuppressWarnings("unchecked")
            TreeView<File> arbol = (TreeView<File>) ((BorderPane) escenarioPrincipal.getScene().getRoot()).getLeft();
            cargarDirectorioEnArbol(directorioSeleccionado, arbol);
            consola.appendText("Carpeta abierta: " + directorioSeleccionado.getAbsolutePath() + "\n");
        }
    }

    private void abrirArchivoEnPestana(File archivo) {
        String rutaAbsoluta = archivo.getAbsolutePath();

        for (Tab pestana : gestorPestanas.getTabs()) {
            if (pestana.getUserData() != null && pestana.getUserData().equals(rutaAbsoluta)) {
                gestorPestanas.getSelectionModel().select(pestana);
                return;
            }
        }

        try {
            String contenido = Files.readString(archivo.toPath()).replace("\r", "");
            String nombreArchivo = archivo.getName().toLowerCase();

            EditorCodigoNativo nuevoEditor = new EditorCodigoNativo();
            if (nombreArchivo.endsWith(".z")) nuevoEditor.setTipoLenguaje("zetariano");
            else if (nombreArchivo.endsWith(".pig")) nuevoEditor.setTipoLenguaje("piglatin");
            else if (nombreArchivo.endsWith(".y")) nuevoEditor.setTipoLenguaje("y");
            else nuevoEditor.setTipoLenguaje("texto_plano");

            nuevoEditor.setText(contenido);

            Tab nuevaPestana = new Tab(archivo.getName());
            nuevaPestana.setContent(nuevoEditor);
            nuevaPestana.setUserData(rutaAbsoluta);

            gestorPestanas.getTabs().add(nuevaPestana);
            gestorPestanas.getSelectionModel().select(nuevaPestana);

        } catch (IOException ex) {
            consola.appendText("✖ Error al leer el archivo: " + ex.getMessage() + "\n");
        }
    }

    public EditorCodigoNativo obtenerEditorActivo() {
        Tab pestanaActiva = gestorPestanas.getSelectionModel().getSelectedItem();
        if (pestanaActiva != null && pestanaActiva.getContent() instanceof EditorCodigoNativo) {
            return (EditorCodigoNativo) pestanaActiva.getContent();
        }
        return null;
    }

    private void cargarDirectorioEnArbol(File directorioRaiz, TreeView<File> arbol) {
        TreeItem<File> rootItem = crearNodoArbol(directorioRaiz);
        rootItem.setExpanded(true);
        arbol.setRoot(rootItem);
    }

    private TreeItem<File> crearNodoArbol(File archivoODirectorio) {
        TreeItem<File> nodo = new TreeItem<>(archivoODirectorio);
        if (archivoODirectorio.isDirectory()) {
            File[] hijos = archivoODirectorio.listFiles();
            if (hijos != null) {
                for (File hijo : hijos) {
                    if (!hijo.isHidden()) {
                        nodo.getChildren().add(crearNodoArbol(hijo));
                    }
                }
            }
        }
        return nodo;
    }

    private void configurarAparienciaArbol(TreeView<File> arbol) {
        arbol.setCellFactory(tv -> new TreeCell<File>() {
            @Override
            protected void updateItem(File item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getName());
                }
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}