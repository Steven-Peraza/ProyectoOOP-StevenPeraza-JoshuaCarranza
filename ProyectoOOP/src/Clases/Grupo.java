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
    
    private ArrayList<Jugador> jugadores=new ArrayList();
    private ArrayList<Nivel> niveles= new ArrayList();
    private Usuario generador;
    private int contMove;
    private int tiempo;
    public int menorTiempo;
    public int menorMovimientos;
    public String mejorJugador;
    
    public void setGenerador(String nombre,int numero){
    
    }
    
    public void addNivel(int numero){
    
    }
    
    public int getNivel(){
    
        return 0;
    }
    
    public void addJugadores(int numero){
    
    }
    
    public void setContMove(){
    
        contMove ++;
    }
    
    public int getContMove(){
    
    return 0;
    }
    
    public void setTiempo(int segundos){
    
    }
    
    public int getTiempo(){
    
        return 0;
    }
    
    public void setMejorJugador(String nombre){
    mejorJugador=nombre;
    
    } 
    
    public String getMejorJugador(){
    
    return mejorJugador;
    
    }
    
    public void setMenorTiempo(int tiempo){
    
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
    
    public String getJugadores(){
    
    return "we";
    }
    
}

