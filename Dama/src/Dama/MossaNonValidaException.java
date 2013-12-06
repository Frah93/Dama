package Dama;

import javax.swing.JOptionPane;

class MossaNonValidaException extends Exception {
    public MossaNonValidaException(){
        JOptionPane.showMessageDialog(null, "Mossa non Valida");
        GameLogic.PulisciScacchiera();
    }
    
    public MossaNonValidaException(String message){
        JOptionPane.showMessageDialog(null, message);
        GameLogic.PulisciScacchiera();
    }
}
