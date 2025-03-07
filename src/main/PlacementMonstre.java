package main;

import caracteristique.Position;
import entite.Demon;
import entite.Deratisateur;


public class PlacementMonstre {
    protected GamePanel gp;

    public PlacementMonstre(GamePanel gp){
        this.gp = gp;
    }

    public void genMonstre(int i){
        for (int j = 0; j < gp.monstre.length; j++){
            gp.monstre[j] = null;
        }
        switch (i){
            case 5:
                gp.monstre[0] = new Demon(new Position(23*gp.tileSize, gp.tileSize), gp);
                gp.monstre[1] = new Demon(new Position(23*gp.tileSize, 2*gp.tileSize), gp);
                gp.monstre[2] = new Demon(new Position(23*gp.tileSize, 3*gp.tileSize), gp);
                gp.monstre[3] = new Deratisateur(new Position(9*gp.tileSize, 12*gp.tileSize), gp);
                gp.monstre[4] = new Deratisateur(new Position(9*gp.tileSize, 13*gp.tileSize), gp);
                gp.monstre[5] = new Deratisateur(new Position(9*gp.tileSize, 14*gp.tileSize), gp);
                gp.monstre[6] = new Deratisateur(new Position(15*gp.tileSize, 12*gp.tileSize), gp);
                gp.monstre[7] = new Deratisateur(new Position(15*gp.tileSize, 13*gp.tileSize), gp);
                gp.monstre[8] = new Deratisateur(new Position(15*gp.tileSize, 14*gp.tileSize), gp);
                gp.monstre[9] = new Deratisateur(new Position(22*gp.tileSize, 12*gp.tileSize), gp);
                gp.monstre[10] = new Deratisateur(new Position(22*gp.tileSize, 13*gp.tileSize), gp);
                gp.monstre[11] = new Deratisateur(new Position(22*gp.tileSize, 14*gp.tileSize), gp);
                break;
            case 7:
                gp.monstre[0] = new Demon(new Position(9*gp.tileSize, 12*gp.tileSize), gp);
                gp.monstre[1] = new Demon(new Position(9*gp.tileSize, 13*gp.tileSize), gp);
                gp.monstre[2] = new Demon(new Position(9*gp.tileSize, 14*gp.tileSize), gp);
                gp.monstre[3] = new Deratisateur(new Position(23*gp.tileSize, gp.tileSize), gp);
                gp.monstre[4] = new Deratisateur(new Position(23*gp.tileSize, 2*gp.tileSize), gp);
                gp.monstre[5] = new Deratisateur(new Position(23*gp.tileSize, 3*gp.tileSize), gp);
                break;
            case 8:
                gp.monstre[0] = new Demon(new Position(12*gp.tileSize, 12*gp.tileSize), gp);
                gp.monstre[1] = new Demon(new Position(13*gp.tileSize, 13*gp.tileSize), gp);
                gp.monstre[2] = new Demon(new Position(22*gp.tileSize, 12*gp.tileSize), gp);
                gp.monstre[3] = new Demon(new Position(23*gp.tileSize, 13*gp.tileSize), gp);
                gp.monstre[4] = new Deratisateur(new Position(12*gp.tileSize, 2*gp.tileSize), gp);
                gp.monstre[5] = new Deratisateur(new Position(13*gp.tileSize, 3*gp.tileSize), gp);
                gp.monstre[6] = new Deratisateur(new Position(23*gp.tileSize, 2*gp.tileSize), gp);
                gp.monstre[7] = new Deratisateur(new Position(22*gp.tileSize, 3*gp.tileSize), gp);
                break;
            case 9:
                gp.monstre[0] = new Demon(new Position(23*gp.tileSize, 2*gp.tileSize), gp);
                gp.monstre[1] = new Demon(new Position(22*gp.tileSize, 2*gp.tileSize), gp);

                gp.monstre[2] = new Demon(new Position(10*gp.tileSize, 6*gp.tileSize), gp);
                gp.monstre[3] = new Demon(new Position(11*gp.tileSize, 6*gp.tileSize), gp);
                gp.monstre[4] = new Deratisateur(new Position(12*gp.tileSize, 6*gp.tileSize), gp);
                gp.monstre[5] = new Deratisateur(new Position(13*gp.tileSize, 3*gp.tileSize), gp);
                gp.monstre[6] = new Demon(new Position(25*gp.tileSize, 10*gp.tileSize), gp);

                gp.monstre[7] = new Deratisateur(new Position(6*gp.tileSize, 13*gp.tileSize), gp);
                gp.monstre[8] = new Demon(new Position(7*gp.tileSize, 13*gp.tileSize), gp);
                gp.monstre[9] = new Demon(new Position(6*gp.tileSize, 14*gp.tileSize), gp);
                gp.monstre[10] = new Deratisateur(new Position(7*gp.tileSize, 14*gp.tileSize), gp);
                break;
            case 10:
                gp.monstre[0] = new Deratisateur(new Position(6*gp.tileSize, gp.tileSize), gp);
                gp.monstre[1] = new Deratisateur(new Position(5*gp.tileSize, gp.tileSize), gp);
                gp.monstre[2] = new Deratisateur(new Position(6*gp.tileSize, 2*gp.tileSize), gp);

                gp.monstre[3] = new Deratisateur(new Position(gp.tileSize, 13*gp.tileSize), gp);
                gp.monstre[4] = new Deratisateur(new Position(2*gp.tileSize, 13*gp.tileSize), gp);
                gp.monstre[5] = new Deratisateur(new Position(3*gp.tileSize, 13*gp.tileSize), gp);
                gp.monstre[6] = new Deratisateur(new Position(gp.tileSize, 14*gp.tileSize), gp);
                gp.monstre[7] = new Deratisateur(new Position(2*gp.tileSize, 14*gp.tileSize), gp);
                gp.monstre[8] = new Deratisateur(new Position(3*gp.tileSize, 14*gp.tileSize), gp);

                gp.monstre[9] = new Deratisateur(new Position(25*gp.tileSize, 13*gp.tileSize), gp);
                gp.monstre[10] = new Deratisateur(new Position(25*gp.tileSize, 14*gp.tileSize), gp);
                gp.monstre[11] = new Deratisateur(new Position(26*gp.tileSize, 13*gp.tileSize), gp);

                gp.monstre[12] = new Deratisateur(new Position(10*gp.tileSize, gp.tileSize), gp);
                gp.monstre[13] = new Deratisateur(new Position(11*gp.tileSize, 2*gp.tileSize), gp);
                gp.monstre[14] = new Deratisateur(new Position(10*gp.tileSize, 2*gp.tileSize), gp);
                gp.monstre[15] = new Deratisateur(new Position(11*gp.tileSize, gp.tileSize), gp);

                gp.monstre[16] = new Deratisateur(new Position(24*gp.tileSize, 11*gp.tileSize), gp);
                gp.monstre[17] = new Deratisateur(new Position(25*gp.tileSize, 11*gp.tileSize), gp);
                gp.monstre[18] = new Deratisateur(new Position(26*gp.tileSize, 11*gp.tileSize), gp);
                break;
            default:
                break;
        }
    }
}
