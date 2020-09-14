package com.telran;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MedianElementCollecting implements Collector<Integer, ArrayList<Integer>, Double> {
    @Override
    public Supplier<ArrayList<Integer>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<ArrayList<Integer>, Integer> accumulator() {
        return ArrayList::add;
    }

    @Override
    public BinaryOperator<ArrayList<Integer>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<ArrayList<Integer>, Double> finisher() {
        return list -> {
            list.sort(Integer::compareTo);

            int size = list.size();
            if (size % 2 == 1) {
                return (double) list.get(size / 2);
            } else {
                int id2 = size / 2;
                int id1 = id2 - 1;
                return ((double) list.get(id1) + list.get(id2)) / 2;
            }
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
