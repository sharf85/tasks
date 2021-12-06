package de.telran;

import de.telran.random_rule.IRandomRule;
import de.telran.random_rule.ListRandomRule;
import de.telran.random_rule.MaxRandomRule;
import de.telran.random_rule.RangeRandomRule;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int a = random.nextInt();


        // max random generator
        IRandomRule rangeRandomRule = new MaxRandomRule(3);
        RandomGenerator rangeGenerator = new RandomGenerator(rangeRandomRule);

        List<Integer> randomNumbers = rangeGenerator.generateNumbers(20);
        System.out.println(randomNumbers.toString());

        // list random generator
        Integer[] numbers = {10, 8, 15};
        List<Integer> numberList = Arrays.asList(numbers);
        IRandomRule listRandomRule = new ListRandomRule(numberList);
        RandomGenerator listRandomGenerator = new RandomGenerator(listRandomRule);

        randomNumbers = listRandomGenerator.generateNumbers(20);
        System.out.println(randomNumbers.toString());
    }
}
