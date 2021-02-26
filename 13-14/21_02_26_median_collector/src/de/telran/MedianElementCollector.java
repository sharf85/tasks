package de.telran;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MedianElementCollector implements Collector<Integer, List<Integer>, Double> {
    @Override
    public Supplier<List<Integer>> supplier() {
        return () -> new ArrayList<>();
    }

    @Override
    public BiConsumer<List<Integer>, Integer> accumulator() {
        return (temporaryList, number) -> temporaryList.add(number);
    }

    @Override
    public BinaryOperator<List<Integer>> combiner() {
        return (currentRes, currentList) -> {
            currentRes.addAll(currentList);
            return currentRes;
        };
    }

    @Override
    public Function<List<Integer>, Double> finisher() {
        return numbers -> {
            Collections.sort(numbers);

            int size = numbers.size();
            if (size % 2 == 1) {
                return (double) numbers.get(size / 2);
            } else {
                int rightIndex = size / 2;
                int left = numbers.get(rightIndex - 1);
                int right = numbers.get(rightIndex);
                return ((double) left + right) / 2;
            }
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(Set.of(Collector.Characteristics.CONCURRENT));
    }
}
