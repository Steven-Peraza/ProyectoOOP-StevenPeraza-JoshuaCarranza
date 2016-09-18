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
public class Estadistica {
    
    private int cantNivelesJugados=0;
    private int recordRotos;
    private int canGanesOptimizados;
    private int partidasGrupalesJugadas;
    

    public int getCantNivelesJugados() {
        return cantNivelesJugados;
    }

    public void setCantNivelesJugados() {
        this.cantNivelesJugados ++;
    }

    public int getRecordRotos() {
        return recordRotos;
    }

    public void setRecordRotos() {
        this.recordRotos ++;
    }

    public int getCanGanesOptimizados() {
        return canGanesOptimizados;
    }

    public void setCanGanesOptimizados() {
        this.canGanesOptimizados ++;
    }

    public int getPartidasGrupalesJugadas() {
        return partidasGrupalesJugadas;
    }

    public void setPartidasGrupalesJugadas() {
        this.partidasGrupalesJugadas ++;
    }
    
    
    
}
