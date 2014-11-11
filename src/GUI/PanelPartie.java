package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import moutonsimulator.Jeu.ConfigInitial;
import moutonsimulator.Jeu.Partie;

public class PanelPartie extends JPanel {

    public Partie partie;

    public PanelPartie() {
        super();
        this.partie = new Partie(new ConfigInitial(), this);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        partie.render(g2d);
    }

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    public void execution() {
        while (true) {
           this.partie.update();
           this.repaint();
        }
    }
}
