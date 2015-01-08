package GUI;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import moutonsimulator.Config;
import moutonsimulator.Jeu.ConfigInitial;

/**
 * Listener associé au panel split afin de gérer les resized
 */
public class PanelListener implements ComponentListener {
    
    @Override
    public void componentResized(ComponentEvent e) {
        if(e.getComponent().getWidth()>(ConfigInitial.width * Config.coteCase)-ViewPort.width ||e.getComponent().getHeight()>(ConfigInitial.heigth * Config.coteCase)-ViewPort.height){
            
        }
        PanelPartie tmp = (PanelPartie) e.getSource();
        ViewPort.resize(tmp.getWidth(), tmp.getHeight());
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

}
