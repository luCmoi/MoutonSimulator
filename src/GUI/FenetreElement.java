package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.MouseInfo;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import moutonsimulator.Elements.Animal;
import moutonsimulator.Elements.ElementDynamique;
import moutonsimulator.Elements.Plantes.Plante;

public class FenetreElement extends JFrame {
    
    ElementDynamique info;
    
    public FenetreElement(ElementDynamique animal) {
        super(animal.getClass().getSimpleName());
        this.setLocation(MouseInfo.getPointerInfo().getLocation());
        this.info = animal;
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints contraintes = new GridBagConstraints();
        contraintes.fill = GridBagConstraints.BOTH;
        contraintes.insets = new Insets(5, 5, 5, 5);
        contraintes.gridheight = 32;
        contraintes.gridwidth = 32;
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        
        JLabel image = new JLabel(new ImageIcon(Images.banqueImage.get(info.getIdImage()).getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)));
        contraintes.gridx = 0;
        contraintes.gridy = 0;
        contraintes.gridwidth = 2;
        contraintes.gridheight = 2;
        this.add(image, contraintes);
        
        if (info instanceof Animal) {
            Animal info = (Animal) this.info;
            JLabel age = new JLabel("Age : " + info.getCompetence().getAge().getVal());
            contraintes.gridx = 2;
            contraintes.gridwidth = 1;
            contraintes.gridheight = 1;
            this.add(age, contraintes);
            
            JLabel vie = new JLabel("Vie : " + info.getCompetence().getVie().getVal() + "/" + info.getCompetence().getVie().getMax());
            contraintes.gridy = 1;
            this.add(vie, contraintes);
            
            JLabel vue = new JLabel("Vue : " + info.getCompetence().getVue());
            contraintes.gridx = 3;
            contraintes.gridy = 0;
            this.add(vue, contraintes);
            
            JLabel puissance = new JLabel("Puissance : " + info.getCompetence().getPuissance());
            contraintes.gridy = 1;
            this.add(puissance, contraintes);
        } else {
            Plante info = (Plante) this.info;
            
            JLabel age = new JLabel("Age : " + info.getAge().getVal());
            contraintes.gridx = 2;
            contraintes.gridy = 0;
            contraintes.gridwidth = 1;
            contraintes.gridheight = 1;
            this.add(age, contraintes);
            
            JLabel vie = new JLabel("Vie : " + info.getVie().getVal() + "/" + info.getVie().getMax());
            contraintes.gridy = 1;
            this.add(vie, contraintes);
            
            JButton famille = new JButton(new ImageIcon(Images.arbre.getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)));
            famille.setPreferredSize(new Dimension(64, 64));
            famille.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    afficheFamille();
                }
            });
            contraintes.gridx = 4;
            contraintes.gridy = 0;
            contraintes.gridwidth = 2;
            contraintes.gridheight = 2;
            this.add(famille, contraintes);
        }
        this.pack();
        this.setVisible(true);
    }
    
    private void afficheFamille() {
        this.getContentPane().removeAll();
        GridBagConstraints contraintes = new GridBagConstraints();
        contraintes.fill = GridBagConstraints.BOTH;
        contraintes.insets = new Insets(5, 5, 5, 5);
        contraintes.gridheight = 32;
        contraintes.gridwidth = 32;
        Plante info = (Plante) this.info;
        
        JLabel image = new JLabel(new ImageIcon(Images.banqueImage.get(info.getFamille().getIdImage()).getScaledInstance(64, 64, java.awt.Image.SCALE_SMOOTH)));
        contraintes.gridx = 0;
        contraintes.gridy = 0;
        contraintes.gridwidth = 2;
        contraintes.gridheight = 2;
        this.add(image, contraintes);
        
        JLabel age = new JLabel("Age : " + info.getFamille().getSpecs().getAge());
        contraintes.gridx = 2;
        contraintes.gridwidth = 1;
        contraintes.gridheight = 1;
        this.add(age, contraintes);
        
        JLabel vie = new JLabel("Vie : " + info.getFamille().getSpecs().getVie());
        contraintes.gridy = 1;
        this.add(vie, contraintes);
        
        JLabel duree = new JLabel("Duree de pousse : " + info.getFamille().getSpecs().getDureePousse());
        contraintes.gridx = 3;
        contraintes.gridy = 0;
        this.add(duree, contraintes);
        
        JLabel mute = new JLabel("Taux de mutation : " + info.getFamille().getSpecs().getTauxMutationPlante() + "/1000");
        contraintes.gridy = 1;
        this.add(mute, contraintes);
        
        JLabel membres = new JLabel("Nombre de membres : " + info.getFamille().getRepresentants().size());
        contraintes.gridx = 2;
        contraintes.gridy = 2;
        this.add(membres, contraintes);
        
        this.pack();
        this.repaint();
    }
}
