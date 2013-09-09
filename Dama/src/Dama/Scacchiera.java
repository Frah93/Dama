package Dama;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

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
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
                        
                        //Controllo per la mangiata
                        //i Due controlli vanno differanziati
                        GameLogic.ifPedinaCanEat(scacchiera[Character.getNumericValue(ae.getActionCommand().charAt(0))]
                                [Character.getNumericValue(ae.getActionCommand().charAt(2))]);
                        //Controllo per la mossa
                        GameLogic.ifPedinaCanMove(scacchiera[Character.getNumericValue(ae.getActionCommand().charAt(0))]
                                [Character.getNumericValue(ae.getActionCommand().charAt(2))]);
                        
                        //Controllo per la denominazione delle caselle
                        scacchiera[Character.getNumericValue(ae.getActionCommand().charAt(0))]
                                [Character.getNumericValue(ae.getActionCommand().charAt(2))].setContentAreaFilled(false);
                        
                    }
                });
                this.scacchiera[i][j].setBounds(i*70+20, j*70+20, 70, 70);
                this.scacchiera[i][j].setContentAreaFilled(false);
                this.add(this.scacchiera[i][j]);
            }
        }
        //TODO metodo Move(Pedina, [i][j])
        //decide se posso spostare, se è una mossa vincente, se trasforma una dama, cambia turno
        
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
        if (pCasella.getColore().equals(Scacchiera.Colori.NERO)){
            return true;
        } else {
            return false;
        }
    }
    
    public void Set_Visible(boolean pSet){
        setVisible(pSet);
    }
    
    public String toString(){
        return Colori.BIANCO.toString();
    }
}