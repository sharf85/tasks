package de.telran;

public class Main {

    public static void main(String[] args) {
        int a = f(2);
        int number = f(3);
    }

    // n can be greater than 0
    static int f(int n) {
        if (n == 0)
            return 1;

        int res = 2 * f(n - 1);
        return res;
    }
}
