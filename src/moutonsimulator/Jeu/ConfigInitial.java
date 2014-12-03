package moutonsimulator.Jeu;

public class ConfigInitial {

    public static int width = 15;
    public static int heigth = 15;
    public int nbMouton = 0;
    public int nbLoup = 0;
    private int probaPlante = 0;//sur 1000

    public int nbFamillePlante = 0;
    private int eau = 40000;
    private int nbMaxFamille;

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

    public int getNbFamillePlante() {
        return nbFamillePlante;
    }

    public void setNbFamillePlante(int nbFamillePlante) {
        this.nbFamillePlante = nbFamillePlante;
    }

}
