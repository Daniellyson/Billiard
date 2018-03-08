package threads;

import balles.Balle;
import billard.Billard;

import java.util.Iterator;

public class ThreadMouvement extends Thread {
    private Billard billard;

    public ThreadMouvement(Billard billard) {
        super("Mouvement");
        this.billard = billard;
    }

    public void run() {

       try {
           while(true) {
               Thread.sleep(5);
               //One way to move and delete the ball
               Iterator<Balle> balles = billard.getBalles().iterator();
               while(balles.hasNext()) {
                   Balle balle = balles.next();

                   balle.bouge();

                   if(balle.isaSupprimer()) {
                       balles.remove();
                   }
               }
               //Another way to move and delete the ball
               /*
               for(Balle balle : billard.getBalles()){
                   balle.bouge();
               }
               for(int i = 0; i < billard.getBalles().size(); i++) {
                   if(billard.getBalles().get(i).isaSupprimer()) {
                       billard.removerBalle(billard.getBalles().get(i));
                   }
               }
               */
               billard.repaint();
           }
       }
       catch (InterruptedException e) {
           e.printStackTrace();
       }
    }
}