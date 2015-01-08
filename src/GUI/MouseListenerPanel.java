package GUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import moutonsimulator.Config;
import moutonsimulator.Jeu.Case;
import moutonsimulator.Jeu.ConfigInitial;

/**
 * Listener de la sourie sur le panel de la partie
 */
public class MouseListenerPanel implements MouseMotionListener, MouseListener, MouseWheelListener {

    private int xPressed = 0;
    private int yPressed = 0;
    private int xV = 0;
    private int yV = 0;
    private boolean inMoove = false;

    /**
     * Gère les déplacements du Viewport
     * @param me 
     */
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
    }

    /**
     * Gère l'affichage des fenetres spécifiques aux élément sur lesquels on clique
     * @param me 
     */
    @Override
    public void mousePressed(MouseEvent me) {
        if (me.getButton() == MouseEvent.BUTTON1) {
            xPressed = me.getX();
            yPressed = me.getY();
            xV = ViewPort.x;
            yV = ViewPort.y;
            inMoove = true;
        }
        if (me.getButton() == MouseEvent.BUTTON3) {
            Case tmp = ViewPort.panel.getPartie().getPlateau().getPlateau()[(me.getX() + ViewPort.x) / Config.coteCase][(me.getY() + ViewPort.y) / Config.coteCase];
            if (tmp.presence()) {
                if (tmp.getAnimal() != null && tmp.getPlante()==null) {
                    new FenetreElement(tmp.getAnimal());
                }else if(tmp.getAnimal()==null && tmp.getPlante()!=null){
                    new FenetreElement(tmp.getPlante());
                }else{
                    new FenetreElement(tmp.getAnimal(),tmp.getPlante());
                }
            }
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

    /**
     * Gère le zoom a l'aide du ViewPort
     * @param mwe 
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent mwe) {
        ViewPort.zoom(mwe.getWheelRotation(), inMoove);
        mwe.consume();
    }

}
