package moutonsimulator.Elements;

import GUI.Images;
import moutonsimulator.Jeu.Case;


public class Mouton extends Herbivore{

    public Mouton(Case c,Arbre arbre) {
        super(c, arbre);
        this.image=Images.mouton;
        priorite.add(Plante.class);
        priorite.add(Mouton.class);
    }

    @Override
    public void moove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
