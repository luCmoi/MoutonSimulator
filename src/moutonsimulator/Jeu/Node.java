package moutonsimulator.Jeu;

import java.util.HashSet;

public class Node {

    private HashSet<Node> peres;
    private Case self;
    private boolean racine;
    
    public Node(Case c){
        this.self = c;
        this.peres = new HashSet<Node>();
        this.racine=true;
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
}
