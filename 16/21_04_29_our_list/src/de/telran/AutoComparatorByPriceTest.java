package de.telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AutoComparatorByPriceTest {
    AutoComparatorByPrice comparator;

    @BeforeEach
    public void init() {
        comparator = new AutoComparatorByPrice();
    }

    @Test
    public void testEqual() {
        Auto a1 = new Auto("Audi", "black", 120);
        Auto a2 = new Auto("BMW", "white", 120);
        int result = comparator.compare(a1, a2);
        assertEquals(0, result);
    }

    @Test
    public void testGreater() {
        Auto a1 = new Auto("Audi", "black", 180);
        Auto a2 = new Auto("BMW", "white", 160);
        int result = comparator.compare(a1, a2);
        assertTrue(result > 0);
    }

    @Test
    public void testLess() {
        Auto a1 = new Auto("Audi", "black", 120);
        Auto a2 = new Auto("BMW", "white", 160);
        int result = comparator.compare(a1, a2);
        assertTrue(result < 0);
    }

    @Test
    public void compare() {
        Auto a1 = new Auto("Audi", "black", 120);
        Auto a2 = new Auto("BMW", "white", 80);
        Auto a3 = new Auto("Toyota", "blue", 210);
        Auto a4 = new Auto("Opel", "black", 60);
        Auto a5 = new Auto("Honda", "grey", 100);
        Auto[] autos = {a1, a2, a3, a4, a5};

        Arrays.sort(autos, comparator);
        assertEquals((int) autos[0].getPrice(), 60);
        assertEquals((int) autos[1].getPrice(), 80);
        assertEquals((int) autos[2].getPrice(), 100);
        assertEquals((int) autos[3].getPrice(), 120);
        assertEquals((int) autos[4].getPrice(), 210);

    }
}
