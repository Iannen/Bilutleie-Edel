package KonseptuelleKlasser;

import main.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Representerer en lokasjon som firmaet driver utleie fra
 */
public class Lokasjon implements Id {
    /**
     * Unik identifikator for lokasjonen
     */
    int id;
    /**
     * Lokasjonens adresse
     */
    String adresse;
    /**
     * Lokasjonens telefonnummer;
     */
    int telefonnummer;
    /**
     * En liste over ekspeditører - personer som håndterer kundehenvendelser på denne lokasjonen
     */
    List<Ekspeditoer> ekspeditoerer;
    /**
     * En liste over biler som disponeres for utleie fra lokasjonen
     */
    List<Bil> biler;
    /**
     * En liste over utleieordrer fra denne lokasjonen
     */
    List<Utleie> utleier;

    /**
     * Initierer en lokasjon med statisk data og tomme Lister
     * @param id Unik identifikator for lokasjonen
     * @param adresse Lokasjonens adresse
     * @param telefonnummer Lokasjonens telefonnummer
     */
    public Lokasjon(int id, String adresse, int telefonnummer) {
        this.id = id;
        this.adresse = adresse;
        this.telefonnummer = telefonnummer;
        this.biler = new ArrayList<>();
        this.utleier = new ArrayList<>();
        this.ekspeditoerer=new ArrayList<>();
    }
    //getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(int telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public List<Ekspeditoer> getEkspeditoerer() {
        return ekspeditoerer;
    }

    public void setEkspeditoerer(List<Ekspeditoer> ekspeditoerer) {
        this.ekspeditoerer = ekspeditoerer;
    }

    public List<Bil> getBiler() {
        return biler;
    }

    public void setBiler(List<Bil> biler) {
        this.biler = biler;
    }

    public List<Utleie> getUtleier() {
        return utleier;
    }

    public void setUtleier(List<Utleie> utleier) {
        this.utleier = utleier;
    }
}
