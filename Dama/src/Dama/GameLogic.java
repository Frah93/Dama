package Dama;

public class GameLogic {
    
    public static Scacchiera Board;

    private Giocatore player1;
    private Giocatore player2;

    private Giocatore activePlayer;
    
    public static Casella Casellaswap;
    
    public GameLogic(Giocatore pPlayer1, Giocatore pPlayer2) {
        this.player1 = pPlayer1;
        this.player2 = pPlayer2;
        
        //definiamo la scacchiera e disponiamo le pedine dei due giocatori
        Board = new Scacchiera();
        Board.initScacchiera(player1,player2);
        
        this.Casellaswap = new Casella(Scacchiera.Colori.BIANCO);
        /*try {
            this.PianoDiGioco = new Scacchiera(8, 8);
        } catch (Exception ex) {
            // NON SI VERIFICANO
        } catch (Exception ex) {
        }
        
        this.activePlayer = this.player1;
    }
    
    public Giocatore getActivePlayer() {
        return this.activePlayer;*/
    }
    //Verifica quali mosse sono ammissibili
    //TODO: La gestione del colore sara' gestita dal player active
    public static void ifPedinaCanMove(Casella pCasellaSelect){
        if(!pCasellaSelect.getPedina().getColore().equals(Pedina.Colori.NULL)){
            //Se ho selezionato una pedina nera
            if(pCasellaSelect.getPedina().getColore().equals(Pedina.Colori.NERO)){
                //Controlla se ho selezionato l'ultima pedina a sinistra
                if(pCasellaSelect.getColonna()==0){
                    if(Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()+1].getPedina().getColore().equals(Pedina.Colori.NULL)){
                        Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()+1].setContentAreaFilled(true);
                    }
                //Controlla se ho selezionato l'ultima pedina a destra
                } else if(Board.scacchiera[0].length-1==pCasellaSelect.getColonna()){
                    if(Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()+1].getPedina().getColore().equals(Pedina.Colori.NULL)){
                        Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()+1].setContentAreaFilled(true);
                    }
                } else {
                    if(Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()+1].getPedina().getColore().equals(Pedina.Colori.NULL)){
                        Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()+1].setContentAreaFilled(true);
                    }
                    if(Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()+1].getPedina().getColore().equals(Pedina.Colori.NULL)){
                            Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()+1].setContentAreaFilled(true);
                    }
            }
            //Se ho selezionato una pedina bianca
            } else if(pCasellaSelect.getPedina().getColore().equals(Pedina.Colori.BIANCO)){
                //Controlla se ho selezionato l'ultima pedina a sinistra
                if(pCasellaSelect.getColonna()==0){
                    if(Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()-1].getPedina().getColore().equals(Pedina.Colori.NULL)){
                        Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()-1].setContentAreaFilled(true);
                    }
                //Controlla se ho selezionato l'ultima pedina a destra
                } else if(Board.scacchiera[0].length-1==pCasellaSelect.getColonna()){
                    if(Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()-1].getPedina().getColore().equals(Pedina.Colori.NULL)){
                        Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()-1].setContentAreaFilled(true);
                    }
                } else {
                    if(Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()-1].getPedina().getColore().equals(Pedina.Colori.NULL)){
                        Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()-1].setContentAreaFilled(true);
                    }
                    if(Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()-1].getPedina().getColore().equals(Pedina.Colori.NULL)){
                        Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()-1].setContentAreaFilled(true);
                    }
                }
            }
        }
    }
    
    
    public void setGameBoardVisible(boolean pset){
        Board.Set_Visible(pset);
    }
    
}
