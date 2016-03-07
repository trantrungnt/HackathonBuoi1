import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Anh on 3/6/2016.
 */
public class PlaneEnemy2 extends PlaneEnemyOject {

    private int angle = 0;
    private int count = 0;
    private Vector<Bullet> vecBul = new Vector<Bullet>();

    public PlaneEnemy2(int positionX, int positionY, int speed) {
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
        Bullet2 bullet1 = new Bullet2(this.positionX + 10, this.positionY + 30, Helper.ENEMY_BULLET_SPEED);
        Bullet1 bullet2 = new Bullet1(this.positionX + 25, this.positionY + 30, -Helper.ENEMY_BULLET_SPEED);
        Bullet2 bullet3 = new Bullet2(this.positionX + 35, this.positionY + 30, -Helper.ENEMY_BULLET_SPEED);
        vecBul.add(bullet1);
        vecBul.add(bullet2);
        vecBul.add(bullet3);

    }


    @Override
    public void draw(Graphics g) {
        for (Bullet bul : vecBul) {
            bul.draw(g);
        }
        g.drawImage(sprite,(int) positionX,(int) positionY, null);

    }

    @Override
    public void move() {
        angle++;
        this.positionX += (double) (5 * Math.sin(angle * 0.09));
        this.positionY += (double) (5 * Math.cos(angle * 0.09));


    }

    @Override
    public void update() {
        count++;
        if (count >= Helper.SHOT_DELAY) {
            this.shot();
            count = 0;
        }
        for (Bullet bul : vecBul) {
            bul.update();
        }
        move();
    }
}
