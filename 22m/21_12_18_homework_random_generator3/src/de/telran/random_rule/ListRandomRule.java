package de.telran.random_rule;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//TODO an object of the class must receive a list of integers through the constructor while created.
// The method nextInt() must pick a number from this list randomly.
public class ListRandomRule implements IRandomRule {

    private final List<Integer> numbers;
    private final Random rnd = new Random();

    public ListRandomRule(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    @Override
    //{10, 15, 90, -8} -> or 10, 15, 90, -8
    public int nextInt() {
        int index = rnd.nextInt(numbers.size());
        return numbers.get(index);
    }
}

