package KonseptuelleKlasser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AdministratorTest {
	@Test
	 public void testKonstruktor() {
        Administrator admin = new Administrator(1, "admin123", "pass", "Hans Hansen");
        assertEquals("admin123", admin.getBrukernavn());
        assertEquals("pass", admin.getPassord());
        assertEquals("Hans Hansen", admin.getNavn());
    }
}