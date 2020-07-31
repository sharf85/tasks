package com.telran;

public class Gcd {

    /**
     * Finds the greatest common divisor for two int positive numbers
     *
     * @param a > 0
     * @param b > 0
     * @return gcd of the two
     */
    public int compute(int a, int b) {
        if (b == 0)
            return a;
        int d = a % b;
        return compute(b, d);
    }
}
