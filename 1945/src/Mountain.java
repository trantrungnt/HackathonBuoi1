import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

/**
 * Created by Mr Hung on 3/6/2016.
 */
public class Mountain extends GameObject {
    public Mountain(int x, int y){
        this.positionX = x;
        this.positionY = y;
        try {
            this.sprite = ImageIO.read(new File("Resources/mountain.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g){
        g.drawImage(this.sprite,(int)this.positionX,(int)this.positionY,null);
    }
}
