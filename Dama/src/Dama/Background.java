package Dama;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;
import util.Resources;

public class Background extends JPanel {
    
    private Image sfondoMenu;
    
    public Background(){
        this(false);
    }
    
    public Background(boolean choose) {
        this.setSize(800, 600);
        if (choose){
            this.sfondoMenu = Resources.getImage("/Images/ExperimentalChessbaseChessBoard.png");
        }else{
            this.sfondoMenu = Resources.getImage("/Images/SfondoMenu.jpg");
        }
    }

    @Override
    public void paint(Graphics grphcs) {
        grphcs.drawImage(sfondoMenu, 0, 0, this);
    }
    
    
    
}
