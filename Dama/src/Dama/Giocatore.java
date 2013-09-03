package Dama;

public class Giocatore {
    
    private Pedina Pedine[];
    
    public Giocatore(Pedina.Colori pColore){
        this.Pedine = new Pedina[12];
        for (int i=0; i<12; i++){
            this.Pedine[i] = new Pedina(pColore);
        }
    }
    
    //TODO metodo +PuoiSpostare():Boolean;
    //TODO metodo +Move(Pedina, Casella): Void;
    //TODO metodo +DoveSiTrova():Casella;
    
}
