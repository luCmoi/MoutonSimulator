package moutonsimulator.Elements;

import GUI.Images;
import moutonsimulator.Jeu.Case;

public class Loup extends Animal{
    
    public Loup(Case c, Arbre arbre){
        super(c, arbre);
        this.image=Images.loup;
    }

    @Override
    public boolean mange(ElementDynamique el) {
       return (el instanceof Mouton);
    }
    
}
