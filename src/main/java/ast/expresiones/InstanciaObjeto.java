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
    public List<Expresion> argumentos;

    public InstanciaObjeto(String nombreClase, List<Expresion> argumentos, int linea, int columna) {
        super(linea, columna);
        this.nombreClase = nombreClase;
        this.argumentos = argumentos;
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();
        Simbolo simClase = entorno.buscar(nombreClase);

        if (simClase == null || !"Clase".equals(simClase.categoria)) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "No se puede instanciar la clase '" + nombreClase + "' porque no existe.", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // Guardar la direccion base actual del Heap (H) que será la referencia 'this'
        AccesoTemporal t_referenciaThis = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new Asignacion3D(t_referenciaThis, new PunteroGlobal3D("H")));

        // INYECCIÓN DE LA V-TABLE (Polimorfismo en tiempo de ejecución)
        AccesoTemporal t_posVTable = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(t_posVTable, t_referenciaThis, "+", new Literal3D(String.valueOf(simClase.tamano))));

        // Usamos el hashcode absoluto de la clase como ID de V-Table
        int idClaseRuntime = Math.abs(nombreClase.hashCode() % 99999);
        gen.agregarCuarteta(new SetHeap3D(t_posVTable, new Literal3D(String.valueOf(idClaseRuntime))));

        // Reservar memoria total moviendo H: (Atributos + 1 slot para la V-Table)
        gen.agregarCuarteta(new OperacionBinaria3D(
                new PunteroGlobal3D("H"),
                new PunteroGlobal3D("H"),
                "+",
                new Literal3D(String.valueOf(simClase.tamano + 1))
        ));

        // Calcular el inicio del nuevo entorno temporal para el constructor
        AccesoTemporal t_nuevoP = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_nuevoP, new PunteroGlobal3D("P"), "+", new Literal3D(String.valueOf(entorno.offset))
        ));

        // Inyectar 'this' en la posición 0 del Stack del constructor
        AccesoTemporal t_posThis = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(t_posThis, t_nuevoP, "+", new Literal3D("0")));
        gen.agregarCuarteta(new SetStack3D(t_posThis, t_referenciaThis));

        //Inyectar los argumentos enviados al constructor
        if (argumentos != null && !argumentos.isEmpty()) {
            for (int i = 0; i < argumentos.size(); i++) {
                ResultadoC3D resArg = (ResultadoC3D) argumentos.get(i).generar(entorno);
                if (resArg != null && resArg.tipo != TipoDato.ERROR) {
                    AccesoTemporal t_posArg = new AccesoTemporal(gen.generarTemporal());
                    gen.agregarCuarteta(new OperacionBinaria3D(
                            t_posArg, t_nuevoP, "+", new Literal3D(String.valueOf(i + 1))
                    ));
                    gen.agregarCuarteta(new SetStack3D(t_posArg, resArg.valorC3D));
                }
            }
        }

        // Cambio de entorno y LLAMADA AL CONSTRUCTOR
        String nombreConstructor = nombreClase + "_" + nombreClase;
        gen.agregarCuarteta(new Asignacion3D(new PunteroGlobal3D("P"), t_nuevoP));
        gen.agregarCuarteta(new Call3D(nombreConstructor));

        // Restauración del entorno (Regresar P a su estado original)
        AccesoTemporal t_regresarP = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_regresarP, new PunteroGlobal3D("P"), "-", new Literal3D(String.valueOf(entorno.offset))
        ));
        gen.agregarCuarteta(new Asignacion3D(new PunteroGlobal3D("P"), t_regresarP));

        // Retornar la referencia del objeto instanciado
        ResultadoC3D res = new ResultadoC3D(t_referenciaThis, TipoDato.OBJETO);
        res.tipoStringOriginal = nombreClase;
        return res;
    }
}