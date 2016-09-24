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
    
    private int id;
    private int numeroCaja;
    private int posicionFila;
    private int posicionColumna;

    //posicion inicial de la caja y el numero de caja 
    public Cajas(int numeroCaja, int posicionFila, int posicionColumna) {
        this.numeroCaja = numeroCaja;
        this.posicionFila = posicionFila;
        this.posicionColumna = posicionColumna;
    }

    
    
    public int getNumeroCaja() {
        return numeroCaja;
    }

    public void setNumeroCaja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
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

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = 1;
    }

    @Override
    public String toString() {
        return "Cajas{" + "id=" + id + ", numeroCaja=" + numeroCaja + ", posicionFila=" + posicionFila + ", posicionColumna=" + posicionColumna + '}';
    }
    
    
    
}
