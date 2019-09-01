package com.telran.invert_string;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringInverterTest {

    private StringInverter inverter;

    @Before
    public void init() {
        inverter = new StringInverter();
    }

    @Test
    public void testInvert_EmptyString() {
        assertEquals(inverter.invert(""), "");
    }

    @Test
    public void testInvert_OneLetterWord() {
        assertEquals(inverter.invert("a"), "A");
    }

    @Test
    public void testInvert_SimpleWorld() {
        assertEquals(inverter.invert("Telran"), "tELRAN");
    }

    @Test
    public void testInvert_TwoWordsWithSpace() {
        assertEquals(inverter.invert("Telran Is GrEat"), "tELRAN iS gReAT");
    }

    @Test
    public void testInvert_NonLetterCharacter() {
        assertEquals(inverter.invert("Telran Is GrEat!+5"), "tELRAN iS gReAT!+5");
    }
}
