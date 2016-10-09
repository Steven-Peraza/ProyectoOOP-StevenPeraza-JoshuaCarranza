/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Jugador;
import Clases.Usuario;
import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyListener;
import proyectooop.ProyectoOOP;
import static proyectooop.ProyectoOOP.programa;


/**
 *
 * @author Josua
 */
public class estadistica extends javax.swing.JFrame {

    /**
     * Creates new form estadistica
     */
    public Jugador jugador;
    
    public estadistica() {
        initComponents();
        
        mensaje.setForeground(Color.red);
        mensaje.setVisible(false);
        nombre.setEditable(false); //para que no se pueda escribir en el textfield
        rep.setEditable(false);
        niveles.setEditable(false);
        opt.setEditable(false);
        rotos.setEditable(false);
        this.getContentPane().setBackground(new Color(200,200,255));    //color a la ventana
        this.setLocationRelativeTo(null);   //centrar pantalla
        exit.setForeground(Color.blue);
        imp.setForeground(Color.blue);       
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ced = new javax.swing.JFormattedTextField();
        mensaje = new javax.swing.JLabel();
        imp = new javax.swing.JToggleButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        niveles = new javax.swing.JTextField();
        rotos = new javax.swing.JTextField();
        opt = new javax.swing.JTextField();
        rep = new javax.swing.JTextField();
        exit = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesUsuario/fondoHisto.fw.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Estadisticas de Jugador");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Stencil Std", 0, 12)); // NOI18N
        jLabel1.setText("Ingrese el numero de cédula del jugador");

        try {
            ced.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ced.setToolTipText("9 dígitos, con ceros");

        mensaje.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        mensaje.setText("Jugador no encontrado");

        imp.setFont(new java.awt.Font("Stencil", 0, 11)); // NOI18N
        imp.setText("Imprimir Estadística");
        imp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                impActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Stencil", 0, 11)); // NOI18N
        jLabel2.setText("Niveles Jugados");

        jLabel3.setFont(new java.awt.Font("Stencil", 0, 11)); // NOI18N
        jLabel3.setText("Record Rotos");

        jLabel4.setFont(new java.awt.Font("Stencil", 0, 11)); // NOI18N
        jLabel4.setText("Ganes Optimizados");

        jLabel5.setFont(new java.awt.Font("Stencil", 0, 11)); // NOI18N
        jLabel5.setText("Nivel más Repetido");

        jLabel6.setFont(new java.awt.Font("Stencil", 0, 11)); // NOI18N
        jLabel6.setText("Nombre Jugador");

        exit.setFont(new java.awt.Font("Stencil Std", 0, 11)); // NOI18N
        exit.setText("Salir");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesUsuario/menucasco.fw.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(ced, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(rep, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(niveles, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(imp, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(289, 289, 289)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(mensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(rotos, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(opt, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(ced, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(rep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(niveles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(imp))
            .addGroup(layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(mensaje))
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(rotos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(opt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(194, 194, 194)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void impActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_impActionPerformed
        // TODO add your handling code here:
        
        if ((ced.getText().length()==9)&&(esnumero(ced.getText())==true)){
        
        Usuario use=programa.buscarUsuario(Integer.parseInt(ced.getText()));
        
        if (use!=null){
            int reps;
            int cant;
            int roto;   //variables para almacenar datos
            int ganes;
            jugador=(Jugador) use;
            cant= programa.cantidadNivelesJugados(jugador);
            reps=programa.obtenerNivelMasRepetido(jugador);
            roto=programa.cantidadRecordRotos(jugador);
            ganes=programa.jugadorCantidadGanesOpt(jugador);
            
            
            nombre.setText(jugador.getNombre());        //se despliegan datos

            niveles.setText("  "+String.valueOf(cant));
            rotos.setText("  "+String.valueOf(roto));
            opt.setText("  "+String.valueOf(ganes));
            rep.setText("  "+String.valueOf(reps));
            mensaje.setVisible(false);

            }
        else{  mensaje.setVisible(true); }
        
        }
        
        else{
                mensaje.setVisible(true);
            
            }
        
        
    }//GEN-LAST:event_impActionPerformed

    
        public boolean esnumero(String texto){
    
	try {
		Integer.parseInt(texto);
		return true;
	} catch (NumberFormatException mistake){    //si no todos los caracteres son numeros
		return false;
    
        }
    }
    
    
    
    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        this.dispose();
        try {
            new ventanaAdministrador().setVisible(true);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(estadistica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(estadistica.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(estadistica.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
   
    }//GEN-LAST:event_exitActionPerformed

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
            java.util.logging.Logger.getLogger(estadistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(estadistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(estadistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(estadistica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new estadistica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField ced;
    private javax.swing.JButton exit;
    private javax.swing.JToggleButton imp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel mensaje;
    private javax.swing.JTextField niveles;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField opt;
    private javax.swing.JTextField rep;
    private javax.swing.JTextField rotos;
    // End of variables declaration//GEN-END:variables
}
