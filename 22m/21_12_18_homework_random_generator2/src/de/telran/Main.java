package de.telran;

import de.telran.random_rule.IRandomRule;
import de.telran.random_rule.ListRandomRule;
import de.telran.random_rule.MaxRandomRule;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(10);
        numbers.add(15);

        IRandomRule listRandomRule = new ListRandomRule(numbers);
        RandomGenerator listGenerator = new RandomGenerator(listRandomRule);
        System.out.println(listGenerator.generate(10));
// comment
// test
        numbers.add(20);
        System.out.println(listGenerator.generate(10));

        IRandomRule maxRandomRule = new MaxRandomRule(10);
        RandomGenerator maxGenerator = new RandomGenerator(maxRandomRule);

        maxGenerator.generate(20);
    }
}
