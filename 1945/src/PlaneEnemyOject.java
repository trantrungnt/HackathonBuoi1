import java.awt.*;

/**
 * Created by Anh on 3/5/2016.
 */
public abstract class PlaneEnemyOject extends PlaneAbstact {

    public PlaneEnemyOject(double positionX, double positionY, int speed) {
        super(positionX, positionY, speed);


    }

    public abstract void draw(Graphics g);

    public abstract void move();

    public abstract void update();
}

