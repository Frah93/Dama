package Dama;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import util.Resources;

public class Background extends JPanel {
    
    private Image sfondoMenu;
    
    public Background () {
        this.setSize(800, 600);
        this.sfondoMenu = Resources.getImage("/Images/SfondoMenu.jpg");
    }

    @Override
    public void paint(Graphics grphcs) {
        grphcs.drawImage(sfondoMenu, 0, 0, this);
    }
    
    
    
}
