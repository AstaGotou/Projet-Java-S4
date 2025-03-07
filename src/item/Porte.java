package item;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Porte extends Item {
    
    protected int id;

    public Porte(int x, int y, int i){
        super(x, y);
        nom = "porte";
        id = i;
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/objet/Porte.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

        collision = true;
    }

    public int getId() {
        return id;
    }

}
