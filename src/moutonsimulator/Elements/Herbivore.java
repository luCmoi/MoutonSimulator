package moutonsimulator.Elements;

import moutonsimulator.Jeu.Case;

public abstract class Herbivore extends Animal {

    public Herbivore(Case c) {
        super(c);
    }
    
    public Herbivore(Case c,Animal pere,Animal mere){
        super(c, pere, mere);
    }

    public Herbivore(Case c, CaracteristiqueAnimale specs) {
        super(c, specs);
    }
}
