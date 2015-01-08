package moutonsimulator.Jeu;

/**
 * Configuration d'une partie crée a partir du formulaire initial
 */
public class ConfigInitial {

    public static int width = 100;
    public static int heigth = 50;
    public final int nbMouton;
    public final int nbLoup;
    private final int probaPlante;
    public final int nbFamillePlante;
    private final int eau;
    public static boolean modeMinimal;

    public ConfigInitial(int caseX, int caseY, int mout, int loup, int probaPlante, int famillePlante, int eau, boolean selected) {
        width = caseX;
        heigth = caseY;
        nbMouton = mout;
        nbLoup = loup;
        modeMinimal=selected;
        this.probaPlante=probaPlante;
        nbFamillePlante=famillePlante;
        this.eau=eau;
    }

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

    public int getNbLoup() {
        return nbLoup;
    }

    public int getProbaPlante() {
        return probaPlante;
    }


    public int getEau() {
        return eau;
    }


    public int getNbFamillePlante() {
        return nbFamillePlante;
    }


}
