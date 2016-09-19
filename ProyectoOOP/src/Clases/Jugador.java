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
    private int nivelActual;
    private int masRepetido;
    private Estadistica estadistica=new Estadistica();
    private ArrayList<Historial> arrayHistorial=new ArrayList(); //historial por nivel

    public Jugador(String nombre, int cedula, String correo, String contraseña, String fechaRegistro) {
        super(nombre, cedula, correo, contraseña, fechaRegistro);   //se llama al constructor de la superclase
    }
    
    
    
    public int getBestMoves() {
        return bestMoves;
    }

    public void setBestMoves(int bestMoves) {
        this.bestMoves = bestMoves;
    }

    public int getNivelActual() {
        return nivelActual;
    }

    public void setNivelActual(int nivelActual) {
        this.nivelActual = nivelActual;
    }

    public int getMasRepetido() {
        return masRepetido;
    }

    public void setMasRepetido(int masRepetido) {
        this.masRepetido = masRepetido;
    }

    public ArrayList getArrayHistorial() {
        return arrayHistorial;
    }

    public void setArrayHistorial(Historial var) {
        this.arrayHistorial.add(var);
    }

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
