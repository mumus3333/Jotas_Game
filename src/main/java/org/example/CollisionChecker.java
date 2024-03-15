package org.example;

import org.example.Entidad.Entity;

public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity entity) {

        int entityLeftWordlx = entity.worldX + entity.solidArea.x;
        int entityRightWorldx = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;

        int entityLeftCol = Math.max(0, entityLeftWordlx / gp.tileSize);
        int entityRightCol = Math.min(gp.tileM.mapTileNum.length - 1, entityRightWorldx / gp.tileSize);
        int entityTopRow = Math.max(0, entityTopWorldY / gp.tileSize);
        int entityBottomRow = Math.min(gp.tileM.mapTileNum[0].length - 1, entityBottomWorldY / gp.tileSize);

        int tileNum1, tileNum2;

        switch (entity.direction) {
            case "up":
                entityTopRow = Math.max(0, (entityTopWorldY - entity.speed) / gp.originalTileSize);
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }
                break;
            case "down":
                entityBottomRow = Math.min(gp.tileM.mapTileNum[0].length - 1, (entityBottomWorldY + entity.speed) / gp.originalTileSize);
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }

                break;
            case "left":
                entityLeftCol = Math.max(0, (entityLeftWordlx - entity.speed) / gp.originalTileSize);
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }

                break;
            case "right":
                entityRightCol = Math.min(gp.tileM.mapTileNum.length - 1, (entityRightWorldx - entity.speed) / gp.originalTileSize);
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if (gp.tileM.tile[tileNum1].collision || gp.tileM.tile[tileNum2].collision) {
                    entity.collisionOn = true;
                }

                break;

            default:
                break;
        }

    }

}
