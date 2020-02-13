package com.telran.collection;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class OurTreeSetTest {
    private OurTreeSet<Integer> ourTreeSet = new OurTreeSet<>();

    @org.junit.Test
    public void testSize_EmptySet_Zero() {
        assertEquals(0, ourTreeSet.size());
    }

    @org.junit.Test
    public void testAdd_SetWithOneVertex_OneElement() {
        Integer sample = 5;
        ourTreeSet.add(sample);
        assertEquals(1, ourTreeSet.size());
    }

    @org.junit.Test
    public void testAdd_SetWithTreeElements_TreeElement() {
        Integer sample01 = 5;
        Integer sample02 = 1;
        Integer sample03 = 2;
        ourTreeSet.add(sample01);
        ourTreeSet.add(sample02);
        ourTreeSet.add(sample03);
        assertEquals(3, ourTreeSet.size());
    }

    @org.junit.Test
    public void testContains_SetWithTreeElements_True() {
        Integer sample01 = 5;
        Integer sample02 = 1;
        Integer sample03 = 2;
        ourTreeSet.add(sample01);
        ourTreeSet.add(sample02);
        ourTreeSet.add(sample03);
        assertTrue(ourTreeSet.contains(sample01));
    }

    @org.junit.Test
    public void testContains_SetWithTreeElements_False() {
        Integer sample01 = 5;
        Integer sample02 = 1;
        Integer sample03 = 2;
        Integer sample04 = 8;
        ourTreeSet.add(sample01);
        ourTreeSet.add(sample02);
        ourTreeSet.add(sample03);
        assertFalse(ourTreeSet.contains(sample04));
    }

    @org.junit.Test
    public void testRemove_SetThreeElementsWithoutBothChildrenRemoveLastElement_TwoElements() {
        Integer sample01 = 10;
        Integer sample02 = 18;
        Integer sample03 = 19;
        ourTreeSet.add(sample01);
        ourTreeSet.add(sample02);
        ourTreeSet.add(sample03);
        ourTreeSet.remove(sample03);
        assertEquals(2, ourTreeSet.size());
        assertFalse(ourTreeSet.contains(sample03));
    }

    @org.junit.Test
    public void testRemove_SetThreeElementsWithoutBothChildrenRemoveMiddleElement_TwoElements() {
        Integer sample01 = 10;
        Integer sample02 = 18;
        Integer sample03 = 19;
        ourTreeSet.add(sample01);
        ourTreeSet.add(sample02);
        ourTreeSet.add(sample03);
        ourTreeSet.remove(sample02);
        assertEquals(2, ourTreeSet.size());
        assertFalse(ourTreeSet.contains(sample02));
    }

    @org.junit.Test
    public void testRemove_SetThreeElementsWithoutBothChildrenRemoveFirstElement_TwoElements() {
        Integer sample01 = 10;
        Integer sample02 = 18;
        Integer sample03 = 19;
        ourTreeSet.add(sample01);
        ourTreeSet.add(sample02);
        ourTreeSet.add(sample03);
        ourTreeSet.remove(sample01);
        assertEquals(2, ourTreeSet.size());
        assertFalse(ourTreeSet.contains(sample01));
    }

    @org.junit.Test
    public void testRemove_SetFourElementsWithBothChildrenRemoveLastElement_ThreeElements() {
        Integer sample01 = 10;
        Integer sample02 = 18;
        Integer sample03 = 19;
        Integer sample04 = 17;
        ourTreeSet.add(sample01);
        ourTreeSet.add(sample02);
        ourTreeSet.add(sample03);
        ourTreeSet.add(sample04);
        ourTreeSet.remove(sample03);
        assertEquals(3, ourTreeSet.size());
        assertFalse(ourTreeSet.contains(sample03));
    }

    @org.junit.Test
    public void testRemove_SetFourElementsWithBothChildrenRemoveMiddleElement_ThreeElements() {
        Integer sample01 = 10;
        Integer sample02 = 18;
        Integer sample03 = 19;
        Integer sample04 = 17;
        ourTreeSet.add(sample01);
        ourTreeSet.add(sample02);
        ourTreeSet.add(sample03);
        ourTreeSet.add(sample04);
        ourTreeSet.remove(sample02);
        assertEquals(3, ourTreeSet.size());
        assertFalse(ourTreeSet.contains(sample02));
    }

    @org.junit.Test
    public void testRemove_SetFourElementsWithBothChildrenRemoveFirstElement_ThreeElements() {
        Integer sample01 = 10;
        Integer sample02 = 18;
        Integer sample03 = 19;
        Integer sample04 = 17;
        ourTreeSet.add(sample01);
        ourTreeSet.add(sample02);
        ourTreeSet.add(sample03);
        ourTreeSet.add(sample04);
        ourTreeSet.remove(sample01);
        assertEquals(3, ourTreeSet.size());
        assertFalse(ourTreeSet.contains(sample01));
    }

    @org.junit.Test
    public void testAddAll_NonEmptySet_SameElementsWereNotAdded() {
        Integer sample01 = 5;
        Integer sample02 = 10;
        Integer sample03 = 15;
        ourTreeSet.add(sample01);
        ourTreeSet.add(sample02);
        ourTreeSet.add(sample03);
        OurHashSet<Integer> testSet = new OurHashSet<>();
        testSet.add(sample01);
        assertFalse(ourTreeSet.addAll(testSet));
    }

    @org.junit.Test
    public void testAddAll_NonEmptySet_NewElementsWereAdded() {
        Integer sample01 = 5;
        Integer sample02 = 10;
        Integer sample03 = 15;
        Integer sample04 = 20;
        ourTreeSet.add(sample01);
        ourTreeSet.add(sample02);
        OurHashSet<Integer> testSet = new OurHashSet<>();
        testSet.add(sample03);
        testSet.add(sample04);
        assertTrue(ourTreeSet.addAll(testSet));
        assertTrue(ourTreeSet.contains(sample03));
        assertTrue(ourTreeSet.contains(sample04));
        assertEquals(4, ourTreeSet.size());
    }

    @org.junit.Test
    public void testRemoveAll_NonEmptySet_AllSameElementsWereRemoved() {
        Integer sample01 = 5;
        Integer sample02 = 10;
        Integer sample03 = 15;
        Integer sample04 = 20;
        ourTreeSet.add(sample01);
        ourTreeSet.add(sample02);
        ourTreeSet.add(sample03);
        OurHashSet<Integer> testSet = new OurHashSet<>();
        testSet.add(sample01);
        testSet.add(sample04);
        assertTrue(ourTreeSet.removeAll(testSet));
        assertFalse(ourTreeSet.contains(sample01));
        assertTrue(ourTreeSet.contains(sample02));
        assertTrue(ourTreeSet.contains(sample03));
        assertEquals(2, ourTreeSet.size());
    }

    @org.junit.Test
    public void retainAll_NonEmptySetsWithSameElements_SetContainsRetainedElementsOnly() {
        Integer sample01 = 5;
        Integer sample02 = 10;
        Integer sample03 = 15;
        Integer sample04 = 20;
        ourTreeSet.add(sample01);
        ourTreeSet.add(sample02);
        ourTreeSet.add(sample03);
        OurHashSet<Integer> testSet = new OurHashSet<>();
        testSet.add(sample01);
        testSet.add(sample02);
        testSet.add(sample04);
        assertTrue(ourTreeSet.retainAll(testSet));
        assertTrue(ourTreeSet.contains(sample01));
        assertTrue(ourTreeSet.contains(sample02));
        assertFalse(ourTreeSet.contains(sample03));
        assertFalse(ourTreeSet.contains(sample04));
        assertEquals(2, ourTreeSet.size());
    }

    @org.junit.Test
    public void retainAll_NonEmptySetsWithNoElements_SetContainsZeroElementsOnly() {
        Integer sample01 = 5;
        Integer sample02 = 10;
        Integer sample03 = 15;
        ourTreeSet.add(sample01);
        ourTreeSet.add(sample02);
        OurHashSet<Integer> testSet = new OurHashSet<>();
        testSet.add(sample01);
        testSet.add(sample02);
        testSet.add(sample03);
        assertFalse(ourTreeSet.retainAll(testSet));
        assertEquals(2, ourTreeSet.size());
    }
}
