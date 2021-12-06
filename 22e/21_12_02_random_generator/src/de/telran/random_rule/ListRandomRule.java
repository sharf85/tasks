package de.telran.random_rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListRandomRule implements IRandomRule {

    private final List<Integer> numbers;
    private final Random rnd = new Random();

    public ListRandomRule(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    @Override
    public int nextInt() {
        int index = rnd.nextInt(numbers.size());
        return numbers.get(index);
    }
}
