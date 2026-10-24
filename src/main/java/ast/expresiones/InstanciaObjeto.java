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

import java.util.ArrayList;
import java.util.List;

public class InstanciaObjeto extends Expresion {
    public String nombreClase;
    public List<Expresion> argumentos;

    public InstanciaObjeto(String nombreClase, List<Expresion> argumentos, int linea, int columna) {
        super(linea, columna);
        this.nombreClase = nombreClase;
        this.argumentos = argumentos != null ? argumentos : new ArrayList<>();
    }

    @Override
    public Object generar(TablaSimbolos entorno) {
        GeneradorC3D gen = GeneradorC3D.getInstancia();

        // Validar que la clase exista en la Tabla de Símbolos global
        Simbolo simClase = entorno.buscar(nombreClase);
        if (simClase == null || !"Clase".equals(simClase.categoria)) {
            GestorErrores.getInstancia().agregarError(
                    TipoError.SEMANTICO, "No se puede instanciar. La clase '" + nombreClase + "' no existe.", linea, columna
            );
            return new ResultadoC3D(null, TipoDato.ERROR);
        }

        // Evaluar los argumentos que se enviarán al constructor
        List<ResultadoC3D> resultadosArgs = new ArrayList<>();
        for (Expresion arg : argumentos) {
            ResultadoC3D resArg = (ResultadoC3D) arg.generar(entorno);
            if (resArg != null && resArg.tipo != TipoDato.ERROR) {
                resultadosArgs.add(resArg);
            }
        }

        // Reservar memoria en el Heap (H) para el nuevo objeto
        AccesoTemporal t_refObjeto = new AccesoTemporal(gen.generarTemporal());

        // Guardamos el puntero actual del Heap (H) como la referencia del objeto
        gen.agregarCuarteta(new Asignacion3D(t_refObjeto, new PunteroGlobal3D("H")));

        // Movemos el puntero del Heap según el tamaño de la clase (H = H + tamanoClase)
        AccesoTemporal t_nuevoH = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_nuevoH, new PunteroGlobal3D("H"), "+", new Literal3D(String.valueOf(simClase.tamano))
        ));
        gen.agregarCuarteta(new Asignacion3D(new PunteroGlobal3D("H"), t_nuevoH));

        // Preparar el cambio de entorno simulado (Stack) para llamar al constructor
        AccesoTemporal t_nuevoP = new AccesoTemporal(gen.generarTemporal());

        // Calculamos dónde inicia el nuevo entorno: t_nuevoP = P + entorno.offset
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_nuevoP, new PunteroGlobal3D("P"), "+", new Literal3D(String.valueOf(entorno.offset))
        ));

        // Inyectar el puntero 'this' en la posición 0 del nuevo entorno (Stack[t_nuevoP + 0] = t_refObjeto)
        AccesoTemporal t_posThis = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(t_posThis, t_nuevoP, "+", new Literal3D("0")));
        gen.agregarCuarteta(new SetStack3D(t_posThis, t_refObjeto));

        // Pasar el resto de argumentos a partir de la posición 1 (Stack[t_nuevoP + 1], Stack[t_nuevoP + 2]...)
        for (int i = 0; i < resultadosArgs.size(); i++) {
            AccesoTemporal t_posArg = new AccesoTemporal(gen.generarTemporal());
            gen.agregarCuarteta(new OperacionBinaria3D(
                    t_posArg, t_nuevoP, "+", new Literal3D(String.valueOf(i + 1))
            ));
            gen.agregarCuarteta(new SetStack3D(t_posArg, resultadosArgs.get(i).valorC3D));
        }

        // Mover Puntero, llamar al constructor y regresar Puntero
        String nombreConstructor = nombreClase + "_" + nombreClase; // Name Mangling del constructor

        gen.agregarCuarteta(new Asignacion3D(new PunteroGlobal3D("P"), t_nuevoP));
        // NOTA: Asegúrate de tener una cuarteta Llamada3D o similar que traduzca a "nombreConstructor();" en C3D
        gen.agregarCuarteta(new Asignacion3D(new AccesoTemporal("llamar"), new Literal3D(nombreConstructor + "()")));

        AccesoTemporal t_regresarP = new AccesoTemporal(gen.generarTemporal());
        gen.agregarCuarteta(new OperacionBinaria3D(
                t_regresarP, new PunteroGlobal3D("P"), "-", new Literal3D(String.valueOf(entorno.offset))
        ));
        gen.agregarCuarteta(new Asignacion3D(new PunteroGlobal3D("P"), t_regresarP));

        // Devolver el tipo OBJETO y adjuntar el nombre de la clase original para futuras validaciones semánticas
        ResultadoC3D resultado = new ResultadoC3D(t_refObjeto, TipoDato.OBJETO);
        resultado.tipoStringOriginal = nombreClase;

        return resultado;
    }
}