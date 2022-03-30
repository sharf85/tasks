package de.telran;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Solution {

    public <T> Predicate<T> union(List<Predicate<T>> predicates) {
        Optional<Predicate<T>> optionalTPredicate = predicates.stream()
                .reduce(Predicate::or);

        Supplier<NoSuchElementException> supplierByDefault = NoSuchElementException::new;

        return optionalTPredicate.orElseThrow(supplierByDefault);
    }

    public <T> Predicate<T> intersect(List<Predicate<T>> predicates) {
        return predicates.stream()
                .reduce(Predicate::and)
                .orElseThrow(NoSuchElementException::new);
    }

    public List<String> check(String text, Set<String> badWords) {

        return Arrays.stream(text.split("[,.:;?! ]+"))
                .map(String::toLowerCase)
                .filter(badWords::contains)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }
}
