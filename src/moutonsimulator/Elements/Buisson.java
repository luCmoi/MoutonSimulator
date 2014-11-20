package moutonsimulator.Elements;

import GUI.Images;
import java.awt.Color;
import moutonsimulator.Jeu.Case;

public class Buisson extends Plante {

    public static final int type = 1;

    public Buisson(CaracteristiquePlante specs, Case c) {
        super(specs, c);
        this.image = Images.conversionModel(Images.buissonModel, new Color(2, 51, 2, 255), new Color(5, 102, 5, 255), new Color(15, 130, 15, 255));
    }

}
