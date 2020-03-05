package com.telran;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ExchangeTest {
    @Test
    public void testSplit_CanBeChanged_UseRepeatedCoinO() {
        List<Integer> coins = Arrays.asList(5, 4, 1);
        Exchange exchange = new Exchange(coins);
        int sum = 18;
        assertEquals(4, exchange.split(sum).size());
    }

    @Test
    public void testSplit_CanBeChanged_UseFirstCoinOnly() {
        List<Integer> coins = Arrays.asList(5, 4, 1);
        Exchange exchange = new Exchange(coins);
        int sum = 15;
        assertEquals(3, exchange.split(sum).size());
    }

    @Test
    public void testSplit_CanBeChanged_UseSecondCoinOnly() {
        List<Integer> coins = Arrays.asList(5, 4, 1);
        Exchange exchange = new Exchange(coins);
        int sum = 8;
        assertEquals(2, exchange.split(sum).size());
    }

    @Test
    public void testSplit_CanBeChanged_UseLastCoinOnly() {
        List<Integer> coins = Arrays.asList(5, 4, 1);
        Exchange exchange = new Exchange(coins);
        int sum = 3;
        assertEquals(3, exchange.split(sum).size());
    }

    @Test
    public void testSplit_CanBeChanged_UseFirstSecondCoin() {
        List<Integer> coins = Arrays.asList(5, 4, 1);
        Exchange exchange = new Exchange(coins);
        int sum = 13;
        assertEquals(3, exchange.split(sum).size());
    }

    @Test
    public void testSplit_CanBeChanged_UseFirstLastCoin() {
        List<Integer> coins = Arrays.asList(5, 4, 1);
        Exchange exchange = new Exchange(coins);
        int sum = 7;
        assertEquals(3, exchange.split(sum).size());
    }

    @Test
    public void testSplit_CanBeChanged_UseSecondLastCoin() {
        List<Integer> coins = Arrays.asList(5, 2, 1);
        Exchange exchange = new Exchange(coins);
        int sum = 3;
        assertEquals(2, exchange.split(sum).size());
    }

    @Test
    public void testSplit_CanBeChanged_UseAllCoins() {

        List<Integer> coins = Arrays.asList(5, 2, 1);
        Exchange exchange = new Exchange(coins);
        int sum = 8;
        assertEquals(3, exchange.split(sum).size());
    }

    @Test
    public void testSplit_CantBeChanged_Zero() {
        List<Integer> coins = Arrays.asList(8, 6, 3);
        Exchange exchange = new Exchange(coins);
        int sum = 10;
        assertEquals(0, exchange.split(sum).size());
    }
}