package com.telran;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class RepeatedNumbersFinder {
    public List<Integer> getRepeated(List<Integer> list) {
        HashSet<Integer> occurredNums = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();

        for (int num : list) {
            if (occurredNums.contains(num)) {
                res.add(num);
            } else {
                occurredNums.add(num);
            }
        }

        return new ArrayList<>(res);
    }
}
