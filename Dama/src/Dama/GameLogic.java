package Dama;

public class GameLogic {
    
    public static Scacchiera Board;

    private Giocatore player1;
    private Giocatore player2;

    private Giocatore activePlayer;
    
    public GameLogic(Giocatore pPlayer1, Giocatore pPlayer2) {
        this.player1 = pPlayer1;
        this.player2 = pPlayer2;
        
        //definiamo la scacchiera e disponiamo le pedine dei due giocatori
        Board = new Scacchiera();
        Board.initScacchiera(player1,player2);
        
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
    
    public void setGameBoardVisible(boolean pset){
        Board.Set_Visible(pset);
    }
    
}
