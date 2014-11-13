package GUI;

public class ViewPort {

    public static int x = 0;
    public static int y = 0;
    public static int width;
    public static int height;
    public static PanelPartie panel;
    
    public static void resize(int width, int height) {
        ViewPort.width = width;
        ViewPort.height = height;
        ViewPort.panel.repaint();
    }
}
