package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// TODO complete tests
class NewsTest {
    @Test
    public void testCompareTo_samePriority() {
        News news1 = new News("Hello world", 7);
        News news2 = new News("Hello", 7);

        assertTrue(news1.compareTo(news2) > 0);
    }

    @Test
    public void testCompareTo_differentPriority() {
        News news1 = new News("Hello world", 8);
        News news2 = new News("Hello", 7);

        assertTrue(news1.compareTo(news2) < 0);
    }

    @Test
    public void testCompareTo_samePrioritySameLength() {
        News news1 = new News("world", 7);
        News news2 = new News("Hello", 7);

        assertEquals(0, news1.compareTo(news2));
    }
}
