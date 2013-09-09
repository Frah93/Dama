package Dama;

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
        
        JLabel testo = new JLabel("Qui andranno le regole\n e le informazioni su come si gioca\n a dama.");
        
        //BufferedImage Dama = ImageIO.read(getClass().getResource("/Images/Ritratto di dama.jpg"));
        //JLabel Dama_label = new JLabel(Dama);
        
        //add(Dama_label);
        
    }
    
    public void Set_Visible(boolean pSet){
        setVisible(pSet);
    }
    
}
