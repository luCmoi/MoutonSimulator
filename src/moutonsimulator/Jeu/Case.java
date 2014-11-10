package moutonsimulator.Jeu;

import moutonsimulator.Elements.Animal;
import moutonsimulator.Elements.Plante;

public class Case {

    private int x;
    private int y;
    private Animal animal;
    private Plante plante;
    public Grille container;

    Case(int x, int y) {
        this.x = x;
        this.y = y;
        this.animal = null;
        this.plante = null;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    void update() {
        this.animal.update();
    }

    public Plante getPlante() {
        return plante;
    }

    public Grille getContainer() {
        return container;
    }

}
