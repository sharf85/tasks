package de.telran;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {
    Map<String, Auto> map = new HashMap<>();

    @Test
    void changeTheValueOofAnExistingElement() {

        Auto audi = new Auto("blue", "Audi");
        Auto audi2 = new Auto("braun", "Audi");

        map.put("WIN5628", audi);
        map.put("WIN5628", audi2);
        assertEquals(map.get("WIN5628"), audi2);
        assertNotSame(map.get("WIN5628"), audi);
        assertEquals(map.size(), 1);
    }

    @Test
    void testRemove_twoObjectInCells_bottom() {
        Auto opel = new Auto("grey", "Opel");
        Auto mazda = new Auto("red", "Mazda");
        Auto bmw = new Auto("black", "BMW");
        Auto audi = new Auto("blue", "Audi");
        Auto audi2 = new Auto("braun", "Audi");

        map.put("WIN4528", opel);
        map.put("WIN74528", opel);
        map.put("WIN56828", mazda);
        map.put("WIN56628", mazda);
        map.put("WIN56298", mazda);
        map.put("WIN8988", bmw);
        map.put("WIN8989", bmw);
        map.put("WIN5628", audi);
        map.put("WIN56256", audi2);
        assertEquals(map.remove("WIN8989"), bmw);
        assertEquals(map.get("WIN74528"), opel);
        assertEquals(map.size(), 8);
        String[] autoWin = {"WIN4528", "WIN56828", "WIN74528", "WIN56628", "WIN56298", "WIN8988", "WIN5628", "WIN56256"};
        checkAllElements(map, autoWin);
    }

    @Test
    void testRemove_OneElement() {
        Auto opel = new Auto("grey", "Opel");
        Auto mazda = new Auto("red", "Mazda");
        Auto bmw = new Auto("black", "BMW");
        Auto audi = new Auto("blue", "Audi");
        Auto audi2 = new Auto("braun", "Audi");

        map.put("WIN4528", opel);
        map.put("WIN74528", opel);
        map.put("WIN56828", mazda);
        map.put("WIN56628", mazda);
        map.put("WIN56298", mazda);
        map.put("WIN8988", bmw);
        map.put("WIN8989", bmw);
        map.put("WIN5628", audi);
        map.put("WIN56256", audi2);

        assertEquals(map.remove("WIN8988"), bmw);
        assertNull(map.get("WIN8988"));
        assertEquals(map.size(), 8);
        String[] autoWin = {"WIN4528", "WIN56828", "WIN74528", "WIN56628", "WIN56298", "WIN8989", "WIN5628", "WIN56256"};
        checkAllElements(map, autoWin);
    }

    @Test
    void testRemove_twoObjectInCells_UpElement() {
        Auto opel = new Auto("grey", "Opel");
        Auto mazda = new Auto("red", "Mazda");
        Auto bmw = new Auto("black", "BMW");
        Auto audi = new Auto("blue", "Audi");
        Auto audi2 = new Auto("braun", "Audi");

        map.put("WIN4528", opel);
        map.put("WIN74528", opel);
        map.put("WIN56828", mazda);
        map.put("WIN56628", mazda);
        map.put("WIN56298", mazda);
        map.put("WIN8988", bmw);
        map.put("WIN8989", bmw);
        map.put("WIN5628", audi);
        map.put("WIN56256", audi2);
        assertEquals(map.remove("WIN74528"), opel);
        assertEquals(map.get("WIN8989"), bmw);
        assertEquals(map.size(), 8);

        String[] autoWin = {"WIN4528", "WIN56828", "WIN56628", "WIN56298", "WIN8988", "WIN8989", "WIN5628", "WIN56256"};
        checkAllElements(map, autoWin);
    }

    @Test
    void put_changeElement() {

        Auto opel = new Auto("grey", "Opel");
        Auto mazda = new Auto("red", "Mazda");
        Auto bmw = new Auto("black", "BMW");
        Auto bmw1 = new Auto("pink", "BMW");
        Auto audi = new Auto("blue", "Audi");
        Auto audi2 = new Auto("braun", "Audi");

        map.put("WIN4528", opel);
        map.put("WIN8988", bmw);
        map.put("WIN8988", bmw1);
        assertEquals(map.get("WIN8988"), bmw1);
        assertNotSame(map.get("WIN8988"), bmw);


        map.put("WIN74528", opel);
        map.put("WIN56828", mazda);
        map.put("WIN56628", mazda);
        map.put("WIN56298", mazda);

        map.put("WIN5628", audi);
        assertEquals(audi, map.put("WIN5628", audi2));
        assertEquals(map.get("WIN5628"), audi2);
        assertNotSame(map.get("WIN5628"), audi);
        assertEquals(map.size(), 7);

        String[] autoWin = {"WIN4528", "WIN56828", "WIN74528", "WIN56628", "WIN56298", "WIN8988", "WIN5628"};
        checkAllElements(map, autoWin);
    }

    void checkAllElements(Map<String, Auto> mapCheck, String[] arrayStr) {
        for (String elm : arrayStr) {
            // System.out.println(elm);
            assertNotNull(mapCheck.get(elm));
        }
    }

    @Test
    public void testKeyIterator_emptyList() {
        Iterator<String> iterator = map.keyIterator();

        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testKeyIterator_oneElement() {

        Auto opel = new Auto("grey", "Opel");
        map.put("WIN4528", opel);

        Iterator<String> iterator = map.keyIterator();

        int i = 0;
        while (iterator.hasNext()) {
            String key = iterator.next();
            assertEquals("WIN4528", key);
            i++;
        }

        assertEquals(1, i);

        assertThrows(NoSuchElementException.class, () -> {
            iterator.next();
        });
    }

    @Test
    public void testForwardIterator_severalElements() {
        Auto opel = new Auto("grey", "Opel");
        Auto mazda = new Auto("red", "Mazda");
        Auto bmw = new Auto("black", "BMW");
        Auto audi = new Auto("blue", "Audi");
        Auto audi2 = new Auto("braun", "Audi");

        map.put("WIN4528", opel);
        map.put("WIN74528", opel);
        map.put("WIN56828", mazda);
        map.put("WIN56628", mazda);
        map.put("WIN56298", mazda);
        map.put("WIN8988", bmw);
        map.put("WIN8989", bmw);
        map.put("WIN5628", audi);
        map.put("WIN56256", audi2);

        Iterator<String> iterator = map.keyIterator();

        int i = 0;
        while (iterator.hasNext()) {
            iterator.next();
            i++;
        }

        assertEquals(9, i);

        assertThrows(NoSuchElementException.class, () -> {
            iterator.next();
        });
    }

    Map<Integer, String> intMap = new HashMap<>();

    @Test
    public void test_keyIterator() {
        for (int i = 0; i < 5; i++) {
            intMap.put(i, "aaa");
            intMap.put(i * 2, "bbb");
        }
        Iterator<Integer> iterator = intMap.keyIterator();
        int[] exp = {0, 1, 2, 3, 4, 6, 8};
        int i = 0;
        while (iterator.hasNext()) {
            iterator.next();
            i++;
//            assertEquals(exp[i++], iterator.next());
        }

        assertEquals(7, i);
    }

    @Test
    public void testSizePut_emptyObject_newElements() {
        intMap.put(3, "f");
        intMap.put(2, "b");
        intMap.put(1, "c");
        assertEquals(3, intMap.size());
    }

    @Test
    public void testSizePut_emptyObject_noElements() {
        assertEquals(0, intMap.size());
    }

    @Test
    public void testSizePut_NotEmptyObject_notExistKey() {
        intMap.put(1, "a");
        intMap.put(2, "b");
        intMap.put(3, "c");
        assertEquals(3, intMap.size());
        intMap.put(4, "d");
        assertEquals(4, intMap.size());
    }

    @Test
    public void testSizePut_NotEmptyObject_existKey() {
        intMap.put(1, "a");
        intMap.put(2, "b");
        intMap.put(3, "c");
        assertEquals(3, intMap.size());
        intMap.put(2, "d");
        assertEquals(3, intMap.size());
    }

    @Test
    public void testGetContains_NotEmptyObject_existKey() {
        intMap.put(1, "a");
        intMap.put(2, "b");
        intMap.put(3, "c");
        assertEquals("b", intMap.get(2));
        assertEquals("a", intMap.get(1));
        assertEquals("c", intMap.get(3));
    }

    @Test
    public void testGetContains_NotEmptyObject_notExistKey() {
        intMap.put(1, "a");
        intMap.put(2, "b");
        intMap.put(3, "c");
        assertNull(intMap.get(5));
    }

    @Test
    public void testGetContains_emptyObject_notExistKey() {
        assertNull(intMap.remove(5));
    }

    @Test
    public void testRemove_NotEmptyObject_existKey() {
        intMap.put(1, "a");
        intMap.put(2, "b");
        intMap.put(3, "c");
        assertEquals(3, intMap.size());
        intMap.remove(2);
        assertEquals(2, intMap.size());
        assertNull(intMap.get(2));
    }

    @Test
    public void testRemove_NotEmptyObject_notExistKey() {
        intMap.put(1, "a");
        intMap.put(2, "b");
        intMap.put(3, "c");
        assertEquals(3, intMap.size());
        assertNull(intMap.remove(5));
        assertEquals(3, intMap.size());
        assertNull(intMap.get(5));
    }

    @Test
    public void testRemove_OneElement_exist() {
        intMap.put(1, "a");
        assertEquals("a", intMap.remove(1));
        assertEquals(0, intMap.size());
        assertNull(intMap.get(5));
    }

    @Test
    void test_contains_trueCase() {
        intMap.put(666, "@");
        assertTrue(intMap.contains(666));
    }

    @Test
    void test_contains_falseCase() {
        assertFalse(intMap.contains(666));
    }

}
