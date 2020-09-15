package com.telran;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class UniqueUsersCollector implements Collector<LogEntry, Set<String>, Integer> {
    @Override
    public Supplier<Set<String>> supplier() {
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<String>, LogEntry> accumulator() {
        return (userSet, log) -> userSet.add(log.getUsername());
    }

    @Override
    public BinaryOperator<Set<String>> combiner() {
        return (userSet1, userSet2) -> {
            userSet1.addAll(userSet2);
            return userSet1;
        };
    }

    @Override
    public Function<Set<String>, Integer> finisher() {
        return Set::size;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }
}
