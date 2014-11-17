package moutonsimulator.Elements;

import java.awt.Point;


public class Noeud {
    float cout_g;
    float cout_h;
    float cout_f;
    Point parent; 
    
    public Noeud(){
        this.cout_f=0;
        this.cout_g=0;
        this.cout_h=0;
        this.parent=new Point(0,0);
    }
}
