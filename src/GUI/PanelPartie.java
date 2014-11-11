package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(PanelPartie.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.partie.update();
<<<<<<< HEAD
        System.out.println("Epaint");
        this.repaint();
        System.out.println("Je tourne salop");
=======
        this.repaint();
>>>>>>> 2403b66ca8afbfee817ff495cc32c6fa5e90b6dd
    }
}
