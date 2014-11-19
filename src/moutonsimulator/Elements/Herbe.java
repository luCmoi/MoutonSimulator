/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moutonsimulator.Elements;

import GUI.Images;
import moutonsimulator.Jeu.Case;

public class Herbe extends Plante{
    
    public static final int type = 0;

    public Herbe(CaracteristiquePlante specs, Case c) {
        super(specs, c);
        image = Images.hauteHerbe;
    }
    
}
