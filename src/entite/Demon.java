package entite;

import caracteristique.Position;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Demon extends Monstre{
    public Demon(Position p, GamePanel gp){
        nom = "Demon";
        this.gp = gp;
        this.p = p;
        speed = 1;
        degats = 1;
        rangeAggro = 200;
        point_de_vie = 6;
        this.hitbox = new Rectangle(p.getX()+3, p.getY()+18, 42, 30);
        getImage();
    }

    public void getImage(){
        try {
            up = ImageIO.read(getClass().getResourceAsStream("/Monstre/Monstre.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
