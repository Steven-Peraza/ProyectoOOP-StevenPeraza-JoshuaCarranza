/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectooop;


/**
 *
 * @author Steven
 */
import Ventanas.inicioSesion;
import Clases.Programa;
import Clases.Administrador;
import Clases.Cajas;
import Clases.Estadistica;
import Clases.Grupo;
import Clases.Historial;
import Clases.Juego;
import Clases.Jugador;
import Clases.Nivel;
import Clases.Personaje;
import Clases.Reglas;
import Clases.Usuario;
import javax.swing.Timer;
//import Ventanas.*;

public class ProyectoOOP {
   
   
    /**
     * @param args the command line arguments
     */
    
    public static Timer timer;
    public static inicioSesion ventana=new inicioSesion();
    public static Programa programa=new Programa();
    public static Usuario usuario;
    public static void main(String[] args) {
        // TODO code application logic here

        
        Jugador primero=new Jugador("alguien",30,"joshua@gmail.com","hola","30 de mayo");
        //Jugador primero=new Jugador("alguien",30,"joshua@gmail.com","hola","30 de mayo");
        //primero.getEstadistica().setCanGanesOptimizados();
        Nivel nuevo= new Nivel(10,8);
        primero.setNivelActual(1);
       nuevo.setNumNivel(1);
        programa.agregarUsuario(primero);
        System.out.println(String.valueOf(programa.login("alguien","hola")));
        programa.agregarNivel(nuevo);
       // Nivel primer=new Nivel();
       // primer.setNumNivel(3);
       // nuevo.usuariosGaOpt();
       // primer.setCedulaAdministrador(333);
        
       // nuevo.agregarNivel(primer);
        
       // prime=new Jugador("alguien",30,"joshua@gmail.com","32","30 de mayo");
      // nuevo.eliminarJugador(2334);
      // nuevo.agregarJugador(prime);
      // Nivel segundo=new Nivel();
      // segundo.setNumNivel(1);
       //segundo.setCedulaAdministrador(444);
       //nuevo.agregarNivel(segundo);
       ventana.setVisible(true);
    }
    
}
