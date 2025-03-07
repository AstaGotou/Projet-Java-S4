package entite;
import main.GamePanel;
import main.Son;

import java.awt.*;

public class Monstre extends Entite{
    protected String nom;
    Son s1 = new Son();
    GamePanel gp;
    protected int degats;
    protected int rangeAggro;
    public String getNom(){
        return nom;
    }
    public int getDegats(){
        return degats;
    }
    public void draw(Graphics2D g2, GamePanel gp){
        if (invulerable){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
        }
        g2.drawImage(up, p.getX(), p.getY(), gp.tileSize, gp.tileSize, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }

    public void update(Entite e){
        collisionLeftOn = false;
        collisionRightOn = false;
        collisionTopOn = false;
        collisionBottomOn = false;
        int objIndex = gp.gestionCollision.checkItem(this);
        gp.gestionCollision.checkBloc(this);
        gp.gestionCollision.checkMonster2(this);

        if (Math.sqrt(Math.pow(e.getP().getX() - p.getX(), 2) + Math.pow(e.getP().getY() - p.getY(), 2)) < rangeAggro){
            if (!collisionLeftOn) {
                if (e.getP().getX() - p.getX() < 1) {
                    hitbox.setLocation(hitbox.x - speed, hitbox.y);
                    p.addX(-speed);
                }
            }
            if (!collisionRightOn) {
                if (e.getP().getX()-p.getX() > 1){
                    hitbox.setLocation(hitbox.x + speed, hitbox.y);
                    p.addX(speed);
                }
            }

            if (!collisionTopOn) {
                if (e.getP().getY() - p.getY() < 1) {
                    hitbox.setLocation(hitbox.x, hitbox.y - speed);
                    p.addY(-speed);
                }
            }
            if (!collisionBottomOn) {
                if (e.getP().getY() - p.getY() > 1) {
                    hitbox.setLocation(hitbox.x, hitbox.y + speed);
                    p.addY(speed);
                }
            }
        }
        if (invulerable){
            if (invulnerable_compteur == 0){
                s1.setFile(6);
                s1.jouer();
            }
            invulnerable_compteur++;
            if (invulnerable_compteur > 60){
                invulerable = false;
                invulnerable_compteur = 0;
            }
        }
    }
}
