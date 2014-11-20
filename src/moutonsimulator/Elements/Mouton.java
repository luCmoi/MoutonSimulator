package moutonsimulator.Elements;

import GUI.Images;
import moutonsimulator.Jeu.Case;

public class Mouton extends Herbivore {

    public Mouton(Case c, Arbre arbre) {
        super(c, arbre);
        this.image = Images.mouton;
        priorite.put(Plante.class, 5);
        priorite.put(Mouton.class, 10);
        priorite.put(Loup.class, -10);
    }

    /*@Override
    public void mort() {
        super.mort();
        conteneur.getContainer().getPartie().getSetMouton().remove(this);
    */

    @Override
    public void moove() {
    }
}
