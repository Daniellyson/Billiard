package threads;

import balles.Balle;
import billard.Billard;

public class ThreadCouleur extends Thread {
    private Billard billard;

    public ThreadCouleur(Billard billard) {
        super("Color thread");
        this.billard = billard;
    }

    public void run() {
        try {
            while(true) {
                Thread.sleep(500);
                for(Balle balle : billard.getBalles()) {
                    balle.changeCouleur();
                }
                billard.repaint();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
