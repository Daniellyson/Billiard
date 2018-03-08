package myClasses;

import balles.Compteur;
import billard.Billard;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class MyImages extends JPanel {

    private BufferedImage imgCofe;
    private BufferedImage imgBillard;

    public MyImages(Object object) {
        if(object instanceof Compteur) {
            setPreferredSize(new Dimension(70, 70));
            try {
                imgCofe = ImageIO.read(new File("src/java.png"));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(object instanceof Billard) {
            setPreferredSize(new Dimension(570, 350));
            try {
                imgBillard = ImageIO.read(new File("src/billard.jpg"));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);

        graphics.drawImage(imgCofe, 10, 0, 60, 60, this);
        graphics.drawImage(imgBillard, 50, 50, 570, 350, this);
    }
}


