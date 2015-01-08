package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.text.NumberFormatter;
import moutonsimulator.BigBoss;
import moutonsimulator.Jeu.ConfigInitial;

/**
 * Fenêtre affichée lors du lancement du programme permettant d'en choisir les réglages
 */
public class FenetreCreation extends JFrame {

    private final JFormattedTextField nombreCaseX;
    private final JFormattedTextField nombreCaseY;
    private final JFormattedTextField nombreMouton;
    private final JFormattedTextField nombreLoup;
    private final JFormattedTextField nombreEau;
    private final JFormattedTextField nombreFamilleP;
    private final JFormattedTextField nombreProbaP;
    private final JRadioButton choixNormal;

    public FenetreCreation() {
        super("Creation de la carte");
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints contraintes = new GridBagConstraints();
        contraintes.fill = GridBagConstraints.BOTH;
        contraintes.insets = new Insets(10, 10, 10, 10);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        NumberFormatter formatter = new NumberFormatter(NumberFormat.getInstance());
        formatter.setValueClass(Integer.class);
        formatter.setMinimum(1);
        formatter.setMaximum(Integer.MAX_VALUE);
        formatter.setCommitsOnValidEdit(true);

        JLabel titre = new JLabel("Nouvelle Carte");
        contraintes.gridx = 0;
        contraintes.gridy = 0;
        contraintes.gridwidth = 2;
        contraintes.gridheight = 1;
        this.add(titre, contraintes);

        JLabel labelCaseX = new JLabel("Nombre de case de largeur");
        contraintes.gridy = 1;
        contraintes.gridwidth = 1;
        this.add(labelCaseX, contraintes);
        nombreCaseX = new JFormattedTextField(formatter);
        nombreCaseX.setText("40");
        nombreCaseX.setPreferredSize(new Dimension(75, 20));
        contraintes.gridx = 1;
        this.add(nombreCaseX, contraintes);

        JLabel labelCaseY = new JLabel("Nombre de case de hauteur");
        contraintes.gridx = 0;
        contraintes.gridy = 2;
        this.add(labelCaseY, contraintes);
        nombreCaseY = new JFormattedTextField(formatter);
        nombreCaseY.setText("40");
        contraintes.gridx = 1;
        this.add(nombreCaseY, contraintes);
        try {
            formatter = (NumberFormatter) formatter.clone();
        } catch (CloneNotSupportedException ex) {
        }
        formatter.setMinimum(0);

        JLabel labelNombreMouton = new JLabel("Nombre de moutons");
        contraintes.gridx = 0;
        contraintes.gridy = 3;
        this.add(labelNombreMouton, contraintes);
        nombreMouton = new JFormattedTextField(formatter);
        nombreMouton.setText("400");
        contraintes.gridx = 1;
        this.add(nombreMouton, contraintes);

        JLabel labelNombreLoup = new JLabel("Nombre de loups");
        contraintes.gridx = 0;
        contraintes.gridy = 4;
        this.add(labelNombreLoup, contraintes);
        nombreLoup = new JFormattedTextField(formatter);
        nombreLoup.setText("20");
        contraintes.gridx = 1;
        this.add(nombreLoup, contraintes);

        JLabel labelProbaPlante = new JLabel("Proportion de plante sur mille");
        contraintes.gridx = 0;
        contraintes.gridy = 5;
        this.add(labelProbaPlante, contraintes);
        nombreProbaP = new JFormattedTextField(formatter);
        nombreProbaP.setText("100");
        contraintes.gridx = 1;
        this.add(nombreProbaP, contraintes);

        JLabel labelNombreFamilleP = new JLabel("Nombre de famille de Plante");
        contraintes.gridx = 0;
        contraintes.gridy = 6;
        this.add(labelNombreFamilleP, contraintes);
        nombreFamilleP = new JFormattedTextField(formatter);
        nombreFamilleP.setText("50");
        contraintes.gridx = 1;
        this.add(nombreFamilleP, contraintes);

        JLabel labelEau = new JLabel("Cases d'eau");
        contraintes.gridx = 0;
        contraintes.gridy = 7;
        this.add(labelEau, contraintes);
        nombreEau = new JFormattedTextField(formatter);
        nombreEau.setText("200");
        contraintes.gridx = 1;
        this.add(nombreEau, contraintes);

        choixNormal = new JRadioButton("Mode Minimal", false);
        contraintes.gridx = 0;
        contraintes.gridy = 8;
        this.add(choixNormal, contraintes);

        JButton creer = new JButton(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int caseX = Integer.parseInt(nombreCaseX.getText().replaceAll(" ", ""));
                int caseY = Integer.parseInt(nombreCaseY.getText().replaceAll(" ", ""));
                int mout = Integer.parseInt(nombreMouton.getText().replaceAll(" ", ""));
                int loup = Integer.parseInt(nombreLoup.getText().replaceAll(" ", ""));
                int probaPlante = Integer.parseInt(nombreProbaP.getText().replaceAll(" ", ""));
                int famillePlante = Integer.parseInt(nombreFamilleP.getText().replaceAll(" ", ""));
                int eau = Integer.parseInt(nombreEau.getText().replaceAll(" ", ""));
                BigBoss boss = new BigBoss(new ConfigInitial(caseX, caseY, mout, loup, probaPlante, famillePlante, eau, choixNormal.isSelected()));
                dispose();
            }
        });
        creer.setText("Valider");
        contraintes.gridx = 0;
        contraintes.gridy = 9;
        this.add(creer, contraintes);

        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }
}
