package ast.instrucciones;

import ast.Expresion;
import ast.Instruccion;
import ast.ResultadoC3D;
import cuartetas.Condicional3D;
import cuartetas.DefinicionEtiqueta3D;
import cuartetas.Goto3D;
import cuartetas.Literal3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.TablaSimbolos;
import semantico.TipoDato;

import java.util.List;

public class NodoIf extends Instruccion {
    public Expresion condicion;
    public List<Instruccion> bloqueVerdadero;
    public List<Instruccion> bloqueFalso; // Puede contener instrucciones de un 'else' o un único NodoIf para un 'else if'

    public NodoIf(Expresion condicion, List<Instruccion> bloqueVerdadero, List<Instruccion> bloqueFalso, int linea, int columna) {
        super(linea, columna);
        this.condicion = condicion;
        this.bloqueVerdadero = bloqueVerdadero;
        this.bloqueFalso = bloqueFalso;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        // Evaluar la condición
        ResultadoC3D resCondicion = (ResultadoC3D) condicion.generar(entorno);

        if (resCondicion == null || resCondicion.tipo == TipoDato.ERROR) {
            return null; // El error ya fue reportado por los nodos hijos
        }

        // Validación Semántica: La condición debe ser estrictamente BOOLEANA
        if (resCondicion.tipo != TipoDato.BOOLEANO) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO,
                    "La condición de la sentencia 'if' debe ser de tipo BOOLEANO. Se encontró: " + resCondicion.tipo,
                    linea, columna
            );
            return null;
        }

        // Generar etiquetas de control de flujo
        String L_Verdadero = gen.generarEtiqueta();
        String L_Falso = gen.generarEtiqueta();
        String L_Salida = gen.generarEtiqueta();

        // Salto condicional: if (condicion == 1) goto L_Verdadero
        gen.agregarCuarteta(new Condicional3D(resCondicion.valorC3D, new Literal3D("1"), "==", L_Verdadero));

        // Si la condición no se cumplió, el flujo "cae" al goto L_Falso
        gen.agregarCuarteta(new Goto3D(L_Falso));

        // --- BLOQUE VERDADERO ---
        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Verdadero));

        // Crear un nuevo ámbito (Scope) para que las variables locales del 'if' no afecten al exterior
        TablaSimbolos entornoVerdadero = new TablaSimbolos(entorno, "If_Verdadero");
        if (bloqueVerdadero != null) {
            for (Instruccion inst : bloqueVerdadero) {
                if (inst != null) inst.generar(entornoVerdadero);
            }
        }

        // Al terminar el bloque verdadero, saltar hacia el final para evitar ejecutar el else
        gen.agregarCuarteta(new Goto3D(L_Salida));

        // --- BLOQUE FALSO (ELSE / ELSE IF) ---
        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Falso));

        if (bloqueFalso != null && !bloqueFalso.isEmpty()) {
            TablaSimbolos entornoFalso = new TablaSimbolos(entorno, "If_Falso");
            for (Instruccion inst : bloqueFalso) {
                if (inst != null) inst.generar(entornoFalso);
            }
        }

        // --- ETIQUETA DE SALIDA ---
        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Salida));

        return null;
    }
}