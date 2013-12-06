package Dama;

import util.*;
import javax.swing.*;

public class Regole extends JFrame{
    
    private Background RulesPanel;
    
    public Regole(){
    super();
    this.RulesPanel = new Background("/Images/DamaRegole.jpg");
    this.add(RulesPanel);
    this.RulesPanel.setSize(600, 750);
    this.setSize(600, 750);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    }
    
   
        
    
    public void Set_Visible(boolean pSet){
        setVisible(pSet);
    }
    
}
