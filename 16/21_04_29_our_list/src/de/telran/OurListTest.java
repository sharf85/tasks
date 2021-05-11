package de.telran;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

abstract class OurListTest {

    OurList<Integer> integerList;
    OurList<String> stringList;

    Integer[] array5element = {2, 4, 6, -6, 10};

    private void fillListFromArray5Elements() {
        for (int a : array5element) {
            integerList.add(a);
        }
    }


    @Test
    void testGet() {
        fillListFromArray5Elements();
        int test = array5element[1]; //4
        assertEquals(test, integerList.get(1));
    }

    @Test
    void testAdd() {
        fillListFromArray5Elements();
        int test = array5element[0]; //2
        assertEquals(5, integerList.size());
        assertTrue(integerList.contains(2));
    }

    @Test
    public void testSize_listOf5Elements() {
        fillListFromArray5Elements();
        assertEquals(5, integerList.size());
    }

    @Test
    void testAdd_onlyNullElement() {
        integerList.add(null);
        assertTrue(integerList.contains(null));
    }

    @Test
    void testAdd_severalElementsAndNullInEnd() {
        fillListFromArray5Elements();
        integerList.add(null);
        assertTrue(integerList.contains(null));
    }

    @Test
    void testAdd_withEmptiness() {
        String test = "";
        stringList.add(test);
        assertTrue(stringList.contains(test));
    }

    @Test
    public void test_throwsIOOBE_inRemoveGetSetMethod() {
        fillListFromArray5Elements();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.get(-3);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.get(integerList.size() + 2);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.set(integerList.size() + 2, 9);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.set(-3, 9);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.remove(-100);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.remove(integerList.size() + 2);
        });
        try {
            integerList.get(-3);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
    }

    @Test
    void testRemove_mitIndex() {
        fillListFromArray5Elements();
        int elm = integerList.get(1);
        assertEquals(elm, integerList.remove(1));
        assertEquals(array5element.length - 1, integerList.size());
        assertFalse(integerList.contains(elm));
    }

    @Test
    void testRemove_firstElementAndLastElement() {
        fillListFromArray5Elements();
        Integer elm = integerList.get(array5element.length - 1);
        assertTrue(integerList.remove(elm));
        assertEquals(array5element.length - 1, integerList.size());
        assertFalse(integerList.contains(elm));

        Integer elm2 = integerList.get(0);
        assertTrue(integerList.remove(elm2));
        assertEquals(array5element.length - 2, integerList.size());
        assertFalse(integerList.contains(elm2));

    }

    @Test
    public void textIterator_zeroElement() {
        Iterator<Integer> it = integerList.iterator();
        assertFalse(it.hasNext());
    }

    @Test
    public void textIterator_severalElements() {
        fillListFromArray5Elements();
        Iterator<Integer> it = integerList.iterator();
        int i = 0;

        while (it.hasNext()) {
            int current = it.next();
            assertEquals(array5element[i], current);
            i++;
        }
        assertEquals(5, i);

    }

    @Test
    public void test_min() {
        fillListFromArray5Elements();
        int min = -6;
        assertEquals(min, integerList.min(new IntegerNaturalComparator()));
    }

    @Test
    public void test_max() {
        fillListFromArray5Elements();
        int max = 10;
        assertEquals(max, integerList.max(new IntegerNaturalComparator()));
    }

    @Test
    public void testSize_newList() {
        assertEquals(0, integerList.size());
    }

    @Test
    public void testAddAndGet_severalElements() {
        integerList.add(-7);
        integerList.add(-17);
        integerList.add(5);

        assertEquals(3, integerList.size());

        assertEquals(-7, integerList.get(0));
        assertEquals(-17, integerList.get(1));
        assertEquals(5, integerList.get(2));
    }

    @Test
    public void testAddAndGet_severalElements_throwsIOOBE() {
        integerList.add(-7);
        integerList.add(-17);
        integerList.add(5);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.get(-3);
        });

        // another way
        try {
            integerList.get(-3);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }

        assertThrows(IndexOutOfBoundsException.class, () -> {
            integerList.get(3);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> integerList.get(-1));
    }

    @Test
    public void testIterator_zeroElements() {
        Iterator<Integer> it = integerList.iterator();
        assertFalse(it.hasNext());
        assertThrows(IndexOutOfBoundsException.class, () -> it.next());
    }

    @Test
    public void testIterator_severalElements() {
        integerList.add(-7);
        integerList.add(-17);
        integerList.add(5);
        integerList.add(8);
        integerList.add(3);

        Iterator<Integer> it = integerList.iterator();

        int[] expected = {-7, -17, 5, 8, 3};
        int i = 0;

        //here we write the code which is the correct way to use iterator
        while (it.hasNext()) {
            int current = it.next();
            assertEquals(expected[i], current);
            i++;
        }
        assertEquals(5, i);
        assertThrows(IndexOutOfBoundsException.class, () -> it.next());
    }

    @Test
    public void testSort_severalElements() {
        integerList.add(-7);
        integerList.add(-17);
        integerList.add(5);
        integerList.add(8);
        integerList.add(3);

        integerList.sort(new IntegerNaturalComparator());
        Iterator<Integer> it = integerList.iterator();

        int[] expected = {-17, -7, 3, 5, 8};
        int i = 0;

        //here we write the code which is the correct way to use iterator
        while (it.hasNext()) {
            int current = it.next();
            assertEquals(expected[i], current);
            i++;
        }
        assertEquals(5, i);
        assertThrows(IndexOutOfBoundsException.class, () -> it.next());
    }

    @Test
    public void testBackwardIterator_severalElements() {
        integerList.add(-7);
        integerList.add(-17);
        integerList.add(5);
        integerList.add(8);
        integerList.add(3);

        Iterator<Integer> it = integerList.backwardIterator();

        int[] expected = {3, 8, 5, -17, -7};
        int i = 0;

        //here we write the code which is the correct way to use iterator
        while (it.hasNext()) {
            int current = it.next();
            assertEquals(expected[i], current);
            i++;
        }
        assertEquals(5, i);
        assertThrows(IndexOutOfBoundsException.class, () -> it.next());
    }

    @Test
    public void testBackwardIterator_zeroElements() {
        Iterator<Integer> it = integerList.backwardIterator();
        assertFalse(it.hasNext());
        assertThrows(IndexOutOfBoundsException.class, () -> it.next());
    }

    @Test
    public void getMinNumber() {
        integerList.add(-7);
        integerList.add(-17);
        integerList.add(5);
        integerList.add(8);
        integerList.add(3);
        int min = integerList.min(new IntegerNaturalComparator());
        assertEquals(min, -17);
    }

    @Test
    public void getMaxNumber() {
        integerList.add(-7);
        integerList.add(-17);
        integerList.add(5);
        integerList.add(8);
        integerList.add(3);
        int max = integerList.max(new IntegerNaturalComparator());
        assertEquals(max, 8);
    }

}
