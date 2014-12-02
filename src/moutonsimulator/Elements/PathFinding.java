package moutonsimulator.Elements;

import java.awt.Point;
import java.util.HashMap;
import moutonsimulator.Jeu.Case;

public class PathFinding {

    public static double distance(Point a, Point b) {
        return Math.sqrt(((a.x - b.x) * (a.x - b.x)) + ((a.y - b.y) * (a.y - b.y)));
    }

    public static void ajoutCaseVoisines(Point p, Point destination, HashMap<Point, Noeud> listeOuverte, HashMap<Point, Noeud> listeFermee, Case[][] plateau) {
        Noeud tmp = new Noeud();
        for (int i = Math.max(0, p.x - 1); i < Math.min(p.x + 2, plateau.length); i++) {
            for (int j = Math.max(0, p.y - 1); j < Math.min(p.y + 2, plateau[0].length); j++) {
                if (!(i == destination.x && j == destination.y)) {
                    if (((i == p.x) && (j == p.y)) || !plateau[i][j].isTraversable() || plateau[i][j].getAnimal()!=null) {
                        continue;
                    }
                }
                Point it = new Point(i, j);
                if (!listeFermee.containsKey(it)) {
                    tmp.cout_g = listeFermee.get(p).cout_g + (float) (distance(it, p));
                    tmp.cout_h = (float) distance(it, destination);
                    tmp.cout_f = tmp.cout_g + tmp.cout_h;
                    tmp.parent = p;
                    if (listeOuverte.containsKey(it)) {
                        if (tmp.cout_f < listeOuverte.get(it).cout_f) {
                            listeOuverte.put(it, tmp);
                        }
                    } else {
                        listeOuverte.put(it, tmp);
                    }
                }
            }
        }
    }

    public static void ajoutListeFermee(Point p, HashMap<Point, Noeud> listeFermee, HashMap<Point, Noeud> listeOuverte) {
        listeFermee.put(p, listeOuverte.get(p));
        listeOuverte.remove(p);
    }

    public static Point meilleurNoeud(HashMap<Point, Noeud> listeOuverte) {
        float m_coutf = -1;
        Point m_noeud = new Point();
        for (Point p : listeOuverte.keySet()) {
            if (m_coutf < 0) {
                m_coutf = listeOuverte.get(p).cout_f;
                m_noeud = p;
            } else if (listeOuverte.get(p).cout_f < m_coutf) {
                m_coutf = listeOuverte.get(p).cout_f;
                m_noeud = p;
            }
        }
        return m_noeud;
    }

    public static Point retrouver_chemin(Point destination, Point depart, HashMap<Point, Noeud> listeFermee, Objectif but) {
        Noeud tmp = listeFermee.get(destination);
        Point precedent = new Point();
        Point actuel = new Point();
        actuel.x = destination.x;
        actuel.y = destination.y;
        precedent.x = tmp.parent.x;
        precedent.y = tmp.parent.y;
        while (!precedent.equals(depart)) {
            actuel.x = precedent.x;
            actuel.y = precedent.y;
            tmp = listeFermee.get(tmp.parent);
            precedent.x = tmp.parent.x;
            precedent.y = tmp.parent.y;
        }
        if (actuel.equals(destination) && !but.isSuperpose()) {
            return listeFermee.get(actuel).parent;
        } else {
            return actuel;
        }
    }

}
