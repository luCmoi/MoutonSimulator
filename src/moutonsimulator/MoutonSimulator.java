package moutonsimulator;

import GUI.FenetrePrincipale;
import GUI.Images;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MoutonSimulator {

    public static void main(String[] args) {
        Images.init();
        creerEtAfficherGUI();
    }

    private static void creerEtAfficherGUI() {
        FenetrePrincipale fenetrePrincipale = new FenetrePrincipale();
        fenetrePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetrePrincipale.setVisible(true);
        fenetrePrincipale.execution();
    }

}
