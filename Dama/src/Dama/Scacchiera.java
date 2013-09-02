package Dama;

public class Scacchiera { 
    public enum Colori {BIANCO, NERO};

    public Casella[][] scacchiera;
    public int i = 0;
    public int j = 0;

    //Costruttore
    public Scacchiera() { 
        this.scacchiera = new Casella[8][8];
        
        for (i = 0; i < 7; i++) {
            for (j = 0; j < 7; j++) {
                Casella nuovaCasella = new Casella(Colori.BIANCO);
                this.scacchiera[i][j] = nuovaCasella;
            }
        }
        
        //TODO metodo Move(Pedina, [i][j])
        //decide se posso spostare, se è una mossa vincente, se trasforma una dama, cambia turno
        
        //Genera in modo alternato caselle bianche e nere
        }
        
}