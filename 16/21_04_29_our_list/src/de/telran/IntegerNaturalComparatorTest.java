package de.telran;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class IntegerNaturalComparatorTest {

    IntegerNaturalComparator comparator;

    @BeforeEach
    public void init() {
        comparator = new IntegerNaturalComparator();
    }

    public void testCompare_nonEqualNumbers() {
        assertTrue(comparator.compare(1, 2) < 0);
        assertTrue(comparator.compare(2, 1) > 0);
        assertTrue(comparator.compare(15, 2) > 0);
        assertTrue(comparator.compare(2, 15) < 0);
    }
}
