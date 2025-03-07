package item;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Coffre extends Item {
     public Coffre(int x, int y){
        super(x, y);
        nom = "coffre";
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/objet/Coffre.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
    }
}
