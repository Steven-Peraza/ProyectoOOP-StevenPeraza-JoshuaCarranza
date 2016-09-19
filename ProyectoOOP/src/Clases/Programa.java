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
public class Programa {
   
  private ArrayList<Jugador> users;
    private ArrayList<Administrador> administradores; 

  private ArrayList<Nivel> niveles;

    public Programa() {
        users=new ArrayList();
        niveles=new ArrayList();
        administradores=new ArrayList();
        
    }
  
  
  
  public void agregarUsuario(Jugador nuevo){
      
      
      
      //System.out.println(users.size());
       for (int i=0;i<users.size();i++){
      
          if (users.get(i).getCedula()==nuevo.getCedula()){    //se compara el numero de cedula
                System.out.println("Ya está registrado numero de cedula");              //para ver si ya existe
                return;                                 //no se agrega si el numero de cedula ya está.
                
      }
          
       }
       
       users.add(nuevo); //se agrega el usuario jugador
       System.out.println(users.size());
       
  }
    
  public void eliminarUsuario(int identificacion){
  
      for (int i=0;i<users.size();i++){
      
          if (users.get(i).getCedula()==identificacion){    //se compara el numero de cedula
               users.remove(i);
               System.out.println("Se eliminó");    //se remueve el usuario
               return;
          }       
  }     
        System.out.println("No se encuentra el usuario");    

        System.out.println(users.size());

  }
  public void agregarNivel(Nivel nuevo)
  {    
      if (niveles.size()==0){   //si está vacio solo se agrega
          nuevo.setNumNivel(1); //se asigna como el nivel 1;
          niveles.add(nuevo);
          return;
      }
       for (int i=0;i<niveles.size();i++){
      
          if (niveles.get(i).getNumNivel()==nuevo.getNumNivel()){    //se compara el numero de nivel
               niveles.add(i,nuevo);        //se inserta en esa posicion
               System.out.println("Se inserto");    //se remueve el usuario
                for (int x=0;x<niveles.size();x++){
                niveles.get(i).setNumNivel(x+1); //se reasigna numero de niveles para ordenar
                    }
                return;
             
          }
       }
       
      niveles.add(nuevo); //se agrega el nivel si el numero no era igual a ningún otro      
      for (int i=0;i<niveles.size();i++){
          niveles.get(i).setNumNivel(i+1); //se reasigna numero de niveles para ordenar
      }
      
  }
  
  public int nivelesPorAdministrador(int identificacion){
      
      for (int i=0;i<administradores.size();i++){
      
          if (administradores.get(i).getCedula()==identificacion){    //se compara el numero de cedula
               return administradores.get(i).getNivelesAgregados(); //se devuelve la cantidad de niveles agregados
              }
      }
      return 0;
      
  }
  public void historialUsuario(int identificacion){
      
      Jugador player;   //para guardar el jugador al que hay que acceder
      for (int i=0;i<users.size();i++){
             if(users.get(i).getCedula()==identificacion){
             
                    player=users.get(i); //se encontro el jugador
                    
                    break;
             }
                    
      }
        
     
    
  
  }
  
  public void usuariosGaOpt(){
      
      
  
  }
  
  public void usuariosReRot(){
  
      
  }
  
  public void usuariosInLevel(int numero){
  
  }
  
  public void usuariosGanaron(int numero){
  
  }
  
  public void infoUsuario(int identificacion){
  
  }
  
  public void agregarAdministrador(Administrador nuevo){
  
  }
  
  public void eliminarAdministrador (int identificacion){
  
  }
  
  public void buscarUsuario(Usuario elemento){
  
  } 
  
  public void buscarAdministrador(Administrador elemento){
  
  }
  
}
