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
public class Personaje {
    
    private int posicionFila;
    private int posicionColumna;

    public Personaje(int posicionFila, int posicionColumna) {   //se asigna la posicion inical del personaje
        this.posicionFila = posicionFila;
        this.posicionColumna = posicionColumna;
    }

    
    
    
    public int getPosicionFila() {
        return posicionFila;
    }

    public void setPosicionFila(int posicionFila) {
        this.posicionFila = posicionFila;
    }

    public int getPosicionColumna() {
        return posicionColumna;
    }

    public void setPosicionColumna(int posicionColumna) {
        this.posicionColumna = posicionColumna;
    }
    
    
    
    
}
