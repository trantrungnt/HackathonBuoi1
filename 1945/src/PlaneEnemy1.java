import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Anh on 3/6/2016.
 */
public class PlaneEnemy1 extends PlaneEnemyOject {
    private int count = 0;
    private Vector<Bullet1> vecBul = new Vector<Bullet1>();

    public PlaneEnemy1(double positionX, double positionY, int speed) {
        super(positionX, positionY, speed);
        this.positionX = positionX;
        this.positionY = positionY;
        this.speed = speed;
        try {
            this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shot() {
        Bullet1 bullet = new Bullet1(this.positionX + 30, this.positionY + 60, -Helper.ENEMY_BULLET_SPEED);
        Bullet1 bullet2 = new Bullet1(this.positionX + 30, this.positionY + 80, -Helper.ENEMY_BULLET_SPEED);
        vecBul.add(bullet);
        vecBul.add(bullet2);
    }

    @Override
    public void draw(Graphics g) {
        for (Bullet1 bul : vecBul) {
            bul.draw(g);
        }
        g.drawImage(sprite, (int)positionX,(int) positionY, null);
    }


    @Override
    public void move() {
        this.positionX += this.speed;
        if (this.positionX <= 0) {
            this.speed = -this.speed;
        }
        if (this.positionX >= Helper.WIDTH) {
            this.speed = -this.speed;
        }

    }

    @Override
    public void update() {
        count++;
        if (count >= Helper.SHOT_DELAY) {
            this.shot();
            count = 0;
        }
        for (Bullet1 bul : vecBul) {
            bul.update();
        }
        move();
    }
}

