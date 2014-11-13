package moutonsimulator.Elements;

import GUI.Images;
import moutonsimulator.IntValMax;
import moutonsimulator.Jeu.Case;

public class Plante extends ElementDynamique {

    public int dureePousse;

    public Plante(int ageMax, int vie, int dureePousse, Case c) {
        this.age = new IntValMax(0, ageMax);
        this.vie = new IntValMax(vie);
        this.dureePousse = dureePousse;
        this.image = Images.buisson;
        this.conteneur = c;
    }

    @Override
    public void mort() {
        this.conteneur.setPlante(null);
        this.image = null;
    }

    @Override
    public void update() {
        super.update();
    }

    public IntValMax getVie() {
        return vie;
    }

    public void setVie(IntValMax vie) {
        this.vie = vie;
    }

    public IntValMax getAge() {
        return age;
    }

    public void setAge(IntValMax age) {
        this.age = age;
    }

    public int getDureePousse() {
        return dureePousse;
    }

    public void setDureePousse(int dureePousse) {
        this.dureePousse = dureePousse;
    }

}
