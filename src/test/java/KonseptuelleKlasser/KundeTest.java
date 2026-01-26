package KonseptuelleKlasser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


//  public Kunde(int id, String brukernavn, String passord, String navn, int telefonNummer, String adresse) {
class KundeTest {
	@Test
	public void konstruktorTest() {
		Kunde kunde = new Kunde(17231, "abc123", "passord1","Ingrid Dale", 90807060,"Bakarvågen 22");
		assertEquals(17231,kunde.getId());
		assertEquals("abc123",kunde.getBrukernavn());
		assertEquals("Ingrid Dale",kunde.getNavn());
		assertEquals("passord1",kunde.getPassord());
		assertEquals(90807060,kunde.getTelefonNummer());
		assertEquals("Bakarvågen 22", kunde.getAdresse());
	}

}