package environnement;

import java.awt.Graphics2D;

import main.GamePanel;

public class EnvironnementHandler {
    GamePanel gp;
    Lumiere lum;

    public EnvironnementHandler(GamePanel gp){
        this.gp = gp;
    }

    public void setUpEnvironnemnt(){
        lum = new Lumiere(gp, 400);
    }

    public void draw(Graphics2D g2){
        lum.draw(g2);
    }

}
