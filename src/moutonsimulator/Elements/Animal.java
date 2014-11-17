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

    public Animal(Case c, Arbre arbre) {
        priorite = new HashMap<Class, Integer>();
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
                    //deuxieme condition a supprimer plus tard
                    casePossible.add(conteneur.getContainer().getPlateau()[x][y]);
                }
            }
        }
        if(casePossible.isEmpty()){
            System.out.println("peut pas bouger");
            return;
        }
        Collections.shuffle(casePossible);
        Case tmp = casePossible.pop();
        conteneur.setAnimal(null);
        tmp.setAnimal(this);
    }

    public void mouvementDirige(Case c) {
        mouvementAleatoire();
    }

    public void mouvementBasique() {
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

    public void mouvementBasique2() {
        /*
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
        //}
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

}
