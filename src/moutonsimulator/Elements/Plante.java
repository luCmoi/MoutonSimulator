package moutonsimulator.Elements;

import moutonsimulator.IntValMax;


public class Plante {
    
    private IntValMax vie;
    private IntValMax age;
    private int dureePousse;
    
    public Plante(int ageMax,int vie,int dureePousse){
        this.age = new IntValMax(0, ageMax);
        this.vie = new IntValMax(vie);
        this.dureePousse = dureePousse;
        
    }
    
}
