package main;

import Brukergrensesnitt.Brukergrensesnitt;
import KonseptuelleKlasser.*;

public class Main {

    public static void main(String[] args) {
        Bilutleiefirma bilutleieFirma = new Bilutleiefirma("Edel",55347640,"Laksbakkveien 27, 1952 Langhus");

        Administrator admin1=new Administrator(1,"admin","pass", "Axel Admin");
        bilutleieFirma.addAdmin(admin1);

        Lokasjon lok1 = new Lokasjon(1,"Storeveien",1 );
        Kunde kunde1 = new Kunde(1,"kunde", "pass","Kåre Kunde",1,"Lilleveien");
        bilutleieFirma.getLokasjoner().add(lok1);
        bilutleieFirma.getKunder().add(kunde1);

        Ekspeditoer eks1 = new Ekspeditoer(1,"eks","pass","Elise Ekspeditør",1);
        lok1.getEkspeditoerer().add(eks1);
        Bil bil1 = new Bil(1,"SR_1","Volvo","EX30","Brun",1);
        lok1.getBiler().add(bil1);

        Brukergrensesnitt brukergrensesnitt = new Brukergrensesnitt(bilutleieFirma);
    }
}