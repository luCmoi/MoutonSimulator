package moutonsimulator.Elements;

import moutonsimulator.Jeu.Case;

public class Loup extends Carnivore {

    public Loup(Case c, Arbre arbre) {
        super(c, arbre);
        this.idImage = 0;
        priorite.put(Mouton.class, 5);
        priorite.put(Loup.class, 15);
        
    }
    @Override
    public void mort(){
       super.mort();
       conteneur.getContainer().getPartie().getSetLoup().remove(this);
    }
}
