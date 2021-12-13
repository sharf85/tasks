package de.telran.random_rule;

import java.util.Random;

public class RangeRandomRule implements IRandomRule {

    private final int max;
    private final int min;
    private final Random rnd = new Random();

    public RangeRandomRule(int max, int min) {
        this.max = max;
        this.min = min;
    }


    @Override
    public int nextInt() {
        int diff = max - min;
        return rnd.nextInt(diff) + min;
    }
}
