package GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class FenetrePrincipale extends JFrame {

    private PanelPartie pan;

    public FenetrePrincipale() {
        super("Mouton Simulator");
        setLayout(new BorderLayout());
        setSize(800, 600);
        pan = new PanelPartie();
        this.setContentPane(pan);
        this.setVisible(true);
        System.out.println(Thread.currentThread().getId());
    }

    public PanelPartie getPan() {
        return pan;
    }

    public void setPan(PanelPartie pan) {
        this.pan = pan;
    }

}
