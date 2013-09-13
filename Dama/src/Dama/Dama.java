package Dama;

import Dama.Pedina.Colori.*;
import javax.swing.ImageIcon;

public class Dama extends Pedina{
    
    public Dama(Colori pColore) {
        super(pColore);
    }

    @Override
    public ImageIcon getImgColore(Colori pColore) {
        if (pColore.equals(Colori.BIANCO)){
            return new ImageIcon(getClass().getResource("/Images/dama_bianca.png"));
        }else if (pColore.equals(Colori.NERO)){
            return new ImageIcon(getClass().getResource("/Images/dama_nera.png"));
        } else {
            return super.getImgColore(pColore);
        }
    }
    
    
    
}
