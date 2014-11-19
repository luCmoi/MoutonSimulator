/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moutonsimulator.Elements;

import GUI.Images;
import moutonsimulator.Jeu.Case;

public class Buisson extends Plante {

    public static final int type = 1;

    public Buisson(CaracteristiquePlante specs, Case c) {
        super(specs, c);
        this.image = Images.buisson;
    }

}
