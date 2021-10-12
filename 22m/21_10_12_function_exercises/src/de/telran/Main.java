package de.telran;

public class Main {

    public static void main(String[] args) {
        System.out.println(getSquare(1));//1
        System.out.println(getSquare(3));//9
        System.out.println(getSquare(13));//169
        System.out.println(getSquare(14));//196

        System.out.println(getCube(2));//8
        System.out.println(getCube(3));//27
        System.out.println(getCube(5));//125
        System.out.println(getCube(10));//1000
    }

    static int getSquare(int number) {
        return number * number;
    }

    static int getCube(int number) {
        return getSquare(number) * number;
    }
}
