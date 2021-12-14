public class Problems {

    /**
     * @param a > 0
     * @param b > 0
     * @return gcd of the two numbers
     */
    public int gcd(int a, int b) {
        int rest = a % b;//a if a < b
        if (rest == 0)
            return b;

        return gcd(b, rest);
    }

    /**
     * @param a > 0
     * @param b > 0
     * @return lcm of the two numbers
     */
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    /**
     * @param n the number of the fibonacci number
     * @param m the number to divide on
     * @return
     */
    public int fibonacciModuloM(int n, int m) {
        if (n == 0)
            return n;

        int prev = 0;
        int current = 1;

        for (int i = 1; i < n; i++) {
            int temp = current;
            current = (current + prev) % m;
            prev = temp;
        }

        return current;
    }

}

