package main;

import java.net.URL;

import javax.sound.sampled.*;

public class Son {
    protected Clip clip;
    protected URL sonUrl[] = new URL[10] ;
    public int musique_actuelle = -1;

    public Son(){
        sonUrl[0] = getClass().getResource("/MusicJeu.wav");
        sonUrl[1] = getClass().getResource("/MusiqueMenu.wav");
        sonUrl[2] = getClass().getResource("/SonGO.wav");
        sonUrl[3] = getClass().getResource("/SonWin.wav");
        sonUrl[4] = getClass().getResource("/SonDegat.wav");
        sonUrl[5] = getClass().getResource("/SonAttaque.wav");
        sonUrl[6] = getClass().getResource("/SonMonstre.wav");
        sonUrl[7] = getClass().getResource("/SonPorte.wav");
        sonUrl[8] = getClass().getResource("/SonClef.wav");
        sonUrl[9] = getClass().getResource("/SonCoeur.wav");
    }

    public void setFile(int i){
        musique_actuelle = i;
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(sonUrl[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void jouer(){
        clip.start();
    }   

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop(){
        clip.stop();
    }

    public int getMusique_actuelle() {
        return musique_actuelle;
    }
}
