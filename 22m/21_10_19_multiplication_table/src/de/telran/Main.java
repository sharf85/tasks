package de.telran;

public class Main {

    public static void main(String[] args) {
        // вывести на экран таблицу умножения (использовать while внутри while)

        int mul1 = 1;
        while (mul1 < 10) {
            int mul2 = 1;
            while (mul2 < 10) {
                System.out.print(mul1 * mul2 + "\t");
                mul2++;
            }
            System.out.println();
            mul1++;
        }

    }
}
