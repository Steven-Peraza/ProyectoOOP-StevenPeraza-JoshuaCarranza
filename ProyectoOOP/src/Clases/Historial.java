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
    private String estado;
    private int cantidadMovimientos;
    private int tiempo;
    private int vecesJugado=0;
    private  int bestMoves;
    
    
    public int getNumNivel() {
        return numNivel;
    }

    public void setNumNivel(int numero) {
        this.numNivel = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidadMovimientos() {
        return cantidadMovimientos;
    }

    public void setCantidadMovimientos(int cantidad) {
        this.cantidadMovimientos = cantidad;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int segundos) {
        this.tiempo = segundos;
    }

    public int getVecesJugado() {
        return vecesJugado;
    }

    public void setVecesJugado() {
        this.vecesJugado ++;
    }

    public int getBestMoves() {
        return bestMoves;
    }

    public void setBestMoves(int bestMoves) {
        this.bestMoves = bestMoves;
    }

    
}
