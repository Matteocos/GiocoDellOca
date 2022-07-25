package school.devskill.GiocoDellOca.web.Interface;

import school.devskill.GiocoDellOca.eccezioni.GiocoInCorsoException;
import school.devskill.GiocoDellOca.web.command.InfoGiocatore;

public interface IGiocoController  {
    String aggiungiGiocatore(InfoGiocatore i) throws GiocoInCorsoException;
    String reset();
    String statoPartita();
    String giocaTurno();
}
