package com.telran;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoinsTest {

    @Test
    public void testExchangeQty() {
        Coins coins = new Coins();
        assertEquals(6, coins.exchangeQty(28));
        assertEquals(19, coins.exchangeQty(149));
    }
}