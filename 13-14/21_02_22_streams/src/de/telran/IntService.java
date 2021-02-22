package de.telran;

import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

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
//        Predicate<Integer> dividedBy3 = x -> x % 3 == 0;
//        Predicate<Integer> dividedBy5 = x -> x % 5 == 0;
//        Predicate<Integer> dividedBy5And3 = dividedBy5.and(dividedBy3);

        return IntStream.concat(stream1, stream2)
                .filter(dividedBy5And3)
                .sorted()
                .skip(2);
    }
}
