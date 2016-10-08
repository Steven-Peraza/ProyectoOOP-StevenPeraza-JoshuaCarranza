
package Ventanas;

import Clases.Historial;
import Clases.Jugador;
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


public class historialPersonal extends javax.swing.JFrame {

    public Jugador jugador;
    public ArrayList<Historial> arreglo;    //referencia al historial del jugador
    int indice=0; //rrecorrido del historial
    
    
    public historialPersonal() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        nive.setVisible(false);
        datos.setVisible(false);
        nive.setForeground(Color.red);
        datos.setForeground(Color.red);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nombre = new javax.swing.JTextField();
        nombre6 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nive = new javax.swing.JLabel();
        datos = new javax.swing.JLabel();
        ant = new javax.swing.JButton();
        sig = new javax.swing.JButton();
        salir = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        numNivel = new javax.swing.JTextField();
        BM = new javax.swing.JTextField();
        estado = new javax.swing.JTextField();
        movJug = new javax.swing.JTextField();
        veces = new javax.swing.JTextField();
        tiempo = new javax.swing.JTextField();
        verDatos = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        jLabel1.setText("Número de Nivel");

        jLabel2.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        jLabel2.setText("Best Moves");

        jLabel3.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        jLabel3.setText("Estado");

        jLabel4.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        jLabel4.setText("Movimientos Jugador");

        jLabel5.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        jLabel5.setText("Tiempo");

        jLabel6.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        jLabel6.setText("Veces Jugado");

        nive.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        nive.setText("No existen más niveles jugados");

        datos.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        datos.setText("No existen datos guardados del jugador");

        ant.setFont(new java.awt.Font("Stencil", 0, 11)); // NOI18N
        ant.setText("<-Ant");
        ant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                antActionPerformed(evt);
            }
        });

        sig.setFont(new java.awt.Font("Stencil", 0, 11)); // NOI18N
        sig.setText("Sig->");
        sig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sigActionPerformed(evt);
            }
        });

        salir.setFont(new java.awt.Font("Stencil", 0, 11)); // NOI18N
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Stencil", 0, 11)); // NOI18N
        jLabel9.setText("Historial de Juego");

        numNivel.setEditable(false);

        BM.setEditable(false);

        estado.setEditable(false);

        movJug.setEditable(false);

        veces.setEditable(false);

        tiempo.setEditable(false);

        verDatos.setFont(new java.awt.Font("Stencil", 0, 11)); // NOI18N
        verDatos.setText("Ver mi Historial de Juego");
        verDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verDatosActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesUsuario/menuhisto2.fw.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(verDatos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1)
                        .addGap(19, 19, 19)
                        .addComponent(numNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel2)
                        .addGap(42, 42, 42)
                        .addComponent(BM, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(ant, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(69, 69, 69)
                                .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addGap(128, 128, 128)
                        .addComponent(sig, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel5)
                        .addGap(78, 78, 78)
                        .addComponent(tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel6)
                        .addGap(31, 31, 31)
                        .addComponent(veces, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(datos)
                        .addGap(56, 56, 56)
                        .addComponent(salir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(nive))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(movJug, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel9)
                .addGap(21, 21, 21)
                .addComponent(verDatos)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(numNivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addComponent(BM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(ant, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19)
                        .addComponent(jLabel4))
                    .addComponent(sig, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5))
                    .addComponent(tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6))
                    .addComponent(veces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(datos))
                    .addComponent(salir)))
            .addGroup(layout.createSequentialGroup()
                .addGap(402, 402, 402)
                .addComponent(nive))
            .addGroup(layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(movJug, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        this.dispose();
        try {
            new ventanaJugador().setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(historialPersonal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(historialPersonal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(historialPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_salirActionPerformed

    private void verDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verDatosActionPerformed
        indice=0;
        datos.setVisible(false);
        nive.setVisible(false);
        jugador=(Jugador)ProyectoOOP.usuario;
        arreglo=jugador.getArrayHistorial();
            if (arreglo.size()==0){
                datos.setVisible(true);
                return; // se imprime el mensaje correspondiente    
              }    
            else{  
                // se asignan valores
                nombre.setText(jugador.getNombre());
                numNivel.setText(String.valueOf(arreglo.get(indice).getNumNivel()));
                estado.setText(arreglo.get(indice).getEstado());
                BM.setText(String.valueOf(arreglo.get(indice).getBestMoves()));
                movJug.setText(String.valueOf(arreglo.get(indice).getCantidadMovimientos()));
                tiempo.setText(String.valueOf(arreglo.get(indice).getTiempo()+" minutos"));
                veces.setText(String.valueOf(arreglo.get(indice).getVecesJugado()));     
            }
    
    }//GEN-LAST:event_verDatosActionPerformed

    private void antActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_antActionPerformed
        if (indice>0){
             indice--;      //se decrementa el indice
            // se asignan valores
              
              numNivel.setText(String.valueOf(arreglo.get(indice).getNumNivel()));
              estado.setText(arreglo.get(indice).getEstado());
              BM.setText(String.valueOf(arreglo.get(indice).getBestMoves()));
              movJug.setText(String.valueOf(arreglo.get(indice).getCantidadMovimientos()));
              tiempo.setText(String.valueOf(arreglo.get(indice).getTiempo()+" minutos"));
              veces.setText(String.valueOf(arreglo.get(indice).getVecesJugado()));
            
            }
        else
            nive.setVisible(true);
    }//GEN-LAST:event_antActionPerformed

    private void sigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sigActionPerformed
        if (indice<arreglo.size()){
        
            indice++; //se aumenta el indice
             numNivel.setText(String.valueOf(arreglo.get(indice).getNumNivel()));
             estado.setText(arreglo.get(indice).getEstado());
             BM.setText(String.valueOf(arreglo.get(indice).getBestMoves()));
             movJug.setText(String.valueOf(arreglo.get(indice).getCantidadMovimientos()));
             tiempo.setText(String.valueOf(arreglo.get(indice).getTiempo()+" minutos"));
             veces.setText(String.valueOf(arreglo.get(indice).getVecesJugado()));
        }
        else
            nive.setVisible(true);
    }//GEN-LAST:event_sigActionPerformed

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
            java.util.logging.Logger.getLogger(historialPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(historialPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(historialPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(historialPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new historialPersonal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BM;
    private javax.swing.JButton ant;
    private javax.swing.JLabel datos;
    private javax.swing.JTextField estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField movJug;
    private javax.swing.JLabel nive;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField nombre6;
    private javax.swing.JTextField numNivel;
    private javax.swing.JButton salir;
    private javax.swing.JButton sig;
    private javax.swing.JTextField tiempo;
    private javax.swing.JTextField veces;
    private javax.swing.JButton verDatos;
    // End of variables declaration//GEN-END:variables
}
