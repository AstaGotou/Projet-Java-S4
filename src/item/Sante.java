package item;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.*;

public class Sante extends Item {

    BufferedImage img2, img3;
    GamePanel gp;

    public Sante(GamePanel gp){
        super(0, 0);
        this.gp = gp;
        nom = "sante";
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/objet/Coeur.png"));
            img2 = ImageIO.read(getClass().getResourceAsStream("/objet/Coeur_moitie.png"));
            img3 = ImageIO.read(getClass().getResourceAsStream("/objet/Coeur_Vide.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public BufferedImage getImg2() {
        return img2;
    }

    public BufferedImage getImg3() {
        return img3;
    }
}
