package de.telran;

public class Main {

    public static void main(String[] args) {
    }

    //сложить все нечетные числа от 1 до N
    static int sumOddsToN(int number) {
        int res = 0;
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0)
                continue;//go to the next iteration

            res += i;
        }
        return res;
    }
}
