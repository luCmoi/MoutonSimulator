package moutonsimulator.Jeu;

public class ConfigInitial {
    
    public static int width = 75;
    public static int heigth = 75;
    public int nbMouton = 15;
    public int nbLoup = 10;
    private int probaPlante = 20;
    private int eau = 100;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        ConfigInitial.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        ConfigInitial.heigth = heigth;
    }

    public int getNbMouton() {
        return nbMouton;
    }

    public void setNbMouton(int nbMouton) {
        this.nbMouton = nbMouton;
    }

    public int getNbLoup() {
        return nbLoup;
    }

    public void setNbLoup(int nbLoup) {
        this.nbLoup = nbLoup;
    }

    public int getProbaPlante() {
        return probaPlante;
    }

    public void setProbaPlante(int probaPlante) {
        this.probaPlante = probaPlante;
    }

    public int getEau() {
        return eau;
    }

    public void setEau(int eau) {
        this.eau = eau;
    }
    
    
}
