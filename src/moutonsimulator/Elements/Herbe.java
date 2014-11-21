package moutonsimulator.Elements;

import GUI.Images;
import java.awt.Color;
import moutonsimulator.Jeu.Case;

public class Herbe extends Plante {

    public static final int type = 0;

    public Herbe(CaracteristiquePlante specs, Case c) {
        super(specs, c);
        this.image = Images.conversionModel(Images.hauteHerbeModel, new Color(0, 51, 0, 255), new Color(0, 102, 0, 255), new Color(0, 153, 0, 255));
    }

}
