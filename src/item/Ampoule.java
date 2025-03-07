package item;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Ampoule extends Item {
    public Ampoule(int x, int y){
        super(x, y);
        nom = "Ampoule";
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/objet/Ampoule.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
