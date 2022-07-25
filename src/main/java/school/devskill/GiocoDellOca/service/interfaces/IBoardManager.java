package school.devskill.GiocoDellOca.service.interfaces;


import school.devskill.GiocoDellOca.ElementiDiGioco.Player;

import school.devskill.GiocoDellOca.eccezioni.GiocoInCorsoException;
import school.devskill.GiocoDellOca.eccezioni.NoPlayersException;


public interface IBoardManager {




     void aggiungiGiocatore(Player p) throws GiocoInCorsoException ;


    void Reset() throws NoPlayersException;
  String giocaTurno() throws NoPlayersException;

    String statoPartita();
}








