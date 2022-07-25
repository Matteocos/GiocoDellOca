package school.devskill.GiocoDellOca.ElementiDiGioco;

public class CasellaNumerica implements ICasellaSpeciale {

    private  final int imprevisto;

    public CasellaNumerica(int imprevisto) {
        this.imprevisto = imprevisto;
    }



    @Override
    public int calcolaPosizione(int posizioneGiocatore) {
        if (imprevisto == 0) {
            return 0;

        }
        return posizioneGiocatore+imprevisto;
    }
}
