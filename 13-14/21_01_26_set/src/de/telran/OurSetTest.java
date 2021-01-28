package de.telran;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class OurSetTest {

    OurSet<Integer> set;
    OurSet<Integer> another;

    @Test
    void add() {

        set.add(1);
        set.add(2);
        set.add(1);

        assertEquals(2, set.size());
        for (int value : set) {

            assertTrue(value == 1 || value == 2);
        }
    }

    @Test
    void remove() {

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        assertFalse(set.remove(9001));
        assertEquals(4, set.size());

        set.remove(1);
        set.remove(2);
        set.remove(3);
        set.remove(4);

        assertFalse(set.remove(-5));
        assertEquals(0, set.size());
    }

    @Test
    void contains() {
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        assertTrue(set.contains(1));
        assertFalse(set.contains(5));
    }

    @Test
    void size() {
        assertEquals(0, set.size());
        set.add(1);
        set.add(2);
        assertEquals(2, set.size());
        set.remove(2);

        assertEquals(1, set.size());
    }

    @Test
    void addAll() {
        set.add(1);
        set.add(3);
        set.add(5);

        another.add(2);
        another.add(3);
        another.add(4);


        set.addAll(another);
        assertEquals(5, set.size());
        assertTrue(set.contains(1));
        assertTrue(set.contains(3));
        assertTrue(set.contains(5));
        assertTrue(set.contains(2));
        assertTrue(set.contains(4));
    }

    @Test
    void retainAll() {
        set.add(1);
        set.add(3);
        set.add(5);

        another.add(2);
        another.add(3);
        another.add(4);

        set.retainAll(another);
        assertTrue(set.contains(3));
        assertEquals(1, set.size());
    }

    @Test
    void removeAll() {
        set.add(1);
        set.add(3);
        set.add(5);

        another.add(2);
        another.add(3);
        another.add(4);

        set.removeAll(another);
        assertTrue(set.contains(1));
        assertTrue(set.contains(5));
        assertEquals(2, set.size());
    }

    @Test
    void iterator() {

        set.add(1);
        set.add(2);
        set.add(3);

        for (int value : set) {
            another.add(value);
        }

        assertEquals(3, another.size());
        assertTrue(another.contains(1));
        assertTrue(another.contains(2));
        assertTrue(another.contains(3));
    }

    @Test
    public void test_add_trueCase_iterator() {
        assertTrue(set.add(5));
        assertEquals(5, set.iterator().next());
    }
    @Test
    public void test_add_falseCase_size() {
        set.add(5);
        assertFalse(set.add(5));
        assertEquals(1, set.size());
    }
    @Test
    public void test_add_severalElements_size() {
        set.add(5);
        set.add(-5);
        set.add(121);
        assertFalse(set.add(5));
        assertFalse(set.add(-5));
        assertFalse(set.add(121));
        assertTrue(set.add(34));
        assertTrue(set.add(0));
        assertEquals(5, set.size());
    }
    @Test
    public void test_remove_falseCase_size() {
        assertFalse(set.remove(2));
        assertEquals(0, set.size());
    }
    @Test
    public void test_remove_trueCase_iterator() {
        set.add(2);
        assertTrue(set.remove(2));
        assertFalse(set.iterator().hasNext());
    }
    @Test
    public void test_add_and_remove_severalElements_size() {
        set.add(5);
        set.add(-5);
        set.add(121);
        assertTrue(set.remove(5));
        assertTrue(set.remove(-5));
        assertFalse(set.remove(-5));
        assertFalse(set.remove(34));
        assertFalse(set.remove(0));
        assertEquals(1, set.size());
    }
    @Test
    public void test_size() {
        for (int i = 0; i < 20; i++) {
            set.add(i);
        }
        assertEquals(20, set.size());
    }
    @Test
    public void test_contains_trueCase() {
        int[] exp = {5, -5, 0};
        for (int i = 0; i < exp.length; i++) {
            set.add(exp[i]);
            assertTrue(set.contains(exp[i]));
        }
    }
    @Test
    public void test_contains_falseCase() {
        int[] exp = {5, -5, 0};
        for (int i = 0; i < exp.length; i++) {
            assertFalse(set.contains(exp[i]));
        }
    }
    @Test
    public void test_addAll_size_contains() {
        another.add(2);
        another.add(-5);
        set.add(101);
        set.add(-86);
        set.addAll(another);
        assertEquals(4, set.size());
        assertTrue(set.contains(2));
        assertTrue(set.contains(-5));
        assertTrue(set.contains(101));
        assertTrue(set.contains(-86));
    }
    @Test
    public void test_retainAll_size_contains() {
        another.add(2);
        another.add(7);
        set.add(7);
        set.add(2);
        set.add(-5);
        set.retainAll(another);
        assertEquals(2, set.size());
        assertTrue(set.contains(2));
        assertTrue(set.contains(7));
        assertFalse(set.contains(101));
        assertFalse(set.contains(-86));
    }
    @Test
    public void test_removeAll_size_contains() {
        another.add(2);
        another.add(-5);
        another.add(7);
        set.add(101);
        set.add(-86);
        set.add(7);
        set.add(2);
        set.removeAll(another);
        assertEquals(2, set.size());
        assertFalse(set.contains(2));
        assertFalse(set.contains(7));
        assertTrue(set.contains(101));
        assertTrue(set.contains(-86));
    }
    @Test
    public void test_keyIterator() {
        for (int i = 0; i < 5; i++) {
            set.add(i);
            set.add(i * 2);
        }
        Iterator<Integer> iterator = set.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            iterator.next();
            i++;
        }
        assertEquals(7, i);
    }
}
