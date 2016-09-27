/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author Josua
 */
public class Reglas {
    private int cajasPorMover;
    private int controlZ;

    // constructor de la clase
    public Reglas(int cajasPorMover, int controlZ) {
        this.cajasPorMover = cajasPorMover;
        this.controlZ = controlZ;
    }
    
    // se retorna un valor con el que se determina si la regla esta activa o no
    public int getCajasPorMover() {
        return cajasPorMover;
    }

    
    public void setCajasPorMover(int regla) {
        this.cajasPorMover = regla;
    }
    
    // se retorna un valor con el que se determina si la regla esta activa o no
    public int getControlZ() {
        return controlZ;
    }

    public void setControlZ(int habilitar) {
        this.controlZ = habilitar;
    }

    @Override
    public String toString() {
        return "Reglas{" + "cajasPorMover=" + cajasPorMover + ", controlZ=" + controlZ + '}';
    }
    
    
    
}
