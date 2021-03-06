package moutonsimulator.Jeu;

import GUI.ViewPort;
import java.awt.Graphics2D;
import java.util.HashSet;
import moutonsimulator.Config;
import moutonsimulator.Elements.Animal;
import moutonsimulator.Elements.Plantes.FamillePlante;
import moutonsimulator.Elements.Plantes.Graine;
import moutonsimulator.Elements.Plantes.Plante;
import moutonsimulator.Elements.Sol;

/**
 * Composant de base de la grille composé de sol, plantes, animaux et/ou engrais
 */
public class Case implements Comparable {

    private final int x;
    private final int y;
    private Animal animal;
    private Plante plante;
    private int engrais;
    private final Grille container;
    private boolean traversable;
    private Sol sol;
    private HashSet<Graine> graines;

    Case(int x, int y, Grille cont, Sol sol) {
        this.x = x;
        this.y = y;
        this.animal = null;
        this.plante = null;
        this.container = cont;
        if (ConfigInitial.modeMinimal) {
            this.engrais = 0;
        } else {
            this.engrais = 25 + (int) (Math.random() * 2);
        }
        this.sol = sol;
        this.traversable = sol.isTraversable();
        this.graines = new HashSet<>();
    }

    /**
     * Informe si la case est déja occupé par une plante ou un animal
     *
     * @return
     */
    public boolean presence() {
        return this.animal != null || this.plante != null;
    }

    /**
     * Met a jour les graines pour la germination de plante
     */
    private void updateGraine() {
        boolean germe = false;
        for (Graine g : graines) {
            if (g.getCountDown().decremente()) {
                if (this.engrais > 0) {
                    FamillePlante tmp = g.getFamille();
                    Plante p = tmp.add(this);
                    plante = p;
                    engrais--;
                    germe = true;
                    break;
                } else {
                    germe = true;
                }
            }
        }
        if (germe) {
            for (Graine g : graines) {
                g.getFamille().supGraine();
            }
            graines.clear();
        }
    }

    /**
     * Met a jour la case et donc ses plantes animaux engrais ou graines(a
     * chaque "tick")
     */
    public void update() {
        if (this.plante != null) {
            plante.update();
        } else {//if (this.engrais > 0)
            if (!ConfigInitial.modeMinimal) {
                updateGraine();
            } else if (engrais > 0) {
                container.getPartie().getFamillesPlante().add(new FamillePlante((int) (Math.random() * 2), this));
                engrais--;
            }
        }
        if (this.getAnimal() != null) {
            this.getAnimal().update();
        }
    }

    /**
     * La case se déssine a ses coordonnées
     *
     * @param batch
     */
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

    public int getY() {
        return y;
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
        Case tmp = (Case) o;
        if (this.x < tmp.getX()) {
            return -1;
        } else if (x > tmp.getX()) {
            return 1;
        } else {
            if (this.y < tmp.getY()) {
                return -1;
            } else if (this.y > tmp.getY()) {
                return 1;
            } else {
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
        this.traversable = sol.isTraversable();
    }

    public HashSet<Graine> getGraines() {
        return graines;
    }

    public void setGraines(HashSet<Graine> graines) {
        this.graines = graines;
    }
}
