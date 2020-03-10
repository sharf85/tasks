package com.telran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MedianCollector implements Collector<Integer, ArrayList<Integer>, Double> {
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
        return (list) -> {
            Collections.sort(list);
            int size = list.size();
            if (size % 2 == 1) {
                return (double) list.get(size / 2);
            } else {
                return ((double) list.get(size / 2 - 1) + list.get(size / 2)) / 2;
            }
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }
}
