package KonseptuelleKlasser;

import main.Login;

/**
 * Representerer en Administrator. En person som kan opprette lokasjoner, andre ansatte og biler i systemet.
 * Administratorer opprettes utenfor systemet
 */
public class Administrator implements Login {
    /**
     * Unik identifikator for administratoren
     */
    private int id;
    /**
     * Administratorens påloggingsID
     */
    private String brukernavn;
    /**
     * Administratorens passord;
     */
    private String passord;
    /**
     * Administratorens fulle navn
     */
    private String navn;

    public Administrator(int id, String brukernavn, String passord,String navn) {
        this.id = id;
        this.brukernavn = brukernavn;
        this.passord = passord;
        this.navn = navn;
    }
    @Override
    public String getBrukernavn() {
        return brukernavn;
    }

    public void setBrukernavn(String brukernavn) {
        this.brukernavn = brukernavn;
    }
    @Override
    public String getPassord() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
