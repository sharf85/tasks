package de.telran;

public class Main {

    public static void main(String[] args) {
        float a = 10.5f;
        float anotherFloat = a + 15.5f;

        double b = 8.5;

        double c = a + b;//19.0

        c = c % 2.5;//1.5

        b = b / 3;
        System.out.println(c);

        double doubleNumber = 15.7;
        int intNumber = 5;
        double anotherDouble = doubleNumber / intNumber;
        System.out.println(anotherDouble);

        int wholePart = (int) anotherDouble;
        double d = intNumber;
        System.out.println(wholePart);
    }
}
