package moutonsimulator.Elements;

import moutonsimulator.Elements.Plantes.Buisson;
import moutonsimulator.Elements.Plantes.Herbe;
import moutonsimulator.Jeu.Case;

public class Mouton extends Herbivore {

    public Mouton(Case c, Arbre arbre) {
        super(c, arbre);
        this.idImage = 1;
        priorite.put(Buisson.class, 5);
        priorite.put(Herbe.class, 5);
        priorite.put(Mouton.class, 10);
        priorite.put(Loup.class, -10);
    }

    @Override
    public void mort() {
        super.mort();
        conteneur.getContainer().getPartie().getSetMouton().remove(this);
    }

    @Override
    public void moove() {
    }
}
