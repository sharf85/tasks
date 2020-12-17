package de.telran.generator.rule;

import de.telran.generator.RandomRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ListRandomRule implements RandomRule {

    List<Integer> values;
    Random random = new Random();

    public ListRandomRule(List<Integer> numbers) {
        values = new ArrayList<>(numbers);
    }

    public ListRandomRule(int[] numbers) {
        values = new ArrayList<>();
        for (int number : numbers) {
            values.add(number);
        }
    }

    @Override
    public int nextInt() {
        return values.get(random.nextInt(values.size()));
    }
}
