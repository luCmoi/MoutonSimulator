package GUI;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class FenetrePrincipale extends JFrame {

    public PanelPartie pan;

    public FenetrePrincipale() {
        super("Mouton Simulator");
        setLayout(new BorderLayout());
        setSize(800, 600);
        pan = new PanelPartie();
        this.setContentPane(pan);
        this.setVisible(true);
    }

    public PanelPartie getPan() {
        return pan;
    }

    public void setPan(PanelPartie pan) {
        this.pan = pan;
    }

    public void execution() {
        while (true) {
            this.pan.execution();
        }
    }
}
