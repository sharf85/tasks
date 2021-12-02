package de.telran;

import de.telran.random_rule.IRandomRule;
import de.telran.random_rule.MaxRandomRule;
import de.telran.random_rule.RangeRandomRule;

import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt();


        IRandomRule rangeRandomRule = new MaxRandomRule(10);
        RandomGenerator generator = new RandomGenerator(rangeRandomRule);

        List<Integer> randomNumbers = generator.generateNumbers(100);
    }
}
