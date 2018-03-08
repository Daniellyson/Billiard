package billard;

import balles.Balle;

import java.awt.*;

public class Paroi {
    private Rectangle rectangle;
    private int points;

    public Paroi(int x, int y, int largeur, int longueur, int points) {
        rectangle = new Rectangle(x, y, largeur, longueur);
        this.points = points;
    }

    public void dessine(Graphics graphics) {
        graphics.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public Rectangle getRectangle() {

        return rectangle;
    }

    public boolean collision(Balle balle) {

        return rectangle.intersects(balle.getRectangle());
    }

    public int getPoints() {

        return points;
    }
}
