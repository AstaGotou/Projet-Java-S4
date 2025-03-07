package item;

import caracteristique.Position;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Item {
    protected BufferedImage img;
    protected String nom;
    protected boolean collision = false;
    protected Position p;
    protected Rectangle hitBoxItem;

    public Item(int x, int y){
        p = new Position(x, y);
        hitBoxItem = new Rectangle(x, y, 48, 48);
    }

    public Rectangle getHitBoxItem() {
        return hitBoxItem;
    }
    public boolean getCollision(){
        return collision;
    }
    public String getNom(){
        return nom;
    }
    public BufferedImage getImg() {
        return img;
    }
    public Position getP() {
        return p;
    }

    public void draw(Graphics2D g2, GamePanel gp){
        g2.drawImage(img, p.getX(), p.getY(), gp.tileSize, gp.tileSize, null);
    }
}