package school.devskill.GiocoDellOca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import school.devskill.GiocoDellOca.ElementiDiGioco.Player;
import school.devskill.GiocoDellOca.eccezioni.GiocoInCorsoException;
import school.devskill.GiocoDellOca.eccezioni.NoPlayersException;
import school.devskill.GiocoDellOca.service.classes.BoardManagerImpl;

@SpringBootApplication
public class GiocoDellOcaApplication {

	public static void main(String[] args) {


		SpringApplication.run(GiocoDellOcaApplication.class, args);
		try {
		Player uno = new Player("Marco");Player due = new Player("Filippo");
		BoardManagerImpl manager = new BoardManagerImpl();
		manager.aggiungiGiocatore(uno);
		manager.aggiungiGiocatore(due);
		System.out.println(manager.giocaTurno());


	} catch (GiocoInCorsoException e) {
	e.printStackTrace();
		} catch (NoPlayersException e) {
			throw new RuntimeException(e);
		}
	}}

