package Dama;

import java.awt.*;
import javax.swing.JPanel;
import util.Resources;

public class Background extends JPanel {
    
    private Image SfondoMenuNew;
    
    public Background(String locazione_immagine) {
        this.setSize(800, 600);
        this.SfondoMenuNew = Resources.getImage(locazione_immagine);
    }

    @Override
    public void paint(Graphics grphcs) {
        grphcs.drawImage(this.SfondoMenuNew, 0, 0, this);
    }
   
    
    
}
