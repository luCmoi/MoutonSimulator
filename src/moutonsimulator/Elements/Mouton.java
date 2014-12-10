package moutonsimulator.Elements;

import java.util.ArrayList;
import moutonsimulator.Elements.Plantes.Buisson;
import moutonsimulator.Elements.Plantes.Herbe;
import moutonsimulator.Jeu.Case;

public class Mouton extends Herbivore {

    public Mouton(Case c) {
        super(c);
         if(this.sexe){
            this.idImage = 1;
        }else{
            this.idImage = 2;
        }
        priorite.put(Buisson.class, 5);
        priorite.put(Herbe.class, 5);
        priorite.put(Mouton.class, 40);
        priorite.put(Loup.class, -10);
    }

    public Mouton(Case c,Animal pere,Animal mere) {
        super(c,pere,mere);
        if(this.sexe){
            this.idImage = 1;
        }else{
            this.idImage = 2;
        }
        priorite.put(Buisson.class, 5);
        priorite.put(Herbe.class, 5);
        priorite.put(Mouton.class, 40);
        priorite.put(Loup.class, -10);
    }
    
    public Mouton(Case c,  CaracteristiqueAnimale specs) {
        super(c, specs);
         if(this.sexe){
            this.idImage = 1;
        }else{
            this.idImage = 2;
        }
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
        getPriorite().put(Buisson.class, vie.getVal());
        getPriorite().put(Herbe.class, vie.getVal());
        getPriorite().put(Mouton.class, (vie.getMax() - vie.getVal()));

    }
}
