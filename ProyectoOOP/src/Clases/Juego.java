/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import javax.swing.JLabel;
import java.util.ArrayList;


/**
 *
 * @author Josua
 */
public class Juego {
    
    private int contmoves=0;
    private int tiempo;
    private int regresar=0;   //si existe el controlz esta variable
                             //representa las veces que se ha usado
    private Nivel nivel;
   private Personaje person;
   private int deshacer; 
   private int numNivel;
   private ArrayList<Cajas> cajas; 
   private int[] ultimaCaja;
   private int[][] matrizLogica;
   private int reglaMovimientosCajas;
   private int segundaOportunidad=3;
   private JLabel[][] matrizGrafica;    //se tiene la matrizgrafica
   private int[] ultimoPersonaje;
   

    public Juego() {
        person = new Personaje(0,0); //Cambiar el 0,0
        ultimaCaja=new int [3];     //un arreglo de 3 , para guardar el numero de caja, y la posicion
    }

    public int getContmoves() {
        return contmoves;
    }

    public void setContmoves() {
        this.contmoves++;
    }
    
    public void setPosicionPersonaje(int x,int y){
    
    person.setPosicionColumna(x);       //se asigna al objeto persona la posicion
    person.setPosicionFila(y);
    
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int segundos) {
        this.tiempo = tiempo;
    }

    public int getRegresar() {
        return regresar;
    }

    public void setRegresar() { //se aumenta porque se uso el control z
        this.regresar ++;
    }

    public int[] getUltimaCaja() {
        return ultimaCaja;
    }

    public void setUltimaCaja(int x,int y,int numeroCaja) {
        ultimaCaja[0]=numeroCaja;
        ultimaCaja[1]=x;   //se asigna valor al arreglo de la ultimacaja
        ultimaCaja[2]=y;
    }
    
    public void reset(){
    
    }
    
    public void moverArriba(){
    
    }
    
    public void moverAbajo(){
    
    }
    
    public void moverDerecha(){
    
    }
    
    public void moverIzquierda(){
    
    }
    
    public void setMatrizGrafica(int [][] matriz){
    
    
    
    }

    public JLabel[][] getMatrizGrafica() {
        return matrizGrafica;
    }

    public int getDeshacer() {
        return deshacer;
    }

    public void setDeshacer(int deshacer) {
        this.deshacer = deshacer;
    }
    
    public boolean verificarMovimiento(int pos_x,int pos_y){
    
    
     return true;
    }
    
    public boolean juegoGanado(){
    
    
    return true; 
    }

    public int getNumNivel() {
        return numNivel;
    }

    public void setNumNivel(int num) {
        this.numNivel = num;
    }
    
    public void deshacerJugada(int [] arreglo){
    
    
    }
    
    public void desplegarMatriz(){
    
    
    }
   
    public void salirJuego(){
    
    
    }
    
    public void continuarJuego(){
    
    
    }
    
    public void juegoBloqueado(){
    
    
    }

    public int getReglaMovimientosCajas() {
        return reglaMovimientosCajas;
    }

    public void setReglaMovimientosCajas(int valor) {
        this.reglaMovimientosCajas = valor;
    }

    public int[][] getMatrizLogica() {
        return matrizLogica;
    }

    public void setMatrizLogica(int[][] matriz) {
        this.matrizLogica = matriz;
    }

    public int getSegundaOportunidad() {
        return segundaOportunidad;
    }

    public void setSegundaOportunidad() {
        this.segundaOportunidad--;
    }
    
    public void agregarCaja(int numero,int x,int y){
    
    
    }
    
    public void mover(){
        
    }
    
    public void cambiarBestMoves(int nuevoBM){
        
    }
    
    public void setUltimaPosicionPersonaje(int posX,int posY){
        
    }
    public int[] getUltimaPosicionPersonaje(){
        return ultimoPersonaje;
    }
    
    public void buscarNivel(int level){
        //nivel va a ser una referencia a level...
    }
    
    @Override
    public String toString() {
        return "Juego{" + "contmoves=" + contmoves + ", tiempo=" + tiempo + ", regresar=" + regresar + ", deshacer=" + deshacer + ", numNivel=" + nivel.getNumNivel() + ", cajas=" + cajas.size() + ", ultimaCaja=" + ultimaCaja[0] + ", reglaMovimientosCajas=" + reglaMovimientosCajas + ", segundaOportunidad=" + segundaOportunidad +  '}';
    }
    
    
    
}
