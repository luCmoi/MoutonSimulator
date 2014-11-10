package moutonsimulator.Elements;

import moutonsimulator.IntValMax;
import moutonsimulator.Jeu.Case;


public class Plante extends ElementDynamique{
    
    private IntValMax vie;
    private IntValMax age;
    private int dureePousse;
    private Case container;
    
    public Plante(int ageMax,int vie,int dureePousse){
        this.age = new IntValMax(0, ageMax);
        this.vie = new IntValMax(vie);
        this.dureePousse = dureePousse;
        
    }

    @Override
    public void update() {
        
    }
    
}
