package listener;

import balles.Balle;
import billard.Billard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButoonListener implements ActionListener {
    private Billard billard;

    public ButoonListener(Billard billard) {
        this.billard = billard;
    }

    public void actionPerformed(ActionEvent event) {
        billard.additionnerBalle(new Balle(billard, 425, 80, 25, 25));
    }
}
