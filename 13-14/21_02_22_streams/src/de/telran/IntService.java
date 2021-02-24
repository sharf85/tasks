package de.telran;

import java.util.NoSuchElementException;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class IntService {

    /**
     * the method determines whether the number is prime
     *
     * @param number must be greater than zero
     * @return true if the number is prime, false otherwise
     */
    public boolean isPrime(int number) {
        if (number == 1)
            return false;
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(divisor -> number % divisor == 0);
    }

    public IntStream compose(IntStream stream1, IntStream stream2) {
        IntPredicate dividedBy3 = x -> x % 3 == 0;
        IntPredicate dividedBy5 = x -> x % 5 == 0;
        IntPredicate dividedBy5And3 = dividedBy5.and(dividedBy3);

        return IntStream.concat(stream1, stream2)
                .filter(dividedBy5And3)
                .sorted()
                .skip(2);
    }

    public long factorial(int n) {
        return LongStream.rangeClosed(1, n)
                .reduce(1, (currResult, currentNum) -> currResult * currentNum);
    }

    /**
     * finds sum of odd numbers between the two.
     *
     * @param a
     * @param b
     * @return
     * @throws java.util.NoSuchElementException if no odd numbers found between a and b, or a > b
     */
    public long sumOddNumbersBetween(int a, int b) {
        return LongStream.rangeClosed(a, b)
                .filter(num -> num % 2 == 1)
                .reduce((res, num) -> res + num)
                .orElseThrow(() -> new NoSuchElementException());
    }
}
