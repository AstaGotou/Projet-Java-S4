package item;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Coeur extends Item {
    
    public Coeur(int x, int y){
        super(x, y);
        nom = "coeur";
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/objet/Coeur.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
