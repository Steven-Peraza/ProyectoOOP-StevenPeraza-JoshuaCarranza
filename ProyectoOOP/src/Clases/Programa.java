/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Clases.Administrador;
import Clases.Grupo;
import Clases.Historial;
import Clases.Juego;
import Clases.Jugador;
import Clases.Nivel;
import Clases.Reglas;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author Josua
 */
public class Programa {
   
  static public ArrayList<Usuario> users;
 
  private ArrayList<Grupo> listaGrupos;
  private ArrayList<Nivel> niveles;
  private Reglas ruler;

  //inicializacion de arrays
    public Programa() {
        users=new ArrayList();
        niveles=new ArrayList();
        listaGrupos=new ArrayList();
        
    }

    
    // se recibe un objeto tipo usuario para agregar a la lista
  public void agregarUsuario(Usuario nuevo){
      
      
      
      //System.out.println(users.size());
       for (int i=0;i<users.size();i++){
      
          if (users.get(i).getContraseña().equals(nuevo.getContraseña())||(users.get(i).getNombre().equals(nuevo.getNombre()))||(users.get(i).getCedula()==nuevo.getCedula())){    //se compara el numero de cedula
                System.out.println("Ya está el nombre de usuario,la cedula o la contraseña");              //para ver si ya existe
                return;                                 //no se agrega si el numero de cedula ya está.
                
      }
          
       }
       
       users.add(nuevo); //se agrega el usuario jugador
       System.out.println(users.size());
       
  }
    
  //recibe un atributo unico del usario a eliminar y lo elimina
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
  
  // se recibe un objeto nivel para agregar a la lista de niveles
  public void agregarNivel(Nivel nuevo)
  {    
      if (niveles.size()==0){   //si está vacio solo se agrega
          nuevo.setNumNivel(1); //se asigna como el nivel 1;
          niveles.add(nuevo);
          return;
      }
                                            
       for (int i=0;i<niveles.size();i++){  //si el numero de nivel ya se encuentra registrado
      
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
  
  // recibe la identificacion del administrador y se retorna los niveles agregados por este
  public int nivelesPorAdministrador(int identificacion){
      
      for (int i=0;i<users.size();i++){
          
          if (users.get(i) instanceof Administrador){
              Administrador admin=(Administrador) users.get(i);  // sugerencia java
          if (users.get(i).getCedula()==identificacion){    //se compara el numero de cedula
               return admin.getNivelesAgregados(); //se devuelve la cantidad de niveles agregados
              }
                    }
     
      }
      
       return 0;
  }
  
  // retorna un objeto tipo jugador con el que luego puede accederse al historial de este 
  public Jugador historialJugador(int identificacion){
      
      Jugador player = null;   //para guardar el jugador al que hay que acceder
      for (int i=0;i<users.size();i++){
          
            if (users.get(i) instanceof Jugador){

             if(users.get(i).getCedula()==identificacion){
             
                    player=(Jugador) users.get(i); //se encontro el jugador
                    break;
             }
                    
      }
      }
      
      return player;    //se retorna el jugador
        
     
    
  
  }
  
  // retorna un string que contiene el nombre de los 5 usuarios co mas ganes optimos 
  public String usuariosGaOpt(){
      
      if (users.size()==0){
          
          return "";
      }
      
      ArrayList<Jugador> array= new ArrayList();  //arreglo de jugadores para cinco
      int cantidad;
      for (int i=0;i<users.size()-1;i++){
          
          if (users.get(i) instanceof Jugador){
           
          Jugador nuevo=(Jugador) users.get(i);
          cantidad=nuevo.getEstadistica().getCanGanesOptimizados();
          
          
        if (array.size()==0){   //si no hay nada solo se agrega
           array.add((Jugador) users.get(i));
            
            }
         
         else if (array.size()==5){  //si esta lleno   
             for (int x=0;x<array.size();x++){
               
                if (array.get(x).getEstadistica().getCanGanesOptimizados()<cantidad){
                    
                    array.add(x, (Jugador) users.get(i)); //se inserta el jugador
                }
                
             
                 
             }}
         
         else{
              for (int x=0;x<array.size();x++){     //si hay espacio se inserta ordenado igualmente
               
                if (array.get(x).getEstadistica().getCanGanesOptimizados()<cantidad){
                    
                    array.add(x, (Jugador) users.get(i)); //se inserta el jugador
                }
                
             
                 
             }
                    }
             
         }
            }
      String jugadores;
      jugadores=array.get(0).getNombre();   //se concatena el contenido del array en un string para retornarlo
      jugadores+=",";
      jugadores+=array.get(1).getNombre();
      jugadores+=",";
      jugadores+=array.get(2).getNombre();
      jugadores+=",";
      jugadores+=array.get(3).getNombre();
      jugadores+=",";
      jugadores+=array.get(4).getNombre();
      return jugadores;
      
      }
  
  
  // retorna un string que contiene el nombre de 5 usuarios con mas record rotos
  public String usuariosReRot(){
      
      if (users.size()==0){
      
          return "";        // si esta vacio
        }
      
      ArrayList<Jugador> array= new ArrayList();  //arreglo de jugadores para cinco
      int cantidad;
      for (int i=0;i<users.size()-1;i++){
                    
          if (users.get(i) instanceof Jugador){
          Jugador nuevo=(Jugador) users.get(i);
          cantidad = nuevo.getEstadistica().getRecordRotos();
         
          
        if (array.size()==0){   //si no hay nada solo se agrega
           array.add((Jugador) users.get(i));
            
            }
         
         else if (array.size()==5){  //si esta lleno   
             for (int x=0;x<array.size();x++){
               
                if (array.get(x).getEstadistica().getRecordRotos()<cantidad){
                    
                    array.add(x, (Jugador) users.get(i)); //se inserta el jugador
                }
                
             
                 
             }}
         
         else{
              for (int x=0;x<array.size();x++){     //si hay espacio se inserta ordenado igualmente
               
                if (array.get(x).getEstadistica().getRecordRotos()<cantidad){
                    
                    array.add(x, (Jugador) users.get(i)); //se inserta el jugador
                }
                
             
                 
             }
                    }
             
         }
      }
      
      String jugadores;
      jugadores=array.get(0).getNombre();   //se concatena el contenido del array en un string para retornarlo
      jugadores+=",";
      jugadores+=array.get(1).getNombre();
      jugadores+=",";
      jugadores+=array.get(2).getNombre();
      jugadores+=",";
      jugadores+=array.get(3).getNombre();
      jugadores+=",";
      jugadores+=array.get(4).getNombre();
      return jugadores;
    
      }
  
  //se recibe el numero de nivel y se busca los cinco usuarios que mas lo han jugado
  public String usuariosInsistentesEnNivel(int numero){
      boolean esta=false;
      for (int i=0;i<niveles.size();i++){
      
           if (numero==niveles.get(i).getNumNivel()){
           
               esta=true;
               break;
           }
      }
      
      if(esta==false){  // si no se encuentra el numero de nivel
          return "";
      }
      

      return " ";
  }
  
  // se recibe el numero de nivel y se busca los usuarios que ganaron ese nivel
  public String usuariosGanaron(int numero){
      
      if ((users.size()==0)||(niveles.size()==0)){  //si alguna de las dos listas esta vacia
      
            return "";
        }
      int nivel=0;
      String nombres =""; //almacena los nombres de los que pasaron el nivel
      
      for (int i=0;i<niveles.size();i++){   //para comprobar que el numero de nivel ingresado está
      
            if (niveles.get(i).getNumNivel()==numero){
                nivel=numero;
            }
      }
      
      if (nivel==0){        //si el numero de nivel no existe
          return "";
      }
      
      else{
          for (int z=0;z<users.size();z++){
              Jugador player = (Jugador) users.get(z);
              ArrayList temporal= player.getArrayHistorial(); // se accede temporalmente al array historial
              for (int x=0;x<temporal.size();x++ ){                 //del jugador
                  
                  Historial temp=(Historial) temporal.get(x);   //correccion java
                  if (temp.getNumNivel()==nivel);{       //si ya jugo el nivel
                  if (("Ganado"==temp.getEstado())||("Optimizado"==temp.getEstado())){ //si lo paso
                    nombres+=users.get(z).getNombre();     //se concatena el nombre al String 
                    nombres+=",";                          //se establece este separador
                  }
                      }
                  
              }
              } 
          }
      
      return nombres;
      
      }
  
  // se recibe la identificacion de un jugador y sse retorna el objeto tipo jugador
  public Jugador imprmirEstadisticaJugador (int identificacion){
      
      
      Jugador player=null;
      
      if (users.size()==0){
      
          return player; //en este caso retornaria null
      }
      
      return player;
  }
 
  

  // devuelve un objeto tipo usuario, recibe una identificacion unica del usuario
  public Usuario buscarUsuario(int identificacion){
  
      Usuario usuario=null;
        if (users.size()==0){
        
            return usuario; //retornaria null
        
        }
        
      return usuario;
  } 
 
  //devuelve true si la persona esta registrada
  public boolean login(String nom,String password){
      
      if (users.size()==0){
      
            return false;      // estaria vacio si entra aqui
      }
      
      for (int i=0;i<users.size();i++){     //se busca en la lista de jugadores
             
          if ((users.get(i).getNombre().equals(nom))&&(users.get(i).getContraseña().equals(password))){
              System.out.println("entre");
              return true;
          }
      }
      
      return false;     //si no estaba en los anteriores se retorna false
  }
  
  // recibe el numero del nivel que se va a cambiar
  public void cambiarOrdenNivel(int numero){
      
  
  }
  
  // se cambia el gane de usuarios de optimizado a ganado simplemente
  public void cambiarNivelesOptimizados(int numeroNivel){
  
  
  }
  
  // funcion que inicia el juego
  public void jugarNivel(int numeroNivel){
  
  
  }
  
// recibe las listas que contiene el grupo y los niveles a jugar  
  public void jugarGrupo(ArrayList<Nivel> niveles,ArrayList<Jugador> jugadores){
  
  
  }
  
  // recibe el numero de cajas a mover, y un valor numerico que indica si el controlz es permitido
  public void setReglas(int numeroCajas,int controlZ){
  
  
  }
  
  // modifica las reglas establecidas
  public void cambiarReglas(int numeroCajas,int controlZ){
      
     ruler.setCajasPorMover(numeroCajas);
     ruler.setControlZ(controlZ);
 
  }
  
  // retorna el valor de los dos atributos del objeto ruler, en un string con un separador
  public String getReglas(){
      
      String texto="";
      texto+= String.valueOf(ruler.getCajasPorMover());
      texto+=",";
      texto+= String.valueOf(ruler.getControlZ());
      return texto;
  }
  
  // calcula la diferencia entre los movimientos hechos por el usuario
  // y los que eran necesarios para ganar;
  // recibe un numero de nivel, el historial de un jugador con el que se accede a informacion
  // general del nivel y retorna la resta de estos dos datos
  public int calcularDiferenciaEnMovimientos(int numNivel,Historial historial){
  
  
      return 0;
  }
  
  // es para modificar el historial del jugador cuando este ha repetido algún nivel
  public void actualizarHistorial(int numeroNivel,int movimientos){
  
 
      
  }
  
  // se recibe el numero de cedula del jugador y se retorna los 3 niveles que puede repetir
  public String repetirNiveles(int cedula){
  
  return "";
  
  }
  
  // si el usuario gana un nivel, se continua con el siguiente;
  public int pasarDeNivel(int nivelJugado){
  
  
  return 0;
  }
  
  //recibe toda la informacion del juego recien jugado para colocarlo en el historial del jugador
  public void generarHistorial(Juego game){
  
  
  }
  
  // recibe por parametro el jugador para generar la estadistica
  public int cantidadNivelesJugados(Jugador usuario){
        
      int cant=0;
      
      for (int i=0;i<usuario.getArrayHistorial().size();i++){
      
            cant ++;
      }
      
  
   return cant;
  }
  
  // se retorna los records rotos por el usuario
  public int cantidadRecordRotos(Jugador usuario){
  
  
      return 0;
  }
  
  // se retorna el nivel que ha jugado mas veces el ususario
  public int obtenerNivelMasRepetido(Jugador usuario){
  
  
  return 0;
  
  }
  
  // se retorna la cantidad de ganes optimizados del jugador
  public int jugadorCantidadGanesOpt(Jugador Usuario){
  
  
  return 0;
  }
  
  //recibe la informacion de todo un grupo, se coloca en la lista de grupos general del programa
  public void agregaraGrupoLista(Grupo group){
  
  
  }
  
  // se retorna la lista de grupos general que tiene el programa
  public ArrayList obtenerListaGrupo(){
  
  return listaGrupos;
  }
  

    @Override
    public String toString() {
        return "Programa{" + "users=" + users.size() +  ", listaGrupos=" + listaGrupos.size() + ", niveles=" + niveles.size() + ", ruler=" + ruler.toString() + '}';
    }

   
  
  
}
