package moutonsimulator.Jeu;

import GUI.ViewPort;
import java.awt.Color;
import java.awt.Graphics2D;
import moutonsimulator.Config;
import moutonsimulator.Elements.Plaine;

/**
 * La grille contient un tableau de cases représentant le plateau de la partie
 */
public class Grille {

    private final Case[][] plateau;
    private final Partie partie;

    public Grille(int width, int height,Partie p) {
        this.partie = p;
        this.plateau = new Case[width][height];
        for (int x = 0; x < plateau.length; x++) {
            for (int y = 0; y < plateau[0].length; y++) {
                this.plateau[x][y] = new Case(x, y, this,new Plaine());
            }
        }
    }

    /**
     * Met a jour toutes les cases de la partie
     */
    public void update() {
        for (Case[] plateau1 : plateau) {
            for (Case caseTmp : plateau1) {
                caseTmp.update();
            }
        }
    }

    /**
     * Préviens les cases présentes dans le ViewPort de s'afficher
     * @param batch 
     */
    public void render(Graphics2D batch) {
        batch.setColor(Color.DARK_GRAY);
        batch.fillRect(0, 0, partie.getPan().getWidth(), partie.getPan().getHeight());
        int moduloX = 0;
        int viewXTmp = (ViewPort.width - (Config.coteCase - (ViewPort.x % Config.coteCase)));
        int caseX = (ViewPort.x / Config.coteCase) + (viewXTmp / Config.coteCase);
        if (viewXTmp % Config.coteCase != 0) {
            moduloX = 1;
        }
        int moduloY = 0;
        int viewYTmp = (ViewPort.height - (Config.coteCase - (ViewPort.y % Config.coteCase)));
        int caseY = (ViewPort.y / Config.coteCase) + (viewYTmp / Config.coteCase);
        if (viewYTmp % Config.coteCase != 0) {
            moduloY = 1;
        }
        for (int x = ViewPort.x / Config.coteCase; x <= caseX + moduloX; x++) {
            for (int y = ViewPort.y / Config.coteCase; y <= caseY + moduloY; y++) {
                plateau[x][y].render(batch);
            }
        }
    }

    public Case[][] getPlateau() {
        return plateau;
    }

    public Partie getPartie() {
        return partie;
    }

}
