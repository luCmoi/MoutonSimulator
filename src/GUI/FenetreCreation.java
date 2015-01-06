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
import javax.swing.text.NumberFormatter;
import moutonsimulator.Jeu.ConfigInitial;
import moutonsimulator.MoutonSimulator;

public class FenetreCreation extends JFrame {

    JFormattedTextField nombreCaseX;
    JFormattedTextField nombreCaseY;
    JFormattedTextField nombreMouton;
    JFormattedTextField nombreLoup;

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
        nombreCaseX.setText("100");
        nombreCaseX.setPreferredSize(new Dimension(75, 20));
        contraintes.gridx = 1;
        this.add(nombreCaseX, contraintes);

        JLabel labelCaseY = new JLabel("Nombre de case de hauteur");
        contraintes.gridx = 0;
        contraintes.gridy = 2;
        this.add(labelCaseY, contraintes);
        nombreCaseY = new JFormattedTextField(formatter);
        nombreCaseY.setText("50");
        contraintes.gridx = 1;
        this.add(nombreCaseY, contraintes);
        try {
            formatter= (NumberFormatter)formatter.clone();
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

        JButton creer = new JButton(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int caseX = Integer.parseInt(nombreCaseX.getText().replaceAll(" ", ""));
                int caseY = Integer.parseInt(nombreCaseY.getText().replaceAll(" ", ""));
                int mout = Integer.parseInt(nombreMouton.getText().replaceAll(" ", ""));
                int loup = Integer.parseInt(nombreLoup.getText().replaceAll(" ", ""));
                MoutonSimulator.nouveau(new ConfigInitial(caseX, caseY, mout, loup));
                dispose();
            }
        });
        creer.setText("Valider");
        contraintes.gridx = 0;
        contraintes.gridy = 5;
        this.add(creer,contraintes);
        
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
    }
}
