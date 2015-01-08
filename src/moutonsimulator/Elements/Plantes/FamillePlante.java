package moutonsimulator.Elements.Plantes;

import GUI.Images;
import java.util.ArrayList;
import moutonsimulator.Jeu.Case;
import moutonsimulator.Jeu.ConfigInitial;
import moutonsimulator.Jeu.Partie;

public class FamillePlante {

    private ArrayList<Plante> representants = new ArrayList<>();
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
                if (c != null) {
                    Herbe h = new Herbe(c, this);
                    c.setPlante(h);
                    representants.add(h);
                }
                break;
            default:
                if (c != null) {
                    Buisson b = new Buisson(c, this);
                    c.setPlante(b);
                    representants.add(b);
                }
                break;
        }
        this.partie = c.getContainer().getPartie();
    }

    /**
     * Ajout d'une plante a la famille Met a jours ses representents.
     *
     * @param c
     * @return
     */
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

    /**
     * Si la famille n'as plus de representant, elle efface ses champs et met a
     * jours la partie et la banque d'image
     */
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

    /**
     *  Met a jour les representant quand une plante meurt
     *
     *
     */
    public void supGraine() {
        this.compteurGraines--;
        if (this.representants.isEmpty() && compteurGraines <= 0) {
            mort();
        }
    }

    /**
     * Met a jour les representant quand une plante meurt
     *
     * @param p
     */
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
