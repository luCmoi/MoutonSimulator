package moutonsimulator.Elements;

import GUI.Images;
import java.util.ArrayList;
import moutonsimulator.Jeu.Case;

public class Loup extends Carnivore {

    public Loup(Case c, Arbre arbre) {
        super(c, arbre);
        this.image = Images.loup;
        priorite.put(Mouton.class, 10);
        priorite.put(Loup.class, 5);
        
    }

    public boolean inRange(Case c) {
        int d = ((conteneur.getX() - c.getX()) * (conteneur.getX() - c.getX())) + ((conteneur.getY() - c.getY()) * (conteneur.getY() - c.getY()));
        return d <= competence.getVue();
    }

    @Override
    public void moove() {
        //Recherche dichotomique du plus proche sur x
        /*
        ArrayList<Animal> moutInRange = new ArrayList<>();
        ArrayList<Animal> listMouton = getConteneur().getContainer().getPartie().getSetMouton();
        int indice = listMouton.size() / 2;
        while (!(conteneur.compareTo(listMouton.get(indice).getConteneur()) == 1) && conteneur.compareTo(listMouton.get(indice + 1).getConteneur()) == -1) {
            if (conteneur.compareTo(listMouton.get(indice).getConteneur()) == -1) {
                indice /= 2;
            } else if (conteneur.compareTo(listMouton.get(indice).getConteneur()) == 1) {
                indice += (listMouton.size() - indice) / 2;
            }
            else{
                break;
            }

        }
        //Reperage des moutons a porte de vue
        int tmpP = indice;
        int tmpM = indice;
        int xTmpP = listMouton.get(indice).getConteneur().getX();
        int xTmpM = listMouton.get(indice).getConteneur().getX();
        
        Case tmp = listMouton.get(indice).getConteneur();
        
        while (tmp.getX()<=conteneur.getX()+competence.getVue() && tmpP < listMouton.size()) {
            tmp = listMouton.get(tmpP).getConteneur();
            if (!moutInRange.contains(listMouton.get(tmpP)) && inRange(tmp)) {
                moutInRange.add(listMouton.get(tmpP));
            }
            tmpP++;
        }
        
        tmp = listMouton.get(indice).getConteneur();
        while (tmp.getX()>=conteneur.getX()-competence.getVue() && tmpM < listMouton.size()) {
            tmp = listMouton.get(tmpM).getConteneur();
            if (!moutInRange.contains(listMouton.get(tmpM)) && inRange(tmp)) {
                moutInRange.add(listMouton.get(tmpM));
            }
            tmpM--;
        }

        

        //trie liste mouton par x puis par y - FAIT
        //fouiller dans le range du loup les moutons quil y a dedant -FAIT
        //trouer celui qui a la distance la plus courte
        //aller le bouffer
                */
    }
                

}
