package Dama;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Scacchiera extends JFrame{ 
    public enum Colori {BIANCO, NERO};
    
    private Casella[][] scacchiera;
    private int i = 0;
    private int j = 0;

    //Costruttore
    public Scacchiera() { 
        super();
        this.setSize(600,625);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        
        this.scacchiera = new Casella[8][8];
        
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                Casella nuovaCasella;
                if((j%2==0 && i%2!=0) || (j%2!=0 && i%2==0)) {
                    nuovaCasella = new Casella(Scacchiera.Colori.BIANCO);
                } else {
                    nuovaCasella = new Casella(Scacchiera.Colori.NERO);
                }
                    this.scacchiera[i][j] = nuovaCasella;
                    this.scacchiera[i][j].setBounds(i*70+20, j*70+20, 70, 70);
                    this.scacchiera[i][j].setContentAreaFilled(false);
                    this.add(this.scacchiera[i][j]);
            }
        }
        //TODO metodo Move(Pedina, [i][j])
        //decide se posso spostare, se è una mossa vincente, se trasforma una dama, cambia turno
        
        //Genera in modo alternato caselle bianche e nere
        
        Background background = new Background(true);
        this.add(background);
        }
    
    public void initScacchiera(Giocatore pGiocatore1, Giocatore pGiocatore2){
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 4; j++) {
                if (isCasellaNera(this.scacchiera[i][j])==true)
                    for (int p=0; p < 12; p++) {
                        this.scacchiera[i][j].setPedina(pGiocatore1.Pedine[p]);
                        this.scacchiera[i][j].setIcon(pGiocatore1.Pedine[p].getColore(pGiocatore1.getPedina().getColore()));
                    }
            }
        }
        
        for (i = 8; i < 0; i++) {
            for (j = 0; j < 4; j++) {
                if (isCasellaNera(this.scacchiera[i][j])==true)
                    for (int p=0; p < 12; p++) {
                        this.scacchiera[i][j].setPedina(pGiocatore2.Pedine[p]);
                        this.scacchiera[i][j].setIcon(pGiocatore1.Pedine[p].getColore(pGiocatore1.getPedina().getColore()));
                    }
            }
        }
    }
    
    public boolean isCasellaNera(Casella pCasella){
        if (pCasella.equals(Scacchiera.Colori.NERO)){
            return true;
        } else {
            return false;
        }
    }
    
        
    public void Set_Visible(boolean pSet){
        setVisible(pSet);
    }
}