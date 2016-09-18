/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author Josua
 */
public class Nivel {
    
    private int cantCajas;
    private int cantPuntos;
    private int[][] matrizLogica;
    private int columnas;
    private int filas;
    private int personajeColumna;
    private int personajeFila;
    private String nombreAdministrador;
    private int cedulaAdministrador;
    private int numNivel;
    private int bestMoves;

    public int getCantCajas() {
        return cantCajas;
    }

    public void setCantCajas(int cantCajas) {
        this.cantCajas = cantCajas;
    }

    public int getCantPuntos() {
        return cantPuntos;
    }

    public void setCantPuntos(int cantPuntos) {
        this.cantPuntos = cantPuntos;
    }

    public int[][] getMatrizLogica() {
        return matrizLogica;
    }

    public void setMatrizLogica(int[][] matrizLogica) {
        this.matrizLogica = matrizLogica;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getPersonajeColumna() {
        return personajeColumna;
    }

    public void setPersonajeColumna(int personajeColumna) {
        this.personajeColumna = personajeColumna;
    }

    public int getPersonajeFila() {
        return personajeFila;
    }

    public void setPersonajeFila(int personajeFila) {
        this.personajeFila = personajeFila;
    }

    public String getNombreAdministrador() {
        return nombreAdministrador;
    }

    public void setNombreAdministrador(String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }

    public int getCedulaAdministrador() {
        return cedulaAdministrador;
    }

    public void setCedulaAdministrador(int cedulaAdministrador) {
        this.cedulaAdministrador = cedulaAdministrador;
    }

    public int getNumNivel() {
        return numNivel;
    }

    public void setNumNivel(int numNivel) {
        this.numNivel = numNivel;
    }

    public int getBestMoves() {
        return bestMoves;
    }

    public void setBestMoves(int bestMoves) {
        this.bestMoves = bestMoves;
    }
    
    
}
