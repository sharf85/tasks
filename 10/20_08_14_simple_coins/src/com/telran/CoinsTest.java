package com.telran;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoinsTest {

    Coins coins = new Coins();

    @Test
    public void testGetMinNumbersOfCoins_sum0_coins0() {
        assertEquals(0, coins.exchange(0));
    }

    @Test
    public void testGetMinNumbersOfCoins_sum1_coins1() {
        assertEquals(1, coins.exchange(1));
    }

    @Test
    public void testGetMinNumbersOfCoins_sum2_coins2() {
        assertEquals(2, coins.exchange(2));
    }

    @Test
    public void testGetMinNumbersOfCoins_sum3_coins3() {
        assertEquals(3, coins.exchange(3));
    }

    @Test
    public void testGetMinNumbersOfCoins_sum4_coins4() {
        assertEquals(4, coins.exchange(4));
    }

    @Test
    public void testGetMinNumbersOfCoins_sum5_coins1() {
        assertEquals(1, coins.exchange(5));
    }

    @Test
    public void testGetMinNumbersOfCoins_sum7_coins3() {
        assertEquals(3, coins.exchange(7));
    }

    @Test
    public void testGetMinNumbersOfCoins_sum10_coins1() {
        assertEquals(1, coins.exchange(10));
    }

    @Test
    public void testGetMinNumbersOfCoins_sum11_coins2() {
        assertEquals(2, coins.exchange(11));
    }

    @Test
    public void testGetMinNumbersOfCoins_sum27_coins1() {
        assertEquals(5, coins.exchange(27));
    }

}
