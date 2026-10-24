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
    public Expresion condicionPrincipal;
    public List<Instruccion> bloqueVerdadero;
    public List<NodoSino> listaSinos;
    public List<Instruccion> bloqueContrario;

    public NodoIf(Expresion condicionPrincipal, List<Instruccion> bloqueVerdadero, List<NodoSino> listaSinos, List<Instruccion> bloqueContrario, int linea, int columna) {
        super(linea, columna);
        this.condicionPrincipal = condicionPrincipal;
        this.bloqueVerdadero = bloqueVerdadero;
        this.listaSinos = listaSinos;
        this.bloqueContrario = bloqueContrario;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();
        String L_Salida = gen.generarEtiqueta();

        // Evaluar IF principal
        ResultadoC3D resCond = (ResultadoC3D) condicionPrincipal.generar(entorno);
        validarBooleano(resCond, linea, columna);

        String L_Verdadero = gen.generarEtiqueta();
        String L_Falso = gen.generarEtiqueta();

        gen.agregarCuarteta(new Condicional3D(resCond.valorC3D, new Literal3D("1"), "==", L_Verdadero));
        gen.agregarCuarteta(new Goto3D(L_Falso));

        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Verdadero));
        TablaSimbolos entornoIf = new TablaSimbolos(entorno, "Bloque_If");
        ejecutarBloque(bloqueVerdadero, entornoIf);
        gen.agregarCuarteta(new Goto3D(L_Salida));

        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Falso));

        // Evaluar SINOS (else if)
        if (listaSinos != null) {
            for (NodoSino sino : listaSinos) {
                ResultadoC3D resCondSino = (ResultadoC3D) sino.condicion.generar(entorno);
                validarBooleano(resCondSino, sino.linea, sino.columna);

                String L_VerdaderoSino = gen.generarEtiqueta();
                String L_FalsoSino = gen.generarEtiqueta();

                gen.agregarCuarteta(new Condicional3D(resCondSino.valorC3D, new Literal3D("1"), "==", L_VerdaderoSino));
                gen.agregarCuarteta(new Goto3D(L_FalsoSino));

                gen.agregarCuarteta(new DefinicionEtiqueta3D(L_VerdaderoSino));
                TablaSimbolos entornoSino = new TablaSimbolos(entorno, "Bloque_Sino");
                ejecutarBloque(sino.bloque, entornoSino);
                gen.agregarCuarteta(new Goto3D(L_Salida));

                gen.agregarCuarteta(new DefinicionEtiqueta3D(L_FalsoSino));
            }
        }

        // Evaluar CONTRARIO (else)
        if (bloqueContrario != null && !bloqueContrario.isEmpty()) {
            TablaSimbolos entornoElse = new TablaSimbolos(entorno, "Bloque_Else");
            ejecutarBloque(bloqueContrario, entornoElse);
        }

        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Salida));
        return null;
    }

    private void validarBooleano(ResultadoC3D res, int l, int c) {
        if (res != null && res.tipo != TipoDato.BOOLEANO && res.tipo != TipoDato.ERROR) {
            GestorErrores.getInstancia().agregarError(TipoError.SEMANTICO, "La condición debe ser booleana.", l, c);
        }
    }

    private void ejecutarBloque(List<Instruccion> bloque, TablaSimbolos ent) {
        if (bloque != null) {
            for (Instruccion inst : bloque) {
                if (inst != null) inst.generar(ent);
            }
        }
    }

    public static class NodoSino {
        public Expresion condicion;
        public List<Instruccion> bloque;
        public int linea, columna;
        public NodoSino(Expresion condicion, List<Instruccion> bloque, int linea, int columna) {
            this.condicion = condicion; this.bloque = bloque; this.linea = linea; this.columna = columna;
        }
    }
}