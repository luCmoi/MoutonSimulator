package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import moutonsimulator.Config;
import moutonsimulator.Jeu.ConfigInitial;

/**
 * Fenêtre principale du programme qui affiche continent l'affichage de la grille a l'aide d'un ViewPort et un panel Overview
 */
public class FenetrePrincipale extends JFrame {

    private final PanelSplit split;
    private final PanelOverview over;
    private PanelPartie pan;
    
    public FenetrePrincipale() {
        super("Mouton Simulator");
        setLayout(new BorderLayout());
        this.setResizable(true);
        setSize(new Dimension(Math.min((Config.coteCase * ConfigInitial.width),1920), Math.min((Config.coteCase * ConfigInitial.heigth),1080)));
        pan = new PanelPartie();
        over = new PanelOverview(pan);
        split = new PanelSplit(pan, over,getSize().width);
        this.setContentPane(split);
        this.setVisible(true);
        this.setBackground(Color.yellow);
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

    public PanelOverview getOver() {
        return over;
    }

}
