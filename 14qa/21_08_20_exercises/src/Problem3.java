public class Problem3 {
    /**
     * The method accepts two positive int numbers and returns their GCD
     *
     * @param a positive
     * @param b positive
     * @return
     */
    public int gcd(int a, int b) {
        int min = Math.min(a, b);

        for (int i = min; i > 1; i--) {
            if (a % i == 0 && b % i == 0)
                return i;
        }

        return 1;
    }
}
