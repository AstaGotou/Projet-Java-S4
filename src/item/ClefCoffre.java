package item;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ClefCoffre extends Item {

    public ClefCoffre(int x, int y){
        super(x, y);
        nom = "Clef_Coffre";
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/objet/Clef_Coffre.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}