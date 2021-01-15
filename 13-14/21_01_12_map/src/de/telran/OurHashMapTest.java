package de.telran;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class OurHashMapTest {

    OurHashMap<String, Auto> map = new OurHashMap<>();


    @Test
    void testPut_resize() {
        OurHashMap<String, Auto> map = new OurHashMap<>(0.5);
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
        assertEquals(map.get("WIN56256"), audi2);
        assertEquals(map.size(), 9);
    }

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
        OurHashMap<String, Auto> map = new OurHashMap<>();
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
        map.put("WIN5628", audi2);
        assertEquals(map.get("WIN5628"), audi2);
        assertNotSame(map.get("WIN5628"), audi);
        assertEquals(map.size(), 7);

        String[] autoWin = {"WIN4528", "WIN56828", "WIN74528", "WIN56628", "WIN56298", "WIN8988", "WIN5628"};
        checkAllElements(map, autoWin);
    }

    void checkAllElements(OurHashMap<String, Auto> mapCheck, String[] arrayStr) {
        for (String elm : arrayStr) {
            // System.out.println(elm);
            assertNotNull(mapCheck.get(elm));
        }
    }

    @Test
    public void testKeyIterator_emptyList() {
        Iterator<String> iterator = map.keyIterator();

        assertFalse(iterator.hasNext());
        assertThrows(IndexOutOfBoundsException.class, () -> {
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
            System.out.println(key);
            assertEquals("WIN4528", key);
        }

        assertThrows(IndexOutOfBoundsException.class, () -> {
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
            System.out.println(iterator.next());
            i++;
        }

        assertEquals(9, map.size());

        assertThrows(IndexOutOfBoundsException.class, () -> {
            iterator.next();
        });
    }

    OurMap<Integer, String> intMap = new OurHashMap<>();

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
              System.out.println(iterator.next());
//            assertEquals(exp[i++], iterator.next());
        }
    }

}
