package moutonsimulator.Elements;

import java.util.HashSet;
import moutonsimulator.IntValMax;

public abstract class Animal{

    protected IntValMax vie;
    protected IntValMax age;
    protected HashSet<Integer> setComp;
    protected Arbre arbreGene;

    public void update(){
        
    }
    
    public Animal(int vieMax, int ageMax, Arbre arbre) {
        this.vie = new IntValMax(vieMax);
        this.age = new IntValMax(0, ageMax);
        this.setComp = new HashSet<>();
        this.arbreGene = arbre;
    }

}
