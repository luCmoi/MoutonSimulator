package GUI;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import moutonsimulator.Config;
import moutonsimulator.Jeu.ConfigInitial;

public class PanelListener extends MouseAdapter implements ComponentListener {
    
    @Override
    public void componentResized(ComponentEvent e) {
        System.out.println("Comp : "+e.getClass());
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
