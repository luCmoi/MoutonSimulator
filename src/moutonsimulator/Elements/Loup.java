package moutonsimulator.Elements;

import moutonsimulator.Jeu.Case;

public class Loup extends Carnivore {

    public Loup(Case c, Arbre arbre) {
        super(c, arbre);
        this.idImage = 0;
        priorite.put(Mouton.class, 5);
        priorite.put(Loup.class, 15);

    }

    public Loup(Case c, Arbre arbre, CaracteristiqueAnimale specs) {
        super(c, arbre, specs);
        this.idImage = 0;
        priorite.put(Mouton.class, 5);
        priorite.put(Loup.class, 15);

    }

    @Override
    public void mort() {
        super.mort();
        conteneur.getContainer().getPartie().getSetLoup().remove(this);
    }

    @Override
    public void updatePriorite() {
        priorite.put(Mouton.class, vie.getVal());
        priorite.put(Loup.class, (vie.getMax() - vie.getVal()));
    }
}
