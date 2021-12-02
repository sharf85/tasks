package de.telran;

import de.telran.random_rule.IRandomRule;

import java.util.List;

public class RandomGenerator {

    private final IRandomRule randomRule;

    public RandomGenerator(IRandomRule randomRule) {
        this.randomRule = randomRule;
    }

    public List<Integer> generateNumbers(int number) {
        //TODO compose a list of "number" random numbers using "randomRule" and return
    }
}
