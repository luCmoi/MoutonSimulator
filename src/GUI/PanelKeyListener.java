package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import moutonsimulator.Config;
import moutonsimulator.Jeu.ConfigInitial;
import moutonsimulator.Jeu.Partie;

public class PanelKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP && ViewPort.y != 0) {
            ViewPort.y = ViewPort.y - 1;
            ViewPort.panel.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN && ViewPort.y < ((ConfigInitial.heigth) * Config.coteCase) - ViewPort.height) {
            ViewPort.y = ViewPort.y + 1;
            ViewPort.panel.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && ViewPort.x != 0) {
            ViewPort.x = ViewPort.x - 1;
            ViewPort.panel.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && ViewPort.x < ((ConfigInitial.width) * Config.coteCase) - ViewPort.width) {
            ViewPort.x = ViewPort.x + 1;
            ViewPort.panel.repaint();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (Partie.pause) {
                Partie.pause = false;
            }else{
               Partie.pause = true; 
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
