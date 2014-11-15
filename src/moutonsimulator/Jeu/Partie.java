package moutonsimulator.Jeu;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;
import javax.swing.JPanel;
import moutonsimulator.Elements.Animal;
import moutonsimulator.Elements.Loup;
import moutonsimulator.Elements.Mouton;
import moutonsimulator.Elements.Plante;

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
        for (Animal m : setMouton) {
            System.out.println("x :" + m.getConteneur().getX() + " y : " + m.getConteneur().getY());
        }
    }

    private void initPlateau(ConfigInitial init) {
        this.plateau = new Grille(init.getWidth(), init.getHeigth(), this);
        if (init.getNbMouton() + init.getNbLoup() >= init.getHeigth() * init.getWidth()) {
            System.out.println("Parametre initiaux invalides.");
            System.exit(0);
        }
        Stack<Case> caseLibre = new Stack<>();
        for (int x = 0; x < init.getWidth(); x++) {
            for (int y = 0; y < init.getHeigth(); y++) {
                caseLibre.add(plateau.getPlateau()[x][y]);
                //Placement des plantes : 
                if ((int) (Math.random() * 11) < init.getProbaPlante()) {
                    plateau.getPlateau()[x][y].setPlante(new Plante((int) (50 + Math.random() * 50), 10, 5, plateau.getPlateau()[x][y]));
                }
            }
        }
        Collections.shuffle(caseLibre);
        //Placement des animaux
        int mouton = init.getNbMouton();
        int loup = init.getNbLoup();
        while (mouton > 0) {
            Case tmp = caseLibre.pop();
            Mouton moutmout = new Mouton(tmp, null);
            tmp.setAnimal(moutmout);
            setMouton.add(moutmout);
            mouton--;
        }
        while (loup > 0) {
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

    public void placementSol(ConfigInitial init) {
        Node tab[][] = initTabNode(init);
        
        Stack<Case> caseLibre = new Stack<>();
        for (int x = 0; x < init.getWidth(); x++) {
            for (int y = 0; y < init.getHeigth(); y++) {
                caseLibre.add(plateau.getPlateau()[x][y]);
            }
        }
        int eau = init.getEau();
        while(!caseLibre.empty())
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
                for (int x2 = Math.max(0, x - 1); x < Math.min(x + 2, init.getWidth()); x++) {
                    for (int y2 = Math.max(0, y - 1); y < Math.min(y + 2, init.getHeigth()); y++) {
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
        //System.out.println("J : " + jours);
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
