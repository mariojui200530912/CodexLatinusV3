package ast.expresiones;

import ast.Expresion;
import ast.ResultadoC3D;
import cuartetas.*;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.TablaSimbolos;
import semantico.TipoDato;
import semantico.ValidadorTipos;

public class OperacionBinaria extends Expresion {
    public Expresion izq;
    public Expresion der;
    public String operador;

    public OperacionBinaria(Expresion izq, Expresion der, String operador, int linea, int columna) {
        super(linea, columna);
        this.izq = izq;
        this.der = der;
        this.operador = operador;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        ResultadoC3D resIzq = (ResultadoC3D) izq.generar(entorno);
        ResultadoC3D resDer = (ResultadoC3D) der.generar(entorno);

        if (resIzq == null || resDer == null || resIzq.tipo == TipoDato.ERROR || resDer.tipo == TipoDato.ERROR) {
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        TipoDato tipoResultante = TipoDato.ERROR;

        // VALIDACION SEMANTICA SEGUN EL OPERADOR
        switch (operador) {
            case "+":
                tipoResultante = ValidadorTipos.operarSuma(resIzq.tipo, resDer.tipo);
                break;
            case "-":
            case "*":
            case "/":
                tipoResultante = ValidadorTipos.operarAritmetica(resIzq.tipo, resDer.tipo);
                break;
            case ">":
            case "<":
            case ">=":
            case "<=":
                tipoResultante = ValidadorTipos.operarRelacional(resIzq.tipo, resDer.tipo);
                break;
            case "==":
            case "!=":
                tipoResultante = ValidadorTipos.operarIgualdad(resIzq.tipo, resDer.tipo);
                break;
            case "&&":
            case "||":
                if (resIzq.tipo == TipoDato.BOOLEANO && resDer.tipo == TipoDato.BOOLEANO) {
                    tipoResultante = TipoDato.BOOLEANO;
                }
                break;
        }

        // Reporte de Error Sematico si la combinacion es invalida
        if (tipoResultante == TipoDato.ERROR) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO,
                    "Incompatibilidad de tipos en operación '" + operador + "': No se puede operar " + resIzq.tipo + " con " + resDer.tipo,
                    linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // GENERACION DE CODIGO INTERMEDIO (C3D)
        AccesoTemporal temporalResultado = new AccesoTemporal(gen.generarTemporal());

        if (esAritmetico(operador)) {
            // Nota: Si el resultado es CADENA (concatenación de string + string/int),
            // en C3D requerirá una llamada a una función nativa de manejo de strings en el Heap.
            // Por ahora, emitimos la instrucción binaria estándar.
            gen.agregarCuarteta(new OperacionBinaria3D(
                    temporalResultado, resIzq.valorC3D, operador, resDer.valorC3D
            ));
            return new ResultadoC3D(temporalResultado, tipoResultante);
        }
        else {
            String etiquetaVerdadera = gen.generarEtiqueta();
            String etiquetaFalsa = gen.generarEtiqueta();
            String etiquetaSalida = gen.generarEtiqueta();

            if (esRelacionalOIgualdad(operador)) {
                gen.agregarCuarteta(new Condicional3D(resIzq.valorC3D, resDer.valorC3D, operador, etiquetaVerdadera));
            } else if (operador.equals("&&")) {
                gen.agregarCuarteta(new OperacionBinaria3D(temporalResultado, resIzq.valorC3D, "*", resDer.valorC3D));
                gen.agregarCuarteta(new Condicional3D(temporalResultado, new Literal3D("1"), "==", etiquetaVerdadera));
            } else if (operador.equals("||")) {
                gen.agregarCuarteta(new OperacionBinaria3D(temporalResultado, resIzq.valorC3D, "+", resDer.valorC3D));
                gen.agregarCuarteta(new Condicional3D(temporalResultado, new Literal3D("0"), ">", etiquetaVerdadera));
            }

            gen.agregarCuarteta(new Goto3D(etiquetaFalsa));

            // Bloque Verdadero
            gen.agregarCuarteta(new DefinicionEtiqueta3D(etiquetaVerdadera));
            gen.agregarCuarteta(new Asignacion3D(temporalResultado, new Literal3D("1")));
            gen.agregarCuarteta(new Goto3D(etiquetaSalida));

            // Bloque Falso
            gen.agregarCuarteta(new DefinicionEtiqueta3D(etiquetaFalsa));
            gen.agregarCuarteta(new Asignacion3D(temporalResultado, new Literal3D("0")));

            // Salida
            gen.agregarCuarteta(new DefinicionEtiqueta3D(etiquetaSalida));

            return new ResultadoC3D(temporalResultado, TipoDato.BOOLEANO);
        }
    }

    private boolean esAritmetico(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }

    private boolean esRelacionalOIgualdad(String op) {
        return op.equals(">") || op.equals("<") || op.equals(">=") || op.equals("<=") || op.equals("==") || op.equals("!=");
    }
}