package Brukergrensesnitt;

import KonseptuelleKlasser.*;
import main.Id;
import main.Login;

import java.util.List;
import java.util.Scanner;

/**
 * Har statiske metoder for innlogging, utvelging og innhenting av data for oppretting
 */
public class Prosedyrer {
    static Scanner scanner=new Scanner(System.in);

    /**
     * Lar bruker logge inn som administrator, hvis brukernavn og passord stemmer
     * @param bilutleiefirma Bilutleiefirmaet som bruker forsøker å logg inn som administraror for
     * @return Et objekt som representerer administratoren, eller null hvis innlogging mislykkes
     */
    public static Administrator adminLogin(Bilutleiefirma bilutleiefirma) {
        Administrator administrator = null;
        System.out.println("Vennligst returner ditt brukernavn\n");
        String brukernavn = scanner.nextLine();
        System.out.println("Vennligst returner ditt passord\n");
        String passord = scanner.nextLine();
        administrator = login(bilutleiefirma.getAdmins(),brukernavn,passord);
        if (administrator==null)
            System.out.println("Pålogging mislykkes");
        
        else
            System.out.println("Velkommen "+administrator.getNavn()+"! Go easy on 'em!");
        scanner.nextLine();
        return administrator;
    }
    public static Ekspeditoer ekspeditoerLogin(Lokasjon lokasjon) {
        Ekspeditoer ekspeditoer = null;
        System.out.println("Vennligst returner ditt brukernavn\n");
        String brukernavn = scanner.nextLine();
        System.out.println("Vennligst returner ditt passord\n");
        String passord = scanner.nextLine();
        ekspeditoer = login(lokasjon.getEkspeditoerer(),brukernavn,passord);
        if (ekspeditoer==null)
            System.out.println("Pålogging mislykkes");
        else
            System.out.println("Velkommen "+ekspeditoer.getNavn()+"! Vær snill med kundene!");
        scanner.nextLine();
        return ekspeditoer;
    }
    public static Kunde kundeLogin(Bilutleiefirma bilutleiefirma){
        Kunde kunde = null;
        System.out.println("Vennligst returner ditt brukernavn\n");
        String brukernavn = scanner.nextLine();
        System.out.println("Vennligst returner ditt passord\n");
        String passord = scanner.nextLine();
        kunde = login(bilutleiefirma.getKunder(),brukernavn,passord);
        if (kunde==null)
            System.out.println("Pålogging mislykkes");
        else
            System.out.println("Velkommen "+kunde.getNavn()+"! Nyt utvalget!");
        scanner.nextLine();
        return kunde;
    }

    /**
     * Generell metode for pålogging
     * @param liste En List<> over mulige innloggingsobjekter
     * @param brukernavn brukers brukernavn for innlogging
     * @param passord  brukers passord
     * @return Et objekt som representerer den innloggede bruker
     * @param <T> Et objekt som implementerer interface Login
     */
    static <T extends Login>T login(List<T> liste, String brukernavn, String passord) {
        List<T> matchList = liste.stream().
                filter(a->a.getBrukernavn().equals(brukernavn) && a.getPassord().equals(passord))
                .toList();
        if (matchList.isEmpty())
            return null;
        if (matchList.size()>1)
            throw new RuntimeException("Oppgitt brukernavn og passord var en match for mer enn ett objekt. Databasen er korrupt");
        return matchList.get(0);
    }


    public static Lokasjon velgLokasjon(Bilutleiefirma bilutleiefirma) {
        Lokasjon lokasjon=null;
        System.out.println("velg en lokasjon");
        for (Lokasjon l:bilutleiefirma.getLokasjoner())
            System.out.println(l.getId()+" "+l.getAdresse());
        String lokasjonId = scanner.nextLine();
        lokasjon = velg(bilutleiefirma.getLokasjoner(),lokasjonId);
        if (lokasjon==null)
            System.out.println("Det eksisterer ingen lokasjoner med id "+lokasjonId);
        else
            System.out.println("Lokasjon "+lokasjon.getId()+" på adresse "+lokasjon.getAdresse()+" er valgt");
        scanner.nextLine();
        return lokasjon;
    }
    static <T extends Id>T velg(List<T> liste, String id) {
        List<T> matchList = liste.stream().filter(a->String.valueOf(a.getId()).equals(id)).toList();
        if (matchList.isEmpty())
            return null;
        if (matchList.size()>1)
            throw new RuntimeException("Oppgitt ID var en match for mer enn ett objekt. Databasen er korrupt");
        return matchList.get(0);
    }

    public static Ekspeditoer lagEkspeditoer() {
        System.out.println("Vennligst returner ekspeditørId");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Vennligst returner ekspeditørens brukernavn");
        String brukernavn=scanner.nextLine();
        System.out.println("Vennligst returner ekspeditørens passord");
        String passord = scanner.nextLine();
        System.out.println("Vennligst returner ekspeditørens fulle navn");
        String navn = scanner.nextLine();
        System.out.println("Vennligst returner ekspeditørens telefonnummer");
        int telefonnummer = Integer.parseInt(scanner.nextLine());
        return new Ekspeditoer(id,brukernavn, passord, navn, telefonnummer);
    }

    public static Lokasjon lagLokasjon() {
        System.out.println("Vennligst oppgi en Id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Vennligst oppgi en adresse");
        String adresse = scanner.nextLine();
        System.out.println("Vennligst oppgi ett telefonnummer");
        int telefonnummer = Integer.parseInt(scanner.nextLine());
        return new Lokasjon(id,adresse,telefonnummer);
    }

    public static Bil lagBil() {
        System.out.println("Vennligst oppgi bilens id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Vennligst oppgi bilens registreringsnummer");
        String regNr= scanner.nextLine();;
        System.out.println("Vennligst oppgi bilens merke / produsent");
        String merke = scanner.nextLine();
        System.out.println("Vennligst oppgi bilens modell");
        String modell = scanner.nextLine();
        System.out.println("Vennligst oppgi bilens farge");
        String farge = scanner.nextLine();
        System.out.println("Vennligst oppgi bilens utleiegruppe");
        int utleieGruppe = Integer.parseInt(scanner.nextLine());
        return new Bil(id,regNr, merke, modell, farge, utleieGruppe);
    }


    public static Kunde lagKunde() {
        System.out.println("Vennligst oppgi Id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Vennligst oppgi brukernavn");
        String brukernavn = scanner.nextLine();
        System.out.println("Vennligst oppgi passord");
        String passord = scanner.nextLine();
        System.out.println("Vennligst oppgi fullt navn");
        String navn = scanner.nextLine();
        System.out.println("Vennligst oppgi fullt telefonnummer");
        int telefonnummer = Integer.parseInt(scanner.nextLine());
        System.out.println("Vennligst oppgi adresse");
        String adresse = scanner.nextLine();
        return new Kunde(id,brukernavn,passord,navn,telefonnummer,adresse);
    }

    public static Kunde velgKunde(Bilutleiefirma bilutleiefirma) {
        Kunde kunde =null;
        System.out.println("velg en kunde");
        for (Kunde k:bilutleiefirma.getKunder())
            System.out.println(k.getId()+" "+k.getNavn());
        String id = scanner.nextLine();
        kunde = velg(bilutleiefirma.getKunder(),id);
        if (kunde==null)
            System.out.println("Det eksisterer ingen kunde med id "+id);
        else
            System.out.println("kunde nr."+kunde.getId()+kunde.getNavn()+" er valgt");
        return kunde;
    }

    public static Bil velgBil(Lokasjon lokasjon) {
        Bil bil = null;
        System.out.println("velg en bil");
        for (Bil b:lokasjon.getBiler())
            System.out.println(b.getId()+" "+b.getFarge()+" "+b.getMerke()+" "+b.getModell());
        String id = scanner.nextLine();
        bil = velg(lokasjon.getBiler(),id);
        if (bil==null)
            System.out.println("Det eksisterer ingen bil med id "+id);
        else
            System.out.println("bil nr."+bil.getId()+" "+bil.getFarge()+" "+bil.getMerke()+" "+bil.getModell()+" er valgt");
        return bil;
    }

    /**
     *  Leier ut en bil til en kunde;
     * @param kunde kunden som skal leie en bil
     * @param bil bilen kunden leier
     * @return et bilutleieobjekt
     */
    public static Utleie leiUtBil(Kunde kunde, Bil bil) {
        System.out.println("Vennligst oppgi Id");
        int id = Integer.parseInt(scanner.nextLine());
        return new Utleie(id,kunde,bil);
    }
}
