/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dama;

import java.awt.Color;
import java.awt.Transparency;
import javax.swing.JButton;

/**
 *
 * @author Francesca
 */
public class Casella extends JButton{
    
    private Scacchiera.Colori colore;
    private Pedina pedina;
    private Dama dama;
    private int colonna,riga;
    
    public Casella(Scacchiera.Colori pColore) {
        super();
        this.colore = pColore;
        this.pedina = new Pedina(Pedina.Colori.NULL);
        this.dama = new Dama(Pedina.Colori.NULL);
        this.riga = 0;
        this.colonna = 0;
    }

    public Scacchiera.Colori getColore() {
        return colore;
    }

    public void setColore(Scacchiera.Colori colore) {
        this.colore = colore;
    }

    public Pedina getPedina() {
        return this.pedina;
    }
    
    public Dama getDama() {
        return this.dama;
    }
    
    public void setDama(Dama pDama){
        this.pedina = new Pedina(Pedina.Colori.NULL);
        this.dama = pDama;
        setIcon(pDama.getImgColore(pDama.getColore()));
    }

    public void setPedina(Pedina pPedina) {
        this.pedina = pPedina;
        this.dama = new Dama(Dama.Colori.NULL);
        setIcon(pPedina.getImgColore(pPedina.getColore()));
    }
    
    public void setCoordinate(int priga, int pcolonna){
        this.riga = priga;
        this.colonna = pcolonna;
    }

    public int getColonna() {
        return colonna;
    }

    public int getRiga() {
        return riga;
    }    
    
}
