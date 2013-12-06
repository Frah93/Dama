package Dama;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    
    private GameLogic Logic;
    private Regole Rule;
    
    public MainFrame() {
     super();
     //serve per togliere la decorazione della finestra di windows
     this.setUndecorated(true);
     
     //instanziamo le regole
     this.Rule = new Regole();
     
     //definiamo i due giocatori
     Giocatore Giocatore1 = new Giocatore(Pedina.Colori.BIANCO);
     Giocatore Giocatore2 = new Giocatore(Pedina.Colori.NERO);
     
     //instanziamo il gioco
     this.Logic = new GameLogic(Giocatore1, Giocatore2);
     
     this.setTitle("Dama");
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
     this.setResizable(false);
     this.setLayout(null);
     this.setSize(800, 600);
     this.setLocationRelativeTo(null);
          
     //Creo i bottoni
     JButton btnGioca = new JButton();
     btnGioca.setText("Gioca");
     btnGioca.setBounds(50, 500, 100, 50);
     {
         btnGioca.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent ae) {
                 Logic.setGameBoardVisible(true);
                 setVisible(false);
             }
         });
     }
     
     JButton btnEsci = new JButton();
     btnEsci.setText("Esci");
     btnEsci.setBounds(630, 500, 100, 50);
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
     btnRegole.setBounds(330, 500, 100, 50);
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
     
     Background background = new Background("/Images/SfondoMenuNew.jpg");
     this.add(background);
     
     }
    
    public static final MainFrame Menu = new MainFrame();
    
    public static void main(String[] args){
         
        Menu.setVisible(true);
               
    }

            
}
