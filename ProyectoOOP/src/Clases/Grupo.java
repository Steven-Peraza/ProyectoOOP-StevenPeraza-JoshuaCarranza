/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
//se importan herramientas de netbeans
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Josua
 */
public class Grupo {
    //se declaran las variables de la clase
    private ArrayList<Jugador> jugadores;
    private ArrayList<Nivel> niveles;
    private String generador;
    private int contMove;
    private int tiempo;
    public int menorTiempo;
    public int menorMovimientos;
    public String mejorEnTiempo;
    public String mejorEnMovimientos;

    // se inicializan los array
    public Grupo() {
        
        jugadores=new ArrayList();
        niveles=new ArrayList();
        
        
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public void setNiveles(ArrayList<Nivel> niveles) {
        this.niveles = niveles;
    }
    
    
    
    
    //funcion que establece el nombre del usuario que creo el grupo
    public void setGenerador(String nombre){
        this.generador=nombre;
    }
    //funcion que retorna el nombre del usuario que creo el grupo
    public String getGenerador(){
    
        return generador;
    
    }
    
    // se agrega un nivel a la lista de nivels
    public void addNivel(int numero){
    
        if (niveles.size()==5){ //si el arreglo ya contiene su maximo valor posible no se agrega
            System.out.println("array lleno");
        }
        
        else{
            
        }
    }
    
    //devuelve en un string los niveles que se eligió jugar, con un separador
    public String getNiveles(){
        
        String levels="";
        
        for (int i=0;i<niveles.size();i++){
        
            levels+=niveles.get(i).getNumNivel();
            levels+=",";
            
        }
        
        return levels;
    }
    //funcion que agrega jugadores mientras no haya una cantidad mayor a 4
    public void addJugadores(int numero){
        
        if (jugadores.size()==4){ //si el arreglo ya contiene su maximo valor posible no se agrega
            System.out.println("array lleno");
    
    }
        
        else{
        
            
        }
    }
     //funcion que establece los movimientos que un usuario ha realizado en un nivel
    public void setContMove(int cont){
        contMove=cont;
        
    }
    //funcion que retorna los movimientos que un usuario ha realizado en un nivel
    public int getContMove(){
    
        return contMove;
    }
    //funcion que establece el tiempo de juego
    public void setTiempo(int segundos){
    
        tiempo=segundos;
    }
    //funcion que retorna el tiempo de juego
    public int getTiempo(){
    
        return tiempo;
    }
    //funcion que establece el menor tiempo en realizar un nivel    
    public void setMenorTiempo(int tiempo){
    
        menorTiempo=tiempo;
    }
    //funcion que retorna el menor tiempo en realizar un nivel 
    public int getMenorTiempo(){
    
      return menorTiempo;
    }
    //funcion que establece la menor cantidad de moves en realizar un nivel 
    public void setMenorMovimientos(int moves){
    
        menorMovimientos=moves;
    }
    //funcion que retorna la menor cantidad de moves en realizar un nivel
    public int getMenorMovimientos(){
    
        return menorMovimientos;
    }
    
    //retorna un string con los nombres de los jugadores
    public String getJugadores(){
    
    String players="";
    
    for (int i=0;i<jugadores.size();i++){
    
        players+= jugadores.get(i).getNombre();
        players+=",";        
     }
        
    return players;
    }

    //funcion que retorna el jugador con el mejor tiempo
    public String getMejorEnTiempo() {
        return mejorEnTiempo;
    }
    //funcion que establece el juegador con el mejor tiempo
    public void setMejorEnTiempo(String mejorEnTiempo) {
        this.mejorEnTiempo = mejorEnTiempo;
    }
    //funcion que retorna el jugador con menos moves
    public String getMejorEnMovimientos() {
        return mejorEnMovimientos;
    }
    //funcion que establece el jugador con menos moves
    public void setMejorEnMovimientos(String mejorEnMovimientos) {
        this.mejorEnMovimientos = mejorEnMovimientos;
    }
    
    //se va a eliminar del grupo al jugador que decida abandonar
    public void abandonarGrupo(int cedula){
        
        for (int i=0;i<jugadores.size();i++){
        
            if (jugadores.get(i).getCedula()==cedula){
                jugadores.remove(i);        //se elimina el elemento
                break;
            }
            
        }
           
    }
    
    
    
    
    
    // funcion que verifica la cantidad de usuarios en el grupo (de 2 a 4)
    public boolean hacerGrupo(){
        return true;
    }
    
    @Override
    public String toString() {
        return "Grupo{" + "generador=" + generador + "Jugadores: "+getJugadores()+ "Niveles: "+getNiveles()+ ", contMove=" + contMove + ", tiempo=" + tiempo + ", menorTiempo=" + menorTiempo + ", menorMovimientos=" + menorMovimientos + ", mejorEnTiempo=" + mejorEnTiempo + ", mejorEnMovimientos=" + mejorEnMovimientos + '}';
    }
    
    
    
}

