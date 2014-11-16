package moutonsimulator.Elements;

import java.awt.Image;

public class Sol {
    
    private boolean traversable;
    private Image image;
    
    public Sol(Image img, boolean traversable){
        this.image = img;
        this.traversable = traversable;
    }

    public boolean isTraversable() {
        return traversable;
    }

    public void setTraversable(boolean traversable) {
        this.traversable = traversable;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
    
}
