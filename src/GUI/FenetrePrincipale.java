package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import moutonsimulator.Config;
import moutonsimulator.Jeu.ConfigInitial;

public class FenetrePrincipale extends JFrame {

    private PanelSplit split;
    private PanelOverview over;
    private PanelPartie pan;
    
    public FenetrePrincipale() {
        super("Mouton Simulator");
        setLayout(new BorderLayout());
        this.setResizable(true);
        setSize(new Dimension((Config.coteCase * ConfigInitial.width), (Config.coteCase * ConfigInitial.heigth)));
        pan = new PanelPartie();
        over = new PanelOverview(pan);
        split = new PanelSplit(pan, over,getSize().width);
        this.setContentPane(split);
        this.setVisible(true);
    }

    public PanelPartie getPan() {
        return pan;
    }

    public void setPan(PanelPartie pan) {
        this.pan = pan;
    }

    public PanelSplit getSplit() {
        return split;
    }

    public void setSplit(PanelSplit split) {
        this.split = split;
    }

    public PanelOverview getOver() {
        return over;
    }

    public void setOver(PanelOverview over) {
        this.over = over;
    }

}
