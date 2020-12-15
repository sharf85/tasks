package de.telran.generator;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {

    private RandomRule rule;

    public RandomGenerator(RandomRule rule) {
        this.rule = rule;
    }

    public List<Integer> nextInts(int n) {
        List<Integer> res = new ArrayList<>();
        //TODO call n times rule.nextInt() and place them into the res
        return res;
    }
}
