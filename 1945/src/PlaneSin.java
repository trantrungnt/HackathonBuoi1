import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Anh on 3/6/2016.
 */
public class PlaneSin extends PlaneEnemyOject {
    private double angle = 0;
    private int count = 0;
    private Vector<Bullet1> vecBul = new Vector<Bullet1>();


    public PlaneSin(double positionX, double positionY, int speed) {
        super(positionX, positionY, speed);

        try {
            this.sprite = ImageIO.read(new File("Resources/PLANE1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void shot() {


        Bullet1 bullet2 = new Bullet1(this.positionX + Helper.PIC_PLANE_WIDTH, this.positionY + Helper.PIC_PLANE_HEIGT, -Helper.ENEMY_BULLET_SPEED);

        vecBul.add(bullet2);
    }


    @Override
    public void draw(Graphics g) {
        for (Bullet1 bul : vecBul) {
            bul.draw(g);
        }
        g.drawImage(this.sprite, (int) this.positionX, (int) this.positionY, null);

    }

    @Override
    public void move() {
        this.angle += Math.PI / 40;
        this.positionX += this.speed;
        this.positionY = (double) (50 * Math.sin(angle) + 100);
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
