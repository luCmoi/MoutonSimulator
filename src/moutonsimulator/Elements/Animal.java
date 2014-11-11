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

    @Override
    public void update() {
        mouvementBasique();
    }

    public void mouvementBasique() {
        int nX, nY;
        while (true) {
            nX = (conteneur.getX() - 1) + (int) (Math.random() * 3);
            nY = (conteneur.getY() - 1) + (int) (Math.random() * 3);
            try {
                if (conteneur.getContainer().getPlateau()[nX][nY].getAnimal() == null) {
                    conteneur = conteneur.getContainer().getPlateau()[nX][nY];
                    break;
                }
            } catch (Exception e) {

            }
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
