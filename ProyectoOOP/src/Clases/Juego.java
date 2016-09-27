/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
//se incluyen librerias para el correcto funcionamiento del programa
import javax.swing.JLabel;
import java.util.ArrayList;


/**
 *
 * @author Josua
 */
public class Juego {
    
    //se declaran las variables que se utilizaran en esta clase.
    private int contmoves=0;
    private int tiempo;
    private int regresar=0;   
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
   
   //se crea el constructor
    public Juego() {
        person = new Personaje(0,0); 
        ultimaCaja=new int [3];     //un arreglo de 3 , para guardar el numero de caja, y la posicion
    }

    // se obtiene un contador de movimientos
    public int getContmoves() {
        return contmoves;
    }
    //se aumenta el contador de movimientos por uno
    public void setContmoves() {
        this.contmoves++;
    }
    //se establece la posición del personaje en la matriz.
    public void setPosicionPersonaje(int x,int y){
    
    person.setPosicionColumna(x);       //se asigna al objeto persona la posicion
    person.setPosicionFila(y);
    
    }
    //se obtiene el tiempo de juego
    public int getTiempo() {
        return tiempo;
    }
    //se establece el tiempo de juego
    public void setTiempo(int segundos) {
        this.tiempo = tiempo;
    }
    //se utiliza para el control z. retorna la cantidad de regresar movimientos que se han realizado
    public int getRegresar() {
        return regresar;
    }

    public void setRegresar() { //se aumenta porque se uso el control z
        this.regresar ++;
    }
    //se retorna la ultima posicion de la caja que ha sido movida
    public int[] getUltimaCaja() {
        return ultimaCaja;
    }
    //se guarda la ultima posicion de la caja que ha sido movida
    public void setUltimaCaja(int x,int y,int numeroCaja) {
        ultimaCaja[0]=numeroCaja;
        ultimaCaja[1]=x;   //se asigna valor al arreglo de la ultimacaja
        ultimaCaja[2]=y;
    }
    //función que resetea el nivel
    public void reset(){
    
    }
    //funcion que mueve cajas o el personaje hacia arriba en la matriz logica
    public void moverArriba(){
    
    }
    //funcion que mueve cajas o el personaje hacia abajo en la matriz logica
    public void moverAbajo(){
    
    }
    //funcion que mueve cajas o el personaje hacia derecha en la matriz logica
    public void moverDerecha(){
    
    }
    //funcion que mueve cajas o el personaje hacia izquierda en la matriz logica
    public void moverIzquierda(){
    
    }
    //se crea la natriz gráfica de acuerdo a la matriz logica
    public void setMatrizGrafica(int [][] matriz){
    
    
    
    }
    //se retorna la natriz gráfica de acuerdo a la matriz logica
    public JLabel[][] getMatrizGrafica() {
        return matrizGrafica;
    }

    public int getDeshacer() {
        return deshacer;
    }
    //funcion que permite saber cual regla se esta jugando (1 o 2 cajas)
    public void setDeshacer(int deshacer) {
        this.deshacer = deshacer;
    }
    //funcion que verifica si el movimiento de una caja o persomaje es válido o no
    public boolean verificarMovimiento(int pos_x,int pos_y){
    
    
     return true;
    }
    //función que retorna true si el nivel ha sido completado para poder pasar al siguiente nivel
    public boolean juegoGanado(){
    
    
    return true; 
    }
    //se obtiene el numero del nivel en ejecucion
    public int getNumNivel() {
        return numNivel;
    }
    //se establece el numero de nivel que se desea jugar
    public void setNumNivel(int num) {
        this.numNivel = num;
    }
    
    //funcion que devuelve la jugada realizada
    public void deshacerJugada(int [] arreglo){
    
    
    }
    //funcion para crear los labels
    public void desplegarMatriz(){
    
    
    }
   //función que termina el juego y sale del programa.
    public void salirJuego(){
    
    
    }
    //función que continúa el juego dejado a medias por el usuario.
    public void continuarJuego(){
    
    
    }
    //funcion que revisa si el jugador se quedo sin movimientos y da la opcion de reiniciar el nivel
    public void juegoBloqueado(){
    
    
    }
    //funcion que retorna la regla de juego (poder mover 1 o 2 cajas)
    public int getReglaMovimientosCajas() {
        return reglaMovimientosCajas;
    }
    //funcion que establece la regla de juego (poder mover 1 o 2 cajas)
    public void setReglaMovimientosCajas(int valor) {
        this.reglaMovimientosCajas = valor;
    }
    //funcion que retorna la matriz logica
    public int[][] getMatrizLogica() {
        return matrizLogica;
    }
    //funcion que establece la matriz logica
    public void setMatrizLogica(int[][] matriz) {
        this.matrizLogica = matriz;
    }
    //funcion que retorna la cantidad de veces que un usuario puede repetir los niveles mas bajos en moves
    public int getSegundaOportunidad() {
        return segundaOportunidad;
    }
    //funcion que establece la cantidad de veces que un usuario puede repetir los niveles mas bajos en moves
    public void setSegundaOportunidad() {
        this.segundaOportunidad--;
    }
    //función que agrega una o mas cajas a la matriz logica
    public void agregarCaja(int numero,int x,int y){
    
    
    }
    //función que compara la tecla oprimida por el usuario y llama a la fucnion correspondiente
    public void mover(){
        
    }
    //función que sobreescribe un nuevo record de movimientos.
    public void cambiarBestMoves(int nuevoBM){
        
    }
    //funcion que establece la ultima posicion del personaje en la matriz logica
    public void setUltimaPosicionPersonaje(int posX,int posY){
        
    }
    //funcion que retorna esa ultima posicion
    public int[] getUltimaPosicionPersonaje(){
        return ultimoPersonaje;
    }
    
    //funcion que busca entre los niveles creados, el nivel por jugar
    public void buscarNivel(int level){
        //nivel va a ser una referencia a level...
    }
    
    //toString
    @Override
    public String toString() {
        return "Juego{" + "contmoves=" + contmoves + ", tiempo=" + tiempo + ", regresar=" + regresar + ", deshacer=" + deshacer + ", numNivel=" + nivel.getNumNivel() + ", cajas=" + cajas.size() + ", ultimaCaja=" + ultimaCaja[0] + ", reglaMovimientosCajas=" + reglaMovimientosCajas + ", segundaOportunidad=" + segundaOportunidad +  '}';
    }
    
    
    
}
