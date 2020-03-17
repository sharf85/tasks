package com.telran;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LovelyNumbers {

    public List<Integer> getAllLovelyNumbersFromRange(int A, int B) {
        return IntStream.rangeClosed(A, B)
                .filter(this::isLovely)
                .boxed()
                .collect(Collectors.toList());
    }

    private boolean isLovely(int num) {
//        String.valueOf(num)...
        return false;
    }
}
