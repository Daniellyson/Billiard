package billard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import balles.Balle;
import myClasses.MyImages;
import threads.ThreadCouleur;
import threads.ThreadMouvement;

public class Billard extends JPanel {
    private List<Paroi> paroisVerticales;
    private List<Paroi> paroisHorizontales;

    private List<Balle> balles;

    private List<Piege> pieges;

    private int totalDesPoints;
    private static final int NB_POINTS_OBSTACLES = 10;
    private static final int NB_POINTS_PAROIS = 0;

    //thread occurrence to start the ball with a start();
    private ThreadMouvement threadMouvement;

    private ThreadCouleur threadCouleur;



    public Billard() {
        ArrayList<Paroi> verticales = new ArrayList<>();
        paroisVerticales = Collections.synchronizedList(verticales);
        ArrayList<Paroi> horizontales = new ArrayList<>();
        paroisHorizontales = Collections.synchronizedList(horizontales);

        ArrayList<Balle> balle = new ArrayList<>();
        balles = Collections.synchronizedList(balle);

        ArrayList<Piege> piege = new ArrayList<>();
        pieges = Collections.synchronizedList(piege);

        //table 570 x 350
        paroisVerticales.add(new Paroi(50, 50, 1, 350, NB_POINTS_PAROIS));
        paroisVerticales.add(new Paroi(620, 50, 1, 350, NB_POINTS_PAROIS));

        paroisHorizontales.add(new Paroi(50, 50, 570, 1, NB_POINTS_PAROIS));
        paroisHorizontales.add(new Paroi(50, 400, 570, 1, NB_POINTS_PAROIS));


        //My Images
        this.setLayout(new BorderLayout());
        MyImages myImages = new MyImages(this);
        this.add(myImages, BorderLayout.CENTER);


        //Obstacles middle left
        paroisVerticales.add(new Paroi(160, 200, 1, 50, NB_POINTS_OBSTACLES));
        paroisVerticales.add(new Paroi(180, 200, 1, 50, NB_POINTS_OBSTACLES));
        paroisHorizontales.add(new Paroi(160, 200, 20, 1, NB_POINTS_OBSTACLES));
        paroisHorizontales.add(new Paroi(160, 250, 20, 1, NB_POINTS_OBSTACLES));
        //Obstacles middle
        /*paroisVerticales.add(new Paroi(320, 200, 1, 50, NB_POINTS_OBSTACLES));
        paroisVerticales.add(new Paroi(340, 200, 1, 50, NB_POINTS_OBSTACLES));
        paroisHorizontales.add(new Paroi(320, 200, 20, 1, NB_POINTS_OBSTACLES));
        paroisHorizontales.add(new Paroi(320, 250, 20, 1, NB_POINTS_OBSTACLES));*/
        //Obstacles middle right
        paroisVerticales.add(new Paroi(480, 200, 1, 50, NB_POINTS_OBSTACLES));
        paroisVerticales.add(new Paroi(500, 200, 1, 50, NB_POINTS_OBSTACLES));
        paroisHorizontales.add(new Paroi(480, 200, 20, 1, NB_POINTS_OBSTACLES));
        paroisHorizontales.add(new Paroi(480, 250, 20, 1, NB_POINTS_OBSTACLES));


        pieges.add(new Piege(49, 49, 30, 30)); //Up Left
        pieges.add(new Piege(592, 49, 30, 30)); //Up Right
        pieges.add(new Piege(49, 372, 30, 30)); //Down Left
        pieges.add(new Piege(592, 372, 30, 30)); //Down Right
        pieges.add(new Piege(315, 49, 30, 30)); //Middle Up
        pieges.add(new Piege(315, 372, 30, 30)); //Middle Down

        //Move the ball
        threadMouvement = new ThreadMouvement(this);
        threadMouvement.start();

        //Change colors
        threadCouleur = new ThreadCouleur(this);
        threadCouleur.start();

    }

    public List<Paroi> getParoisHorizontales() {
        return paroisHorizontales;
    }
    //used in bouge()↑↓
    public List<Paroi> getParoisVerticales() {
        return paroisVerticales;
    }

    public List<Balle> getBalles() {
        return balles;
    }
    /*public Balle getBalle() {
        return balle;
    }*/

    public List<Piege> getPieges() {
        return pieges;
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);

        /*//Table without image, green background
        //Fill rectangle (base) gray
        graphics.fillRect(30, 30, 610, 390);
        //Fill rectangle green 2nd layer
        graphics.setColor(new Color(0,102,51));
        graphics.fillRect(50,50,570,350);*/


        //Border Billard extern
        graphics.fillRect(30, 30, 20, 371); //Left
        graphics.fillRect(50, 30, 590, 20); //Up
        graphics.fillRect(620, 50, 20, 370); //Right
        graphics.fillRect(30, 400, 590, 20); //Down

        //Color to the vertical obstacles
        graphics.setColor(new Color(142,42,13));
        graphics.fillRect(160, 200, 20, 50); // Left
        //graphics.fillRect(320, 200, 20, 50); //Middle
        graphics.fillRect(480, 200, 20, 50); //Right


        for(Paroi paroi : paroisVerticales){
            paroi.dessine(graphics);
        }
        for(Paroi paroi : paroisHorizontales){
            paroi.dessine(graphics);
        }
        for(Balle balle : balles) {
            balle.dessine(graphics);
        }
        for(Piege piege : pieges) {
            graphics.setColor(new Color(142,42,13));
           // graphics.setColor(Color.BLACK);
            piege.dessine(graphics);
        }
    }

    public void removerBalle(Balle balle) {
        balles.remove(balle);
    }

    public void additionnerBalle(Balle balle) {
        balles.add(balle);
    }

    public void mettreAjourTotalDesPoints(int point) {
        totalDesPoints += point;
    }

    public int getTotalDesPoints() {
        return totalDesPoints;
    }
}
