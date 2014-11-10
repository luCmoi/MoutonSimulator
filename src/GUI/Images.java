package GUI;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Images {

    public static Image herbe;

    public static void init() {
        try {
            Images.herbe = ImageIO.read(new File("Ressources/Images/herbe.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Images.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
