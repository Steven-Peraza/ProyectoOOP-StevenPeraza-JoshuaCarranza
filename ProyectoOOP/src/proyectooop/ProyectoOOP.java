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
import Clases.Administrador;
import Clases.Cajas;
import Clases.Estadistica;
import Clases.Grupo;
import Clases.Historial;
import Clases.Juego;
import Clases.Jugador;
import Clases.Nivel;
import Clases.Personaje;
import Clases.Programa;
import Clases.Reglas;
import Clases.Usuario;
public class ProyectoOOP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Programa nuevo=new Programa();
        Jugador primero=new Jugador("josua",30,"joshua@gmail.com","23","30 de mayo");
        nuevo.agregarUsuario(primero);
        Nivel primer=new Nivel();
        primer.setNumNivel(3);
        primer.setCedulaAdministrador(333);
        
        nuevo.agregarNivel(primer);
        
        Jugador prime=new Jugador("josua",30,"joshua@gmail.com","32","30 de mayo");
       nuevo.eliminarUsuario(2334);
       nuevo.agregarUsuario(prime);
       Nivel segundo=new Nivel();
       segundo.setNumNivel(1);
       segundo.setCedulaAdministrador(444);
       nuevo.agregarNivel(segundo);
       
       

        
    }
    
}
