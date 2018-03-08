package balles;

import billard.Billard;
import billard.Paroi;
import billard.Piege;

import javax.swing.*;
import java.awt.*;

public class Balle {
    private Rectangle rectangle;
    private Billard billard;

    //Ball's direction
    private int deltaX;
    private int deltaY;

    //Change the balls' color
    private Color color;
    private int iColor;
    private Color [] colors = {
            Color.BLUE,
            Color.DARK_GRAY,
            Color.CYAN,
            Color.GREEN,
            Color.PINK,
            Color.ORANGE,
            Color.RED,
            Color.YELLOW,
            Color.MAGENTA,
            Color.WHITE,
            Color.GRAY
    };

    private boolean aSupprimer;

    public Balle(Billard billard, int x, int y, int largeur, int longueur) {

        this.rectangle = new Rectangle(x, y, largeur, longueur);
        this.billard = billard;

        //Move
        deltaX = 1;
        deltaY = 1;
        //make the machine to chose the direction
        /*deltaX = (int) ((Math.round(Math.random()) == 0) ? 1 : -1);
        deltaY = (int) ((Math.round(Math.random()) == 0) ? 1 : -1);*/

        color = Color.BLACK;

        aSupprimer = false;

    }


    public void dessine(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillOval(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        //graphics.drawOval(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    //Color changer with the array of colors in a loop.
    public void changeCouleur() {
        color = colors[iColor];
        iColor = (iColor + 1) % colors.length;
    }

    public void bouge() {

        rectangle.x += deltaX;
        rectangle.y += deltaY;

        for(Paroi paroi : billard.getParoisVerticales()) {

            if(paroi.collision(this)){
                deltaX *= -1;
                billard.mettreAjourTotalDesPoints(paroi.getPoints());
            }
        }

        for(Paroi paroi : billard.getParoisHorizontales()){

            if(paroi.collision(this)){
                deltaY *= -1;
                billard.mettreAjourTotalDesPoints(paroi.getPoints());
            }
        }

        for(Balle balle : billard.getBalles()) {
            if(balle != this) {
                if (balle.collision(this)) {
                    deltaX *= -1;
                    deltaY *= -1;
                }
            }
        }

        for(Piege piege : billard.getPieges()) {
            if(piege.disparition(this)) {
                aSupprimer = true;
            }
        }
    }

    public boolean isaSupprimer() {

        return aSupprimer;
    }

    public boolean collision(Balle balle) {

        return balle.getRectangle().intersects(rectangle);
    }

    //Position de la balle avec le X et Y
    public Rectangle getRectangle() {

        return rectangle;
    }
}
