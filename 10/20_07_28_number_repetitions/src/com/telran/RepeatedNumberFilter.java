package com.telran;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedNumberFilter {
    public List<Integer> remainRepeated(List<Integer> numbers) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> appeared = new HashSet<>();

        for (int num : numbers) {
            if (appeared.contains(num)) {
                res.add(num);
            } else {
                appeared.add(num);
            }
        }

        return new ArrayList<>(res);
    }
}
