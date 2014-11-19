package moutonsimulator.Elements;

import java.util.Stack;
import moutonsimulator.IntValMax;
import moutonsimulator.Jeu.Case;

public class Plante extends ElementDynamique {

    protected CaracteristiquePlante specs;
    protected int countDownRepro;
    public static final int type = 1;

    public Plante(CaracteristiquePlante specs, Case c) {
        this.specs = specs;
        this.age = specs.getAge();
        this.vie = specs.getVie();
        this.countDownRepro = specs.getDureeReproduction();
        this.conteneur = c;
    }

    @Override
    public void mort() {
        this.conteneur.setPlante(null);
        this.image = null;
    }

    @Override
    public void update() {
        if (--countDownRepro == 0) {
            reproduction();
        }
        super.update();
    }

    public void reproduction() {
        Stack<Case> casePossible = new Stack<>();
        for (int x = Math.max(0, conteneur.getX() - specs.getPorteSpore()); x < Math.min(conteneur.getX() + specs.getPorteSpore(), conteneur.getContainer().getPlateau().length); x++) {
            for (int y = Math.max(0, conteneur.getY() - (specs.getPorteSpore() - Math.abs(conteneur.getX() - x))); y < Math.min(conteneur.getY() + (specs.getPorteSpore() - Math.abs(conteneur.getX() - x)), conteneur.getContainer().getPlateau().length); y++) {
                if (conteneur.getContainer().getPlateau()[x][y].isTraversable()) {
                    casePossible.add(conteneur.getContainer().getPlateau()[x][y]);
                }
            }
        }
        for (Case c : casePossible) {
            if ((int) (Math.random() * 101) < specs.getProliferation()) {
                c.getGraines().add(new Graine(c, (this).type, specs.getDureePousse()));//je sais pas si pour le type ça vas marcher
            }
        }
        this.countDownRepro = specs.getDureeReproduction();
        casePossible.clear();
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
}
