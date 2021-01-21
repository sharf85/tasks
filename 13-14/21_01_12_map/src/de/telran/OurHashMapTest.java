package de.telran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OurHashMapTest extends OurMapTest {
    @BeforeEach
    public void init() {
        map = new OurHashMap<>();
        intMap = new OurHashMap<>();
    }

    @Test
    void testPut_resize() {
        map = new OurHashMap<>(0.5);
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

}
