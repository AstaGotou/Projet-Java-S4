package environnement;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import main.*;

public class Lumiere {
    GamePanel gp;
    BufferedImage filtreLumineux;
    Color couleur[] = new Color[5];
    float graduation[] = new float[5];

    public Lumiere(GamePanel gp, int tailleLumiere){
        this.gp = gp;
        filtreLumineux = new BufferedImage (gp.screenWidth, gp.screenHeight, BufferedImage.TYPE_INT_ARGB) ; 
        Graphics2D g2 = (Graphics2D) filtreLumineux.getGraphics();

        Area zoneSombre = new Area(new Rectangle2D.Double(0, 0, gp.screenWidth, gp.screenHeight));

        int centreX = gp.getJoueur().getP().getX() + gp.tileSize/2;
        int centreY = gp.getJoueur().getP().getY() + gp.tileSize/2;

        double x = centreX - tailleLumiere/2;
        double y = centreY - tailleLumiere/2;

        Area zoneLumineuse = new Area(new Ellipse2D.Double(x, y, tailleLumiere, tailleLumiere));
        zoneSombre.subtract(zoneLumineuse);

        couleur[0] = new Color(0,0,0, 0f);
        couleur[1] = new Color(0,0,0, 0.25f);
        couleur[2] = new Color(0,0,0, 0.5f);
        couleur[3] = new Color(0,0,0, 0.75f);
        couleur[4] = new Color(0,0,0, 0.98f);
    
        graduation [0] = 0f;
        graduation [1] = 0.25f;
        graduation [2] = 0.5f;
        graduation [3] = 0.75f;
        graduation [4] = 1f;

        RadialGradientPaint paint = new RadialGradientPaint(centreX, centreY, (tailleLumiere/2), graduation, couleur);

        g2.setPaint(paint);
        g2.fill(zoneLumineuse);

        g2.setColor(new Color(0,0,0, 0.95f));
        g2.fill(zoneSombre);
        g2.dispose();
    }

    public void draw(Graphics2D g2){
        g2.drawImage(filtreLumineux, 0,0, null);
    }
}
