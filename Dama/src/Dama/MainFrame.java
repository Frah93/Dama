package Dama;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    
    public static Scacchiera Board;
    private Regole Rule = new Regole();
    
    public MainFrame() {
     super();
     //definiamo i due giocatori
     Giocatore Giocatore1 = new Giocatore(Pedina.Colori.BIANCO);
     Giocatore Giocatore2 = new Giocatore(Pedina.Colori.NERO);
     //definiamo la scacchiera e disponiamo le pedine dei due giocatori
     Board = new Scacchiera();
     Board.initScacchiera(Giocatore1,Giocatore2);
     
     //Creo un oggetto grafico
     Container contentPane = this.getContentPane();
     
     this.setTitle("Dama");
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
     this.setResizable(false);
     this.setLayout(null);
     this.setSize(800, 600);
     this.setLocationRelativeTo(null);
          
     //Creo i bottoni
     JButton btnGioca = new JButton();
     btnGioca.setText("Gioca");
     btnGioca.setBounds(50, 500, 95, 30);
     {
         btnGioca.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent ae) {
                 Board.Set_Visible(true);
                 setVisible(false);
             }
         });
     }
     
     JButton btnEsci = new JButton();
     btnEsci.setText("Esci");
     btnEsci.setBounds(630, 500, 95, 30);
     {
         btnEsci.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent ae) {
                 System.exit(0);
             }
         });
     }
     
     JButton btnRegole = new JButton();
     btnRegole.setText("Regole");
     btnRegole.setBounds(500, 500, 95, 30);
     {
         btnRegole.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent ae) {
                 Rule.Set_Visible(true);
             }
         });
     }
     
     
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
