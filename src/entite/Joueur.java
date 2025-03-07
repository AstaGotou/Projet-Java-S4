package entite;

import item.ClefCoffre;
import main.GamePanel;
import main.KeyHandler;
import caracteristique.Position;
import item.ClefPorte;
import item.Porte;
import item.PorteOuverte;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Joueur extends Entite {
    GamePanel gp;
    KeyHandler keyH;
    protected ClefCoffre clefCoffre;
    protected ClefPorte porteClef[];
    protected boolean isAttacking;
    protected int degats;
    protected int isAttacking_Compteur;
    protected Rectangle attackArea;
    protected boolean lumiere = false;

    public Joueur(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        MAX_PV = 6;
        point_de_vie = MAX_PV;
        p = new Position(2*gp.tileSize, 2*gp.tileSize);
        // il faut que la hitbox soit plus petite qu'une case
        hitbox = new Rectangle(p.getX() + 12, p.getY() + 16, 24, 32);
        speed = 3;
        degats = 2;
        direction = "down";
        porteClef = new ClefPorte[10];
        clefCoffre = null;
        invulerable = false;
        invulnerable_compteur = 0;
        isAttacking = false;
        isAttacking_Compteur = 0;
        lumiere = false;
    }

    public ClefPorte[] getPorteClef(){
        return porteClef;
    }
    public ClefCoffre getClefCoffre(){
        return clefCoffre;
    }
    public Rectangle getAttackArea() {
        return attackArea;
    }
    public boolean getIsAttacking() {
        return isAttacking;
    }
    public boolean getLumiere(){
        return lumiere;
    }

    public void getPlayerImage() {
        try {
            up = ImageIO.read(getClass().getResourceAsStream("/player/Dos_Marmotte.png"));
            down = ImageIO.read(getClass().getResourceAsStream("/player/Face_Marmotte.png"));
            right = ImageIO.read(getClass().getResourceAsStream("/player/Droite_Marmotte.png"));
            left = ImageIO.read(getClass().getResourceAsStream("/player/Gauche_Marmotte.png"));

            attackUp = ImageIO.read(getClass().getResourceAsStream("/player/Attaque_Haut.png"));
            attackDown = ImageIO.read(getClass().getResourceAsStream("/player/Attaque_Bas.png"));
            attackRight = ImageIO.read(getClass().getResourceAsStream("/player/Attaque_Droite.png"));
            attackLeft = ImageIO.read(getClass().getResourceAsStream("/player/Attaque_Gauche.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ramasseItem(int index) {
        if (index != 999) {
            switch (gp.item[index].getNom()) {
                case "coeur":
                    if (point_de_vie < 6) {
                        gp.effetSonor(9);
                        point_de_vie++;
                        if (point_de_vie < 6) {
                            point_de_vie++;
                        }
                    }
                    gp.item[index] = null;
                    break;
                case "Clef_Porte":
                    gp.effetSonor(8);
                    porteClef[((ClefPorte) gp.item[index]).getId()] = (ClefPorte) gp.item[index];
                    gp.item[index] = null;
                    break;

                case "porte":
                    if (porteClef[((Porte) gp.item[index]).getId()] != null) {
                        porteClef[((Porte) gp.item[index]).getId()] = null;
                        gp.effetSonor(7);
                        gp.item[index] = new PorteOuverte(gp.item[index].getP().getX(), gp.item[index].getP().getY());
                    }
                    break;
                case "Clef_Coffre":
                    gp.effetSonor(8);
                    clefCoffre = (ClefCoffre) gp.item[index];
                    gp.item[index] = null;
                    break;

                case "coffre":
                    if (clefCoffre != null) {
                        clefCoffre = null;
                        gp.setEtatJeu(gp.WIN);
                    }
                    break;

                case "SpeedBoost":
                    speed += 1;
                    gp.item[index] = null;
                    break;

                case "Poison":
                    if (!invulerable) {
                        if (point_de_vie >= 2) {
                            point_de_vie -= 2;
                        } else if (point_de_vie == 1) {
                            point_de_vie --;
                        }
                        invulerable = true;
                        gp.item[index] = null;
                    }
                    break;
                case "Ampoule":
                    lumiere = true;
                    gp.item[index] = null;
                    break;

            }

        }
    }

    public void collisionAttackMonster(int index) {
        if (index != 999) {
            if (gp.monstre[index].getPoint_de_vie() > 0 && !gp.monstre[index].getInvulerable()) {
                gp.monstre[index].setPoint_de_vie(gp.monstre[index].getPoint_de_vie() - degats);
                gp.monstre[index].setInvulerable(true);
            }
        }
    }

    public void collisionMonster(int index) {
        if (index != 999) {
            if (point_de_vie > 0 && !invulerable) {
                point_de_vie -= gp.monstre[index].getDegats();
                invulerable = true;
            }
        }
    }

    public void update() {
        if(point_de_vie == 0){
            gp.setEtatJeu(gp.OVER);
        }
        if(!isAttacking) {
            if (keyH.upPressed) {
                direction = "up";
            } else if (keyH.downPressed) {
                direction = "down";
            } else if (keyH.leftPressed) {
                direction = "left";
            } else if (keyH.rightPressed) {
                direction = "right";
            }
        }

        // CHECK COLLISION BLOC :
        collisionLeftOn = false;
        collisionRightOn = false;
        collisionTopOn = false;
        collisionBottomOn = false;
        gp.gestionCollision.checkBloc(this);

        // attaque
        if (keyH.aPressed){
            isAttacking = true;
            switch (direction){
                case "up":
                    attackArea = new Rectangle(p.getX() + gp.tileSize/4, p.getY()-gp.tileSize, gp.tileSize/2 , gp.tileSize);
                    break;
                case "down":
                    attackArea = new Rectangle(p.getX()+ gp.tileSize/4, p.getY()+gp.tileSize, gp.tileSize/2 , gp.tileSize);
                    break;
                case "left":
                    attackArea = new Rectangle(p.getX() - gp.tileSize, p.getY() + gp.tileSize/4, gp.tileSize, gp.tileSize/2);
                    break;
                case "right":
                    attackArea = new Rectangle(p.getX() + gp.tileSize, p.getY() + gp.tileSize/4, gp.tileSize, gp.tileSize/2);
                    break;
            }
        }
        if (isAttacking){
            if(isAttacking_Compteur ==0) {
                gp.effetSonor(5);
            }
            isAttacking_Compteur++;
            if(isAttacking_Compteur > 30){
                isAttacking = false;
                isAttacking_Compteur = 0;
            }
            collisionLeftOn = true;
            collisionRightOn = true;
            collisionTopOn = true;
            collisionBottomOn = true;
        }

        // CHECK COLLISION ITEM :
        int objIndex = gp.gestionCollision.checkItem(this);
        ramasseItem(objIndex);

        // CHECK MONSTER COLLISION :
        int MonsterIndex = gp.gestionCollision.checkMonster(this);
        collisionMonster(MonsterIndex);

        // CHECK ATTACK MONSTER COLLISION :
        int MonsterAttackIndex = gp.gestionCollision.checkMonsterAttack(this);
        collisionAttackMonster(MonsterAttackIndex);

        // si CollisionOn = false, on peut avancer etc...
        if (!collisionTopOn) {
            if (keyH.upPressed) {
                p.addY(-speed);
                hitbox.setLocation(p.getX() + 12, p.getY() + 16);
            }
        }
        if (!collisionBottomOn) {
            if (keyH.downPressed) {
                p.addY(speed);
                hitbox.setLocation(p.getX() + 12, p.getY() + 16);
            }
        }
        if (!collisionLeftOn) {
            if (keyH.leftPressed) {
                p.addX(-speed);
                hitbox.setLocation(p.getX() + 12, p.getY() + 16);
            }
        }
        if (!collisionRightOn) {
            if (keyH.rightPressed) {
                p.addX(speed);
                hitbox.setLocation(p.getX() + 12, p.getY() + 16);
            }
        }
        if (invulerable){
            if (invulnerable_compteur == 0){
                gp.effetSonor(4);
            }
            invulnerable_compteur++;
            if (invulnerable_compteur > 60){
                invulerable = false;
                invulnerable_compteur = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (isAttacking){
                    image = attackUp;
                }
                else{
                    image = up;
                }
                break;
            case "down":
                if (isAttacking){
                    image = attackDown;
                }
                else{
                    image = down;
                }
                break;
            case "left":
                if (isAttacking){
                    image = attackLeft;
                }
                else{
                    image = left;
                }
                break;
            case "right":
                if (isAttacking){
                    image = attackRight;
                }
                else{
                    image = right;
                }
                break;
        }
        if (invulerable){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.6f));
        }
        if (isAttacking){
            switch (direction){
                case "up":
                    g2.drawImage(image, p.getX()-gp.tileSize/2, p.getY()-gp.tileSize, gp.tileSize*2, gp.tileSize*2, null);
                    break;
                case "down":
                    g2.drawImage(image, p.getX()-gp.tileSize/2, p.getY(), gp.tileSize*2, gp.tileSize*2, null);
                    break;
                case "left":
                    g2.drawImage(image, p.getX()-gp.tileSize, p.getY()-gp.tileSize/2, gp.tileSize*2, gp.tileSize*2, null);
                    break;
                case "right":
                    g2.drawImage(image, p.getX(), p.getY()-gp.tileSize/2, gp.tileSize*2, gp.tileSize*2, null);
                    break;
            }
        }
        else{
            g2.drawImage(image, p.getX(), p.getY(), gp.tileSize, gp.tileSize, null);
        }
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    }
}