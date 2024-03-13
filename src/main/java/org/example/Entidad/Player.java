package org.example.Entidad;

import org.example.AccionTeclas;
import org.example.GamePanel;

import java.awt.*;
import java.awt.event.KeyListener;

public class Player extends Entity{

    GamePanel gp;
    AccionTeclas keyH;

    public Player (GamePanel gp, AccionTeclas keyH){
        this.gp = gp;
        this.keyH = keyH;
        SetDefaultValues();
    }

    public void SetDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
    }

    public void update() {

        if(keyH.upPressed == true){
            y -= speed;
        } else if (keyH.downPressed==true) {
            y += speed;
        } else if (keyH.leftPressed==true) {
            x -= speed;
        } else if (keyH.rightPressed==true) {
            x += speed;
        }

    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillRect(x,y, gp.tileSize, gp.tileSize);
    }

}
