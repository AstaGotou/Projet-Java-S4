package main;

import environnement.Lumiere;
import item.*;

import java.awt.image.BandedSampleModel;


public class  PlacementItem {
    protected GamePanel gp;

    public PlacementItem(GamePanel gp){
        this.gp = gp;
    }

    public void genItem(int i){
        switch (i){
            case 1:
                gp.item[0] = new Coffre(5*gp.tileSize, 2*gp.tileSize);
                gp.item[1] = new ClefCoffre(7*gp.tileSize, 2*gp.tileSize);
                break;
            case 2:
                gp.item[0] = new Coffre(15*gp.tileSize, 2*gp.tileSize);
                gp.item[1] = new ClefCoffre(13*gp.tileSize, 2*gp.tileSize);
                gp.item[2] = new Porte(6*gp.tileSize, 2*gp.tileSize, 0);
                gp.item[3] = new ClefPorte(3*gp.tileSize, 8*gp.tileSize, 0);
                break;
            case 3:
                gp.item[0] = new Coffre(14*gp.tileSize, 2*gp.tileSize);
                gp.item[1] = new ClefCoffre(14*gp.tileSize, 13*gp.tileSize);
                gp.item[2] = new Porte(4*gp.tileSize, 2*gp.tileSize, 0);
                gp.item[3] = new ClefPorte(16*gp.tileSize, 13*gp.tileSize, 0);
                gp.item[4] = new SpeedBoost(2*gp.tileSize, 5*gp.tileSize);
                gp.item[5] = new SpeedBoost(2*gp.tileSize, 10*gp.tileSize);
                break;
            case 4:
                gp.item[0] = new Coffre(18*gp.tileSize, 2*gp.tileSize);
                gp.item[1] = new ClefCoffre(16*gp.tileSize, 2*gp.tileSize);
                gp.item[2] = new Poison(5*gp.tileSize, 2*gp.tileSize);
                gp.item[3] = new Poison(6*gp.tileSize, 2*gp.tileSize);
                gp.item[4] = new Poison(7*gp.tileSize, 2*gp.tileSize);
                gp.item[5] = new Coeur(10*gp.tileSize, 2*gp.tileSize);
                break;
            case 5:
                gp.item[0] = new Coffre(4*gp.tileSize, 14*gp.tileSize);
                gp.item[1] = new ClefCoffre(6*gp.tileSize, 14*gp.tileSize);
                gp.item[2] = new Coeur(26*gp.tileSize, gp.tileSize);
                gp.item[3] = new Coeur(26*gp.tileSize, 2*gp.tileSize);
                gp.item[4] = new Coeur(26*gp.tileSize, 3*gp.tileSize);
                gp.item[5] = new Porte(19*gp.tileSize, 4*gp.tileSize, 0);
                gp.item[6] = new ClefPorte(25*gp.tileSize, 2*gp.tileSize, 0);
                gp.item[7] = new SpeedBoost(26*gp.tileSize, 7*gp.tileSize);
                gp.item[8] = new SpeedBoost(26*gp.tileSize, 8*gp.tileSize);
                break;
            case 6:
                gp.item[0] = new Coffre(26*gp.tileSize, 8*gp.tileSize);
                gp.item[1] = new ClefCoffre(20*gp.tileSize, 8*gp.tileSize);
                gp.item[2] = new Ampoule(6*gp.tileSize, 6*gp.tileSize);
                break;
            case 7:
                gp.item[0] = new Coffre(26*gp.tileSize, 14*gp.tileSize);
                gp.item[1] = new ClefCoffre(22*gp.tileSize, gp.tileSize);
                gp.item[2] = new Porte(4*gp.tileSize, 4*gp.tileSize, 0);
                gp.item[3] = new ClefPorte(3*gp.tileSize,4*gp.tileSize, 0);
                gp.item[4] = new Porte(21*gp.tileSize, 12*gp.tileSize, 1);
                gp.item[5] = new ClefPorte(15*gp.tileSize,9*gp.tileSize, 1);
                gp.item[6] = new Porte(19*gp.tileSize, 5*gp.tileSize, 2);
                gp.item[7] = new ClefPorte(15*gp.tileSize,3*gp.tileSize, 2);
                gp.item[8] = new Ampoule(5*gp.tileSize, gp.tileSize);
                gp.item[9] = new SpeedBoost(gp.tileSize, 8*gp.tileSize);
                gp.item[10] = new Coeur(6*gp.tileSize, 13*gp.tileSize);
                gp.item[11] = new Coeur(7*gp.tileSize, 13*gp.tileSize);
                break;
            case 8:
                gp.item[0] = new Coffre(26*gp.tileSize, 3*gp.tileSize);
                gp.item[1] = new ClefCoffre(23*gp.tileSize, 6*gp.tileSize);
                gp.item[2] = new Porte(7*gp.tileSize, 4*gp.tileSize, 0);
                gp.item[3] = new ClefPorte(3*gp.tileSize,4*gp.tileSize, 0);
                gp.item[4] = new Porte(17*gp.tileSize, 12*gp.tileSize, 1);
                gp.item[5] = new ClefPorte(15*gp.tileSize,9*gp.tileSize, 1);
                gp.item[6] = new Ampoule(gp.tileSize, 12*gp.tileSize);
                gp.item[7] = new SpeedBoost(gp.tileSize, 8*gp.tileSize);
                gp.item[8] = new Coeur(6*gp.tileSize, 13*gp.tileSize);
                gp.item[9] = new Coeur(5*gp.tileSize, 13*gp.tileSize);
                gp.item[10] = new SpeedBoost(14*gp.tileSize, 7*gp.tileSize);
                break;
            case 9:
                gp.item[0] = new Porte(20* gp.tileSize, 2*gp.tileSize, 0);
                gp.item[1] = new Porte(2* gp.tileSize, 4*gp.tileSize, 1);
                gp.item[2] = new Porte(20* gp.tileSize, 6*gp.tileSize, 2);
                gp.item[3] = new Porte(2* gp.tileSize, 8*gp.tileSize, 3);
                gp.item[4] = new Porte(25* gp.tileSize, 8*gp.tileSize, 4);
                gp.item[5] = new Porte(25* gp.tileSize, 12*gp.tileSize, 5);
                gp.item[6] = new ClefPorte(4* gp.tileSize, 2*gp.tileSize, 0);
                gp.item[7] = new ClefPorte(25* gp.tileSize, 2*gp.tileSize, 1);
                gp.item[8] = new ClefPorte(2* gp.tileSize, 6*gp.tileSize, 2);
                gp.item[9] = new ClefPorte(23* gp.tileSize, 6*gp.tileSize, 3);
                gp.item[10] = new ClefPorte(18* gp.tileSize, 10*gp.tileSize, 4);
                gp.item[11] = new ClefPorte(22* gp.tileSize, 10*gp.tileSize, 5);
                gp.item[12] = new Coffre(gp.tileSize, 14*gp.tileSize);
                gp.item[13] = new ClefCoffre(17*gp.tileSize, 10*gp.tileSize);

                gp.item[14] = new Coeur(26*gp.tileSize, 1*gp.tileSize);
                gp.item[15] = new Coeur(26*gp.tileSize, 2*gp.tileSize);
                gp.item[16] = new Coeur(26*gp.tileSize, 3*gp.tileSize);

                gp.item[17] = new Coeur(2*gp.tileSize, 10*gp.tileSize);
                gp.item[18] = new Coeur(3*gp.tileSize, 10*gp.tileSize);
                gp.item[19] = new Coeur(26*gp.tileSize, 10*gp.tileSize);
                break;
            case 10:
                gp.item[0] = new Ampoule(3*gp.tileSize, 5* gp.tileSize);
                gp.item[1] = new Coffre(22* gp.tileSize, gp.tileSize);
                gp.item[2] = new ClefCoffre(4* gp.tileSize, 5* gp.tileSize);

                gp.item[3] = new Coeur(4*gp.tileSize, 9* gp.tileSize);
                gp.item[4] = new Coeur(5* gp.tileSize, 10* gp.tileSize);

                gp.item[5] = new Coeur(11* gp.tileSize, 13* gp.tileSize);
                gp.item[6] = new Coeur(12*gp.tileSize, 13* gp.tileSize);

                gp.item[7] = new Coeur(24* gp.tileSize, 4* gp.tileSize);
                gp.item[8] = new Coeur(25* gp.tileSize, 5* gp.tileSize);

                gp.item[9] = new Poison(10*gp.tileSize, 13* gp.tileSize);
                gp.item[10] = new Poison(10* gp.tileSize, 14* gp.tileSize);

                gp.item[11] = new Coeur(11* gp.tileSize, 13* gp.tileSize);
                gp.item[12] = new Coeur(11*gp.tileSize, 14* gp.tileSize);

                gp.item[13] = new Poison(14* gp.tileSize, 13* gp.tileSize);
                gp.item[14] = new Poison(14* gp.tileSize, 14* gp.tileSize);

                gp.item[15] = new Coeur(15* gp.tileSize, 13* gp.tileSize);
                gp.item[16] = new Coeur(15* gp.tileSize, 14* gp.tileSize);

                gp.item[17] = new Coeur(18* gp.tileSize, 13* gp.tileSize);
                gp.item[18] = new Poison(18* gp.tileSize, 14* gp.tileSize);
                break;

            default:
                break;
        }
    }
}
