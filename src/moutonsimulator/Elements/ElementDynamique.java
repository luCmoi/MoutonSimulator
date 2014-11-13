package moutonsimulator.Elements;

import GUI.ViewPort;
import java.awt.Graphics2D;
import java.awt.Image;
import moutonsimulator.Config;
import moutonsimulator.IntValMax;
import moutonsimulator.Jeu.Case;

public abstract class ElementDynamique {

    protected IntValMax vie;
    protected IntValMax age;
    protected Image image;
    protected Case conteneur;

    public void update() {
        if (this.vie.decremente()) {
            this.mort();
        }
        if (this.age.incremente()) {
            this.mort();
        }
    }

    public abstract void mort();

    public void render(Graphics2D batch) {
        batch.drawImage(image, (conteneur.getX() * Config.coteCase) - (ViewPort.x), (conteneur.getY() * Config.coteCase) - (ViewPort.y), Config.coteCase, Config.coteCase, null);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
