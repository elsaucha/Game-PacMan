package org.example;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    private static final int DIAMETER = 30;
    private int x;
    private int y;
    private int dx = 0;
    private int dy = 0;
    Game game;

    public Player(Game game){
        this.game = game;
        initialPosition();
    }

    public void paint(Graphics2D graphics){
        graphics.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public void initialPosition(){
        x = 445;
        y = 605;
    }

    public void keyPressed(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP -> {
                dy = -1;
                dx = 0;
            }
            case KeyEvent.VK_DOWN -> {
                dy = 1;
                dx = 0;
            }
            case KeyEvent.VK_LEFT -> {
                dx = -1;
                dy = 0;
            }
            case KeyEvent.VK_RIGHT -> {
                dx = 1;
                dy = 0;
            }
        }
    }

    public void keyReleased(KeyEvent e){
        dx = 0;
        dy = 0;
    }

    public void moveVertical(){
        y = y + dy;
    }

    public void moveHorizontal(){
        x = x + dx;
    }

}