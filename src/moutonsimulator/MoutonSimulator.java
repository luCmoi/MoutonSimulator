package moutonsimulator;

import GUI.Images;

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
        BigBoss boss= new BigBoss();
    }

}
