package GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import moutonsimulator.Config;
import moutonsimulator.Elements.ElementDynamique;

public class AffichageElement extends JPanel {

    ElementDynamique element;

    public AffichageElement(ElementDynamique elem) {
        element = elem;
        this.setPreferredSize(new Dimension(100, 200));
        JButton imageBoutton = new JButton();
        imageBoutton.setPreferredSize(new Dimension(32, 32));
        imageBoutton.setAction(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewPort.setVue(element.getConteneur().getX() * Config.coteCase, element.getConteneur().getY() * Config.coteCase);
            }
        });
        imageBoutton.setIcon(new ImageIcon(Images.banqueImage.get(element.getIdImage()).getScaledInstance(32, 32, java.awt.Image.SCALE_SMOOTH)));
        this.add(imageBoutton);
    }
}
