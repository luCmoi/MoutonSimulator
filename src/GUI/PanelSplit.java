package GUI;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JSplitPane;

/**
 * Panel contenant les deux autres et permettant de resize les deux Panels manuellement
¨ */
public class PanelSplit extends JSplitPane {

    private final PanelOverview overview;

    public PanelSplit(PanelPartie partie, final PanelOverview overview, int width) {
        super(JSplitPane.HORIZONTAL_SPLIT, partie, overview);
        this.overview=overview;
        this.setDividerLocation(width - overview.getLargeur());
        this.setDividerSize(5);
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setDividerLocation(e.getComponent().getWidth() - overview.getLargeur());
            }
        });
    }
}
