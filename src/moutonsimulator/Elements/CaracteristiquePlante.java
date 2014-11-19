package moutonsimulator.Elements;

import moutonsimulator.IntValMax;


public class CaracteristiquePlante {
    
    private IntValMax age;
    private IntValMax vie;
    private int dureePousse;
    private int porteSpore;
    private int dureeReproduction;
    private int proliferation;//pourcentage de chance d'ensemencer une case alentour
    
    public CaracteristiquePlante(int vieMax, int ageMax,int duree,int porte,int repro,int proliferartion){
        this.vie = new IntValMax(vieMax);
        this.age = new IntValMax(0, ageMax);
        this.dureePousse = duree;
        this.porteSpore = porte;
        this.dureeReproduction = repro;
        this.proliferation = proliferartion;
    }
    
    public static CaracteristiquePlante randomSpecs(){
        return new CaracteristiquePlante(10+(int)(Math.random()*25), 10+(int)(Math.random()*50), 2, 3+(int)(Math.random()*10), 20,10);
    }

    public IntValMax getAge() {
        return age;
    }

    public void setAge(IntValMax age) {
        this.age = age;
    }

    public IntValMax getVie() {
        return vie;
    }

    public void setVie(IntValMax vie) {
        this.vie = vie;
    }

    public int getDureePousse() {
        return dureePousse;
    }

    public void setDureePousse(int dureePousse) {
        this.dureePousse = dureePousse;
    }

    public int getPorteSpore() {
        return porteSpore;
    }

    public void setPorteSpore(int porteSpore) {
        this.porteSpore = porteSpore;
    }

    public int getDureeReproduction() {
        return dureeReproduction;
    }

    public void setDureeReproduction(int dureeReproduction) {
        this.dureeReproduction = dureeReproduction;
    }

    public int getProliferation() {
        return proliferation;
    }

    public void setProliferation(int proliferation) {
        this.proliferation = proliferation;
    }
    
    
    
}
 