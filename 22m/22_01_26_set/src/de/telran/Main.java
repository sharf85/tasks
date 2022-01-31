package de.telran;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        Set<Integer> numbers2 = new HashSet<>();
        // numbers: {1, 7, -5, 10}; numbers2: {8, 10, 7, 15, 17}
        //в numbers будут лежать все эелементы из обоих множеств {1, 7, -5, 10, 8, 15, 17}
        numbers.addAll(numbers2);

        // в numbers будут лежать только те элементы, которые есть в numbers и которых нет в numbers2
        // {1, -5}
        numbers.removeAll(numbers2);

        // оставит в numbers только те элементы, которые существуют в обоих множествах {7, 10}
        numbers.retainAll(numbers2);

        // если тип дынных для TreeSet или TreeMap (ключи) является Comparable, то объект Компаратора при
        // инициализации этого TreeSet или TreeMap не обяхателен
        Set<Integer> numbers3 = new TreeSet<>();
        Set<String> numbers4 = new TreeSet<>();


        {
            "opel":[{"astra", 10000}, {"astra", 15000}, {"insignia", 10000}, {"insignia", 20000}],
            "vw": [...]
        }
    }
}
