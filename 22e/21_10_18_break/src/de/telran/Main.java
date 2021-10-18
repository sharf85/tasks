package de.telran;

public class Main {

    public static void main(String[] args) {
        // print out the minimal number which is greater than A and divided by 11, 13 or 17
        printFirstNumberFromA1(14);
        printFirstNumberFromA2(14);
    }

    static void printFirstNumberFromA1(int a) {
        for (int i = a; i < a + 17; i++) {
            if (i % 11 == 0 || i % 13 == 0 || i % 17 == 0) {
                System.out.println(i);
                break;
            }
        }
    }

    static void printFirstNumberFromA2(int a) {
        int i = a;
        while (true) {
            if (i % 11 == 0 || i % 13 == 0 || i % 17 == 0) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }
}
