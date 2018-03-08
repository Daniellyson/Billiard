package balles;

import billard.Billard;
import threads.ThreadComptagePoints;

import javax.swing.*;
import java.awt.*;
//input the image in the compteur
import myClasses.MyImages;

public class Compteur extends JPanel{
    private Billard billard;
    private ThreadComptagePoints comptagePoints;

    //image in compteur
    private MyImages myImages;

    public Compteur(Billard billard) {
        this.billard = billard;

        this.setLayout(new BorderLayout());
        myImages = new MyImages(this);
        this.add(myImages, BorderLayout.WEST);

        comptagePoints = new ThreadComptagePoints(this);
        comptagePoints.start();
    }

    public void paint(Graphics graphics) {

        super.paint(graphics);
        graphics.setFont(new Font("TimesRoman", Font.BOLD, 30));
        graphics.setColor(new Color(0,102,51));
        graphics.drawString(String.valueOf(billard.getTotalDesPoints()), 125, 50);
    }
}
