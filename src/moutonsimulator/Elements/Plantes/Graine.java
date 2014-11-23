package moutonsimulator.Elements.Plantes;

import moutonsimulator.IntValMax;


public class Graine {
    
    public IntValMax  countDown;
    public FamillePlante famille;
    
    public Graine(FamillePlante famille){
        this.countDown = new IntValMax(famille.getSpecs().dureePousse);
        this.famille = famille;
    }

    public IntValMax getCountDown() {
        return countDown;
    }

    public void setCountDown(IntValMax countDown) {
        this.countDown = countDown;
    }

    public FamillePlante getFamille() {
        return famille;
    }

    public void setFamille(FamillePlante famille) {
        this.famille = famille;
    }

    
}
