package moutonsimulator.Jeu;

import GUI.Images;
import GUI.ViewPort;
import java.awt.Graphics2D;
import moutonsimulator.Config;
import moutonsimulator.Elements.Animal;
import moutonsimulator.Elements.Plante;

public class Case {

    private int x;
    private int y;
    private Animal animal;
    private Plante plante;
    private int engrais;
    private final Grille container;

    Case(int x, int y, Grille cont) {
        this.x = x;
        this.y = y;
        this.animal = null;
        this.plante = null;
        this.container = cont;
        this.engrais = 0;
    }
    
    public boolean presence(){
        return this.animal!=null || this.plante!=null;
    }

    public void update() {
        if(this.plante==null && this.engrais>0){
            this.engrais--;
            this.plante = new Plante(10, 20, 1, this);
        }
        if (this.getAnimal() != null) {
            this.getAnimal().update();
        }
        if (this.getPlante() != null) {
            this.getPlante().update();
        }
    }

    public void render(Graphics2D batch) {
        batch.drawImage(Images.herbe, (x * Config.coteCase) - (ViewPort.x), (y * Config.coteCase) - (ViewPort.y), Config.coteCase, Config.coteCase, null);
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

}
