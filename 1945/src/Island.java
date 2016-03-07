import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr Hung on 3/6/2016.
 */
public class Island extends GameObject {
    public Island(int x, int y){
        this.positionX = x;
        this.positionY = y;
        try {
            this.sprite = ImageIO.read(new File("Resources/island.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g){
        g.drawImage(this.sprite,(int)this.positionX,(int)this.positionY,null);
    }
}
