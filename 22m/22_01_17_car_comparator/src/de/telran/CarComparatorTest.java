package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarComparatorTest {
    CarComparator comparator = new CarComparator();

    @Test
    public void testCompare_sameYears() {
        Car car1 = new Car(100000, 2015);
        Car car2 = new Car(50000, 2015);

        assertTrue(comparator.compare(car1, car2) > 0);
        assertTrue(comparator.compare(car2, car1) < 0);
    }

    @Test
    public void testCompare_differentYears() {
        Car car1 = new Car(100000, 2015);
        Car car2 = new Car(50000, 2010);

        assertTrue(comparator.compare(car1, car2) < 0);
        assertTrue(comparator.compare(car2, car1) > 0);
    }
}
