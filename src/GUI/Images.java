package GUI;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Images {

    public static Image herbe;
    public static Image mouton;
    public static Image loup;
    public static Image buisson;

    public static void init() {
        try {
            Images.herbe = ImageIO.read(new File("Ressources/Images/herbe.jpg"));
            Images.mouton = ImageIO.read(new File("Ressources/Images/mouton.png"));
            Images.loup = ImageIO.read(new File("Ressources/Images/loup.gif"));
            Images.buisson = ImageIO.read(new File("Ressources/Images/buisson.png"));
        } catch (IOException ex) {
            Logger.getLogger(Images.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
