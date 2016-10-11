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
public class Cajas {
    
    private int id = 1;
    private int numeroCaja;
    private int posicionFila;
    private int posicionColumna;
    private int posicionIniFila;
    private int posicionIniColumna;

    //posicion inicial de la caja y el numero de caja 
    public Cajas(int numeroCaja, int posicionFila, int posicionColumna) {
        this.numeroCaja = numeroCaja;
        this.posicionFila = posicionFila;
        this.posicionColumna = posicionColumna;
    }

    public Cajas(int numeroCaja, int posicionFila, int posicionColumna, int posicionIniFila, int posicionIniColumna) {
        this.numeroCaja = numeroCaja;
        this.posicionFila = posicionFila;
        this.posicionColumna = posicionColumna;
        this.posicionIniFila = posicionIniFila;
        this.posicionIniColumna = posicionIniColumna;
    }
    public Cajas(int posicionFila, int posicionColumna) {
        this.posicionFila = posicionFila;
        this.posicionColumna = posicionColumna;
    }
    
    
    //funcion que retorna el numero de la caja dentro del juego
    public int getNumeroCaja() {
        return numeroCaja;
    }
    //funcion que establece el numero de la caja dentro del juego
    public void setNumeroCaja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
    }
    //funcion que retorna la posicion en el eje x de la caja dentro del juego
    public int getPosicionFila() {
        return posicionFila;
    }
     //funcion que establece la posicion en el eje x de la caja dentro del juego
    public void setPosicionFila(int posicionFila) {
        this.posicionFila = posicionFila;
    }
    //funcion que retorna la posicion en el eje y de la caja dentro del juego
    public int getPosicionColumna() {
        return posicionColumna;
    }
    //funcion que establece la posicion en el eje y de la caja dentro del juego
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
    
    //funcion que retorna el numero que representa a las cajas en la matriz logica
    public int getId() {
        return id;
    }
    //funcion que establece el numero que representa a las cajas en la matriz logica
    public void setId() {
        this.id = 1;
    }

    @Override
    public String toString() {
        return "Cajas{" + "id=" + id + ", numeroCaja=" + numeroCaja + ", posicionFila=" + posicionFila + ", posicionColumna=" + posicionColumna + '}';
    }
    
    
    
}
