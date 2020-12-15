package de.telran.generator.rule;

import de.telran.generator.RandomRule;

import java.util.Random;

public class RangeRandomRule implements RandomRule {

    private int max;
    private Random random = new Random();

    public RangeRandomRule(int max) {
        this.max = max;
    }

    @Override
    public int nextInt() {
        return random.nextInt(max);
    }
}
