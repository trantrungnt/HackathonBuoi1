import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

/**
 * Created by Anh on 3/6/2016.
 */
public class Bullet2 extends Bullet {

    public Bullet2(double positionX, double positionY, int speed) {
        super(positionX, positionY, speed);
        try {
            this.sprite = ImageIO.read(new File("Resources/DAN.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void move() {
        if (this.speed < 0) {
            this.positionY -= this.speed;
            this.positionX -= this.speed ;
        } else {
            this.positionY += this.speed;
            this.positionX -= this.speed;
        }

    }

    @Override
    public void update() {
        move();

    }
}
