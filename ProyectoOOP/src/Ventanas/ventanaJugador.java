/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Jugador;
import java.awt.Color;
import clases.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import static proyectooop.ProyectoOOP.programa;
import proyectooop.ProyectoOOP;
/**
 *
 * @author Josua
 * 
 */
public class ventanaJugador extends javax.swing.JFrame {

    /**
     * Creates new form ventanaJugador
     */
    
    
     public Jugador jugador;
     String ima;
     
    public ventanaJugador() {
        initComponents();
        this.getContentPane().setBackground(new Color(200,250,200));    //color a la ventana
        this.setLocationRelativeTo(null);   //centrar pantalla
        exit.setForeground(Color.blue);
        jugador=(Jugador)ProyectoOOP.usuario;
        bienvenida.setForeground(Color.black);
        jLabel1.setForeground(Color.black);
        jLabel2.setForeground(Color.black);
         this.getContentPane().setBackground(new Color(200,250,200));    //color a la ventana
        exit.setForeground(Color.blue);
        bienvenida.setText("Bienvenido  "+jugador.getNombre());
        String ima=jugador.getFotografia();
        ImageIcon imag = new ImageIcon(ima);
               
        Image photo = imag.getImage();
               
               //cambiar tamaño a la imagen
        Image nueva= photo.getScaledInstance(155, 175, java.awt.Image.SCALE_SMOOTH);
               
        //generando imageicon con la nueva imagen
               
        ImageIcon icono= new ImageIcon(nueva);
         imagen.setIcon(icono);
         imagen.setSize(155, 175);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bienvenida = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        imagen = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        juegoGrupal = new javax.swing.JMenuItem();
        juegoNormal = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        verEstadistica = new javax.swing.JMenuItem();
        verHistorial = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventaja Jugador");
        setResizable(false);

        bienvenida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("En el menu de la parte superior de la ventana ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("encontrará las acciones que puedes realizar");

        exit.setText("Salir");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jMenu1.setText("Juego");

        juegoGrupal.setText("Hacer grupo de juego");
        juegoGrupal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juegoGrupalActionPerformed(evt);
            }
        });
        jMenu1.add(juegoGrupal);

        juegoNormal.setText("Juego individual");
        juegoNormal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juegoNormalActionPerformed(evt);
            }
        });
        jMenu1.add(juegoNormal);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Reportes");

        verEstadistica.setText("Ver mis estadísticas");
        verEstadistica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verEstadisticaActionPerformed(evt);
            }
        });
        jMenu2.add(verEstadistica);

        verHistorial.setText("Ver mi historial");
        verHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verHistorialActionPerformed(evt);
            }
        });
        jMenu2.add(verHistorial);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(368, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bienvenida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ProyectoOOP.ventana.setVisible(true);
    }//GEN-LAST:event_exitActionPerformed

    private void juegoNormalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juegoNormalActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new game().setVisible(true);
        
        
    }//GEN-LAST:event_juegoNormalActionPerformed

    private void verEstadisticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verEstadisticaActionPerformed
       this.dispose();
       new estadisticasPersonales().setVisible(true);
    }//GEN-LAST:event_verEstadisticaActionPerformed

    private void verHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verHistorialActionPerformed
       this.dispose();
       new historialPersonal().setVisible(true);
    }//GEN-LAST:event_verHistorialActionPerformed

    private void juegoGrupalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juegoGrupalActionPerformed
       this.dispose();
       new juegoGrupal().setVisible(true);
    }//GEN-LAST:event_juegoGrupalActionPerformed

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
            java.util.logging.Logger.getLogger(ventanaJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventanaJugador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bienvenida;
    private javax.swing.JButton exit;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem juegoGrupal;
    private javax.swing.JMenuItem juegoNormal;
    private javax.swing.JMenuItem verEstadistica;
    private javax.swing.JMenuItem verHistorial;
    // End of variables declaration//GEN-END:variables
}
