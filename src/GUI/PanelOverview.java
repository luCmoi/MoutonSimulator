package GUI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
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
    private JPanel contenu;

    public PanelOverview(PanelPartie pan) {
        this.pan = pan;
        //this.setLayout(new GridLayout(3, 1));
        contenu = new JPanel();
        contenu.setPreferredSize(new Dimension(3 * Config.coteCase, 150));
        scrollPan = new JScrollPane(contenu, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.add(new JLabel("Overview"));
        this.setPreferredSize(new Dimension(4 * Config.coteCase, Toolkit.getDefaultToolkit().getScreenSize().height));
        selection = new JComboBox();
        selection.setPreferredSize(new Dimension(3 * Config.coteCase, 20));
        selection.addItem("Loup");
        selection.addItem("Mouton");
        selection.addItem("Plante");
        selection.addItemListener(new EtatCombo());
        this.add(selection);
        this.add(scrollPan);
    }

    public void update() {
        for (Component comp : contenu.getComponents()) {
            contenu.remove(comp);
        }
        if (selection.getSelectedIndex() == 0) {
            for (Animal m : pan.getPartie().getSetLoup()) {
                contenu.add(new JLabel("Louloup"));
            }
        }
        if (selection.getSelectedIndex() == 1) {
            for (Animal m : pan.getPartie().getSetMouton()) {
                contenu.add(new JLabel("Moutmout"));
            }
        }
        scrollPan.validate();
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
