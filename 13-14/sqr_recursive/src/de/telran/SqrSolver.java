package de.telran;

public class SqrSolver {

    /**
     * The method accepts only positive int numbers.
     *
     * @param n the sqr of which should be found
     * @return n * n
     */
    public int sqr(int n) {
        if (n == 1)
            return 1;
        return sqr(n - 1) + n + n - 1;
    }
}
