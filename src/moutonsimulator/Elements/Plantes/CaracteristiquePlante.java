package moutonsimulator.Elements.Plantes;

public class CaracteristiquePlante {

    public int age;
    public int vie;
    public int dureePousse;//temps qu'une graine met a pousser
    public int porteSpore;//distance a la quelle un plante peut fertiliser une case
    public int intervalReproduction;//nombre de tour avant chaque reproduction
    public int proliferation;//pourcentage de chance d'ensemencer une case alentour
    public int tauxMutationPlante;//Proba de creer une nouvelle famille lors de la reproduction; sur 10000

    public CaracteristiquePlante(int vieMax, int ageMax, int dureePousse, int porte, int dureeRepro, int proliferartion,int tauxMutation) {
        this.vie = vieMax;
        this.age = ageMax;
        this.dureePousse = dureePousse;
        this.porteSpore = porte;
        this.intervalReproduction = dureeRepro;
        this.proliferation = proliferartion;
        this.tauxMutationPlante= tauxMutation;
    }

    public static CaracteristiquePlante randomSpecs() {
        int vieMax = 1 + (int) (Math.random() * 10);
        int ageMax = 60 + (int) (Math.random() * 30);
        int dureePousse = 3 + (int) (Math.random() * 13);
        int porteSpore = 1 + (int) (Math.random() * 5);
        int intervaleReproduction = ageMax / (1 + (int) (Math.random() * 3));
        int proliferation = 1 + (int) (Math.random() * 8);
        int tauxMutation = 1+(int)(Math.random()*2);
        return new CaracteristiquePlante(vieMax, ageMax, dureePousse, porteSpore, intervaleReproduction, proliferation,tauxMutation);
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

    public int getIntervalReproduction() {
        return intervalReproduction;
    }

    public void setIntervalReproduction(int dureeReproduction) {
        this.intervalReproduction = dureeReproduction;
    }

    public int getProliferation() {
        return proliferation;
    }

    public void setProliferation(int proliferation) {
        this.proliferation = proliferation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getTauxMutationPlante() {
        return tauxMutationPlante;
    }

    public void setTauxMutationPlante(int tauxMutationPlante) {
        this.tauxMutationPlante = tauxMutationPlante;
    }

}
