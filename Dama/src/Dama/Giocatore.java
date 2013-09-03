package Dama;

public class Giocatore {
    
    public Pedina Pedine[];
    
    public Giocatore(Pedina.Colori pColore){
        this.Pedine = new Pedina[12];
        for (int i=0; i<12; i++){
            this.Pedine[i] = new Pedina(pColore);
        }
    }
    
    public Pedina getPedina(){
        return this.Pedine[0];
    }
    
    
    //TODO metodo +PuoiSpostare():Boolean;
    //TODO metodo +Move(Pedina, Casella): Void;
    //TODO metodo +DoveSiTrova():Casella;
    
}
