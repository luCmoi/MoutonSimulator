package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import moutonsimulator.Config;
import moutonsimulator.Jeu.Case;
import moutonsimulator.Jeu.ConfigInitial;

public class MouseListenerPanel implements MouseMotionListener, MouseListener, MouseWheelListener {

    public static int xPressed = 0;
    public static int yPressed = 0;
    public static int xV = 0;
    public static int yV = 0;
    public static boolean inMoove = false;

    @Override

    public void mouseDragged(MouseEvent me) {
        if (inMoove) {
            int nX = xV + (xPressed - me.getX());
            int nY = yV + (yPressed - me.getY());

            if (nX >= 0 && nX < (ConfigInitial.width * Config.coteCase) - ViewPort.width) {
                ViewPort.x = xV + (xPressed - me.getX());
            }
            if (nY >= 0 && nY < (ConfigInitial.heigth * Config.coteCase) - ViewPort.height) {
                ViewPort.y = yV + (yPressed - me.getY());
            }
            ViewPort.panel.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if (me.getButton() == MouseEvent.BUTTON3) {
            Case tmp = ViewPort.panel.getPartie().getPlateau().getPlateau()[(me.getX() + ViewPort.x) / 32][(me.getY() + ViewPort.y) / 32];
            if (tmp.getAnimal() != null) {
                new FenetreElement(tmp.getAnimal());
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getButton() == MouseEvent.BUTTON1) {
            xPressed = me.getX();
            yPressed = me.getY();
            xV = ViewPort.x;
            yV = ViewPort.y;
            inMoove = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        inMoove = false;
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mwe) {
        ViewPort.zoom(mwe.getWheelRotation(), inMoove);

    }

}
