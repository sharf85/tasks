package com.telran;

public class Coins {

    public int exchangeQty(int n) {
        int tens = n / 10;
        int fives = (n % 10) / 5;
        int ones = n % 5;
        return tens + fives + ones;
    }
}
