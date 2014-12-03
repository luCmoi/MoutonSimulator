package moutonsimulator.Elements;

import java.util.ArrayList;
import moutonsimulator.Elements.Plantes.Buisson;
import moutonsimulator.Elements.Plantes.Herbe;
import moutonsimulator.Jeu.Case;

public class Mouton extends Herbivore {

    public Mouton(Case c, Arbre arbre) {
        super(c, arbre);
        this.idImage = 1;
        priorite.put(Buisson.class, 5);
        priorite.put(Herbe.class, 5);
        priorite.put(Mouton.class, 40);
        priorite.put(Loup.class, -10);
    }

    @Override
    public void mort() {
        super.mort();
        conteneur.getContainer().getPartie().getSetMouton().remove(this);
    }

    @Override
    public void updatePriorite() {
        priorite.put(Buisson.class, vie.getVal());
        priorite.put(Herbe.class, vie.getVal());
        priorite.put(Mouton.class, (vie.getMax() - vie.getVal()));

    }
    /*
    @Override
    public Objectif findBut() {
        ArrayList<Objectif> objectifs = new ArrayList();
        for (int x = Math.max(0, conteneur.getX() - competence.getVue()); x < Math.min(conteneur.getX() + competence.getVue(), conteneur.getContainer().getPlateau().length); x++) {
            for (int y = Math.max(0, conteneur.getY() - (competence.getVue() - Math.abs(conteneur.getX() - x))); y < Math.min(conteneur.getY() + (competence.getVue() - Math.abs(conteneur.getX() - x)), conteneur.getContainer().getPlateau()[0].length); y++) {
                if (!(x == conteneur.getX() && y == conteneur.getY())) {
                    if (conteneur.getContainer().getPlateau()[x][y].getAnimal() instanceof Mouton || conteneur.getContainer().getPlateau()[x][y].getPlante() != null) {
                        objectifs.add(new Objectif(conteneur, conteneur.getContainer().getPlateau()[x][y]));
                    }
                }
            }
        }
    */
    }
