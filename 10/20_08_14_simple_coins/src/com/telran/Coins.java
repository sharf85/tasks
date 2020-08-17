package com.telran;

public class Coins {

    public int exchange(int N) {
        int res = N / 10;
        N %= 10;
        res += N / 5;
        N %= 5;
        res += N;
        return res;
    }
}
