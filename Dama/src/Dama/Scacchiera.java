package Dama;

import java.awt.GridLayout;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Scacchiera extends JFrame{ 
    public enum Colori {BIANCO, NERO};

    public Casella[][] scacchiera;
    public int i = 0;
    public int j = 0;

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
                Casella nuovaCasella = new Casella(Colori.BIANCO);
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
        
    public void Set_Visible(boolean pSet){
        setVisible(pSet);
    }
}