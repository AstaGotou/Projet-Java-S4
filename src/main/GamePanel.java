package main;

import bloc.GestionBloc;
import entite.*;
import environnement.EnvironnementHandler;
import item.Item;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Arrays;

public class GamePanel extends JPanel implements Runnable{
    //Resolution et mise à l'échelle :
    public final int originalTileSize = 16; // 16x16
    public final int scale = 3;
    public final int tileSize = originalTileSize * scale; // donc 48x48
    //Taille de la fenêtre :
    public final int maxScreenCol = 28;
    public final int maxScreenRow = 16;
    public final int screenWidth = tileSize * maxScreenCol; // longueur de 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // largueur de 576 pixels

    int FPS = 60; // images par seconde
    protected int numMap = 1;

    // inialisation :
    public Son son = new Son();
    public Son effet = new Son();
    public GestionBloc gestionBloc;
    public KeyHandler keyH = new KeyHandler(this); // permet de traiter les evenements clavier
    public Thread gameThread;
    public GestionCollision gestionCollision = new GestionCollision(this);
    EnvironnementHandler envHandler = new EnvironnementHandler(this);

    protected Joueur joueur = new Joueur(this, keyH);
    public Item item[];
    public PlacementItem itemPlace = new PlacementItem(this);
    public Monstre monstre[] = new Monstre[20];
    public PlacementMonstre monstrePlace = new PlacementMonstre(this);

    //Etat du jeu
    protected UI ui = new UI(this);
    public final int PLAY = 1;
    public final int PAUSE = 2;
    public final int MENU = 3;
    public final int OVER = 4;
    public final int WIN = 5;
    public final int CHOIXLEVEL = 6;
    protected int etatJeu;

    public GamePanel () {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.gray);
        this.setDoubleBuffered(true); // minimise le scintillement et fournit des mises à jour plus fluides
        this.setFocusable(true);
        this.addKeyListener(keyH); // permet de traiter les evenements clavier
    }
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void jeuSetUp(){
        etatJeu = MENU;
        joueur = new Joueur(this, keyH);
        gestionBloc = new GestionBloc(this, numMap);
        item = new Item[20];
        monstre = new Monstre[20];
        monstrePlace.genMonstre(numMap);
        itemPlace.genItem(numMap);
        if (son.clip != null && son.getMusique_actuelle()!=1) {
            stopMusique();
        }
        if(effet.clip!=null){
            stopEffet();
        }
        if (son.getMusique_actuelle()!=1) {
            jouerMusique(1);
        }
    }

    public void jeuloadLVL(int i){
        joueur.setDefaultValues();
        gestionBloc = new GestionBloc(this, i);
        Arrays.fill(monstre, null);
        Arrays.fill(item, null);
        monstrePlace.genMonstre(i);
        itemPlace.genItem(i);
    }

    public int getEtatJeu() {
        return etatJeu;
    }

    public void setEtatJeu(int etatJeu) {
        this.etatJeu = etatJeu;

        if (etatJeu == MENU) {
            jeuSetUp();
        } else if(etatJeu == CHOIXLEVEL){
            numMap = 1;
        } else if(etatJeu == PLAY){
            envHandler.setUpEnvironnemnt();
            if (son.clip != null && son.getMusique_actuelle()!=0) {
                stopMusique();
            }
            if(effet.clip!=null){
                stopEffet();
            }
            if (son.getMusique_actuelle() != 0){
                jouerMusique(0);
            }
            else {
                continuerMusique();
            }
        } else if(etatJeu == OVER){
            stopMusique();
            if(effet.clip!=null){
                stopEffet();
            }
            effetSonor(2);
        }  else if(etatJeu == WIN){
            stopMusique();
            if(effet.clip!=null){
                stopEffet();
            }
            effetSonor(3);
        } else if (etatJeu == PAUSE) {
            if(effet.clip != null){
                stopEffet();
            }
            stopMusique();
        }
    }
    public void jouerMusique(int i){
        son.setFile(i);
        son.jouer();
        son.loop();
    }
    public void stopMusique(){
        son.stop();
    }
    public void stopEffet(){
        effet.stop();
    }

    public void effetSonor(int i){
        effet.setFile(i);
        effet.jouer();
    }
    public void continuerMusique(){
        son.jouer();
        son.loop();
    }

    public Joueur getJoueur() {
        return joueur;
    }

    @Override
    public void run(){
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime () ;
        long currentTime;
        while (gameThread != null) {
            currentTime = System.nanoTime () ;
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                update() ;
                repaint() ;
                delta--;
            }
        }
    }

    public void update(){
        if(etatJeu == PLAY){
            joueur.update();
            envHandler.setUpEnvironnemnt();
            for (int i = 0; i < monstre.length; i++){
                if (monstre[i] != null){
                   if (monstre[i].getPoint_de_vie() <=0){
                       monstre[i] = null;
                   }
                   else {
                       monstre[i].update(joueur);
                   }
                }
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (etatJeu == PLAY || etatJeu == PAUSE || etatJeu == WIN || etatJeu == OVER){
            // dessine la map
            gestionBloc.draw(g2);
            // dessine les items
            for (Item item : item) {
                if(item != null){
                    item.draw(g2, this);
                }
            }
            // dessine le joueur
            joueur.draw(g2);
            // dessine les monstres
            for (int i = 0; i < monstre.length; i++){
                if (monstre[i] != null){
                    monstre[i].draw(g2, this);
                }
            }
            if(!joueur.getLumiere() && numMap >= 6){
                envHandler.draw(g2);
            }
        }
        ui.draw(g2);
        g2.dispose();
    }
}
