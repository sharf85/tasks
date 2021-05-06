package de.telran;

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

    }
}
