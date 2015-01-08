package moutonsimulator;

import GUI.FenetrePrincipale;
import GUI.ViewPort;
import javax.swing.JFrame;
import moutonsimulator.Jeu.ConfigInitial;
import moutonsimulator.Jeu.Partie;

/**
 * Class gérant tous les élément du programme ainsi que le multiThreading
 * (thread principal et celui des "tick" de la partie
 */
public class BigBoss {

    private final Partie partie;
    private final FenetrePrincipale fenetre;

    public BigBoss(ConfigInitial conf) {
        this.fenetre = new FenetrePrincipale();
        this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.fenetre.setVisible(true);
        this.partie = new Partie(conf, fenetre.getPan());
        this.fenetre.getPan().setPartie(partie);
        ViewPort.panel = this.fenetre.getPan();
        ViewPort.resize(this.fenetre.getPan().getWidth(), this.fenetre.getPan().getHeight());
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        fenetre.getPan().execution();
                        fenetre.getOver().update();
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        }).start();
    }
}
