package ast.expresiones;

import ast.Expresion;
import ast.ResultadoC3D;
import cuartetas.*;
import errores.GestorErrores;
import errores.TipoError;
import generador.GeneradorC3D;
import semantico.Simbolo;
import semantico.TablaSimbolos;
import semantico.TipoDato;

import java.util.List;

public class InstanciaObjeto extends Expresion {
    public String nombreClase;
    public List<Expresion> argumentos; // Para el constructor

    public InstanciaObjeto(String nombreClase, List<Expresion> argumentos, int linea, int columna) {
        super(linea, columna);
        this.nombreClase = nombreClase;
        this.argumentos = argumentos;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        // Buscar la definicion de la clase en el entorno global
        Simbolo simClase = entorno.buscar(nombreClase);

        if (simClase == null || !"Clase".equals(simClase.categoria)) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "No se puede instanciar la clase '" + nombreClase + "' porque no existe.", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // Guardar la direccion base actual del Heap (H) que será la referencia 'this' del objeto
        AccesoTemporal t_referenciaThis = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new Asignacion3D(t_referenciaThis, new cuartetas.PunteroGlobal3D("H")));

        // Reservar el espacio de todos los atributos moviendo el puntero H
        gen.agregarCuarteta(new OperacionBinaria3D(
                new cuartetas.PunteroGlobal3D("H"),
                new cuartetas.PunteroGlobal3D("H"),
                "+",
                new Literal3D(String.valueOf(simClase.tamano))
        ));

        // Calcular el inicio del nuevo entorno temporal: t_nuevoP = P + entorno.offset
        AccesoTemporal t_nuevoP = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_nuevoP, new cuartetas.PunteroGlobal3D("P"), "+", new Literal3D(String.valueOf(entorno.offset))
        ));

        // Inyectar 'this' en la posición 0 del Stack de la función constructora
        AccesoTemporal t_posThis = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(t_posThis, t_nuevoP, "+", new Literal3D("0")));
        gen.agregarCuarteta(new SetStack3D(t_posThis, t_referenciaThis));

        // Evaluar e inyectar los argumentos del constructor a partir de la posición 1 del nuevo Stack
        if (argumentos != null && !argumentos.isEmpty()) {
            for (int i = 0; i < argumentos.size(); i++) {
                ResultadoC3D resArg = (ResultadoC3D) argumentos.get(i).generar(entorno);
                if (resArg != null && resArg.tipo != TipoDato.ERROR) {
                    AccesoTemporal t_posArg = new AccesoTemporal(gen.generarTemporal());

                    // Posición param = t_nuevoP + (i + 1)
                    gen.agregarCuarteta(new OperacionBinaria3D(
                            t_posArg, t_nuevoP, "+", new Literal3D(String.valueOf(i + 1))
                    ));
                    gen.agregarCuarteta(new SetStack3D(t_posArg, resArg.valorC3D));
                }
            }
        }

        String nombreConstructor = nombreClase + "_" + nombreClase;

        // Cambio de entorno y LLAMADA AL CONSTRUCTOR usando Call3D
        gen.agregarCuarteta(new Asignacion3D(new cuartetas.PunteroGlobal3D("P"), t_nuevoP));
        gen.agregarCuarteta(new Call3D(nombreConstructor)); // <--- CORRECCIÓN APLICADA

        // Restauración del entorno
        AccesoTemporal t_regresarP = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_regresarP, new cuartetas.PunteroGlobal3D("P"), "-", new Literal3D(String.valueOf(entorno.offset))
        ));
        gen.agregarCuarteta(new Asignacion3D(new cuartetas.PunteroGlobal3D("P"), t_regresarP));

        // Retornar la referencia del objeto en memoria
        ResultadoC3D res = new ResultadoC3D(t_referenciaThis, TipoDato.OBJETO);
        res.tipoStringOriginal = nombreClase;
        return res;
    }
}