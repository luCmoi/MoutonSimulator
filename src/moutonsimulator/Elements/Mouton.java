package moutonsimulator.Elements;

import java.util.ArrayList;
import moutonsimulator.Elements.Plantes.Buisson;
import moutonsimulator.Elements.Plantes.Herbe;
import moutonsimulator.Jeu.Case;

public class Mouton extends Herbivore {

    public Mouton(Case c, Arbre arbre) {
        super(c, arbre);
        this.idImage = 1;
        priorite.put(Buisson.class, 5);
        priorite.put(Herbe.class, 5);
        priorite.put(Mouton.class, 40);
        priorite.put(Loup.class, -10);
    }

    public Mouton(Case c, Arbre arbre, CaracteristiqueAnimale specs) {
        super(c, arbre, specs);
        this.idImage = 1;
        priorite.put(Buisson.class, 5);
        priorite.put(Herbe.class, 5);
        priorite.put(Mouton.class, 40);
        priorite.put(Loup.class, -10);
    }

    @Override
    public void mort() {
        super.mort();
        conteneur.getContainer().getPartie().getSetMouton().remove(this);
    }

    @Override
    public void updatePriorite() {
        priorite.put(Buisson.class, vie.getVal());
        priorite.put(Herbe.class, vie.getVal());
        priorite.put(Mouton.class, (vie.getMax() - vie.getVal()));

    }
   
}
