package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringServiceTest {

    StringService service = new StringService();

    @Test
    public void testReverse_emptyString() {
        assertEquals("", service.reverse(""));
    }

    @Test
    public void testReverse_symmetricString() {
        assertEquals("HelleH", service.reverse("HelleH"));
        assertEquals("oLo", service.reverse("oLo"));
        assertEquals("hello olleh", service.reverse("hello olleh"));
    }

    @Test
    public void testReverse_anyString() {
        assertEquals("Hello", service.reverse("olleH"));
        assertEquals("Hello world", service.reverse("dlrow olleH"));
    }
}
