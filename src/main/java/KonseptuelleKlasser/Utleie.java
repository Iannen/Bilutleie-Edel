package KonseptuelleKlasser;

import java.time.LocalDateTime;

/**
 * Representerer ett utleie - en forekomst av at en kunde leier en bil
 */
public class Utleie {
    /**
     * en unik identifikator for utleiet
     */
    int id;
    /**
     * Dato utleiet loeper fra
     */
    private LocalDateTime fraDato;
    /**
     * Dato utleiet loper til
     */
    private LocalDateTime tilDato;
    /**
     * Antall kilimeter som ble kjoert under utleiet
     */
    private int kilometer;
    /**
     * Kunden som leiet en bil
     */
    private Kunde kunde;
    /**
     * Bilen som ble utleid
     */
    private Bil bil;

    public Utleie(int id, Kunde kunde, Bil bil) {
        this.id = id;
        this.fraDato = LocalDateTime.now();
        this.tilDato = null;
        this.kilometer = 0;
        this.kunde = kunde;
        this.bil = bil;
    }
}
