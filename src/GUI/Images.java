package GUI;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;

/**
 * Class a éléments static qui sert de banque d'image au programme
 */
public class Images {

    public static BufferedImage herbe;
    public static BufferedImage mouton;
    public static BufferedImage mouton1;
    public static BufferedImage loup;
    public static BufferedImage buisson;
    public static BufferedImage eau;
    public static BufferedImage pierre;
    public static BufferedImage hauteHerbe;
    public static BufferedImage herbe2;
    public static BufferedImage hauteHerbeModel;
    public static BufferedImage buissonModel;
    public static BufferedImage arbre;
    public static HashMap<Integer, BufferedImage> banqueImage;
    public static int compteurImage;

    /** 
     * Charge les images necessaire au jeu
     * Creer la banque d'image et y met l'image du loup, des moutons males et femelle
     */
    public static void init() {
        Images.banqueImage = new HashMap<>();
        Images.compteurImage = 0;
        
        try {
            Images.arbre = ImageIO.read(new File("Ressources/Images/arbre.png"));
            Images.hauteHerbeModel = ImageIO.read(new File("Ressources/Images/hauteHerbeNB.png"));
            Images.buissonModel = ImageIO.read(new File("Ressources/Images/buissonNB.png"));
            Images.herbe2 = ImageIO.read(new File("Ressources/Images/herbe2.png"));
            Images.hauteHerbe = ImageIO.read(new File("Ressources/Images/hauteHerbe.png"));
            Images.pierre = ImageIO.read(new File("Ressources/Images/rock.gif"));
            Images.eau = ImageIO.read(new File("Ressources/Images/eau.gif"));
            Images.herbe = ImageIO.read(new File("Ressources/Images/herbe.jpg"));
            Images.mouton = ImageIO.read(new File("Ressources/Images/mouton.png"));
            Images.mouton1 = ImageIO.read(new File("Ressources/Images/mouton1.png"));
            Images.loup = ImageIO.read(new File("Ressources/Images/loup.gif"));
            Images.buisson = ImageIO.read(new File("Ressources/Images/buisson.png"));
        } catch (IOException ex) {
            System.out.println("Toutes les images n'ont pas pu etre chargees.");
        }
        //
         Images.banqueImage.put(0,Images.loup);
         Images.banqueImage.put(1,Images.mouton);
         Images.banqueImage.put(2,Images.mouton1);
         compteurImage = 3;
        
        //
    }
    
    /**
     * A partir du modele en noir et blanc,
     * Genere une nouvelle image avec des couleur differente mais coherentes
     * Donne un id a cette image et la place dans la banque
     * Renvoi l'id
     * @param model
     * @return 
     */
    public static int nouvelleImage(int model) {
        BufferedImage imgModel;
        switch (model) {
            case 0:
                imgModel = hauteHerbeModel;
                break;
            default:
                imgModel = buissonModel;
        }
        int r = (int) (Math.random() * 153);
        int g = (int) (Math.random() * 153);
        int b = (int) (Math.random() * 153);

        Color c1 = new Color(r, g, b);
        Color c2 = new Color(r + 51, g + 51, b + 51);
        Color c3 = new Color(r + 102, g + 102, b + 102);
        Images.banqueImage.put(Images.compteurImage, conversionModel(imgModel, c1, c2, c3));
        return compteurImage++;
    }

    /**
     * Genere la nouvelle imagea partir du model et des trois couleurs
     * @param model
     * @param c1
     * @param c2
     * @param c3
     * @return 
     */
    public static BufferedImage conversionModel(BufferedImage model, Color c1, Color c2, Color c3) {
        BufferedImage img = new BufferedImage(64, 64, 2);
        for (int x = 0; x < 64; x++) {
            for (int y = 0; y < 64; y++) {
                Color tmp = new Color(model.getRGB(x, y));
                if (tmp.getRed() == 30) {
                    img.setRGB(x, y, Color.BLACK.getRGB());
                } else if (tmp.getRed() == 100) {//c1
                    img.setRGB(x, y, c1.getRGB());
                } else if (tmp.getRed() == 150) {//c2
                    img.setRGB(x, y, c2.getRGB());
                } else if (tmp.getRed() == 255) {//c3
                    img.setRGB(x, y, c3.getRGB());
                }
            }

        }
        return img;
    }

}
