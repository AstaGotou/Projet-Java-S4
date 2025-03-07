package bloc;

import main.GamePanel;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

public class GestionBloc {
    GamePanel gp;
    public Bloc[] bloc;
    public int mapBlocNum[][];

    public GestionBloc (GamePanel gp, int numMap){
        this.gp = gp;
        bloc = new Bloc[10];
        mapBlocNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        getBlocImage();
        switch (numMap){
            case 1:
                loadMap("/maps/map01.txt");
                break;
            case 2:
                loadMap("/maps/map02.txt");
                break;
            case 3:
                loadMap("/maps/map03.txt");
                break;
            case 4:
                loadMap("/maps/map04.txt");
                break;
            case 5:
                loadMap("/maps/map05.txt");
                break;
            case 6:
                loadMap("/maps/map06.txt");
                break;
            case 7:
                loadMap("/maps/map07.txt");
                break;
            case 8:
                loadMap("/maps/map08.txt");
                break;
            case 9:
                loadMap("/maps/map09.txt");
                break;
            case 10:
                loadMap("/maps/map10.txt");
                break;
            default:
                break;
        }
    }

    public void getBlocImage(){
        try {
            bloc[0] = new Bloc();
            bloc[0].image = ImageIO.read(getClass().getResourceAsStream("/bloc/Sol.png"));

            bloc[2] = new Bloc();
            bloc[2].image = ImageIO.read(getClass().getResourceAsStream("/bloc/Mur.png"));
            bloc[2].setCollision(true);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadMap(String CheminMap){ // fonction de lecture de la map
        try {
            InputStream is = getClass().getResourceAsStream(CheminMap); // charge le fichier
            BufferedReader br = new BufferedReader(new InputStreamReader(is)); // lecture du fichier
            int col = 0;
            int row = 0;
            while (col < gp.maxScreenCol && row < gp.maxScreenRow){
                String line = br.readLine(); // lecture de la ligne
                while (col < gp.maxScreenCol){
                    String numbers[] = line.split (" "); // lecture des nombres
                    int num = Integer.parseInt (numbers[col]) ; // conversion des nombres en int depuis la lecture
                    mapBlocNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxScreenCol) {
                    col = 0;
                    row++;
                }
            }
            br.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2){ // fonction de dessin de bloc de la map correspondant
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
            int blocNum = mapBlocNum[col][row]; // récupère le bloc correspondant
            g2.drawImage (bloc[blocNum].image, x, y, gp.tileSize, gp.tileSize, null); // dessine le bloc
            col++;
            x+= gp.tileSize;
            if (col == gp.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
}
