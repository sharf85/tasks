package de.telran.function;

public class UniqNumbersPredicate implements TernaryIntPredicate {
    @Override
    public boolean test(int a, int b, int c) {
        return a != b && b != c && a != c;
    }
}
