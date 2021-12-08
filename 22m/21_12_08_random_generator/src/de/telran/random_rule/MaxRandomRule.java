package de.telran.random_rule;

import java.util.Random;

public class MaxRandomRule implements IRandomRule{

    private final int max;

    public MaxRandomRule(int max) {
        this.max = max;
    }

    @Override
    public int nextInt() {
        Random rnd = new Random();
        return rnd.nextInt(max);//generates random numbers from 0 inclusive to max exclusive
    }
}
