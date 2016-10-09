/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import Clases.Cajas;
import Clases.Historial;
import Clases.Juego;
import Clases.Jugador;
import Clases.Nivel;
import Clases.Personaje;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import proyectooop.ProyectoOOP;
import static proyectooop.ProyectoOOP.programa;

/**
 *
 * @author Josua
 */
public class game extends javax.swing.JFrame {

    /**
     * Creates new form Juego
     */
    
    boolean pasar=false;  //para manejar el uso del boton siguiente nivel
    Juego games = new Juego();  //instancia de juego
    ArrayList<Nivel> level;    //inicializacion de variables
    ArrayList<Cajas> box = new ArrayList();
    String rules;

    Cronometro cron;

    Jugador uno;
    String[] reglas;
    Personaje perso ;
    int[][] mat;
    Nivel jugando;
    int niv;
    JLabel[][] grafica;
    int filas;
    int col;
    int movimientos = 0;

    public game() {
        initComponents();
       
        
        jugando=null;
        perso= new Personaje(0, 0);
        niv=0;
        filas=0;
        col=0;
        siguiente.setFocusable(pasar);  //inhabilita el focus del boton para no afectar el juego
        tiempo.setForeground(Color.blue);
        cron = new Cronometro(tiempo);     //recibe el label por parametro
        cron.start();
        //se inicia
        gane.setVisible(false);
        moves.setForeground(Color.blue);
        bestmov.setForeground(Color.blue);
        nivel.setForeground(Color.blue);

        panel.setFocusable(true);
        moves.setText(String.valueOf(movimientos)); //mostrar mensajes

        this.setLocationRelativeTo(null);
        uno = (Jugador) ProyectoOOP.usuario;

        niv = uno.getNivelActual();
        level = ProyectoOOP.programa.getNiveles();

        for (int i = 0; i < level.size(); i++) {   //se busca el nivel en la lista general del programa

            if (level.get(i).getNumNivel() == niv) {
                jugando = level.get(i);
                break;                  //se hace una referencia al nivel

            }

        }

        bestmov.setText(String.valueOf(jugando.getBestMoves()));    //mostrando datos
        nivel.setText(String.valueOf(jugando.getNumNivel()));

        games.setMatrizLogica(jugando.getMatrizLogica());  //para que el juego conozca la matriz logica del nivel respectivo
        games.setNumNivel(niv);

        rules = programa.getReglas();
        reglas = rules.split(","); //en posicion 0 cantidad de cajas, en posicion 1 controlz
        String nu = reglas[0];
        int n = Integer.parseInt(nu);
        games.setReglaMovimientosCajas(Integer.parseInt(nu));
        games.setDeshacer(Integer.parseInt(reglas[1]));

        mat = jugando.getMatrizLogica();
        int cont = 0;
        filas = jugando.getFilas();
        col = jugando.getColumnas();
        grafica = new JLabel[filas][col];     //se inicializa la matriz grafica
        for (int i = 0; i < mat.length; i++) {      //se hace que el juego tenga una lista de cajas

            for (int x = 0; x < mat[i].length; x++) { // forma de recorrer la matriz  

                if (mat[i][x] == 1) {        //represenacion de la caja en matriz logica
                    cont++;
                    Cajas c = new Cajas(cont, i, x);
                    box.add(c);
                } else if (mat[i][x] == 3) {
                    perso.setPosicionFila(i);
                    perso.setPosicionColumna(x);

                }
            }
        }

        games.setCajas(box);  // se asigna el arreglo de cajas
        
        this.setSize(new Dimension(jugando.getColumnas() * 60 + 300, jugando.getFilas() * 60 + 150)); //se determina tamaño de la ventana
        //games.setMatrizLogica(jugando.getMatrizLogica());  //se obtiene la matriz lógica

        setimagenes();

    }
    
    
    //como las cajas se representan con numeros en la matriz y no como objetos
    //se guardo en box( una lista de objetos cajas) con su posicion
    //entonces para saber cual caja hay que eliminar de la ventana cuando se hace el deshacer
    //se busca la caja en la lista que tenga las mismas posiciones  que la que se guardo en el arreglo
    //de la clase juego (ultimacaja)
    //para saber cual caja eliminar y donde retorna la caja
    public void buscarCaja(){
     int [] array=games.getUltimaCaja();    //se recibe la ultima caja que se movio el numero y la posicion
    // se busca en el arreglo de cajas
    for (int i=0;i<box.size();i++){
        
        if ((box.get(i).getPosicionColumna()==array[1])&&(box.get(i).getPosicionFila()==array[2])){
                //hacer cambios de imagen en la ventana
        }
    }
    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //true si el jugador gano
    //false si no ha ganado
    public void determinarGane() {
        int contador = 0;  // contar los puntos que hay para saber si gano el jugador

        for (int i = 0; i < mat.length; i++) {      //se hace que el juego tenga una lista de cajas

            for (int x = 0; x < mat[i].length; x++) { // forma de recorrer la matriz  

                if (mat[i][x] == 5) {        //represenacion de la caja en matriz logica
                    contador++;
                }
            }

        }

        if (contador == jugando.getCantCajas()) {  //si hay tantas llegadas como cajas habian
            panel.setFocusable(false);  //se inhabilita lectura de
            gane.setVisible(true);
            cron.detener();
            setHistorial();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        moves = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nivel = new javax.swing.JLabel();
        bestmov = new javax.swing.JLabel();
        tiempo = new javax.swing.JLabel();
        reiniciar = new javax.swing.JButton();
        controlZ = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        gane = new javax.swing.JLabel();
        siguiente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sokoban");
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                panelKeyReleased(evt);
            }
        });

        jLabel1.setText("Movimientos");

        jLabel4.setText("Best Moves");

        jLabel2.setText("Tiempo");

        jLabel3.setText("Nivel");

        reiniciar.setText("Reiniciar Juego");

        controlZ.setText("Deshacer Movimiento");
        controlZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlZActionPerformed(evt);
            }
        });

        exit.setText("Salir");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        reset.setText("Repetir Nivel");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        gane.setFont(new java.awt.Font("Tahoma", 2, 48)); // NOI18N
        gane.setForeground(new java.awt.Color(255, 255, 51));
        gane.setText("Has superado este nivel");

        siguiente.setText("Siguiente Nivel");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(reset)
                        .addGap(28, 28, 28)
                        .addComponent(reiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(controlZ)
                        .addGap(18, 18, 18)
                        .addComponent(siguiente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(exit))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(moves, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(61, 61, 61)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(bestmov, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel3))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(gane, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(moves, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bestmov, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(150, 150, 150)
                .addComponent(gane, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reiniciar)
                    .addComponent(controlZ)
                    .addComponent(exit)
                    .addComponent(reset)
                    .addComponent(siguiente))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
      
        //panel.revalidate();
        //panel.repaint();    
        
       // this.remove(panel); // se elimina el panel
        
        moves.setText("");
        bestmov.setText("");
        tiempo.setText("");
        nivel.setText("");
        gane.setText("");
        this.dispose();
        new ventanaJugador().setVisible(true);
    }//GEN-LAST:event_exitActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resetActionPerformed

    private void controlZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlZActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_controlZActionPerformed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased

    }//GEN-LAST:event_formKeyReleased

    private void panelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelKeyReleased
        // TODO add your handling code here:
        int a;
        int b = 0;
        System.out.println(evt.getKeyCode());
        switch (evt.getKeyCode()) {   //se obtiene la tecla pulsada

            case KeyEvent.VK_LEFT:
                
                int c = perso.getPosicionColumna();
                a = mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1];
                b =mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2];
                if (ProyectoOOP.cajas==2){
                    if ((a != 5)&&(b!=5)) {
                        moverIzquierda2();
                    }
                }
                
                else{
                     if ((a != 5)&&(b!=5)) {
                        moverIzquierda();
                    }
                }
                break;

            case KeyEvent.VK_RIGHT:
                a = mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1];
                 b =mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2];
                if (ProyectoOOP.cajas==2){
                    if ((a != 5)&&(b!=5)) {
                        moverDerecha2();
                    }
                }
                
                else{
                     if ((a != 5)&&(b!=5)) {
                        moverDerecha();
                    }
                }
                
                break;

            case KeyEvent.VK_UP:
                a = mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()];
                b=mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()];
                
                if (ProyectoOOP.cajas==2){
                    if ((a != 5)&&(b!=5)) {
                        moverArriba2();
                    }
                }
                
                else{
                     if ((a != 5)&&(b!=5)) {
                        moverArriba();
                    }
                }
                
                break;
                    
               
                

            case KeyEvent.VK_DOWN:
                a = mat[perso.getPosicionFila() + 1][perso.getPosicionColumna()];
                b=mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()];
               
                if (ProyectoOOP.cajas==2){
                    if ((a != 5)&&(b!=5)) {
                        moverAbajo2();
                    }
                }
                
                else{
                     if ((a != 5)&&(b!=5)) {
                        moverAbajo();
                    }
                }
                
                
               
                break;

        }
    }//GEN-LAST:event_panelKeyReleased

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        // TODO add your handling code here:
        if (pasar==true){
            this.dispose(); //cerrar ventana
            new game().setVisible(true); //se abre una nueva ventana de juego
            }
        
        panel.setFocusable(true);
    }//GEN-LAST:event_siguienteActionPerformed

    
    public void moverIzquierda2() {
        int a;
        int b = perso.getPosicionFila();
        int c = perso.getPosicionColumna();
        a = mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1];
        
        

        if ((a != 1) && (a != 0) && (a != 2)&&(a-1!=5)) {
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;

            grafica[perso.getPosicionColumna() - 1][perso.getPosicionFila()].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            perso.setPosicionColumna(perso.getPosicionColumna() - 1);
        } //mover caja
        
        else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 3] == 2)) {
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] = 1;       //caja de otro color
             mat[perso.getPosicionFila()][perso.getPosicionColumna() - 3]=5;

            grafica[perso.getPosicionColumna() - 1][perso.getPosicionFila()].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() - 2][perso.getPosicionFila()].setIcon(getImagen(1));
            grafica[perso.getPosicionColumna() - 3][perso.getPosicionFila()].setIcon(getImagen(5));
            perso.setPosicionColumna(perso.getPosicionColumna() - 1);

        }
        
        else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] ==1)&&(mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2]!=5)){
            
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] = 1;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 3]=1;

            grafica[perso.getPosicionColumna() - 1][perso.getPosicionFila()].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() - 2][perso.getPosicionFila()].setIcon(getImagen(1));
            grafica[perso.getPosicionColumna() - 3][perso.getPosicionFila()].setIcon(getImagen(1));
            perso.setPosicionColumna(perso.getPosicionColumna() - 1);
            }
         else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] == 2)) {
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] = 5;       //caja de otro color

            grafica[perso.getPosicionColumna() - 1][perso.getPosicionFila()].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() - 2][perso.getPosicionFila()].setIcon(getImagen(5));
            perso.setPosicionColumna(perso.getPosicionColumna() - 1);}        
             
        else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 1)&&(mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 5)) {
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] = 1;

            grafica[perso.getPosicionColumna() - 1][perso.getPosicionFila()].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() - 2][perso.getPosicionFila()].setIcon(getImagen(1));
            perso.setPosicionColumna(perso.getPosicionColumna() - 1);
        }

        movimientos++;
        moves.setText(String.valueOf(movimientos));
        determinarGane();

    }
    
    
    public void moverDerecha2() {
        int a;
        a = mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1];
        if ((a != 1) && (a != 0) && (a != 2)&&(a!=5)) {
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;

            grafica[perso.getPosicionColumna() + 1][perso.getPosicionFila()].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            perso.setPosicionColumna(perso.getPosicionColumna() + 1);
        } 

        else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() +3] == 2)) {
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] = 1;       //caja de otro color
             mat[perso.getPosicionFila()][perso.getPosicionColumna() + 3]=5;

            grafica[perso.getPosicionColumna() + 1][perso.getPosicionFila()].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() + 2][perso.getPosicionFila()].setIcon(getImagen(1));
            grafica[perso.getPosicionColumna() + 3][perso.getPosicionFila()].setIcon(getImagen(5));
            perso.setPosicionColumna(perso.getPosicionColumna() + 1);

        }
        
        else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() +2] ==1)&&(mat[perso.getPosicionFila()][perso.getPosicionColumna() +2]!=5)){
            
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] = 1;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 3]=1;

            grafica[perso.getPosicionColumna() + 1][perso.getPosicionFila()].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() + 2][perso.getPosicionFila()].setIcon(getImagen(1));
            grafica[perso.getPosicionColumna() + 3][perso.getPosicionFila()].setIcon(getImagen(1));
            perso.setPosicionColumna(perso.getPosicionColumna() + 1);
            }
        
        //mover caja
        else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] == 2)) {
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] = 5;       //caja llego al destino

            grafica[perso.getPosicionColumna() + 1][perso.getPosicionFila()].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() + 2][perso.getPosicionFila()].setIcon(getImagen(5)); //caja de otro color
            perso.setPosicionColumna(perso.getPosicionColumna() + 1);

        } else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 1)) {
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] = 1;

            grafica[perso.getPosicionColumna() + 1][perso.getPosicionFila()].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() + 2][perso.getPosicionFila()].setIcon(getImagen(1));
            perso.setPosicionColumna(perso.getPosicionColumna() + 1);
        }

        movimientos++;
        moves.setText(String.valueOf(movimientos));
        determinarGane();
    }
    
     public void moverArriba2() {
        int a;
        a = mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()];

        if ((a != 1) && (a != 0) && (a != 2)&&(a!=5)) {
            mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            perso.setPosicionFila(perso.getPosicionFila() - 1);
        }
        //    
         else if ((a == 1) && (mat[perso.getPosicionFila()-2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila()-2][perso.getPosicionColumna()] == 1) && (mat[perso.getPosicionFila()-3][perso.getPosicionColumna() ] == 2)) {
            mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] = 1;
            mat[perso.getPosicionFila() - 3][perso.getPosicionColumna()] = 5;
            
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 2].setIcon(getImagen(1));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 3].setIcon(getImagen(5));
            perso.setPosicionFila(perso.getPosicionFila() - 1); 

        }    
        //  
        else if ((a == 1) && (mat[perso.getPosicionFila()-2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila()-2][perso.getPosicionColumna()] ==1)&&(mat[perso.getPosicionFila()-2][perso.getPosicionColumna()]!=5)){
            mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] = 1;
            mat[perso.getPosicionFila() - 3][perso.getPosicionColumna()] = 1;
               
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 2].setIcon(getImagen(1));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 3].setIcon(getImagen(1));
            perso.setPosicionFila(perso.getPosicionFila() - 1);  
        
        }
        // 
        else if ((a == 1) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] != 1) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] == 2)) {
            mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] = 5;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 2].setIcon(getImagen(5));
            perso.setPosicionFila(perso.getPosicionFila() - 1);  
            
        } else if ((a == 1) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] != 1)) {
            mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] = 1;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 2].setIcon(getImagen(1));
            perso.setPosicionFila(perso.getPosicionFila() - 1);

        }

        movimientos++;
        moves.setText(String.valueOf(movimientos));
        determinarGane();
    }
    
    
    public void moverAbajo2() {
        int a;
        a = mat[perso.getPosicionFila() + 1][perso.getPosicionColumna()];
        if ((a != 1) && (a != 0) && (a != 2)&&(a!=5)) {
            mat[perso.getPosicionFila() + 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            perso.setPosicionFila(perso.getPosicionFila() + 1);
            
            
        } 
        
         else if ((a == 1) && (mat[perso.getPosicionFila()+2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila()+2][perso.getPosicionColumna()] == 1) && (mat[perso.getPosicionFila()+3][perso.getPosicionColumna() ] == 2)) {
            mat[perso.getPosicionFila() +1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] = 1;
            mat[perso.getPosicionFila() + 3][perso.getPosicionColumna()] = 5;
            
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() +1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 2].setIcon(getImagen(1));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 3].setIcon(getImagen(5));
            perso.setPosicionFila(perso.getPosicionFila() + 1); 

        }    
        //  
        else if ((a == 1) && (mat[perso.getPosicionFila()+2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila()+2][perso.getPosicionColumna()] ==1)&&(mat[perso.getPosicionFila()+2][perso.getPosicionColumna()]!=5)){
            mat[perso.getPosicionFila() +1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() +2][perso.getPosicionColumna()] = 1;
            mat[perso.getPosicionFila() + 3][perso.getPosicionColumna()] = 1;
               
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() +1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() +2].setIcon(getImagen(1));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() +3].setIcon(getImagen(1));
            perso.setPosicionFila(perso.getPosicionFila() + 1);  
        
        }
        // 
        
        else if ((a == 1) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] != 1) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] == 2)) {
            mat[perso.getPosicionFila() + 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] = 5;
            
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 2].setIcon(getImagen(5));
            perso.setPosicionFila(perso.getPosicionFila() + 1);

        } else if ((a == 1) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] != 1)) {
            mat[perso.getPosicionFila() + 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] = 1;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 2].setIcon(getImagen(1));
            perso.setPosicionFila(perso.getPosicionFila() + 1);

        }

        movimientos++;
        moves.setText(String.valueOf(movimientos));
        determinarGane();
    }
    
    public void moverAbajo() {
        int a;
        a = mat[perso.getPosicionFila() + 1][perso.getPosicionColumna()];
        if ((a != 1) && (a != 0) && (a != 2)&&(a!=5)) {
            mat[perso.getPosicionFila() + 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            perso.setPosicionFila(perso.getPosicionFila() + 1);
            
        } else if ((a == 1) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] != 1) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] == 2)) {
            mat[perso.getPosicionFila() + 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] = 5;
            
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 2].setIcon(getImagen(5));
            perso.setPosicionFila(perso.getPosicionFila() + 1);

        } else if ((a == 1) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] != 1)) {
            mat[perso.getPosicionFila() + 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] = 1;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 2].setIcon(getImagen(1));
            perso.setPosicionFila(perso.getPosicionFila() + 1);

        }

        movimientos++;
        moves.setText(String.valueOf(movimientos));
        determinarGane();
    }

    public void moverArriba() {
        int a;
        a = mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()];

        if ((a != 1) && (a != 0) && (a != 2)&&(a!=5)) {
            mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            perso.setPosicionFila(perso.getPosicionFila() - 1);

        } else if ((a == 1) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] != 1) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] == 2)) {
            mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] = 5;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 2].setIcon(getImagen(5));
            perso.setPosicionFila(perso.getPosicionFila() - 1);

        } else if ((a == 1) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] != 1)) {
            mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] = 1;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 2].setIcon(getImagen(1));
            perso.setPosicionFila(perso.getPosicionFila() - 1);

        }

        movimientos++;
        moves.setText(String.valueOf(movimientos));
        determinarGane();
    }

    public void moverDerecha() {
        int a;
        a = mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1];
        if ((a != 1) && (a != 0) && (a != 2)&&(a!=5)) {
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;

            grafica[perso.getPosicionColumna() + 1][perso.getPosicionFila()].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            perso.setPosicionColumna(perso.getPosicionColumna() + 1);
        } //mover caja
        else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] == 2)) {
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] = 5;       //caja llego al destino

            grafica[perso.getPosicionColumna() + 1][perso.getPosicionFila()].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() + 2][perso.getPosicionFila()].setIcon(getImagen(5)); //caja de otro color
            perso.setPosicionColumna(perso.getPosicionColumna() + 1);

        } else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 1)) {
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] = 1;

            grafica[perso.getPosicionColumna() + 1][perso.getPosicionFila()].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() + 2][perso.getPosicionFila()].setIcon(getImagen(1));
            perso.setPosicionColumna(perso.getPosicionColumna() + 1);
        }

        movimientos++;
        moves.setText(String.valueOf(movimientos));
        determinarGane();
    }

    public void moverIzquierda() {
        int a;
        int b = perso.getPosicionFila();
        int c = perso.getPosicionColumna();
        a = mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1];

        if ((a != 1) && (a != 0) && (a != 2)&&(a!=5)) {
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;

            grafica[perso.getPosicionColumna() - 1][perso.getPosicionFila()].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            perso.setPosicionColumna(perso.getPosicionColumna() - 1);
        } //mover caja
        else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] == 2)) {
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] = 5;       //caja de otro color

            grafica[perso.getPosicionColumna() - 1][perso.getPosicionFila()].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() - 2][perso.getPosicionFila()].setIcon(getImagen(5));
            perso.setPosicionColumna(perso.getPosicionColumna() - 1);

        } else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 1)&&(mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 5)) {
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] = 1;

            grafica[perso.getPosicionColumna() - 1][perso.getPosicionFila()].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() - 2][perso.getPosicionFila()].setIcon(getImagen(1));
            perso.setPosicionColumna(perso.getPosicionColumna() - 1);
        }

        movimientos++;
        moves.setText(String.valueOf(movimientos));
        determinarGane();

    }

    public ImageIcon getImagen(int num) {

        switch (num) {

            case 0:
                return new ImageIcon(getClass().getResource("/ImagenesUsuario/pared.png"));

            case 1:
                return new ImageIcon(getClass().getResource("/ImagenesUsuario/caja.png"));

            case 2:
                return new ImageIcon(getClass().getResource("/ImagenesUsuario/diamante.png"));

            case 3:
                return new ImageIcon(getClass().getResource("/ImagenesUsuario/persona.png"));

            case 5:
                return new ImageIcon(getClass().getResource("/ImagenesUsuario/cajap.png"));
            default:
                return new ImageIcon(getClass().getResource("/ImagenesUsuario/fond.png"));
            
        
        }

    }
    
    //datos para hacer el historial del jugador
    public void setHistorial(){
    
    int time=cron.getTotalSegundos();
    String condicion;
    int mov=Integer.parseInt(moves.getText());
    if (mov>jugando.getBestMoves()){
            condicion="Ganado";
            
            }
    
    else{
            condicion="Optimizado";
            }
    
    // se hace el historial
    Historial nuevo=new Historial(jugando.getNumNivel(),jugando,condicion,mov,time,jugando.getBestMoves());
    nuevo.setVecesJugado();
    uno.setArrayHistorial(nuevo);   //se agrega el historial al jugador
    
    
    if (level.size()>uno.getNivelActual()){
            
            uno.setNivelActual(uno.getNivelActual()+1);     //se actualiza el nivel actual del jugador si existen más
            pasar=true;     //habilitar boton de siguiente nivel
            siguiente.setFocusable(pasar);
            }
    
    }
    

    public void setimagenes() {

        for (int i = 0; i < filas; i++) {

            for (int x = 0; x < col; x++) {

                grafica[i][x] = new JLabel();
                grafica[i][x].setOpaque(true);    //si no se coloca no se vé la imagen del label
                grafica[i][x].setBounds((i * 60) + 80, (x * 60) + 80, 60, 60);  //situando el label
                grafica[i][x].setVisible(true);
                //grafica[i][x].setBackground(Color.BLUE);
                grafica[i][x].setIcon(getImagen(mat[x][i]));    //las dos estan en orden diferente
                panel.add(grafica[i][x]);   //se agrega el panel

            }
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
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bestmov;
    private javax.swing.JButton controlZ;
    private javax.swing.JButton exit;
    private javax.swing.JLabel gane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel moves;
    private javax.swing.JLabel nivel;
    private javax.swing.JPanel panel;
    private javax.swing.JButton reiniciar;
    private javax.swing.JButton reset;
    private javax.swing.JButton siguiente;
    private javax.swing.JLabel tiempo;
    // End of variables declaration//GEN-END:variables

}
