package com.telran.random;

import java.util.Random;

public class MaxRule implements RandomRule {

    private int max;

    private Random random = new Random();

    public MaxRule(int max) {
        this.max = max;
    }

    public int nextInt() {
        if (max < 0)
            return random.nextInt(max - Integer.MIN_VALUE) + Integer.MIN_VALUE;
        else
            return random.nextInt(Integer.MAX_VALUE) - Integer.MAX_VALUE - 1 + random.nextInt(max);
    }
}
