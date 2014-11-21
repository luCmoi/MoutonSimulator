package moutonsimulator.Elements;

import GUI.Images;
import java.awt.Color;
import moutonsimulator.Jeu.Case;

public class Buisson extends Plante {

    public static final int type = 1;

    public Buisson(CaracteristiquePlante specs, Case c) {
        super(specs, c);
        this.c1 = new Color(2, 51, 2, 255);
        this.c2 = new Color(5, 102, 5, 255);
        this.c3 = new Color(15, 130, 15, 255);
        this.image = Images.conversionModel(Images.buissonModel, c1, c2, c3);
    }
    
     public Buisson(CaracteristiquePlante specs, Case c,Color c1,Color c2,Color c3) {
        super(specs, c,c1,c2,c3);
        this.image = Images.conversionModel(Images.buissonModel, c1, c2, c3);
    }

}
