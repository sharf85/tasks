package de.telran;

import java.util.*;

public class NumbersService {

    /**
     * The method finds the number in the 'numbers' which is the most repeatable number.
     *
     * @param numbers a list of number. If the list is null, the behavior is undefined
     * @return the most repeatable number. If there are several numbers which satisfy
     * the requirement, the method should return any of these.
     * @throws java.util.NoSuchElementException will be thrown if the list is empty
     */
    public int getNumberOfMaxOccurrence(List<Integer> numbers) {
        if (numbers.isEmpty())
            throw new NoSuchElementException();

        Map<Integer, Integer> qtyByNumber = new HashMap<>();
        for (int number : numbers) {
            int newQty = qtyByNumber.getOrDefault(number, 0) + 1;
            qtyByNumber.put(number, newQty);
        }

        int result = 0;
        int max = 0;

        for (int key : qtyByNumber.keySet()) {
            int qty = qtyByNumber.get(key);
            if (qty > max) {
                max = qty;
                result = key;
            }
        }

        return result;
    }

    public boolean isPrime(int number) {
        if (number < 2)
            return false;

        int sqrt = (int) Math.sqrt(number);
        for (int i = 2; i <= sqrt; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

    /**
     * The method finds all primes up to n
     *
     * @param n must be greater than zero.
     * @return list of all primes non greater than the n
     */
    public List<Integer> getAllPrimesTo(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (isPrime(i))
                res.add(i);
        }
        return res;
    }

    public int getMaxCoveredNumbers(List<Integer> numbers, int l) {
        int res = 0;
        for (int currentNumber : numbers) {
            // we want to compute how many numbers are covered by the cut of length 'l' with the 'currentNumber'
            // as the left end of the cut.
            int coveredPoints = 0;
            int leftEnd = currentNumber;
            int rightEnd = currentNumber + l;

            for (int number : numbers) {
                if (leftEnd <= number && number <= rightEnd) {
                    coveredPoints++;
                }
            }

            if (coveredPoints > res)
                res = coveredPoints;
        }
        return res;
    }
}
