package com.telran.collection;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class OurTreeSetIteratorTest {

    private OurTreeSet<Integer> ourSetTree = new OurTreeSet<>();

    @Test
    public void testHasNext_EmptySet_False() {
        OurTreeSetIterator<Integer> test = new OurTreeSetIterator<>(ourSetTree);
        assertFalse(test.hasNext());
    }

    @Test
    public void testNext_NonEmptySetTree_IncreasingNumberOrder() {
        Integer sample01 = 10;
        Integer sample02 = 8;
        Integer sample03 = 15;
        Integer sample04 = 13;
        Integer sample05 = 14;
        ourSetTree.add(sample01);
        ourSetTree.add(sample02);
        ourSetTree.add(sample03);
        ourSetTree.add(sample04);
        ourSetTree.add(sample05);
        int[] expected = {8, 10, 13, 14, 15};
        OurTreeSetIterator<Integer> test = new OurTreeSetIterator<>(ourSetTree);

        int i = 0;
        while (test.hasNext()) {
            Integer num = test.next();
            assertEquals(expected[i++], (long) num);
        }

        assertEquals(5, i);
    }
} 