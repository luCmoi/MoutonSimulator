package moutonsimulator.Elements;

import GUI.Images;
import moutonsimulator.Jeu.Case;


public class Mouton extends Animal{

    public Mouton(int vieMax, int ageMax, Arbre arbre,Case c) {
        super(vieMax, ageMax, arbre,c);
        this.image=Images.mouton;
    }
    
}
