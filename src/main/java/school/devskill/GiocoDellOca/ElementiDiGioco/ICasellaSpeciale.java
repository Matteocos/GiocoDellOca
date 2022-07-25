package school.devskill.GiocoDellOca.ElementiDiGioco;

import school.devskill.GiocoDellOca.eccezioni.AzioneNonPermessaException;

public interface ICasellaSpeciale {

    int calcolaPosizione(int posizioneGiocatore) throws AzioneNonPermessaException;
}
