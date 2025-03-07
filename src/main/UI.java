package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import item.*;

public class UI  {
    
    protected GamePanel gp;
    protected Graphics2D g2;
    protected Font arial_40 = new Font("Arial", Font.PLAIN, 40);
    protected BufferedImage coeurPlein, coeurMoitie, coeurVide; 

    public UI(GamePanel gp){
        this.gp = gp;

        Sante sante = new Sante(gp);
        coeurPlein = sante.getImg();
        coeurMoitie = sante.getImg2();
        coeurVide = sante.getImg3();
    }

    public void draw(Graphics2D g2){
        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);

        if(gp.etatJeu == gp.MENU){
            drawMenu();
        }
        else if(gp.etatJeu == gp.PLAY){
            drawPV();
            drawCleCoffre();
            drawClePorte();
        }
        else if(gp.getEtatJeu() == gp.PAUSE){
            drawPV();
            drawClePorte();
            drawCleCoffre();
            pauseScreen();
        }
        else if(gp.getEtatJeu() == gp.OVER){
            drawPV();
            drawClePorte();
            drawCleCoffre();
            drawGameOver();
        }
        else if(gp.getEtatJeu() == gp.WIN){
            drawPV();
            drawClePorte();
            drawCleCoffre();
            drawWin();
        }
        else if (gp.getEtatJeu() == gp.CHOIXLEVEL) {
            drawMenuLVL();
        }
    }

    public void drawMenu(){
        //Fond
        g2.setColor(new Color(03, 65, 78));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        // Titre
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
        int x = ((gp.screenWidth - g2.getFontMetrics().stringWidth("Marmot Lab"))/2);
        int y = gp.tileSize*4;
        g2.setColor(Color.white);
        g2.drawString("Marmot Lab", x, y);

        //Marmotte
        x = ((gp.screenWidth - gp.tileSize*4)/2);
        y += gp.tileSize*2;
        g2.drawImage(gp.joueur.getDown(), x, y, gp.tileSize*4, gp.tileSize*4, null);

        //Commencer
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
        x = ((gp.screenWidth - g2.getFontMetrics().stringWidth("JOUER (C)"))/2);
        y += gp.tileSize*6;
        g2.drawString("JOUER (C)", x, y);

        //Quitter
        x = ((gp.screenWidth - g2.getFontMetrics().stringWidth("Quitter (Q)"))/2);
        y += gp.tileSize*2;
        g2.drawString("Quitter (Q)", x, y);

    }

    public void pauseScreen(){
        g2.setColor(new Color(0, 0, 0, 150));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
        int x = ((gp.screenWidth - g2.getFontMetrics().stringWidth("PAUSE"))/2);
        int y = gp.screenHeight/2;
        g2.drawString("PAUSE", x, y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 36F));

        x = ((gp.screenWidth - g2.getFontMetrics().stringWidth("Continuer (ECHAP)"))/2);
        y += gp.tileSize*2;
        g2.drawString("Continuer (ECHAP)", x, y);

        x = ((gp.screenWidth - g2.getFontMetrics().stringWidth("Retour au Menu (Q)"))/2);
        y += gp.tileSize*2;
        g2.drawString("Retour au Menu (Q)", x, y);
    }

    public void drawMenuLVL(){
        //Fond
        g2.setColor(new Color(03, 65, 78));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        // Titre
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 96F));
        int x = ((gp.screenWidth - g2.getFontMetrics().stringWidth("Choix du Niveau"))/2);
        int y = gp.tileSize*4;
        g2.setColor(Color.white);
        g2.drawString("Choix du Niveau", x, y);

        // niveau
        x = gp.tileSize*3;
        y = gp.tileSize*8;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));
        for (int i =1; i<=10; i++){
            x += gp.tileSize*2;
            if (i == gp.numMap){
                g2.setColor(Color.black);
            } else {
                g2.setColor(Color.white);
            }
            g2.drawString(""+i, x, y);
        }

        g2.setColor(Color.white);

        //Aide
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 36F));
        x = ((gp.screenWidth - g2.getFontMetrics().stringWidth("Utiliser les flèches du clavier pour choisir le niveau"))/2);
        y = gp.tileSize*11;
        g2.drawString("Utiliser les flèches du clavier pour choisir le niveau", x, y);

        //Lancer niveau
        x = ((gp.screenWidth - g2.getFontMetrics().stringWidth("Lancer le niveau (enter)"))/2);
        y = gp.tileSize*13;
        g2.drawString("Lancer le niveau (enter)", x, y);

        //Quitter
        x = ((gp.screenWidth - g2.getFontMetrics().stringWidth("Retour au menu (Q)"))/2);
        y = gp.tileSize*15;
        g2.drawString("Retour au menu (Q)", x, y);
    }

    public void drawGameOver(){
        g2.setColor(new Color(0, 0, 0, 150));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));

        int x = ((gp.screenWidth - g2.getFontMetrics().stringWidth("Game Over"))/2);
        int y = gp.screenHeight/2;
        g2.drawString("Game Over", x, y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 48F));

        x = ((gp.screenWidth - g2.getFontMetrics().stringWidth("Recommencer le niveau (R)"))/2);
        y += gp.tileSize*2;
        g2.drawString("Recommencer le niveau (R)", x, y);

        x = ((gp.screenWidth - g2.getFontMetrics().stringWidth("Retour au Menu (Q)"))/2);
        y += gp.tileSize*2;
        g2.drawString("Retour au Menu (Q)", x, y);
    }

    public void drawWin(){
        g2.setColor(new Color(0, 0, 0, 150));
        g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);

        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 60F));
        int x = ((gp.screenWidth - g2.getFontMetrics().stringWidth("Félicitation !!! Vous aviez réussi le niveau " + gp.numMap))/2);
        int y = gp.screenHeight/3;
        g2.drawString("Félicitation !!! Vous avez défini le niveau " + gp.numMap, x, y);

        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 36F));
        if (gp.numMap <10) {
            x = ((gp.screenWidth - g2.getFontMetrics().stringWidth("Niveau Suivant (S)")) / 2);
            y += gp.tileSize * 3;
            g2.drawString("Niveau Suivant (S)", x, y);
        }

        x = ((gp.screenWidth - g2.getFontMetrics().stringWidth("Recommencer ce niveau (R)"))/2);
        y += gp.tileSize*1.5;
        g2.drawString("Recommencer ce niveau (R)", x, y);

        x = ((gp.screenWidth - g2.getFontMetrics().stringWidth("Retour au Menu (Q)"))/2);
        y += gp.tileSize*1.5;
        g2.drawString("Retour au Menu (Q)", x, y);
    }

    public void drawPV(){
        int x = gp.tileSize/2;
        int i = 0;
        int pv = gp.joueur.getPoint_de_vie();

        while (i < gp.joueur.getMAX_PV()/2) {
            g2.drawImage(coeurVide, x, 0, gp.tileSize, gp.tileSize, null);
            i++;
            x += gp.tileSize;
        }

        x = gp.tileSize/2;
        i = 0;

        while (i<pv){
            g2.drawImage(coeurMoitie, x, 0, gp.tileSize, gp.tileSize, null);
            i++;
            if(i< pv){
                g2.drawImage(coeurPlein, x, 0, gp.tileSize, gp.tileSize, null);
            }
            i++;
            x += gp.tileSize;
        }
    }

    public void drawClePorte(){
        int x = 4*gp.tileSize + gp.tileSize/2;
        int y = 0;
        for (int i = 0; i < gp.joueur.getPorteClef().length; i++) {
           if (gp.joueur.getPorteClef()[i] != null) {
               g2.drawImage(gp.joueur.getPorteClef()[i].getImg(), x, y, gp.tileSize, gp.tileSize, null);
               x += gp.tileSize;
           }
        }
    }

    public void drawCleCoffre(){
        int x = 3*gp.tileSize + gp.tileSize/2;
        int y = 0;
        if (gp.joueur.getClefCoffre() != null){
            g2.drawImage(gp.joueur.getClefCoffre().getImg(), x, y, gp.tileSize, gp.tileSize, null);
        }
    }
}



