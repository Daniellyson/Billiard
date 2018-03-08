package balles;

import billard.Billard;
import listener.FenetreListener;

import javax.swing.*;
import java.awt.*;

public class FenetrePoints extends JFrame {
    private Billard billard;
    private Container container;
    private Compteur compteur;

    public FenetrePoints(Billard billard) {
        super("Compteur des points");
        this.billard = billard;

        setBounds(80, 50, 300, 100);

        addWindowListener(new FenetreListener());

        compteur = new Compteur(billard);
        container = getContentPane();
        container.add(compteur);

        setVisible(true);
    }
}
