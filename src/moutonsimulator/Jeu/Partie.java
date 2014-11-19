package moutonsimulator.Jeu;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import javax.swing.JPanel;
import moutonsimulator.Elements.Animal;
import moutonsimulator.Elements.Buisson;
import moutonsimulator.Elements.CaracteristiquePlante;
import moutonsimulator.Elements.Eau;
import moutonsimulator.Elements.Herbe;
import moutonsimulator.Elements.Loup;
import moutonsimulator.Elements.Mouton;

public class Partie {

    private Grille plateau;
    private int jours;
    private JPanel pan;
    private ArrayList<Animal> setMouton;
    private ArrayList<Animal> setLoup;

    public Partie(ConfigInitial init, JPanel pan) {
        this.jours = 0;
        this.pan = pan;
        this.setLoup = new ArrayList<>();
        this.setMouton = new ArrayList<>();
        initPlateau(init);
    }

    private void initPlateau(ConfigInitial init) {
        this.plateau = new Grille(init.getWidth(), init.getHeigth(), this);
        //Placement de l'eau + verification nombre animaux;
        if (init.getNbMouton() + init.getNbLoup() >= (init.getHeigth() * init.getWidth() - placementSol(init))) {
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
            Mouton moutmout = new Mouton(tmp, null);
            tmp.setAnimal(moutmout);
            setMouton.add(moutmout);
            mouton--;
        }
        while (loup > 0 && !caseLibre.empty()) {
            Case tmp = caseLibre.pop();
            Loup loupe = new Loup(tmp, null);
            tmp.setAnimal(loupe);
            setLoup.add(loupe);
            loup--;
        }
        caseLibre.clear();
        triInsert(setMouton);
        triInsert(setLoup);

    }

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

        for (int x = 0; x < init.getWidth(); x++) {
            for (int y = 0; y < init.getHeigth(); y++) {
                if (plateau.getPlateau()[x][y].getSol() instanceof Eau) {
                    plateau.getPlateau()[x][y].setTraversable(false);
                }
            }
        }
        caseLibre.clear();
        return compteurEau;
    }

    public int placementPlante(ConfigInitial init) {
        int cmp = 0;
        for (int x = 0; x < init.getWidth(); x++) {
            for (int y = 0; y < init.getHeigth(); y++) {
                if ((int) (Math.random() * 101) < init.getProbaPlante() && plateau.getPlateau()[x][y].isTraversable()) {
                    switch ((int) (Math.random() * 2)) {
                        case 0:
                            plateau.getPlateau()[x][y].setPlante(new Herbe(CaracteristiquePlante.randomSpecs(), plateau.getPlateau()[x][y]));
                            break;
                        case 1:
                            plateau.getPlateau()[x][y].setPlante(new Buisson(CaracteristiquePlante.randomSpecs(), plateau.getPlateau()[x][y]));
                            break;
                    }
                    cmp++;
                }
            }
        }
        return cmp;
    }

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

    public void update() {
        plateau.update();
        jours++;
        for (Animal a : setMouton) {
            a.setABouge(false);
        }
        for (Animal a : setLoup) {
            a.setABouge(false);
        }
    }

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

    public void setPan(JPanel pan) {
        this.pan = pan;
    }

    public ArrayList<Animal> getSetMouton() {
        return setMouton;
    }

    public void setSetMouton(ArrayList<Animal> setMouton) {
        this.setMouton = setMouton;
    }

    public ArrayList<Animal> getSetLoup() {
        return setLoup;
    }

    public void setSetLoup(ArrayList<Animal> setLoup) {
        this.setLoup = setLoup;
    }
}
