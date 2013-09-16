package Dama;

import util.*;
import javax.swing.*;

public class Regole extends JFrame{
    
    private JLabel regole,dama;
    private Icon dama_image;
    
    public Regole(){
        super();
        setTitle("Regole");
        setSize(590, 700);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(false);
        
        this.dama_image = new ImageIcon(Resources.getImage("/Images/Dama_con_liocorno.jpg"));
	this.dama = new JLabel( this.dama_image );
        this.dama.setSize(this.getSize());
        
        this.regole = new JLabel("<html>Dama italiana <br/>" +
        "Le 10 regole per giocare <br/>" +
        "    La damiera si compone di 64 caselle alternate per colore, bianche e scure, e va posizionata con l'ultima casella in basso a destra di colore nero.<br/>" +
        "    Ciascun giocatore dispone all'inizio di 12 pedine, di colore diverso da quelle dell'avversario (bianche o nere), collocate sulle prime tre righe di caselle scure poste sul proprio lato della damiera. Il nero occupa le caselle dal n. 1 al n. 12, il bianco quelle dal n. 21 al n. 32. La scelta del colore fra i giocatori si effettua per sorteggio.<br/>" +
        "    Inizia a giocare sempre il bianco.<br/>" +
        "    La pedina si muove sempre in diagonale sulle caselle scure di una casella alla volta e soltanto in avanti. Quando una pedina raggiunge una delle caselle dell'ultima riga viene promossa, diventa dama e deve essere contraddistinta con la sovrapposizione di un'altra pedina prelevata tra quelle non in gioco.<br/>" +
        "    Ogni pedina puo' mangiare quelle avversarie che si trovano in avanti, sulla casella diagonale accanto alla propria e che abbiano la casella successiva libera. Dopo la presa, se incontrano in diagonale altre pedine con la successiva casella libera, si deve continuare a mangiare senza togliere la mano dalla pedina stessa. In tal caso la presa si chiama multipla. Le pedine prese vanno tolte dalla damiera.<br/>" +
        "    La dama si muove anch'essa di una casella alla volta, sempre in diagonale, in tutte le direzioni possibili, mangiando sia le pedine che le dame avversarie.<br/>" +
        "    In caso di presa e' obbligatorio mangiare i pezzi. L'antica regola del \"soffio\", ossia quella di catturare il pezzo avversario che pur avendone diritto, per distrazione o per scelta non aveva mangiato, e' stata abolita dalla Federazione Dama nel 1934.<br/>" +
        "    Avendo piu' possibilita'  di presa si debbono rispettare obbligatoriamente nell'ordine le seguenti priorita' :<br/>" +
        "        e' obbligatorio mangiare dove ci sono piu' pezzi;<br/>" +
        "        a parita'  di pezzi di presa tra pedina e dama, quest'ultima e' obbligata a mangiare;<br/>" +
        "        la dama sceglie la presa dove si mangiano piu' dame;<br/>" +
        "        a parita'  di condizioni si mangia dove s'incontra prima la dama avversaria.<br/>" +
        "    \"Pezzo toccato = Pezzo mosso\": il giocatore che, nel proprio turno di gioco, tocca un proprio pezzo sulla damiera e' obbligato a muoverlo.<br/>" +
        "    Se si vuole aggiustare un pezzo messo male sulla damiera bisogna prima avvertire l'avversario dichiarando \"accomodo\" o \"acconcio\" e attendere l'assenso dell'avversario.<br/>" +
        "    Si vince per abbandono dell'avversario, che si trova in palese difficolta' , o quando si catturano o si bloccano tutti i pezzi avversari.<br/>" +
        "    Si pareggia in una situazione di evidente equilibrio finale per accordo dei giocatori o per decisione dell'arbitro a seguito del conteggio di 40 mosse richiesto da uno dei due giocatori. Il conteggio delle mosse si azzera e riparte da capo tutte le volte che uno dei due giocatori muove una pedina o effettua una presa.</html>");

        this.regole.setBounds(10,0,590,700);
        
        add(this.regole);
        add(this.dama);
        
    }
    
    public void Set_Visible(boolean pSet){
        setVisible(pSet);
    }
    
}
