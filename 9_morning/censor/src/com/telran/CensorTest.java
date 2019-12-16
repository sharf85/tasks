package com.telran;

import org.junit.Test;

import static org.junit.Assert.*;

public class CensorTest {

    @Test
    public void testCensor_IsNotLegal_atTheBeginnig() {
        String[] words = {"abc", "cbf", "bca"};
        Censor censor = new Censor(words);
        String text = "abc goes to the House";
        assertFalse(censor.isLegal(text));
    }

    @Test
    public void testCensor_IsNotLegal_atTheEnd() {
        String[] words = {"abc", "cbf", "bca"};
        Censor censor = new Censor(words);
        String text = "The Dog goes to the cbf";
        assertFalse(censor.isLegal(text));
    }

    @Test
    public void testCensor_IsNotLegal_atTheMiddle() {
        String[] words = {"abc", "cbf", "bca"};
        Censor censor = new Censor(words);
        String text = "The Dog cbf bca abc House";
        assertFalse(censor.isLegal(text));
    }

    @Test
    public void testCensor_IsNotLegal_UpperCase() {
        String[] words = {"ABC", "cbf", "BCA"};
        Censor censor = new Censor(words);
        String text = "The Dog CBF bca abc House";
        assertFalse(censor.isLegal(text));
    }

    @Test
    public void testCensor_isLegalTrue() {
        String[] words = {"abc", "cbf", "bca"};
        Censor censor = new Censor(words);
        String text = "The Dog goes to the House";
        assertTrue(censor.isLegal(text));
    }

    @Test
    public void testCensor_isLegalTrue_UpperCase() {
        String[] words = {"ABC", "cbf", "BCA"};
        Censor censor = new Censor(words);
        String text = "The Dog goes to the House";
        assertTrue(censor.isLegal(text));
    }
}