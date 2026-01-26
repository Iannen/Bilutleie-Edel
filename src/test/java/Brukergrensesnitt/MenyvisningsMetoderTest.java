package Brukergrensesnitt;

import KonseptuelleKlasser.Administrator;
import KonseptuelleKlasser.Bilutleiefirma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Her skrives menyene ut for visuell inspeksjon
 */
class MenyvisningsMetoderTest {
    Bilutleiefirma bilutleiefirma;
    Administrator administrator;

    @BeforeEach
    void beforeEach() {
        bilutleiefirma = new Bilutleiefirma("Testfirma",55347640,"Laksbakk");
        administrator = new Administrator(1,"Admin","pass","Karl Robert");
    }

    @Test
    void hovedMenyTest() {
        System.out.println("**Hovedmenytest**");
        MenyvisningsMetoder.visHovedMeny(bilutleiefirma);
        System.out.println();
    }
    @Test
    void visAdminMenyTest(){
        System.out.println("**Administratormenytest**");
        MenyvisningsMetoder.visAdminMeny(administrator);
    }
}