import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Anh on 3/5/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Graphics seconds;
    Image image;
    BufferedImage background;
    Plane planeMoveByKey, planeMoveByMouse;
    PlaneEnemy2 planeEnemy2;
    Mountain mountain,mountain2;
    Island island;
    Bird bird;
    int direction = 0;
    Vector<PlaneEnemy1> vectorPlaneEnemy = new Vector<>();
    Vector<PlaneSin> vectorPlaneSin =new Vector<>();
    private int count =0;

    public GameWindow() {

        //thiet lap tieu de cho cua so
        this.setTitle("TechKids - code the change");
        //thiet lap kich thuoc cho cua so
        this.setSize(Helper.WIDTH, Helper.HEIGHT);
        //thiet lap xem cua so co hien thi hay khong
        this.setVisible(true);
        //khi an vao nut X thi thoat
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        //load Image tu thu muc Resource
        try {
            background = ImageIO.read(new File("Resources/Background.jpg"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        initPlane();
        //bat su kien di chuyen chuot
        //this.addMouseListener();
        //doan code de bat su kien bam phim
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
                    planeMoveByMouse.shot();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                planeMoveByMouse.move(e.getX(), e.getY());
            }
        });
        this.addKeyListener(new KeyListener() {
            //truoc khi bam
            @Override
            public void keyTyped(KeyEvent e) {

            }

            //khi dang giu phim
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    planeMoveByKey.setDirection(3);
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    planeMoveByKey.setDirection(4);
                } else if (e.getKeyCode() == KeyEvent.VK_W) {
                    planeMoveByKey.setDirection(1);
                } else if (e.getKeyCode() == KeyEvent.VK_S) {
                    planeMoveByKey.setDirection(2);
                } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    planeMoveByKey.shot();
                }
            }

            //khi nhac phim len
            @Override
            public void keyReleased(KeyEvent e) {
                planeMoveByKey.setDirection(0);
            }
        });
    }

    private void initPlane() {
        mountain = new Mountain(250,200);
        mountain2 = new Mountain(50,300);
        island = new Island(70,150);
        bird = new Bird(150,200);
        planeMoveByKey = new Plane(100, 300, 3, 4);
        planeMoveByMouse = new Plane(300, 300, 4, 2);

        planeEnemy2 = new PlaneEnemy2(150, 300, 3);

        vectorPlaneEnemy.add(new PlaneEnemy1(200, 200, 1));
        vectorPlaneEnemy.add(new PlaneEnemy1(150, 100, 1));
        vectorPlaneEnemy.add(new PlaneEnemy1(100, 150, 1));
        vectorPlaneEnemy.add(new PlaneEnemy1(250, 120, 1));
        vectorPlaneEnemy.add(new PlaneEnemy1(300, 90, 1));
    }

    public void update(Graphics g) {
        if (image == null) {
            image = createImage(this.getWidth(), this.getHeight());
            seconds = image.getGraphics();
        }
        seconds.setColor(getBackground());
        seconds.fillRect(0, 0, getWidth(), getHeight());
        seconds.setColor(getForeground());
        paint(seconds);
        g.drawImage(image, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);

        g.drawImage(background, 0, 0, null);

        island.draw(g);
        mountain.draw(g);
        mountain2.draw(g);
        bird.draw(g);

        planeEnemy2.draw(g);
        planeMoveByKey.draw(g);
        planeMoveByMouse.draw(g);
        for (PlaneEnemy1 planeEnemy : vectorPlaneEnemy) {
            planeEnemy.draw(g);
        }
        for (PlaneSin planeSin : vectorPlaneSin){
            planeSin.draw(g);
        }

    }

    @Override
    public void run() {
        while (true) {
            count++;
            if(count % Helper.PLANE_SIN_DELAY == 1){
                vectorPlaneSin.add(new PlaneSin(10,100,Helper.ENEMY_BULLET_SPEED));
            }
            bird.update();

            planeEnemy2.update();
            planeMoveByKey.update();
            planeMoveByMouse.update();
            for (PlaneEnemy1 planeEnemy : vectorPlaneEnemy) {
                planeEnemy.update();
            }
            for (PlaneSin planeSin : vectorPlaneSin){
                planeSin.update();
            }

            repaint();


            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

