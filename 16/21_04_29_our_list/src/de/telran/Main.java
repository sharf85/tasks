package de.telran;

import java.util.Comparator;
import java.util.Iterator;

public class Main {
    public static void main(String... args) {
        OurList<String> list = new OurArrayList<>();

        try {
            list.get(-1);
        } catch (IndexOutOfBoundsException e) {
//            System.out.println(e.getMessage());
        }

        list.add("hello");
        list.add("world");
        list.add("!");

//        System.out.println(list.contains(new String("hello")));

        // this is possible since the list is an object implementing Iterable
        for (String line : list) {
            System.out.println(line);
        }

        // another way to iterate over our list is
        Iterator<String> listIterator = list.iterator();
        while (listIterator.hasNext()) {
            String currentElt = listIterator.next();
            System.out.println(currentElt);
        }

        // how to use comparators
        OurList<Integer> numbers = new OurArrayList<>();
        numbers.add(-16);
        numbers.add(-25);
        numbers.add(7);
        numbers.add(0);

        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        Comparator<Integer> intComparator = new IntegerNaturalComparator();
        numbers.sort(intComparator);

        // after the previous line we should see the numbers from our list in a sorted order while iterating
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        Iterator<Integer> backwardIterator = numbers.backwardIterator();
        while (backwardIterator.hasNext()) {
            System.out.println(backwardIterator.next());
        }
    }
}

