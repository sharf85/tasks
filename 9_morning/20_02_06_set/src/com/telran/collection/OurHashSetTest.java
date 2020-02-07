package com.telran.collection;

import org.junit.Test;

import static org.junit.Assert.*;

public class OurHashSetTest {
    @Test
    public void size_returns_number_of_elemnts_in_set() {
        OurSet<Integer> set = new OurHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(3);
        set.add(2);
        assertEquals(3, set.size());

    }

    @Test
    public void add_returns_changed_for_new_element() {
        OurSet<Integer> set = new OurHashSet<>();
        boolean result = set.add(1);
        assertTrue(result);
    }

    @Test
    public void add_returns_unchanged_for_existing_element() {
        OurSet<Integer> set = new OurHashSet<>();
        set.add(1);
        boolean result = set.add(1);
        assertFalse(result);
    }

    @Test
    public void remove_returns_changed_for_existing_element() {
        OurSet<Integer> set = new OurHashSet<>();
        set.add(1);
        boolean result = set.remove(1);
        assertTrue(result);
    }

    @Test
    public void remove_returns_unchanged_for_new_element() {
        OurSet<Integer> set = new OurHashSet<>();
        set.add(1);
        boolean result = set.remove(2);
        assertFalse(result);
    }

    @Test
    public void contains_returns_true_for_existing_element() {
        OurSet<Integer> set = new OurHashSet<>();
        set.add(1);
        boolean contains = set.contains(1);
        assertTrue(contains);
    }

    @Test
    public void contains_returns_false_for_nonexisting_element() {
        OurSet<Integer> set = new OurHashSet<>();
        set.add(1);
        boolean contains = set.contains(2);
        assertFalse(contains);
    }

    @Test
    public void addAll_updates_set_with_element_from_other() {
        OurSet<Integer> set = new OurHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        OurSet<Integer> otherSet = new OurHashSet<>();
        otherSet.add(1);
        otherSet.add(4);
        otherSet.add(5);

        Integer[] expected = {1, 2, 3, 4, 5};

        set.addAll(otherSet);

        assertEquals(set.size(), expected.length);
        for (Integer element : expected) {
            assertTrue(set.contains(element));
        }
    }

    @Test
    public void removeAll_removes_elemnts_that_are_in_other_set() {
        OurSet<Integer> set = new OurHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        OurSet<Integer> otherSet = new OurHashSet<>();
        otherSet.add(1);
        otherSet.add(2);
        otherSet.add(4);
        otherSet.add(5);

        Integer[] expected = {3};

        set.removeAll(otherSet);

        assertEquals(set.size(), expected.length);
        for (Integer element : expected) {
            assertTrue(set.contains(element));
        }
    }

    @Test
    public void retainAll_keeps_only_elements_that_are_in_other_set() {
        OurSet<Integer> set = new OurHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        OurSet<Integer> otherSet = new OurHashSet<>();
        otherSet.add(1);
        otherSet.add(5);
        otherSet.add(4);
        otherSet.add(2);

        Integer[] expected = {1, 2};

        boolean res = set.retainAll(otherSet);

        assertEquals(set.size(), expected.length);
        assertTrue(res);
        for (Integer element : expected) {
            assertTrue(set.contains(element));
        }
    }

    @Test
    public void retainAll_firstSetIsPlacedInOther() {
        OurSet<Integer> set = new OurHashSet<>();
        set.add(1);
        set.add(2);

        OurSet<Integer> otherSet = new OurHashSet<>();
        otherSet.add(1);
        otherSet.add(5);
        otherSet.add(4);
        otherSet.add(2);

        Integer[] expected = {1, 2};

        boolean res = set.retainAll(otherSet);

        assertEquals(expected.length, set.size());
        assertFalse(res);
        for (Integer element : expected) {
            assertTrue(set.contains(element));
        }
    }
}