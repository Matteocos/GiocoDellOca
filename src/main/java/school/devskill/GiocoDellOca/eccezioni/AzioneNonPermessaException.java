package school.devskill.GiocoDellOca.eccezioni;

public class AzioneNonPermessaException extends RuntimeException {
    public AzioneNonPermessaException(){
        super("Azione non permessa");
    }
}
