package com.telran;

import org.junit.Test;

import static org.junit.Assert.*;

public class CensorTest {

    @Test
    public void isLegal_returns_false() {
        Censor censor = new Censor(new String[]{"Democracy", "Freedom"});
        String text = "democracy - the power of the people.";

        boolean isLegal = censor.isLegal(text);

        assertFalse(isLegal);
    }

    @Test
    public void isLegal_returns_true() {
        Censor censor = new Censor(new String[]{"Democracy", "Freedom"});
        String text = "monarchy - the best system of government.";

        boolean isLegal = censor.isLegal(text);

        assertTrue(isLegal);
    }
}