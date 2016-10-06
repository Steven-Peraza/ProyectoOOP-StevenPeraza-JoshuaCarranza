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

        Estadistica e;
        
        Jugador primero=new Jugador("alguien1",300900000,"joshua@gmail.com","hola","30 de mayo");
        Jugador primer=new Jugador("alguien2",300080000,"joshua@gmail.com","holas","30 de mayo");
        Jugador prime=new Jugador("alguien3",300050000,"joshua@gmail.com","holasd","30 de mayo");
        Jugador prim=new Jugador("alguien4",300004000,"joshua@gmail.com","holass","30 de mayo");
        Jugador pri=new Jugador("alguien5",300000700,"joshua@gmail.com","holaa","30 de mayo");
        Jugador pr=new Jugador("alguien6",300000060,"joshua@gmail.com","holae","30 de mayo");
        
        
        Nivel nuevo= new Nivel(10,8);
        primero.setNivelActual(1);
        nuevo.setNumNivel(1);
        programa.agregarUsuario(primero);
        programa.agregarUsuario(primer);
        programa.agregarUsuario(prime);
        programa.agregarUsuario(prim);
        programa.agregarUsuario(pri);
        programa.agregarUsuario(pr);
        e=new Estadistica(1,1,1);
        primero.setEstadistica(e);
        e=new Estadistica(2,4,1);
        primer.setEstadistica(e);
        e=new Estadistica(4,2,1);
        prime.setEstadistica(e);
        e=new Estadistica(3,3,1);
        prim.setEstadistica(e);
        e=new Estadistica(6,6,1);
        pri.setEstadistica(e);
        e=new Estadistica(5,7,1);
        pr.setEstadistica(e);
        
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
