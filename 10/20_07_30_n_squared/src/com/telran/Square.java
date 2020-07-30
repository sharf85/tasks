package com.telran;

public class Square {

    public int sqr(int N) {
        if (N == 1)
            return 1;
        return sqr(N - 1) + N + N - 1;
    }
}
