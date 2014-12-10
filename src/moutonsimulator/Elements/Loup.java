package moutonsimulator.Elements;

import moutonsimulator.Jeu.Case;

public class Loup extends Carnivore {

    public Loup(Case c) {
        super(c);
        this.idImage = 0;
        priorite.put(Mouton.class, 5);
        priorite.put(Loup.class, 15);

    }

    public Loup(Case c, Animal pere, Animal mere) {
        super(c, pere, mere);
        this.idImage = 0;
        priorite.put(Mouton.class, 5);
        priorite.put(Loup.class, 15);

    }

    public Loup(Case c, CaracteristiqueAnimale specs) {
        super(c, specs);
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
        getPriorite().put(Mouton.class, vie.getVal());
        getPriorite().put(Loup.class, (vie.getMax() - vie.getVal()));
    }
}
