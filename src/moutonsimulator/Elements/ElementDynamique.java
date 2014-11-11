package moutonsimulator.Elements;

import java.awt.Graphics2D;
import java.awt.Image;
import moutonsimulator.Config;
import moutonsimulator.Jeu.Case;

public abstract class ElementDynamique {

    protected Image image;
    protected Case conteneur;

    abstract public void update();

    public void render(Graphics2D batch) {
        batch.drawImage(image, conteneur.getX()*Config.coteCase, conteneur.getY()*Config.coteCase, Config.coteCase, Config.coteCase,null);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
