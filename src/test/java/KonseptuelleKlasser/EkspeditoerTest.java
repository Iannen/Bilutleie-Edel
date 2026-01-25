package KonseptuelleKlasser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EkspeditoerTest {
// public Ekspeditoer(int id, String brukernavn, String passord, String navn, int telefonNummer) {
	@Test 
	public void testKonstruktør() {
		Ekspeditoer ekspeditoer = new Ekspeditoer(1,"henHen","pass123","Henrik Henriksen", 22334455);
		assertEquals(1, ekspeditoer.getId());
		assertEquals("henHen", ekspeditoer.getBrukernavn());
		assertEquals("pass123", ekspeditoer.getPassord());
		assertEquals("Henrik Henriksen", ekspeditoer.getNavn());
		assertEquals(22334455, ekspeditoer.getTelefonNummer());
		
	}
}