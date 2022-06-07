package de.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapsMedianElementCollectionTest {

    HeapsMedianElementCollection collection = new HeapsMedianElementCollection();

    @Test
    public void test_1() {
        collection.add(5);
        collection.add(8);
        collection.add(2);
        collection.add(4);
        collection.add(3);
        collection.add(128);
        collection.add(129);
        assertEquals(5, collection.getMedian());
    }

    @Test
    public void test_2() {
        collection.add(5);
        collection.add(8);
        collection.add(2);
        collection.add(4);
        collection.add(3);
        collection.add(128);
        assertEquals(4.5, collection.getMedian());
    }

    @Test
    public void test_3() {
        collection.add(-4);
        collection.add(3);
        collection.add(8);
        collection.add(12);
        collection.add(12);
        collection.add(128);
        assertEquals(10, collection.getMedian());
    }

    @Test
    public void test_4() {
        collection.add(0);
        collection.add(3);
        collection.add(8);
        collection.add(12);
        collection.add(12);
        collection.add(128);
        collection.add(14);
        assertEquals(12, collection.getMedian());
    }
}
