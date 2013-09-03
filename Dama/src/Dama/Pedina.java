package Dama;

import javax.swing.ImageIcon;

public class Pedina {
    public static enum Colori {BIANCO,NERO,NULL};
    
    private Colori colore;
    public Pedina(Colori pColore) {
        this.colore = pColore;
    }

    public Colori getColore() {
        return this.colore;
    }
    
    public ImageIcon getColore(Colori pColore) {
        if (pColore== Colori.BIANCO){
            return new ImageIcon(getClass().getResource("/Images/pedina_bianca.png"));
        }else if (pColore== Colori.NERO){
            return new ImageIcon(getClass().getResource("/Images/pedina_nera.png"));
        } else {
            return new ImageIcon(getClass().getResource("/Images/pedina_vuota.png"));
        }
    }
    
}
