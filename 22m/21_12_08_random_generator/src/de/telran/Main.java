package de.telran;

import de.telran.random_rule.IRandomRule;
import de.telran.random_rule.MaxRandomRule;

public class Main {

    public static void main(String[] args) {
//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(1);
//        numbers.add(10);
//        numbers.add(15);

        IRandomRule maxRandomRule = new MaxRandomRule(10);
        RandomGenerator maxGenerator = new RandomGenerator(maxRandomRule);

        maxGenerator.generate(20);
    }
}
