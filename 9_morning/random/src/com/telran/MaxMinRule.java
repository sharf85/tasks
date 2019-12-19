package com.telran;

import java.util.Random;

public class MaxMinRule implements RandomRule {

    Random random = new Random();

    private int min;
    private int max;

    public MaxMinRule(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int nextInt() {
        return (int) (min + Math.abs(random.nextLong()) % ((long) max - (long) min));
    }
}
