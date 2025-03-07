package main;


import java.awt.event. KeyEvent;
import java.awt.event.KeyListener;
public class KeyHandler implements KeyListener {

    GamePanel gp;
    public boolean upPressed, downPressed, rightPressed, leftPressed, aPressed;

    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void keyTyped (KeyEvent e) {
    }
    @Override
    public void keyPressed (KeyEvent e) {
        int code = e.getKeyCode(); // obtenir le code de la touche
        if(gp.getEtatJeu() == gp.PLAY) {
            if (code == KeyEvent.VK_UP) { // si la flêche haut est enfoncé
                upPressed = true;
            }
            if (code == KeyEvent.VK_DOWN) { // si la flêche bas est enfonné
                downPressed = true;
            }
            if (code == KeyEvent.VK_RIGHT) { // si la flêche droite est enfonné
                rightPressed = true;
            }
            if (code == KeyEvent.VK_LEFT) { // si la flêche gauche est enfonné
                leftPressed = true;
            }
            if (code == KeyEvent.VK_A) {
                aPressed = true;
            }
            if (code == KeyEvent.VK_ESCAPE) {
                gp.setEtatJeu(gp.PAUSE);
            }
        } else if(gp.getEtatJeu() ==gp.PAUSE){
            if (code == KeyEvent.VK_ESCAPE){
                gp.setEtatJeu(gp.PLAY);
            }
            if (code == KeyEvent.VK_Q){
                gp.setEtatJeu(gp.MENU);
            }
        } else if(gp.getEtatJeu() == gp.OVER){
            if (code == KeyEvent.VK_R){
                gp.jeuloadLVL(gp.numMap);
                gp.setEtatJeu(gp.PLAY);
            }
            if(code == KeyEvent.VK_Q){
                gp.setEtatJeu(gp.MENU);
            }
        } else if(gp.getEtatJeu() == gp.MENU){
            if(code == KeyEvent.VK_C){
                gp.setEtatJeu(gp.CHOIXLEVEL);
            }
            if(code == KeyEvent.VK_Q){
                System.exit(0);
            }
        } else if (gp.getEtatJeu() == gp.WIN){
            if (code == KeyEvent.VK_S){
                if (gp.numMap <10){
                    gp.numMap ++;
                    gp.jeuloadLVL(gp.numMap);
                    gp.setEtatJeu(gp.PLAY);
                }
            }
            if (code == KeyEvent.VK_R){
                gp.jeuloadLVL(gp.numMap);
                gp.setEtatJeu(gp.PLAY);
            }
            if (code == KeyEvent.VK_Q){
                gp.setEtatJeu(gp.MENU);
            }
        }
        else if(gp.getEtatJeu() == gp.CHOIXLEVEL){
            if(code == KeyEvent.VK_RIGHT){
                if (gp.numMap <10){
                    gp.numMap ++;
                }
            }
            if(code == KeyEvent.VK_LEFT){
                if (gp.numMap >1){
                    gp.numMap --;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                gp.jeuloadLVL(gp.numMap);
                gp.setEtatJeu(gp.PLAY);
            }
            if (code == KeyEvent.VK_Q){
                gp.setEtatJeu(gp.MENU);
            }
        }
    }
    @Override
    public void keyReleased (KeyEvent e) {
        int code = e.getKeyCode(); // obtenir le code de la touche
        if (code == KeyEvent.VK_UP){ // si la flêche haut est enfoncé
            upPressed = false;
        }
        if (code == KeyEvent.VK_DOWN){ // si la flêche bas est enfonné
            downPressed = false;
        }
        if (code == KeyEvent.VK_RIGHT){ // si la flêche droite est enfonné
            rightPressed = false;
        }
        if (code == KeyEvent.VK_LEFT){ // si la flêche gauche est enfonné
            leftPressed = false;
        }
        if(code == KeyEvent.VK_A){
            aPressed = false;
        }
    }
}