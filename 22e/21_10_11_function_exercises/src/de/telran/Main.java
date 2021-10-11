package de.telran;

public class Main {

    public static void main(String[] args) {
        System.out.println(square(1));//1
        System.out.println(square(2));//4
        System.out.println(square(3));//9
        System.out.println(square(13));//169
        System.out.println(square(12));//144

        System.out.println(cube(1));//1
        System.out.println(cube(2));//4
        System.out.println(cube(3));//9
        System.out.println(cube(13));//169
        System.out.println(cube(12));//144
    }

    static int square(int number) {
        return number * number;
    }

    static int cube(int number) {
        return number * number * number;
    }
}
