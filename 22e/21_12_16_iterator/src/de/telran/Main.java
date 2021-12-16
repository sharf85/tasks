package de.telran;

import java.util.Iterator;

//TODO
// 1. Написать итератор, который перебирает целочисленный массив справа налево.
// 2. Написать итератор, который перебирает массив в порядке возрастания
// (помнить о том, что массив должен остаться неизменным после перебора).
// Для сортировки массива можно воспользоваться Arrays.sort()

public class Main {

    public static void main(String[] args) {
        int[] array = {10, 7, 17, 25};//to iterate

        // any iterator must not change the collection it iterates
        Iterator<Integer> iterator = new IntArrayStraightIterator(array);

        //how to use iterators
        while (iterator.hasNext()) {
            int currentElement = iterator.next();
            System.out.println(currentElement);
        }
    }
}
