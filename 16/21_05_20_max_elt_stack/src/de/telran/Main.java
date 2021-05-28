package de.telran;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        TreeSet<Integer> integers = new TreeSet<>();

        Comparator<Integer> reversedIntComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        TreeSet<Integer> integers2 = new TreeSet<>(reversedIntComparator);

        IMaxElementStack<Integer> maxElementStack = new NaiveMaxElementStack<>();
    }
}
