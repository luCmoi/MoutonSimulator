package moutonsimulator.Elements;

import GUI.Images;
import java.awt.Color;
import moutonsimulator.Jeu.Case;

public class Herbe extends Plante {

    public static final int type = 0;

    public Herbe(CaracteristiquePlante specs, Case c) {
        super(specs, c);
        this.c1 = new Color(0, 51, 0, 255);
        this.c2 = new Color(0, 102, 0, 255);
        this.c3 = new Color(0, 153, 0, 255);
        this.image = Images.conversionModel(Images.hauteHerbeModel, c1, c2, c3);
    }
    
    public Herbe(CaracteristiquePlante specs, Case c,Color c1,Color c2,Color c3) {
        super(specs, c,c1,c2,c3);
        this.image = Images.conversionModel(Images.hauteHerbeModel, c1, c2, c3);
    }

}
