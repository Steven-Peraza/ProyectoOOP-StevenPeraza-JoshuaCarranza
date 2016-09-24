/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Josua
 */
public class Grupo {
    
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
    
    
    
    public void setGenerador(String nombre){
        this.generador=nombre;
    }
    
    public String getGenerador(){
    
        return generador;
    
    }
    
    // se agrega un nivel a la lista de nivels
    public void addNivel(int numero){
    
        if (niveles.size()==5){ //si el arreglo ya contiene su maximo valor posible no se agrega
            System.out.println("array lleno");
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
    
    public void addJugadores(int numero){
        
        if (jugadores.size()==4){ //si el arreglo ya contiene su maximo valor posible no se agrega
            System.out.println("array lleno");
    
    }
    }
    
    public void setContMove(){
        contMove ++;
        
    }
    
    public int getContMove(){
    
        return contMove++;
    }
    
    public void setTiempo(int segundos){
    
        tiempo=segundos;
    }
    
    public int getTiempo(){
    
        return tiempo;
    }
    
    public void setMenorTiempo(int tiempo){
    
        menorTiempo=tiempo;
    }
    
    public int getMenorTiempo(){
    
      return menorTiempo;
    }
    
    public void setMenorMovimientos(int moves){
    
        menorMovimientos=moves;
    }
    
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

    
    public String getMejorEnTiempo() {
        return mejorEnTiempo;
    }

    public void setMejorEnTiempo(String mejorEnTiempo) {
        this.mejorEnTiempo = mejorEnTiempo;
    }

    public String getMejorEnMovimientos() {
        return mejorEnMovimientos;
    }

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

    @Override
    public String toString() {
        return "Grupo{" + "generador=" + generador + "Jugadores: "+getJugadores()+ "Niveles: "+getNiveles()+ ", contMove=" + contMove + ", tiempo=" + tiempo + ", menorTiempo=" + menorTiempo + ", menorMovimientos=" + menorMovimientos + ", mejorEnTiempo=" + mejorEnTiempo + ", mejorEnMovimientos=" + mejorEnMovimientos + '}';
    }
    
    
    
}

