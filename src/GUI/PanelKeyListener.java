package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import moutonsimulator.Config;
import moutonsimulator.Jeu.ConfigInitial;

public class PanelKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP && ViewPort.y != 0) {
            ViewPort.y = ViewPort.y - 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN && ViewPort.y < ((ConfigInitial.heigth) * Config.coteCase) -ViewPort.height) {
            ViewPort.y = ViewPort.y + 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && ViewPort.x != 0) {
            ViewPort.x = ViewPort.x - 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && ViewPort.x < ((ConfigInitial.width) * Config.coteCase)-ViewPort.width) {
            ViewPort.x = ViewPort.x + 1;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
