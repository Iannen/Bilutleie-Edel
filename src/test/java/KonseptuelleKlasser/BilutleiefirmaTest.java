package KonseptuelleKlasser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BilutleiefirmaTest {
@Test
public void testKonstruktør() {
	Bilutleiefirma bilutleiefirma = new Bilutleiefirma("Hertz",12345678,"Edvard Munchs veg");
	assertEquals("Hertz", bilutleiefirma.getNavn());
	assertEquals("12345678", bilutleiefirma.getTelefonnummer());
	assertEquals("Edvard Munchs veg", bilutleiefirma.getAdresse());
}
}