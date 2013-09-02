package Dama;

import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    
      
    public MainFrame() {
     super();
     
      //Creo un oggetto grafico
     Container contentPane = this.getContentPane();
     
     this.setTitle("Dama");
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
     this.setResizable(false);
     this.setLayout(null);
     this.setLocationRelativeTo(null);
     this.setSize(800, 600);
          
     //Creo i bottoni
     JButton btnGioca = new JButton();
     btnGioca.setText("Gioca");
     btnGioca.setBounds(70, 100, 70, 30);
        
     JButton btnEsci = new JButton();
     btnEsci.setText("Esci");
     btnEsci.setBounds(70, 200, 95, 30);
     
     JButton btnRegole = new JButton();
     btnRegole.setText("Regole");
     btnRegole.setBounds(70, 100, 95, 30);
     
    this.add(btnGioca);
    this.add(btnEsci);
    this.add(btnRegole);
     
     Background background = new Background();
     this.add(background);
     
     }
    
    public static void main(String[] args){
        
        MainFrame Menu = new MainFrame();    
        Menu.setVisible(true);
               
    }

            
}
