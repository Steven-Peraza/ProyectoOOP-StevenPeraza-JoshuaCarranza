/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Administrador;
import Ventanas.eliminarUsuarios;
import Ventanas.estadistica;
import Ventanas.ganesOpt;
import java.awt.Color;
import clases.*;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import static proyectooop.ProyectoOOP.programa;
import proyectooop.ProyectoOOP;


/**
 *
 * @author Josua
 */
public class ventanaAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form pantallaInicial
     */
    public Administrador admin;
    private static Clip clip3;
    
    public ventanaAdministrador() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        initComponents();
        admin=(Administrador)ProyectoOOP.usuario;
        bienvenida.setForeground(Color.black);
        jLabel1.setForeground(Color.black);
        this.setLocationRelativeTo(null);   //centrar pantalla
        jLabel2.setForeground(Color.black);
        this.getContentPane().setBackground(new Color(200,250,200));    //color a la ventana
        exit.setForeground(Color.blue);
        bienvenida.setText("Bienvenido  "+admin.getNombre());
        String ima=admin.getFotografia();
        ImageIcon imag = new ImageIcon(ima);
               
        Image photo = imag.getImage();
               
               //cambiar tamaño a la imagen
        Image nueva= photo.getScaledInstance(155, 175, java.awt.Image.SCALE_SMOOTH);
               
        //generando imageicon con la nueva imagen
               
        ImageIcon icono= new ImageIcon(nueva);
         imagen.setIcon(icono);
         imagen.setSize(155, 175);
         
         if (clip3 == null)
            Musica("Anville_Town.wav");
         else
             System.out.println("Sigue la mùsica");
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
        exit = new javax.swing.JToggleButton();
        imagen = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        agregarnivel = new javax.swing.JMenu();
        hacernivel = new javax.swing.JMenuItem();
        agregados = new javax.swing.JMenuItem();
        verHistorial = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        optimos = new javax.swing.JMenuItem();
        records = new javax.swing.JMenuItem();
        superado = new javax.swing.JMenuItem();
        insistencia = new javax.swing.JMenuItem();
        estadisticas = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ventana Administrador");
        setPreferredSize(new java.awt.Dimension(460, 331));
        setResizable(false);

        bienvenida.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Stencilia-Bold", 0, 13)); // NOI18N
        jLabel1.setText("En el menu de la parte superior de la ventana ");

        jLabel2.setFont(new java.awt.Font("Stencilia-Bold", 0, 13)); // NOI18N
        jLabel2.setText("encontrará las acciones que puedes realizar");

        exit.setFont(new java.awt.Font("Stencil Std", 0, 11)); // NOI18N
        exit.setText("Salir");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesUsuario/fondomenusJyA.fw.png"))); // NOI18N

        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 461, 290);



        agregarnivel.setText("Niveles");
        agregarnivel.setFont(new java.awt.Font("Stencilia-Bold", 0, 12)); // NOI18N

        hacernivel.setFont(new java.awt.Font("Stencilia-Bold", 0, 12)); // NOI18N
        hacernivel.setText("Hacer un Nivel");
        hacernivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hacernivelActionPerformed(evt);
            }
        });
        agregarnivel.add(hacernivel);

        agregados.setFont(new java.awt.Font("Stencilia-Bold", 0, 12)); // NOI18N
        agregados.setText("Ver informacion de niveles agregados");
        agregados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregadosActionPerformed(evt);
            }
        });
        agregarnivel.add(agregados);

        jMenuBar1.add(agregarnivel);

        verHistorial.setText("Usuarios");
        verHistorial.setFont(new java.awt.Font("Stencilia-Bold", 0, 12)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Stencilia-Bold", 0, 12)); // NOI18N
        jMenuItem1.setText("Eliminar Usuario");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        verHistorial.add(jMenuItem1);

        jMenu1.setText("Ver usuarios con");
        jMenu1.setFont(new java.awt.Font("Stencilia-Bold", 0, 12)); // NOI18N

        optimos.setFont(new java.awt.Font("Stencilia-Bold", 0, 12)); // NOI18N
        optimos.setText("Más ganes  óptimos");
        optimos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optimosActionPerformed(evt);
            }
        });
        jMenu1.add(optimos);

        records.setFont(new java.awt.Font("Stencilia-Bold", 0, 12)); // NOI18N
        records.setText("Más record rotos");
        records.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recordsActionPerformed(evt);
            }
        });
        jMenu1.add(records);

        superado.setFont(new java.awt.Font("Stencilia-Bold", 0, 12)); // NOI18N
        superado.setText("Cierto nivel superado");
        superado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                superadoActionPerformed(evt);
            }
        });
        jMenu1.add(superado);

        insistencia.setFont(new java.awt.Font("Stencilia-Bold", 0, 12)); // NOI18N
        insistencia.setText("Insistencia en un nivel");
        insistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insistenciaActionPerformed(evt);
            }
        });
        jMenu1.add(insistencia);

        verHistorial.add(jMenu1);

        estadisticas.setFont(new java.awt.Font("Stencilia-Bold", 0, 12)); // NOI18N
        estadisticas.setText("Imprimir estadisticas de usuario");
        estadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadisticasActionPerformed(evt);
            }
        });
        verHistorial.add(estadisticas);

        jMenuItem2.setFont(new java.awt.Font("Stencilia-Bold", 0, 12)); // NOI18N
        jMenuItem2.setText("Ver historial de un usuario");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        verHistorial.add(jMenuItem2);

        jMenuBar1.add(verHistorial);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(141, 141, 141)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
         clip3.stop();
         this.dispose();
         ProyectoOOP.ventana.setVisible(true);
    }//GEN-LAST:event_exitActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new eliminarUsuarios().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void estadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadisticasActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new estadistica().setVisible(true);
        
    }//GEN-LAST:event_estadisticasActionPerformed

    private void optimosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optimosActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new ganesOpt().setVisible(true);
        
        
    }//GEN-LAST:event_optimosActionPerformed

    private void recordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recordsActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
        new record().setVisible(true);
        
    }//GEN-LAST:event_recordsActionPerformed

    private void superadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_superadoActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new superado().setVisible(true);
        
    }//GEN-LAST:event_superadoActionPerformed

    private void agregadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregadosActionPerformed

        this.dispose();
        new agregados().setVisible(true);
        
    }//GEN-LAST:event_agregadosActionPerformed

    private void hacernivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hacernivelActionPerformed
        clip3.stop();
        this.dispose();
        new hacerNivel().setVisible(true);
        
    }//GEN-LAST:event_hacernivelActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new historial().setVisible(true);
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void insistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insistenciaActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new insistentes().setVisible(true);
    }//GEN-LAST:event_insistenciaActionPerformed

    public void Musica(String soundFile) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        File f = new File("./" + soundFile);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());  
        clip3 = AudioSystem.getClip();
        clip3.open(audioIn);
        clip3.loop(Clip.LOOP_CONTINUOUSLY);
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
            java.util.logging.Logger.getLogger(ventanaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventanaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventanaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventanaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ventanaAdministrador().setVisible(true);
                } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                    Logger.getLogger(ventanaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem agregados;
    private javax.swing.JMenu agregarnivel;
    private javax.swing.JLabel bienvenida;
    private javax.swing.JMenuItem estadisticas;
    private javax.swing.JToggleButton exit;
    private javax.swing.JMenuItem hacernivel;
    private javax.swing.JLabel imagen;
    private javax.swing.JMenuItem insistencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem optimos;
    private javax.swing.JMenuItem records;
    private javax.swing.JMenuItem superado;
    private javax.swing.JMenu verHistorial;
    // End of variables declaration//GEN-END:variables
}
