package moutonsimulator.Elements;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;
import moutonsimulator.IntValMax;
import moutonsimulator.Jeu.Case;

public abstract class Animal extends ElementDynamique {

    protected IntValMax repro;
    protected CaracteristiqueAnimale competence;
    protected HashMap<Class, Integer> priorite;
    protected Boolean aBouge = false;
    protected Animal pere;
    protected Animal mere;
    protected boolean sexe;
    protected boolean mort;
    private int nbEnfants;
    
    public abstract void updatePriorite();

    public Animal(Case c) {
        this.priorite = new HashMap<>();
        this.competence = CaracteristiqueAnimale.randomCompetences();
        this.vie = competence.getVie();
        this.age = competence.getAge();
        this.repro = competence.getReproduction();
        this.conteneur = c;
        this.sexe = (int) (Math.random() * 2) == 0;
        this.mort = false;
        this.pere = null;
        this.mere = null;
    }
    
    public Animal(Case c,Animal pere,Animal mere) {
        this.priorite = new HashMap<>();
        this.competence = CaracteristiqueAnimale.specsEnfant(pere.getCompetence(), mere.getCompetence());
        this.vie = competence.getVie();
        this.age = competence.getAge();
        this.repro = competence.getReproduction();
        this.conteneur = c;
        this.sexe = (int) (Math.random() * 2) == 0;
        this.mort = false;
        this.pere = pere;
        this.mere = mere;
    }
    
    public Animal(Case c, CaracteristiqueAnimale specs) {
        this.priorite = new HashMap<>();
        this.competence = specs;
        this.vie = competence.getVie();
        this.age = competence.getAge();
        this.repro = competence.getReproduction();
        this.conteneur = c;
        this.sexe = (int) (Math.random() * 2) == 0;
        this.mort = false;
        this.pere = null;
        this.mere = null;
    }

    @Override
    public void update() {
        if(mere != null && mere.isMort()){
            mere = null;
        }
        if(pere != null && pere.isMort()){
            pere = null;
        }
        repro.decremente();
        updatePriorite();
        mouvementBasique();
        super.update();
    }

    public void mange(ElementDynamique el) {
        this.vie.setVal(this.vie.getVal() + el.estMange(this.competence.getPuissance()));
    }

    public void reproduction(Animal p1, Animal p2) {
        Animal mere, pere;
        if (p1.sexe) {
            mere = p1;
            pere = p2;
        } else {
            mere = p2;
            pere = p1;
        }
        Stack<Case> caseLibre = new Stack<>();
        for (int x = Math.max(0, mere.getConteneur().getX() - 1); x < Math.min(mere.getConteneur().getX() + 2, conteneur.getContainer().getPlateau().length); x++) {
            for (int y = Math.max(0, mere.getConteneur().getY() - 1); y < Math.min(mere.getConteneur().getY() + 2, conteneur.getContainer().getPlateau()[0].length); y++) {
                if (conteneur.getContainer().getPlateau()[x][y].isTraversable() && conteneur.getContainer().getPlateau()[x][y].getAnimal() == null) {
                    caseLibre.add(conteneur.getContainer().getPlateau()[x][y]);
                }
            }
        }
        if (caseLibre.empty()) {
            return;
        }
        Collections.shuffle(caseLibre);
        Case tmp = caseLibre.pop();
        Animal fils;
        if (mere.getClass() == Mouton.class) {
            fils = new Mouton(tmp,pere,mere);
            mere.getConteneur().getContainer().getPartie().getSetMouton().add(fils);
        } else {
            fils = new Loup(tmp,pere,mere);
            mere.getConteneur().getContainer().getPartie().getSetLoup().add(fils);
        }
        fils.setMere(mere);
        fils.setPere(pere);
        pere.setNbEnfants(pere.getNbEnfants()+1);
        mere.setNbEnfants(mere.getNbEnfants()+1);
        tmp.setAnimal(fils);
        caseLibre.clear();
    }

    public void interaction(Objectif but) {
        //Nourriture
        if (but.isSuperpose()) {
            if (this instanceof Herbivore) {
                mange(but.getCible().getPlante());
            }
        } else {
            if (but.getCible().getAnimal().getClass() == this.getClass()) {
                repro.setVal(repro.getMax());
                reproduction(this, but.getCible().getAnimal());
            } else if (this instanceof Carnivore) {
                mange(but.getCible().getAnimal());
            }
        }
    }

    @Override
    public void mort() {
        this.conteneur.setAnimal(null);
        this.conteneur.setEngrais(this.conteneur.getEngrais() + this.competence.getEngrais());
        this.mort = true;
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
            return;
        }
        Collections.shuffle(casePossible);
        Case tmp = casePossible.pop();
        conteneur.setAnimal(null);
        tmp.setAnimal(this);
        this.conteneur = tmp;
    }

    public void mouvementDirige(Objectif o) {
        if (o.getCible() != this.conteneur) {
            Point cible = new Point(o.getCible().getX(), o.getCible().getY());
            Point courant = new Point(conteneur.getX(), conteneur.getY());
            HashMap<Point, Noeud> listeFermee = new HashMap<>();
            HashMap<Point, Noeud> listeOuverte = new HashMap<>();
            listeOuverte.put(courant, new Noeud());
            listeOuverte.get(courant).cout_f = (float) PathFinding.distance(courant, cible);
            PathFinding.ajoutListeFermee(courant, listeFermee, listeOuverte);
            PathFinding.ajoutCaseVoisines(courant, cible, listeOuverte, listeFermee, conteneur.getContainer().getPlateau(),this.competence.getVue());
            while (!((courant.x == cible.x) && (courant.y == cible.y)) && (!listeOuverte.isEmpty())) {
                courant = PathFinding.meilleurNoeud(listeOuverte);
                PathFinding.ajoutListeFermee(courant, listeFermee, listeOuverte);
                PathFinding.ajoutCaseVoisines(courant, cible, listeOuverte, listeFermee, conteneur.getContainer().getPlateau(),this.competence.getVue());
            }
            if ((courant.x == cible.x) && (courant.y == cible.y)) {
                Point tmp = PathFinding.retrouver_chemin(cible, new Point(conteneur.getX(), conteneur.getY()), listeFermee, o);
                conteneur.setAnimal(null);
                Case caseTmp = conteneur.getContainer().getPlateau()[tmp.x][tmp.y];
                caseTmp.setAnimal(this);
                this.conteneur = caseTmp;
                if (cible.equals(tmp) && o.isSuperpose()) {
                    this.interaction(o);
                } else if (listeFermee.get(cible).parent.equals(tmp) && !o.isSuperpose()) {
                    this.interaction(o);
                }
            } else {
                mouvementAleatoire();
            }
        } else {
            this.interaction(o);
        }
    }

    public void mouvementBasique() {
        if (!aBouge) {
            aBouge = true;
            ArrayList<Objectif> objectifs = new ArrayList();
            for (int x = Math.max(0, conteneur.getX() - competence.getVue()); x < Math.min(conteneur.getX() + competence.getVue(), conteneur.getContainer().getPlateau().length); x++) {
                for (int y = Math.max(0, conteneur.getY() - (competence.getVue() - Math.abs(conteneur.getX() - x))); y < Math.min(conteneur.getY() + (competence.getVue() - Math.abs(conteneur.getX() - x)), conteneur.getContainer().getPlateau()[0].length); y++) {
                    //On regarde pas notre case ici
                    if (!(x == conteneur.getX() && y == conteneur.getY())) {
                        //Ici on regarde le cas ou il y a un animal
                        if (conteneur.getContainer().getPlateau()[x][y].getAnimal() != null) {
                            //S'il est dans notre liste
                            if (priorite.keySet().contains(conteneur.getContainer().getPlateau()[x][y].getAnimal().getClass())) {
                                //Si c'est un autre animal
                                if (conteneur.getContainer().getPlateau()[x][y].getAnimal().getClass() != this.getClass()) {
                                    objectifs.add(new Objectif(conteneur, conteneur.getContainer().getPlateau()[x][y]));
                                    //Si c'est l'un des notres
                                } else if (conteneur.getContainer().getPlateau()[x][y].getAnimal().getSexe() != this.sexe && this.repro.getVal() <= 0) {
                                    objectifs.add(new Objectif(conteneur, conteneur.getContainer().getPlateau()[x][y]));
                                }
                            }
                        }
                    }
                    if (conteneur.getContainer().getPlateau()[x][y].getPlante() != null && priorite.keySet().contains(conteneur.getContainer().getPlateau()[x][y].getPlante().getClass())) {
                        if (conteneur.getContainer().getPlateau()[x][y].getAnimal() == null || conteneur.getContainer().getPlateau()[x][y].getAnimal() == this) {
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
                    if (e.evaluation() < max && e.evaluation() >= 0) {
                        max = e.getPoint();
                        but = e;
                    }
                }
                if (but.evaluation() < 0) {
                    mouvementAleatoire();
                } else {
                    mouvementDirige(but);
                }
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

    public void setConteneur(Case conteneur) {
        this.conteneur = conteneur;
    }

    public HashMap<Class, Integer> getPriorite() {
        return priorite;
    }

    public void setPriorite(HashMap<Class, Integer> priorite) {
        this.priorite = priorite;
    }

    public void setABouge(boolean change) {
        this.aBouge = change;
    }

    public CaracteristiqueAnimale getCompetence() {
        return competence;
    }

    public boolean getSexe() {
        return sexe;
    }

    public void setSexe(boolean sexe) {
        this.sexe = sexe;
    }

    public IntValMax getRepro() {
        return repro;
    }

    public void setRepro(IntValMax repro) {
        this.repro = repro;
    }

    public void setCompetence(CaracteristiqueAnimale competence) {
        this.competence = competence;
    }

    public Boolean getaBouge() {
        return aBouge;
    }

    public void setaBouge(Boolean aBouge) {
        this.aBouge = aBouge;
    }

    public Animal getPere() {
        return pere;
    }

    public void setPere(Animal pere) {
        this.pere = pere;
    }

    public Animal getMere() {
        return mere;
    }

    public void setMere(Animal mere) {
        this.mere = mere;
    }

    public boolean isSexe() {
        return sexe;
    }

    public boolean isMort() {
        return mort;
    }

    public void setMort(boolean mort) {
        this.mort = mort;
    }

    public int getNbEnfants() {
        return nbEnfants;
    }

    public void setNbEnfants(int nbEnfants) {
        this.nbEnfants = nbEnfants;
    }
}
