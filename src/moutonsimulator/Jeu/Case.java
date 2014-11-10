package moutonsimulator.Jeu;

import moutonsimulator.Elements.Animal;

public class Case {

    private int x;
    private int y;
    private Animal animal;

    Case(int x, int y) {
        this.x = x;
        this.y = y;
        this.animal = null;
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

}
