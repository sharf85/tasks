package com.telran;

public class Variables {

    public static void main(String[] args) {
        byte a, e, f = 9;
        a = 0;
        byte c = 6;

        byte b = 10;

        e = a;
        System.out.println("" + a + " " + b);
        System.out.println(-10 % 3);

        int applesPetr = 2;
        int applesMaria = 3;

        int allApples = applesPetr + applesMaria;
        System.out.println(allApples);

// task about apples
        /* sdfsdgf */
        byte applesPetrByte = 20;
        byte applesMariaByte = 3;

        byte allApplesByte = (byte) (applesPetr % applesMaria);
        System.out.println(allApples);

        int increment = 8;
        increment++;
        ++increment;

        System.out.println(increment);
        System.out.println(++increment);//11
        System.out.println(increment++);//11
        System.out.println(increment);//12
    }

}
