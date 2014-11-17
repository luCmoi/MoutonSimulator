package moutonsimulator.Elements;

import moutonsimulator.IntValMax;


public class CaracteristiqueAnimale {

    private IntValMax vie;
    private IntValMax age;
    private int engrais;
    private int vue;
    private int puissance;

    public CaracteristiqueAnimale(int vieMax, int ageMax, int engrais,int vue, int puissance) {
        this.vie = new IntValMax(vieMax);
        this.age = new IntValMax(0, ageMax);
        this.engrais = engrais;
        this.vue = vue;
        this.puissance = puissance;
    }
    
    public static CaracteristiqueAnimale randomCompetences(){
        return new CaracteristiqueAnimale(70, 100, 2, 5, 20);
    }
    
    public int getEngrais() {
        return engrais;
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

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    public IntValMax getVie() {
        return vie;
    }

    public void setVie(IntValMax vie) {
        this.vie = vie;
    }

    public IntValMax getAge() {
        return age;
    }

    public void setAge(IntValMax age) {
        this.age = age;
    }

}
