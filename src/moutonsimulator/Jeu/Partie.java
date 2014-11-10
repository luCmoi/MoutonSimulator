package moutonsimulator.Jeu;

import java.awt.Graphics2D;


public class Partie {
    
    private final Grille plateau;
    private int jours;
    
    public Partie(ConfigInitial init){
        this.plateau = new Grille(init.getWidth(), init.getHeigth());
        this.jours = 0;
    }
    
    public void update(){
        plateau.update();
        jours++;
    }
    
    public void render(Graphics2D batch){
        plateau.render(batch);
    }
}
