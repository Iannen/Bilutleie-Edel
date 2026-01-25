package Brukergrensesnitt;

import KonseptuelleKlasser.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ProsedyrerTest {
    Bilutleiefirma bilutleiefirma;
    Lokasjon lokasjon1;
    Lokasjon lokasjon2;
    Lokasjon lokasjon3;

    Administrator admin1;
    Administrator admin2;
    Administrator admin3;

    Ekspeditoer eks1;
    Ekspeditoer eks2;
    Ekspeditoer eks3;

    Kunde kunde1;
    Kunde kunde2;
    Kunde kunde3;

    @BeforeEach
    void beforeEach(){
        bilutleiefirma= new Bilutleiefirma("Testfirma", 55347640,"Laksbakk");
        lokasjon1 = new Lokasjon(1,"Storeveien", 1);
        lokasjon2 = new Lokasjon(2,"Mellomveien", 2);
        lokasjon3 = new Lokasjon(3,"Lilleveien", 3);

        //implementerer Login
        admin1=new Administrator(1,"Admin1", "pass1","navn1");
        admin2=new Administrator(2,"Admin2", "pass2","navn2");
        admin3=new Administrator(3,"Admin3", "pass3","navn3");
        eks1 = new Ekspeditoer(1,"eks1","pass1","navn1",1);
        eks2 = new Ekspeditoer(2,"eks2","pass2","navn2",2);
        eks3 = new Ekspeditoer(3,"eks3","pass3","navn3",3);
        kunde1 = new Kunde(1,"kunde1","pass1","navn1",1,"adr1");
        kunde2 = new Kunde(2,"kunde2","pass2","navn2",2,"adr2");
        kunde3 = new Kunde(3,"kunde3","pass3","navn3",3,"adr3");
    }

    @Test
    void adminLogin() {
        List<Administrator> liste = bilutleiefirma.getAdmins();
        liste.add(admin1);
        liste.add(admin2);
        liste.add(admin3);
        liste.add(admin3);

        //tester at metoden returnerer et adminobjekt hvis pålogging og passord er korrekt
        Assertions.assertEquals(Prosedyrer.login(liste,admin1.getBrukernavn(), admin1.getPassord()),admin1);
        //Tester at metoden returnerer null hvis pålogging er feil
        Assertions.assertNull(Prosedyrer.login(liste,"feil", admin1.getPassord()));
        //Tester at metoden returnerer null hvis passord er feil
        Assertions.assertNull(Prosedyrer.login(liste,admin1.getBrukernavn(), "feil"));
        //Tester at metoden kaster feil hvis påloggingsinfo er match for mer enn en admin
        Assertions.assertThrows(RuntimeException.class,()->Prosedyrer.login(liste,admin3.getBrukernavn(),admin3.getPassord()));
    }
    @Test
    void kundeLogin(){
        List<Kunde> liste = bilutleiefirma.getKunder();
        liste.add(kunde1);
        liste.add(kunde2);
        liste.add(kunde3);
        liste.add(kunde3);
        //tester at metoden returnerer et kundeobjekt hvis pålogging og passord er korrekt
        Assertions.assertEquals(Prosedyrer.login(liste,kunde1.getBrukernavn(),kunde1.getPassord()),kunde1);
        //Tester at metoden returnerer null hvis pålogging er feil
        Assertions.assertNull(Prosedyrer.login(liste,"feil",kunde1.getPassord()));
        //Tester at metoden returnerer null hvis passord er feil
        Assertions.assertNull(Prosedyrer.login(liste,kunde1.getBrukernavn(),"feil"));
        //Tester at metoden kaster feil hvis påloggingsinfo er match for mer enn en admin
        Assertions.assertThrows(RuntimeException.class,()->Prosedyrer.login(liste,kunde3.getBrukernavn(),kunde3.getPassord()));
    }
    @Test
    void EkspeditoerLogin(){
        List<Ekspeditoer> liste = lokasjon1.getEkspeditoerer();
        liste.add(eks1);
        liste.add(eks2);
        liste.add(eks3);
        liste.add(eks3);

        //tester at metoden returnerer et ekspeditørobjekt hvis pålogging og passord er korrekt
        Assertions.assertEquals(Prosedyrer.login(liste,eks1.getBrukernavn(),eks1.getPassord()),eks1);
        //Tester at metoden returnerer null hvis pålogging er feil
        Assertions.assertNull(Prosedyrer.login(liste,"feil",eks1.getPassord()));
        //Tester at metoden returnerer null hvis passord er feil
        Assertions.assertNull(Prosedyrer.login(liste,eks1.getBrukernavn(),"feil"));
        //Tester at metoden kaster feil hvis påloggingsinfo er match for mer enn en admin
        Assertions.assertThrows(RuntimeException.class,()->Prosedyrer.login(liste,eks3.getBrukernavn(),eks3.getPassord()));
    }

    @Test
    void velgLokasjon() {
        List<Lokasjon> liste = bilutleiefirma.getLokasjoner();
        liste.add(lokasjon1);
        liste.add(lokasjon2);
        liste.add(lokasjon3);
        liste.add(lokasjon3);

        //tester at metoden returnerer en korrekt forespurt lokasjon
        Assertions.assertEquals(Prosedyrer.velg(liste,"1"),lokasjon1);
        //Tester at metoden returnerer null hvis forespurt lokasjon ikke eksisterer
        Assertions.assertNull(Prosedyrer.velg(liste,"5"));
        //Tester at metoden kaster feil hvis forespurt lokasjon er en match for mer enn en lokasjon
        Assertions.assertThrows(RuntimeException.class,()->Prosedyrer.velg(liste,"3"));
    }
}