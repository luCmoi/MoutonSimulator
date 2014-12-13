package moutonsimulator.Elements.Plantes;

import GUI.Images;
import java.util.ArrayList;
import moutonsimulator.Jeu.Case;
import moutonsimulator.Jeu.ConfigInitial;
import moutonsimulator.Jeu.Partie;

public class FamillePlante {

    private ArrayList representants;
    private int idImage;
    private CaracteristiquePlante specs;
    private int espece;
    private Partie partie;
    private int compteurGraines;

    public FamillePlante(int espece, Case c) {
        this.espece = espece;
        if (ConfigInitial.modeMinimal) {
            this.specs = CaracteristiquePlante.minimalSpecs();
        } else {
            this.specs = CaracteristiquePlante.randomSpecs();
        }
        this.idImage = Images.nouvelleImage(espece);
        this.compteurGraines = 0;
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
        this.partie = c.getContainer().getPartie();
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

    public void mort() {
        try {
            Images.banqueImage.get(idImage).flush();
        } catch (NullPointerException n) {
        }
        this.specs = null;
        this.representants = null;
        Images.banqueImage.remove(idImage);
        partie.getFamillesPlante().remove(this);
        this.partie = null;
        System.gc();
    }

    public void supGraine() {
        this.compteurGraines--;
        if (this.representants.isEmpty() && compteurGraines <= 0) {
            mort();
        }
    }

    public void remove(Plante p) {
        this.representants.remove(p);
        if (this.representants.isEmpty() && compteurGraines <= 0) {
            mort();
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

    public Partie getPartie() {
        return partie;
    }

    public void setPartie(Partie partie) {
        this.partie = partie;
    }

    public int getCompteurGraines() {
        return compteurGraines;
    }

    public void setCompteurGraines(int compteurGraines) {
        this.compteurGraines = compteurGraines;
    }

}
