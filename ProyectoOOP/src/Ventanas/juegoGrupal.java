/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Grupo;
import Clases.Jugador;
import Clases.Nivel;
import Clases.Usuario;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import proyectooop.ProyectoOOP;
import static proyectooop.ProyectoOOP.programa;


public class juegoGrupal extends javax.swing.JFrame {

    public Jugador jugador;
    public Nivel level;
    private int maximoJug = 1;
    private int maximoNiveles = 0;
    public Grupo group=new Grupo();
    
    ArrayList<Jugador> jugadores = new ArrayList();
    ArrayList<Nivel> nivelesGrupo = new ArrayList();
    
    public juegoGrupal() {
        initComponents();
        this.setLocationRelativeTo(null);
        niv.setForeground(Color.red);
        jug.setForeground(Color.red);
        datos.setForeground(Color.red);
        maxJuga.setForeground(Color.red);
        maxlevels.setForeground(Color.red);
        niv.setVisible(false);
        jug.setVisible(false);
        datos.setVisible(false);
        maxJuga.setVisible(false);
        maxlevels.setVisible(false);
        jugador=(Jugador)ProyectoOOP.usuario;   //se agrega el jugador
        jugadores.add (jugador);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cedu = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nivel = new javax.swing.JTextField();
        Jugar = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        jug = new javax.swing.JLabel();
        niv = new javax.swing.JLabel();
        datos = new javax.swing.JLabel();
        addJugador = new javax.swing.JButton();
        addNivel = new javax.swing.JButton();
        maxJuga = new javax.swing.JLabel();
        maxlevels = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Stencil Std", 0, 11)); // NOI18N
        jLabel1.setText("Creación de Juegos Grupales");

        jLabel2.setFont(new java.awt.Font("Stencilia-Bold", 0, 10)); // NOI18N
        jLabel2.setText("Ingrese el número de cedula del jugador que desea agregar al grupo (máximo 4 jugadores).");

        jLabel3.setFont(new java.awt.Font("Stencil", 0, 11)); // NOI18N
        jLabel3.setText("Cedula:");

        jLabel6.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        jLabel6.setText("Ingrese un nivel que desea jugar (máximo 5 niveles)");

        jLabel7.setFont(new java.awt.Font("Stencil", 0, 11)); // NOI18N
        jLabel7.setText("Número de Nivel:");

        Jugar.setFont(new java.awt.Font("Stencil", 0, 11)); // NOI18N
        Jugar.setText("Jugar!");
        Jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JugarActionPerformed(evt);
            }
        });

        Salir.setFont(new java.awt.Font("Stencil", 0, 11)); // NOI18N
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        jug.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        jug.setText("Este Jugador no existe");

        niv.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        niv.setText("Este Nivel no existe");

        datos.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        datos.setText("Ingrese al menos un nivel y un jugador, por favor");

        addJugador.setFont(new java.awt.Font("Stencil", 0, 11)); // NOI18N
        addJugador.setText("Añadir Jugador");
        addJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addJugadorActionPerformed(evt);
            }
        });

        addNivel.setFont(new java.awt.Font("Stencil", 0, 11)); // NOI18N
        addNivel.setText("Añadir Nivel");
        addNivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNivelActionPerformed(evt);
            }
        });

        maxJuga.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        maxJuga.setText("Ya ingresó el máximo de Jugadores.");

        maxlevels.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        maxlevels.setText("Ya ingresó el máximo de Niveles.");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesUsuario/menucasco.fw.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(cedu, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(maxJuga))
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(addJugador)
                .addGap(18, 18, 18)
                .addComponent(jug))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(maxlevels))
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(addNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(Jugar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(niv, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(datos, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel3))
                    .addComponent(cedu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(maxJuga)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addJugador)
                    .addComponent(jug))
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(maxlevels)))
                .addGap(27, 27, 27)
                .addComponent(addNivel)
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Salir)
                    .addComponent(Jugar)))
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(niv))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(datos))
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.dispose();
        ventanaJugador.clip2.stop();
        try {
            new ventanaJugador().setVisible(true);
        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
            Logger.getLogger(juegoGrupal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_SalirActionPerformed

    private void JugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JugarActionPerformed
        
       if ((maximoJug >= 2)&&(nivelesGrupo != null)){
           //se llama la función de jugar con los datos de los jugadores y niveles agregados por el usuario
           
           
           group.setJugadores(jugadores);   //se agregan los jugadores al objeto grupo
           group.setNiveles(nivelesGrupo);  //se agregan niveles
           group.setGenerador(proyectooop.ProyectoOOP.usuario.getNombre()); //nombre del jugador que generó el grupo
           group.setMenorMovimientos(1000);
           group.setMenorTiempo(100000);
           ProyectoOOP.grp=group;       //variable global grupo
           
           programa.agregaraGrupoLista(group);  //se agrega el grupo recien hecho a la lista de programa
           
           ProyectoOOP.tipo="grupal";
           System.out.print("A Juegar!!!");
           
           this.dispose();
           try {
               new game().setVisible(true);
           } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
               Logger.getLogger(juegoGrupal.class.getName()).log(Level.SEVERE, null, ex);
           }
           
           
           
       }
       else
           datos.setVisible(true);        
    }//GEN-LAST:event_JugarActionPerformed

    private void addJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addJugadorActionPerformed
        if (maximoJug < 4){
        
        if ((cedu.getText().length()==9)&&(esnumero(cedu.getText())==true)){
            Usuario use=programa.buscarUsuario(Integer.parseInt(cedu.getText()));
            if (use != null){
                jugador=(Jugador) use;
                jugadores.add(jugador);
                maximoJug ++;
                cedu.setText("");
                
            }
            else
                jug.setVisible(true);
                cedu.setText("");

            }
        }
        else
            maxJuga.setVisible(true);
            cedu.setText("");
    }//GEN-LAST:event_addJugadorActionPerformed

    private void addNivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNivelActionPerformed
        if (maximoNiveles < 5){
        
        if (esnumero(nivel.getText())==true){
            Nivel use=programa.buscarNivel(Integer.parseInt(nivel.getText()));
            if (use != null){
                level=(Nivel) use;
                nivelesGrupo.add(level);
                maximoNiveles ++;
                nivel.setText("");
            }
            else
                niv.setVisible(true);
                nivel.setText("");
            }
        }
        else
            maxlevels.setVisible(true);
            nivel.setText("");
    }//GEN-LAST:event_addNivelActionPerformed

    public boolean esnumero(String texto){
    
	try {
		Integer.parseInt(texto);
		return true;
	} catch (NumberFormatException mistake){    //si no todos los caracteres son numeros
		return false;
    
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(juegoGrupal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(juegoGrupal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(juegoGrupal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(juegoGrupal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new juegoGrupal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Jugar;
    private javax.swing.JButton Salir;
    private javax.swing.JButton addJugador;
    private javax.swing.JButton addNivel;
    private javax.swing.JTextField cedu;
    private javax.swing.JLabel datos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JLabel jug;
    private javax.swing.JLabel maxJuga;
    private javax.swing.JLabel maxlevels;
    private javax.swing.JLabel niv;
    private javax.swing.JTextField nivel;
    // End of variables declaration//GEN-END:variables
}
