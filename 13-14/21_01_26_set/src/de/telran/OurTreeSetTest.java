package de.telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OurTreeSetTest extends OurSetTest {
    @BeforeEach
    public void init() {
        set = new OurTreeSet<>();
        another = new OurTreeSet<>();
    }

    @Test
    public void test_keyIterator_correctOrder() {
        set.add(33);
        set.add(-5);
        set.add(0);
        set.add(12);
        Iterator<Integer> iterator = set.iterator();
        ArrayList<Integer> exp = new ArrayList<>();
        Collections.addAll(exp, -5, 0, 12, 33);
        ArrayList<Integer> actual = new ArrayList<>();

        while (iterator.hasNext()) {
            actual.add((Integer) iterator.next());
        }
        assertEquals(exp, actual);
    }
}
