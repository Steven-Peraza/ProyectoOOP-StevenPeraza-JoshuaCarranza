/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author Josua
 */
public class Historial {
    

    private int numNivel;
    private Nivel nivel;
    private String estado;
    private int cantidadMovimientos;
    private int tiempo;
    private int vecesJugado=0;
    private  int bestMoves;

    public Historial(int numNivel, Nivel nivel, String estado, int cantidadMovimientos, int tiempo, int bestMoves) {
        this.numNivel = numNivel;
        this.nivel = nivel;
        this.estado = estado;
        this.cantidadMovimientos = cantidadMovimientos;
        this.tiempo = tiempo;
        this.bestMoves = bestMoves;
    }    
    
    //funcion que retorna el numero del nivel jugado
    public int getNumNivel() {
        return numNivel;
    }
    //funcion que establece el numero del nivel jugado
    public void setNumNivel(int numero) {
        this.numNivel = numero;
    }
    //funcion que retorna el estado del nivel jugado (completo, incompleto)
    public String getEstado() {
        return estado;
    }
    //funcion que establece el estado del nivel jugado (completo, incompleto)
    public void setEstado(String estado) {
        this.estado = estado;
    }
    //funcion que retorna la cantidad de moves que ha realizado el usuario
    public int getCantidadMovimientos() {
        return cantidadMovimientos;
    }
    //funcion que establece la cantidad de moves que ha realizado el usuario
    public void setCantidadMovimientos(int cantidad) {
        this.cantidadMovimientos = cantidad;
    }
    //funcion que retorna el tiempo trancurrido en un nivel
    public int getTiempo() {
        return tiempo;
    }
    //funcion que establece el tiempo trancurrido en un nivel
    public void setTiempo(int segundos) {
        this.tiempo = segundos;
    }
    //funcion que retorna la cantidad de veces que ha sido jugado un nivel por el usuario.
    public int getVecesJugado() {
        return vecesJugado;
    }
    //funcion que establece la cantidad de veces que ha sido jugado un nivel por el usuario.
    public void setVecesJugado() {
        this.vecesJugado ++;
    }
    //funcion que retorna los best moves conseguidos por el usuario
    public int getBestMoves() {
        return bestMoves;
    }
    //funcion que establece los best moves conseguidos por el usuario
    public void setBestMoves(int bestMoves) {
        this.bestMoves = bestMoves;
    }
    
    public void enlazarNivel(){
        //comparar numNivel con el nivel deseado...
    }

    @Override
    public String toString() {
        return "Historial{" + "numNivel=" + numNivel + ", estado=" + estado + ", cantidadMovimientos=" + cantidadMovimientos + ", tiempo=" + tiempo + ", vecesJugado=" + vecesJugado + ", bestMoves=" + bestMoves + '}';
    }

    
}
