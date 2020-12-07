package de.telran;


import java.util.Arrays;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        int[] array = {10, -8, 0, 15};

        Iterator<Integer> simpleArrayIterator = new SimpleArrayIterator(array);
        Iterator<Integer> backwardArrayIterator = new BackwardArrayIterator(array);
        Iterator<Integer> increasingArrayIterator = new IncreasingArrayIterator(array);

        iterate(simpleArrayIterator);
        iterate(backwardArrayIterator);
        iterate(increasingArrayIterator);

        System.out.println(Arrays.toString(array));
    }

    static void iterate(Iterator<Integer> iterator) {
        while (iterator.hasNext()) {
            int current = iterator.next();
            System.out.print(current + " ");
        }
        System.out.println();
    }
}
