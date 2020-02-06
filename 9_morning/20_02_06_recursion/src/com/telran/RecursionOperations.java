package com.telran;

public class RecursionOperations {

    public int powerRecursion(int n, int k) {
        if (k == 0)
            return 1;

        return n * powerRecursion(n, k - 1);
    }

    public int squareRecursion(int n) {
        if (n == 0)
            return 0;

        return squareRecursion(n - 1) + n + n - 1;
    }
}
