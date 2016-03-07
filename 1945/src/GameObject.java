import java.awt.image.BufferedImage;

/**
 * Created by Anh on 3/6/2016.
 */
public abstract class GameObject {
    public BufferedImage sprite;
    protected double positionX;
    protected double positionY;

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
}

