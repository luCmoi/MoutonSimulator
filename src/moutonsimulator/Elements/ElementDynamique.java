package moutonsimulator.Elements;

import GUI.Images;
import GUI.ViewPort;
import java.awt.Graphics2D;
import java.awt.Image;
import moutonsimulator.Config;
import moutonsimulator.IntValMax;
import moutonsimulator.Jeu.Case;

public abstract class ElementDynamique {

    protected IntValMax vie;
    protected IntValMax age;
    protected int idImage;//Numero de l'image dans la banque image
    protected Case conteneur;

    /**Mise a jour minimal :
     * Meurt si plus de vie ou trop vieux
     */
    public void update() {
        if (this instanceof Animal) {
            if (this.vie.decremente()) {
                this.mort();
            }
        }
        if (this.age.incremente()) {
            this.mort();
        }
    }

    public abstract void mort();

    /**
     * Baisse la vie quand mange
     * @param puissance
     * @return 
     */
    public int estMange(int puissance){
        int retour;
        if (this.vie.getVal()<=puissance){
            retour = this.vie.getVal();
            this.mort();
        } else {
            retour = puissance;
            this.vie.setVal(this.vie.getVal()-puissance);
        }
        return retour;
    }
    
    /**
     * Dessine son image sur le batch
     * @param batch 
     */
    public void render(Graphics2D batch) {
        batch.drawImage(Images.banqueImage.get(idImage), (conteneur.getX() * Config.coteCase) - (ViewPort.x), (conteneur.getY() * Config.coteCase) - (ViewPort.y), Config.coteCase, Config.coteCase, null);
    }
    
    public Case getConteneur(){
        return conteneur;
    }

    public int getIdImage() {
        return idImage;
    }
}
