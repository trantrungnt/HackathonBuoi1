import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Anh on 3/5/2016.
 */
public class Plane extends PlaneAbstact {
    private int direction;
    private int planetype;
    //ham ban
    private Vector<Bullet1> vecBul = new Vector<Bullet1>();

    public Plane(double positionX, double positionY, int speed, int planetype) {
        super(positionX, positionY, speed);

        /*this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;*/

        switch (planetype) {
            case 1:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE2.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE3.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    this.sprite = ImageIO.read(new File("Resources/PLANE4.png"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void shot() {
        Bullet1 bul = new Bullet1(this.positionX + Helper.PIC_PLANE_WIDTH, this.positionY, Helper.BULLET_SPEED);
        vecBul.add(bul);
    }

    public void move(int x, int y) {
        this.positionX = x;
        this.positionY = y;

    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(this.sprite, (int)this.positionX, (int)this.positionY, null);
        for (Bullet bul : vecBul) {
            bul.draw(g);
        }


    }

    @Override
    public void move() {
        switch (direction) {
            case 0:
                //dung im
                break;
            case 1:
                this.positionY -= this.speed;
                break;
            case 2:
                this.positionY += this.speed;
                break;
            case 3:
                this.positionX -= this.speed;
                break;
            case 4:
                this.positionX += this.speed;
                break;
        }

    }

    @Override
    public void update() {
        this.move();
        for (Bullet bul : vecBul) {
            bul.update();
        }

    }
}
