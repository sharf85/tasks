package de.telran;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class PredicateService {

    /**
     * @param predicates a list of predicates
     * @param <T>        type of predicates
     * @return the union of the list. If no items in the list, return false
     */
    public <T> Predicate<T> union(List<Predicate<T>> predicates) {
        Predicate<T> res = (t) -> false;
        for (Predicate<T> predicate : predicates) {
            res = res.or(predicate);
        }
        return res;
    }

    /**
     * @param predicates a list of predicates
     * @param <T>        type of predicates
     * @return the intersection of the list of predicates
     * @throws IllegalArgumentException if no items in the list
     */
    public <T> Predicate<T> intersect(List<Predicate<T>> predicates) {
        if (predicates.size() == 0)
            throw new IllegalArgumentException();

        Iterator<Predicate<T>> iterator = predicates.iterator();
        Predicate<T> res = iterator.next();
        while (iterator.hasNext()) {
            res = res.and(iterator.next());
        }
        return res;
    }
}
