package entite;

import caracteristique.Position;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Deratisateur extends Monstre{
    public Deratisateur(Position p, GamePanel gp){
        nom = "Deratisateur";
        this.gp = gp;
        this.p = p;
        speed = 2;
        degats = 1;
        rangeAggro = 400;
        point_de_vie = 4;
        this.hitbox = new Rectangle(p.getX()+3, p.getY()+18, 42, 30);
        getImage();
    }

    public void getImage(){
        try {
            up = ImageIO.read(getClass().getResourceAsStream("/Monstre/Deratisateur.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
