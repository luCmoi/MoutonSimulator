package moutonsimulator.Elements;

import java.awt.Color;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import moutonsimulator.IntValMax;
import moutonsimulator.Jeu.Case;

public class Plante extends ElementDynamique {

    private CaracteristiquePlante specs;
    private int countDownRepro;
    protected Color c1;
    protected Color c2;
    protected Color c3;

    public Plante(CaracteristiquePlante specs, Case c) {
        this.specs = specs;
        this.age = specs.getAge();
        this.vie = specs.getVie();
        this.countDownRepro = specs.getDureeReproduction();
        this.conteneur = c;
        c1 = Color.BLACK;
        c2 = Color.DARK_GRAY;
        c3 = Color.GRAY;
    }

    public Plante(CaracteristiquePlante specs, Case c, Color c1, Color c2, Color c3) {
        this.specs = specs;
        this.age = specs.getAge();
        this.vie = specs.getVie();
        this.countDownRepro = specs.getDureeReproduction();
        this.conteneur = c;
        this.c1 = c1;
        this.c2 = c2;
        this.c3 = c3;
    }

    @Override
    public void mort() {
        this.conteneur.setPlante(null);
        this.image.flush();
        this.image = null;
        this.age = null;
        this.c1 = null;
        this.c2 = null;
        this.c3 = null;
        this.conteneur = null;
        this.specs = null;
        this.vie = null;
        this.finalise();
    }
    
    public void finalise(){
        try {
            super.finalize();
        } catch (Throwable ex) {
        }
    }

    @Override
    public void update() {
        if (--countDownRepro == 0) {
            reproduction();
        }
        super.update();
    }

    public void reproduction() {
        Stack<Case> casePossible = new Stack<>();
        for (int x = Math.max(0, conteneur.getX() - specs.getPorteSpore()); x < Math.min(conteneur.getX() + specs.getPorteSpore(), conteneur.getContainer().getPlateau().length); x++) {
            for (int y = Math.max(0, conteneur.getY() - (specs.getPorteSpore() - Math.abs(conteneur.getX() - x))); y < Math.min(conteneur.getY() + (specs.getPorteSpore() - Math.abs(conteneur.getX() - x)), conteneur.getContainer().getPlateau().length); y++) {
                if (conteneur.getContainer().getPlateau()[x][y].isTraversable()) {
                    casePossible.add(conteneur.getContainer().getPlateau()[x][y]);
                }
            }
        }
        for (Case c : casePossible) {
            if ((int) (Math.random() * 101) < specs.getProliferation()) {
                if (this instanceof Herbe) {
                    //  System.out.println(this.c1);
                    c.getGraines().add(new Graine(c, 0, specs.getDureePousse(), new Color(Math.min(255, this.c1.getRed() + 10), Math.min(255, this.c1.getGreen() + 10), this.c1.getBlue()), new Color(Math.min(255, this.c2.getRed() + 10), Math.min(255, this.c2.getGreen() + 10), this.c2.getBlue()), new Color(Math.min(255, this.c3.getRed() + 10), Math.min(255, this.c3.getGreen() + 10), this.c3.getBlue())));
                } else if (this instanceof Buisson) {
                    c.getGraines().add(new Graine(c, 1, specs.getDureePousse(), new Color(Math.min(255, this.c1.getRed() + 10), Math.min(255, this.c1.getGreen() + 10), this.c1.getBlue()), new Color(Math.min(255, this.c2.getRed() + 10), Math.min(255, this.c2.getGreen() + 10), this.c2.getBlue()), new Color(Math.min(255, this.c3.getRed() + 10), Math.min(255, this.c3.getGreen() + 10), this.c3.getBlue())));
                }
            }
        }
        this.countDownRepro = specs.getDureeReproduction();
        casePossible.clear();
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

    public CaracteristiquePlante getSpecs() {
        return specs;
    }

    public void setSpecs(CaracteristiquePlante specs) {
        this.specs = specs;
    }

    public int getCountDownRepro() {
        return countDownRepro;
    }

    public void setCountDownRepro(int countDownRepro) {
        this.countDownRepro = countDownRepro;
    }

    public Color getC1() {
        return c1;
    }

    public void setC1(Color c1) {
        this.c1 = c1;
    }

    public Color getC2() {
        return c2;
    }

    public void setC2(Color c2) {
        this.c2 = c2;
    }

    public Color getC3() {
        return c3;
    }

    public void setC3(Color c3) {
        this.c3 = c3;
    }
}
