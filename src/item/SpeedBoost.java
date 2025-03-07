package item;

import java.io.IOException;

import javax.imageio.ImageIO;

public class SpeedBoost extends Item{
    
    public SpeedBoost(int x, int y){
        super(x, y);
        nom = "SpeedBoost";
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/objet/SpeedBoost.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
