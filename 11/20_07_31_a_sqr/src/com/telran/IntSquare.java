package com.telran;

public class IntSquare {

    /**
     * The function computes the sqr of a number greater than 0
     *
     * @param n square to compute
     * @return square of input number
     */
    public int compute(int n) {
        if (n == 1)
            return 1;

        return compute(n - 1) + n + n - 1;
    }
}
