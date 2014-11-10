package GUI;

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
            partie.render(batch);
        }
    }
}
