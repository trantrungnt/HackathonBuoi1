import java.awt.*;

/**
 * Created by Anh on 3/5/2016.
 */
public abstract class Bullet extends GameObject {
    protected int speed;

    public Bullet(double positionX, double positionY, int speed) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
    }

    public void draw(Graphics g) {
        g.drawImage(this.sprite,(int)this.positionX, (int)this.positionY, null);
    }


    public abstract void move();


    public abstract void update();
}