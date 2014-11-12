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
        for (int x = ViewPort.x / Config.coteCase; x <= (ViewPort.width / Config.coteCase) + 1 + (ViewPort.x / Config.coteCase); x++) {
            for (int y = ViewPort.y / Config.coteCase; y <= (ViewPort.height / Config.coteCase) + 1 + (ViewPort.y / Config.coteCase); y++) {
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
