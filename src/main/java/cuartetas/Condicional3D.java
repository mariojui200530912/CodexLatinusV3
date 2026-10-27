package cuartetas;

import generador.TraductorRiscV;

public class Condicional3D extends Cuarteta {
    public Operando3D izq;
    public Operando3D der;
    public String operador;
    public String etiqueta;

    public Condicional3D(Operando3D izq, Operando3D der, String operador, String etiqueta) {
        this.izq = izq;
        this.der = der;
        this.operador = operador;
        this.etiqueta = etiqueta;
    }

    @Override
    public String generarCodigo() {
        return "if (" + izq.obtenerValor() + " " + operador + " " + der.obtenerValor() + ") goto " + etiqueta + ";\n";
    }

    @Override
    public void traducirRiscV(StringBuilder ensamblador, TraductorRiscV traductor) {
        // Usamos registros temporales seguros 't0' y 't1'
        traductor.cargarOperando(izq, "t0");
        traductor.cargarOperando(der, "t1");

        // Mapear el operador de C3D a la instrucción de salto condicional de RISC-V
        String branchOp;
        switch (operador) {
            case "==": branchOp = "beq"; break;
            case "!=": branchOp = "bne"; break;
            case "<":  branchOp = "blt"; break;
            case ">":  branchOp = "bgt"; break;
            case "<=": branchOp = "ble"; break;
            case ">=": branchOp = "bge"; break;
            default:   branchOp = "beq"; break;
        }

        // Escribir la instrucción ensamblador usando t0 y t1
        ensamblador.append("    ").append(branchOp).append(" t0, t1, ").append(etiqueta).append("\n");
    }
}