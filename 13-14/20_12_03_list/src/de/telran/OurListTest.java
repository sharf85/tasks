package de.telran;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public abstract class OurListTest {

    OurList<Integer> list;
    OurList<String> stringList;

    @Test
    public void testSize_emptyList_zero() {
        assertEquals(0, list.size());
    }

    @Test
    public void testGet_emptyList_throwsIOOBE() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(10));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-10));
    }

    @Test
    public void testRemoveById_emptyList_throwsIOOBE() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(10));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(-10));
    }

    @Test
    public void testRemove_singleNotNullElement_removesExisting() {
        stringList.addLast("Kuku");
        String str1 = "kuku";
        String str2 = "kuku";
        String str3 = new String("kuku");
        assertTrue(str1 == str2);
        assertFalse(str1 == str3);

        assertTrue(stringList.remove("Kuku"));
        assertEquals(0, stringList.size());
    }

    @Test
    public void testRemoveById_singleNotNullElement_removesExisting() {
        stringList.addLast("Kuku");

        assertEquals("Kuku", stringList.removeById(0));
        assertEquals(0, stringList.size());
    }

    @Test
    public void testRemoveById_singleNullElement_removesExisting() {
        stringList.addLast(null);

        assertNull(stringList.removeById(0));
        assertEquals(0, stringList.size());
    }

    @Test
    public void testRemove_singleNullElement_removesExisting() {
        stringList.addLast(null);

        assertTrue(stringList.remove(null));
        assertEquals(0, stringList.size());
    }

    @Test
    public void testSet_emptyList_throwsIOOBE() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(0, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(10, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-10, 0));
    }

    @Test
    public void testSizeAndAddLast_addSeveralElements_correctSize() {
        list.addLast(1);
        list.addLast(1);
        list.addLast(1);
        assertEquals(3, list.size());
    }

    @Test
    public void testGetAndAddLast_addSeveralElements_correctOrderOfElements() {
        int[] numbers = {-5, 18, 3, 1, 10, 2, 0, 6};
        for (int number : numbers) {
            list.addLast(number);
        }

        for (int i = 0; i < numbers.length; i++) {
            assertEquals(numbers[i], list.get(i));
        }
    }

    @Test
    public void testRemoveById_addSeveralElementsAndRemoveLast_correct() {
        int[] numbers = {-5, 18, 3, 1, 10, 2, 0, 6};
        for (int number : numbers) {
            list.addLast(number);
        }

        assertEquals(6, list.removeById(7));
        assertEquals(7, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(7));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(7, 111));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(7));
    }

    @Test
    public void testSet_toFirstIndex() {

        addElementsToList(5);
        list.set(0, 100098);

        assertEquals(100098, list.get(0));
    }

    @Test
    public void testSet_toLastIndex() {

        addElementsToList(5);
        list.set(list.size() - 1, 404);

        assertEquals(404, list.get(list.size() - 1));
    }

    @Test
    public void set_To_Index_Between_First_And_Last() {

        int numberOfElements = 20;
        addElementsToList(numberOfElements);

        list.set(17, 30998);

        assertEquals(30998, list.get(17));
    }

    @Test
    public void testClear_emptyList() {
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testClear_nonEmptyList() {
        addElementsToList(20);

        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testUniversal_addSeveralElementsThenSetThenRemove_etc() {
        addElementsToList(4);//{0,1,2,3}

        list.removeById(2);//{0,1,3}
        list.set(1, 5);//{0,5,3}

        list.addLast(-10);//{0,5,3,-10}
        list.addLast(-15);//{0,5,3,-10,-15}

        list.removeById(2);//{0,5,-10,-15}
        list.removeById(0);//{5,-10,-15}

        assertEquals(3, list.size());

        assertEquals(5, list.get(0));
        assertEquals(-10, list.get(1));
        assertEquals(-15, list.get(2));
    }

    @Test
    public void testRemove_RemoveIntermediate_correct() {

        for (int i = 0; i < 16; i++) {
            stringList.addLast("symbol " + i);
        }

        String removeElement = "symbol 5";
        assertTrue(stringList.remove(removeElement));
        assertEquals(15, stringList.size());

        for (int i = 0; i < 5; i++) {
            assertEquals("symbol " + i, stringList.get(i));
        }

        for (int i = 5; i < stringList.size(); i++) {
            assertEquals("symbol " + (i + 1), stringList.get(i));
        }
    }

    @Test
    public void testRemove_RemoveFirst_correct() {

        for (int i = 0; i < 16; i++) {
            stringList.addLast("symbol " + i);
        }

        assertTrue(stringList.remove("symbol 0"));
        assertEquals(15, stringList.size());
        assertEquals("symbol 15", stringList.get(14));

        for (int i = 1; i < stringList.size(); i++) {
            assertEquals("symbol " + (i + 1), stringList.get(i));
        }
    }

    @Test
    public void testRemove_RemoveLast_correct() {

        createStringList(16);

        assertTrue(stringList.remove("symbol P"));
        assertEquals(15, stringList.size());

    }

    @Test
    public void testContains_First_Intermediate_Last_correct() {

        createStringList(16);

        assertTrue(stringList.contains("symbol A"));
        assertTrue(stringList.contains("symbol C"));
        assertTrue(stringList.contains("symbol P"));

    }

    @Test
    public void test_clear_EmptyList() {
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void test_clear_NonEmptyList() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testSort_severalUnsortedNumbers_sorted() {
        list.addLast(15);
        list.addLast(-8);
        list.addLast(3);
        list.addLast(-8);

        // anonymous class
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };

        list.sort(comparator);

        int[] expected = {-8, -8, 3, 15};
        int i = 0;
        for (int num : list) {
            assertEquals(expected[i++], num);
        }

//        list.sort(new IntegerComparator());
    }

//    class IntegerComparator implements Comparator<Integer> {
//
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            return o1 - o2;
//        }
//    }

    @Test
    public void testForwardIterator_emptyList() {
        Iterator<String> iterator = stringList.forwardIterator();

        assertFalse(iterator.hasNext());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testForwardIterator_oneElement() {
        String[] expected = {"Evgeny Borisovich"};

        stringList.addLast("Evgeny Borisovich");

        Iterator<String> iterator = stringList.forwardIterator();

        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(expected[i++], iterator.next());
        }
        assertEquals(1, i);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testForwardIterator_severalElements() {
        String[] expected = {"Evgeny", "Borisovich", "Vladislava", "Evgenievna"};

        stringList.addLast("Evgeny");
        stringList.addLast("Borisovich");
        stringList.addLast("Vladislava");
        stringList.addLast("Evgenievna");

        Iterator<String> iterator = stringList.forwardIterator();

        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(expected[i++], iterator.next());
        }

        assertEquals(4, i);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testIterator_emptyList() {
        Iterator<String> iterator = stringList.iterator();

        assertFalse(iterator.hasNext());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testIterator_oneElement() {
        String[] expected = {"Evgeny Borisovich"};

        stringList.addLast("Evgeny Borisovich");

        Iterator<String> iterator = stringList.iterator();

        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(expected[i++], iterator.next());
        }

        assertEquals(1, i);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testIterator_severalElements() {
        String[] expected = {"Evgeny", "Borisovich", "Vladislava", "Evgenievna"};

        stringList.addLast("Evgeny");
        stringList.addLast("Borisovich");
        stringList.addLast("Vladislava");
        stringList.addLast("Evgenievna");

        Iterator<String> iterator = stringList.iterator();

        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(expected[i++], iterator.next());
        }

        assertEquals(4, i);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testBackwardIterator_emptyList() {
        Iterator<String> iterator = stringList.backwardIterator();

        assertFalse(iterator.hasNext());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testBackwardIterator_oneElement() {
        String[] expected = {"Evgeny Borisovich"};

        stringList.addLast("Evgeny Borisovich");

        Iterator<String> iterator = stringList.backwardIterator();

        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(expected[i++], iterator.next());
        }
        assertEquals(1, i);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testBackwardIterator_severalElements() {
        String[] expected = {"Evgenievna", "Vladislava", "Borisovich", "Evgeny"};

        stringList.addLast("Evgeny");
        stringList.addLast("Borisovich");
        stringList.addLast("Vladislava");
        stringList.addLast("Evgenievna");

        Iterator<String> iterator = stringList.backwardIterator();

        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(expected[i++], iterator.next());
        }

        assertEquals(4, i);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void test_max_severalInt() {
        int[] test = {6, -2, -8, 9, 0, -1, 13};
        for (int i : test) {
            list.addLast(i);
        }
        assertEquals(13, list.max(new IntegerComparator()));
    }

    @Test
    public void test_min_severalInt() {
        int[] test = {6, -2, -8, 9, 0, -1, 13};
        for (int i : test) {
            list.addLast(i);
        }
        assertEquals(-8, list.min(new IntegerComparator()));
    }

    @Test
    public void test_max_emptyList() {
        assertThrows(NoSuchElementException.class, () -> list.max(new IntegerComparator()));
    }

    @Test
    public void test_min_emptyList() {
        assertThrows(NoSuchElementException.class, () -> list.min(new IntegerComparator()));
    }

//    @Test
//    public void test_max_severalString() {
//        String[] expected = {"Evgenievna", "Vladislava", "Borisovich", "Evgeny"};
//
//        stringList.addLast("Evgeny");
//        stringList.addLast("Borisovich");
//        stringList.addLast("Vladislava");
//        stringList.addLast("Evgenievna");
//        assertEquals("Vladislava", stringList.max(new StringComparator()));
//    }

    /**
     * The function fills the list with the numbers from 0 to (number - 1)
     *
     * @param number the amount of numbers to be inserted into the list
     */
    private void addElementsToList(int number) {
        for (int j = 0; j < number; j++) {
            list.addLast(j);
        }
    }

    private void createStringList(int index) {

        String symbol = "symbol ";
        for (char i = 65; i < (65 + index); i++) {
            stringList.addLast(symbol + i);
        }
    }

}

class IntegerComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}
