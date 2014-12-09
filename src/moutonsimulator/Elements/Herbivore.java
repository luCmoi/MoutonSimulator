package moutonsimulator.Elements;

import moutonsimulator.Jeu.Case;

public abstract class Herbivore extends Animal {

    public Herbivore(Case c, Arbre arbre) {
        super(c, arbre);
    }

    public Herbivore(Case c, Arbre arbre, CaracteristiqueAnimale specs) {
        super(c, arbre, specs);
    }
}
