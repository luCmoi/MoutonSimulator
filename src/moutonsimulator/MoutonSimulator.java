package moutonsimulator;

import GUI.FenetreCreation;
import GUI.Images;
import moutonsimulator.Jeu.ConfigInitial;

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
        new FenetreCreation();
    }

    public static void nouveau(ConfigInitial conf) {
        BigBoss boss = new BigBoss(conf);
    }
}
