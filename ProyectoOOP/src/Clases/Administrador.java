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
    //SE decalran variables necesarias
    private String nacionalidad;
    private int nivelesAgregados=0;
    private int bestmovesSuperados=0;
    
    
    public Administrador(String nombre, int cedula, String correo, String contraseña, String fechaRegistro) {
        super(nombre, cedula, correo, contraseña, fechaRegistro);   //constructor de la superclase
    }
    
    
    
    //funcion que retorna la nacionalidad del admin
    public String getNacionalidad() {
        return nacionalidad;
    }
    //funcion que establece la nacionalidad del admin
    public void setNacionalidad(String pais) {
        this.nacionalidad = pais;
    }
    //funcion que retorna los niveles agregados por el admin
    public int getNivelesAgregados() {
        return nivelesAgregados;
    }
    //funcion que establece la cantidad de niveles creados por un admin
    public void setNivelesAgregados() {
        this.nivelesAgregados++;
    }
    //funcion que retorna la cantidad de BM superados por usuarios en los niveles crados por el admin
    public int getBestmovesSuperados() {
        return bestmovesSuperados;
    }
    //funcion que establece la cantidad de BM superados por usuarios en los niveles crados por el admin
    public void setBestmovesSuperados() {
        this.bestmovesSuperados++;
    }

    @Override
    public String toString() {
        
        return super.toString()+
                "Administrador{" + "nacionalidad=" + nacionalidad + ", nivelesAgregados=" + nivelesAgregados + ", bestmovesSuperados=" + bestmovesSuperados + '}';
    }

    
   
    
}
