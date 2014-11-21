package moutonsimulator.Jeu;

import GUI.ViewPort;
import java.awt.Graphics2D;
import java.util.HashSet;
import moutonsimulator.Config;
import moutonsimulator.Elements.Animal;
import moutonsimulator.Elements.Buisson;
import moutonsimulator.Elements.CaracteristiquePlante;
import moutonsimulator.Elements.Graine;
import moutonsimulator.Elements.Herbe;
import moutonsimulator.Elements.Plante;
import moutonsimulator.Elements.Sol;

public class Case implements Comparable {

    private int x;
    private int y;
    private Animal animal;
    private Plante plante;
    private int engrais;
    private final Grille container;
    private boolean traversable;
    private Sol sol;
    private HashSet<Graine> graines;

    Case(int x, int y, Grille cont,Sol sol) {
        this.x = x;
        this.y = y;
        this.animal = null;
        this.plante = null;
        this.container = cont;
        this.engrais = 15;
        this.sol = sol;
        this.traversable = true;
        this.graines = new HashSet<>();
    }
    
    public boolean presence(){
        return this.animal!=null || this.plante!=null;
    }
    
    public void updatePlante(){
        if(this.plante!=null){
            plante.update();
        }else if(this.engrais>0){
            for(Graine g : graines){
                g.setCountDown(g.getCountDown()-1);
                if(g.getCountDown()==0){
                    switch(g.getType()){//J'ai pas encore trouver mieu que le switch
                        case Herbe.type:
                            this.plante = new Herbe(CaracteristiquePlante.randomSpecs(),this,g.getC1(),g.getC2(),g.getC3());
                            break;
                        case Buisson.type:
                            this.plante = new Buisson(CaracteristiquePlante.randomSpecs(),this,g.getC1(),g.getC2(),g.getC3());
                            break;
                    }
                    engrais--;
                    break;
                }
            }
        }
    }

    public void update() {
        updatePlante();
        if (this.getAnimal() != null) {
            this.getAnimal().update();
        }
        if (this.getPlante() != null) {
            this.getPlante().update();
        }
    }

    public void render(Graphics2D batch) {
        batch.drawImage(sol.getImage(), (x * Config.coteCase) - (ViewPort.x), (y * Config.coteCase) - (ViewPort.y), Config.coteCase, Config.coteCase, null);
        if (this.getPlante() != null) {
            this.getPlante().render(batch);
        }
        if (this.getAnimal() != null) {
            this.getAnimal().render(batch);
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Plante getPlante() {
        return plante;
    }

    public Grille getContainer() {
        return container;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public void setPlante(Plante plante) {
        this.plante = plante;
    }

    public int getEngrais() {
        return engrais;
    }

    public void setEngrais(int engrais) {
        this.engrais = engrais;
    }

    @Override
    public int compareTo(Object o) {
        Case tmp = (Case)o;
        if(this.x<tmp.getX()){
            return -1;
        }else if(x>tmp.getX()){
            return 1;
        }else{
            if(this.y<tmp.getY()){
                return -1;
            }else if(this.y>tmp.getY()){
                return 1;
            }else{
                return 0;
            }
        }
    }

    public boolean isTraversable() {
        return traversable;
    }

    public void setTraversable(boolean traversable) {
        this.traversable = traversable;
    }

    public Sol getSol() {
        return sol;
    }

    public void setSol(Sol sol) {
        this.sol = sol;
    }

    public HashSet<Graine> getGraines() {
        return graines;
    }

    public void setGraines(HashSet<Graine> graines) {
        this.graines = graines;
    }
}
