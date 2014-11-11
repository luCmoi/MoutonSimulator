package moutonsimulator.Jeu;

import java.awt.Graphics2D;
import moutonsimulator.Elements.Loup;
import moutonsimulator.Elements.Mouton;
import moutonsimulator.Elements.Plante;

public class Partie {
    
    private final Grille plateau;
    private int jours;
    
    public Partie(ConfigInitial init) {
        this.plateau = initPlateau(init);
        this.jours = 0;
    }
    
    public Grille initPlateau(ConfigInitial init) {
        Grille plateau = new Grille(init.getWidth(), init.getHeigth());
        if (init.getNbMouton() + init.getNbLoup() >= init.getHeigth() * init.getWidth()) {
            System.out.println("Parametre initiaux invalides.");
            System.exit(0);
        }
        int mouton = init.getNbMouton();
        int loup = init.getNbLoup();
        while (mouton > 0) {
            int x = (int) (Math.random() * init.getWidth());
            int y = (int) (Math.random() * init.getHeigth());
            if (plateau.getPlateau()[x][y].getAnimal() == null) {
                plateau.getPlateau()[x][y].setAnimal(new Mouton(10, 50, null,plateau.getPlateau()[x][y]));
                mouton--;
            }
        }
        while (loup > 0) {
            int x = (int) (Math.random() * init.getWidth());
            int y = (int) (Math.random() * init.getHeigth());
            if (plateau.getPlateau()[x][y].getAnimal() == null) {
                plateau.getPlateau()[x][y].setAnimal(new Loup(10, 50, null,plateau.getPlateau()[x][y]));
                loup--;
            }
        }
        
        for (int x = 0; x < init.getWidth(); x++) {
            for (int y = 0; y < init.getHeigth(); y++) {
                if ((int) (Math.random() * 5) < 1) {
                    plateau.getPlateau()[x][y].setPlante(new Plante(500, 10, 5,plateau.getPlateau()[x][y]));
                }
            }
        }
        return plateau;
    }
    
    public void update() {
        plateau.update();
        jours++;
    }
    
    public void render(Graphics2D batch) {
        plateau.render(batch);
    }
}
