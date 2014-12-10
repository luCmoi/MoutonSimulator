package moutonsimulator.Elements;

import moutonsimulator.IntValMax;

public class CaracteristiqueAnimale {

    private IntValMax vie;
    private IntValMax age;
    public IntValMax reproduction;
    private int engrais;
    private int vue;
    private int puissance;

    public CaracteristiqueAnimale(int vieMax, int ageMax, int engrais, int vue, int puissance, int repro) {
        this.vie = new IntValMax(vieMax);
        this.age = new IntValMax(0, ageMax);
        this.reproduction = new IntValMax(repro);
        this.engrais = engrais;
        this.vue = vue;
        this.puissance = puissance;
    }

    public static CaracteristiqueAnimale randomCompetences() {
        int vieMax = 5 + (int) (Math.random() * 11);
        int ageMax = 70 + (int) (Math.random() * 41);
        int engrais = 1 + (int) (Math.random() * 2);
        int vue = 7 + (int) (Math.random() * 9);
        int puissance = 5 + (int) (Math.random() * 5);
        int repro = 15 + (int) (Math.random() * 10);
        return new CaracteristiqueAnimale(vieMax, ageMax, engrais, vue, puissance, repro);
    }

    public static CaracteristiqueAnimale specsEnfant(CaracteristiqueAnimale specsPere, CaracteristiqueAnimale specsMere) {
        int vieMax = (specsPere.getVie().getVal()+specsMere.getVie().getVal())/2;
        int ageMax = (specsPere.getAge().getVal()+specsMere.getAge().getVal())/2;
        int engrais = (specsPere.getEngrais()+specsMere.getEngrais())/2;
        int vue = (specsPere.getVue()+specsMere.getVue())/2;
        int puissance = (specsPere.getPuissance()+specsMere.getPuissance())/2;
        int repro = (specsPere.getReproduction().getVal()+specsMere.getReproduction().getVal())/2;
        return new CaracteristiqueAnimale(vieMax, ageMax, engrais, vue, puissance, repro);
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

    public IntValMax getReproduction() {
        return reproduction;
    }

    public void setReproduction(IntValMax reproduction) {
        this.reproduction = reproduction;
    }

}
