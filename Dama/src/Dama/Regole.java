package Dama;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Regole extends JFrame{
    
    public Regole(){
        super();
        setTitle("Regole");
        setSize(450, 570);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(false);
        
        //BufferedImage Dama = ImageIO.read(getClass().getResource("/Images/Ritratto di dama.jpg"));
        //JLabel Dama_label = new JLabel(Dama);
        
        //add(Dama_label);
        
    }
    
    public void Set_Visible(boolean pSet){
        setVisible(pSet);
    }
    
}
