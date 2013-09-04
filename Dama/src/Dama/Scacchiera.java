package Dama;

import javax.swing.JFrame;

public class Scacchiera extends JFrame{ 
    public static enum Colori {BIANCO, NERO};
    
    public Casella[][] scacchiera;
    private int i;
    private int j;

    //Costruttore
    public Scacchiera() { 
        super();
        this.setSize(600,625);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        setVisible(false);
        
        this.scacchiera = new Casella[8][8];
        
        for (i = 0; i < 8; i++) {
            for (j = 0; j < 8; j++) {
                Casella nuovaCasella;
                if((j%2==0 && i%2!=0) || (j%2!=0 && i%2==0)) {
                    nuovaCasella = new Casella(Colori.BIANCO);
                } else {
                    nuovaCasella = new Casella(Colori.NERO);
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
        //pedine bianche
        int pb=0;
        for (i = 0; i < 8; i++) {
            for (j = 7; j > 4; j--) {
                if(pb<12){
                    if (isCasellaNera(this.scacchiera[i][j])==true){
                            this.scacchiera[i][j].setPedina(pGiocatore1.Pedine[pb]);
                            this.scacchiera[i][j].setIcon(pGiocatore1.Pedine[pb].getColore(pGiocatore1.getPedina().getColore()));
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
                            this.scacchiera[i][j].setIcon(pGiocatore2.Pedine[pn].getColore(pGiocatore2.getPedina().getColore()));
                            pn++;
                    }
                }
            }
        }
        
    }
    
    public boolean isCasellaNera(Casella pCasella){
        if (pCasella.getColore().equals(Scacchiera.Colori.NERO)){
            return true;
        } else {
            return false;
        }
    }
    
        
    public void Set_Visible(boolean pSet){
        setVisible(pSet);
    }
}