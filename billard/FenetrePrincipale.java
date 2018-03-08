package billard;

import balles.FenetrePoints;
import listener.ButoonListener;
import listener.FenetreListener;

import javax.swing.*;
import java.awt.*;


public class FenetrePrincipale extends JFrame {
    private Billard billard;
    private Container container;

    //page 7 ajouter un bouton
    private JPanel startPanel;
    private JButton startButton;


    public FenetrePrincipale() {
        super("Table de Billard");

        //Window size
        setBounds(50, 150, 690, 500);

        //cross bottom close
        addWindowListener(new FenetreListener());

        billard = new Billard();
        container = getContentPane();

        startPanel = new JPanel();
        startButton = new JButton("Start");
        startPanel.add(startButton);
        startButton.setToolTipText("Cliquez pour additionner une balle");
        //startButton.addActionListener(new ButoonListener(billard, startButton));
        startButton.addActionListener(new ButoonListener(billard));

        container.add(billard, BorderLayout.CENTER);
        container.add(startPanel, BorderLayout.SOUTH);

        //Make the whole window visible
        setVisible(true);

        //Send infos from billard to class FenetrePoints
        new FenetrePoints(billard);

    }
}
