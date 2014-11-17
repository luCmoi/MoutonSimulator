package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import moutonsimulator.Config;
import moutonsimulator.Jeu.ConfigInitial;

public class FenetrePrincipale extends JFrame {

    private PanelPartie pan;

    public FenetrePrincipale() {
        super("Mouton Simulator");
        setLayout(new BorderLayout());
        this.setMaximumSize(new Dimension((Config.coteCase * ConfigInitial.width), (Config.coteCase * ConfigInitial.heigth)));
        this.setResizable(true);
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

}
