package threads;

import balles.Compteur;

public class ThreadComptagePoints extends Thread{
    private Compteur compteur;

    public ThreadComptagePoints(Compteur compteur) {
        super("Compteur");
        this.compteur = compteur;
    }

    public void run() {

        try {
            while(true) {
                compteur.repaint();
                Thread.sleep(10);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
