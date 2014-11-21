package moutonsimulator.Elements;

import java.awt.Color;
import moutonsimulator.Jeu.Case;


public class Graine {
    
    private int countDown;
    private int type;
    private Case conteneur;
    private Color c1;
    private Color c2;
    private Color c3;
    
    public Graine(Case c,int type,int countDown,Color c1,Color c2,Color c3){
        this.countDown = countDown;
        this.type =type;
        this.conteneur = c;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
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

    public Color getC1() {
        return c1;
    }

    public void setC1(Color c1) {
        this.c1 = c1;
    }

    public Color getC2() {
        return c2;
    }

    public void setC2(Color c2) {
        this.c2 = c2;
    }

    public Color getC3() {
        return c3;
    }

    public void setC3(Color c3) {
        this.c3 = c3;
    }
    
}
