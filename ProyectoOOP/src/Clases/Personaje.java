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
    private int posicionIniFila;
    private int posicionIniColumna;
    private int id = 3;

    public Personaje(int posicionFila, int posicionColumna) {   //se asigna la posicion inical del personaje
        this.posicionFila = posicionFila;
        this.posicionColumna = posicionColumna;
    }

    public Personaje(int posicionFila, int posicionColumna, int posicionIniFila, int posicionIniColumna) {
        this.posicionFila = posicionFila;
        this.posicionColumna = posicionColumna;
        this.posicionIniFila = posicionIniFila;
        this.posicionIniColumna = posicionIniColumna;
    }

    
    
    
    // se retorna la posicion en y del personaje dentro de la matriz logica
    public int getPosicionFila() {
        return posicionFila;
    }

    public void setPosicionFila(int posicionFila) {
        this.posicionFila = posicionFila;
    }
    
    // se asigna la posicion en x del personaje dentro de la matriz logica
    public int getPosicionColumna() {
        return posicionColumna;
    }

    public void setPosicionColumna(int posicionColumna) {
        this.posicionColumna = posicionColumna;
    }

     // se retorna la posicion en y del personaje dentro de la matriz logica
    public int getIniPosicionFila() {
        return posicionIniFila;
    }

    public void setIniPosicionFila(int posicionFila) {
        this.posicionIniFila = posicionFila;
    }
    
    // se asigna la posicion en x del personaje dentro de la matriz logica
    public int getIniPosicionColumna() {
        return posicionIniColumna;
    }

    public void setIniPosicionColumna(int posicionColumna) {
        this.posicionIniColumna = posicionColumna;
    }
    
    public int getId() {
        return id;
    }
    
    //numero con el que se representa el personaje en la matriz logica
    public void setId(int id) {
        this.id = 3;            //numero que representa al personaje
    }

    @Override
    public String toString() {
        return "Personaje{" + "posicionFila=" + posicionFila + ", posicionColumna=" + posicionColumna + ", id=" + id + '}';
    }

    
     
    
}
