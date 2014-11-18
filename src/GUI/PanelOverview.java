package GUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import moutonsimulator.Config;
import moutonsimulator.Elements.Animal;

public class PanelOverview extends JPanel {

    private PanelPartie pan;
    private JComboBox selection;
    private JScrollPane scrollPan;

    public PanelOverview(PanelPartie pan) {
        this.pan = pan;
        //this.setLayout(new GridLayout(3, 1));
        scrollPan = new JScrollPane();
        this.add(new JLabel("Overview"));
        this.setPreferredSize(new Dimension(4 * Config.coteCase, ViewPort.height));
        selection = new JComboBox();
        selection.setPreferredSize(new Dimension(3 * Config.coteCase, 20));
        selection.addItem("Loup");
        selection.addItem("Mouton");
        selection.addItem("Plante");
        selection.addItemListener(new EtatCombo());
        scrollPan.setSize(3*Config.coteCase, ViewPort.height-30);
        scrollPan.setVisible(true);
        this.add(selection);
        this.add(scrollPan);
    }

    public void update() {
        for (Component comp : scrollPan.getComponents()) {
            if (comp instanceof JLabel) {
                this.remove(comp);
            }
        }
        if (selection.getSelectedIndex() == 1) {
            for (Animal m : pan.getPartie().getSetMouton()) {
                scrollPan.add(new JLabel("Moutmout"));
                scrollPan.repaint();
                this.repaint();
            }
        }
    }

    public void render() {

    }

    class EtatCombo implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            update();
        }
    }
}
