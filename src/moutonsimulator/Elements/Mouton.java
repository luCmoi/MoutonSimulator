package moutonsimulator.Elements;

import GUI.Images;
import moutonsimulator.Jeu.Case;


public class Mouton extends Animal{

    public Mouton(Case c,Arbre arbre) {
        super(c, arbre);
        this.image=Images.mouton;
    }
    
    @Override
    public boolean mange(ElementDynamique el) {
       return (el instanceof Plante);
    }

    @Override
    public void moove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
