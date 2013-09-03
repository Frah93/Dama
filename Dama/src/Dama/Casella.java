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
    
    private Scacchiera.Colori colore;
    private Pedina pedina;
    
    public Casella(Scacchiera.Colori pColore) {
        super();
        this.colore = pColore;
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

    public void setPedina(Pedina pPedina) {
        this.pedina = pPedina;
    }
}
