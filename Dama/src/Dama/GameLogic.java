package Dama;

public class GameLogic {
    
    private static Scacchiera Board;

    private Giocatore player1;
    private Giocatore player2;

    private Giocatore activePlayer;
    
    private static Casella Casellaswap;
    
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
    
    public void swapCasella(Casella pCasella){
        Casellaswap = pCasella;
    }
    
    public Casella getCasellaswap(){
        return Casellaswap;
    }
    
    public static void ifPedinaCanMove(Casella pCasellaSelect, Casella pCasellaSuccessiva){
        if(!pCasellaSelect.getPedina().equals(Pedina.Colori.NULL) && 
           (pCasellaSuccessiva.getPedina().equals(Pedina.Colori.NULL) || Board.isCasellaNera(pCasellaSuccessiva)) ){
                if(pCasellaSuccessiva.getRiga()>pCasellaSelect.getRiga()){
                    pCasellaSuccessiva.setPedina(pCasellaSelect.getPedina());
                    pCasellaSelect.setPedina(new Pedina(Pedina.Colori.NULL));
                } else { }
        } else { }
    }
    
    
    public void setGameBoardVisible(boolean pset){
        Board.Set_Visible(pset);
    }
    
}
