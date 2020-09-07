package com.telran;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Algebra {

    /**
     * Determines whether the number is prime.
     *
     * @param p int number, p >= 2
     * @return true if the number is prime.
     */
    public boolean isPrime(int p) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(p))
                .noneMatch(num -> p % num == 0);
    }


    /**
     * @param n > 0
     * @return multiplication af all the numbers from 1 to n
     */
    public long factorial(int n) {
        return LongStream.rangeClosed(2, n)
                .reduce(1, (res, currentNum) -> res * currentNum);
    }

    /**
     * a is less or equals to b.
     *
     * @param a int number
     * @param b int number
     * @return sum of all the odd numbers from a to b. If there is no odd numbers in
     * the interval, then return 0
     */
    public int sumOds(int a, int b) {
        return IntStream.rangeClosed(a, b)
                .filter(value -> value % 2 == 1)
                .sum();
    }
}
