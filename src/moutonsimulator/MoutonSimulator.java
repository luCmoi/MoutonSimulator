package moutonsimulator;

import GUI.FenetrePrincipale;
import GUI.Images;
import javax.swing.JFrame;

public class MoutonSimulator {

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
        FenetrePrincipale fenetrePrincipale = new FenetrePrincipale();
        fenetrePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetrePrincipale.setVisible(true);
        fenetrePrincipale.execution();
    }

}
