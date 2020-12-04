package de.telran;


import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        int[] array = {10, -8, 0, 15};

        Iterator<Integer> simpleArrayIterator = new SimpleArrayIterator(array);

        while (simpleArrayIterator.hasNext()) {
            int current = simpleArrayIterator.next();
            System.out.println(current);
        }

    }
}
