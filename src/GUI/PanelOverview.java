package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import moutonsimulator.Elements.Plantes.FamillePlante;

/**
 * Panel qui affiche des informations sur les entitées présente sur la partie
 */
public class PanelOverview extends JPanel {

    private PanelPartie pan;
    private final JLabel nombreLoup = new JLabel();
    private final JLabel nombreMouton = new JLabel();
    private final JLabel nombreFamillePlante = new JLabel();
    private final JLabel nombrePlante = new JLabel();
    private final JLabel nombreJour = new JLabel();
    private int largeur;

    public PanelOverview(PanelPartie pan) {
        this.pan = pan;
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints contraintes = new GridBagConstraints();
        contraintes.fill = GridBagConstraints.BOTH;
        contraintes.insets = new Insets(5, 5, 5, 5);
        contraintes.gridheight = 32;

        contraintes.gridx = 0;
        contraintes.gridy = 0;
        contraintes.gridwidth = 1;
        contraintes.gridheight = 1;
        this.add(new JLabel("Overview"), contraintes);
        contraintes.gridy = 2;
        this.add(nombreLoup, contraintes);
        contraintes.gridy = 3;
        this.add(nombreMouton, contraintes);
        contraintes.gridy = 4;
        this.add(nombreFamillePlante, contraintes);
        contraintes.gridy = 5;
        this.add(nombrePlante, contraintes);
        contraintes.gridy = 6;
        this.add(nombreJour, contraintes);
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setLargeur(e.getComponent().getWidth());
            }
        });
    }

    public void update() {
        this.nombreLoup.setText("Nombre de Loups : " + pan.getPartie().getSetLoup().size());
        this.nombreMouton.setText("Nombre de Moutons : " + pan.getPartie().getSetMouton().size());
        this.nombreFamillePlante.setText("Nombre de famille de Plantes : " + pan.getPartie().getFamillesPlante().size());
        int comptePlante = 0;
        for (FamillePlante fp : pan.getPartie().getFamillesPlante()) {
            comptePlante += fp.getRepresentants().size();
        }
        this.nombrePlante.setText("Nombre de Plantes : " + comptePlante);
        this.nombreJour.setText("Jours écoulés : " + pan.getPartie().getJours());
        this.repaint();
        this.validate();
    }

    public PanelPartie getPan() {
        return pan;
    }

    public void setPan(PanelPartie pan) {
        this.pan = pan;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
}
