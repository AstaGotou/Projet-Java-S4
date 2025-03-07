package item;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ClefPorte extends Item {
    
    protected int id;

    public ClefPorte(int x, int y, int i){
        super(x, y);
        id = i;
        nom = "Clef_Porte";
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/objet/Clef_Porte.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }
}