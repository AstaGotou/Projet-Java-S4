package entite;

import caracteristique.Position;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
public abstract class Entite {
    protected Position p;
    protected int speed;
    protected int point_de_vie;
    protected int MAX_PV;
    protected boolean invulerable = false;
    protected int invulnerable_compteur;

    protected BufferedImage up, down, left, right, attackUp, attackDown, attackLeft, attackRight;
    protected String direction;

    protected Rectangle hitbox; // zone d'impact, càd la zone qui englobe l'entité physiquement (pas visuellement)
    
    protected boolean collisionLeftOn = false;
    protected boolean collisionRightOn = false;
    protected boolean collisionTopOn = false;
    protected boolean collisionBottomOn = false;

    public Position getP() {
        return p;
    }
    public int getSpeed() {
        return speed;
    }
    public int getPoint_de_vie() {
        return point_de_vie;
    }
    public void setPoint_de_vie(int point_de_vie) {
        this.point_de_vie = point_de_vie;
    }
    public void setInvulerable(boolean invulerable) {
        this.invulerable = invulerable;
    }
    public boolean getInvulerable() {
        return invulerable;
    }

    public void setCollisionLeftOn(boolean collisionOn) {
        this.collisionLeftOn = collisionOn;
    }
    public void setCollisionRightOn(boolean collisionOn) {
        this.collisionRightOn = collisionOn;
    }
    public void setCollisionTopOn(boolean collisionOn) {
        this.collisionTopOn = collisionOn;
    }
    public void setCollisionBottomOn(boolean collisionOn) {
        this.collisionBottomOn = collisionOn;
    }

    public Rectangle getHitbox(){
        return hitbox;
    }
    public int getMAX_PV(){
        return MAX_PV;
    }
    public BufferedImage getDown() {
        return down;
    }
}
