package de.telran.random_rule;

import de.telran.random_rule.IRandomRule;

//TODO the class should have a constructor, which receives a positive number and the method nextInt must return
// only random numbers between 0 inclusive and max exclusive
public class MaxRandomRule implements IRandomRule {

    private final int max;

    public MaxRandomRule(int max) {
        this.max = max;
    }

    @Override
    public int nextInt() {
        return 0;
    }
}
