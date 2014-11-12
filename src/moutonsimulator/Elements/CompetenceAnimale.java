package moutonsimulator.Elements;


public class CompetenceAnimale {

    private int vieMax;
    private int ageMax;
    private int engrais;

    public CompetenceAnimale(int vieMax, int ageMax, int engrais) {
        this.vieMax = vieMax;
        this.ageMax = ageMax;
        this.engrais = engrais;
    }
    
    public static CompetenceAnimale randomCompetences(){
        return new CompetenceAnimale(10, 50, 2);
    }
    
    public int getEngrais() {
        return engrais;
    }

    public int getVieMax() {
        return vieMax;
    }

    public void setVieMax(int vieMax) {
        this.vieMax = vieMax;
    }

    public int getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(int ageMax) {
        this.ageMax = ageMax;
    }

    public void setEngrais(int engrais) {
        this.engrais = engrais;
    }

}
