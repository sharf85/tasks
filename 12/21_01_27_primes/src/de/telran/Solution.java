package de.telran;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    /**
     * @param upperBound must be 2 or greater
     * @return
     */
    public List<Integer> getPrimes(int upperBound) {
        return IntStream.rangeClosed(2, upperBound)
                .filter(this::isPrime)
                .boxed()
                .collect(Collectors.toList());

//        List<Integer> primes = new ArrayList<>();
//        for (int i = 2; i <= upperBound; i++) {
//            if (isPrime(i))
//                primes.add(i);
//        }
//
//        return primes;
    }


    // number = a * b


    boolean isPrime(int number) {
        int sqrt = (int) Math.sqrt(number);
//        for (int i = 2; i <= sqrt; i++) {
//            if (number % i == 0)
//                return false;
//        }
//        return true;

        return IntStream.rangeClosed(2, sqrt)
                .noneMatch(value -> number % value == 0);
    }
}
