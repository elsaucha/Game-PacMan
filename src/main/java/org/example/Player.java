package org.example;

import java.awt.*;

public class Player {
    private static final int DIAMETER = 30;
    private int x;
    private int y;
    Game game;

    public Player(Game game){
        this.game = game;
        initialPosition();
    }

    public void paint(Graphics2D graphics){
        graphics.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public void initialPosition(){
        x = 250;
        y = 250;
    }

}