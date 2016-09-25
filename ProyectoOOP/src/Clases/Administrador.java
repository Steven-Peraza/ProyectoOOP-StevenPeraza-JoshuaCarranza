/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.*;

/**
 *
 * @author Josua
 */
public class Administrador extends Usuario {
    
    private String nacionalidad;
    private int nivelesAgregados=0;
    private int bestmovesSuperados=0;

    public Administrador(String nombre, int cedula, String correo, String contraseña, String fechaRegistro) {
        super(nombre, cedula, correo, contraseña, fechaRegistro);   //constructor de la superclase
    }
    
    
    

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String pais) {
        this.nacionalidad = pais;
    }

    public int getNivelesAgregados() {
        return nivelesAgregados;
    }

    public void setNivelesAgregados() {
        this.nivelesAgregados++;
    }

    public int getBestmovesSuperados() {
        return bestmovesSuperados;
    }

    public void setBestmovesSuperados() {
        this.bestmovesSuperados++;
    }

    @Override
    public String toString() {
        
        return super.toString()+
                "Administrador{" + "nacionalidad=" + nacionalidad + ", nivelesAgregados=" + nivelesAgregados + ", bestmovesSuperados=" + bestmovesSuperados + '}';
    }

    
   
    
}
