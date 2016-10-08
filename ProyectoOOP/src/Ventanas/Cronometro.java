/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Josua
 */
public class Cronometro extends Thread {
    int second=-1;
    int minutos=0;
    int totalSegundos=-1;
    boolean estado=true;
    JLabel mensaje;

    public Cronometro(JLabel mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
    @Override 
    public void run( ){
        
        while (estado){
            
            try {
                Thread.sleep(1000);
                second+=1;
                totalSegundos++;
                if (second==60){
                    minutos++;
                    second=0;
                    mensaje.setText(String.valueOf(minutos)+" Min : "+String.valueOf(second)+" Seg");
                    
                    }
                
                else {
                       // minutos++;
                       // second=-1;       //se reinician segundos
                       mensaje.setText(String.valueOf(minutos)+" Min : "+String.valueOf(second)+" Seg");
                }
                             
                        
            } catch (InterruptedException ex) {
                Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        
        }
    }
    
    
    public void detener(){
    
        estado=false;
    }

    public int getTotalSegundos() {
        return totalSegundos;
    }

    
    
    
}
