
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

//import Clases.Cajas;
//import Clases.Historial;
import Clases.Cajas;
import Clases.Cajas;
import Clases.Estadistica;
import Clases.Grupo;
import Clases.Historial;
import Clases.Juego;
import Clases.Jugador;
import Clases.Nivel;
import Clases.Personaje;
import Clases.Usuario;
import Ventanas.Cronometro;
import Ventanas.ventanaJugador;
import static Ventanas.ventanaJugador.Musica;
import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
    
    boolean fin=false;  //manejar niveles por jugar
    boolean pasar = false;  //para manejar el uso del boton siguiente nivel
    Juego games = new Juego();  //instancia de juego
    ArrayList<Nivel> level;    //inicializacion de variables
    ArrayList<Cajas> box = new ArrayList();

   

    public ArrayList<Historial> arreglo;
    //ArrayList<Personaje> lisMov = new ArrayList();

    String rules;

    Historial nuevo = new Historial(0, null, "nada", 0, 0, 0); //inicializacion de una variable historial

    ArrayList<Grupo> group; //array que guarda los grupos

    Grupo grupo;
    ArrayList<Jugador> jug;

    String[] lev;
    Cronometro cron;

    String joger;

    ArrayList<Personaje> listMovPer = new ArrayList();
    ArrayList<Cajas> listMovCajas = new ArrayList();
    ArrayList<Cajas> listMovCajas2 = new ArrayList();
    ArrayList<Cajas> cajasSueltas = new ArrayList();
    ArrayList<Cajas> cajasSueltas2 = new ArrayList();
    int v, c, a;
    boolean lastMoveBox = false;
    boolean lastMoveBoxes = false;
    boolean VC = false;

    Jugador uno;
    String[] reglas;
    Personaje perso;
    int[][] mat;
    int[][] respaldo;
    Nivel jugando;
    int niv;
    String[] jogador;
    JLabel[][] grafica;
    int filas;
    int col;
    int movimientos = 0;
    private static Clip clip3;

    public game() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        initComponents();

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        Musica("Hyrule_Field.wav");

        jugando = null;
        perso = new Personaje(0, 0);
        niv = 0;
        filas = 0;
        col = 0;
        siguiente.setFocusable(pasar);  //inhabilita el focus del boton para no afectar el juego

        tiempo.setForeground(Color.red);

        cron = new Cronometro(tiempo);     //recibe el label por parametro
        cron.start();
        //se inicia el hilo cron
        gane.setVisible(false);
        moves.setForeground(Color.red);
        bestmov.setForeground(Color.red);
        nivel.setForeground(Color.red);

        panel.setFocusable(true);
        moves.setText(String.valueOf(movimientos)); //mostrar mensajes

        this.setLocationRelativeTo(null);
        uno = (Jugador) ProyectoOOP.usuario;
        
        if (ProyectoOOP.tipo.equals("normal")) {
            niv = uno.getNivelActual();
        } else {
            group = programa.obtenerListaGrupo();
            exit.setEnabled(false);
            for (int i = 0; i < group.size(); i++) {

                jogador = group.get(i).getJugadores().split(","); //lista de jugadores con split
                for (int x = 0; x < jogador.length; x++) {

                    if (uno.getNombre().equals(jogador[x])) {

                        grupo = group.get(i);
                    }
                }
            }
            joger = jogador[ProyectoOOP.j];   //asignado jugador en curso
            lev = grupo.getNiveles().split(","); //array de niveles
            persona.setText("Turno de "+joger);  //nombre del jugador
            niv = Integer.parseInt(lev[ProyectoOOP.pos]);

        }

        level = ProyectoOOP.programa.getNiveles();
        if (uno.getNivelesPorRepetir() != null){
            for (int w = 0; w < uno.getNivelesPorRepetir().length;w++){
                if (uno.getNivelesPorRepetir()[w] != 0){
                    Nivel levelrepe = programa.buscarNivel(uno.getNivelesPorRepetir()[w]);
                    System.out.println(uno.getNivelesPorRepetir()[w]);
                    jugando = levelrepe;
                    uno.nivelesPorRepetir[w] = 0;
                    break;
                }
            }
        }
        else{
        for (int i = 0; i < level.size(); i++) {   //se busca el nivel en la lista general del programa

            if (level.get(i).getNumNivel() == niv) {
                jugando = level.get(i);
                break;                  //se hace una referencia al nivel

            }
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

        respaldo = new int[filas][col];

        for (int z = 0; z < respaldo.length; z++) {

            for (int c = 0; c < respaldo[z].length; c++) {

                respaldo[z][c] = mat[z][c];

            }

        }

        grafica = new JLabel[filas][col];     //se inicializa la matriz grafica
        for (int i = 0; i < mat.length; i++) {

            for (int x = 0; x < mat[i].length; x++) { // forma de recorrer la matriz  

                if (mat[i][x] == 1) {        //represenacion de la caja en matriz logica
                    cont++;
                    Cajas c = new Cajas(cont, i, x, i, x);
                    box.add(c);
                } else if (mat[i][x] == 3) {
                    perso.setPosicionFila(i);
                    perso.setIniPosicionFila(i);
                    perso.setPosicionColumna(x);
                    perso.setIniPosicionColumna(x);

                }
            }
        }

        games.setCajas(box);  // se asigna el arreglo de cajas

        this.setSize(new Dimension(jugando.getColumnas() * 60 + 300, jugando.getFilas() * 60 + 150)); //se determina tamaño de la ventana
        //games.setMatrizLogica(jugando.getMatrizLogica());  //se obtiene la matriz lógica

        setimagenes();

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

     //   System.out.print("tamaño de matriz"+mat.length);
        
        for (int i = 0; i < mat.length; i++) {      //se hace que el juego tenga una lista de cajas
//System.out.print("tamaño de fila "+mat[i].length);
            for (int x = 0; x < mat[i].length; x++) { // forma de recorrer la matriz  

                if (mat[i][x] == 5) {        //represenacion de la caja en matriz logica
                    contador++;
                }
            }

        }

        if (contador == jugando.getCantCajas()) {  //si hay tantas llegadas como cajas habian
                
                
            if (ProyectoOOP.tipo.equals("normal")) {
                panel.setFocusable(false);  //se inhabilita lectura de
                gane.setVisible(true);
                cron.detener();
                
                pasar=true;     //habilitar gane
                controlZ.setEnabled(false);
                reiniciar.setEnabled(false);
               
                setHistorial();

                mat = respaldo;
            } else {
                panel.setFocusable(false);  //se inhabilita lectura de
                gane.setVisible(true);
                pasar = true;
                cron.detener();
                mat = respaldo;
               
                controlZ.setEnabled(false);
                reiniciar.setEnabled(false);
                return;

            }
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
        gane = new javax.swing.JLabel();
        siguiente = new javax.swing.JButton();
        persona = new javax.swing.JLabel();

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

        jLabel1.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        jLabel1.setText("Movimientos");

        jLabel4.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        jLabel4.setText("Best Moves");

        moves.setFont(new java.awt.Font("Stencil Std", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        jLabel2.setText("Tiempo");

        jLabel3.setFont(new java.awt.Font("Stencilia-Bold", 0, 11)); // NOI18N
        jLabel3.setText("Nivel");

        nivel.setFont(new java.awt.Font("Stencil Std", 0, 14)); // NOI18N

        bestmov.setFont(new java.awt.Font("Stencil Std", 0, 14)); // NOI18N

        tiempo.setFont(new java.awt.Font("Stencil Std", 0, 14)); // NOI18N

        reiniciar.setFont(new java.awt.Font("Stencilia-A", 0, 11)); // NOI18N
        reiniciar.setText("Reiniciar Juego");
        reiniciar.setFocusable(false);
        reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reiniciarActionPerformed(evt);
            }
        });

        controlZ.setFont(new java.awt.Font("Stencilia-A", 0, 11)); // NOI18N
        controlZ.setText("Deshacer Movimiento");
        controlZ.setFocusable(false);
        controlZ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                controlZActionPerformed(evt);
            }
        });

        exit.setFont(new java.awt.Font("Stencilia-A", 0, 11)); // NOI18N
        exit.setText("Salir");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        gane.setFont(new java.awt.Font("Stencil Std", 2, 48)); // NOI18N
        gane.setForeground(new java.awt.Color(255, 51, 51));
        gane.setText("¡Nivel Superado!");

        siguiente.setFont(new java.awt.Font("Stencilia-A", 0, 11)); // NOI18N
        siguiente.setText("Siguiente Nivel");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        persona.setFont(new java.awt.Font("Tahoma", 2, 48)); // NOI18N

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addComponent(gane, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(reiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(controlZ)
                                .addGap(33, 33, 33)
                                .addComponent(siguiente)
                                .addGap(40, 40, 40)
                                .addComponent(exit)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(43, 43, 43))
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
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(gane, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(persona, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(persona, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reiniciar)
                    .addComponent(controlZ)
                    .addComponent(exit)
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

        try {
            //panel.revalidate();
            //panel.repaint();
             boolean ya;
             
             clip3.stop();
             Historial rec;
             ya=yaEstaHistorial();
             int time = cron.getTotalSegundos();
             int mov = Integer.parseInt(moves.getText());
            // this.remove(panel); // se elimina el panel
            if ((pasar!=true)&&(ya==true)){       //si no ganó el juego 
                   
               
        
                 rec=traerHistorial();
                 rec.setVecesJugado();
                 rec.setNumNivel(jugando.getNumNivel());
                 rec.setEstado("Perdido");
                 rec.setCantidadMovimientos(mov);
                 rec.setNivel(jugando);  //referencia al nivel jugado
                 rec.setTiempo(time);
                 rec.setBestMoves(jugando.getBestMoves());
                 
            
                    
                }
           
        
            else if ((pasar!=true)&&(ya!=true)) {
              
         
            
            nuevo.setNumNivel(jugando.getNumNivel());
            nuevo.setEstado("Perdido");
            nuevo.setCantidadMovimientos(mov);
            nuevo.setNivel(jugando);  //referencia al nivel jugado
            nuevo.setTiempo(time);
            nuevo.setBestMoves(jugando.getBestMoves());
            nuevo.setVecesJugado();
            uno.setArrayHistorial(nuevo);   //se agrega el historial al jugador
            
               }
            
            
            
            jugando.setMatrizLogica(respaldo);
            moves.setText("");
            bestmov.setText("");
            tiempo.setText("");
            nivel.setText("");
            gane.setText("");
            this.dispose();
            clip3.stop();
            new ventanaJugador().setVisible(true);
            
        } catch (IOException ex) {
            Logger.getLogger(game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(game.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(game.class.getName()).log(Level.SEVERE, null, ex);
        
        }
    }//GEN-LAST:event_exitActionPerformed

    private void controlZActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_controlZActionPerformed

        if ((ProyectoOOP.z < 2)&&(VC == true)){

            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4; //se borra el personaje de la posicion donde se encuentre, en las dos matrices
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            Collections.reverse(listMovPer);
            Collections.reverse(listMovCajas);
            Collections.reverse(listMovCajas2);
            Collections.reverse(cajasSueltas);
            Collections.reverse(cajasSueltas2);
            for (int i = 0; i < listMovPer.size(); i+=2){
                perso.setPosicionFila(listMovPer.get(i+1).getPosicionFila());  //se vuelve a colocar el personaje en la posicion inicial
                perso.setPosicionColumna(listMovPer.get(i).getPosicionColumna());
                listMovPer.remove(i);
                listMovPer.remove(i);
                break;
            }
            if (lastMoveBox == true) {
                for (int i = 0; i < listMovCajas.size(); i++) {
                    v = listMovCajas.get(i).getPosicionFila();  //se vuelve a colocar el personaje en la posicion inicial
                    c = listMovCajas.get(i).getPosicionColumna();
                    a = listMovCajas.get(i).getNumeroCaja();
                    listMovCajas.remove(i);
                    mat[v][c] = 1;
                    grafica[c][v].setIcon(getImagen(1));
                    break;
                }

                for (int i = 0; i < cajasSueltas.size(); i++) {
                    if (mat[cajasSueltas.get(i).getPosicionFila()][cajasSueltas.get(i).getPosicionColumna()] == 5) {
                        mat[cajasSueltas.get(i).getPosicionFila()][cajasSueltas.get(i).getPosicionColumna()] = 2;
                        grafica[cajasSueltas.get(i).getPosicionColumna()][cajasSueltas.get(i).getPosicionFila()].setIcon(getImagen(2));
                        break;
                    }
                    mat[cajasSueltas.get(i).getPosicionFila()][cajasSueltas.get(i).getPosicionColumna()] = 4; //se borra el personaje de la posicion donde se encuentre, en las dos matrices
                    grafica[cajasSueltas.get(i).getPosicionColumna()][cajasSueltas.get(i).getPosicionFila()].setIcon(getImagen(4));
                    cajasSueltas.remove(i);
                    break;
                }

            }
            else if (lastMoveBoxes == true){
                for (int o = 0; o < listMovCajas2.size(); o++){
                    v = listMovCajas2.get(o).getPosicionFila();  //se vuelve a colocar el personaje en la posicion inicial
                    c = listMovCajas2.get(o).getPosicionColumna();
                    a = listMovCajas2.get(o).getNumeroCaja();
                    listMovCajas2.remove(o);
                    mat[v][c] = 1;
                    grafica[c][v].setIcon(getImagen(1));
                    v = listMovCajas2.get(o).getPosicionFila();  //se vuelve a colocar el personaje en la posicion inicial
                    c = listMovCajas2.get(o).getPosicionColumna();
                    a = listMovCajas2.get(o).getNumeroCaja();
                    listMovCajas2.remove(o);
                    System.out.println("joder!!");
                    mat[v][c] = 1;
                    grafica[c][v].setIcon(getImagen(1));
                    break;
                }


                for (int o = 0; o < cajasSueltas2.size(); o++){
                    if (mat[cajasSueltas2.get(o).getPosicionFila()][cajasSueltas2.get(o).getPosicionColumna()] == 5){
                        mat[cajasSueltas2.get(o).getPosicionFila()][cajasSueltas2.get(o).getPosicionColumna()] = 2;
                        grafica[cajasSueltas2.get(o).getPosicionColumna()][cajasSueltas2.get(o).getPosicionFila()].setIcon(getImagen(2));
                        break;
                    }
                    mat[cajasSueltas2.get(o).getPosicionFila()][cajasSueltas2.get(o).getPosicionColumna()] = 4; //se borra el personaje de la posicion donde se encuentre, en las dos matrices
                    grafica[cajasSueltas2.get(o).getPosicionColumna()][cajasSueltas2.get(o).getPosicionFila()].setIcon(getImagen(4));
                    cajasSueltas2.remove(o);
                    break;
                }
            }
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(perso.getId()));
            Collections.reverse(listMovPer);
            Collections.reverse(listMovCajas);
            Collections.reverse(listMovCajas2);
            Collections.reverse(cajasSueltas);
            Collections.reverse(cajasSueltas2);
            movimientos -= 1;
            moves.setText(String.valueOf(movimientos));
            ProyectoOOP.z += 1;
            VC = false;
        }
        else if (ProyectoOOP.z == 2)
            System.out.println("Ha alcanzado el maximo de controls Z");
        else
            System.out.println("Solo posee un control Z por movimiento");

    }//GEN-LAST:event_controlZActionPerformed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased

    }//GEN-LAST:event_formKeyReleased

    private void panelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_panelKeyReleased
        // TODO add your handling code here:
        int a;
        int b = 0;
        int d;
        System.out.println(evt.getKeyCode());
        switch (evt.getKeyCode()) {   //se obtiene la tecla pulsada

            case KeyEvent.VK_LEFT:          //presiona tecla izquierda
                persona.setVisible(false);
                int c = perso.getPosicionColumna();
                a = mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1];
                b = mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2];
                
                if (ProyectoOOP.cajas == 2) {
                    if ((a != 5) && (b != 5)) {
                        moverIzquierda2();
                    }
                } else if ((a != 5) && (b != 5)) {
                    moverIzquierda();
                }
                break;

            case KeyEvent.VK_RIGHT:         //presiona tecla dereha
                persona.setVisible(false);
                a = mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1];
                b = mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2];
                if (ProyectoOOP.cajas == 2) {
                    if ((a != 5) && (b != 5)) {
                        moverDerecha2();
                    }
                } else if ((a != 5) && (b != 5)) {
                    moverDerecha();
                }

                break;

            case KeyEvent.VK_UP:     //presiona tecla arriba
                persona.setVisible(false);
                a = mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()];
                b = mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()];

                if (ProyectoOOP.cajas == 2) {
                    if ((a != 5) && (b != 5)) {
                        moverArriba2();
                    }
                } else if ((a != 5) && (b != 5)) {
                    moverArriba();
                }

                break;

            case KeyEvent.VK_DOWN:      // presiona tecla abajo
                persona.setVisible(false);
                a = mat[perso.getPosicionFila() + 1][perso.getPosicionColumna()];
                b = mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()];

                if (ProyectoOOP.cajas == 2) {
                    if ((a != 5) && (b != 5)) {
                        moverAbajo2();
                    }
                } else if ((a != 5) && (b != 5)) {
                    moverAbajo();
                }

                break;

        }
    }//GEN-LAST:event_panelKeyReleased


    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
        // TODO add your handling code here:
        jugando.setMatrizLogica(respaldo);
        if ((pasar == true) && (ProyectoOOP.tipo.equals("normal"))&&(fin!=true)){    //si aun hay niveles
            
            if(level.size()==uno.getNivelActual()){
            
                fin=true;
            }
                    
            jugando.setMatrizLogica(respaldo);
            
            this.dispose(); //cerrar ventana
            ProyectoOOP.z = 0;
            clip3.stop();
            try {
                new game().setVisible(true); //se abre una nueva ventana de juego
            } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                Logger.getLogger(game.class.getName()).log(Level.SEVERE, null, ex);
            }


        } 
        else if (uno.getNivelesPorRepetir() != null){
                this.dispose(); //cerrar ventana
                try {
                    new game().setVisible(true); //se abre una nueva ventana de juego
                } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                    Logger.getLogger(game.class.getName()).log(Level.SEVERE, null, ex);
                }
            

        } else if ((pasar == true)&&(!ProyectoOOP.tipo.equals("normal"))){
            
            ProyectoOOP.counter+=Integer.parseInt(moves.getText());     //suma de tiempos y de movimientos totales en los
            ProyectoOOP.timer+=cron.getTotalSegundos();      //niveles
            

            
            if ((ProyectoOOP.pos == lev.length - 1) && (ProyectoOOP.j < jogador.length - 1)) {
                
                ProyectoOOP.j++;
                
                ProyectoOOP.pos = 0;
                
                
                if ((ProyectoOOP.counter <ProyectoOOP.grp.getMenorMovimientos())){
                    ProyectoOOP.grp.setMenorMovimientos(ProyectoOOP.counter);
                    ProyectoOOP.grp.setMejorEnMovimientos(joger);   //cambia el nombre;
                    
                }
            
                if (ProyectoOOP.timer < ProyectoOOP.grp.getMenorTiempo()){
                    ProyectoOOP.grp.setMenorTiempo(ProyectoOOP.timer);
                    ProyectoOOP.grp.setMejorEnTiempo(joger);
            
                        }
                
               ProyectoOOP.counter=0;
               ProyectoOOP.timer=0;
                
                jugando.setMatrizLogica(respaldo);
                this.dispose(); //cerrar ventana
                try {
                    new game().setVisible(true); //se abre una nueva ventana de juego
                } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                    Logger.getLogger(game.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if ((ProyectoOOP.pos < lev.length - 1) && (ProyectoOOP.j <= jogador.length - 1)) {
                
                ProyectoOOP.pos++;
                jugando.setMatrizLogica(respaldo);
                
                this.dispose(); //cerrar ventana
                try {
                    new game().setVisible(true); //se abre una nueva ventana de juego
                } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                    Logger.getLogger(game.class.getName()).log(Level.SEVERE, null, ex);
                }
             
            }

             else {
                
                    
                if ((ProyectoOOP.counter<ProyectoOOP.grp.getMenorMovimientos())){
                    ProyectoOOP.grp.setMenorMovimientos(ProyectoOOP.counter);
                    ProyectoOOP.grp.setMejorEnMovimientos(joger);   //cambia el nombre;
                    
                }
            
                if (ProyectoOOP.timer<ProyectoOOP.grp.getMenorTiempo()){
                    ProyectoOOP.grp.setMenorTiempo(ProyectoOOP.timer);
                    ProyectoOOP.grp.setMejorEnTiempo(joger);
            
                        }  
                ProyectoOOP.counter=0;
                ProyectoOOP.timer=0;
               
               
                jugando.setMatrizLogica(respaldo);
                ProyectoOOP.pos=0;
                ProyectoOOP.j=0;
              
                ProyectoOOP.terminaron=true;
                this.dispose();
                new InformeGrupo().setVisible(true);
                        
                }
        }

        
        clip3.stop();
        panel.setFocusable(true);
    }//GEN-LAST:event_siguienteActionPerformed

    public void moverIzquierda2() {
        int a;
        int b = perso.getPosicionFila();
        int c = perso.getPosicionColumna();
        a = mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1];

        Personaje nuevo = new Personaje(perso.getPosicionFila(), perso.getPosicionColumna());

        if ((a != 1) && (a != 0) && (a != 2) && (a - 1 != 5)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            movimientos++;
            
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;

            grafica[perso.getPosicionColumna() - 1][perso.getPosicionFila()].setIcon(getImagen(8));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            perso.setPosicionColumna(perso.getPosicionColumna() - 1);

            lastMoveBoxes = false;
            lastMoveBox = false;
            VC = false;
        } //mover caja
        else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 3] == 2)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] = 1;       //caja de otro color
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 3] = 5;

            grafica[perso.getPosicionColumna() - 1][perso.getPosicionFila()].setIcon(getImagen(8));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() - 2][perso.getPosicionFila()].setIcon(getImagen(1));
            grafica[perso.getPosicionColumna() - 3][perso.getPosicionFila()].setIcon(getImagen(5));
            perso.setPosicionColumna(perso.getPosicionColumna() - 1);


            movimientos++;
            
 
            Cajas nueva = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna());
            listMovCajas2.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna()-1);

            cajasSueltas2.add(suelta);
            Cajas nueva2 = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna()-1);
            listMovCajas2.add(nueva2);
            Cajas suelta2 = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna()-2);
            cajasSueltas2.add(suelta2);
            lastMoveBoxes = true;
            VC = true;
            lastMoveBox = false;

        } else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 5)&&(mat[perso.getPosicionFila()][perso.getPosicionColumna() - 3] != 0)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] = 1;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 3] = 1;

            movimientos++;
            
            grafica[perso.getPosicionColumna() - 1][perso.getPosicionFila()].setIcon(getImagen(8));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() - 2][perso.getPosicionFila()].setIcon(getImagen(1));
            grafica[perso.getPosicionColumna() - 3][perso.getPosicionFila()].setIcon(getImagen(1));
            perso.setPosicionColumna(perso.getPosicionColumna() - 1);
            
            Cajas nueva = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna());
            listMovCajas2.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna()-1);
            cajasSueltas2.add(suelta);
            Cajas nueva2 = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna()-1);
            listMovCajas2.add(nueva2);
            Cajas suelta2 = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna()-2);
            cajasSueltas2.add(suelta2);
            lastMoveBoxes = true;
            VC = true;
            lastMoveBox = false;
            }
         else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] == 2)) {
             
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] = 5;       //caja de otro color

            grafica[perso.getPosicionColumna() - 1][perso.getPosicionFila()].setIcon(getImagen(8));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() - 2][perso.getPosicionFila()].setIcon(getImagen(5));
            perso.setPosicionColumna(perso.getPosicionColumna() - 1);

            movimientos++;
            
            Cajas nueva = new Cajas(perso.getPosicionFila(), perso.getPosicionColumna());
            listMovCajas.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna()-1);
            cajasSueltas.add(suelta);
            lastMoveBox = true;
            VC = true;
            lastMoveBoxes = false;
         }
        else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 1)&&(mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 5)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] = 1;

            grafica[perso.getPosicionColumna() - 1][perso.getPosicionFila()].setIcon(getImagen(8));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() - 2][perso.getPosicionFila()].setIcon(getImagen(1));
            perso.setPosicionColumna(perso.getPosicionColumna() - 1);

            movimientos++;
            
            Cajas nueva = new Cajas(perso.getPosicionFila(), perso.getPosicionColumna());
            listMovCajas.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna()-1);
            cajasSueltas.add(suelta);
            lastMoveBox = true;
            VC = true;
            lastMoveBoxes = false;
        }

        
        moves.setText(String.valueOf(movimientos));
        determinarGane();

    }

    public void moverDerecha2() {
        int a;
        a = mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1];
        Personaje nuevo = new Personaje(perso.getPosicionFila(), perso.getPosicionColumna());

        if ((a != 1) && (a != 0) && (a != 2) && (a != 5)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            movimientos++;
            
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;

            grafica[perso.getPosicionColumna() + 1][perso.getPosicionFila()].setIcon(getImagen(7));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            perso.setPosicionColumna(perso.getPosicionColumna() + 1);
            
            lastMoveBoxes = false;
            lastMoveBox = false;
            VC = false;
        } 
        else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 3] == 2)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] = 1;       //caja de otro color
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 3] = 5;

            grafica[perso.getPosicionColumna() + 1][perso.getPosicionFila()].setIcon(getImagen(7));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() + 2][perso.getPosicionFila()].setIcon(getImagen(1));
            grafica[perso.getPosicionColumna() + 3][perso.getPosicionFila()].setIcon(getImagen(5));
            perso.setPosicionColumna(perso.getPosicionColumna() + 1);


            movimientos++;
            

            
            Cajas nueva = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna());
            listMovCajas2.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna()+1);

            cajasSueltas2.add(suelta);
            Cajas nueva2 = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna()+1);
            listMovCajas2.add(nueva2);
            Cajas suelta2 = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna()+2);
            cajasSueltas2.add(suelta2);
            lastMoveBoxes = true;
            VC = true;
            lastMoveBox = false;

        } else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 5)&&(mat[perso.getPosicionFila()][perso.getPosicionColumna() + 3] != 0)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] = 1;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 3] = 1;

            grafica[perso.getPosicionColumna() + 1][perso.getPosicionFila()].setIcon(getImagen(7));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() + 2][perso.getPosicionFila()].setIcon(getImagen(1));
            grafica[perso.getPosicionColumna() + 3][perso.getPosicionFila()].setIcon(getImagen(1));
            perso.setPosicionColumna(perso.getPosicionColumna() + 1);


            movimientos++;
            

            
            Cajas nueva = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna());
            listMovCajas2.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna()+1);

            cajasSueltas2.add(suelta);
            Cajas nueva2 = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna()+1);
            listMovCajas2.add(nueva2);
            Cajas suelta2 = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna()+2);
            cajasSueltas2.add(suelta2);
            lastMoveBoxes = true;
            VC = true;
            lastMoveBox = false;
            }
        
        //mover caja
        else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] == 2)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] = 5;       //caja llego al destino

            grafica[perso.getPosicionColumna() + 1][perso.getPosicionFila()].setIcon(getImagen(7));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() + 2][perso.getPosicionFila()].setIcon(getImagen(5)); //caja de otro color
            perso.setPosicionColumna(perso.getPosicionColumna() + 1);

            movimientos++;
            
            Cajas nueva = new Cajas(perso.getPosicionFila(), perso.getPosicionColumna());
            listMovCajas.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna()+1);
            cajasSueltas.add(suelta);
            lastMoveBox = true;
            VC = true;
            lastMoveBoxes = false;

        } else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 1)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] = 1;

            grafica[perso.getPosicionColumna() + 1][perso.getPosicionFila()].setIcon(getImagen(7));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() + 2][perso.getPosicionFila()].setIcon(getImagen(1));
            perso.setPosicionColumna(perso.getPosicionColumna() + 1);

            movimientos++;
            
            Cajas nueva = new Cajas(perso.getPosicionFila(), perso.getPosicionColumna());
            listMovCajas.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna()+1);
            cajasSueltas.add(suelta);
            lastMoveBox = true;
            VC = true;
            lastMoveBoxes = false;
        }

        
        moves.setText(String.valueOf(movimientos));
        determinarGane();
    }

    public void moverArriba2() {
        int a;
        a = mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()];
        Personaje nuevo = new Personaje(perso.getPosicionFila(), perso.getPosicionColumna());

        if ((a != 1) && (a != 0) && (a != 2) && (a != 5)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;

            movimientos++;
            
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 1].setIcon(getImagen(6));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            perso.setPosicionFila(perso.getPosicionFila() - 1);

            lastMoveBoxes = false;
            lastMoveBox = false;
            VC = false;
        }
        //    
         else if ((a == 1) && (mat[perso.getPosicionFila()-2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila()-2][perso.getPosicionColumna()] == 1) && (mat[perso.getPosicionFila()-3][perso.getPosicionColumna() ] == 2)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] = 1;
            mat[perso.getPosicionFila() - 3][perso.getPosicionColumna()] = 5;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 1].setIcon(getImagen(6));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 2].setIcon(getImagen(1));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 3].setIcon(getImagen(5));


            movimientos++;
            

            perso.setPosicionFila(perso.getPosicionFila() - 1); 
            
            Cajas nueva = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna());
            listMovCajas2.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila()-1,perso.getPosicionColumna());

            cajasSueltas2.add(suelta);
            Cajas nueva2 = new Cajas(perso.getPosicionFila()-1,perso.getPosicionColumna());
            listMovCajas2.add(nueva2);
            Cajas suelta2 = new Cajas(perso.getPosicionFila()-2,perso.getPosicionColumna());
            cajasSueltas2.add(suelta2);
            lastMoveBoxes = true;
            VC = true;
            lastMoveBox = false;

        } //  
        else if ((a == 1) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] == 1) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] != 5)&&(mat[perso.getPosicionFila() - 3][perso.getPosicionColumna()] != 0)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] = 1;
            mat[perso.getPosicionFila() - 3][perso.getPosicionColumna()] = 1;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 1].setIcon(getImagen(6));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 2].setIcon(getImagen(1));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 3].setIcon(getImagen(1));


            movimientos++;
            
 
            perso.setPosicionFila(perso.getPosicionFila() - 1);  
            
            Cajas nueva = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna());
            listMovCajas2.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila()-1,perso.getPosicionColumna());

            cajasSueltas2.add(suelta);
            Cajas nueva2 = new Cajas(perso.getPosicionFila()-1,perso.getPosicionColumna());
            listMovCajas2.add(nueva2);
            Cajas suelta2 = new Cajas(perso.getPosicionFila()-2,perso.getPosicionColumna());
            cajasSueltas2.add(suelta2);
            lastMoveBoxes = true;
            VC = true;
            lastMoveBox = false;
        
        }
        // 
        else if ((a == 1) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] != 1) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] == 2)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] = 5;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 1].setIcon(getImagen(6));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 2].setIcon(getImagen(5));
            perso.setPosicionFila(perso.getPosicionFila() - 1);

            movimientos++;
            
            Cajas nueva = new Cajas(perso.getPosicionFila(), perso.getPosicionColumna());
            listMovCajas.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila()-1,perso.getPosicionColumna());
            cajasSueltas.add(suelta);
            lastMoveBox = true;
            VC = true;
            lastMoveBoxes = false;
            
        } else if ((a == 1) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] != 1)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] = 1;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 1].setIcon(getImagen(6));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 2].setIcon(getImagen(1));
            perso.setPosicionFila(perso.getPosicionFila() - 1);

            movimientos++;
            
            Cajas nueva = new Cajas(perso.getPosicionFila(), perso.getPosicionColumna());
            listMovCajas.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila()-1,perso.getPosicionColumna());
            cajasSueltas.add(suelta);
            lastMoveBox = true;
            VC = true;
            lastMoveBoxes = false;

        }

       
        moves.setText(String.valueOf(movimientos));
        determinarGane();
    }

    public void moverAbajo2() {
        int a;
        a = mat[perso.getPosicionFila() + 1][perso.getPosicionColumna()];
        Personaje nuevo = new Personaje(perso.getPosicionFila(), perso.getPosicionColumna());

        if ((a != 1) && (a != 0) && (a != 2) && (a != 5)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila() + 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;

            movimientos++;
            
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            perso.setPosicionFila(perso.getPosicionFila() + 1);

            lastMoveBoxes = false;
            lastMoveBox = false;
            VC = false;
        } 
        
         else if ((a == 1) && (mat[perso.getPosicionFila()+2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila()+2][perso.getPosicionColumna()] == 1) && (mat[perso.getPosicionFila()+3][perso.getPosicionColumna() ] == 2)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila() + 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] = 1;
            mat[perso.getPosicionFila() + 3][perso.getPosicionColumna()] = 5;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 2].setIcon(getImagen(1));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 3].setIcon(getImagen(5));
            perso.setPosicionFila(perso.getPosicionFila() + 1);


            movimientos++;
            

            
            Cajas nueva = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna());
            listMovCajas2.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila()+1,perso.getPosicionColumna());

            cajasSueltas2.add(suelta);
            Cajas nueva2 = new Cajas(perso.getPosicionFila()+1,perso.getPosicionColumna());
            listMovCajas2.add(nueva2);
            Cajas suelta2 = new Cajas(perso.getPosicionFila()+2,perso.getPosicionColumna());
            cajasSueltas2.add(suelta2);
            lastMoveBoxes = true;
            VC = true;
            lastMoveBox = false;


        } //  
        else if ((a == 1) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] == 1) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] != 5)&&(mat[perso.getPosicionFila() + 3][perso.getPosicionColumna()] != 0)) {

            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila() + 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] = 1;
            mat[perso.getPosicionFila() + 3][perso.getPosicionColumna()] = 1;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));


            movimientos++;
            

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() +2].setIcon(getImagen(1));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() +3].setIcon(getImagen(1));
            perso.setPosicionFila(perso.getPosicionFila() + 1);  
            
            Cajas nueva = new Cajas(perso.getPosicionFila(),perso.getPosicionColumna());
            listMovCajas2.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila()+1,perso.getPosicionColumna());

            cajasSueltas2.add(suelta);
            Cajas nueva2 = new Cajas(perso.getPosicionFila()+1,perso.getPosicionColumna());
            listMovCajas2.add(nueva2);
            Cajas suelta2 = new Cajas(perso.getPosicionFila()+2,perso.getPosicionColumna());
            cajasSueltas2.add(suelta2);
            lastMoveBoxes = true;
            VC = true;
            lastMoveBox = false;
        }
        // 
        else if ((a == 1) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] != 1) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] == 2)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila() + 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] = 5;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 2].setIcon(getImagen(5));
            perso.setPosicionFila(perso.getPosicionFila() + 1);

            movimientos++;
            
            Cajas nueva = new Cajas(perso.getPosicionFila(), perso.getPosicionColumna());
            listMovCajas.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila()+1,perso.getPosicionColumna());
            cajasSueltas.add(suelta);
            lastMoveBox = true;
            VC = true;
            lastMoveBoxes = false;

        } else if ((a == 1) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] != 1)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila() + 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] = 1;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 2].setIcon(getImagen(1));
            perso.setPosicionFila(perso.getPosicionFila() + 1);

            movimientos++;
            
            Cajas nueva = new Cajas(perso.getPosicionFila(), perso.getPosicionColumna());
            listMovCajas.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila()+1,perso.getPosicionColumna());
            cajasSueltas.add(suelta);
            lastMoveBox = true;
            VC = true;
            lastMoveBoxes = false;

        }

       
        moves.setText(String.valueOf(movimientos));
        determinarGane();
    }


    private void reiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reiniciarActionPerformed
        reset();
    }                                         

    public void reset(){  
        boolean ya;
        Historial rec;
        ya=yaEstaHistorial();
        if (ya==true){
        
            rec=traerHistorial();
            rec.setVecesJugado();
            
            
            }
        
        else  {
            
        nuevo.setVecesJugado();     //se aumenta la cantidad de veces que lo jugo
           
              }
        mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4; //se borra el personaje de la posicion donde se encuentre, en las dos matrices
        grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
        perso.setPosicionFila(perso.getIniPosicionFila());  //se vuelve a colocar el personaje en la posicion inicial
        perso.setPosicionColumna(perso.getIniPosicionColumna());
        grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(perso.getId()));
        for (int i = 0; i < mat.length; i++) {      //se hace que el juego tenga una lista de cajas

            for (int x = 0; x < mat[i].length; x++) { // forma de recorrer la matriz  

                if (mat[i][x] == 1) {        //represenacion de la caja en matriz logica
                    mat[i][x] = 4;
                    grafica[x][i].setIcon(getImagen(4));
                } else if (mat[i][x] == 5) {
                    mat[i][x] = 2;
                    grafica[x][i].setIcon(getImagen(2));
                }

            }

        for (int u = 0; u < box.size();u++){
            mat[box.get(u).getIniPosicionFila()][box.get(u).getIniPosicionColumna()] = 1;
            grafica[box.get(u).getIniPosicionColumna()][box.get(u).getIniPosicionFila()].setIcon(getImagen(1));
        }
        movimientos = 0;    //los movimientos vuelven a cero
        moves.setText(String.valueOf(movimientos));
        ProyectoOOP.z = 0;
        }
    }//GEN-LAST:event_reiniciarActionPerformed


    public void moverAbajo() {
        int a;
        a = mat[perso.getPosicionFila() + 1][perso.getPosicionColumna()];
        Personaje nuevo = new Personaje(perso.getPosicionFila(), perso.getPosicionColumna());

        if ((a != 1) && (a != 0) && (a != 2) && (a != 5)) {
            /*perso.setUltimaPosFila(perso.getPosicionFila());
            perso.setUltimaPosColumna(perso.getPosicionColumna());*/

            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila() + 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;

            movimientos++;
            
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            perso.setPosicionFila(perso.getPosicionFila() + 1);
            lastMoveBox = false;
            VC = false;

        } else if ((a == 1) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] != 1) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] == 2)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila() + 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] = 5;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 2].setIcon(getImagen(5));
            perso.setPosicionFila(perso.getPosicionFila() + 1);

            movimientos++;
            
            Cajas nueva = new Cajas(perso.getPosicionFila(), perso.getPosicionColumna());
            listMovCajas.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila() + 1, perso.getPosicionColumna());
            cajasSueltas.add(suelta);
            lastMoveBox = true;
            VC = true;

        } else if ((a == 1) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] != 1)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila() + 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() + 2][perso.getPosicionColumna()] = 1;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 1].setIcon(getImagen(perso.getId()));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() + 2].setIcon(getImagen(1));
            perso.setPosicionFila(perso.getPosicionFila() + 1);

            movimientos++;
            
            Cajas nueva = new Cajas(perso.getPosicionFila(), perso.getPosicionColumna());
            listMovCajas.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila() + 1, perso.getPosicionColumna());
            cajasSueltas.add(suelta);
            lastMoveBox = true;
            VC = true;
        }

        
        moves.setText(String.valueOf(movimientos));
        determinarGane();
    }

    public void moverArriba() {
        int a;
        a = mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()];
        Personaje nuevo = new Personaje(perso.getPosicionFila(), perso.getPosicionColumna());

        if ((a != 1) && (a != 0) && (a != 2) && (a != 5)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;

            movimientos++;
            
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 1].setIcon(getImagen(6));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            perso.setPosicionFila(perso.getPosicionFila() - 1);
            lastMoveBox = false;
            VC = false;

        } else if ((a == 1) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] != 1) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] == 2)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] = 5;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 1].setIcon(getImagen(6));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 2].setIcon(getImagen(5));
            perso.setPosicionFila(perso.getPosicionFila() - 1);

            movimientos++;
            
            Cajas nueva = new Cajas(perso.getPosicionFila(), perso.getPosicionColumna());
            listMovCajas.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila() - 1, perso.getPosicionColumna());
            cajasSueltas.add(suelta);
            lastMoveBox = true;
            VC = true;

        } else if ((a == 1) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] != 0) && (mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] != 1)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila() - 1][perso.getPosicionColumna()] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila() - 2][perso.getPosicionColumna()] = 1;

            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 1].setIcon(getImagen(6));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila() - 2].setIcon(getImagen(1));
            perso.setPosicionFila(perso.getPosicionFila() - 1);

            movimientos++;
            
            Cajas nueva = new Cajas(perso.getPosicionFila(), perso.getPosicionColumna());
            listMovCajas.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila() - 1, perso.getPosicionColumna());
            cajasSueltas.add(suelta);
            lastMoveBox = true;
            VC = true;
        }

      
        moves.setText(String.valueOf(movimientos));
        determinarGane();
    }

    public void moverDerecha() {
        int a;
        a = mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1];
        Personaje nuevo = new Personaje(perso.getPosicionFila(), perso.getPosicionColumna());

        if ((a != 1) && (a != 0) && (a != 2) && (a != 5)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;

            movimientos++;
            
            grafica[perso.getPosicionColumna() + 1][perso.getPosicionFila()].setIcon(getImagen(7));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            perso.setPosicionColumna(perso.getPosicionColumna() + 1);
            lastMoveBox = false;
            VC = false;
        } //mover caja
        else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] == 2)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] = 5;       //caja llego al destino

            grafica[perso.getPosicionColumna() + 1][perso.getPosicionFila()].setIcon(getImagen(7));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() + 2][perso.getPosicionFila()].setIcon(getImagen(5)); //caja de otro color
            perso.setPosicionColumna(perso.getPosicionColumna() + 1);

            movimientos++;
            
            Cajas nueva = new Cajas(perso.getPosicionFila(), perso.getPosicionColumna());
            listMovCajas.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila(), perso.getPosicionColumna() + 1);
            cajasSueltas.add(suelta);
            lastMoveBox = true;
            VC = true;

        } else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] != 1)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() + 2] = 1;

            grafica[perso.getPosicionColumna() + 1][perso.getPosicionFila()].setIcon(getImagen(7));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() + 2][perso.getPosicionFila()].setIcon(getImagen(1));
            perso.setPosicionColumna(perso.getPosicionColumna() + 1);

            movimientos++;
            
            Cajas nueva = new Cajas(perso.getPosicionFila(), perso.getPosicionColumna());
            listMovCajas.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila(), perso.getPosicionColumna() + 1);
            cajasSueltas.add(suelta);
            lastMoveBox = true;
            VC = true;
        }

       
        moves.setText(String.valueOf(movimientos));
        determinarGane();
    }

    public void moverIzquierda() {
        int a;
        int b = perso.getPosicionFila();
        int c = perso.getPosicionColumna();
        a = mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1];
        Personaje nuevo = new Personaje(perso.getPosicionFila(), perso.getPosicionColumna());

        if ((a != 1) && (a != 0) && (a != 2) && (a != 5)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;

            movimientos++;
            
            grafica[perso.getPosicionColumna() - 1][perso.getPosicionFila()].setIcon(getImagen(8));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            perso.setPosicionColumna(perso.getPosicionColumna() - 1);
            lastMoveBox = false;
            VC = false;
        } //mover caja
        else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] == 2)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] = 5;       //caja de otro color

            grafica[perso.getPosicionColumna() - 1][perso.getPosicionFila()].setIcon(getImagen(8));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() - 2][perso.getPosicionFila()].setIcon(getImagen(5));
            perso.setPosicionColumna(perso.getPosicionColumna() - 1);

            movimientos++;
            
            Cajas nueva = new Cajas(perso.getPosicionFila(), perso.getPosicionColumna());
            listMovCajas.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila(), perso.getPosicionColumna() - 1);
            cajasSueltas.add(suelta);
            lastMoveBox = true;
            VC = true;

        } else if ((a == 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 0) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 1) && (mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] != 5)) {
            listMovPer.add(nuevo);
            listMovPer.add(nuevo);

            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 1] = perso.getId();
            mat[perso.getPosicionFila()][perso.getPosicionColumna()] = 4;
            mat[perso.getPosicionFila()][perso.getPosicionColumna() - 2] = 1;

            grafica[perso.getPosicionColumna() - 1][perso.getPosicionFila()].setIcon(getImagen(8));
            grafica[perso.getPosicionColumna()][perso.getPosicionFila()].setIcon(getImagen(4));
            grafica[perso.getPosicionColumna() - 2][perso.getPosicionFila()].setIcon(getImagen(1));
            perso.setPosicionColumna(perso.getPosicionColumna() - 1);

            movimientos++;
            
            Cajas nueva = new Cajas(perso.getPosicionFila(), perso.getPosicionColumna());
            listMovCajas.add(nueva);
            Cajas suelta = new Cajas(perso.getPosicionFila(), perso.getPosicionColumna() - 1);
            cajasSueltas.add(suelta);
            lastMoveBox = true;
            VC = true;
        }

     
        moves.setText(String.valueOf(movimientos));
        determinarGane();

    }

    public ImageIcon getImagen(int num) {

        switch (num) {

            case 0:
                return new ImageIcon(getClass().getResource("/ImagenesUsuario/wall2.fw.png"));

            case 1:
                return new ImageIcon(getClass().getResource("/ImagenesUsuario/cofre.fw.png"));

            case 2:
                return new ImageIcon(getClass().getResource("/ImagenesUsuario/rupia.fw.png"));

            case 3:
                return new ImageIcon(getClass().getResource("/ImagenesUsuario/link.fw.png"));

            case 5:
                return new ImageIcon(getClass().getResource("/ImagenesUsuario/cofre2.fw.png"));

            case 6:
                return new ImageIcon(getClass().getResource("/ImagenesUsuario/linkarriba.fw.png"));

            case 7:
                return new ImageIcon(getClass().getResource("/ImagenesUsuario/linkderecha.fw.png"));

            case 8:
                return new ImageIcon(getClass().getResource("/ImagenesUsuario/linkizq.fw.png"));

            default:
                return new ImageIcon(getClass().getResource("/ImagenesUsuario/piso.fw.png"));

        }

    }   
    
    public boolean yaEstaHistorial(){
    ArrayList<Historial> lista;
    lista=uno.getArrayHistorial();  //recorrer el historial del jugador
    Historial recuento;
    for (int i=0;i<lista.size();i++){       //ciclo para ver si ya existe un historial de este nivel
            recuento=lista.get(i);
            if (recuento.getNumNivel()==niv){
                return true;                //se marca como que ya lo jugo
                
            }
        }
    
    return false;
    }
    
    //funcion que retorna el historial
    public Historial traerHistorial(){
    ArrayList<Historial> lista;
    lista=uno.getArrayHistorial();  //recorrer el historial del jugador
    Historial recuento = null;
    for (int i=0;i<lista.size();i++){       //ciclo para ver si ya existe un historial de este nivel
            recuento=lista.get(i);
            if (recuento.getNumNivel()==niv){
                break;              //se marca como que ya lo jugo
                
            }
        }
    
    return recuento;
    }
    
    
    //datos para hacer el historial del jugador
    public void setHistorial() {
        
        
        Historial rec;      //variable para cambiar los valores al historial
        int mov = Integer.parseInt(moves.getText());
        boolean ya=false;       //para saber si esta en el historial
        
        int time = cron.getTotalSegundos();
        String condicion = null;
        
        ya=yaEstaHistorial();   //true si el historial ya esta
        
        if (ya==true){
       
        if (mov > jugando.getBestMoves()) {
            condicion = "Ganado";

        } 
        
        else if(mov<jugando.getBestMoves()){    //si rompió un record           
            uno.setBestMoves(uno.getBestMoves()+1); //aumentarle los record rotos por el usuario
            programa.cambiarNivelesOptimizados(niv);  //los jugadores que lo ganaron optimizado ahora lo ganaron normal
            Estadistica e=uno.getEstadistica();
            e.setCanGanesOptimizados();
            e.setRecordRotos();     //se aumenta contador de record rotos
            programa.nuevoRecord(mov, niv);
            condicion="Optimizado";
        
        }
        
        else {
            condicion = "Optimizado";
            Estadistica e=uno.getEstadistica();
            e.setCanGanesOptimizados();
            
        }
        
        rec=traerHistorial();       //se manda a traer el historial
        // se hace el historial
        //Historial nuevo=new Historial(jugando.getNumNivel(),jugando,condicion,mov,time,jugando.getBestMoves());
        rec.setNumNivel(jugando.getNumNivel());
        rec.setNivel(jugando);    //referencia al nivel jugado
        rec.setEstado(condicion);
        rec.setCantidadMovimientos(mov);
        rec.setTiempo(time);
        rec.setBestMoves(jugando.getBestMoves());
        rec.setVecesJugado();
        
        //uno.setArrayHistorial(nuevo);   //se agrega el historial al jugador
        }
        
        else{
              Estadistica e;
              e=uno.getEstadistica();
              
        if (mov > jugando.getBestMoves()) {
            condicion = "Ganado";
            e.setCantNivelesJugados();
        } 
        else if(mov<jugando.getBestMoves()){    //si rompió un record           
            uno.setBestMoves(uno.getBestMoves()+1); //aumentarle los record rotos por el usuario
            programa.cambiarNivelesOptimizados(niv);  //los jugadores que lo ganaron optimizado ahora lo ganaron normal
            e.setCantNivelesJugados();
            e.setCanGanesOptimizados();
            e.setRecordRotos();     //se aumenta contador de record rotos
            condicion="Optimizado";
            programa.nuevoRecord(mov, niv); //se hace el cambio a los bestmoves de nivel si se rompe
                                            //un record
        }
        
        else {
            condicion = "Optimizado";
            e.setCantNivelesJugados();
            e.setCanGanesOptimizados();
        }

        // se hace el historial
        //Historial nuevo=new Historial(jugando.getNumNivel(),jugando,condicion,mov,time,jugando.getBestMoves());
        nuevo.setNumNivel(jugando.getNumNivel());
        nuevo.setNivel(jugando);    //referencia al nivel jugado
        nuevo.setEstado(condicion);
        nuevo.setCantidadMovimientos(mov);
        nuevo.setTiempo(time);
        nuevo.setBestMoves(jugando.getBestMoves());
        nuevo.setVecesJugado();
        uno.setArrayHistorial(nuevo);   //se agrega el historial al jugador
            
            
            }
        
        if (level.size() > uno.getNivelActual()) {

            uno.setNivelActual(uno.getNivelActual() + 1);     //se actualiza el nivel actual del jugador si existen más
            pasar = true;     //habilitar boton de siguiente nivel
            siguiente.setFocusable(pasar);
            
        }
        
        else{
            fin=true;   //no permite cargar otro nivel
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

    public static void Musica(String soundFile) throws LineUnavailableException, IOException, UnsupportedAudioFileException {
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
                try {
                    new game().setVisible(true);
                } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
                    Logger.getLogger(game.class.getName()).log(Level.SEVERE, null, ex);
                }
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
    private javax.swing.JLabel persona;
    private javax.swing.JButton reiniciar;
    private javax.swing.JButton siguiente;
    private javax.swing.JLabel tiempo;
    // End of variables declaration//GEN-END:variables

}
