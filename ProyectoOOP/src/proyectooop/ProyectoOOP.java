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
        //String nombre, int cedula, String correo, String contraseña, String fechaRegistro
        Administrador h=new Administrador("alguien",23000000,"nada","sd","10/10/2010");
        
        programa.setReglas(1, 1);   // se fija las reglas
        programa.agregarUsuario(h);
        
        Estadistica e;
        Historial b;
        Jugador primero=new Jugador("alguien1",300900000,"joshua@gmail.com","hola","30 de mayo");
        Jugador primer=new Jugador("alguien2",300080000,"joshua@gmail.com","holas","30 de mayo");
        Jugador prime=new Jugador("alguien3",300050000,"joshua@gmail.com","holasd","30 de mayo");
        Jugador prim=new Jugador("alguien4",300004000,"joshua@gmail.com","holass","30 de mayo");
        Jugador pri=new Jugador("alguien5",300000700,"joshua@gmail.com","holaa","30 de mayo");
        Jugador pr=new Jugador("alguien6",300000060,"joshua@gmail.com","holae","30 de mayo");
        
        
        Nivel nuevo= new Nivel(10,10);
       int [][]matriz={ {0,0,0,0,0,0,0,0,0,0},
                        {0,4,4,0,4,4,4,4,4,0},
                        {0,4,4,0,4,4,4,4,4,0},
                        {0,4,1,4,3,4,4,4,4,0},
                        {0,4,4,4,4,4,4,4,4,0},
                        {0,4,1,4,4,2,4,4,4,0},
                        {0,4,4,4,4,4,4,4,4,0},
                        {0,4,4,4,4,4,4,4,4,0},
                        {0,4,4,4,4,2,4,4,4,0},
                        {0,0,0,0,0,0,0,0,0,0},
                         };
        nuevo.setMatrizLogica(matriz);// se asigna matriz logica
        primero.setNivelActual(1);
        nuevo.setNumNivel(1);
        
        //int numNivel, Nivel nivel, String estado, int cantidadMovimientos, int tiempo, int bestMoves
        b=new Historial(1,nuevo,"perdido",23,34,20);
        b.setVecesJugado();
        b.setVecesJugado();
        primero.setArrayHistorial(b);
        primer.setArrayHistorial(b);
        b=new Historial(1,nuevo,"Perdido",23,34,20);
        b.setVecesJugado();
        prime.setArrayHistorial(b);
        
        b=new Historial(1,nuevo,"Perdido",23,34,20);
        b.setVecesJugado();
        b.setVecesJugado();
        b.setVecesJugado();
        prim.setArrayHistorial(b);
        
        b=new Historial(1,nuevo,"perdido",23,34,20);
        b.setVecesJugado();
        b.setVecesJugado();
        pri.setArrayHistorial(b);
        pr.setArrayHistorial(b);
        
        
      
        programa.agregarUsuario(primero);
        programa.agregarUsuario(primer);
        programa.agregarUsuario(prime);
        programa.agregarUsuario(prim);
        programa.agregarUsuario(pri);
        programa.agregarUsuario(pr);
        e=new Estadistica(1,1,1);
        e.setCantNivelesJugados();
        primero.setEstadistica(e);
        e=new Estadistica(2,4,1);
        e.setCantNivelesJugados();
        primer.setEstadistica(e);
        e=new Estadistica(4,2,1);
        e.setCantNivelesJugados();
        prime.setEstadistica(e);
        e=new Estadistica(3,3,1);
        e.setCantNivelesJugados();
        prim.setEstadistica(e);
        e=new Estadistica(6,6,1);
        e.setCantNivelesJugados();
        pri.setEstadistica(e);
        e=new Estadistica(5,7,1);
        e.setCantNivelesJugados();
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
