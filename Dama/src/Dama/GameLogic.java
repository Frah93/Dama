package Dama;

public class GameLogic {
    
    public static Scacchiera Board;

    private Giocatore player1;
    private Giocatore player2;

    private Giocatore activePlayer;
    
    private static Casella Casellaorigin,Casellatarget,Casellaswap1,Casellaswap2;
    
    public GameLogic(Giocatore pPlayer1, Giocatore pPlayer2) {
        this.player1 = pPlayer1;
        this.player2 = pPlayer2;
        
        //definiamo la scacchiera e disponiamo le pedine dei due giocatori
        Board = new Scacchiera();
        Board.initScacchiera(player1,player2);
        
        //inizia giocatore 1 con i bianchi
        this.activePlayer = this.player1;
        
        Casellaorigin = new Casella(Scacchiera.Colori.NERO);
        Casellatarget = new Casella(Scacchiera.Colori.NERO);
        Casellaswap1 = new Casella(Scacchiera.Colori.NERO);
        Casellaswap2 = new Casella(Scacchiera.Colori.NERO);
        
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
    //Verifica quali mosse sono ammissibili nel movimento di una pedina
    //TODO: La gestione del colore sara' gestita dal player active
    public static void ifPedinaCanMove(Casella pCasellaSelect){
        //nel caso in cui premo una casella con pedina nera/bianca
        if(!pCasellaSelect.getPedina().getColore().equals(Pedina.Colori.NULL)){
            //Se ho selezionato una pedina nera
            if(pCasellaSelect.getPedina().getColore().equals(Pedina.Colori.NERO)){
                //Controlla se ho selezionato l'ultima pedina a sinistra
                if(pCasellaSelect.getColonna()==0){
                    if(Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()+1].getPedina().getColore().equals(Pedina.Colori.NULL)){
                        //evidenzia le mosse ammissibili
                        Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()+1].setContentAreaFilled(true);
                            //oltre ad evidenziarla deve salvarla in memoria per poter accertare la previsione di una possibile mossa
                            Casellaorigin = pCasellaSelect;
                            Casellaswap1 = Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()+1];
                    }
                //Controlla se ho selezionato l'ultima pedina a destra
                } else if(Board.scacchiera[0].length-1==pCasellaSelect.getColonna()){
                    if(Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()+1].getPedina().getColore().equals(Pedina.Colori.NULL)){
                        Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()+1].setContentAreaFilled(true);
                            Casellaorigin = pCasellaSelect;
                            Casellaswap1 = Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()+1];
                    }
                } else {
                    if(Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()+1].getPedina().getColore().equals(Pedina.Colori.NULL)){
                        Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()+1].setContentAreaFilled(true);
                            Casellaorigin = pCasellaSelect;
                            Casellaswap1 = Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()+1];
                        
                    }
                    if(Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()+1].getPedina().getColore().equals(Pedina.Colori.NULL)){
                        Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()+1].setContentAreaFilled(true);
                            Casellaorigin = pCasellaSelect;
                            Casellaswap2 = Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()+1];
                    }
            }
            //Se ho selezionato una pedina bianca
            } else if(pCasellaSelect.getPedina().getColore().equals(Pedina.Colori.BIANCO)){
                //Controlla se ho selezionato l'ultima pedina a sinistra
                if(pCasellaSelect.getColonna()==0){
                    if(Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()-1].getPedina().getColore().equals(Pedina.Colori.NULL)){
                        Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()-1].setContentAreaFilled(true);
                            Casellaorigin = pCasellaSelect;
                            Casellaswap1 = Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()-1];
                    }
                //Controlla se ho selezionato l'ultima pedina a destra
                } else if(Board.scacchiera[0].length-1==pCasellaSelect.getColonna()){
                    if(Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()-1].getPedina().getColore().equals(Pedina.Colori.NULL)){
                        Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()-1].setContentAreaFilled(true);
                            Casellaorigin = pCasellaSelect;
                            Casellaswap1 = Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()-1];
                    }
                } else {
                    if(Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()-1].getPedina().getColore().equals(Pedina.Colori.NULL)){
                        Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()-1].setContentAreaFilled(true);
                            Casellaorigin = pCasellaSelect;
                            Casellaswap1 = Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()-1];
                    }
                    if(Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()-1].getPedina().getColore().equals(Pedina.Colori.NULL)){
                        Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()-1].setContentAreaFilled(true);
                            Casellaorigin = pCasellaSelect;
                            Casellaswap2 = Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()-1];
                    }
                }
            }
        } else {
            //nel caso in cui sto schiacciando una casella che ho previsto per lo spostamento DI UNA CASELLA
            if(pCasellaSelect.getPedina().equals(Casellaswap1.getPedina())){
                //sposto la pedina nella casella successiva
                Board.scacchiera[Casellaswap1.getColonna()][Casellaswap1.getRiga()].
                        setPedina(Board.scacchiera[Casellaorigin.getColonna()][Casellaorigin.getRiga()].getPedina());
                //cancella la precedente
                Board.scacchiera[Casellaorigin.getColonna()][Casellaorigin.getRiga()].
                        setPedina(new Pedina(Pedina.Colori.NULL));
                //deseleziona l'altra possibilita' di movimento
                Board.scacchiera[Casellaswap2.getColonna()][Casellaswap2.getRiga()].setContentAreaFilled(false);
                
            } else if (pCasellaSelect.getPedina().equals(Casellaswap2.getPedina())){
                //sposto la pedina nella casella successiva
                Board.scacchiera[Casellaswap2.getColonna()][Casellaswap2.getRiga()].
                        setPedina(Board.scacchiera[Casellaorigin.getColonna()][Casellaorigin.getRiga()].getPedina());
                
                //cancella la precedente
                Board.scacchiera[Casellaorigin.getColonna()][Casellaorigin.getRiga()].
                        setPedina(new Pedina(Pedina.Colori.NULL));
                //deseleziona l'altra possibilita' di movimento
                Board.scacchiera[Casellaswap1.getColonna()][Casellaswap1.getRiga()].setContentAreaFilled(false);
            }
        }
    }
    //Controllo se si puo' mangiare
    //ToDo: la scelta del colore avverra' in base al giocatore ed al suo avversario (molto molto meno codice)
    public static void ifPedinaCanEat(Casella pCasellaSelect){
        //nel caso in cui premo una casella con pedina nera/bianca
        if(!pCasellaSelect.getPedina().getColore().equals(Pedina.Colori.NULL)){
            //Se ho selezionato una pedina nera
            if(pCasellaSelect.getPedina().getColore().equals(Pedina.Colori.NERO)){
                //Controlla se ho selezionato l'ultima pedina a sinistra
                if(pCasellaSelect.getColonna()==1){
                    //Controllo una possibile mangiata
                    if(Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()+1].getPedina().getColore().equals(Pedina.Colori.BIANCO) &&
                        Board.scacchiera[pCasellaSelect.getColonna()+2][pCasellaSelect.getRiga()+2].getPedina().getColore().equals(Pedina.Colori.NULL) ){
                            Board.scacchiera[pCasellaSelect.getColonna()+2][pCasellaSelect.getRiga()+2].setContentAreaFilled(true);
                                Casellaorigin = pCasellaSelect;
                                Casellatarget = Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()+1];
                                Casellaswap1 = Board.scacchiera[pCasellaSelect.getColonna()+2][pCasellaSelect.getRiga()+2];
                    }
                //Controlla se ho selezionato l'ultima pedina a destra
                }else if(Board.scacchiera[0].length-2==pCasellaSelect.getColonna()){
                    //Controllo una possibile mangiata
                    if(Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()+1].getPedina().getColore().equals(Pedina.Colori.BIANCO) &&
                        Board.scacchiera[pCasellaSelect.getColonna()-2][pCasellaSelect.getRiga()+2].getPedina().getColore().equals(Pedina.Colori.NULL) ){
                            Board.scacchiera[pCasellaSelect.getColonna()-2][pCasellaSelect.getRiga()+2].setContentAreaFilled(true);
                                Casellaorigin = pCasellaSelect;
                                Casellatarget = Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()+1];
                                Casellaswap1 = Board.scacchiera[pCasellaSelect.getColonna()-2][pCasellaSelect.getRiga()+2];
                    }
                } else {
                    //Controllo una possibile mangiata
                    if(Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()+1].getPedina().getColore().equals(Pedina.Colori.BIANCO) &&
                        Board.scacchiera[pCasellaSelect.getColonna()+2][pCasellaSelect.getRiga()+2].getPedina().getColore().equals(Pedina.Colori.NULL) ){
                            Board.scacchiera[pCasellaSelect.getColonna()+2][pCasellaSelect.getRiga()+2].setContentAreaFilled(true);
                                Casellaorigin = pCasellaSelect;
                                Casellatarget = Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()+1];
                                Casellaswap1 = Board.scacchiera[pCasellaSelect.getColonna()+2][pCasellaSelect.getRiga()+2];
                    }
                    //Controllo una possibile mangiata
                    if(Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()+1].getPedina().getColore().equals(Pedina.Colori.BIANCO) &&
                        Board.scacchiera[pCasellaSelect.getColonna()-2][pCasellaSelect.getRiga()+2].getPedina().getColore().equals(Pedina.Colori.NULL) ){
                            Board.scacchiera[pCasellaSelect.getColonna()-2][pCasellaSelect.getRiga()+2].setContentAreaFilled(true);
                                Casellaorigin = pCasellaSelect;
                                Casellatarget = Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()+1];
                                Casellaswap2 = Board.scacchiera[pCasellaSelect.getColonna()-2][pCasellaSelect.getRiga()+2];
                    }
                }
                
            //Se ho selezionato una pedina bianca
            } else if(pCasellaSelect.getPedina().getColore().equals(Pedina.Colori.BIANCO)){
                //Controlla se ho selezionato l'ultima o la penultima pedina a sinistra
                if(pCasellaSelect.getColonna()==1 || pCasellaSelect.getColonna()==0){
                    //Controllo una possibile mangiata
                    if(Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()-1].getPedina().getColore().equals(Pedina.Colori.NERO) &&
                        Board.scacchiera[pCasellaSelect.getColonna()+2][pCasellaSelect.getRiga()-2].getPedina().getColore().equals(Pedina.Colori.NULL) ){
                            Board.scacchiera[pCasellaSelect.getColonna()+2][pCasellaSelect.getRiga()-2].setContentAreaFilled(true);
                                Casellaorigin = pCasellaSelect;
                                Casellaswap1 = Board.scacchiera[pCasellaSelect.getColonna()+2][pCasellaSelect.getRiga()-2];
                    }
                //Controlla se ho selezionato l'ultima o la penultima pedina a destra
                }else if(Board.scacchiera[0].length-2==pCasellaSelect.getColonna() || Board.scacchiera[0].length-1==pCasellaSelect.getColonna()){
                    //Controllo una possibile mangiata
                    if(Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()-1].getPedina().getColore().equals(Pedina.Colori.NERO) &&
                        Board.scacchiera[pCasellaSelect.getColonna()-2][pCasellaSelect.getRiga()-2].getPedina().getColore().equals(Pedina.Colori.NULL) ){
                            Board.scacchiera[pCasellaSelect.getColonna()-2][pCasellaSelect.getRiga()-2].setContentAreaFilled(true);
                                Casellaorigin = pCasellaSelect;
                                Casellaswap1 = Board.scacchiera[pCasellaSelect.getColonna()-2][pCasellaSelect.getRiga()-2];
                    }
                } else {
                    //Controllo una possibile mangiata
                    if(Board.scacchiera[pCasellaSelect.getColonna()+1][pCasellaSelect.getRiga()-1].getPedina().getColore().equals(Pedina.Colori.NERO) &&
                        Board.scacchiera[pCasellaSelect.getColonna()+2][pCasellaSelect.getRiga()-2].getPedina().getColore().equals(Pedina.Colori.NULL) ){
                            Board.scacchiera[pCasellaSelect.getColonna()+2][pCasellaSelect.getRiga()-2].setContentAreaFilled(true);
                                Casellaorigin = pCasellaSelect;
                                Casellaswap1 = Board.scacchiera[pCasellaSelect.getColonna()+2][pCasellaSelect.getRiga()-2];
                    }
                    //Controllo una possibile mangiata
                    if(Board.scacchiera[pCasellaSelect.getColonna()-1][pCasellaSelect.getRiga()-1].getPedina().getColore().equals(Pedina.Colori.NERO) &&
                        Board.scacchiera[pCasellaSelect.getColonna()-2][pCasellaSelect.getRiga()-2].getPedina().getColore().equals(Pedina.Colori.NULL) ){
                            Board.scacchiera[pCasellaSelect.getColonna()-2][pCasellaSelect.getRiga()-2].setContentAreaFilled(true);
                                Casellaorigin = pCasellaSelect;
                                Casellaswap2 = Board.scacchiera[pCasellaSelect.getColonna()-2][pCasellaSelect.getRiga()-2];
                    }
                }
            }
        } else {
            //nel caso in cui sto schiacciando una casella che ho previsto per lo spostamento e la mangiata
            if(pCasellaSelect.getPedina().equals(Casellaswap1.getPedina()) && 
                    (Casellaorigin.getRiga()+2==Casellaswap1.getRiga() || Casellaorigin.getRiga()-2==Casellaswap1.getRiga()) ){
                //sposto la pedina nella casella successiva
                Board.scacchiera[Casellaswap1.getColonna()][Casellaswap1.getRiga()].
                        setPedina(Board.scacchiera[Casellaorigin.getColonna()][Casellaorigin.getRiga()].getPedina());
                //cancella la precedente
                Board.scacchiera[Casellaorigin.getColonna()][Casellaorigin.getRiga()].
                        setPedina(new Pedina(Pedina.Colori.NULL));
                //Cancella la pedina mangiata
                Board.scacchiera[Casellatarget.getColonna()][Casellatarget.getRiga()].
                        setPedina(new Pedina(Pedina.Colori.NULL));
                Casellatarget = new Casella(Scacchiera.Colori.NERO);
                //deseleziona l'altra possibilita' di movimento
                Board.scacchiera[Casellaswap2.getColonna()][Casellaswap2.getRiga()].setContentAreaFilled(false);
                
            } else if (pCasellaSelect.getPedina().equals(Casellaswap2.getPedina()) && 
                    (Casellaorigin.getRiga()+2==Casellaswap2.getRiga() || Casellaorigin.getRiga()-2==Casellaswap2.getRiga())){
                //sposto la pedina nella casella successiva
                Board.scacchiera[Casellaswap2.getColonna()][Casellaswap2.getRiga()].
                        setPedina(Board.scacchiera[Casellaorigin.getColonna()][Casellaorigin.getRiga()].getPedina());
                //cancella la precedente
                Board.scacchiera[Casellaorigin.getColonna()][Casellaorigin.getRiga()].
                        setPedina(new Pedina(Pedina.Colori.NULL));
                //Cancella la pedina mangiata
                Board.scacchiera[Casellatarget.getColonna()][Casellatarget.getRiga()].
                        setPedina(new Pedina(Pedina.Colori.NULL));
                Casellatarget = new Casella(Scacchiera.Colori.NERO);
                //deseleziona l'altra possibilita' di movimento
                Board.scacchiera[Casellaswap1.getColonna()][Casellaswap1.getRiga()].setContentAreaFilled(false);
            }
        }
    }
    
    //Funzione che pulisce ogni tipo di suggerimento precedente 
    public static void ClearHint(){
        for (int i=0; i< Board.scacchiera.length;i++){
            for (int j=0; j< Board.scacchiera[0].length;i++){
                Board.scacchiera[i][j].setContentAreaFilled(false);
            }
        }
    }
    public void setGameBoardVisible(boolean pset){
        Board.Set_Visible(pset);
    }
    
}
