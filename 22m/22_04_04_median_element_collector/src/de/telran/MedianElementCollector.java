package de.telran;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MedianElementCollector implements Collector<Integer, List<Integer>, Double> {
    @Override
    public Supplier<List<Integer>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Integer>, Integer> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<Integer>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<Integer>, Double> finisher() {
        return (numbers) -> {
            Collections.sort(numbers);
            int size = numbers.size();
            if (size % 2 == 0) {
                int left = numbers.get(size / 2 - 1);
                int right = numbers.get(size / 2);
                return ((double) left + right) / 2;
            } else {
                return (double) numbers.get(size / 2);
            }
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(Set.of(Collector.Characteristics.CONCURRENT));
    }
}
