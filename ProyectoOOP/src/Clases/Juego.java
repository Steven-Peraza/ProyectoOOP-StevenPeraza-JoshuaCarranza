/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JLabel;
import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author Josua
 */
public class Juego {
    
    private int contmoves=0;
    private int tiempo;
    private int regresar;   //si existe el controlz esta variable
                             //representa las veces que se ha usado
   
    
   private Personaje person;
   private Reglas rules;        //reglas del juego
   private ArrayList<Cajas> cajas= new ArrayList(); 
   private int[][] ultimaCaja;
   private int[][] matrizLogica;
   private int[][]ubicacionPersonaje;
   private int reglasMovimientosCajas;
   private int segundaOportunidad=3;
   private JLabel[][] matrizGrafica;    //se guarda la matrizgrafica

    public Juego() {
        this.ultimaCaja=new int[1][0];      //se hace que las matrices de ubicacion
                                            //sean de dos columnas una fila
        this.ubicacionPersonaje= new int [1][0];
    }

    public Reglas getRules() {
        return rules;
    }

    public void setRules(int dato,int dato2) {
        this.rules.setCajasPorMover(dato);
        this.rules.setControlZ(dato2);
        
    }
    
    
    

    public Personaje getPerson() {
        return person;
    }

    public void setPerson(Personaje person) {
       
    }
    
    

    public int getContmoves() {
        return contmoves;
    }

    public void setContmoves() {
        this.contmoves ++;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getRegresar() {
        return regresar;
    }

    public void setRegresar() {
        this.regresar ++;
    }

    public int[][] getUltimaCaja() {
        return ultimaCaja;
    }

    public void setUltimaCaja(int x,int y) {
        this.ultimaCaja[0][0]=x;
        this.ultimaCaja[0][1]=y;
    }

    public int[][] getMatrizLogica() {
        return matrizLogica;
    }

    public void setMatrizLogica(int[][] matrizLogica) {
        this.matrizLogica = matrizLogica;
    }

    public int[][] getPosicionPersonaje() {
        return ubicacionPersonaje;
    }

    public void setPosicionPersonaje(int x,int y) {
        this.ubicacionPersonaje[0][0]=x ;
        this.ubicacionPersonaje[0][1]=y;
    }

    

    public int getSegundaOportunidad() {
        return segundaOportunidad;
    }

    public void setSegundaOportunidad() {
        this.segundaOportunidad--;
    }

    public JLabel[][] getMatrizGrafica() {
        return matrizGrafica;
    }

    public void setMatrizGrafica(int[][] matriz) {
        
    }
    
    public void moverArriba(){
    
    }
   
     public void moverAbajo(){
    
    
    }
     
     public void moverIzq(){
    
    
    }
     
     public void moverDerecha(){
    
    
    }
   
    public void reset(){
    
    
    } 
      
    public void setCajas(int[][]matriz){
        
        
        
    }
    
    public ArrayList<Cajas> getCajas(){
    
    return cajas;
    }
  
    
}
