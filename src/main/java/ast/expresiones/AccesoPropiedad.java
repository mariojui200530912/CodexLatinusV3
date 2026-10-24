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
import semantico.ValidadorTipos;

public class AccesoPropiedad extends Expresion {
    public Expresion objetoBase;
    public String idPropiedad;
    public boolean esDestino = false; // true si está al lado izquierdo de un '='

    public AccesoPropiedad(Expresion objetoBase, String idPropiedad, int linea, int columna) {
        super(linea, columna);
        this.objetoBase = objetoBase;
        this.idPropiedad = idPropiedad;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        // Evaluar el objeto base (debe devolver un puntero al Heap)
        ResultadoC3D resBase = (ResultadoC3D) objetoBase.generar(entorno);

        if (resBase == null || resBase.tipo == TipoDato.ERROR) {
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // Validación semántica: Asegurar que el objeto base sea realmente un OBJETO
        if (resBase.tipo != TipoDato.OBJETO || resBase.tipoStringOriginal == null) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO,
                    "No se puede acceder a la propiedad '" + idPropiedad + "'. La expresión base no es un objeto válido.",
                    linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        String nombreClase = resBase.tipoStringOriginal;

        // Buscar la clase en el entorno global para extraer sus atributos
        Simbolo simClase = entorno.buscar(nombreClase);
        if (simClase == null || !"Clase".equals(simClase.categoria)) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "La clase '" + nombreClase + "' no está definida.", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // Buscar el atributo dentro de los parámetros (estructura simulada) de la clase
        Simbolo simAtributo = null;
        for (Simbolo attr : simClase.parametros) {
            if (attr.id.equals(idPropiedad) && "Atributo".equals(attr.categoria)) {
                simAtributo = attr;
                break;
            }
        }

        if (simAtributo == null) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO,
                    "La propiedad '" + idPropiedad + "' no pertenece a la clase '" + nombreClase + "'.",
                    linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // Obtener el tipo de dato real del atributo (parseado y string original si es objeto)
        TipoDato tipoAtributo = ValidadorTipos.parsearTipo(simAtributo.tipo);

        // Calcular la dirección física en el Heap: t_direccion = puntero_base + offset_atributo
        AccesoTemporal t_direccion = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_direccion,
                resBase.valorC3D,
                "+",
                new Literal3D(String.valueOf(simAtributo.direccionMemoria)) // offset relativo
        ));

        // Retornar dirección o extraer el valor
        ResultadoC3D resFinal;
        if (esDestino) {
            // Si es asignación (L-Value), devolvemos solo la dirección calculada en el Heap
            resFinal = new ResultadoC3D(t_direccion, tipoAtributo);
        } else {
            // Si es lectura (R-Value), emitimos la instrucción para traer el dato del Heap
            AccesoTemporal t_valor = new AccesoTemporal(gen.generarTemporal());
            gen.agregarCuarteta(new GetHeap3D(t_valor, t_direccion));
            resFinal = new ResultadoC3D(t_valor, tipoAtributo);
        }

        // Si la propiedad a la que accedemos es a su vez otro Objeto, preservamos su clase
        if (tipoAtributo == TipoDato.OBJETO) {
            resFinal.tipoStringOriginal = simAtributo.tipo;
        }

        return resFinal;
    }
}