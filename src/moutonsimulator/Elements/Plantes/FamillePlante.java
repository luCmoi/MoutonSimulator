package moutonsimulator.Elements.Plantes;

import GUI.Images;
import java.util.ArrayList;
import moutonsimulator.Jeu.Case;
import moutonsimulator.Jeu.Partie;

public class FamillePlante {

    public ArrayList representants;
    public int idImage;
    public CaracteristiquePlante specs;
    public int espece;
    private Partie partie;

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

    public void remove(Plante p) {
        //System.out.println("id : "+idImage+" size : "+Images.banqueImage.size());
        this.representants.remove(p);
        if (this.representants.isEmpty()) {
            System.out.println("remove");
            try{
               Images.banqueImage.get(idImage).flush(); 
            }
            catch(NullPointerException n){
                System.out.println("Suppresion image : nullPointer");
            }
            Images.banqueImage.remove(idImage);
            partie.getFamillesPlante().remove(this);
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
