package bloc;

import java.awt. image.BufferedImage;

public class Bloc {
    protected BufferedImage image;
    protected boolean collision = false;

    public boolean getCollision(){
        return collision;
    }

    public void setCollision(boolean collision){
        this.collision = collision;
    }
}
