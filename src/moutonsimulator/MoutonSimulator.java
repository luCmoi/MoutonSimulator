package moutonsimulator;

import GUI.FenetrePrincipale;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MoutonSimulator {
        public static void main(String[] args) {
            //kjdfuibdfgi
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                creerEtAfficherGUI();
            }
        });
    }

    private static void creerEtAfficherGUI() {
        FenetrePrincipale fenetrePrincipale = new FenetrePrincipale();
        fenetrePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetrePrincipale.setVisible(true);
    }
    
}
