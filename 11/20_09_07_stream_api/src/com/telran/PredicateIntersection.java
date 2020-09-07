package com.telran;

import java.util.List;
import java.util.function.Predicate;

public class PredicateIntersection {

    public <T> Predicate<T> intersect(List<Predicate<T>> predicates) {
        Predicate<T> res = (x) -> true;

        for (Predicate<T> predicate : predicates) {
            res = res.and(predicate);
        }

        return res;
    }

    public <T> Predicate<T> intersect2(List<Predicate<T>> predicates) {
        Predicate<T> init = (x) -> true;
        return predicates.stream()
                .reduce(init, (res, currentPredicate) -> res.and(currentPredicate));
    }
}
