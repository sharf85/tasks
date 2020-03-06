package com.telran;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class DistinctCountingCollector implements Collector<LogEntry, HashSet<String>, Integer> {
    @Override
    public Supplier<HashSet<String>> supplier() {
        return () -> new HashSet<>();
    }

    @Override
    public BiConsumer<HashSet<String>, LogEntry> accumulator() {
        return (innerCollection, logEntry) -> innerCollection.add(logEntry.getUsername());
    }

    @Override
    public BinaryOperator<HashSet<String>> combiner() {
        return (ic1, ic2) -> {
            ic1.addAll(ic2);
            return ic1;
        };
    }

    @Override
    public Function<HashSet<String>, Integer> finisher() {
        return innerCollection -> innerCollection.size();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return EnumSet.of(Characteristics.CONCURRENT);
    }
}
