package moutonsimulator.Elements;

import java.util.ArrayList;
import moutonsimulator.IntValMax;
import moutonsimulator.Jeu.Case;

public abstract class Animal extends ElementDynamique {

    protected Arbre arbreGene;
    protected CaracteristiqueAnimale competence;
    protected ArrayList<Class> priorite;

    public Animal(Case c, Arbre arbre) {
        priorite = new ArrayList<>();
        this.competence = CaracteristiqueAnimale.randomCompetences();
        this.arbreGene = arbre;
        this.vie = competence.getVie();
        this.age = competence.getAge();
        this.conteneur = c;
    }

    @Override
    public void update() {
        mouvementBasique();
        super.update();
    }

    public void mange(ElementDynamique el) {
        this.vie.setVal(this.vie.getVal() + el.estMange(this.competence.getPuissance()));
    }

    public abstract void moove();

    public void interaction(ElementDynamique voisin) {
        //Nourriture
        if (this instanceof Herbivore) {
            if (voisin instanceof Plante) {
                this.mange(voisin);
            }
        }
        if (this instanceof Carnivore) {
            if (voisin instanceof Animal && voisin.getClass() != this.getClass()) {
                this.mange(voisin);
            }
        }
        //Reproduction
        if (this.getClass() == voisin.getClass()) {
            //niquenique(voisin);
        }
    }

    @Override
    public void mort() {
        this.conteneur.setAnimal(null);
        this.conteneur.setEngrais(this.conteneur.getEngrais() + this.competence.getEngrais());
        this.image = null;
    }

    public void mouvementBasique() {
        ArrayList<int[]> liste = new ArrayList<>();
        for (int x = conteneur.getX() - competence.getVue(); x < conteneur.getX() + competence.getVue(); x++) {
            for (int y = conteneur.getY() - (competence.getVue() - Math.abs(conteneur.getX() - x)); y < conteneur.getY() + (competence.getVue() - Math.abs(conteneur.getX() - x)); y++) {
                try {
                    Case regarde = conteneur.getContainer().getPlateau()[x][y];
                    if (regarde.getPlante() != null) {
                        if (priorite.contains(regarde.getPlante().getClass())) {
                            int[] tmp = {priorite.indexOf(regarde.getPlante().getClass()) + Math.abs(conteneur.getX() - x) + Math.abs(conteneur.getY() - y), x, y};
                            liste.add(tmp);
                        }
                    }
                    if (regarde.getAnimal() != null) {
                        if (priorite.contains(regarde.getAnimal().getClass())) {
                            int[] tmp = {priorite.indexOf(regarde.getAnimal().getClass()) + Math.abs(conteneur.getX() - x) + Math.abs(conteneur.getY() - y), x, y};
                            liste.add(tmp);
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                }
            }
        }
        if (!liste.isEmpty()) {
            int indice = 0;
            int val = liste.get(0)[0];
            for (int i = 1; i < liste.size(); i++) {
                if (val > liste.get(i)[0]) {
                    indice = i;
                    val = liste.get(i)[0];
                }
            }
            System.out.println("Objectif choisit : " + liste.get(indice)[1] + " " + liste.get(indice)[2]);
        } else {
            System.out.println("Mouvement aléa");
        }
        int nX, nY;
        int cmp = 0;
        while (cmp < 5) {
            nX = (conteneur.getX() - 1) + (int) (Math.random() * 3);
            nY = (conteneur.getY() - 1) + (int) (Math.random() * 3);
            cmp++;
            /* try {
             if (!conteneur.getContainer().getPlateau()[nX][nY].isTraversable()) {
             throw new IndexOutOfBoundsException();
             }
             if (conteneur.getContainer().getPlateau()[nX][nY].presence() && conteneur.getContainer().getPlateau()[nX][nY].getAnimal() != this) {
             if (this.mange(conteneur.getContainer().getPlateau()[nX][nY].getAnimal())) {
             conteneur.getContainer().getPlateau()[nX][nY].getAnimal().mort();
             conteneur.setAnimal(null);
             conteneur = conteneur.getContainer().getPlateau()[nX][nY];
             conteneur.setAnimal(this);
             break;
             } else {
             throw new IndexOutOfBoundsException();
             }
             } else {
             conteneur.setAnimal(null);
             conteneur = conteneur.getContainer().getPlateau()[nX][nY];
             conteneur.setAnimal(this);
             break;
             }

             } catch (IndexOutOfBoundsException e) {
             }*/
        }
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
