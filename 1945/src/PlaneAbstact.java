import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Anh on 3/5/2016.
 */
public abstract class PlaneAbstact extends GameObject {

    protected int planetype;
    protected int speed;

    private PlaneAbstact() {

    }

    public PlaneAbstact(double positionX, double positionY, int speed) {
        this.positionX = positionX;
        this.positionY = positionY;

        this.speed = speed;

    }


    public abstract void draw(Graphics g);

    public abstract void move();

    public abstract void update();


    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public void setSprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
