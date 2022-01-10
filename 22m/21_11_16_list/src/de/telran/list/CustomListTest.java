package de.telran.list;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

abstract class CustomListTest {
    CustomList<Integer> intList;
    CustomList<String> stringList;

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
    public void testInsert_emptyList_throwsCustomOutOfBoundsException() {
        assertThrows(CustomOutOfBoundsException.class, () -> {
            intList.insert(1, 10);
        });
    }

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
    }

    @Test
    public void testContains_severalNumbers_false() {
        intList.add(20);
        intList.add(10);
        intList.add(-5);

        assertFalse(intList.contains(15));
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
        assertListContents(new int[]{1, 3, 3});
    }

    @Test
    public void testRemoveById_idZero() {
        intList.add(1);
        intList.add(3);
        intList.add(3);
        intList.add(4);

        assertEquals(1, intList.removeById(0));
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
        assertListContents(new int[]{3, 3, 4});
    }

    @Test
    public void testRemoveByValue_three() {
        intList.add(1);
        intList.add(3);
        intList.add(3);
        intList.add(4);

        assertTrue(intList.removeByValue(3));
        assertListContents(new int[]{1, 3, 4});
    }

    @Test
    public void testRemoveByValue_twoFalse() {
        intList.add(1);
        intList.add(3);
        intList.add(3);
        intList.add(4);

        assertFalse(intList.removeByValue(2));
    }

    @Test
    public void testInsert_emptyListZeroIndex() {
        intList.insert(0, 10);

        assertEquals(1, intList.size());

        assertListContents(new int[]{10});
    }

    @Test
    public void testInsert_nonEmptyListZeroIndex() {
        intList.add(10);
        intList.insert(0, 15);

        assertEquals(2, intList.size());
        assertListContents(new int[]{15, 10});
    }

    @Test
    public void testInsert_nonEmptyListSizeIndex() {
        intList.add(10);
        intList.insert(1, 15);

        assertEquals(2, intList.size());
        assertListContents(new int[]{10, 15});
    }

    @Test
    public void testInsert_nonEmptyListMiddleIndex() {
        intList.add(10);
        intList.add(18);
        intList.insert(1, 15);

        assertEquals(3, intList.size());
        assertListContents(new int[]{10, 15, 18});
    }

    @Test
    public void testInsert_emptyListNonZeroIndex_throwsCustomOutOfBoundsException() {
        assertThrows(CustomOutOfBoundsException.class, () -> intList.insert(1, 10));
        assertThrows(CustomOutOfBoundsException.class, () -> intList.insert(-1, 10));
    }

    @Test
    public void testAddSize_fourStrings() {
        stringList.add("If you always try your best");
        stringList.add("Then you’ll never have to wonder");
        stringList.add("About what you could have done");
        stringList.add("If you’d summoned all your thunder.");

        assertEquals(4, stringList.size());
    }

    @Test
    public void testAddSize_tenStrings() {
        stringList.add("If you always try your best");
        stringList.add("Then you’ll never have to wonder");
        stringList.add("About what you could have done");
        stringList.add("If you’d summoned all your thunder.");
        stringList.add("And if your best");
        stringList.add("Was not as good");
        stringList.add("As you hoped it would be,");
        stringList.add("You still could say,");
        stringList.add("I gave today");
        stringList.add("All that I had in me.");

        assertEquals(10, stringList.size());
    }

    //   public void testAddGet_100RandomNumbers() { // unlikely with strings

    @Test
    public void testContains_string_true() {
        stringList.add("stop");
        stringList.add("stopping");
        stringList.add("yourself");

        assertTrue(stringList.contains("stop"));
    }

    @Test
    public void testContains_string_false() {
        stringList.add("stop");
        stringList.add("stopping");
        stringList.add("yourself");

        assertFalse(stringList.contains("best"));
    }

    @Test
    public void testSet_emptyStringList_throwsCustomOutOfBoundsException() {
        assertThrows(CustomOutOfBoundsException.class, () -> {
            stringList.set(5, "next");
        });
    }

    @Test
    public void testGet_emptyStringList_throwsCustomOutOfBoundsException() {
        assertThrows(CustomOutOfBoundsException.class, () -> {
            stringList.get(0);
        });
    }

    @Test
    public void testRemoveById_emptyStringList_throwsCustomOutOfBoundsException() {
        assertThrows(CustomOutOfBoundsException.class, () -> {
            stringList.removeById(0);
        });
    }

    private void assertStringListContents(String[] array) {
        for (int i = 0; i < array.length; i++) {
            assertEquals(array[i], stringList.get(i));
        }
    }

    @Test
    public void testInsert_emptyStringListIndex0() {
        stringList.insert(0, "aaa");

        assertEquals(1, stringList.size());
        assertEquals("aaa", stringList.get(0));
    }

    @Test
    public void testInsert_nonEmptyLastStringIndex() {
        stringList.add("No reason");
        stringList.add("to stay");
        stringList.add("is a good reason");
        stringList.add("to go");

        stringList.insert(4, "sounds like a plan");

        assertEquals(5, stringList.size());
        assertStringListContents(new String[]{"No reason", "to stay", "is a good reason", "to go", "sounds like a plan"});
    }

    @Test
    public void testInsert_nonEmptyZeroStringIndex() {
        stringList.add("One day");
        stringList.add("At a Time");

        stringList.insert(0, "It is ok");

        assertEquals(3, stringList.size());
        assertStringListContents(new String[]{"It is ok", "One day", "At a Time"});
    }

    @Test
    public void testInsertString_nonEmptyMiddleIndex() {
        stringList.add("Life");
        stringList.add("is");
        stringList.add("short");

        stringList.insert(2, "too");

        assertEquals(4, stringList.size());
        assertStringListContents(new String[]{"Life", "is", "too", "short"});
    }

    @Test
    public void testRemoveStringById_idTwo() {
        stringList.add("Life");
        stringList.add("is");
        stringList.add("too");
        stringList.add("short");

        assertEquals("too", stringList.removeById(2));

        assertStringListContents(new String[]{"Life", "is", "short"});

    }

    @Test
    public void testRemoveStringById_idThree() {
        stringList.add("food");
        stringList.add("water");
        stringList.add("sleep");
        stringList.add("play");

        assertEquals("play", stringList.removeById(3));
        assertEquals(3, stringList.size());

        assertStringListContents(new String[]{"food", "water", "sleep"});
    }

    @Test
    public void testRemoveStringById_idZero() {
        stringList.add("play");
        stringList.add("food");
        stringList.add("water");
        stringList.add("sleep");

        assertEquals("play", stringList.removeById(0));
        assertEquals(3, stringList.size());

        assertStringListContents(new String[]{"food", "water", "sleep"});
    }

    @Test
    public void testRemoveStringById_idTwFour() {
        stringList.add("play");
        stringList.add("food");
        stringList.add("water");
        stringList.add("sleep");

        assertThrows(CustomOutOfBoundsException.class, () -> stringList.removeById(4));
    }

    @Test
    public void testRemoveStringByValue_play() {
        stringList.add("play");
        stringList.add("food");
        stringList.add("water");
        stringList.add("sleep");

        assertTrue(stringList.removeByValue("play"));
        assertEquals(3, stringList.size());

        assertStringListContents(new String[]{"food", "water", "sleep"});
    }

    @Test
    public void testRemoveStringByValue_loveFalse() {
        stringList.add("play");
        stringList.add("food");
        stringList.add("water");
        stringList.add("sleep");

        assertFalse(stringList.removeByValue("love"));
        assertEquals(4, stringList.size());
    }

    @Test
    public void testIterator_severalElements() {
        intList.add(5);
        intList.add(10);
        intList.add(2);
        intList.add(25);
        intList.add(6);

        int[] expected = {5, 10, 2, 25, 6};

        Iterator<Integer> iterator = intList.iterator();

        int i = 0;
        while (iterator.hasNext()) {
            int currentNumber = iterator.next();
            assertEquals(expected[i], currentNumber);
            i++;
        }
        assertEquals(i, expected.length);

    }

    @Test
    public void testIterator_oneElement() {
        intList.add(5);
        Iterator<Integer> iterator = intList.iterator();

        int first = iterator.next();

        assertEquals(5, first);
        assertFalse(iterator.hasNext());

    }

    @Test
    public void testIterator_noElements() {
        Iterator<Integer> iterator = intList.iterator();
        assertFalse(iterator.hasNext());
    }

}
