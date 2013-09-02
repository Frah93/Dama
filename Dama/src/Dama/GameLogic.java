package Dama;

public class GameLogic {
    
   private Giocatore player1;
   private Giocatore player2;
   private Scacchiera PianoDiGioco;
   
   private Giocatore activePlayer;
    
    public GameLogic(Giocatore pPlayer1, Giocatore pPlayer2) {
        this.player1 = pPlayer1;
        this.player2 = pPlayer2;
        
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
    
}
