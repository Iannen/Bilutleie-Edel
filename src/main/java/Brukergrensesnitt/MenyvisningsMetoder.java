package Brukergrensesnitt;

import java.io.IOException;

import KonseptuelleKlasser.Administrator;
import KonseptuelleKlasser.Bilutleiefirma;
import KonseptuelleKlasser.Ekspeditoer;
import KonseptuelleKlasser.Kunde;

public class MenyvisningsMetoder {
    static StringBuilder sb =new StringBuilder();
    /**
     * Viser en hovedmeny der bruker logger inn som 'Systemadministrator', 'Skrankemedarbeider' eller 'Kunde'
     */
    static  void visHovedMeny(Bilutleiefirma bilutleiefirma){
        sb.append("Velkommen til ").append(bilutleiefirma.getNavn()).append("!\n")
                .append("Vennligst en av følgende:\n")
                .append("\t1. ").append("Logg inn som ").append(NavnPaaTing.SYSTEMADMINISTRATOR).append("\n")
                .append("\t2. ").append("Logg inn som ").append(NavnPaaTing.SKRANKEMEDARBEIDER).append("\n")
                .append("\t3. ").append("Logg inn som ").append(NavnPaaTing.KUNDE).append("\n")
                .append("\t4. ").append("Registrer ny ").append(NavnPaaTing.KUNDE).append("\n")
                .append("Returner '0' for å avslutte");
        clearConsole();
        System.out.println(sb);
        sb.setLength(0);
    }
    static  void visAdminMeny(Administrator administrator){
        sb.append("Administrator ").append(administrator.getNavn()).append(" er logget inn !\n")
                .append("Vennligst velg en av følgende:\n")
                .append("\t1. ").append("Opprett ").append(NavnPaaTing.SKRANKEMEDARBEIDER).append("\n")
                .append("\t2. ").append("Opprett ").append(NavnPaaTing.UTLEIEKONTOR).append("\n")
                .append("\t3. ").append("Opprett ").append(NavnPaaTing.BIL).append("\n")
                .append("Returner '0' for å logge av");
        clearConsole();
        System.out.println(sb);
        sb.setLength(0);
    }
    static void visEkspeditoerMeny(Ekspeditoer ekspeditoer){
        sb.append("Ekspeditør ").append(ekspeditoer.getNavn()).append(" er logget inn!\n")
                .append("Vennligst velg en av følgende:\n")
                .append("\t1. ").append("Registrer en ny ").append(NavnPaaTing.KUNDE).append("\n")
                .append("\t2. ").append("Lei ut en ").append(NavnPaaTing.BIL).append("\n")
                .append("Returner '0' for å logge av");
        clearConsole();
        System.out.println(sb);
        sb.setLength(0);
    }
    static void visKundeMeny(Kunde kunde){
        sb.append("Kunde ").append(kunde.getNavn()).append(" er logget inn!\n")
                .append("Vennligst velg en av følgende:\n")
                .append("\t1. ").append("Lei en ").append(NavnPaaTing.BIL).append("\n")
                .append("Returner '0' for å logge av");
        clearConsole();
        System.out.println(sb);
        sb.setLength(0);
    }
    static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("\n");
    }
}
