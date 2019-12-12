package com.telran.comparator;

import com.telran.CountryCode;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountryCodeComparatorTest {

    CountryCodeComparator comparator = new CountryCodeComparator();

    @Test
    public void testCompare_less() {
        CountryCode usa = new CountryCode("USA", 1);
        CountryCode russia = new CountryCode("Russia", 7);
        CountryCode germany = new CountryCode("Germany", 49);

        assertTrue(comparator.compare(usa, russia) < 0);
        assertTrue(comparator.compare(usa, germany) < 0);
        assertTrue(comparator.compare(russia, germany) < 0);
    }

    @Test
    public void testCompare_greater() {
        CountryCode usa = new CountryCode("USA", 1);
        CountryCode russia = new CountryCode("Russia", 7);
        CountryCode germany = new CountryCode("Germany", 49);

        assertTrue(comparator.compare(russia, usa) > 0);
        assertTrue(comparator.compare(germany, usa) > 0);
        assertTrue(comparator.compare(germany, russia) > 0);
    }

    @Test
    public void testCompare_equals() {
        CountryCode usa = new CountryCode("USA", 1);
        CountryCode russia = new CountryCode("Russia", 7);

        CountryCode anotherUsa = new CountryCode("USA", 1);
        CountryCode anotherRussia = new CountryCode("Russia", 7);

        assertEquals(0, comparator.compare(usa, usa));
        assertEquals(0, comparator.compare(usa, anotherUsa));
        assertEquals(0, comparator.compare(russia, russia));
        assertEquals(0, comparator.compare(russia, anotherRussia));
    }
}