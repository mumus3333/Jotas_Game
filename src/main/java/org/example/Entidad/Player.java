package org.example.Entidad;

import org.example.AccionTeclas;
import org.example.GamePanel;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Player extends Entity{

    GamePanel gp;
    AccionTeclas keyH;

    private long lastUpdateTime = System.nanoTime(); 

    private final long animationInterval = 200_000_000L;

    public final int screenX;
    public final int screenY;

    public Player (GamePanel gp, AccionTeclas keyH){
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 - (gp.tileSize/2);

        solidArea = new Rectangle();
        solidArea.x =8;
        solidArea.y =16;
        solidArea.width = 32;
        solidArea.height = 32;

        
        SetDefaultValues();
        getPlayerImage();
    }

    public void SetDefaultValues(){
        worldX = gp.tileSize *23;
        worldY = gp.tileSize * 21;
        speed = 2;
        direction = "down";
    }

    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/0.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/1.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/2.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/3.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/4.png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/5.png"));
    
            down1 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/6.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/7.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/8.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/9.png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/10.png"));
            down6 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/11.png"));
    
            left1 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/12.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/13.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/14.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/15.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/16.png"));
            left6 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/17.png"));
    
            right1 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/18.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/19.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/20.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/21.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/22.png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/org/example/res/player/23.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void update() {

    if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true ||
    keyH.rightPressed == true){

        if (keyH.upPressed) {
            direction = "up";
        
        } else if (keyH.downPressed) {
            direction = "down";
            
        } else if (keyH.leftPressed) {
            direction = "left";
            
        } else if (keyH.rightPressed) {
            direction = "right";
        
        }

        collisionOn = false;
        gp.cCheker.checkTile(this);

        if(collisionOn == false){

            switch (direction) {
                case "up":
                worldY -= speed;
                    break;
                case "down":
                worldY += speed;
                    break; 
                case "left":
                worldX -= speed; 
                    break; 
                case "right":
                     worldX += speed;
                    break;   
            
                default:
                    break;
            }

        }

        spriteCounter++;
        if(spriteCounter > 24){
            if(spriteNum == 1){
                spriteNum = 2;
            }
            else if(spriteNum ==2){
                spriteNum = 1;
            }
            spriteCounter =0;
        }

    }
  
    
    


       /* long now = System.nanoTime();
        long elapsedTime = now - lastUpdateTime;
    
       
        if (elapsedTime > animationInterval && (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed)) {
            spriteNum++;
            if (spriteNum > 6) {
                spriteNum = 1;
            }
            lastUpdateTime = now; 
        }
    
        if (keyH.upPressed) {
            direction = "up";
        
        } else if (keyH.downPressed) {
            direction = "down";
            
        } else if (keyH.leftPressed) {
            direction = "left";
            
        } else if (keyH.rightPressed) {
            direction = "right";
        
        }

        collisionOn = false;
        gp.cCheker.checkTile(this);

        if(collisionOn == false){

            switch (direction) {
                case "up":
                worldY -= speed;
                    break;
                case "down":
                worldY += speed;
                    break; 
                case "left":
                worldX -= speed; 
                    break; 
                case "right":
                     worldX += speed;
                    break;   
            
                default:
                    break;
            }

        }
    
    }
        

    */

    }
    
    public void draw(Graphics2D g2){
       BufferedImage image = null;

       switch (direction) {
        case "up" :

        if(spriteNum == 1){
            image = up1;
        }
        if(spriteNum == 2){
            image = up2;
        }
        if(spriteNum == 3){
            image = up3;
        }
        if(spriteNum == 4){
            image = up4;
        }
        if(spriteNum == 5){
            image = up5;
        }
        if(spriteNum == 6){
            image = up6;
        }
        
            break;
        case "down":
        if(spriteNum == 1){
            image = down1;
        }
        if(spriteNum == 2){
            image = down2;
        }
        if(spriteNum == 3){
            image = down3;
        }
        if(spriteNum == 4){
            image = down4;
        }
        if(spriteNum == 5){
            image = down5;
        }
        if(spriteNum == 6){
            image = down6;
        }
            break;
        case "left":
        if(spriteNum == 1){
            image = left1;
        }
        if(spriteNum == 2){
            image = left2;
        }
        if(spriteNum == 3){
            image = left3;
        }
        if(spriteNum == 4){
            image = left4;
        }
        if(spriteNum == 5){
            image = left5;
        }
        if(spriteNum == 6){
            image = left6;
        }
            break;    
        case "right":
        if(spriteNum == 1){
            image = right1;
        }
        if(spriteNum == 2){
            image = right2;
        }
        if(spriteNum == 3){
            image = right3;
        }
        if(spriteNum == 4){
            image = right4;
        }
        if(spriteNum == 5){
            image = right5;
        }
        if(spriteNum == 6){
            image = right6;
        }
            break;
        default:
            break;
       }

       g2.drawImage(image,screenX,screenY, gp.tileSize, gp.tileSize, null);

    } 

}
