/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Administrador;
import java.awt.Color;
import clases.*;
import java.awt.Image;
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
    
    
    public ventanaAdministrador() {
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

        agregarnivel.setText("Niveles");

        hacernivel.setText("Hacer un Nivel");
        agregarnivel.add(hacernivel);

        agregados.setText("Ver informacion de niveles agregados");
        agregarnivel.add(agregados);

        jMenuBar1.add(agregarnivel);

        verHistorial.setText("Usuarios");

        jMenuItem1.setText("Eliminar Usuario");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        verHistorial.add(jMenuItem1);

        jMenu1.setText("Ver usuarios con");

        optimos.setText("Más ganes  óptimos");
        jMenu1.add(optimos);

        records.setText("Más record rotos");
        jMenu1.add(records);

        superado.setText("Cierto nivel superado");
        jMenu1.add(superado);

        insistencia.setText("Insistencia en un nivel");
        jMenu1.add(insistencia);

        verHistorial.add(jMenu1);

        estadisticas.setText("Imprimir estadisticas de usuario");
        estadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadisticasActionPerformed(evt);
            }
        });
        verHistorial.add(estadisticas);

        jMenuItem2.setText("Ver historial de un usuario");
        verHistorial.add(jMenuItem2);

        jMenuBar1.add(verHistorial);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
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
                new ventanaAdministrador().setVisible(true);
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
