package org.example;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {
    private static final int WIDTH = 759;
    private static final int HEIGHT = 750;

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
            {"","O","O","O","O","O","O","O","X","","","","","","X","O","O","O","O","O","O","O",""},                     //10
            {"X","X","X","X","X","","X","","X","X","X","X","X","X","X","","X","","X","X","X","X","X"},
            {"X","X","X","X","X","O","X","O","O","O","O","O","O","O","O","O","X","O","X","X","X","X","X"},
            {"X","X","X","X","X","","X","","X","X","X","X","X","X","X","","X","","X","X","X","X","X",},
            {"X","O","O","O","O","O","O","O","O","O","O","X","O","O","O","O","O","O","O","O","O","O","X"},

    }
            ;

    //private final int TILE = 30; // tamaño de celda

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


    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        graphics.setColor(Color.yellow);
        player.paint(graphics);

        int posicionX = 0;
        int posicionY = 0;

        for (int i=0; i<MAPA.length;i++){
            for (int j=0;j<MAPA[i].length;j++){
                if (MAPA[i][j].equals("X")){
                    graphics.setColor(Color.blue);
                    graphics.fillRect(posicionX,posicionY,33,25);
                }else if (MAPA[i][j].equals("O")){
                    graphics.setColor(Color.red);
                    graphics.fillOval(posicionX+10,posicionY+6,12,12);
                }
                posicionX += 33;
            }
            posicionX = 0;
            posicionY += 25;
        }
    }

}