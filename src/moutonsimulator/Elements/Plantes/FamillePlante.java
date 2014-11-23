package moutonsimulator.Elements.Plantes;

import GUI.Images;
import java.util.ArrayList;
import moutonsimulator.Jeu.Case;

public class FamillePlante {

    public ArrayList representants;
    public int idImage;
    public CaracteristiquePlante specs;
    public int espece;

    public FamillePlante(int espece, Case c) {
        this.espece = espece;
        this.specs = CaracteristiquePlante.randomSpecs();
        this.idImage = Images.nouvelleImage(espece);
        switch (espece) {
            case 0:
                this.representants = new ArrayList<Herbe>();
                if (c != null) {
                    Herbe h = new Herbe(c, this);
                    c.setPlante(h);
                    representants.add(h);
                }
                break;
            default:
                this.representants = new ArrayList<Buisson>();
                if (c != null) {
                    Buisson b = new Buisson(c, this);
                    c.setPlante(b);
                    representants.add(b);
                }
                break;
        }

    }

    public Plante add(Case c) {
        switch (espece) {
            case 0:
                Herbe h = new Herbe(c, this);
                c.setPlante(h);
                representants.add(h);
                return h;
            default:
                Buisson b = new Buisson(c, this);
                c.setPlante(b);
                representants.add(b);
                return b;
        }
    }
    
    public void remove(Plante p){
        this.representants.remove(p);
        if(this.representants.isEmpty()){
            Images.banqueImage.remove(idImage);
        }
    }

    public ArrayList getRepresentants() {
        return representants;
    }

    public int getIdImage() {
        return idImage;
    }

    public CaracteristiquePlante getSpecs() {
        return specs;
    }

    public int getEspece() {
        return espece;
    }

}
