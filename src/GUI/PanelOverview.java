package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
    private int largeur;

    public PanelOverview(PanelPartie pan) {
        this.pan = pan;
        this.setLayout(new BorderLayout());
        this.largeur = 4 * Config.coteCase;
        contenu = new JPanel();
        scrollPan = new JScrollPane(contenu, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        this.add(new JLabel("Overview"), BorderLayout.NORTH);
        selection = new JComboBox();
        selection.addItem("Loup");
        selection.addItem("Mouton");
        selection.addItem("Plante");
        selection.addItemListener(new EtatCombo());
        this.add(selection, BorderLayout.CENTER);
        this.add(scrollPan, BorderLayout.SOUTH);
        this.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                setLargeur(e.getComponent().getWidth());
                selection.setSize(new Dimension(getLargeur(), 20));
                scrollPan.setPreferredSize(new Dimension(getLargeur(), e.getComponent().getHeight() - 60));
                selection.validate();
                contenu.validate();
            }
        });
    }

    public void update() {
        contenu.removeAll();
        contenu.repaint();
        if (getSelection().getSelectedIndex() == 0) {
            contenu.setLayout(new GridLayout(getPan().getPartie().getSetLoup().size(), 1));
            for (Animal m : getPan().getPartie().getSetLoup()) {
                getContenu().add(new JLabel("Louloup"));
            }
        }
        if (getSelection().getSelectedIndex() == 1) {
            contenu.setLayout(new GridLayout(getPan().getPartie().getSetMouton().size(), 1));
            for (Animal m : getPan().getPartie().getSetMouton()) {
                getContenu().add(new JLabel("Moutmout"));
            }
        }
        getScrollPan().validate();
    }

    public void render() {

    }

    public PanelPartie getPan() {
        return pan;
    }

    public void setPan(PanelPartie pan) {
        this.pan = pan;
    }

    public JComboBox getSelection() {
        return selection;
    }

    public void setSelection(JComboBox selection) {
        this.selection = selection;
    }

    public JScrollPane getScrollPan() {
        return scrollPan;
    }

    public void setScrollPan(JScrollPane scrollPan) {
        this.scrollPan = scrollPan;
    }

    public JPanel getContenu() {
        return contenu;
    }

    public void setContenu(JPanel contenu) {
        this.contenu = contenu;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    class EtatCombo implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent e) {
            update();
        }
    }
}
