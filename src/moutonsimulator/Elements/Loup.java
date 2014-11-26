package moutonsimulator.Elements;

import GUI.Images;
import moutonsimulator.Jeu.Case;

public class Loup extends Carnivore {

    public Loup(Case c, Arbre arbre) {
        super(c, arbre);
        this.image = Images.loup;
        priorite.put(Mouton.class, 10);
        priorite.put(Loup.class, 5);
        
    }

    public boolean inRange(Case c) {
        int d = ((conteneur.getX() - c.getX()) * (conteneur.getX() - c.getX())) + ((conteneur.getY() - c.getY()) * (conteneur.getY() - c.getY()));
        return d <= competence.getVue();
    }
    
    @Override
    public void mort(){
       super.mort();
       conteneur.getContainer().getPartie().getSetLoup().remove(this);
    }

    @Override
    public void moove() {
    }
}
