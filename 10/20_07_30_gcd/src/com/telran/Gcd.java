package com.telran;

public class Gcd {

    /**
     * The function evaluates GCD of two numbers
     *
     * @param a must be positive number
     * @param b must be positive number
     * @return greatest common divisor
     */
    public int countGcd(int a, int b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        int d = a % b;
        return countGcd(b, d);
    }
}
