package moutonsimulator.Jeu;

import GUI.ViewPort;
import java.awt.Graphics2D;
import moutonsimulator.Config;

public class Grille {

    private Case[][] plateau;

    public Grille(int width, int height) {
        this.plateau = new Case[width][height];
        for (int x = 0; x < plateau.length; x++) {
            for (int y = 0; y < plateau[0].length; y++) {
                this.plateau[x][y] = new Case(x, y, this);
            }
        }
    }

    public void update() {
        for (Case[] plateau1 : plateau) {
            for (Case caseTmp : plateau1) {
                caseTmp.update();
            }
        }
    }

    public void render(Graphics2D batch) {
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

    public void setPlateau(Case[][] plateau) {
        this.plateau = plateau;
    }

}
