package de.telran;

public class Main {

    public static void main(String[] strs) {

        int something;
        something = sum(10, 15);
        System.out.println(something);

        int another = sum(100, -200);

        // Vasya and Masha apples
        final int mashaApplesNumber = 3;
        final int vasyaApplesNumber = 2;
        final int applesInTotal = mashaApplesNumber + vasyaApplesNumber;
        System.out.println(applesInTotal);
    }

    static int sum(int x, int y) {
        int result = x + y;
        int anotherResult = x - y;
        int vasya = 10;
        return result;
    }
}
