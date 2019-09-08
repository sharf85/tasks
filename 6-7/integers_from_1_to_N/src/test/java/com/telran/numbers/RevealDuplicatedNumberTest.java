package com.telran.numbers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RevealDuplicatedNumberTest {

    private RevealDuplicatedNumber reveler;

    @Before
    public void init() {
        reveler = new RevealDuplicatedNumber();
    }

    @Test
    public void testReveal_NEquals4OneDuplication() {

        assertEquals(reveler.reveal(1, 2, 3, 2), 2);
        assertEquals(reveler.reveal(1, 2, 3, 1), 1);
        assertEquals(reveler.reveal(1, 2, 3, 3), 3);
    }

    @Test
    public void testReveal_NEquals4TwoDuplications() {
        assertTrue(reveler.reveal(1, 2, 1, 2) == 2 || reveler.reveal(1, 2, 1, 2) == 1);
    }

    @Test(expected = WrongInputError.class)
    public void testReveal_WrongNumbers_throwsWrongInputError() {
        reveler.reveal(1, 2, 1, 4);
    }

    @Test(expected = WrongInputError.class)
    public void testReveal_WrongNumbersWithNegative_throwsWrongInputError() {
        reveler.reveal(1, 2, 1, -1);
    }

    @Test(expected = WrongInputError.class)
    public void testReveal_EmptyArray_throwsWrongInputError() {
        reveler.reveal();
    }

}
