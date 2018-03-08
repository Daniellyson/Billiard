package billard;

import balles.Balle;

import java.awt.*;

public class Piege {
    private Rectangle rectangle;

    public Piege(int x, int y, int largeur, int longueur) {
        rectangle = new Rectangle(x, y, largeur, longueur);
    }

    public void dessine(Graphics graphics) {
        graphics.fillOval(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public boolean disparition(Balle balle) {
        return balle.getRectangle().intersects(rectangle);
    }
}
