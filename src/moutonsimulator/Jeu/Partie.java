package moutonsimulator.Jeu;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import javax.swing.JPanel;
import moutonsimulator.Elements.Animal;
import moutonsimulator.Elements.Eau;
import moutonsimulator.Elements.Loup;
import moutonsimulator.Elements.Mouton;
import moutonsimulator.Elements.Plantes.FamillePlante;

/**
 * La partie est l'élément contenant la grille de jeu ainsi que chaque elementdynamique en présence
 * et les coordonne entre eux ainsi qu'avec les "tick"
 */
public class Partie {

    private Grille plateau;
    private int jours;
    private final JPanel pan;
    private final ArrayList<Animal> setMouton;
    private final ArrayList<Animal> setLoup;
    private final ArrayList<FamillePlante> famillesPlante;
    public static boolean pause;

    public Partie(ConfigInitial init, JPanel pan) {
        this.jours = 0;
        this.pan = pan;
        this.setLoup = new ArrayList<>();
        this.setMouton = new ArrayList<>();
        this.famillesPlante = new ArrayList<>();
        initPlateau(init);
        pause = false;
    }

    /**
     * Regarde si les parametres initiaux sont valide et genere la carte
     * 
     * @param init 
     */
    private void initPlateau(ConfigInitial init) {
        this.plateau = new Grille(init.getWidth(), init.getHeigth(), this);
        //Placement de l'eau + verification nombre animaux;
        if (init.getNbMouton() + init.getNbLoup() > (init.getHeigth() * init.getWidth() - placementSol(init))) {
            System.out.println("Parametre initiaux invalides.");
            System.exit(0);
        }

        placementPlante(init);

        Stack<Case> caseLibre = new Stack<>();
        for (int x = 0; x < init.getWidth(); x++) {
            for (int y = 0; y < init.getHeigth(); y++) {
                if (plateau.getPlateau()[x][y].isTraversable()) {
                    caseLibre.add(plateau.getPlateau()[x][y]);
                }
            }
        }

        Collections.shuffle(caseLibre);
        //Placement des animaux
        int mouton = init.getNbMouton();
        int loup = init.getNbLoup();
        while (mouton > 0 && !caseLibre.empty()) {
            Case tmp = caseLibre.pop();
            Mouton moutmout = new Mouton(tmp);
            tmp.setAnimal(moutmout);
            setMouton.add(moutmout);
            mouton--;
        }
        while (loup > 0 && !caseLibre.empty()) {
            Case tmp = caseLibre.pop();
            Loup loupe = new Loup(tmp);
            tmp.setAnimal(loupe);
            setLoup.add(loupe);
            loup--;
        }
        caseLibre.clear();
        triInsert(setMouton);
        triInsert(setLoup);

    }
    
    /**
     * Place les sols, herbe d'abbord, puis de l'eau de maniere a ce que la terre reste connexe
     * @param init
     * @return 
     */

    public int placementSol(ConfigInitial init) {
        Node tab[][] = initTabNode(init);
        Stack<Case> caseLibre = new Stack<>();
        int compteurEau = 0;
        for (int x = 0; x < init.getWidth(); x++) {
            for (int y = 0; y < init.getHeigth(); y++) {
                caseLibre.add(plateau.getPlateau()[x][y]);
            }
        }
        Collections.shuffle(caseLibre);
        int eau = init.getEau();
        while (!caseLibre.empty() && eau > 0) {
            Case tmpC = caseLibre.pop();
            Node tmpN = tab[tmpC.getX()][tmpC.getY()];
            if (tmpN.testValide(init, tab)) {
                tmpC.setSol(new Eau());
                eau--;
                compteurEau++;
            }
        }
        caseLibre.clear();
        return compteurEau;
    }

    /**
     * Place des plantes en fonction de parametres initiaux
     * @param init
     * @return 
     */
    public int placementPlante(ConfigInitial init) {
        int cmp = 0;
        Stack<Case> casesLibres = new Stack<>();
        for (Case[] plateauTmp : plateau.getPlateau()) {
            for (Case caseTmp : plateauTmp) {
                if (caseTmp.isTraversable()) {
                    casesLibres.add(caseTmp);
                }
            }
        }
        Collections.shuffle(casesLibres);
        int f = Math.min(init.getNbFamillePlante(), casesLibres.size());
        while (f-- > 0) {
            famillesPlante.add(new FamillePlante((int) (Math.random() * 2), casesLibres.pop()));
        }
        while (!casesLibres.empty()) {
            Case tmp = casesLibres.pop();
            if ((int) (Math.random() * 1001) < init.getProbaPlante()) {
                if (!famillesPlante.isEmpty()) {
                    FamillePlante fp = famillesPlante.get((int) (Math.random() * famillesPlante.size()));
                    fp.add(tmp);
                }
            }
        }

        return cmp;
    }
    /**
     * Associe un Node a chaque case et calcul ses peres
     * Utiliser pour le placements de l'eau
     * @param init
     * @return 
     */
    public Node[][] initTabNode(ConfigInitial init) {
        Node tab[][] = new Node[init.getWidth()][init.getHeigth()];
        for (int x = 0; x < init.getWidth(); x++) {
            for (int y = 0; y < init.getHeigth(); y++) {
                tab[x][y] = new Node(plateau.getPlateau()[x][y]);
            }
        }
        for (int x = 0; x < init.getWidth(); x++) {
            for (int y = 0; y < init.getHeigth(); y++) {
                for (int x2 = Math.max(0, x - 1); x2 < Math.min(x + 2, init.getWidth()); x2++) {
                    for (int y2 = Math.max(0, y - 1); y2 < Math.min(y + 2, init.getHeigth()); y2++) {
                        if (tab[x][y] != tab[x2][y2]) {
                            tab[x][y].getPeres().add(tab[x2][y2]);
                        }
                    }
                }
            }
        }
        return tab;
    }
    //Tri les sets de moutons et de loup selon leurs coordonees
    public void triInsert(ArrayList<Animal> list) {

        for (int i = 1; i < list.size(); i++) {
            Case tmp = list.get(i).getConteneur();
            int j = i;
            while (j > 0 && tmp.compareTo(list.get(j - 1).getConteneur()) == -1) {
                list.set(j, list.get(j - 1));
                j--;
            }
            list.set(j, tmp.getAnimal());
        }
    }

    /**
     * Lance la mise a jour sur toutes les cases
     */
    public void update() {
        if (!pause) {
            plateau.update();
            jours++;
            for (Animal a : setMouton) {
                a.setABouge(false);
            }
            for (Animal a : setLoup) {
                a.setABouge(false);
            }
        }
    }

    /**
     * Lance la mise a jour d'affichage sur toutes les cases du plateau
     * @param batch 
     */
    public void render(Graphics2D batch) {
        plateau.render(batch);
    }

    public Grille getPlateau() {
        return plateau;
    }

    public void setPlateau(Grille plateau) {
        this.plateau = plateau;
    }

    public int getJours() {
        return jours;
    }

    public void setJours(int jours) {
        this.jours = jours;
    }

    public JPanel getPan() {
        return pan;
    }


    public ArrayList<Animal> getSetMouton() {
        return setMouton;
    }


    public ArrayList<Animal> getSetLoup() {
        return setLoup;
    }


    public ArrayList<FamillePlante> getFamillesPlante() {
        return famillesPlante;
    }


    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        Partie.pause = pause;
    }
}
