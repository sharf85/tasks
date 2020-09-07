package com.telran.predicate;

public class DifferentNumbersPredicate implements TernaryIntPredicate {
    @Override
    public boolean test(int a, int b, int c) {
        return a != b && b != c && c != a;
    }
}
