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

public class NodoPara extends Instruccion {
    public Instruccion inicializacion;
    public Expresion condicion;
    public Instruccion actualizacion;
    public List<Instruccion> bloque;

    public NodoPara(Instruccion inicializacion, Expresion condicion, Instruccion actualizacion, List<Instruccion> bloque, int linea, int columna) {
        super(linea, columna);
        this.inicializacion = inicializacion;
        this.condicion = condicion;
        this.actualizacion = actualizacion;
        this.bloque = bloque;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        // AMBITO DE INICIALIZACIÓN
        TablaSimbolos entornoPara = new TablaSimbolos(entorno, "Para_Init");
        entornoPara.esCiclo = true;

        if (inicializacion != null) {
            inicializacion.generar(entornoPara);
        }

        // CREACION DE ETIQUETAS
        String L_Condicion = gen.generarEtiqueta();
        String L_Verdadero = gen.generarEtiqueta();
        String L_Falso = gen.generarEtiqueta();
        String L_Actualizacion = gen.generarEtiqueta(); // Exclusiva del ciclo For

        // EVALUACION DE LA CONDICION
        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Condicion));

        if (condicion != null) {
            ResultadoC3D resCond = (ResultadoC3D) condicion.generar(entornoPara);

            if (resCond == null || resCond.tipo == TipoDato.ERROR) return null;

            if (resCond.tipo != TipoDato.BOOLEANO) {
                GestorErrores.getInstancia().agregarError(
                        TipoError.SEMANTICO, "La condición del ciclo 'para' (for) debe ser de tipo BOOLEANO. Se encontró: " + resCond.tipo, linea, columna
                );
                return null;
            }

            gen.agregarCuarteta(new Condicional3D(resCond.valorC3D, new Literal3D("1"), "==", L_Verdadero));
            gen.agregarCuarteta(new Goto3D(L_Falso));
        } else {
            // Si el for no tiene condición for(;;), es un ciclo infinito
            gen.agregarCuarteta(new Goto3D(L_Verdadero));
        }

        // BLOQUE VERDADERO ---
        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Verdadero));

        // El 'continue' en un FOR no salta a la condición, salta a la actualización (i++)
        gen.etiquetasContinue.push(L_Actualizacion);
        gen.etiquetasBreak.push(L_Falso);

        // ambito interno para el bloque de código del ciclo
        TablaSimbolos entornoBloque = new TablaSimbolos(entornoPara, "Para_Bloque");
        entornoBloque.esCiclo = true;

        if (bloque != null) {
            for (Instruccion inst : bloque) {
                if (inst != null) inst.generar(entornoBloque);
            }
        }

        gen.etiquetasContinue.pop();
        gen.etiquetasBreak.pop();

        // Aquí es donde saltan los comandos 'continue'
        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Actualizacion));
        if (actualizacion != null) {
            // Generamos la actualización en entornoPara para que tenga acceso a la variable iteradora
            actualizacion.generar(entornoPara);
        }

        // Bucle: Regresar incondicionalmente a evaluar la condición de nuevo
        gen.agregarCuarteta(new Goto3D(L_Condicion));

        // ETIQUETA DE SALIDA ---
        gen.agregarCuarteta(new DefinicionEtiqueta3D(L_Falso));

        return null;
    }
}