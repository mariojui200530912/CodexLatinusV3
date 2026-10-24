package ast.expresiones;

import ast.Expresion;
import ast.ResultadoC3D;
import cuartetas.AccesoTemporal;
import cuartetas.Casteo3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.TablaSimbolos;
import semantico.TipoDato;

public class Casteo extends Expresion {
    public TipoDato tipoDestino;
    public Expresion expresion;

    public Casteo(TipoDato tipoDestino, Expresion expresion, int linea, int columna) {
        super(linea, columna);
        this.tipoDestino = tipoDestino;
        this.expresion = expresion;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();
        ResultadoC3D resOriginal = (ResultadoC3D) expresion.generar(entorno);

        if (resOriginal == null || resOriginal.tipo == TipoDato.ERROR) {
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // Validacion de casteos permitidos
        boolean casteoValido = false;

        if (tipoDestino == TipoDato.ENTERO && resOriginal.tipo == TipoDato.DECIMAL) casteoValido = true;
        else if (tipoDestino == TipoDato.DECIMAL && resOriginal.tipo == TipoDato.ENTERO) casteoValido = true;
        else if (tipoDestino == TipoDato.ENTERO && resOriginal.tipo == TipoDato.CARACTER) casteoValido = true;
        else if (tipoDestino == TipoDato.CARACTER && resOriginal.tipo == TipoDato.ENTERO) casteoValido = true;

        if (!casteoValido) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "No es posible castear de '" + resOriginal.tipo + "' a '" + tipoDestino + "'.", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // Emitir cuarteta especial de casteo (TraductorRiscV la convertirá en fcvt.s.w o fcvt.w.s)
        AccesoTemporal t_casteado = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new Casteo3D(t_casteado, resOriginal.valorC3D, tipoDestino.toString()));

        return new ResultadoC3D(t_casteado, tipoDestino);
    }
}