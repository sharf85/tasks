package com.telran;

public class RandomGenerator {

    private RandomRule rule;

    public RandomGenerator(RandomRule rule) {
        this.rule = rule;
    }

    public int[] nextInts(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = rule.nextInt();
        }
        return res;
    }
}
