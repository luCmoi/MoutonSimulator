package moutonsimulator.Elements;

import moutonsimulator.Jeu.Case;

public abstract class Carnivore extends Animal{

    public Carnivore(Case c) {
        super(c);
    }
    
    public Carnivore(Case c,Animal pere,Animal mere){
        super(c, pere, mere);
    }
    public Carnivore(Case c, CaracteristiqueAnimale specs) {
        super(c, specs);
    }
}
