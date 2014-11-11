package moutonsimulator.Elements;

import GUI.Images;
import moutonsimulator.Jeu.Case;

public class Loup extends Animal{
    
    public Loup(int vieMax, int ageMax,Arbre arbre,Case c){
        super(vieMax, ageMax, arbre,c );
        this.image=Images.loup;
    }
    
}
