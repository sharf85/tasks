package de.telran.list;

import de.telran.CustomOutOfBoundsException;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

abstract class CustomListTest {
    CustomList<Integer> intList;
    CustomList<String> stringList;

    @Test
    public void testAddSize_threeNumbers() {
        intList.add(20);
        intList.add(10);
        intList.add(-5);

        assertEquals(3, intList.size());
    }

    @Test
    public void testAddSize_9Numbers() {
        intList.add(20);
        intList.add(10);
        intList.add(-5);
        intList.add(-5);
        intList.add(-5);
        intList.add(-5);
        intList.add(-5);
        intList.add(-5);
        intList.add(-5);

        assertEquals(9, intList.size());
    }

    @Test
    public void testAddGet_threeNumbers() {
        intList.add(20);
        intList.add(10);
        intList.add(-5);

        assertEquals(20, intList.get(0));
        assertEquals(10, intList.get(1));
        assertEquals(-5, intList.get(2));
    }

    @Test
    public void testAddGet_100RandomNumbers() {
        int[] randomNumbers = generateRandomNumbers(100);

        for (int i = 0; i < randomNumbers.length; i++) {
            intList.add(randomNumbers[i]);
        }

        assertListContents(randomNumbers);
    }

    private void assertListContents(int[] array) {
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], intList.get(i));
        }
    }

    private int[] generateRandomNumbers(int n) {
        int[] res = new int[n];
        Random rnd = new Random();

        for (int i = 0; i < n; i++) {
            res[i] = rnd.nextInt();
        }

        return res;
    }

    @Test
    public void testContains_severalNumbers_true() {
        intList.add(20);
        intList.add(10);
        intList.add(-5);

        assertTrue(intList.contains(10));
        assertTrue(intList.contains(20));
        assertTrue(intList.contains(-5));
    }

    @Test
    public void testContains_severalNumbers_false() {
        intList.add(20);
        intList.add(10);
        intList.add(-5);

        assertFalse(intList.contains(15));
    }

    @Test
    public void testSet_emptyList_throwsCustomOutOfBoundsException() {
        assertThrows(CustomOutOfBoundsException.class, () -> {
            intList.set(0, 10);
        });
    }

    @Test
    public void testGet_emptyList_throwsCustomOutOfBoundsException() {
        assertThrows(CustomOutOfBoundsException.class, () -> {
            intList.get(0);
        });
    }

    @Test
    public void testRemoveById_emptyList_throwsCustomOutOfBoundsException() {
        assertThrows(CustomOutOfBoundsException.class, () -> {
            intList.removeById(0);
        });
    }

    @Test
    public void testInsert_emptyListIndex0() {
        intList.insert(0, 5);

        assertEquals(1, intList.size());
        assertEquals(5, intList.get(0));
    }

    @Test
    public void testInsert_nonEmptyLastIndex() {
        intList.add(5);
        intList.add(10);
        intList.add(-8);

        intList.insert(3, 25);

        assertEquals(4, intList.size());
        assertListContents(new int[]{5, 10, -8, 25});
    }

    @Test
    public void testInsert_nonEmptyZeroIndex() {
        intList.add(5);
        intList.add(10);
        intList.add(-8);

        intList.insert(0, 25);

        assertEquals(4, intList.size());
        assertListContents(new int[]{25, 5, 10, -8});
    }

    @Test
    public void testInsert_nonEmptyMiddleIndex() {
        intList.add(5);
        intList.add(10);
        intList.add(-8);

        intList.insert(2, 25);

        assertEquals(4, intList.size());
        assertListContents(new int[]{5, 10, 25, -8});
    }

    @Test
    public void testRemoveById_idTwo() {
        intList.add(1);
        intList.add(3);
        intList.add(3);
        intList.add(4);

        assertEquals(3, intList.removeById(2));

        assertListContents(new int[]{1, 3, 4});

    }

    @Test
    public void testRemoveById_idThree() {
        intList.add(1);
        intList.add(3);
        intList.add(3);
        intList.add(4);

        assertEquals(4, intList.removeById(3));
        assertEquals(3, intList.size());

        assertListContents(new int[]{1, 3, 3});
    }

    @Test
    public void testRemoveById_idZero() {
        intList.add(1);
        intList.add(3);
        intList.add(3);
        intList.add(4);

        assertEquals(1, intList.removeById(0));
        assertEquals(3, intList.size());
        assertListContents(new int[]{3, 3, 4});
    }

    @Test
    public void testRemoveById_idTwFour() {
        intList.add(1);
        intList.add(3);
        intList.add(3);
        intList.add(4);

        assertThrows(CustomOutOfBoundsException.class, () -> intList.removeById(4));
    }

    //remove by Value
    @Test
    public void testRemoveByValue_one() {
        intList.add(1);
        intList.add(3);
        intList.add(3);
        intList.add(4);

        assertTrue(intList.removeByValue(1));
        assertEquals(3, intList.size());
        assertListContents(new int[]{3, 3, 4});
    }

    @Test
    public void testRemoveByValue_three() {
        intList.add(1);
        intList.add(3);
        intList.add(3);
        intList.add(4);

        assertTrue(intList.removeByValue(3));
        assertEquals(3, intList.size());
        assertListContents(new int[]{1, 3, 4});
    }

    @Test
    public void testRemoveByValue_twoFalse() {
        intList.add(1);
        intList.add(3);
        intList.add(3);
        intList.add(4);

        assertFalse(intList.removeByValue(2));
        assertEquals(4, intList.size());
    }

    @Test
    public void testIterator_severalElements() {
        intList.add(10);
        intList.add(15);
        intList.add(7);
        intList.add(20);
        intList.add(12);

        int[] expected = {10, 15, 7, 20, 12};

        Iterator<Integer> iterator = intList.iterator();

        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(expected[i], iterator.next());
            i++;
        }
        assertEquals(5, i);
    }

}
