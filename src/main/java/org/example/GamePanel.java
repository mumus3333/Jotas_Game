package org.example;

import org.example.Entidad.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    //Configuraciones de pantalla

    final int originalTileSize = 16; // 16 x 16 cuadros
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; //48 x 48 cuadros

    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int  screenWidth = tileSize * maxScreenCol; //768 pixeles
    final int  screenHeight = tileSize * maxScreenRow; //576 pixeles

    //FPS
    int FPS = 60;

    Thread gameThread;
    AccionTeclas keyH = new AccionTeclas();

    Player player = new Player(this,keyH);

    //Posición por default del personaje

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }



    @Override
    public void run() {

        double drawInterval = 1000000000/FPS; //0.01666 segundos
        double delta  =0;
        long lastTime = System.nanoTime();
        long currenTime;
        long timer =0;
        int drawCount=0;

        while(gameThread!=null){
            currenTime = System.nanoTime();
            delta +=(currenTime-lastTime)/drawInterval;
            timer += (currenTime - lastTime);
            lastTime = currenTime;

            if(delta>=1){
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if(timer>= 1000000000){
                System.out.println("FPS: " + drawCount);
                drawCount =0;
                timer =0;
            }
        }



    }

    public void update() {

     player.update();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        player.draw(g2);
        g2.dispose();

    }
}
