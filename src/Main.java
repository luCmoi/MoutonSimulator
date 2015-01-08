

import GUI.FenetreCreation;
import GUI.Images;
import moutonsimulator.Jeu.ConfigInitial;
import moutonsimulator.BigBoss;

public class Main {

    public static void main(String[] args) {
        Images.init();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                creerEtAfficherGUI();
            }
        });
    }

    private static void creerEtAfficherGUI() {
        new FenetreCreation();
    }
}
