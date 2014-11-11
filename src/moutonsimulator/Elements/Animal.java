package moutonsimulator.Elements;

import java.util.HashSet;
import moutonsimulator.Config;
import moutonsimulator.IntValMax;
import moutonsimulator.Jeu.Case;

public abstract class Animal extends ElementDynamique {

    private IntValMax vie;
    private IntValMax age;
    private HashSet<Integer> setComp;
    private Arbre arbreGene;

    public void update() {
        mouvementBasique();
    }

    public void mouvementBasique() {
        if (this.conteneur.getX() == 0) {

        }
        if (this.conteneur.getX() == Config.dimensionX - 1) {

        }
        if (this.conteneur.getY() == 0) {

        }
        if (this.conteneur.getY() == Config.dimensionY - 1) {

        }
    }

    public Animal(int vieMax, int ageMax, Arbre arbre, Case c) {
        this.vie = new IntValMax(vieMax);
        this.age = new IntValMax(0, ageMax);
        this.setComp = new HashSet<>();
        this.arbreGene = arbre;
        this.conteneur = c;
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

    public HashSet<Integer> getSetComp() {
        return setComp;
    }

    public void setSetComp(HashSet<Integer> setComp) {
        this.setComp = setComp;
    }

    public Arbre getArbreGene() {
        return arbreGene;
    }

    public void setArbreGene(Arbre arbreGene) {
        this.arbreGene = arbreGene;
    }

    public Case getConteneur() {
        return conteneur;
    }

    public void setConteneur(Case conteneur) {
        this.conteneur = conteneur;
    }

}
