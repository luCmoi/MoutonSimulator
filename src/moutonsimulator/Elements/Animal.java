package moutonsimulator.Elements;

import moutonsimulator.IntValMax;
import moutonsimulator.Jeu.Case;

public abstract class Animal extends ElementDynamique {

    protected IntValMax vie;
    protected IntValMax age;
    protected Arbre arbreGene;
    protected CompetenceAnimale competence;

    public Animal(Case c, Arbre arbre) {
        this.competence = CompetenceAnimale.randomCompetences();
        this.arbreGene = arbre;
        this.vie = new IntValMax(competence.getVieMax());
        this.age = new IntValMax(0, competence.getAgeMax());
        this.conteneur = c;
    }

    @Override
    public void update() {
        if (this.vie.plusPlus()) {
            this.mort();
            return;
        }
        mouvementBasique();

    }

    public abstract boolean mange(ElementDynamique el);

    @Override
    public void mort() {
        this.conteneur.setAnimal(null);
        this.conteneur.setEngrais(this.conteneur.getEngrais() + this.competence.getEngrais());
    }

    public void mouvementBasique() {

        int nX, nY;
        int cmp = 0;
        while (cmp < 5) {
            nX = (conteneur.getX() - 1) + (int) (Math.random() * 3);
            nY = (conteneur.getY() - 1) + (int) (Math.random() * 3);
            cmp++;
            try {
                if (conteneur.getContainer().getPlateau()[nX][nY].getAnimal() != null) {
                    if (this.mange(conteneur.getContainer().getPlateau()[nX][nY].getAnimal())) {
                        conteneur.getContainer().getPlateau()[nX][nY].getAnimal().mort();
                        conteneur.setAnimal(null);
                        conteneur = conteneur.getContainer().getPlateau()[nX][nY];
                        conteneur.setAnimal(this);
                        break;
                    } else {
                        System.out.println("1");
                        throw new IndexOutOfBoundsException();
                    }
                } else {
                    conteneur.setAnimal(null);
                    conteneur = conteneur.getContainer().getPlateau()[nX][nY];
                    conteneur.setAnimal(this);
                    break;
                }

            } catch (IndexOutOfBoundsException e) {
            }
        }
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

    public Arbre getArbreGene() {
        return arbreGene;
    }

    public void setArbreGene(Arbre arbreGene) {
        this.arbreGene = arbreGene;
    }

    public Case getConteneur() {
        return conteneur;
    }

    public void setConteneur(Case conteneur) {
        this.conteneur = conteneur;
    }

}
