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
    private int recordRotos=0;
    private int canGanesOptimizados=0;
    private int nivelMasRepetido;

    public Estadistica(int recordRotos, int canGanesOptimizados, int nivelMasRepetido) {
        this.recordRotos = recordRotos;
        this.canGanesOptimizados = canGanesOptimizados;
        this.nivelMasRepetido = nivelMasRepetido;
    }
    
    //funcion que retorna la cantidad de niveles jugados
    public int getCantNivelesJugados() {
        return cantNivelesJugados;
    }
    //funcion que establece la cantidad de niveles jugados
    public void setCantNivelesJugados() {
        this.cantNivelesJugados ++;
    }
    //funcion que retorna la cantidad records rotos
    public int getRecordRotos() {
        return recordRotos;
    }
    //funcion que establece la cantidad de records rotos
    public void setRecordRotos() {
        this.recordRotos ++;
    }
    //funcion que retorna la cantidad de ganes optimizados
    public int getCanGanesOptimizados() {
        return canGanesOptimizados;
    }
    //funcion que establece la cantidad de ganes optimizados
    public void setCanGanesOptimizados() {
        this.canGanesOptimizados ++;
    }
    //funcion que retorna el nivel mas repetido por el usuario
    public int getNivelMasRepetido() {
        return nivelMasRepetido;
    }
    //funcion que establece el nivel mas repetido por el usuario
    public void setNivelMasRepetido(int nivel) {
        this.nivelMasRepetido = nivel;
    }

    @Override
    public String toString() {
        return "Estadistica{" + "cantNivelesJugados=" + cantNivelesJugados + ", recordRotos=" + recordRotos + ", canGanesOptimizados=" + canGanesOptimizados + ", nivelMasRepetido=" + nivelMasRepetido + '}';
    }

    

    
    
    
    
}
