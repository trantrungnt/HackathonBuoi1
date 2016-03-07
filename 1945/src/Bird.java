import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 * Created by Mr Hung on 3/6/2016.
 */
public class Bird extends GameObject {
    private int count = 0;
    public Bird(int x, int y) {
        this.positionX = x;
        this.positionY = y;
        try {
            this.sprite = ImageIO.read(new File("Resources/bird.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics g){
        g.drawImage(this.sprite,(int)this.positionX,(int) this.positionY,null);
    }

    public void update(){
        move();
    }

    public int random(int min, int max){
            try {
                Random rn = new Random();
                int range = max - min + 1;
                int randomNum = min + rn.nextInt(range);
                return randomNum;
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
    }


    public void move(){
        this.positionX += random(-3,3);
        this.positionY += random(-3,3);
    }


}
