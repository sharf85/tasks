package de.telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OurTreeMapTest extends OurMapTest {

    @BeforeEach
    public void init() {
        map = new OurTreeMap<>();
        intMap = new OurTreeMap<>();
    }

    @Test
    public void testRemoveAdd_severalElements_removeRoot() {
        intMap.put(1, "a");
        intMap.put(2, "b");
        assertEquals(2, intMap.size());
        assertEquals("a", intMap.remove(1));
        assertEquals(1, intMap.size());
        assertEquals("b", intMap.get(2));
    }

    @Test
    public void testRemoveAdd_severalElements_removeRight() {
        intMap.put(1, "a");
        intMap.put(2, "b");
        assertEquals(2, intMap.size());
        assertEquals("b", intMap.remove(2));
        assertEquals(1, intMap.size());
        assertEquals("a", intMap.get(1));
    }

    @Test
    public void testKeyIterator_severalElements_increasing() {
        intMap.put(1, "a");
        intMap.put(-10, "b");
        intMap.put(5, "b");
        intMap.put(3, "b");
        intMap.put(-5, "b");
        intMap.put(2, "b");

        List<Integer> expected = Arrays.asList(-10, -5, 1, 2, 3, 5);

        List<Integer> actual = new ArrayList<>();

        Iterator<Integer> keyIterator = intMap.keyIterator();
        while (keyIterator.hasNext())
            actual.add(keyIterator.next());

        assertEquals(expected, actual);
    }

    @Test
    public void testKeyIterator_severalElements_rootToTheLeft() {
        intMap.put(-10, "b");
        intMap.put(-5, "b");
        intMap.put(1, "a");
        intMap.put(2, "b");
        intMap.put(3, "b");
        intMap.put(5, "b");

        List<Integer> expected = Arrays.asList(-10, -5, 1, 2, 3, 5);

        List<Integer> actual = new ArrayList<>();

        Iterator<Integer> keyIterator = intMap.keyIterator();
        while (keyIterator.hasNext())
            actual.add(keyIterator.next());

        assertEquals(expected, actual);
    }

    //TODO implement and write tests for value iterator

}
