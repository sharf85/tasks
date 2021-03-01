package de.telran.collector;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class RootMeanSquaringCollector implements Collector<Double, List<Double>, Double> {

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
        return (combinedNumbers, numbers) -> {
            combinedNumbers.addAll(numbers);
            return combinedNumbers;
        };
    }

    @Override
    public Function<List<Double>, Double> finisher() {
        return numbers -> {
            if (numbers.size() == 0)
                throw new NoSuchElementException();

            double sum = numbers.stream()
                    .reduce(0., (currentRes, currentNum) -> currentRes + currentNum * currentNum);

            return Math.sqrt(sum / numbers.size());
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }
}
