package KonseptuelleKlasser;

import main.Id;
import main.Login;

/**
 * Representerer en kunde
 */
public class Kunde implements Login, Id {
    /**
     * En unik identifikator for kunden
     */
    private int id;
    /**
     * Kundens brukernavn ved pålogging
     */
    private String brukernavn;
    /**
     * Kundens passord ved pålogging
     */
    private String passord;
    /**
     * Kundens fulle navn
     */
    private String navn;
    /**
     * Kundens telefonnummer
     */
    private int telefonNummer;
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public int getTelefonNummer() {
		return telefonNummer;
	}

	public void setTelefonNummer(int telefonNummer) {
		this.telefonNummer = telefonNummer;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	/**
     * Kundens adresse
     */
    private String adresse;
	/**
	 * Lager et nytt kundeobjekt, initiert med:
	 * @param navn Kundens fulle navn
	 * @param telefonNummer Kundens telefonnummer
	 * @param adresse Kundens adresse
	 */
    public Kunde(int id, String brukernavn, String passord, String navn, int telefonNummer, String adresse) {
        this.id = id;
        this.brukernavn = brukernavn;
        this.passord = passord;
        this.navn = navn;
        this.telefonNummer = telefonNummer;
        this.adresse = adresse;
    }
    @Override
    public String getBrukernavn() {
        return brukernavn;
    }

    @Override
    public String getPassord() {
        return passord;
    }
}