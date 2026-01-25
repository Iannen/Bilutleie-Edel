package KonseptuelleKlasser;

import java.util.ArrayList;
import java.util.List;

/**
 * Representerer et firma som driver med utleie av biler fra forskjellige lokasjoner
 */
public class Bilutleiefirma {
    /**
     * Firmaets navn
     */
    private String navn;
    /**
     * Telefonnummer til firmaets hovedkontor
     */
    private int telefonnummer;
    /**
     * Adressen til firmaets hovedkontor
     */
    private String adresse;

    /**
     * En liste over objekter som representerer firmaets kunder
     */
    private List<Kunde> kunder;
    /**
     * En liste over objekter som representerer firmaets lokasjoner
     */
    private List<Lokasjon> lokasjoner;
    /**
     *En liste over objekter som representerer personer med Adminrettigheter.
     * Administratorene kan opprette nye lokasjoner, registrere ansatte og registrere nyinnkjøpte biler.
     */
    private List<Administrator> admins;

    /**
     * Initierer firmaet med dets navn, telefonnummer, adresse og tomme List<> til kunder/lokasjoner/admins
     * @param navn Firmaets navn
     * @param telefonnummer Firmaets telefonnummer
     * @param adresse Firmaets adresse
     */

    public Bilutleiefirma(String navn, int telefonnummer, String adresse) {
        this.navn = navn;
        this.telefonnummer = telefonnummer;
        this.adresse = adresse;
        this.kunder = new ArrayList<>();
        this.lokasjoner = new ArrayList<>();
        this.admins = new ArrayList<>();
    }

    /**
     * Legger til en administrator
     * @param administrator Administratoren som legges til
     */
    public void addAdmin(Administrator administrator){
        this.admins.add(administrator);
    }

    //Getters & setters

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(int telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<Kunde> getKunder() {
        return kunder;
    }

    public void setKunder(List<Kunde> kunder) {
        this.kunder = kunder;
    }

    public List<Lokasjon> getLokasjoner() {
        return lokasjoner;
    }

    public void setLokasjoner(List<Lokasjon> lokasjoner) {
        this.lokasjoner = lokasjoner;
    }

    public List<Administrator> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Administrator> admins) {
        this.admins = admins;
    }
}