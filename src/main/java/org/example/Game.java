package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel {
    private static final int BOXSIZE = 40;
    private static final int WIDTH = 937;
    private static final int HEIGHT = 880;

    Player player = new Player(this);
    private final String[][] MAPA = {
            {"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"},
            {"X","O","O","O","O","O","O","O","O","O","O","X","O","O","O","O","O","O","O","O","O","O","X"},
            {"X","","X","X","X","","X","X","X","","","X","","","X","X","X","","X","X","X","","X"},
            {"X","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","X"},
            {"X","","X","X","X","","X","","X","X","X","X","X","X","X","","X","","X","X","X","","X"},                    //5
            {"X","O","O","O","O","O","X","O","O","O","O","X","O","O","O","O","X","O","O","O","O","O","X"},
            {"X","X","X","X","X","","X","X","X","","","X","","","X","X","X","","X","X","X","X","X"},
            {"X","X","X","X","X","","X","O","O","O","O","O","O","O","O","O","X","","X","X","X","X","X"},
            {"X","X","X","X","X","","X","","X","X","","","","X","X","","X","","X","X","X","X","X"},
            {"","","","","","O","O","O","X","","","","","","X","O","O","O","","","","",""},                     //10
            {"X","X","X","X","X","","X","","X","X","X","X","X","X","X","","X","","X","X","X","X","X"},
            {"X","X","X","X","X","O","X","O","O","O","O","","O","O","O","O","X","O","X","X","X","X","X"},
            {"X","X","X","X","X","","X","","X","X","X","X","X","X","X","","X","","X","X","X","X","X",},
            {"X","O","O","O","O","O","O","O","O","O","O","X","O","O","O","O","O","O","O","O","O","O","X"},
            {"X","","X","X","X","","X","X","X","","","X","","","X","X","X","","X","X","X","","X"},                      //15
            {"X","O","O","O","X","O","O","O","O","O","O","","O","O","O","O","O","O","X","O","O","O","X"},
            {"X","X","","","X","","X","","X","X","X","X","X","X","X","","X","","X","","","X","X"},
            {"X","O","O","O","O","O","X","","","","","X","","","","","X","O","O","O","O","O","X"},
            {"X","","X","X","X","X","X","X","X","","","X","","","X","X","X","X","X","X","X","","X"},
            {"X","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","O","X"},
            {"X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X","X"}
    }
            ;

    public Game(){
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.keyReleased(e);
            }
        });
        setFocusable(true);
    }

    public static void main(String[] args) throws InterruptedException  {
        JFrame frame = new JFrame("Pacman");
        Game game = new Game();
        game.setBackground(Color.BLACK);
        frame.add(game);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);                          //Abril la ventana en el medio de la pantalla
        frame.setResizable(false);                                  //No cambiar el tamaño de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       //Al cerrar la ventana se acaba el programa

        while (true){
            game.move();
            game.repaint();
            Thread.sleep(5);
        }

    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        createMap(graphics);
        createPlayer(graphics);
    }

    public void createMap(Graphics2D graphics){
        int columna = 0;
        int fila = 0;

        for (int i=0; i<MAPA.length;i++){
            for (int j=0;j<MAPA[i].length;j++){
                if (MAPA[i][j].equals("X")){
                    graphics.setColor(Color.blue);
                    graphics.drawRect(columna*BOXSIZE,fila*BOXSIZE,BOXSIZE,BOXSIZE);
                }else if (MAPA[i][j].equals("O")){
                    graphics.setColor(Color.red);
                    graphics.fillOval(columna*BOXSIZE+15,fila*BOXSIZE+15,10,10);
                }
                columna ++;
            }
            columna = 0;
            fila ++;
        }
    }

    public void createPlayer(Graphics2D graphics){
        graphics.setColor(Color.yellow);
        player.paint(graphics);
    }

    public void move(){
        player.moveVertical();
        player.moveHorizontal();
    }

}