package com.telran.random;

public class RandomGenerator {

    public RandomGenerator(RandomRule rule) {
        this.rule = rule;
    }

    private RandomRule rule;

    public int[] nextN(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = rule.nextInt();
        }
        return res;
    }
}
