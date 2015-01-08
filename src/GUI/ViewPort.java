package GUI;

import moutonsimulator.Config;
import moutonsimulator.Jeu.ConfigInitial;

/**
 * Gère le placement de "camera" au dessus de la partie afin de n'en dessiner que la zone visible a l'écran
 */
public class ViewPort {

    public static int x = 0;
    public static int y = 0;
    public static int width;
    public static int height;
    public static int widthMax = ConfigInitial.width * Config.coteCase;
    public static int heightMax = ConfigInitial.heigth * Config.coteCase;
    public static PanelPartie panel;

    /**
     * Recalcul la camera avec de nouvelles dimensions
     * @param width
     * @param height 
     */
    public static void resize(int width, int height) {
        if (ViewPort.x + width > ViewPort.widthMax) {
            if (width > ViewPort.widthMax) {
                ViewPort.width = ViewPort.widthMax;
                ViewPort.x = 0;
            } else {
                int xTmp = ViewPort.widthMax - width;
                ViewPort.width = width;
                ViewPort.x = xTmp;
            }
        } else {
            ViewPort.width = width;
        }
        if (ViewPort.y + height > ViewPort.heightMax) {
            if (height > ViewPort.heightMax) {
                ViewPort.height = ViewPort.heightMax;
                ViewPort.y = 0;
            } else {
                int yTmp = ViewPort.heightMax - height;
                ViewPort.height = height;
                ViewPort.y = yTmp;
            }
        } else {
            ViewPort.height = height;
        }
        ViewPort.panel.repaint();
    }

    /**
     * Recalcul la camera a la suite d'un zoom
     * @param wheel
     * @param inMoove 
     */
    public static void zoom(int wheel, boolean inMoove) {
        int nC = Config.coteCase - 2 * wheel;
        if (nC >= 16 && nC <= 64 && !inMoove) {
            ViewPort.x = (ViewPort.x / Config.coteCase) * nC;
            ViewPort.y = (ViewPort.y / Config.coteCase) * nC;
            ViewPort.heightMax = (nC * ConfigInitial.heigth);
            ViewPort.widthMax = (nC * ConfigInitial.width);
            Config.coteCase = nC;
            if (ViewPort.x + ViewPort.width > ViewPort.widthMax) {
                if (ViewPort.width > ViewPort.widthMax) {
                    ViewPort.width = ViewPort.widthMax;
                    ViewPort.x = 0;
                } else {
                    int xTmp = ViewPort.widthMax - ViewPort.width;
                    ViewPort.x = xTmp;
                }
            }
            if (ViewPort.y + ViewPort.height > ViewPort.heightMax) {
                if (ViewPort.height > ViewPort.heightMax) {
                    ViewPort.height = ViewPort.heightMax;
                    ViewPort.y = 0;
                } else {
                    int yTmp = ViewPort.heightMax - ViewPort.height;
                    ViewPort.y = yTmp;
                }
            }
            ViewPort.panel.repaint();
        }

    }

    /**
     * Déplace le ViewPort au dessus d'une zone spécifique
     * @param x
     * @param y 
     */
    static void setVue(int x, int y) {
        x = x - (ViewPort.width / 2);
        y = y - (ViewPort.height / 2);
        if (x < 0) {
            x = 0;
        }
        if (y < 0) {
            y = 0;
        }
        if (x + ViewPort.width > ViewPort.widthMax) {
            x = ViewPort.widthMax - ViewPort.width;
        }
        if (y + ViewPort.height > heightMax) {
            y = ViewPort.heightMax - ViewPort.height;
        }
        ViewPort.x = x;
        ViewPort.y = y;
        ViewPort.panel.repaint();
    }
}
