package school.devskill.GiocoDellOca.eccezioni;

public class GiocoInCorsoException extends Exception {
public GiocoInCorsoException(){
    super("Azione non permessa mentre il gioco è in esecuzione");

}
}
