package de.telran;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NormalizingCollector implements Collector<Double, List<Double>, List<Double>> {
    @Override
    public Supplier<List<Double>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Double>, Double> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<Double>> combiner() {
        return (list1, list2) -> {
            list2.addAll(list1);
            return list2;
        };
    }

    @Override
    public Function<List<Double>, List<Double>> finisher() {
        return (numbers) -> {
            double max = Collections.max(numbers);
            double min = Collections.min(numbers);
            double divisor = max - min;

            return numbers.stream()
                    .map(number -> (number - min) / divisor)
                    .collect(Collectors.toList());
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
