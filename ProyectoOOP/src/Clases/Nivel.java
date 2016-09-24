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

    //se recibe el tamaño que tendrá la matriz del nivel y se asigna
    public Nivel(int columnas, int filas) {
        this.columnas = columnas;
        this.filas = filas;
    }

    
    
    
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
    
    //se inicialia la matriz con el tamaño especificado
    public void generarMatriz(){
    
    matrizLogica= new int [columnas][filas];    
    }
    
    // se recibe la posicion de la matriz logica en la que se insertará la caja
    public void hacerCaja (int x,int y){
    
        if (((x>0)&&(x<filas))&&((y>0)&&(y<filas))){    //que no este en ninguno de los extremos de la matriz   
        
            matrizLogica[x][y]=1;       //el uno representa a las cajas en la matriz logica 
        }   
    }
    
    public void hacerPunto(int x,int y){
    
        if (((x>0)&&(x<filas))&&((y>0)&&(y<filas))){ 
            
             matrizLogica[x][y]=2;       //el dos representa a los puntos en la matriz logica 
             
        }
    
    }
    
    public void ubicarPersonaje(int x,int y){
     if (((x>0)&&(x<filas))&&((y>0)&&(y<filas))){ 
            
             matrizLogica[x][y]=3;       //el tres representa al personaje en la matriz logica 
             
        }
    
    }
    
    public void hacerPared (int x,int y){

        if (((x>0)&&(x<filas))&&((y>0)&&(y<filas))){ 
            
             matrizLogica[x][y]=0;       //el cero represen a la pared en la matriz logica 
             
        }
    
    } 
    
    //se revisa si la matriz esta bien hecha
    // se retorna un uno si sí un dos si no
    public int validarMatriz(){
    
    return 0;
    }

    @Override
    public String toString() {
        return "Nivel{" + "cantCajas=" + cantCajas + ", cantPuntos=" + cantPuntos + ", columnas=" + columnas + ", filas=" + filas + ", personajeColumna=" + personajeColumna + ", personajeFila=" + personajeFila + ", nombreAdministrador=" + nombreAdministrador + ", cedulaAdministrador=" + cedulaAdministrador + ", numNivel=" + numNivel + ", bestMoves=" + bestMoves + '}';
    }
        
        
    }



