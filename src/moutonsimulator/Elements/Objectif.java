package moutonsimulator.Elements;

import moutonsimulator.Jeu.Case;

public class Objectif {

    private int point;
    private Case proprietaire;
    private Case cible;

    public Objectif(Case prop, Case cible) {
        this.proprietaire = prop;
        this.cible = cible;
        this.point = 0;
    }

    public int evaluation() {
        int valeurAnimal = 1000;
        int valeurPlante = 1000;
        if (proprietaire.getAnimal() == null) {
            return 100000;
        } else {
        }

        if (cible.getAnimal() != null) {
            if (proprietaire.getAnimal().getPriorite().containsKey(cible.getAnimal().getClass())) {
                valeurAnimal = proprietaire.getAnimal().getPriorite().get(cible.getAnimal().getClass());
                valeurAnimal *= ((proprietaire.getX() - cible.getX()) * (proprietaire.getX() - cible.getX())) + ((proprietaire.getY() - cible.getY()) * (proprietaire.getY() - cible.getY()));
            }
        }
        if (cible.getPlante() != null) {
            if (proprietaire.getAnimal().getPriorite().containsKey(cible.getPlante().getClass())) {
                valeurPlante = proprietaire.getAnimal().getPriorite().get(cible.getPlante().getClass());
                valeurPlante *= ((proprietaire.getX() - cible.getX()) * (proprietaire.getX() - cible.getX())) + ((proprietaire.getY() - cible.getY()) * (proprietaire.getY() - cible.getY()));
            }
        }

        return point = Math.min(valeurAnimal, valeurPlante);
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public Case getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Case proprietaire) {
        this.proprietaire = proprietaire;
    }

    public Case getCible() {
        return cible;
    }

    public void setCible(Case cible) {
        this.cible = cible;
    }

}
