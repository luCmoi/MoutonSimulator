package moutonsimulator.Elements;

import moutonsimulator.Jeu.Case;


public class Graine {
    
    private int countDown;
    private int type;
    private Case conteneur;
    
    public Graine(Case c,int type,int countDown){
        this.countDown = countDown;
        this.type =type;
        this.conteneur = c;
    }

    public int getCountDown() {
        return countDown;
    }

    public void setCountDown(int countDown) {
        this.countDown = countDown;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Case getConteneur() {
        return conteneur;
    }

    public void setConteneur(Case conteneur) {
        this.conteneur = conteneur;
    }
    
}
