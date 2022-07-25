package school.devskill.GiocoDellOca.ElementiDiGioco;

import lombok.*;

@Getter
@Setter
@ToString

@AllArgsConstructor
public class Player {
    private final String nome;
    private int nLanci;
    private  int posizione;
    private boolean stop;
    private int ultimoTiro;


    public Player(String name) {
        this.nome = name;
       nLanci=0;
       stop= false;
    }

    public  void aggiungiLancio(){

        this.nLanci++;
    }
}
