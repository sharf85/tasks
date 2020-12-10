package de.telran;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class OurArrayListTest {

    OurArrayList<Integer> list = new OurArrayList<>();
    OurArrayList<String> stringList = new OurArrayList<>();

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
    public void testRemoveById_addCapacityNumberElementsAndRemoveLast_correct() {

        for (int i = 0; i < 16; i++) {
            list.addLast(i);
        }

        assertEquals(15, list.removeById(15));
        assertEquals(15, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(15));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(15, 111));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(15));

    }

    @Test
    public void testRemoveById_addCapacityNumberElementsAndRemoveFirst_correct() {

        for (int i = 0; i < 16; i++) {
            list.addLast(i);
        }

        assertEquals(0, list.removeById(0));
        assertEquals(15, list.size());

        for (int i = 0; i < list.size(); i++) {
            assertEquals(1 + i, list.get(i));
        }

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(15));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(15, 111));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(15));
    }

    @Test
    public void testRemoveById_addCapacityNumberElementsAndRemoveIntermediate_correct() {

        for (int i = 0; i < 18; i++) {
            list.addLast(i);
        }

        assertEquals(5, list.removeById(5));
//        {0,1,2,3,4,  6,7,8,9,10,11,12,13,14,15,16,17}

        assertEquals(17, list.size());

        for (int i = 0; i < 5; i++) {
            assertEquals(i, list.get(i));
        }

        for (int i = 5; i < list.size(); i++) {
            assertEquals(i + 1, list.get(i));
        }

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(17));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(17, 111));
        assertThrows(IndexOutOfBoundsException.class, () -> list.removeById(17));
    }

    // TODO test remove zero-indexed element, remove a middle element, test 'set' in different places, 'clear'.
    // TODO test the behavior of the list while adding-removing-adding etc operation.

    @Test
    public void testAddLast_addInitialCapacityPlusOneElements_correctSizAndCapacity() {
        for (int i = 0; i < 17; i++) {
            list.addLast(i);
        }

        assertEquals(17, list.size());
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
    void test_clear_EmptyList() {
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    void test_clear_NonEmptyList() {
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.clear();
        assertEquals(0, list.size());
    }

    @Test
    public void testForwardIterator_emptyList() {
        OurList<String> strings = new OurArrayList<>();
        Iterator<String> iterator = strings.forwardIterator();

        assertFalse(iterator.hasNext());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testForwardIterator_oneElement() {
        String[] expected = {"Evgeny Borisovich"};

        OurList<String> strings = new OurArrayList<>();
        strings.addLast("Evgeny Borisovich");

        Iterator<String> iterator = strings.forwardIterator();

        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(expected[i++], iterator.next());
        }

        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testForwardIterator_severalElements() {
        String[] expected = {"Evgeny", "Borisovich", "Vladislava", "Evgenievna"};

        OurList<String> strings = new OurArrayList<>();
        strings.addLast("Evgeny");
        strings.addLast("Borisovich");
        strings.addLast("Vladislava");
        strings.addLast("Evgenievna");

        Iterator<String> iterator = strings.forwardIterator();

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
        OurList<String> strings = new OurArrayList<>();
        Iterator<String> iterator = strings.backwardIterator();

        assertFalse(iterator.hasNext());
        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testBackwardIterator_oneElement() {
        String[] expected = {"Evgeny Borisovich"};

        OurList<String> strings = new OurArrayList<>();
        strings.addLast("Evgeny Borisovich");

        Iterator<String> iterator = strings.backwardIterator();

        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(expected[i++], iterator.next());
        }

        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testBackwardIterator_severalElements() {
        String[] expected = {"Evgenievna", "Vladislava", "Borisovich", "Evgeny"};

        OurList<String> strings = new OurArrayList<>();
        strings.addLast("Evgeny");
        strings.addLast("Borisovich");
        strings.addLast("Vladislava");
        strings.addLast("Evgenievna");

        Iterator<String> iterator = strings.backwardIterator();

        int i = 0;
        while (iterator.hasNext()) {
            assertEquals(expected[i++], iterator.next());
        }

        assertEquals(4, i);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

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
