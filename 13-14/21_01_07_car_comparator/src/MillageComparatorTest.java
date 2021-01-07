import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MillageComparatorTest {
    MillageComparator millageComparator = new MillageComparator();

    @Test
    public void testCompare_carsWithSameMillage_zero() {
        Car mazda = new Car("Mazda", 2020, 1000);
        Car opel = new Car("Opel", 2010, 1000);

        assertEquals(0, millageComparator.compare(mazda, opel));
        assertEquals(0, millageComparator.compare(opel, mazda));
    }

    @Test
    public void testCompare_carsWithDifferentMillage_nonEqual() {
        Car mazda = new Car("Mazda", 2020, 1000);
        Car opel = new Car("Opel", 2010, 2000);

        assertTrue(millageComparator.compare(mazda, opel) < 0);
        assertTrue(millageComparator.compare(opel, mazda) > 0);
    }

}
