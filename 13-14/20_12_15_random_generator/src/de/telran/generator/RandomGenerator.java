package de.telran.generator;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {

    private final RandomRule rule;

    public RandomGenerator(RandomRule rule) {
        this.rule = rule;
    }

    public List<Integer> nextInts(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(rule.nextInt());
        }
        return res;
    }
}
