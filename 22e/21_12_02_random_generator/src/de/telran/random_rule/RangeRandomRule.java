package de.telran.random_rule;

import java.util.Random;

//TODO the class should have a constructor, which receives two positive numbers and the method nextInt must return
// only random numbers between the first one inclusive and the second one exclusive
public class RangeRandomRule implements IRandomRule {

    private final int min;
    private final int max;
    private final Random rnd = new Random();

    public RangeRandomRule(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int nextInt() {
        int diff = max - min;
        int randomInt = rnd.nextInt(diff);// 0 -> diff - 1

        return min + randomInt;// min -> max - 1
    }
}
