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
public class Jugador extends Usuario{
    
    private int bestMoves;
    private int nivelActual=1;
    private int masRepetido;
    private Estadistica estadistica=new Estadistica(0,0,0);
    private ArrayList<Historial> arrayHistorial=new ArrayList(); //historial por nivel

    public Jugador(String nombre, int cedula, String correo, String contraseña, String fechaRegistro) {
        super(nombre, cedula, correo, contraseña, fechaRegistro);   //se llama al constructor de la superclase
    }
    
    
    
    public int getBestMoves() {
        return bestMoves;
    }
    
    // se asigna la cantidad de record rotos
    public void setBestMoves(int bestMoves) {
        this.bestMoves = bestMoves;
    }
    
    //se tiene el nivel actual en que se encuentra el usuario
    public int getNivelActual() {
        return nivelActual;
    }
    
    //metodo para fijar el nivel actual del jugador
    public void setNivelActual(int nivelActual) {
        this.nivelActual = nivelActual;
    }

    public int getMasRepetido() {
        return masRepetido;
    }

    // se asigna el nivel que mas ha jugado el usuario
    public void setMasRepetido(int masRepetido) {
        this.masRepetido = masRepetido;
    }
    
    // se retorna la lista de historiales por nivel que tiene el jugador
    public ArrayList getArrayHistorial() {
        return arrayHistorial;
    }
    
    // se va agregar un nivel al historial
    public void setArrayHistorial(Historial var) {
        for (int i=0;i<arrayHistorial.size();i++){
                if (arrayHistorial.get(i).getNumNivel()==var.getNumNivel()){
                
                if (arrayHistorial.get(i).getEstado().equals("Perdido")){
                    int cont=0;
                    while(cont <arrayHistorial.get(i).getVecesJugado()){
                        var.setVecesJugado();
                        cont++;
                    }
                    arrayHistorial.set(i, var);// se remplaza el historial
                    return;
                        }
                }
            }
        
        this.arrayHistorial.add(var);
    }
    
   // se retorna la estadistica general del jugador
    public Estadistica getEstadistica() {
        return estadistica;
    }

    public void setEstadistica(Estadistica estadistica) {
        this.estadistica = estadistica;
    }

    
    
    
    @Override
    public String toString() {
        return super.toString()+
                "Jugador{" + "bestMoves=" + bestMoves + ", nivelActual=" + nivelActual + ", masRepetido=" + masRepetido + '}';
    }

    
    
}
