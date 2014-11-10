package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import moutonsimulator.Jeu.ConfigInitial;
import moutonsimulator.Jeu.Partie;

public class PanelPartie extends JPanel {

    Partie partie;

    public PanelPartie() {
        super();
        this.partie = new Partie(new ConfigInitial());
        while (true) {
            partie.update();
            
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        //Dessein de l'image en fonction du zoom appliqué
        Graphics2D g2d = (Graphics2D) g;
        partie.render(g2d);
    }
}
