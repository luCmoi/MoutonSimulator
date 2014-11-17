package moutonsimulator.Elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;
import moutonsimulator.IntValMax;
import moutonsimulator.Jeu.Case;

public abstract class Animal extends ElementDynamique {

    protected Arbre arbreGene;
    protected CaracteristiqueAnimale competence;
    protected HashMap<Class, Integer> priorite;
    protected Boolean aBouge=false;

    public Animal(Case c, Arbre arbre) {
        priorite = new HashMap<>();
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

    public void mouvementAleatoire() {
        Stack<Case> casePossible = new Stack<>();
        for (int x = Math.max(0, conteneur.getX() - 1); x < Math.min(conteneur.getX() + 2, conteneur.getContainer().getPlateau().length); x++) {
            for (int y = Math.max(0, conteneur.getY() - 1); y < Math.min(conteneur.getY() + 2, conteneur.getContainer().getPlateau()[0].length); y++) {
                if (conteneur.getContainer().getPlateau()[x][y].isTraversable() && conteneur.getContainer().getPlateau()[x][y].getAnimal() == null) {
                    casePossible.add(conteneur.getContainer().getPlateau()[x][y]);
                }
            }
        }
        if (casePossible.isEmpty()) {
            System.out.println("peut pas bouger");
            return;
        }
        Collections.shuffle(casePossible);
        Case tmp = casePossible.pop();
        conteneur.setAnimal(null);
        tmp.setAnimal(this);
        this.conteneur = tmp;
    }

    public void mouvementDirige(Case c) {
        mouvementAleatoire();
    }

    public void mouvementBasique() {
        if (!aBouge) {
            aBouge=true;
            ArrayList<Objectif> objectifs = new ArrayList();
            for (int x = Math.max(0, conteneur.getX() - competence.getVue()); x < Math.min(conteneur.getX() + competence.getVue(), conteneur.getContainer().getPlateau().length); x++) {
                for (int y = Math.max(0, conteneur.getY() - (competence.getVue() - Math.abs(conteneur.getX() - x))); y < Math.min(conteneur.getY() + (competence.getVue() - Math.abs(conteneur.getX() - x)), conteneur.getContainer().getPlateau().length); y++) {
                    if (conteneur.getContainer().getPlateau()[x][y].getAnimal() != null) {
                        if (priorite.keySet().contains(conteneur.getContainer().getPlateau()[x][y].getAnimal().getClass())) {
                            objectifs.add(new Objectif(conteneur, conteneur.getContainer().getPlateau()[x][y]));
                        }
                    }
                    if (conteneur.getContainer().getPlateau()[x][y].getPlante() != null) {
                        if (priorite.keySet().contains(conteneur.getContainer().getPlateau()[x][y].getPlante().getClass())) {
                            objectifs.add(new Objectif(conteneur, conteneur.getContainer().getPlateau()[x][y]));
                        }
                    }

                }
            }
            if (objectifs.isEmpty()) {
                mouvementAleatoire();
            } else {
                Objectif but = objectifs.get(0);
                int max = but.evaluation();
                for (Objectif e : objectifs) {
                    if (e.evaluation() < max) {
                        max = e.getPoint();
                        but = e;
                    }
                }
                mouvementDirige(but.getCible());
                objectifs.clear();
            }
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

    public HashMap<Class, Integer> getPriorite() {
        return priorite;
    }

    public void setPriorite(HashMap<Class, Integer> priorite) {
        this.priorite = priorite;
    }

    public void setABouge(boolean change){
        this.aBouge=change;
    }
}
