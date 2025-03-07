package item;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Poison extends Item {
    public Poison(int x, int y){
        super(x, y);
        nom = "Poison";
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/objet/Poison.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
