package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import moutonsimulator.Elements.Animal;

public class FenetreElement extends JFrame {

    Animal info;

    public FenetreElement(Animal animal) {
        super(animal.getClass().toString());
        this.info = animal;
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints contraintes = new GridBagConstraints();
        contraintes.fill = GridBagConstraints.BOTH;
        contraintes.insets = new Insets(5, 5, 5, 5);
        this.setSize(400,200);
        this.setResizable(false);
        
        JLabel image = new JLabel(new ImageIcon(info.getImage().getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)));
        contraintes.gridx = 0;
        contraintes.gridy = 0;
        contraintes.gridwidth = 2;
        contraintes.gridheight = 2;
        this.add(image,contraintes);

        JLabel age = new JLabel("Age : " + info.getCompetence().getAge().getVal());
        contraintes.gridx = 2;
        contraintes.gridy = 0;
        contraintes.gridwidth = 1;
        contraintes.gridheight = 1;
        this.add(age,contraintes);
        
        JLabel vie = new JLabel("Vie : " + info.getCompetence().getVie().getVal()+"/"+info.getCompetence().getVie().getMax());
        contraintes.gridx = 2;
        contraintes.gridy = 1;
        contraintes.gridwidth = 1;
        contraintes.gridheight = 1;
        this.add(vie,contraintes);
        
        JLabel vue = new JLabel("Vue : " + info.getCompetence().getVue());
        contraintes.gridx = 3;
        contraintes.gridy = 0;
        contraintes.gridwidth = 1;
        contraintes.gridheight = 1;
        this.add(vue,contraintes);
        
        JLabel puissance = new JLabel("Puissance : " + info.getCompetence().getPuissance());
        contraintes.gridx = 3;
        contraintes.gridy = 1;
        contraintes.gridwidth = 1;
        contraintes.gridheight = 1;
        this.add(puissance,contraintes);
        this.setVisible(true);
    }
}
