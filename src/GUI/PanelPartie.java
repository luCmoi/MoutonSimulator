package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import moutonsimulator.Jeu.Partie;

/**
 * Panel qui contient l'affichage de la partie(la grille)
 */
public class PanelPartie extends JPanel {

    private Partie partie;

    public PanelPartie() {
        super();
        this.setPreferredSize(new Dimension(800, 600));
        this.setLayout(new BorderLayout());
        this.addComponentListener(new PanelListener());
        this.addKeyListener(new PanelKeyListener());
        MouseListenerPanel motion = new MouseListenerPanel();
        this.addMouseListener(motion);
        this.addMouseMotionListener(motion);
        this.addMouseWheelListener(motion);        
        this.setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        partie.render(g2d);
        g.finalize();
        g.dispose();
    }

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    public void execution() {
        this.partie.update();
        this.repaint();
    }
}
