package de.telran.random_rule;

import java.util.List;

//TODO an object of the class must receive a list of integers through the constructor while created.
// The method nextInt() must pick a number from this list randomly.
public class ListRandomRule implements IRandomRule{

    public ListRandomRule(List<Integer> numbers){

    }

    @Override
    //{10, 15, 90, -8} -> or 10, 15, 90, -8
    public int nextInt() {
        return 0;
    }
}

