package moutonsimulator.Jeu;

import java.util.HashSet;
import moutonsimulator.Elements.Eau;

public class Node {

    private HashSet<Node> peres;
    private Case self;
    private boolean racine;
    private boolean eau;

    public Node(Case c) {
        this.self = c;
        this.peres = new HashSet<Node>();
        this.racine = true;
        this.eau = false;
    }

    public boolean testValide(ConfigInitial init, Node[][] tab) {
        this.racine = false;
        //boolean ok = false;
        for (int x2 = Math.max(0, self.getX() - 1); x2 < Math.min(self.getX() + 2, init.getWidth()); x2++) {
            for (int y2 = Math.max(0, self.getY() - 1); y2 < Math.min(self.getY() + 2, init.getHeigth()); y2++) {
                tab[x2][y2].setRacine(false);
            }
        }
        int cmp = 0;
        int tmp = 0;
        //do {
            tmp = cmp;
            cmp = 0;
            for (int x2 = Math.max(0, self.getX() - 1); x2 < Math.min(self.getX() + 2, init.getWidth()); x2++) {
                for (int y2 = Math.max(0, self.getY() - 1); y2 < Math.min(self.getY() + 2, init.getHeigth()); y2++) {
                    if (!tab[x2][y2].isEau() && tab[self.getX()][self.getY()] != tab[x2][y2]) {
                        for (Node n : tab[x2][y2].getPeres()) {
                            if (n.isRacine()) {
                                tab[x2][y2].setRacine(true);
                                cmp++;
                                break;
                            }
                        }
                    }
                }
            }
        //} while (cmp != tmp);
        int pere = 0;
        for(Node n : peres){
            //System.out.println("HEY");
            if(!n.isEau())pere++;
        }
        //System.out.println("Message "+pere);
        if (cmp < pere || pere == 1 ) {
            /*for (int x2 = Math.max(0, self.getX() - 1); x2 < Math.min(self.getX() + 2, init.getWidth()); x2++) {
                for (int y2 = Math.max(0, self.getY() - 1); y2 < Math.min(self.getY() + 2, init.getHeigth()); y2++) {
                    if (!(tab[x2][y2].isEau())) {
                        tab[x2][y2].setRacine(true);
                    }

                }
            }
            this.racine = true;*/
            System.out.println(pere);
            System.out.println("FALSE");
            return false;
        }
        this.eau = true;
        this.racine = false;
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

    public HashSet<Node> getPeres() {
        return peres;
    }

    public void setPeres(HashSet<Node> peres) {
        this.peres = peres;
    }

    public boolean isEau() {
        return eau;
    }

    public void setEau(boolean eau) {
        this.eau = eau;
    }
}
