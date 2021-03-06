package Dama;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Scacchiera extends JFrame{ 
    
    public enum Colori {
        BIANCO,
        NERO;
        @Override
        public String toString() {
          switch(this) {
            case BIANCO: return "BIANCO";
            case NERO: return "NERO";
            default: throw new IllegalArgumentException();
          }
        }
    };
    
    public Casella[][] scacchiera;
    private int i,j;
    
    //Costruttore
    public Scacchiera() { 
        super();
        this.setSize(600,625);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowListener() {

            @Override
            public void windowClosing(WindowEvent we) {
                if(JOptionPane.showConfirmDialog(we.getWindow(), "Sei sicuro di voler uscire") == JOptionPane.OK_OPTION){
                    setVisible(false);
                    dispose();
                    GameLogic.ReimpostaPartita();
                    MainFrame.Menu.setVisible(true);
                }
            }
            
            @Override 
            public void windowOpened(WindowEvent we) { }

            @Override
            public void windowClosed(WindowEvent we) { }

            @Override
            public void windowIconified(WindowEvent we) { }

            @Override
            public void windowDeiconified(WindowEvent we) { }

            @Override
            public void windowActivated(WindowEvent we) { }

            @Override
            public void windowDeactivated(WindowEvent we) { }
        });
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        setVisible(false);
        
        this.scacchiera = new Casella[8][8];
        
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                Casella CasellaBianca = new Casella(Colori.BIANCO);
                Casella CasellaNera = new Casella(Colori.NERO);
                
                if((j%2==0 && i%2!=0) || (j%2!=0 && i%2==0)) {
                    //CasellaBianca.setText(i +","+ j);
                    this.scacchiera[i][j] = CasellaBianca;
                } else {
                    //CasellaNera.setText(i +","+ j);
                    this.scacchiera[i][j] = CasellaNera;
                }
                
                this.scacchiera[i][j].setCoordinate(j,i);
                this.scacchiera[i][j].setActionCommand(i+","+j);
                this.scacchiera[i][j].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        int Casella_riga = Character.getNumericValue(ae.getActionCommand().charAt(2));
                        int Casella_colonna = Character.getNumericValue(ae.getActionCommand().charAt(0));
                        try {
                        //Controlli Pedina
                        //Controllo per la mossa
                        GameLogic.ifPedinaCanMove(scacchiera[Casella_colonna][Casella_riga]);
                        //controllo per la mangiata
                        GameLogic.ifPedinaCanEat(scacchiera[Casella_colonna][Casella_riga]);

                        //Controlli Dama
                        //Controllo per la mossa
                        GameLogic.ifDamaCanMove(scacchiera[Casella_colonna][Casella_riga]);
                        //controllo per la mangiata
                        GameLogic.ifDamaCanEat(scacchiera[Casella_colonna][Casella_riga]);

                        } catch (MossaNonValidaException ex ){
                            
                        } catch (MossaEffettuataException ex ){ }
                        
                    }
                });
                this.scacchiera[i][j].setBounds(i*70+20, j*70+20, 70, 70);
                this.scacchiera[i][j].setContentAreaFilled(false);
                this.add(this.scacchiera[i][j]);
            }
        }
        //TODO metodo Move(Pedina, [i][j])
        //decide se posso spostare, se è una mossa vincente, se trasforma una dama, cambia turno
        
        Background background = new Background("/Images/ChessBoard.png");
        this.add(background);
        }
    
    public void initScacchiera(Giocatore pGiocatore1, Giocatore pGiocatore2){
        //pedine bianche
        int pb=0;
        for (i = 0; i < 8; i++) {
            for (j = 7; j > 4; j--) {
                if(pb<12){
                    if (isCasellaNera(this.scacchiera[i][j])==true){
                            this.scacchiera[i][j].setPedina(pGiocatore1.Pedine[pb]);
                            //this.scacchiera[i][j].setIcon(pGiocatore1.Pedine[pb].getColore(pGiocatore1.getPedina().getColore()));
                            pb++;
                    }
                }
            }
        }
        
        
        //pedine nere
        int pn=0;
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 3; j++) {
                if(pn<12){
                    if (isCasellaNera(this.scacchiera[i][j])==true){
                            this.scacchiera[i][j].setPedina(pGiocatore2.Pedine[pn]);
                            //this.scacchiera[i][j].setIcon(pGiocatore2.Pedine[pn].getColore(pGiocatore2.getPedina().getColore()));
                            pn++;
                    }
                }
            }
        }
        
    }
    
    public boolean isCasellaNera(Casella pCasella){
        return pCasella.getColore().equals(Scacchiera.Colori.NERO);
    }
    
    public void Set_Visible(boolean pSet){
        setVisible(pSet);
    }
    
}