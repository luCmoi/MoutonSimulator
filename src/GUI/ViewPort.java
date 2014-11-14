package GUI;

import static GUI.MouseListenerPanel.inMoove;
import moutonsimulator.Config;
import moutonsimulator.Jeu.ConfigInitial;

public class ViewPort {

    public static int x = 0;
    public static int y = 0;
    public static int width;
    public static int height;
    public static int widthMax = ConfigInitial.width * Config.coteCase;
    public static int heightMax = ConfigInitial.heigth * Config.coteCase;
    public static PanelPartie panel;

    public static void resize(int width, int height) {
        if (ViewPort.x + width > ViewPort.widthMax) {
            if (width > ViewPort.widthMax) {
                ViewPort.width = ViewPort.widthMax;
                ViewPort.x = 0;
            } else {
                int xTmp = ViewPort.widthMax - width;
                System.out.println(xTmp);
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

    public static void zoom(int wheel) {
        int nC = Config.coteCase - 2 * wheel;
        if (nC >= 16 && nC <= 64 && !inMoove) {
            ViewPort.x = (ViewPort.x / Config.coteCase) * nC;
            ViewPort.y = (ViewPort.y / Config.coteCase) * nC;
            ViewPort.heightMax = (nC * ConfigInitial.heigth);
            ViewPort.widthMax = (nC * ConfigInitial.width);
            Config.coteCase = nC;
            ViewPort.panel.repaint();
        }

    }
}
