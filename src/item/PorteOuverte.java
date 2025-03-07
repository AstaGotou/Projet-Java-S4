package item;

import java.io.IOException;

import javax.imageio.ImageIO;

public class PorteOuverte extends Item {
    public PorteOuverte(int x, int y){
        super(x, y);

        nom = "porteOuverte";
        try{
            img = ImageIO.read(getClass().getResourceAsStream("/objet/Porte_Ouverte.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
