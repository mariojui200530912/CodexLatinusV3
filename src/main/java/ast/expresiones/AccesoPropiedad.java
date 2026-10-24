package ast.expresiones;

import ast.Expresion;
import ast.ResultadoC3D;
import cuartetas.AccesoTemporal;
import cuartetas.GetHeap3D;
import cuartetas.Literal3D;
import cuartetas.OperacionBinaria3D;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.Simbolo;
import semantico.TablaSimbolos;
import semantico.TipoDato;

public class AccesoPropiedad extends Expresion {
    public Expresion objetoBase;
    public String propiedad;
    public boolean esDestino = false;

    public AccesoPropiedad(Expresion objetoBase, String propiedad, int linea, int columna) {
        super(linea, columna);
        this.objetoBase = objetoBase;
        this.propiedad = propiedad;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        // Obtener la referencia (puntero) base del objeto en el Heap
        ResultadoC3D resBase = (ResultadoC3D) objetoBase.generar(entorno);

        if (resBase == null || resBase.tipo != TipoDato.OBJETO || resBase.tipoStringOriginal == null) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "No se puede acceder a la propiedad '" + propiedad + "' de una referencia nula o tipo inválido.", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // Buscar la clase base en el entorno global para calcular el desplazamiento (offset) del atributo
        Simbolo simClase = entorno.buscar(resBase.tipoStringOriginal);
        Simbolo simPropiedad = null;

        if (simClase != null && simClase.parametros != null) {
            for (Simbolo param : simClase.parametros) {
                if (param.id.equals(propiedad)) {
                    simPropiedad = param;
                    break;
                }
            }
        }

        if (simPropiedad == null) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "La propiedad '" + propiedad + "' no existe en la clase '" + resBase.tipoStringOriginal + "'.", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // Calcular la dirección física: Puntero Base (Heap) + Offset del atributo
        AccesoTemporal t_posicion = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_posicion, resBase.valorC3D, "+", new Literal3D(String.valueOf(simPropiedad.direccionMemoria))
        ));

        this.tipo = semantico.ValidadorTipos.parsearTipo(simPropiedad.tipo);

        // Si es asignación (L-Value), retornamos la dirección calculada en el Heap
        if (esDestino) {
            ResultadoC3D resDestino = new ResultadoC3D(t_posicion, this.tipo);
            if (this.tipo == TipoDato.OBJETO) resDestino.tipoStringOriginal = simPropiedad.tipo;
            return resDestino;
        }

        // Si es lectura (R-Value), extraemos el valor almacenado en el Heap
        AccesoTemporal t_valor = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new GetHeap3D(t_valor, t_posicion));

        ResultadoC3D resFinal = new ResultadoC3D(t_valor, this.tipo);
        if (this.tipo == TipoDato.OBJETO) resFinal.tipoStringOriginal = simPropiedad.tipo;

        return resFinal;
    }
}