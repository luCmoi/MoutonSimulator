package GUI;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Images {

    public static BufferedImage herbe;
    public static BufferedImage mouton;
    public static BufferedImage loup;
    public static BufferedImage buisson;
    public static BufferedImage eau;
    public static BufferedImage pierre;
    public static BufferedImage hauteHerbe;
    public static BufferedImage herbe2;
    public static BufferedImage hauteHerbeModel;
    public static BufferedImage buissonModel;

    public static void init() {
        try {
            Images.hauteHerbeModel = ImageIO.read(new File("Ressources/Images/hauteHerbeNB.png"));
            Images.buissonModel = ImageIO.read(new File("Ressources/Images/buissonNB.png"));
            Images.herbe2 = ImageIO.read(new File("Ressources/Images/herbe2.png"));
            Images.hauteHerbe = ImageIO.read(new File("Ressources/Images/hauteHerbe.png"));
            Images.pierre = ImageIO.read(new File("Ressources/Images/rock.gif"));
            Images.eau = ImageIO.read(new File("Ressources/Images/eau.gif"));
            Images.herbe = ImageIO.read(new File("Ressources/Images/herbe.jpg"));
            Images.mouton = ImageIO.read(new File("Ressources/Images/mouton.png"));
            Images.loup = ImageIO.read(new File("Ressources/Images/loup.gif"));
            Images.buisson = ImageIO.read(new File("Ressources/Images/buisson.png"));
        } catch (IOException ex) {
            System.out.println("Toutes les images n'ont pas pu etre chargees.");
        }
    }

    public static BufferedImage conversionModel(BufferedImage model, Color c1, Color c2, Color c3) {
        /* System.out.println("-------------------------");
         System.out.println("-------------------------");
         System.out.println("-------------------------");
         */
        BufferedImage img = new BufferedImage(64, 64, 2);
        for (int x = 0; x < 64; x++) {
            for (int y = 0; y < 64; y++) {
                Color tmp = new Color(model.getRGB(x, y));
                //System.out.println("R : "+tmp.getRed()+" G : "+tmp.getGreen()+" B : "+tmp.getBlue()+" A : "+tmp.getAlpha());
                if (tmp.getAlpha() != 0.0 && tmp.getRed() == 0) {
                    // img.setRGB(x,y,Color.BLACK.getRGB());
                } else if (tmp.getRed() == 100) {//c1
                    img.setRGB(x, y, c1.getRGB());
                } else if (tmp.getRed() == 150) {//c2
                    img.setRGB(x, y, c2.getRGB());
                } else if (tmp.getRed() == 255) {//c3
                    img.setRGB(x, y, c3.getRGB());
                }
            }
        }/*
         System.out.println("-------------------------");
         System.out.println("-------------------------");
         System.out.println("-------------------------");
         */

        return img;
    }

}
