package moutonsimulator.Elements.Plantes;

import GUI.Images;
import java.util.Stack;
import moutonsimulator.Elements.ElementDynamique;
import moutonsimulator.IntValMax;
import moutonsimulator.Jeu.Case;

public class Plante extends ElementDynamique {

    public FamillePlante famille;
    public IntValMax countDownRepro;

    public Plante(Case c, FamillePlante famille) {
        this.famille = famille;
        this.conteneur = c;
        this.vie = new IntValMax(famille.getSpecs().getVie());
        this.age = new IntValMax(0, famille.getSpecs().getAge());
        this.countDownRepro = new IntValMax(famille.getSpecs().getIntervalReproduction());
        this.idImage = famille.getIdImage();
    }

    @Override
    public void mort() {
        this.famille.remove(this);
        this.conteneur.setPlante(null);
        this.conteneur = null;
        this.age = null;
        this.vie = null;
        this.countDownRepro = null;
    }

    @Override
    public void update() {
        if (countDownRepro.decremente()) {
            reproduction();
            countDownRepro.setVal(famille.getSpecs().getIntervalReproduction());
            //System.out.println("Reproduction");
        }
        super.update();
    }

    public void reproduction() {
        Stack<Case> casePossible = new Stack<>();
        for (int x = Math.max(0, conteneur.getX() - famille.getSpecs().getPorteSpore()); x < Math.min(conteneur.getX() + famille.getSpecs().getPorteSpore(), conteneur.getContainer().getPlateau().length); x++) {
            for (int y = Math.max(0, conteneur.getY() - (famille.getSpecs().getPorteSpore() - Math.abs(conteneur.getX() - x))); y < Math.min(conteneur.getY() + (famille.getSpecs().getPorteSpore() - Math.abs(conteneur.getX() - x)), conteneur.getContainer().getPlateau()[0].length); y++) {
                if (conteneur.getContainer().getPlateau()[x][y].isTraversable() && conteneur.getContainer().getPlateau()[x][y]!=conteneur  && conteneur.getContainer().getPlateau()[x][y].getPlante()==null) {
                    casePossible.add(conteneur.getContainer().getPlateau()[x][y]);
                }
            }
        }
        for (Case c : casePossible) {
            if ((int) (Math.random() * 101) <= famille.getSpecs().getProliferation()) {
                if ((int) (Math.random() * 10001) <= famille.getSpecs().getTauxMutationPlante()) {
                    if (this instanceof Herbe) {
                        //System.out.println("Reprod : new Famille");
                        FamillePlante fp = new FamillePlante(0, c);
                        conteneur.getContainer().getPartie().getFamillesPlante().add(fp);
                    } else {
                        //System.out.println("Reprod : new Famille");
                        FamillePlante fp = new FamillePlante(1, c);
                        conteneur.getContainer().getPartie().getFamillesPlante().add(fp);
                    }
                } else {
                    //System.out.println("Reprod : NORMAL");
                    c.getGraines().add(new Graine(famille));
                    famille.setCompteurGraines(famille.getCompteurGraines()+1);
                }
            }
        }
        casePossible.clear();
    }

    public IntValMax getVie() {
        return vie;
    }

    public void setVie(IntValMax vie) {
        this.vie = vie;
    }

    public IntValMax getAge() {
        return age;
    }

    public void setAge(IntValMax age) {
        this.age = age;
    }

    public FamillePlante getFamille() {
        return famille;
    }

    public void setFamille(FamillePlante famille) {
        this.famille = famille;
    }

    public void setConteneur(Case conteneur) {
        this.conteneur = conteneur;
    }

    public IntValMax getCountDownRepro() {
        return countDownRepro;
    }

    public void setCountDownRepro(IntValMax countDownRepro) {
        this.countDownRepro = countDownRepro;
    }

}
