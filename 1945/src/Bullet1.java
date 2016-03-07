import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by Anh on 3/6/2016.
 */
public class Bullet1 extends Bullet {


    public Bullet1(double positionX, double positionY, int speed) {
        super(positionX, positionY, speed);
        try {
            this.sprite = ImageIO.read(new File("Resources/DAN.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void move() {
        this.positionY -= speed;

    }

    @Override
    public void update() {
        move();
    }
}
