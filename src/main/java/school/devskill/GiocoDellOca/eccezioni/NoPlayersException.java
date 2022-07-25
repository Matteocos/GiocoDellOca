package school.devskill.GiocoDellOca.eccezioni;

public  class NoPlayersException extends Exception {
    public NoPlayersException(){
        super("non ci sono players nella partita");
    }
}
