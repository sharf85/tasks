package com.telran;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class LovelyNumbers {
    public boolean isLovely(long number) {
        return String.valueOf(number).chars()
                .boxed()
                .collect(groupingBy(digit -> digit, counting()))
                .values()
                .stream()
                .allMatch(occurrence -> occurrence <= 2);
    }
//    public boolean isLovely(long number) {
//        Map<Character, Integer> occurrenceByDigit = new HashMap<>();
//        char[] digits = String.valueOf(number).toCharArray();
//
//        for (char digit : digits) {
//            occurrenceByDigit.computeIfPresent(digit, (key, oldValue) -> oldValue + 1);
//            occurrenceByDigit.putIfAbsent(digit, 1);
//            if (occurrenceByDigit.get(digit) > 2)
//                return false;
//        }
//
//        return true;
//    }
}
