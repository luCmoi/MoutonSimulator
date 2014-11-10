package moutonsimulator.Jeu;


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
}
