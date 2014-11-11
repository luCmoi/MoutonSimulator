package moutonsimulator.Jeu;

import java.awt.Graphics2D;

public class Grille {

    private Case[][] plateau;

    public Grille(int width, int height) {
        this.plateau = new Case[width][height];
        for (int x = 0; x < plateau.length; x++) {
            for (int y = 0; y < plateau.length; y++) {
                this.plateau[x][y] = new Case(x, y,this);
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
        for (Case[] plateau1 : plateau) {
            for (Case caseTmp : plateau1) {
                caseTmp.render(batch);
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
