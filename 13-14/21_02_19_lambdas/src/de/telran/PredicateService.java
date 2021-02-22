package de.telran;

import java.util.List;
import java.util.function.Predicate;

public class PredicateService {

    /**
     * @param predicates
     * @return true if no predicates in the list or their intersection
     */
    public Predicate<Double> intersect(List<Predicate<Double>> predicates) {
        Predicate<Double> res = (Double x) -> true;

        for (Predicate<Double> predicate : predicates) {
            res = res.and(predicate);// pred1 & pred2 & ... & predN
        }

        return res;
    }
}
