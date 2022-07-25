package school.devskill.GiocoDellOca.service.classes;

import org.springframework.stereotype.Service;
import school.devskill.GiocoDellOca.ElementiDiGioco.CasellaNumerica;
import school.devskill.GiocoDellOca.ElementiDiGioco.CasellaStop;
import school.devskill.GiocoDellOca.ElementiDiGioco.ICasellaSpeciale;
import school.devskill.GiocoDellOca.ElementiDiGioco.Player;
import school.devskill.GiocoDellOca.eccezioni.AzioneNonPermessaException;
import school.devskill.GiocoDellOca.eccezioni.GiocoInCorsoException;
import school.devskill.GiocoDellOca.eccezioni.GiocoTerminatoException;
import school.devskill.GiocoDellOca.eccezioni.NoPlayersException;
import school.devskill.GiocoDellOca.service.interfaces.IBoardManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service("BoardManager")
public class BoardManagerImpl implements IBoardManager {
    private List<Player> players;
    private  List<ICasellaSpeciale> caselle;
    private final int dimensioneBoard=14;
    private  boolean isOver= false;
    protected  boolean inCorso;


    public BoardManagerImpl() {

        this.players = new ArrayList<>();
        caselle=new ArrayList<>();
       creaBoard();
       inCorso=false;
    }



    public void aggiungiGiocatore(Player p) throws GiocoInCorsoException{
        if(inCorso){
            throw new GiocoInCorsoException();
        }

        players.add(p);
    }
    private int lancioDadi(){
        Random random= new Random();
        int value=0;
        try {
            Thread.sleep(500);

            value=random.nextInt(7-1)+1;
        } catch (InterruptedException e) {
            e.printStackTrace();
            value = random.nextInt(7 - 1) + 1;
        }

        return value;

    }


    public void Reset() throws NoPlayersException {

        if(players== null ||players.size()==0){
            throw  new NoPlayersException();
        }
        isOver= false;
        for(int i=0; i<players.size();i++){
            Player playercorrente = players.get(i);
         playercorrente.setPosizione(0);
         playercorrente.setNLanci(0);
         playercorrente.setStop(false);
        }

    }

    private int aggiornaPosizione(int nuovoValore) throws Exception {
        if (nuovoValore >= dimensioneBoard) {

            throw new GiocoTerminatoException();


        }
        return nuovoValore;
    }

    public String giocaTurno() throws NoPlayersException {


        int giocatoreVincente = 0;

        if (players.size() == 0) {
            throw new NoPlayersException();
        }
        if (!inCorso) inCorso = true;

        Player corrente =null;
        try {
            for (int i = 0; i < players.size(); i++) {
                 corrente = players.get(i);


                if (!corrente.isStop()) {
                    giocatoreVincente = i;

                    int risultatoDado = lancioDadi();
                    int casellaDiArrivoTmp = aggiornaPosizione(corrente.getPosizione() + risultatoDado);


                    corrente.setUltimoTiro(risultatoDado);


                    ICasellaSpeciale casellaArrivo = caselle.get(casellaDiArrivoTmp);


                    if (casellaArrivo != null) {


                        try {
                            casellaDiArrivoTmp = aggiornaPosizione(casellaArrivo.calcolaPosizione(casellaDiArrivoTmp));

                        } catch (AzioneNonPermessaException e) {
                            e.printStackTrace();
                            corrente.setStop(true);
                        }


                    }
                    corrente.aggiungiLancio();
                    corrente.setPosizione(casellaDiArrivoTmp);


                } else {
                    corrente.setStop(false);
                }
            }

         } catch (Exception e) {
            e.printStackTrace();
            System.out.println(players.get(giocatoreVincente));
            isOver = true;
        }
        if (isOver) {
            inCorso = !inCorso;
            return "Game Over" + players.get(giocatoreVincente);
        }



        return "Turno concluso" + players;
    }





@Override
public String statoPartita(){
        return  "Partita in corso :" + inCorso+" "+ players.toString();
}


    private void creaBoard() {
 for (int i=0; i< dimensioneBoard;i++){

     caselle.add(i,null);

     switch (i) {
         case 1 -> caselle.add(new CasellaNumerica(2));
         case 5 -> caselle.add(new CasellaNumerica(-1));
         case 7 -> caselle.add(new CasellaNumerica(3));
         case 8 -> caselle.add(new CasellaNumerica(0));
         case 9 -> caselle.add(new CasellaStop());
         case 12 -> caselle.add(new CasellaNumerica(-3));
         default -> caselle.add( null);
     }




 }

    }

}
