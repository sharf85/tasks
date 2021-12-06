package de.telran.random_rule;

import de.telran.random_rule.IRandomRule;

import java.util.Random;

public class MaxRandomRule implements IRandomRule {

    private final int max;
    private final Random rnd = new Random();

    public MaxRandomRule(int max) {
        this.max = max;
    }

    @Override
    public int nextInt() {
        return rnd.nextInt(max);
    }
}
