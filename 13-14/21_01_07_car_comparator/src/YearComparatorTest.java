import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YearComparatorTest {
    YearComparator yearComparator = new YearComparator();

    @Test
    public void testCompare_carsWithSameYear_zero() {
        Car mazda = new Car("Mazda", 2020, 1000);
        Car opel = new Car("Opel", 2020, 2000);

        assertEquals(0, yearComparator.compare(mazda, opel));
        assertEquals(0, yearComparator.compare(opel, mazda));
    }

    @Test
    public void testCompare_carsWithDifferentYear_nonEqual() {
        Car mazda = new Car("Mazda", 2020, 1000);
        Car opel = new Car("Opel", 2010, 2000);

        assertTrue(yearComparator.compare(mazda, opel) > 0);
        assertTrue(yearComparator.compare(opel, mazda) < 0);
    }

}
