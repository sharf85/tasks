package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VaccinationComparatorTest {

    VaccinationComparator comparator = new VaccinationComparator();

    @Test
    public void testCompare_1() {
        Human vasya = new Human(70, false, "Vasya");
        Human petya = new Human(50, false, "Petya");

        assertTrue(comparator.compare(vasya, petya) < 0);
        assertTrue(comparator.compare(petya, vasya) > 0);
    }

}
