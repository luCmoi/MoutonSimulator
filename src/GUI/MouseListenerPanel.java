package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import moutonsimulator.Config;
import moutonsimulator.Jeu.ConfigInitial;

public class MouseListenerPanel implements MouseMotionListener, MouseListener, MouseWheelListener {

    public static int xPressed = 0;
    public static int yPressed = 0;
    public static int xV = 0;
    public static int yV = 0;
    public static boolean inMoove = false;

    @Override

    public void mouseDragged(MouseEvent me) {
        if(inMoove){
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
        //System.out.println("M");
    }

    @Override
    public void mouseClicked(MouseEvent me) {

        // System.out.println("C");
    }

    @Override
    public void mousePressed(MouseEvent me) {
        xPressed = me.getX();
        yPressed = me.getY();
        xV = ViewPort.x;
        yV = ViewPort.y;
        inMoove = true;
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        inMoove = false;
        //System.out.println("R");
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        // System.out.println("E");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //System.out.println("Ex");
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mwe) {
        int nC = Config.coteCase - 2 * mwe.getWheelRotation();
        if (nC >= 16 && nC < 64 && !inMoove) {
            Config.coteCase = nC;
            ViewPort.panel.repaint();
        }

    }

}
