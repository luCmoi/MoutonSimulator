package moutonsimulator.Jeu;

import java.util.ArrayList;

public class Node {

    private ArrayList<Node> peres;
    private Case self;
    private boolean racine;
    private boolean eau;

    public Node(Case c) {
        this.self = c;
        this.peres = new ArrayList<>();
        this.racine = true;
        this.eau = false;
    }

    public boolean testValide(ConfigInitial init, Node[][] tab) {
        //But : savoir si tout les pere peuvent se remettre a true en passsant par quelq'un d'autre
        for (int x2 = Math.max(0, self.getX() - 1); x2 < Math.min(self.getX() + 2, init.getWidth()); x2++) {
            for (int y2 = Math.max(0, self.getY() - 1); y2 < Math.min(self.getY() + 2, init.getHeigth()); y2++) {
                tab[x2][y2].setRacine(false);
            }
        }
        for (int x2 = Math.max(0, self.getX() - 1); x2 < Math.min(self.getX() + 2, init.getWidth()); x2++) {
            for (int y2 = Math.max(0, self.getY() - 1); y2 < Math.min(self.getY() + 2, init.getHeigth()); y2++) {
                if (tab[x2][y2] != this && !tab[x2][y2].isEau()) {
                    for (Node n : tab[x2][y2].getPeres()) {
                        if (n != this && n.isRacine()) {//racine = non eau
                            n.getPeres().remove(tab[x2][y2]);
                            tab[x2][y2].setRacine(true);
                        }
                    }
                }
            }
        }
        int cmp = 0;
        int pere=0;
        for (int x2 = Math.max(0, self.getX() - 1); x2 < Math.min(self.getX() + 2, init.getWidth()); x2++) {
            for (int y2 = Math.max(0, self.getY() - 1); y2 < Math.min(self.getY() + 2, init.getHeigth()); y2++) {
                if (tab[x2][y2] != this && !tab[x2][y2].isEau()) {
                    pere++;
                    if (tab[x2][y2].isRacine()) {
                        cmp++;
                    }
                }
            }
        }
        if(cmp<pere){
            racine = true;
            return false;
        }
        eau = true;
        racine = false;
        return true;
    }

    public Case getSelf() {
        return self;
    }

    public void setSelf(Case self) {
        this.self = self;
    }

    public boolean isRacine() {
        return racine;
    }

    public void setRacine(boolean racine) {
        this.racine = racine;
    }

    public ArrayList<Node> getPeres() {
        return peres;
    }

    public void setPeres(ArrayList<Node> peres) {
        this.peres = peres;
    }

    public boolean isEau() {
        return eau;
    }

    public void setEau(boolean eau) {
        this.eau = eau;
    }
}
