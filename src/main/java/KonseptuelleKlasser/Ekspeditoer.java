package KonseptuelleKlasser;

import main.Login;

/**
 * Representerer en ekspeditør - en person på en lokasjon som håndterer kundehenvendelser
 */
public class Ekspeditoer implements Login {
    /**
     * En unik identifikator for ekspeditøren
     */
    private int id;
    /**
     * Ekspeditørens passord
     */
    private String brukernavn;
    /**
     * Ekspeditørens passord
     */
    private String passord;
    /**
     * Ekspeditørens fulle navn
     */
    private String navn;
    /**
     * Ekspeditørens telefonnummer
     */
    private int telefonNummer;

    @Override
    public String getBrukernavn() {
        return brukernavn;
    }

    @Override
    public String getPassord() {
        return passord;
    }

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

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public Ekspeditoer(int id, String brukernavn, String passord, String navn, int telefonNummer) {
        this.id = id;
        this.brukernavn = brukernavn;
        this.passord = passord;
        this.navn = navn;
        this.telefonNummer = telefonNummer;
    }
}
