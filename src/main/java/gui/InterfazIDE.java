package gui;

import ast.Instruccion;
import ast.piglatin.PigLatinCustomVisitor;
import ast.y.LenguajeYCustomVisitor;
import gramaticas.pigLatin.PigLatinLexer;
import gramaticas.pigLatin.PigLatinParser;
import gramaticas.y.LenguajeYLexer;
import gramaticas.y.LenguajeYParser;
import gramaticas.zetariano.ZetarianoLexer;
import gramaticas.zetariano.ZetarianoParser;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class InterfazIDE extends Application {

    private TabPane gestorPestanas;
    private TextArea consola;
    private Stage escenarioPrincipal;
    private Button btnCompilar;
    private MenuItem itemCompilar;
    private semantico.TablaSimbolos entornoGlobalActual;

    // Inayon: Mangidulin ti root node tapno nalaka a ma-refresh
    private TreeView<File> arbolArchivos;

    @Override
    public void start(Stage primaryStage) {
        this.escenarioPrincipal = primaryStage;
        BorderPane root = new BorderPane();

        gestorPestanas = new TabPane();
        consola = new TextArea();
        consola.setEditable(false);
        consola.setPrefHeight(200);
        consola.setStyle("-fx-control-inner-background: #1e1e1e; -fx-text-fill: #00ff00; -fx-font-family: 'Consolas';");

        arbolArchivos = new TreeView<>();
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
        itemCompilar = new MenuItem("Compilar y Generar C3D/RISC-V");
        itemCompilar.setOnAction(e -> compilarCodigo());
        menuEjecutar.getItems().add(itemCompilar);

        Menu menuVer = new Menu("Ver");
        MenuItem itemTablaSimbolos = new MenuItem("Tabla de Símbolos");
        itemTablaSimbolos.setOnAction(e -> mostrarTablaSimbolos());
        menuVer.getItems().add(itemTablaSimbolos);

        menuBar.getMenus().addAll(menuArchivo, menuEjecutar, menuVer);

        ToolBar toolBar = new ToolBar();
        btnCompilar = new Button("▶ Ejecutar Compilador");
        btnCompilar.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        btnCompilar.setOnAction(e -> compilarCodigo());
        toolBar.getItems().add(btnCompilar);

        btnCompilar.setDisable(true);
        itemCompilar.setDisable(true);

        VBox panelSuperior = new VBox(menuBar, toolBar);

        arbolArchivos.getSelectionModel().selectedItemProperty().addListener((obs, viejoNodo, nuevoNodo) -> {
            if (nuevoNodo != null) {
                File archivoSeleccionado = nuevoNodo.getValue();
                if (archivoSeleccionado.isFile()) {
                    abrirArchivoEnPestana(archivoSeleccionado);
                }
            }
        });

        gestorPestanas.getSelectionModel().selectedItemProperty().addListener((obs, viejaPestana, nuevaPestana) -> {
            actualizarEstadoBotonCompilar(nuevaPestana);
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

    private void mostrarTablaSimbolos() {
        if (entornoGlobalActual == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Debes compilar el código exitosamente primero para generar la tabla.");
            alert.show();
            return;
        }

        Stage stageTabla = new Stage();
        stageTabla.setTitle("Tabla de Símbolos (Memoria y Scopes)");

        TableView<String[]> tablaUI = new TableView<>();
        String[] nombresColumnas = {"Entorno", "Identificador", "Tipo", "Categoría", "Visibilidad", "Dir. Memoria", "Tamaño"};

        for (int i = 0; i < nombresColumnas.length; i++) {
            final int colIndex = i;
            TableColumn<String[], String> col = new TableColumn<>(nombresColumnas[i]);
            col.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()[colIndex]));
            col.setPrefWidth(120);
            tablaUI.getColumns().add(col);
        }

        java.util.List<String[]> filas = new java.util.ArrayList<>();
        recolectarSimbolosRecursivo(entornoGlobalActual, filas);

        tablaUI.getItems().addAll(filas);

        Scene scene = new Scene(tablaUI, 850, 500);
        stageTabla.setScene(scene);
        stageTabla.show();
    }

    private void recolectarSimbolosRecursivo(semantico.TablaSimbolos entorno, java.util.List<String[]> filas) {
        for (semantico.Simbolo sim : entorno.tabla.values()) {
            filas.add(new String[]{
                    entorno.nombreEntorno,
                    sim.id,
                    sim.tipo,
                    sim.categoria,
                    sim.visibilidad,
                    String.valueOf(sim.direccionMemoria),
                    String.valueOf(sim.tamano)
            });
        }
        for (semantico.TablaSimbolos hijo : entorno.hijos) {
            recolectarSimbolosRecursivo(hijo, filas);
        }
    }

    private void actualizarEstadoBotonCompilar(Tab pestana) {
        if (pestana != null && pestana.getUserData() != null) {
            String ruta = (String) pestana.getUserData();
            boolean esPig = ruta.toLowerCase().endsWith(".pig");
            btnCompilar.setDisable(!esPig);
            itemCompilar.setDisable(!esPig);
        } else {
            btnCompilar.setDisable(true);
            itemCompilar.setDisable(true);
        }
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
            consola.appendText("⚠ Abre el archivo principal (.pig) para compilar.\n");
            return;
        }

        Tab pestanaActiva = gestorPestanas.getSelectionModel().getSelectedItem();
        String rutaArchivoPrincipal = (String) pestanaActiva.getUserData();

        if (rutaArchivoPrincipal == null || !rutaArchivoPrincipal.toLowerCase().endsWith(".pig")) {
            consola.appendText("✖ ERROR DE EJECUCIÓN: El punto de entrada del programa debe ser un archivo PigLatin (.pig).\n");
            return;
        }

        File archivoPrincipal = new File(rutaArchivoPrincipal);
        File directorioRaiz = (arbolArchivos != null && arbolArchivos.getRoot() != null) ? arbolArchivos.getRoot().getValue() : archivoPrincipal.getParentFile();

        consola.clear();
        consola.appendText("\n--- INICIANDO COMPILACIÓN (RESOLVIENDO DEPENDENCIAS) ---\n");

        generador.GeneradorC3D.getInstancia().limpiar();
        errores.GestorErrores.getInstancia().limpiarErrores();
        this.entornoGlobalActual = null;

        java.util.List<Instruccion> astGlobal = new java.util.ArrayList<>();
        java.util.List<Instruccion> astPrincipal = parsearArchivo(archivoPrincipal);
        if (astPrincipal == null) {
            imprimirErrores();
            return;
        }

        java.util.Set<String> archivosProcesados = new java.util.HashSet<>();
        archivosProcesados.add(archivoPrincipal.getAbsolutePath());

        for (Instruccion inst : astPrincipal) {
            if (inst instanceof ast.instrucciones.ImportarArchivo) {
                ast.instrucciones.ImportarArchivo imp = (ast.instrucciones.ImportarArchivo) inst;
                File archivoDependencia = new File(directorioRaiz, imp.rutaRelativa);

                if (!archivoDependencia.exists()) {
                    errores.GestorErrores.getInstancia().agregarError(errores.TipoError.SEMANTICO, "No se encontró el módulo importado: " + imp.rutaRelativa, imp.linea, imp.columna, archivoPrincipal.getName());
                    continue;
                }

                String rutaAbsoluta = archivoDependencia.getAbsolutePath();
                if (!archivosProcesados.contains(rutaAbsoluta)) {
                    archivosProcesados.add(rutaAbsoluta);
                    consola.appendText("-> Vinculando dependencia: " + imp.rutaRelativa + "\n");
                    java.util.List<Instruccion> astDep = parsearArchivo(archivoDependencia);
                    if (astDep != null) {
                        astGlobal.addAll(astDep);
                    }
                }
            }
        }

        astGlobal.addAll(astPrincipal);

        if (errores.GestorErrores.getInstancia().hayErrores()) {
            imprimirErrores();
            return;
        }

        semantico.TablaSimbolos entornoGlobal = new semantico.TablaSimbolos(null, "Global");
        this.entornoGlobalActual = entornoGlobal;


        // PASADA DE REGISTRO: Declarar Clases y pre-registrar firmas
        for (Instruccion inst : astGlobal) {
            if (inst != null) {
                String claseNodo = inst.getClass().getSimpleName();
                if (claseNodo.equals("DefinicionClase")) {
                    inst.generar(entornoGlobal);
                }
            }
        }

        // PRÓLOGO C3D: Salto incondicional para evadir las definiciones de funciones
        generador.GeneradorC3D.getInstancia().agregarCuarteta(new cuartetas.SaltoIncondicional3D("inicio_main"));


        generador.GeneradorC3D.getInstancia().iniciarGeneracionFuncion();

        for (Instruccion inst : astGlobal) {
            if (inst != null) {
                String claseNodo = inst.getClass().getSimpleName();
                if (claseNodo.equals("DefinicionClase")) {
                    // Generar métodos de la clase
                    ((ast.instrucciones.DefinicionClase) inst).generarCuerpoMetodos(entornoGlobal);
                } else if (claseNodo.equals("DefinicionFuncion") || claseNodo.equals("DefinicionMetodo")) {
                    // Generar funciones de Y o métodos sueltos
                    inst.generar(entornoGlobal);
                }
            }
        }

        generador.GeneradorC3D.getInstancia().finalizarGeneracionFuncion();

        // GENERACIÓN DEL MAIN
        generador.GeneradorC3D.getInstancia().agregarCuarteta(new cuartetas.DefinicionEtiqueta3D("inicio_main"));

        // PASADA PRINCIPAL: Generar el código global (variables, prints, lógica suelta)
        for (Instruccion inst : astGlobal) {
            if (inst != null) {
                String claseNodo = inst.getClass().getSimpleName();
                if (!claseNodo.equals("DefinicionClase") &&
                        !claseNodo.equals("DefinicionFuncion") &&
                        !claseNodo.equals("DefinicionMetodo") &&
                        !claseNodo.equals("ImportarArchivo")) {

                    inst.generar(entornoGlobal);
                }
            }
        }

        if (errores.GestorErrores.getInstancia().hayErrores()) {
            imprimirErrores();
        } else {
            generarArchivosSalida(directorioRaiz);
        }
    }

    private void abrirCarpeta() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Seleccionar Carpeta de Trabajo");
        File directorioSeleccionado = directoryChooser.showDialog(escenarioPrincipal);

        if (directorioSeleccionado != null) {
            cargarDirectorioEnArbol(directorioSeleccionado, arbolArchivos);
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

            actualizarEstadoBotonCompilar(nuevaPestana);

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

    private void refrescarArbol() {
        if (arbolArchivos != null && arbolArchivos.getRoot() != null) {
            File directorioActual = arbolArchivos.getRoot().getValue();
            cargarDirectorioEnArbol(directorioActual, arbolArchivos);
        }
    }

    private List<Instruccion> parsearArchivo(File archivo) {
        try {
            String codigo = Files.readString(archivo.toPath());
            errores.GestorErrores.getInstancia().setArchivoActual(archivo.getName());
            CharStream input = CharStreams.fromString(codigo);

            Lexer lexer = null;
            Parser parser = null;
            Object arbolSintactico = null;
            org.antlr.v4.runtime.tree.ParseTreeVisitor<?> visitor = null;

            String nombre = archivo.getName().toLowerCase();

            if (nombre.endsWith(".pig")) {
                lexer = new PigLatinLexer(input);
                parser = new PigLatinParser(new CommonTokenStream(lexer));
                arbolSintactico = ((PigLatinParser) parser).programa();
                visitor = new PigLatinCustomVisitor();
            } else if (nombre.endsWith(".z")) {
                lexer = new ZetarianoLexer(input);
                parser = new ZetarianoParser(new CommonTokenStream(lexer));
                arbolSintactico = ((ZetarianoParser) parser).programa();
                visitor = new ast.zetariano.ZetarianoCustomVisitor();
            } else if (nombre.endsWith(".y")) {
                lexer = new LenguajeYLexer(input);
                parser = new LenguajeYParser(new CommonTokenStream(lexer));
                arbolSintactico = ((LenguajeYParser) parser).programa();
                visitor = new LenguajeYCustomVisitor();
            }

            if (lexer != null && parser != null) {
                lexer.removeErrorListeners();
                parser.removeErrorListeners();

                BaseErrorListener errorListener = new BaseErrorListener() {
                    @Override
                    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                        errores.GestorErrores.getInstancia().agregarError(errores.TipoError.SINTACTICO, msg, line, charPositionInLine, archivo.getName());
                    }
                };
                lexer.addErrorListener(errorListener);
                parser.addErrorListener(errorListener);

                return (List<Instruccion>) visitor.visit((ParseTree) arbolSintactico);
            }
        } catch (Exception ex) {
            consola.appendText("✖ Error al leer/parsear: " + archivo.getName() + " - " + ex.getMessage() + "\n");
        }
        return null;
    }

    private void imprimirErrores() {
        consola.appendText("⚠ SE ENCONTRARON ERRORES DE COMPILACIÓN:\n");
        for (errores.ErrorCompilacion error : errores.GestorErrores.getInstancia().getListaErrores()) {
            consola.appendText(error.toString() + "\n");
        }
    }

    private void generarArchivosSalida(File directorioRaiz) {
        consola.appendText("✔ COMPILACIÓN EXITOSA. Generando Código C3D y RISC-V...\n");
        String codigoC3D = generador.GeneradorC3D.getInstancia().obtenerCodigoString();
        generador.TraductorRiscV traductor = new generador.TraductorRiscV(0);
        String codigoRiscV = traductor.traducir(generador.GeneradorC3D.getInstancia().getCuartetas());

        consola.appendText("\n================ CÓDIGO C3D ================\n" + codigoC3D + "\n");
        consola.appendText("\n============== ENSAMBLADOR RISC-V ==============\n" + codigoRiscV + "\n");

        try {
            Files.writeString(new File(directorioRaiz, "salida_c3d.c").toPath(), codigoC3D);
            Files.writeString(new File(directorioRaiz, "salida_riscv.s").toPath(), codigoRiscV);
            consola.appendText("✔ Archivos generados exitosamente en la raíz del proyecto.\n");

            refrescarArbol();

        } catch (IOException e) {
            consola.appendText("✖ Error al guardar archivos de salida: " + e.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}