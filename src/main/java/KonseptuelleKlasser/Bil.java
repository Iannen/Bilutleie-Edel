package KonseptuelleKlasser;

import main.Id;

/**
 * Representerer en bil som firmaets kunder kan leie
 */
public class Bil implements Id {
    /**
     * En unik identifikator for bilen
     */
    int id;
    /**
     * Bilens registreringsnummer , f.eks SR-236587
     */
    private String regNr;
    /**
     * Bilens merke / produsent, f.eks Tesla, Volvo etc
     */
    private String merke;
    /**
     * Bilens modell, f.eks "Model S", "XC40 Recharge" etc
     */
    private String modell;
    /**
     * Bilens farge, f.eks "Metallic grey", "black" etc
     */
    private String farge;
    /**
     * Bilens utleiegruppe, 1 = liten bil, 2 = mellomstor bil, 3 = stor bil, 4 = stasjonsvogn
     */
    private int utleieGruppe;
    /**
     * Angir om bilen er utleid for øyeblikket
     */
    boolean utleid;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegNr() {
		return regNr;
	}

	public void setRegNr(String regNr) {
		this.regNr = regNr;
	}

	public String getMerke() {
		return merke;
	}

	public void setMerke(String merke) {
		this.merke = merke;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public String getFarge() {
		return farge;
	}

	public void setFarge(String farge) {
		this.farge = farge;
	}

	public int getUtleieGruppe() {
		return utleieGruppe;
	}

	public void setUtleieGruppe(int utleieGruppe) {
		this.utleieGruppe = utleieGruppe;
	}

	public boolean isUtleid() {
		return utleid;
	}

	public void setUtleid(boolean utleid) {
		this.utleid = utleid;
	}

	/**
     * Initierer bilen som uutleid med statisk informasjon
     * @param regNr Bilens registreringsnummer
     * @param merke Bilens merke / produsent
     * @param modell Bilens modell
     * @param farge Bilens farge
     * @param utleieGruppe Bilens utleiegruppe
     */
	public Bil(int id, String regNr, String merke, String modell, String farge, int utleieGruppe) {
		this.id = id;
		this.regNr = regNr;
		this.merke = merke;
		this.modell = modell;
		this.farge = farge;
		this.utleieGruppe = utleieGruppe;
		this.utleid = false;
	}
}
