package Dama;

public class Giocatore {
    
    public Pedina Pedine[];
    public Dama Dame[];
    
    public Giocatore(Pedina.Colori pColore){
        this.Pedine = new Pedina[12];
        this.Dame = new Dama[12];
        for (int i=0; i<12; i++){
            this.Pedine[i] = new Pedina(pColore);
            this.Dame[i] = new Dama(pColore);
        }
    }
    
    public Pedina getPedina(){
        return this.Pedine[0];
    }
    
    public Dama getDama(){
        return this.Dame[0];
    }
    
    //TODO metodo +PuoiSpostare():Boolean;
    //TODO metodo +Move(Pedina, Casella): Void;
    //TODO metodo +DoveSiTrova():Casella;
    
}
