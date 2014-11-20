package GUI;

import javax.swing.JSplitPane;

public class PanelSplit extends JSplitPane {
    
    public PanelSplit(PanelPartie partie, PanelOverview overview,int width){
        super( JSplitPane.HORIZONTAL_SPLIT , partie, overview);
        this.setDividerLocation(width-overview.getLargeur());
        this.setDividerSize(5);
    }
}
