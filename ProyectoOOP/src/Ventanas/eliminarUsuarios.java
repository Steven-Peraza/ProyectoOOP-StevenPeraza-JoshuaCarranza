/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import proyectooop.*;
import static proyectooop.ProyectoOOP.programa;

/**
 *
 * @author Josua
 */
public class eliminarUsuarios extends javax.swing.JFrame {

    /**
     * Creates new form eliminarUsuarios
     */
    public eliminarUsuarios() {
        initComponents();
        this.getContentPane().setBackground(new Color(200,200,255));    //color a la ventana
        this.setLocationRelativeTo(null);   //centrar pantalla
        elim.setForeground(Color.blue);
        si.setVisible(false);
        no.setVisible(false);
        error.setVisible(false);
        error.setForeground(Color.red);
        back.setForeground(Color.blue);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ced = new javax.swing.JFormattedTextField();
        elim = new javax.swing.JButton();
        si = new javax.swing.JLabel();
        no = new javax.swing.JLabel();
        error = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Eliminando Usuarios");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Stencil", 0, 12)); // NOI18N
        jLabel1.setText("Ingrese el numero de cédula del jugador a eliminar");

        try {
            ced.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ced.setToolTipText("9 dígitos, con ceros");

        elim.setFont(new java.awt.Font("Stencil", 0, 11)); // NOI18N
        elim.setText("Eliminar Usuario");
        elim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elimActionPerformed(evt);
            }
        });

        si.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        si.setText("Se eliminó el usuario");

        no.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        no.setText("No fue posible eliminar");

        error.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        error.setText("Error en el ingreso de datos");

        back.setFont(new java.awt.Font("Stencil", 0, 11)); // NOI18N
        back.setText("Regresar");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesUsuario/fondoHisto.fw.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(si, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(ced, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(elim, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(si))
            .addGroup(layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(no))
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(ced, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(elim, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(error))
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void elimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elimActionPerformed
        // TODO add your handling code here:
        if (!ced.getText().equals("")&&(ced.getText().length()==9)&&(esnumero(ced.getText())==true)){
           
           boolean delete;
           delete=programa.eliminarUsuario(Integer.parseInt(ced.getText()));
           
           if (delete==true){ si.setVisible(true);
                              error.setVisible(false);
                              no.setVisible(false);
                              ced.setText("");
                                    }
           else{
               no.setVisible(true);
               si.setVisible(false);
               error.setVisible(false);
               ced.setText("");
               
           }
               
           
        }
           
         
        else{
                error.setVisible(true);
                ced.setText("");
                 }
        
        
        
    }//GEN-LAST:event_elimActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        error.setVisible(false);
        si.setVisible(false);
        no.setVisible(false);
        ced.setText("");
        this.dispose();
        try {
            new ventanaAdministrador().setVisible(true);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(eliminarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(eliminarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(eliminarUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(eliminarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(eliminarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(eliminarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(eliminarUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new eliminarUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JFormattedTextField ced;
    private javax.swing.JButton elim;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel no;
    private javax.swing.JLabel si;
    // End of variables declaration//GEN-END:variables
}
