package de.telran.random_rule;

import java.util.List;

//TODO the class should have a constructor, which receives a list of numbers and the method nextInt must return
// only the numbers from this list
public class ListRandomRule implements IRandomRule {

    public ListRandomRule(List<Integer> numbers) {

    }

    @Override
    public int nextInt() {
        return 0;
    }
}
