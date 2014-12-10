package moutonsimulator.Elements;

import moutonsimulator.Jeu.Case;

public abstract class Carnivore extends Animal{

    public Carnivore(Case c, Arbre arbre) {
        super(c, arbre);
    }
    public Carnivore(Case c, Arbre arbre,CaracteristiqueAnimale specs) {
        super(c, arbre,specs);
    }
}
