package GUI;

import java.awt.Dimension;
import javax.swing.JPanel;

public class PanelOverview extends JPanel {

    private final FenetrePrincipale container;

    public PanelOverview(FenetrePrincipale container) {
        this.container = container;
        this.setPreferredSize(new Dimension(50, ViewPort.height));

    }
}
