package KonseptuelleKlasser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class BilTest {
	
	 @Test
	    public void testKonstruktør() {
	        Bil bil = new Bil(1,"EN-236587", "Tesla", "Model S", "Hvit", 1);

	        assertEquals("SR-236587", bil.getRegNr());
	        assertEquals("Tesla", bil.getMerke());
	        assertEquals("Model S", bil.getModell());
	        assertEquals("Hvit", bil.getFarge());
	        assertEquals(1, bil.getUtleieGruppe());
	        assertEquals(false, bil.isUtleid());
	        
	    }

}