package de.telran.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class CustomArrayListTest extends CustomListTest {
    @BeforeEach
    public void init() {
        intList = new CustomArrayList<>();
        stringList = new AdvancedArrayList<>();
    }

    @Test
    public void testSort_integers() {
        Integer[] numbers = {15, 10, 17, 5, 6};
        intList.add(15);
        intList.add(10);
        intList.add(17);
        intList.add(5);
        intList.add(6);

        CustomArrayList<Integer> intArrayList = (CustomArrayList<Integer>) intList;
        intArrayList.sort(new NaturalIntComparator());

        int[] expected = {5, 6, 10, 15, 17};

        assertListContents(expected);
    }

    static class NaturalIntComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }
}
