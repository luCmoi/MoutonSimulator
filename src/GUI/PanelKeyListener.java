package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import moutonsimulator.Config;
import moutonsimulator.Jeu.ConfigInitial;

public class PanelKeyListener implements KeyListener {

    private int acceleratorY = 1;
    private int acceleratorX = 1;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP && ViewPort.y != 0) {
            ViewPort.y = ViewPort.y - acceleratorY;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN && ViewPort.y != (ConfigInitial.heigth - 1) * Config.coteCase) {
            ViewPort.y = ViewPort.y + acceleratorY;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && ViewPort.x != 0) {
            ViewPort.x = ViewPort.x - acceleratorX;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && ViewPort.x != (ConfigInitial.width - 1) * Config.coteCase) {
            ViewPort.x = ViewPort.x + acceleratorX;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
