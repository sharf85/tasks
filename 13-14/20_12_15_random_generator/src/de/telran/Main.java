package de.telran;

import de.telran.generator.RandomGenerator;
import de.telran.generator.RandomRule;
import de.telran.generator.rule.ListRandomRule;
import de.telran.generator.rule.RangeRandomRule;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers = {5, -10, 7};

        //list random rule
        RandomRule rule = new ListRandomRule(numbers);
        RandomGenerator generator = new RandomGenerator(rule);
        System.out.println(generator.nextInts(10));

        //range random rule
        generator = new RandomGenerator(new RangeRandomRule(3));
        System.out.println(generator.nextInts(10));
    }
}
