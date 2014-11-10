package GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class FenetrePrincipale extends JFrame {

    public FenetrePrincipale() {
        super("Mouton Simulator");
        setLayout(new BorderLayout());
        setSize(800, 600);
        this.add(new PanelPartie());
    }
}
