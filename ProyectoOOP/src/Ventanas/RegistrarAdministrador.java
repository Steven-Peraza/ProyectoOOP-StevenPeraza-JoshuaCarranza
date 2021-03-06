package Ventanas;

import Clases.Administrador;
import java.awt.Color;
import proyectooop.*;
import clases.*;
import java.awt.Font;
import java.awt.Image;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import static proyectooop.ProyectoOOP.programa;
/**
 *
 * @author Josua
 */
public class RegistrarAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarAdministrador
     */
    
    public String direccionImagen=" ";      // guardar direccion de la imagen
    private FileNameExtensionFilter archivo= new FileNameExtensionFilter("Archivo de imagen","png");
    
    public RegistrarAdministrador() {
        initComponents();
        this.getContentPane().setBackground(new Color(200,250,200));    //color a la ventana
        this.setLocationRelativeTo(null);   //centrar pantalla
        registro.setForeground(Color.blue);
        volver.setForeground(Color.blue);
        adv.setForeground(Color.red);
        direccionImagen="";   
        Calendar Cal= Calendar.getInstance(); 
        String fec= Cal.get(Cal.DATE)+"/"+(Cal.get(Cal.MONTH)+1)+"/"+Cal.get(Cal.YEAR);
        fecha.setText(fec);
        
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
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nom = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        cedula = new javax.swing.JLabel();
        registro = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        volver = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        nacionalidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        exito = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        id = new javax.swing.JFormattedTextField();
        adv = new javax.swing.JLabel();
        imagen = new javax.swing.JButton();
        mostrar = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesUsuario/menuregistrar.fw.png"))); // NOI18N

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesUsuario/menuregistrar.fw.png"))); // NOI18N
        jLabel8.setOpaque(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de Administrador");
        setAutoRequestFocus(false);
        setResizable(false);
        setSize(new java.awt.Dimension(559, 496));

        jLabel1.setFont(new java.awt.Font("Stencil Std", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Registro de administrador");

        nom.setFont(new java.awt.Font("Stencilia-Bold", 0, 18)); // NOI18N
        nom.setForeground(new java.awt.Color(255, 255, 255));
        nom.setText("Nombre");

        cedula.setFont(new java.awt.Font("Stencilia-Bold", 0, 18)); // NOI18N
        cedula.setForeground(new java.awt.Color(255, 255, 255));
        cedula.setText("Cédula");

        registro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesUsuario/BotonRegistar.fw.png"))); // NOI18N
        registro.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        registro.setDefaultCapable(false);
        registro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registroActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Stencilia-Bold", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Correo ");

        jLabel3.setFont(new java.awt.Font("Stencilia-Bold", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha de Registro");

        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesUsuario/BotonRegresar.fw.png"))); // NOI18N
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Stencilia-Bold", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nacionalidad");

        jLabel5.setFont(new java.awt.Font("Stencilia-Bold", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Contraseña");

        try {
            id.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        id.setToolTipText("9 dígitos, incluya ceros");

        adv.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesUsuario/BotonImagen.fw.png"))); // NOI18N
        imagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imagenActionPerformed(evt);
            }
        });

        fecha.setEditable(false);
        fecha.setForeground(new java.awt.Color(153, 153, 153));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagenesUsuario/menuregistrar.fw.png"))); // NOI18N
        jLabel6.setText("Exito en registro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(382, 382, 382)
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(180, 180, 180)
                                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63)
                                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(nacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(52, 52, 52))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(exito, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(registro, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(51, 51, 51)))
                        .addComponent(mostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(adv, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 564, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(mostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(248, 248, 248))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cedula, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(nacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(adv, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(exito, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(registro, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(volver, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(65, 65, 65))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ProyectoOOP.ventana.setVisible(true);
    }//GEN-LAST:event_volverActionPerformed

    private void registroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registroActionPerformed
        // TODO add your handling code here:
        
    String name;
    String contra="";
    String correos;
    String ced;
    String nacionalida;
    String fechaRegistro;
    
    name=nombre.getText();
    char [] cadena =pass.getPassword();
    for (int i=0;i<cadena.length;i++){
        contra+=cadena[i];
    }

    correos=correo.getText();
    ced=(id.getText());
    nacionalida=nacionalidad.getText();
    fechaRegistro=fecha.getText();
                                    //se valida que no hayan datos incorrectos
    if ((!name.equals(""))&&(ced.length()==9)&&(!contra.equals(""))&&(!correos.equals(""))&&(!nacionalida.equals(""))&&(!direccionImagen.equals(""))){
    
        adv.setText("");
        int numero= Integer.parseInt(ced);
        Administrador  nuevo;
        nuevo=new Administrador(name,numero,correos,contra,fechaRegistro);
        nuevo.setNacionalidad(nacionalida);
        nuevo.setFotografia(direccionImagen);
        programa.agregarUsuario(nuevo);   //se agrega
        Font fuente = new Font("Stencilia-Bold", 1, 20);
        adv.setFont(fuente);
        adv.setForeground(Color.green);
        adv.setText("Registro exitoso");
        //adv.setVisible(true);
        nombre.setText("");
        pass.setText("");
        correo.setText("");
        id.setText("");
        nacionalidad.setText("");
        mostrar.setIcon(new ImageIcon(""));
        direccionImagen="";}
    
    else {
        Font fuente = new Font("Stencilia-Bold", 1, 20);
        adv.setFont(fuente);
        adv.setText("Existen apartados en blanco"); }
    }//GEN-LAST:event_registroActionPerformed

    private void imagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imagenActionPerformed
        // TODO add your handling code here:
         //se hace un objeto tipo Jfilechooser
        
        JFileChooser nuevo = new JFileChooser ();
        
        // se establece el formato de la imagen a aceptar
        nuevo.setFileFilter(archivo);
        
        //abrir la ventana de dialogo en esta ventana para selleccionar imagen
        int var =nuevo.showOpenDialog(this);
        
        if (var==JFileChooser.APPROVE_OPTION){   // si selecciono una imagen
                    //obtener el archivo seleeccionado
               String seleccionado= nuevo.getSelectedFile().getPath();
                
                   // obtener direccion donde se guardara la imagen
               String direccion= nuevo.getSelectedFile().toString();
               mostrar.setIcon(new ImageIcon(seleccionado));
               
               ImageIcon imagen = new ImageIcon(seleccionado);
               
               Image photo = imagen.getImage();
               
               //cambiar tamaño a la imagen
               Image nueva= photo.getScaledInstance(155, 175, java.awt.Image.SCALE_SMOOTH);
               
               //generando imageicon con la nueva imagen
               
               ImageIcon icono= new ImageIcon(nueva);
               mostrar.setIcon(icono);
               mostrar.setSize(155, 175);
               
               direccionImagen=seleccionado;
        
    }//GEN-LAST:event_imagenActionPerformed
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
            java.util.logging.Logger.getLogger(RegistrarAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel adv;
    private javax.swing.JLabel cedula;
    private javax.swing.JTextField correo;
    private javax.swing.JLabel exito;
    private javax.swing.JTextField fecha;
    private javax.swing.JFormattedTextField id;
    private javax.swing.JButton imagen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel mostrar;
    private javax.swing.JTextField nacionalidad;
    private javax.swing.JLabel nom;
    private javax.swing.JTextField nombre;
    private javax.swing.JPasswordField pass;
    private javax.swing.JButton registro;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
