package moutonsimulator;

import GUI.FenetrePrincipale;
import GUI.ViewPort;
import javax.swing.JFrame;
import moutonsimulator.Jeu.ConfigInitial;
import moutonsimulator.Jeu.Partie;

public class BigBoss {

    Partie partie;
    FenetrePrincipale fenetre;

    public BigBoss() {
        this.fenetre = new FenetrePrincipale();
        this.fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.fenetre.setVisible(true);
        this.partie = new Partie(new ConfigInitial(), fenetre.getPan());
        this.fenetre.getPan().setPartie(partie);
        ViewPort.panel = this.fenetre.getPan();
        ViewPort.resize(this.fenetre.getPan().getWidth(), this.fenetre.getPan().getHeight());
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getId());
                while (true) {
                    try {
                        fenetre.getPan().execution();
                        Thread.currentThread().sleep(500);
                    } catch (InterruptedException ex) {
                    }
                }
            }
        }).start();
    }
}
