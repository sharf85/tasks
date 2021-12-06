package de.telran;

import de.telran.random_rule.IRandomRule;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {

    private final IRandomRule randomRule;

    public RandomGenerator(IRandomRule randomRule) {
        this.randomRule = randomRule;
    }

    public List<Integer> generateNumbers(int number) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            int randomNumber = randomRule.nextInt();
            res.add(randomNumber);
        }

        return res;
    }
}
