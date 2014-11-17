package moutonsimulator.Elements;


public class CompetenceAnimale {

    private int vieMax;
    private int ageMax;
    private int engrais;
    private int vue;

    public CompetenceAnimale(int vieMax, int ageMax, int engrais,int vue) {
        this.vieMax = vieMax;
        this.ageMax = ageMax;
        this.engrais = engrais;
        this.vue = vue;
    }
    
    public static CompetenceAnimale randomCompetences(){
        return new CompetenceAnimale(100, 50, 2, 5);
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

    public int getVue() {
        return vue;
    }

    public void setVue(int vue) {
        this.vue = vue;
    }

}
