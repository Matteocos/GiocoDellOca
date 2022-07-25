package school.devskill.GiocoDellOca.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import school.devskill.GiocoDellOca.ElementiDiGioco.Player;
import school.devskill.GiocoDellOca.eccezioni.GiocoInCorsoException;
import school.devskill.GiocoDellOca.eccezioni.NoPlayersException;
import school.devskill.GiocoDellOca.service.interfaces.IBoardManager;
import school.devskill.GiocoDellOca.web.Interface.IGiocoController;
import school.devskill.GiocoDellOca.web.command.InfoGiocatore;

@RestController
@RequestMapping("/oca/")
public class GiocoController implements IGiocoController {

private IBoardManager boardManager;
private final ObjectMapper micheal;


@Autowired
public  GiocoController(IBoardManager boardManager, ObjectMapper micheal){
    this.boardManager=boardManager;
    this.micheal = micheal;
}



    @PostMapping("aggiungiGiocatore")
    @Override
    public String aggiungiGiocatore(@RequestBody InfoGiocatore i) {
    String message="";
        try {
            boardManager.aggiungiGiocatore(micheal.convertValue(i, Player.class));
            message="giocatore aggiunto con successo";
        } catch (GiocoInCorsoException e) {
            e.printStackTrace();
            message= e.getMessage();
        }


        return message;

    }
    @PostMapping("reset")
    @Override
    public String reset() {

        String message = "";
        try {
            boardManager.Reset();
            message = "partita resettata con successo";
        } catch (NoPlayersException e) {
            e.printStackTrace();
            message = e.getMessage();
        }
        return message;
    }



    @GetMapping ("statoPartita")
    @Override
    public String statoPartita() {
        return boardManager.statoPartita();

    }
    @PostMapping("giocaTurno")
    @Override
    public String giocaTurno() {
    String message="";
        try {
            message=boardManager.giocaTurno();
        } catch (NoPlayersException e) {
            e.printStackTrace();
            message= e.getMessage();
        }
        return message;

    }
}
