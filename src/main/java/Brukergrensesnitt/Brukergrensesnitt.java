package Brukergrensesnitt;

import KonseptuelleKlasser.*;

import java.util.Scanner;

import static Brukergrensesnitt.MenyvisningsMetoder.visHovedMeny;

/**
 * Tekstbasert brukergrensesnitt for et Bilutleiefirma-system
 * Lar firmaets administratorer, ekspeditører og kunder gjøre ting i systemet
 */
public class Brukergrensesnitt {
    /**
     * Til innlesing av brukerinput
     */
    private final Scanner scanner = new Scanner(System.in);
    /**
     * Utleiefirmaet som brukergrensesnittet tilgjengeliggjør
     */
    private final Bilutleiefirma bilutleiefirma;

    /**
     * Initierer brukergrensesnittet med et bilutleiefirma og starter programmet
     * @param bilutleiefirma systemet som tilgjengeliggjøres
     */
    public Brukergrensesnitt(Bilutleiefirma bilutleiefirma) {
        this.bilutleiefirma = bilutleiefirma;
        System.out.println("Program starter");
        startMeny();
    }

    /**
     * Lar bruker velge å logge på som Administrator, ekspeditør eller kunde
     */
    public void startMeny() {
        Lokasjon lokasjon;
        Kunde kunde;
        boolean running = true;
        while (running){
            visHovedMeny(bilutleiefirma);
            String response = scanner.nextLine();
            switch (response){
                case "1":
                    //Logge inn som en administrator for bilutleiefirma
                    Administrator administrator = Prosedyrer.adminLogin(bilutleiefirma);
                    if (administrator!=null)
                        adminMeny(administrator);
                    break;
                case "2":
                    //velge ut en lokasjon
                    lokasjon = Prosedyrer.velgLokasjon(bilutleiefirma);
                    //logge inn som en ekspeditør gitt lokasjonen
                    if (lokasjon!=null){
                        Ekspeditoer ekspeditoer= Prosedyrer.ekspeditoerLogin(lokasjon);
                        if (ekspeditoer!=null)
                            ekspeditoerMeny(ekspeditoer);
                    }

                    break;
                case "3": // logge inn som en kunde
                    kunde = Prosedyrer.kundeLogin(bilutleiefirma);
                    if (kunde!=null)
                        kundeMeny(kunde);
                    break;
                case "4":
                    kunde = Prosedyrer.lagKunde();
                    bilutleiefirma.getKunder().add(kunde);
                    kundeMeny(kunde);
                    break;
                case "0":
                    running = false;
                    break;
            }
        }
    }
    private void adminMeny(Administrator administrator) {
        Lokasjon lokasjon;
        Bil bil;
        boolean running = true;
        while (running){
            MenyvisningsMetoder.visAdminMeny(administrator);
            String response = scanner.nextLine();
            switch (response) {
                case "1":
                    //opprette ekspeditør i en lokasjon
                    lokasjon=Prosedyrer.velgLokasjon(bilutleiefirma);
                    if (lokasjon!=null){
                        Ekspeditoer ekspeditoer=Prosedyrer.lagEkspeditoer();
                        lokasjon.getEkspeditoerer().add(ekspeditoer);
                    }
                    break;
                case "2":
                    //opprette lokasjon i bilutleiefirma
                    lokasjon = Prosedyrer.lagLokasjon();
                    bilutleiefirma.getLokasjoner().add(lokasjon);
                    break;
                case "3":
                    //opprette bil i en lokasjon
                    lokasjon=Prosedyrer.velgLokasjon(bilutleiefirma);
                    if (lokasjon!=null){
                        bil = Prosedyrer.lagBil();
                        lokasjon.getBiler().add(bil);
                    }
                    break;
                case "0":
                    running = false;
                    break;
            }
        }
    }
    private void ekspeditoerMeny(Ekspeditoer ekspeditoer) {
        boolean running = true;
        while (running){
            Kunde kunde;
            Bil bil;
            Lokasjon lokasjon;
            MenyvisningsMetoder.visEkspeditoerMeny(ekspeditoer);
            String response = scanner.nextLine();
            switch (response){
                case "1":
                    //Registrer en ny kunde
                    kunde= Prosedyrer.lagKunde();
                    bilutleiefirma.getKunder().add(kunde);
                    break;
                case "2": //Lei ut en bil til en eksisterende kunde
                    //velg ut en kunde
                    kunde = Prosedyrer.velgKunde(bilutleiefirma);
                    //finn lokasjon til ekspeditøren
                    lokasjon = bilutleiefirma.getLokasjoner().stream().filter(a->a.getEkspeditoerer().contains(ekspeditoer)).toList().get(0);
                    //velg en bil fra lokasjonens biler
                    bil = Prosedyrer.velgBil(lokasjon);
                    //opprette ut utleie for kunden og bilen
                    Prosedyrer.leiUtBil(kunde,bil);
                    break;
                case "3": //Registrere at en kunde leverer tilbake en bil
                    //TODO
                    break;
                default:
                    running = false;
            }
        }
    }
    private void kundeMeny(Kunde kunde){
        boolean running = true;
        while (running){
            Lokasjon lokasjon;
            Bil bil;
            MenyvisningsMetoder.visKundeMeny(kunde);
            String response = scanner.nextLine();
            switch (response){
                case "1"://lei en bil
                    //velg en lokasjon
                    lokasjon = Prosedyrer.velgLokasjon(bilutleiefirma);
                    //velg en bil fra lokasjonen
                    bil =Prosedyrer.velgBil(lokasjon);
                    //opprette ut utleie for kunden og bilen
                    Utleie utleie = Prosedyrer.leiUtBil(kunde,bil);
                    lokasjon.getUtleier().add(utleie);
                    break;
                default:
                    running = false;
            }
        }
    }
}
