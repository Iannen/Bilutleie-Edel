package KonseptuelleKlasser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LokasjonTest {
	//public Lokasjon(int id, String adresse, int telefonnummer) {
@Test
public void konstruktorTest() {
	Lokasjon lokasjon = new Lokasjon(3, "Bergensveien 2", 11111111);
	assertEquals(3, lokasjon.getId());
	assertEquals("Bergensveien 2", lokasjon.getAdresse());
	assertEquals(11111111, lokasjon.getTelefonnummer());
}
}