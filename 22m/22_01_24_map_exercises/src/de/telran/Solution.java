package de.telran;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * The method must return an element from the list, which appears at most.
     * Only one element satisfies this requirement.
     *
     * @param numbers a list of numbers
     * @return the most occurred element in the list
     * {1, 5, -10, 1} -> 1
     * {1, 5, -10} -> ?
     */
    public int solve(List<Integer> numbers) {

        // переменная будет хранить числа из листа в качестве ключей и количество раз, сколько каждое число встречается
        // в листе, в качестве значений.
        Map<Integer, Integer> qtyByNumber = new HashMap<>();

        for (int number : numbers) {
            if (qtyByNumber.containsKey(number)) {
                int oldValue = qtyByNumber.get(number);
                qtyByNumber.put(number, oldValue + 1);
            } else {
                qtyByNumber.put(number, 1);
            }
        }

        Iterator<Integer> keyIterator = qtyByNumber.keySet().iterator();

        int res = keyIterator.next();
        int maxOccurrence = qtyByNumber.get(res);

        while (keyIterator.hasNext()) {
            int currentNumber = keyIterator.next();
            if (maxOccurrence < qtyByNumber.get(currentNumber)) {
                maxOccurrence = qtyByNumber.get(currentNumber);
                res = currentNumber;
            }
        }

        return res;

    }
}
