/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Dama;

import javax.swing.JButton;

/**
 *
 * @author Francesca
 */
public class Casella extends JButton{
    
    private Dama.Scacchiera.Colori colore;
    private Pedina pedina;
    
    public Casella(Dama.Scacchiera.Colori pColore) {
        super();
        this.colore = pColore;
        this.pedina = new Pedina(Pedina.Colori.NULL);
    }

    public Dama.Scacchiera.Colori getColore() {
        return colore;
    }

    public void setColore(Dama.Scacchiera.Colori colore) {
        this.colore = colore;
    }

    public Pedina getPedina() {
        return this.pedina;
    }

    public void setPedina(Pedina pPedina) {
        this.pedina = pPedina;
    }
}
